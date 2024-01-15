package dao.impl;

import dao.TipoDAO;
import dao.generic.GenericDAOImpl;
import models.Tipo;
import org.hibernate.Session;

public class TipoDAOImpl extends GenericDAOImpl<Tipo> implements TipoDAO {
  private final Session session;

  public TipoDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public Tipo searchByName(String tipo) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    return session.createQuery("FROM Tipo c WHERE c.nombre = :nombre", Tipo.class)
            .setParameter("nombre", tipo)
            .getSingleResult();
  }
}
