package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.bd.DBConnection;
import velazquez._5_registrologin.model.OrderDetail;
import velazquez._5_registrologin.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOOrderDetailsImpl implements DAOOrderDetails {

  @Override
  public ArrayList<OrderDetail> getDetailsFromOrder(int orderNumber) {

    ArrayList<OrderDetail> orderdetails = new ArrayList<OrderDetail>();
    OrderDetail od;
    Product product;

    try {

      String sql = "SELECT * FROM orderdetails WHERE orderNumber = ?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setInt(1, orderNumber);

      ResultSet rs = statement.executeQuery();

      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {

        od = new OrderDetail();
        od.setOrderLineNumber(rs.getInt("orderLineNumber"));
        od.setPriceEach(rs.getDouble("priceEach"));
        od.setQuantityOrdered(rs.getInt("quantityOrdered"));

        String productCode = rs.getString("productCode");

        DAOProductImpl daoProduct = new DAOProductImpl();

        product = daoProduct.getProductByCode(productCode);

        od.setProduct(product);

        orderdetails.add(od);
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } finally {
      DBConnection.close();
    }

    return orderdetails;
  }
}
