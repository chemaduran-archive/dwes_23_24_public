package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.model.Order;

import java.util.ArrayList;

public interface DAOOrder {
  public Order getOrder(int orderNumber);

  public ArrayList<Order> getAllOrders();
}
