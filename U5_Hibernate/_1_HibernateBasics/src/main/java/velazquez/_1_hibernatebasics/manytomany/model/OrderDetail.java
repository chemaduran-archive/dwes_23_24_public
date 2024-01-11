package velazquez._1_hibernatebasics.manytomany.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(OrderProductId.class)
public class OrderDetail {

  @Id
  @ManyToOne
  @JoinColumn(name = "order_id", insertable = false, updatable = false)
  private Order order;

  @Id
  @ManyToOne
  @JoinColumn(name = "product_id", insertable = false, updatable = false)
  private Product product;

  private Integer quantity;

  public OrderDetail() {}

  public OrderDetail(Order order, Product product) {
    super();
    this.order = order;
    this.product = product;
  }

  public OrderDetail(Order order, Product product, Integer quantity) {
    super();
    this.order = order;
    this.product = product;
    this.quantity = quantity;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(order, product);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    OrderDetail other = (OrderDetail) obj;
    return Objects.equals(order, other.order) && Objects.equals(product, other.product);
  }
}
