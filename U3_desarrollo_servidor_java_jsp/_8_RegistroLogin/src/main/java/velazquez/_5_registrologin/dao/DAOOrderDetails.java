package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.model.OrderDetail;

import java.util.ArrayList;

public interface DAOOrderDetails {

  public ArrayList<OrderDetail> getDetailsFromOrder(int orderNumber);
}
