package velazquez._1_hibernatebasics.onetomany.services;

import velazquez._1_hibernatebasics.onetomany.model.Publisher;

import java.util.List;

public interface PublisherService {

  public void insertNewPublisher(final Publisher book);

  public void updatePublisher(final Publisher book);

  public void deletePublisher(final Publisher book);

  public Publisher searchById(final Long publisherId);

  public List<Publisher> searchAll();

  public Publisher searchPublisherByName(final String name);
}
