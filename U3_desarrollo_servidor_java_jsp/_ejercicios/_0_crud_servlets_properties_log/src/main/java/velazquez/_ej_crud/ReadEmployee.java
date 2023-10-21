package velazquez._ej_crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._ej_crud.dao.EmployeesDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "read-employee", value = "/crud/read-employee")
public class ReadEmployee extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf8");

    PrintWriter out = resp.getWriter();

    out.println("<html><body>");
    out.println("<title>Read Employee</title>");
    out.println("<h1>Read Employee</h1>");
    out.println("<form action=\"read-employee\" method=\"POST\">");
    out.println("<input id=\"employee-number\" type=\"text\" name=\"employee-number\">");
    out.println("<button type=\"submit\">Submit</button>");
    out.println("</form>");
    out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    int employeeNumber = Integer.parseInt(req.getParameter("employee-number"));
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf8");

    PrintWriter out = resp.getWriter();
    EmployeesDAOImpl employeesDAO  = new EmployeesDAOImpl();

    out.println("<html><body>");
    out.println("<h1>" + employeesDAO.getEmployeesById(employeeNumber) + "</h1>");
    out.println("</body></html>");
  }

  @Override
  public void destroy() {
    super.destroy();
  }

  @Override
  public void init() throws ServletException {
    super.init();
  }
}
