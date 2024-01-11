package velazquez._1_hibernatebasics.onetomany.dao;

import velazquez._1_hibernatebasics.onetomany.model.Book;
import velazquez._1_hibernatebasics.utils.dao.GenericDAO;

public interface BookDAO extends GenericDAO<Book> {

  public Book searchByIsbn(final String isbn);
}
