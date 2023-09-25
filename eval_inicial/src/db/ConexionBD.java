package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
  private static Connection con = null;
  private static String url =
      "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=XXXXX";

  public static Connection getConnection() {
    try {
      con = DriverManager.getConnection(ConexionBD.url);
      System.out.println("Conexión realizada correctamente");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return con;
  }

  public static void close() {
    if (con != null) {
      try {
        con.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
  }
}
