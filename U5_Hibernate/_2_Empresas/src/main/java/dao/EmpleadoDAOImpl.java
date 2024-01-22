package dao;

import java.util.List;

import model.Empleado;
import org.hibernate.Session;
import utils.dao.GenericDAOImpl;
import jakarta.persistence.criteria.*;

public class EmpleadoDAOImpl extends GenericDAOImpl<Empleado> implements EmpleadoDAO {

  private final Session session;

  public EmpleadoDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public List<Empleado> searchByFullName(String firstName, String lastName) {

    // Compruebo que la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupero empleados que cumplen las condiciones con Criteria
    // No es una consulta Nativa uso el nombre de la clase
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Empleado> criteria = builder.createQuery(Empleado.class);
    Root<Empleado> root = criteria.from(Empleado.class);
    criteria.select(root);
    criteria.where(
        builder.equal(root.get("firstName"), firstName),
        builder.equal(root.get("lastName"), lastName));

    return session.createQuery(criteria).getResultList();
  }
}
