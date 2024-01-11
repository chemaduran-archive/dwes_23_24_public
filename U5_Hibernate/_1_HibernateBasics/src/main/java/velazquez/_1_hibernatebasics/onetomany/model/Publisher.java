package velazquez._1_hibernatebasics.onetomany.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publisher implements Serializable {

  @Id @GeneratedValue private Long id;

  @Column(name = "name", unique = true, length = 100, nullable = false)
  private String name;

  @Column(name = "year", nullable = true)
  @Digits(integer = 4, fraction = 0)
  @Min(value = 1600, message = "")
  @Max(value = 3000, message = "")
  private Integer foundationYear;

  @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Book> books = new HashSet<>();

  public Publisher() {
  }

  // No tiene sentido el set del ID ya que está auto generado
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getFoundationYear() {
    return foundationYear;
  }

  public void setFoundationYear(Integer foundationYear) {
    this.foundationYear = foundationYear;
  }

  public Set<Book> getBooks() {
    return books;
  }

  // Métodos HELPERs
  public void addBook(Book book) {
    this.books.add(book);
    book.setPublisher(this);
  }

  public void removeBook(Book book) {
    this.books.remove(book);
    book.setPublisher(null);
  }

  @Override
  public String toString() {
    return "Publisher [id="
        + id
        + ", name="
        + name
        + ", foundationYear="
        + foundationYear
        + ", books="
        + books
        + "]";
  }
}
