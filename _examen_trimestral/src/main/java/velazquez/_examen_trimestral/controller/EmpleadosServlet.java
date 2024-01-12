package velazquez._examen_trimestral.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._examen_trimestral.dao.DAOEmployeeImpl;
import velazquez._examen_trimestral.model.Employee;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EmpleadosServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DAOEmployeeImpl daoEmployeeImpl = new DAOEmployeeImpl();

    ArrayList<Employee> empleados = daoEmployeeImpl.getAllEmployees();
    request.setAttribute("empleados", empleados);
    request.getRequestDispatcher("/WEB-INF/view/admin/empleados.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
