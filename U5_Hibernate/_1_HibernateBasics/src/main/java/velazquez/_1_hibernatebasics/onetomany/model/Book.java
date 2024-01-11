package velazquez._1_hibernatebasics.onetomany.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import velazquez._1_hibernatebasics.utils.dao.Identifiable;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Serializable, Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 300)
  private String title;

  @Column(nullable = false)
  @Min(value = 1, message = "No hay libros sin hojas")
  private Integer pages;

  @Column(nullable = true, length = 300)
  private String author;

  @Column(nullable = false, unique = true, length = 20)
  private String isbn;

  @ManyToOne private Publisher publisher;

  public Book() {}

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Book other = (Book) obj;
    return Objects.equals(isbn, other.isbn);
  }

  // No tiene sentido el setId ya que es auto generado
  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return "Book [id="
        + id
        + ", title="
        + title
        + ", pages="
        + pages
        + ", author="
        + author
        + ", isbn="
        + isbn
        + "]";
  }
}
