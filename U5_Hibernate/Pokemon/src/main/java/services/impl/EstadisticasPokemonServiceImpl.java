package services.impl;

import dao.EstadisticasPokemonDAO;
import dao.impl.EstadisticasPokemonDAOImpl;
import models.EstadisticasPokemon;
import org.hibernate.Session;
import services.EstadisticasPokemonService;

import java.util.List;

public class EstadisticasPokemonServiceImpl implements EstadisticasPokemonService {
  EstadisticasPokemonDAO estadisticasPokemonDAO;

  public EstadisticasPokemonServiceImpl(Session session) {
    estadisticasPokemonDAO = new EstadisticasPokemonDAOImpl(session);
  }

  @Override
  public void insertNewEstadisticasPokemon(EstadisticasPokemon estadisticasPokemon) {
    if (estadisticasPokemon != null && estadisticasPokemon.getId() != null) {
      estadisticasPokemonDAO.insert(estadisticasPokemon);
    }
  }

  @Override
  public EstadisticasPokemon updateEstadisticasPokemon(EstadisticasPokemon estadisticasPokemon) {
    EstadisticasPokemon estadisticasPokemonUpdated = null;
    if (estadisticasPokemon != null && estadisticasPokemon.getId() != null) {
      estadisticasPokemonUpdated = estadisticasPokemonDAO.update(estadisticasPokemon);
    }
    return estadisticasPokemonUpdated;
  }

  @Override
  public void deleteEstadisticasPokemon(EstadisticasPokemon estadisticasPokemon) {
    if (estadisticasPokemon != null && estadisticasPokemon.getId() != null) {
      estadisticasPokemonDAO.delete(estadisticasPokemon);
    }
  }

  @Override
  public EstadisticasPokemon searchById(Long id) {
    if (id != null) {
      return estadisticasPokemonDAO.searchById(id);
    }
    return null;
  }

  @Override
  public List<EstadisticasPokemon> searchAll() {
    return estadisticasPokemonDAO.searchAll();
  }
}
