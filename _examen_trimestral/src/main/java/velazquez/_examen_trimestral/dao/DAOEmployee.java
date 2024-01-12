package velazquez._examen_trimestral.dao;

import velazquez._examen_trimestral.model.Employee;

import java.util.ArrayList;

public interface DAOEmployee {
  public ArrayList<Employee> getAllEmployees();

  public boolean insertEmployee(Employee employee);

  public boolean updateEmployee(Employee employee);

  public boolean removeEmployee(Employee employee);

  public Employee getEmployee(int employeeNumber);
}
