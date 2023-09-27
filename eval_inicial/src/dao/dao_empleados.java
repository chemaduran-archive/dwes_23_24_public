package dao;

import db.ConexionBD;
import models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dao_empleados {
  public static List<Employee> getEmpleados() {
    Connection con = ConexionBD.getConnection();
    ArrayList<Employee> lista_empleados = new ArrayList<>();

    try {
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM employees;");

      while (resultSet.next()) {
        Employee employee =
            new Employee(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getInt(7),
                resultSet.getString(8));
        lista_empleados.add(employee);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    ConexionBD.close();

    return lista_empleados;
  }
}
