package velazquez._5_registrologin.model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
  private Product product;
  private int quantityOrdered;
  private double priceEach;
  private int orderLineNumber;

  public OrderDetail() {
  }

  public OrderDetail(Product product, int quantityOrdered, double priceEach, int orderLineNumber) {
    super();
    this.product = product;
    this.quantityOrdered = quantityOrdered;
    this.priceEach = priceEach;
    this.orderLineNumber = orderLineNumber;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantityOrdered() {
    return quantityOrdered;
  }

  public void setQuantityOrdered(int quantityOrdered) {
    this.quantityOrdered = quantityOrdered;
  }

  public double getPriceEach() {
    return priceEach;
  }

  public void setPriceEach(double priceEach) {
    this.priceEach = priceEach;
  }

  public int getOrderLineNumber() {
    return orderLineNumber;
  }

  public void setOrderLineNumber(int orderLineNumber) {
    this.orderLineNumber = orderLineNumber;
  }
}
