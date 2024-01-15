package services.impl;

import dao.TipoDAO;
import dao.impl.TipoDAOImpl;
import models.Tipo;
import org.hibernate.Session;
import services.TipoService;

import java.util.List;

public class TipoServiceImpl implements TipoService {

  TipoDAO tipoDAO;

  public TipoServiceImpl(Session session) {
    tipoDAO = new TipoDAOImpl(session);
  }

  @Override
  public void insertNewTipo(Tipo tipo) {
    if (tipo != null && tipo.getId() == null) {
      tipoDAO.insert(tipo);
    }
  }

  @Override
  public Tipo updateTipo(Tipo tipo) {
    Tipo tipoUpdated = null;
    if (tipo != null && tipo.getId() != null) {
      tipoUpdated = tipoDAO.update(tipo);
    }
    return tipoUpdated;
  }

  @Override
  public void deleteTipo(Tipo tipo) {
    if (tipo != null && tipo.getId() != null) {
      tipoDAO.delete(tipo);
    }
  }

  @Override
  public Tipo searchById(Long postId) {
    if (postId != null) {
      return tipoDAO.searchById(postId);
    }
    return null;
  }

  @Override
  public Tipo serchByNombre(final String nombre) {
    if (nombre != null) {
      return tipoDAO.searchByName(nombre);
    }
    return null;
  }

  @Override
  public List<Tipo> searchAll() {
    return tipoDAO.searchAll();
  }
}
