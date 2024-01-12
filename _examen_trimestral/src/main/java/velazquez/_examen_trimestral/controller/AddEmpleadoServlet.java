package velazquez._examen_trimestral.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._examen_trimestral.dao.DAOEmployeeImpl;
import velazquez._examen_trimestral.dao.DAOOfficeImpl;
import velazquez._examen_trimestral.model.Employee;
import velazquez._examen_trimestral.model.Office;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(AddEmpleadoServlet.class);
  private static final long serialVersionUID = 1L;

  public AddEmpleadoServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DAOEmployeeImpl daoImpl = new DAOEmployeeImpl();
    DAOOfficeImpl daoOfficeImpl = new DAOOfficeImpl();

    ArrayList<Employee> empleados = daoImpl.getAllEmployees();
    ArrayList<Office> oficinas = daoOfficeImpl.getAllOffices();

    request.setAttribute("empleados", empleados);
    request.setAttribute("oficinas", oficinas);

    request.getRequestDispatcher("/WEB-INF/view/admin/addempleado.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int numEmpleado = Integer.parseInt(request.getParameter("employeeNumber"));
    String nombre = request.getParameter("firstName");
    String apellido = request.getParameter("firstName");
    String extension = request.getParameter("extension");
    String puesto = request.getParameter("jobTitle");
    String mail = request.getParameter("mail");
    int oficina = Integer.parseInt(request.getParameter("officeCode"));
    int jefe = Integer.parseInt(request.getParameter("jefe"));

    if (numEmpleado >= 0
        && jefe >= 0
        && nombre != null
        && apellido != null
        && extension != null
        && puesto != null
        && oficina >= 0) {
      Employee empleado = new Employee();
      DAOEmployeeImpl daoImpl = new DAOEmployeeImpl();
      System.out.println();
      empleado.setEmployeeNumber(numEmpleado);
      empleado.setLastName(apellido);
      empleado.setFirstName(nombre);
      empleado.setExtension(extension);
      empleado.setEmail(mail);
      empleado.setOfficeCode(oficina);
      empleado.setReportsTo(jefe);
      empleado.setJobTitle(puesto);

      if (daoImpl.insertEmployee(empleado)) {
        logger.info(
            "Se ha añadido el empleado " + empleado.getFirstName() + " " + empleado.getLastName());
      } else {
        logger.error(
            "No se ha podido añadir el empleado "
                + empleado.getFirstName()
                + " "
                + empleado.getLastName());
      }

      response.sendRedirect(request.getContextPath() + "/Admin/Empleados");
    }
  }
}
