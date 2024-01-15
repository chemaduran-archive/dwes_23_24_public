package dao.impl;

import dao.CategoriaDAO;
import models.Categoria;
import org.hibernate.Session;
import dao.generic.GenericDAOImpl;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria> implements CategoriaDAO {
  private final Session session;

  public CategoriaDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public Categoria searchByName(String categoria) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    return session.createQuery("FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
            .setParameter("nombre", categoria)
            .getSingleResult();
  }
}
