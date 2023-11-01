package velazquez._0_ejemploredirect.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._0_ejemploredirect.model.UsuarioBean;

import java.io.IOException;
import java.io.PrintWriter;

public class EjemploRedirect extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EjemploRedirect() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    if (request.getParameter("destino") != null) {
      if (request.getParameter("destino").equalsIgnoreCase("A")) {
        UsuarioBean usuario = new UsuarioBean();
        usuario.setUsuario("admin");
        usuario.setPassword("admin");
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("a.jsp").forward(request, response);
      } else {
        UsuarioBean usuario = new UsuarioBean();
        usuario.setUsuario("pepe");
        usuario.setPassword("pepe");
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("b.jsp").forward(request, response);
      }
    } else {
      PrintWriter out = response.getWriter();
      out.println("NO SE ADONDE IR");
    }
  }
}
