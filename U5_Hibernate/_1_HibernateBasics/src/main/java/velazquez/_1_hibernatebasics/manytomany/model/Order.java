package velazquez._1_hibernatebasics.manytomany.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

  @Id @GeneratedValue private Long id;

  @Column(name = "date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date orderDate;

  @Column(name = "customer", nullable = false, length = 100)
  private String customer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OrderDetail> orderDetails = new HashSet<>();

  public Order() {}

  public Long getId() {
    return id;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Set<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Order other = (Order) obj;
    return Objects.equals(id, other.id);
  }

  // Métodos Helpers
  public void addProduct(Product product, Integer quantity) {
    OrderDetail orderDetail = new OrderDetail(this, product, quantity);
    this.orderDetails.add(orderDetail);
    product.getOrderDetails().add(orderDetail);
  }

  public void removeProduct(Product product) {
    OrderDetail orderDetail = new OrderDetail(this, product);
    product.getOrderDetails().remove(orderDetail);
    this.orderDetails.remove(orderDetail);
  }
}
