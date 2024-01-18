package services;

import models.EstadisticasPokemon;
import models.Tipo;

import java.util.List;

public interface EstadisticasPokemonService {
  public void insertNewEstadisticasPokemon(final EstadisticasPokemon estadisticasPokemon);

  public EstadisticasPokemon updateEstadisticasPokemon(final EstadisticasPokemon estadisticasPokemon);

  public void deleteEstadisticasPokemon(final EstadisticasPokemon estadisticasPokemon);

  public EstadisticasPokemon searchById(final Long tipoId);

  public List<EstadisticasPokemon> searchAll();
}
