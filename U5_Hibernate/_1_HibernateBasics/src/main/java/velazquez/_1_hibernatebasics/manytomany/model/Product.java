package velazquez._1_hibernatebasics.manytomany.model;

import jakarta.persistence.*;
import velazquez._1_hibernatebasics.utils.dao.Identifiable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "barCode", nullable = false, unique = true, length = 100)
  private String barCode;

  @Column(name = "price", nullable = false)
  private Double price;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OrderDetail> orderDetails = new HashSet<>();

  public Product() {}

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Set<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  @Override
  public int hashCode() {
    return Objects.hash(barCode, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Product other = (Product) obj;
    return Objects.equals(barCode, other.barCode)
        && Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }
}
