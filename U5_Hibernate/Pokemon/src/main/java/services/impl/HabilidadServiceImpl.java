package services.impl;

import dao.HabilidadDAO;
import dao.impl.HabilidadDAOImpl;
import models.Habilidad;
import models.Tipo;
import org.hibernate.Session;
import services.HabilidadService;

import java.util.List;

public class HabilidadServiceImpl implements HabilidadService {

  HabilidadDAO habilidadDAO;

  public HabilidadServiceImpl(Session session) {
    this.habilidadDAO = new HabilidadDAOImpl(session);
  }


  @Override
  public void insertNewHabilidad(Habilidad habilidad) {
    if (habilidad != null && habilidad.getId() == null) {
      habilidadDAO.insert(habilidad);
    }
  }

  @Override
  public Habilidad updateHabilidad(Habilidad habilidad) {
    Habilidad habilidadUpdated = null;
    if (habilidad != null && habilidad.getId() != null) {
      habilidadUpdated = habilidadDAO.update(habilidad);
    }
    return habilidadUpdated;
  }

  @Override
  public void deleteHabilidad(Habilidad habilidad) {
    if (habilidad != null && habilidad.getId() != null) {
      habilidadDAO.delete(habilidad);
    }
  }

  @Override
  public Habilidad searchById(Long habilidadId) {
    if (habilidadId != null) {
      return habilidadDAO.searchById(habilidadId);
    }
    return null;
  }

  @Override
  public Habilidad serchByNombre(String nombre) {
    if (nombre != null) {
      return habilidadDAO.searchByNombre(nombre);
    }
    return null;
  }

  @Override
  public List<Habilidad> searchAll() {
    return null;
  }
}
