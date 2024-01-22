package dao;

import java.util.ArrayList;
import java.util.List;

import model.Departamento;
import org.hibernate.Session;
import utils.dao.GenericDAOImpl;

public class DepartamentoDAOImpl extends GenericDAOImpl<Departamento> implements DepartamentoDAO {

  private final Session session;

  public DepartamentoDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public List<Departamento> searchByName(String name) {

    // Compruebo que la conexión está actica
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    List<Departamento> departamentoList = new ArrayList<>();

    if (name != null) {
      // Recupero todos los departamentos con ese nombre
      departamentoList =
          session
              .createQuery("FROM Departamento WHERE name=:name", Departamento.class)
              .setParameter("name", name)
              .list();
    }

    return departamentoList;
  }
}
