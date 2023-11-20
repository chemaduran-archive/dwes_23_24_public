package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.bd.DBConnection;
import velazquez._5_registrologin.model.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPaymentImpl implements DAOPayment {

  @Override
  public List<Payment> getAllPayments() {
    ArrayList<Payment> paymentsList = new ArrayList<>();
    Payment customer;

    try {
      String sql = "SELECT * FROM payments";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        Payment payment = new Payment();

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
  public Payment getPayment(int customerNumber, String checkNumber) {
    Payment payment = null;

    try {
      String sql = "SELECT * FROM payments WHERE customerNumber= ? AND checkNumber= ?";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setInt(1, customerNumber);
      statement.setString(2, checkNumber);

      ResultSet rs = statement.executeQuery();
      // Como el campo de búsqueda es la clave solo debería obtener un resultado
      // si no es así estaremos machacando cada vez el valor de customer y
      while (rs.next()) {
        payment = new Payment();

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
  public boolean updatePayment(Payment payment) {

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

  @Override
  public boolean insertPayment(Payment payment) {
    int resultado = 0;

    try {
      String sql = "INSERT INTO payments VALUES(?,?,?,?)";
      PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
      statement.setInt(1, payment.getCustomerNumber());
      statement.setString(2, payment.getCheckNumber());
      statement.setString(3, payment.getDate());
      statement.setDouble(4, payment.getAmount());

      resultado = statement.executeUpdate();

      DBConnection.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }
}
