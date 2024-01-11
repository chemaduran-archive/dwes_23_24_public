package velazquez._1_hibernatebasics.utils.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

public class GenericDAOImpl<T> implements GenericDAO<T> {

  // Tipo de la clase Genérica
  private Class<T> entityClass;

  // Sesión para obtener la conexión a la base de datos.
  private Session session;

  public GenericDAOImpl(Session session) {
    setEntityClass(
        (Class<T>)
            ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    this.session = session;
  }

  @Override
  public void insert(final T objectT) {

    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Inserta el objeto
    session.save(objectT);
    session.flush();

    // Confirma la inserción
    session.getTransaction().commit();
  }

  @Override
  public void update(final T objectT) {

    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Actualiza el objeto
    session.saveOrUpdate(objectT);

    // Confirma la actualización
    session.getTransaction().commit();
  }

  @Override
  public void delete(final T objectT) {

    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Elimina el objeto
    session.delete(objectT);

    // Confirmo al inserción
    session.getTransaction().commit();
  }

  @Override
  public T searchById(final Long id) {

    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupera el objeto al que corresponde ese ID
    T resultado = session.get(this.entityClass, id);

    return resultado;
  }

  @Override
  public List<T> searchAll() {

    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Búsqueda de todos los registros.
    List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

    return list;
  }

  // Devuelve la clase de la entirdad
  public Class<T> getEntityClass() {
    return entityClass;
  }

  // Establece la clase de la entidad
  public void setEntityClass(Class<T> entityClass) {
    this.entityClass = entityClass;
  }
}
