package velazquez._3_jstl_editarclientes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import velazquez._3_jstl_editarclientes.bd.DBConnection;
import velazquez._3_jstl_editarclientes.model.PaymentBean;

public class DAOPaymentImpl implements DAOPayment {

  @Override
  public List<PaymentBean> getAllPayments() {
    ArrayList<PaymentBean> paymentsList = new ArrayList<>();
    PaymentBean customer;

    try {
      String sql = "SELECT * FROM payments;";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        PaymentBean payment = new PaymentBean();

        payment.setCustomerNumber(rs.getInt("customerNumber"));
        payment.setCheckNumber(rs.getString("checkNumber"));
        payment.setDate(rs.getString("paymentDate"));
        payment.setAmount(rs.getDouble("amount"));

        paymentsList.add(payment);
      }

      DBConnection.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return paymentsList;
  }

  @Override
  public PaymentBean getPayment(int customerNumber, String checkNumber) {

    PaymentBean payment = null;

    try {
      String sql = "SELECT * FROM payments where customerNumber= ? and checkNumber= ?";

      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setInt(1, customerNumber);
      statement.setString(2, checkNumber);

      ResultSet rs = statement.executeQuery();

      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {
        payment = new PaymentBean();

        payment.setCustomerNumber(rs.getInt("customerNumber"));
        payment.setCheckNumber(rs.getString("checkNumber"));
        payment.setDate(rs.getString("paymentDate"));
        payment.setAmount(rs.getDouble("amount"));
      }
      DBConnection.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return payment;
  }

  @Override
  public boolean removePayment(int customerNumber, String checkNumber) {

    int resultado = 0;

    try {
      String sql = "DELETE FROM payments WHERE customerNumber=? AND checkNumber=?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setInt(1, customerNumber);
      statement.setString(2, checkNumber);

      resultado = statement.executeUpdate();

      DBConnection.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return (resultado != 0);
  }

  @Override
  public boolean updatePayment(PaymentBean payment) {

    int resultado = 0;

    try {
      String sql =
          "UPDATE payments SET paymentDate= ?, amount=? WHERE customerNumber = ? AND checkNumber = ?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setString(1, payment.getDate());
      statement.setDouble(2, payment.getAmount());
      statement.setInt(3, payment.getCustomerNumber());
      statement.setString(4, payment.getCheckNumber());

      resultado = statement.executeUpdate();

      DBConnection.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return (resultado != 0);
  }
}
