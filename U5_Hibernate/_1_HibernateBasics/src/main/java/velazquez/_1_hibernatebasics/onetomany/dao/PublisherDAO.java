package velazquez._1_hibernatebasics.onetomany.dao;

import velazquez._1_hibernatebasics.onetomany.model.Publisher;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

public interface PublisherDAO extends GenericDAO<Publisher> {

  public Publisher searchByName(final String name);
}
