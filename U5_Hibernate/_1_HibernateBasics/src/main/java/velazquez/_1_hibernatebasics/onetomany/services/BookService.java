package velazquez._1_hibernatebasics.onetomany.services;

import velazquez._1_hibernatebasics.onetomany.model.Book;

import java.util.List;

public interface BookService {

  public void insertNewBook(final Book book);

  public void updateBook(final Book book);

  public void deleteBook(final Book book);

  public Book searchById(final Long bookId);

  public List<Book> searchAll();

  public Book searchBookByIsbn(final String isbn);
}
