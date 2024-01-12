package velazquez._examen_trimestral.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._examen_trimestral.bd.PoolDB;
import velazquez._examen_trimestral.model.Employee;
import velazquez._examen_trimestral.model.Office;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEmployeeImpl implements DAOEmployee {

  static final Logger logger = LoggerFactory.getLogger(DAOEmployeeImpl.class);

  @Override
  public ArrayList<Employee> getAllEmployees() {

    ArrayList<Employee> employeeList = new ArrayList<>();
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();

    try {

      String sql = "SELECT * FROM employees";
      PreparedStatement statement = con.prepareStatement(sql);

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {

        Employee employee = new Employee();

        employee.setEmployeeNumber(rs.getInt("employeeNumber"));
        employee.setLastName(rs.getString("lastName"));
        employee.setFirstName(rs.getString("firstName"));
        employee.setExtension(rs.getString("extension"));
        employee.setEmail(rs.getString("email"));
        employee.setOfficeCode(rs.getInt("officeCode"));
        employee.setReportsTo(rs.getInt("reportsTo"));
        employee.setJobTitle(rs.getString("jobTitle"));

        logger.info("officeCode: " + employee.getOfficeCode());

        DAOOffice daoOffice = new DAOOfficeImpl();
        Office office = daoOffice.getOffice(employee.getOfficeCode());
        employee.setOfficeName(office.getCity());

        if (employee.getReportsTo() != 0) {
          employee.setReportsToName(getEmployee(rs.getInt("reportsTo")).getFirstName());
        } else {
          employee.setReportsToName("President");
        }

        employeeList.add(employee);
      }

      con.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    System.out.println(employeeList);
    return employeeList;
  }

  @Override
  public boolean updateEmployee(Employee employee) {
    int resultado = 0;
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();
    try {

      String sql =
          "UPDATE employees SET employeeNumber=?, lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=? WHERE employeeNumber=?;";
      PreparedStatement statement = con.prepareStatement(sql);

      statement.setInt(1, employee.getEmployeeNumber());
      statement.setString(2, employee.getLastName());
      statement.setString(3, employee.getFirstName());
      statement.setString(4, employee.getExtension());
      statement.setString(5, employee.getEmail());
      statement.setInt(6, employee.getOfficeCode());
      statement.setInt(7, employee.getReportsTo());
      statement.setString(8, employee.getJobTitle());
      statement.setInt(9, employee.getEmployeeNumber());

      resultado = statement.executeUpdate();

      con.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }

  @Override
  public boolean insertEmployee(Employee employee) {
    int resultado = 0;
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();

    try {

      String sql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
      PreparedStatement statement = con.prepareStatement(sql);

      statement.setInt(1, employee.getEmployeeNumber());
      statement.setString(2, employee.getLastName());
      statement.setString(3, employee.getFirstName());
      statement.setString(4, employee.getExtension());
      statement.setString(5, employee.getEmail());
      statement.setInt(6, employee.getOfficeCode());
      statement.setInt(7, employee.getReportsTo());
      statement.setString(8, employee.getJobTitle());

      resultado = statement.executeUpdate();

      con.close();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return (resultado != 0);
  }

  @Override
  public boolean removeEmployee(Employee employee) {
    return false;
  }

  @Override
  public Employee getEmployee(int employeeNumber) {
    Employee employee = new Employee();
    PoolDB pool = new PoolDB();
    Connection con = pool.getConnection();

    try {

      String sql = "SELECT * FROM employees WHERE employeeNumber=?";
      PreparedStatement statement = con.prepareStatement(sql);

      statement.setInt(1, employeeNumber);

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {

        employee.setEmployeeNumber(rs.getInt("employeeNumber"));
        employee.setLastName(rs.getString("lastName"));
        employee.setFirstName(rs.getString("firstName"));
        employee.setExtension(rs.getString("extension"));
        employee.setEmail(rs.getString("email"));
        employee.setOfficeCode(rs.getInt("officeCode"));
        employee.setReportsTo(rs.getInt("reportsTo"));
        employee.setJobTitle(rs.getString("jobTitle"));
      }

      con.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return employee;
  }
}
