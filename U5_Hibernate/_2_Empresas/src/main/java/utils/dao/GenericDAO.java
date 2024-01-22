package utils.dao;

import java.util.List;

public interface GenericDAO<T extends Identifiable> {

  public void insert(final T objetT);

  public T update(final T objectT);

  public void delete(final T objectT);

  public T searchById(final Long id);

  public List<T> searchAll();
}
