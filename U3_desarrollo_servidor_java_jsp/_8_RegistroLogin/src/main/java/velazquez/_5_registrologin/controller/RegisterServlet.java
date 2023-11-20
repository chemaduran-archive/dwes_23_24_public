package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._5_registrologin.dao.DAOUsuarioImpl;
import velazquez._5_registrologin.model.Usuario;
import velazquez._5_registrologin.utils.PasswordHashGenerator;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RegisterServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Vamos a obtener los campos del formulario
    String usuario = request.getParameter("usuario");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    DAOUsuarioImpl dao = new DAOUsuarioImpl();

    // Comprobamos que los parámetros no son nulos
    if (usuario != null && email != null && password != null) {
      if (dao.getUsuario(usuario) != null) {

        request.setAttribute("error", "Usuario existente");
        doGet(request, response);
        return;
      } else {
        password = PasswordHashGenerator.hashPassword(password);
        Usuario user = new Usuario(usuario, password, email, "usuario");
        dao.registerUsuario(user);
      }
    }
    response.sendRedirect(request.getContextPath());
  }
}
