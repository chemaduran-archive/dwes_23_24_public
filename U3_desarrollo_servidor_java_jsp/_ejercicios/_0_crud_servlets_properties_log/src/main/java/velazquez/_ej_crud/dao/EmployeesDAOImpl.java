package velazquez._ej_crud.dao;

import velazquez._ej_crud.db.DBConnection;
import velazquez._ej_crud.models.EmployeeBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAOImpl implements EmployeesDAO {

    @Override
    public List<EmployeeBean> getEmployees() {
        Connection con = DBConnection.getConnection();
        ArrayList<EmployeeBean> employeesList = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees;");

            while (resultSet.next()) {
                EmployeeBean employeeBean =
                        new EmployeeBean(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getString(8));
                employeesList.add(employeeBean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employeesList;
    }

    @Override
    public EmployeeBean getEmployeesById(Integer employeeNumber) {
        Connection con = DBConnection.getConnection();
        EmployeeBean employeeBean = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employees WHERE employeeNumber = ?");
            ps.setInt(1, employeeNumber);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                employeeBean =
                        new EmployeeBean(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getString(8));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employeeBean;
    }

    @Override
    public void deleteEmployeesById(Integer employeeNumber) {
        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE employeeNumber = ?");
            ps.setInt(1, employeeNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(EmployeeBean employeeBean) {
        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE employees " +
                    "     SET " +
                    "      `lastName` = ?," +
                    "      `firstName` = ?," +
                    "      `extension` = ?," +
                    "      `email` = ?," +
                    "      `officeCode` = ?," +
                    "      `reportsTo` = ?," +
                    "      `jobTitle` = ?" +
                    "     WHERE `employeeNumber` = ?");
            ps.setString(1,  employeeBean.getLastName());
            ps.setString(2,  employeeBean.getFirstName());
            ps.setString(3,  employeeBean.getExtension());
            ps.setString(4,  employeeBean.getEmail());
            ps.setString(5,  employeeBean.getOfficeCode());
            ps.setInt(6,  employeeBean.getReportsTo());
            ps.setString(7,  employeeBean.getJobTitle());
            ps.setInt(8,  employeeBean.getEmployeeNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void createEmployee(EmployeeBean employeeBean) {
        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO employees (`lastName`, `firstName`, `extension`, " +
                    "`email`, `officeCode`, `reportsTo`, `jobTitle`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1,  employeeBean.getLastName());
            ps.setString(2,  employeeBean.getFirstName());
            ps.setString(3,  employeeBean.getExtension());
            ps.setString(4,  employeeBean.getEmail());
            ps.setString(5,  employeeBean.getOfficeCode());
            ps.setInt(6,  employeeBean.getReportsTo());
            ps.setString(7,  employeeBean.getJobTitle());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
