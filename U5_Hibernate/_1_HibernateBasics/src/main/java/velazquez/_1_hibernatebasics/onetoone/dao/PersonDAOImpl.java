package velazquez._1_hibernatebasics.onetoone.dao;

import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.onetoone.model.Person;
import velazquez._1_hibernatebasics.utils.dao.GenericDAOImpl;

public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO {

  private Session session;

  public PersonDAOImpl(Session session) {
    super(session);
  }

  @Override
  public List<Person> searchByFirstAndLastName(final String firstName, final String lastName) {

    // Compruebo que la conexión esté activa
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupero las personas con esos datos
    final List<Person> personList =
        session
            .createQuery(
                "FROM Person WHERE firstName =" + firstName + " AND lastName = " + lastName)
            .list();

    return personList;
  }
}
