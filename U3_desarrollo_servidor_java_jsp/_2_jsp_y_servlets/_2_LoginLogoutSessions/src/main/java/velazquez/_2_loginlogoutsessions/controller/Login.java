package velazquez._2_loginlogoutsessions.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import velazquez._2_loginlogoutsessions.model.UsuarioBean;

import java.io.IOException;

public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Login() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");
    HttpSession sesion;

    if (usuario.equals("admin") && password.equals("admin")) {
      sesion = request.getSession();
      UsuarioBean user = new UsuarioBean();
      user.setNombre(usuario);
      sesion.setAttribute("usuario", user);
      response.sendRedirect("AdminServlet");
    } else if (usuario.equals("normal") && password.equals("normal")) {
      sesion = request.getSession();
      UsuarioBean user = new UsuarioBean();
      user.setNombre(usuario);
      sesion.setAttribute("usuario", user);
      response.sendRedirect("UsuarioServlet");
    } else {
      response.sendRedirect("Login");
    }
  }
}
