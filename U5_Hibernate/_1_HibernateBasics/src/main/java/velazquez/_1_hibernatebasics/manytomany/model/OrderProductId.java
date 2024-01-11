package velazquez._1_hibernatebasics.manytomany.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderProductId implements Serializable {

  private Long order;
  private Long product;

  public OrderProductId() {}

  @Override
  public int hashCode() {
    return Objects.hash(order, product);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    OrderProductId other = (OrderProductId) obj;

    if (product == null) {
      if (other.product != null) return false;
    } else if (product != other.product) return false;

    if (order == null) {
      if (other.order != null) return false;
    } else if (order != other.order) return false;

    return true;
  }

  public Long getOrderId() {
    return order;
  }

  public void setOrderId(Long orderId) {
    this.order = orderId;
  }

  public Long getProductId() {
    return product;
  }

  public void setProductId(Long productId) {
    this.product = productId;
  }
}
