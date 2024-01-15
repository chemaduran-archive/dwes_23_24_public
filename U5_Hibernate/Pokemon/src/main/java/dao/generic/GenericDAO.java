package dao.generic;

import java.util.List;

public interface GenericDAO<T> {

  public void insert(final T objectT);

  public T update(final T objectT);

  public void delete(final T objectT);

  public T searchById(final Long id);

  public List<T> searchAll();
}
