package velazquez._1_hibernatebasics.onetomany.dao;

import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.onetomany.model.Book;
import velazquez._1_hibernatebasics.utils.dao.GenericDAOImpl;

public class BookDAOImpl extends GenericDAOImpl<Book> implements BookDAO {

  private final Session session;

  public BookDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public Book searchByIsbn(final String isbn) {

    // Compruebo que la conexión está actica
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    // Recupero los libros por isbn
    // No es una consulta Nativa uso el nombre de la clase
    List<Book> bookList =
        session.createQuery("FROM Book WHERE isbn=:isbn").setParameter("isbn", isbn).list();

    // Como el ISBN es único si me devuelve algo me quedo con el primero
    Book book = null;
    if (bookList != null && bookList.size() > 0) {
      book = bookList.get(0);
    }

    return book;
  }
}
