package services;

import java.util.List;

import models.Categoria;
import models.Pokemon;
import models.Tipo;

public interface PokemonService {

  public void insertNewPokemon(final Pokemon pokemon);

  public Pokemon updatePokemon(final Pokemon pokemon);

  public void deletePokemon(final Pokemon pokemon);

  public Pokemon searchById(final Long pokemonId);

  public Pokemon addCategoria(final Categoria categoria);

  public List<Pokemon> searchAll();

  public List<String> getPokemons(final Tipo tipo);

  public List<Pokemon> getAllPokemonsFromNameOrDescription(final String busqueda);
}
