package velazquez._1_hibernatebasics.onetomany;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.onetomany.model.Book;
import velazquez._1_hibernatebasics.onetomany.model.Publisher;
import velazquez._1_hibernatebasics.onetomany.services.BookService;
import velazquez._1_hibernatebasics.onetomany.services.BookServiceImpl;
import velazquez._1_hibernatebasics.onetomany.services.PublisherService;
import velazquez._1_hibernatebasics.onetomany.services.PublisherServiceImpl;
import velazquez._1_hibernatebasics.utils.HibernateUtils;

public class MainOneToMany {

  public static void main(String[] args) {

    // Creo la sesión
    Session session = HibernateUtils.getSessionFactory().openSession();

    // Creo los servicios
    BookService bookService = new BookServiceImpl(session);
    PublisherService publisherService = new PublisherServiceImpl(session);

    // Creo varios libros
    Book bookA = new Book();
    bookA.setAuthor("Cervantes");
    bookA.setIsbn("111111-X-4");
    bookA.setPages(1000);
    bookA.setTitle("Don Quijote de la Mancha");

    Book bookB = new Book();
    bookB.setIsbn("222222-Y-5");
    bookB.setPages(500);
    bookB.setTitle("El Lazarillo de Tormes");

    Book bookC = new Book();
    bookC.setAuthor("Shakepeare");
    bookC.setIsbn("33333-W-10");
    bookC.setPages(750);
    bookC.setTitle("Rome and Juliet");

    // Creo la editorial
    Publisher publisher = new Publisher();
    publisher.setFoundationYear(1830);
    publisher.setName("Planetilla");

    // Persisto los libros antes de añadirlos a la editorial para
    // posteriormente añadirlos a la editorial
    bookService.insertNewBook(bookA);
    bookService.insertNewBook(bookB);
    bookService.insertNewBook(bookC);

    // Añado los libros ya persistidos (creados y con Id) a la editorial
    publisher.addBook(bookA);
    publisher.addBook(bookB);
    publisher.addBook(bookC);

    // Una vez tengo eso añadido ya puedo persistir la editorial
    publisherService.insertNewPublisher(publisher);

    // Probamos alguno de los otros métodos
    Book book = bookService.searchBookByIsbn("222222-Y-5");

    System.out.println("El id del libro con ISBN 222222-Y-5 es: " + book.getId());
    System.out.println(book);

    Publisher p = publisherService.searchPublisherByName("Planetilla");
    System.out.println("El id de la editorial Planetilla es: " + p.getId());
    System.out.println(p);

    // Cierro la sesión
    session.close();
  }
}
