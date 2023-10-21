package velazquez._ej_crud.dao;

import velazquez._ej_crud.models.EmployeeBean;

import java.util.List;

public interface EmployeesDAO {
    List<EmployeeBean> getEmployees();
    EmployeeBean getEmployeesById(Integer employeeNumber);
    void deleteEmployeesById(Integer employeeNumber);
    void updateEmployee(EmployeeBean employeeBean);
    void createEmployee(EmployeeBean employeeBean);
}
