package velazquez._1_hibernatebasics.onetomany.dao;

import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.onetomany.model.Publisher;
import velazquez._1_hibernatebasics.utils.dao.GenericDAOImpl;

public class PublisherDAOImpl extends GenericDAOImpl<Publisher> implements PublisherDAO {

  private Session session;

  public PublisherDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public Publisher searchByName(final String name) {

    // Compruebo que la conexión está acticva
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupero las editoriales por nombre
    List<Publisher> publisherList =
        session.createQuery("FROM Publisher WHERE name='" + name + "'").list();

    // Como el nombre del publisher debe ser único me quedo con el primero en caso
    // de que se haya devuelvo algo (existe)
    Publisher publisher = null;
    if (publisherList != null && publisherList.size() > 0) {
      publisher = publisherList.get(0);
    }

    return publisher;
  }
}
