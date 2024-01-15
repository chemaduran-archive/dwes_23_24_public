package dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;
import dao.PokemonDAO;
import dao.generic.GenericDAOImpl;

import java.util.List;

public class PokemonDAOImpl extends GenericDAOImpl<Pokemon> implements PokemonDAO {
  private final Session session;

  public PokemonDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  // Búsqueda de todos los nombres de pokemon de un tipo determinado (con HQL)
  @Override
  public List<String> getPokemonsNamesFromTipo(final Tipo tipo) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    return session
            .createQuery("FROM Pokemon p JOIN PokemonTipo pt ON p.id, pt.idPokemon WHERE pt.idPokemon=:id_tipo")
            .setParameter("id_tipo", tipo.getId())
            .list();
  }

//  Búsqueda de todos los pokemons con un nombre o que contenga una descripción determinada (con Criteria)
  @Override
  public List<Pokemon> getAllPokemonsFromNameOrDescription(final String busqueda) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Pokemon> criteria = builder.createQuery(Pokemon.class);
    Root<Pokemon> root = criteria.from(Pokemon.class);

    Predicate pokemonNamePredicate = builder.equal(root.get("nombre"), busqueda);
    Predicate pokemonDescriptionPredicate = builder.equal(root.get("descripcion"), busqueda);
    Predicate orPredicate = builder.or(pokemonNamePredicate, pokemonDescriptionPredicate);

    criteria.select(root);
    criteria.where(orPredicate);

    return session.createQuery(criteria).getResultList();

  }
}
