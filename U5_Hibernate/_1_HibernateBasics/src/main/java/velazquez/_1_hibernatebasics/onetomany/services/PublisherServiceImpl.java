package velazquez._1_hibernatebasics.onetomany.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.onetomany.dao.PublisherDAO;
import velazquez._1_hibernatebasics.onetomany.dao.PublisherDAOImpl;
import velazquez._1_hibernatebasics.onetomany.model.Publisher;

public class PublisherServiceImpl implements PublisherService {

  // El servicio encapsulará el uso del DAO
  // y añadirá lógica de negocio necesaria
  private PublisherDAO publisherDao;

  public PublisherServiceImpl(final Session session) {

    this.publisherDao = new PublisherDAOImpl(session);
  }

  @Override
  public void insertNewPublisher(final Publisher publisher) {

    // Compruebo que no es nulo y que aún no existe
    // es decir no tiene ID
    if (publisher != null && publisher.getId() == null) {

      // Inserción del publisher
      publisherDao.insert(publisher);
    }
  }

  @Override
  public void updatePublisher(final Publisher publisher) {

    // Compruebo que no es nulo y que ya existe (tiene ID)
    if (publisher != null && publisher.getId() != null) {

      // Actualizo el publisher
      publisherDao.update(publisher);
    }
  }

  @Override
  public void deletePublisher(final Publisher publisher) {

    // Compruebo que no es nulo y que ya existe (tiene ID)
    if (publisher != null && publisher.getId() != null) {

      // Actualizo el publisher
      publisherDao.delete(publisher);
    }
  }

  @Override
  public Publisher searchById(final Long publisherId) {

    Publisher publisher = null;

    if (publisherId != null) {

      publisher = publisherDao.searchById(publisherId);
    }

    return publisher;
  }

  @Override
  public List<Publisher> searchAll() {

    List<Publisher> publisherList = new ArrayList<Publisher>();

    publisherList = publisherDao.searchAll();

    return publisherList;
  }

  @Override
  public Publisher searchPublisherByName(final String name) {

    Publisher publisher = null;

    if (name != null) {

      publisher = publisherDao.searchByName(name);
    }

    return publisher;
  }
}
