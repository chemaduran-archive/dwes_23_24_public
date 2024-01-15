package services.impl;

import java.util.List;

import models.Categoria;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;

import services.PokemonService;
import dao.PokemonDAO;
import dao.impl.PokemonDAOImpl;

public class PokemonServiceImpl implements PokemonService {

  PokemonDAO pokemonDAO;

  public PokemonServiceImpl(Session session) {
    pokemonDAO = new PokemonDAOImpl(session);
  }

  @Override
  public void insertNewPokemon(Pokemon pokemon) {
    if (pokemon != null && pokemon.getId() == null) {
      pokemonDAO.insert(pokemon);
    }
  }

  @Override
  public Pokemon updatePokemon(Pokemon pokemon) {
    Pokemon pokemonUpdated = null;
    if (pokemon != null && pokemon.getId() != null) {
      pokemonUpdated = pokemonDAO.update(pokemon);
    }
    return pokemonUpdated;
  }

  @Override
  public void deletePokemon(Pokemon pokemon) {
    if (pokemon != null && pokemon.getId() != null) {
      pokemonDAO.delete(pokemon);
    }
  }

  @Override
  public Pokemon searchById(Long pokemonId) {
    if (pokemonId != null) {
      return pokemonDAO.searchById(pokemonId);
    }
    return null;
  }

  @Override
  public Pokemon addCategoria(Categoria categoria) {
    return null;
  }

  @Override
  public List<Pokemon> searchAll() {
    return pokemonDAO.searchAll();
  }

  @Override
  public List<String> getPokemons(final Tipo tipo) {
    return pokemonDAO.getPokemonsNamesFromTipo(tipo);
  }

  @Override
  public List<Pokemon> getAllPokemonsFromNameOrDescription(final String busqueda) {
    if (busqueda != null && !busqueda.isEmpty()) {
      return pokemonDAO.getAllPokemonsFromNameOrDescription(busqueda);
    }
    return null;
  }
}
