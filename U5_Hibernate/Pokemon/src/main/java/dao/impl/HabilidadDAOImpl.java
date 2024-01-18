package dao.impl;

import dao.HabilidadDAO;
import dao.generic.GenericDAOImpl;
import models.Habilidad;
import models.Tipo;
import org.hibernate.Session;

public class HabilidadDAOImpl extends GenericDAOImpl<Habilidad> implements HabilidadDAO {
  private final Session session;

  public HabilidadDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public Habilidad searchByNombre(String nombre) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    return session
        .createQuery("FROM Habilidad c WHERE c.nombre = :nombre", Habilidad.class)
        .setParameter("nombre", nombre)
        .getSingleResult();
  }
}
