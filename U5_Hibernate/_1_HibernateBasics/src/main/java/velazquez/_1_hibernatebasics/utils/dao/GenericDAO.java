package velazquez._1_hibernatebasics.utils.dao;

import java.util.List;

public interface GenericDAO<T> {

  public void insert(final T objetT);

  public void update(final T objectT);

  public void delete(final T objectT);

  public T searchById(final Long id);

  public List<T> searchAll();
}
