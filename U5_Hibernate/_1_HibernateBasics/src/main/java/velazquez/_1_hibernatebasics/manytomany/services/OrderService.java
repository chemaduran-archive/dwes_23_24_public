package velazquez._1_hibernatebasics.manytomany.services;

import velazquez._1_hibernatebasics.manytomany.model.Order;
import java.util.List;

public interface OrderService {

  public void insertNewOrder(final Order order);

  public void updateOrder(final Order order);

  public void deleteOrder(final Order order);

  public Order searchById(final Long orderId);

  public List<Order> searchAll();
}
