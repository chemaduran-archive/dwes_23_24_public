package velazquez._ej_crud;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "start", value = "/crud/start")
public class Start extends HttpServlet {



  public void init() {}

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf8");

    PrintWriter out = resp.getWriter();

    out.println("<html>");
    out.println("<head><title>CRUD - START</title></head>");
    out.println("<body>");
    out.println("<h1>Employee operations</h1><br />");
    //  Crear empleado
    out.println("<a href=\"create-employee\">Create employee</a><br />");
    //  Leer empleado
    out.println("<a href=\"read-employee\">Read employee</a><br />");
    //  Modificar empleado
    out.println("<a href=\"update-employee\">Update employee</a><br />");
    //  Eliminar empleado
    out.println("<a href=\"delete-employee\">Delete employee</a><br />");
  }

  public void destroy() {}
}
