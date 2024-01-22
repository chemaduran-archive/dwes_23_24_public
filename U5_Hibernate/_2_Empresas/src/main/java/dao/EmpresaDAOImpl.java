package dao;

import java.util.List;

import model.Empresa;
import org.hibernate.Session;
import utils.dao.GenericDAOImpl;

public class EmpresaDAOImpl extends GenericDAOImpl<Empresa> implements EmpresaDAO {

  private final Session session;

  public EmpresaDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public Empresa searchByName(String name) {

    // Compruebo que la conexión está actica
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupero las empresas por nombre
    // No es una consulta Nativa uso el nombre de la clase
    List<Empresa> empresaList =
        session
            .createQuery("FROM Empresa WHERE name=:name ", Empresa.class)
            .setParameter("name", name)
            .list();

    // El nombre de la empresa va a ser único
    Empresa empresa = null;
    if (empresaList != null && !empresaList.isEmpty()) {
      empresa = empresaList.get(0);
    }

    return empresa;
  }
}
