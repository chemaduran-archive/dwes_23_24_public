package dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.EntityExistsException;
import org.hibernate.Session;

public class GenericDAOImpl<T extends Identifiable> implements GenericDAO<T> {

  // Sesión para obtener la conexión a la base de datos.
  private final Session session;
  // Tipo de la clase Genérica
  private Class<T> entityClass;

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
    session.persist(objectT);
    System.out.println("Insertado: " + objectT);
    session.flush();

    // Confirma la inserción
    session.getTransaction().commit();
  }

  @Override
  public T update(final T objectT) {
    T objectUpdated = null;

    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Actualiza el objeto
    //    session.saveOrUpdate(objectT);

    if (Objects.isNull(session.find(this.entityClass, objectT.getId()))) {
      session.persist(objectT);
      System.out.println("UPDATE Insertado: " + objectT);
    } else {
      objectUpdated = session.merge(objectT);
      System.out.println("UPDATE Actualizado: " + objectUpdated);
    }

    try {
      // Confirma la actualización
      session.getTransaction().commit();
    } catch (EntityExistsException e) {
      System.out.println("Error al actualizar: " + objectT);
      System.out.println(e.getMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        System.out.println(element);
      }
    }
    return objectUpdated;
  }

  @Override
  public void delete(final T objectT) {
    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Elimina el objeto
    session.remove(objectT);

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
    return session.get(this.entityClass, id);
  }

  @Override
  public List<T> searchAll() {
    // Comprueba si la conexión está activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Búsqueda de todos los registros.
    return session.createQuery("FROM " + this.entityClass.getName(), this.entityClass).list();
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
