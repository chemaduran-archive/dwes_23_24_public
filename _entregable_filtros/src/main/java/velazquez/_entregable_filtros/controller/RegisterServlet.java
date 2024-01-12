package velazquez._entregable_filtros.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import velazquez._entregable_filtros.dao.DAOUsuarioImpl;
import velazquez._entregable_filtros.models.Usuario;
import velazquez._entregable_filtros.utils.PasswordHashGenerator;

import java.io.IOException;

@WebServlet("/RegisterServlet")
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
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    DAOUsuarioImpl daoUser = new DAOUsuarioImpl();

    // Comprobamos que los parámetros no son nulos
    if (usuario != null
        && email != null
        && password != null
        && firstName != null
        && lastName != null) {

      if (daoUser.getUsuario(usuario) != null) {
        request.setAttribute("error", "Usuario existente");
        doGet(request, response);
        return;
      } else {
        password = PasswordHashGenerator.hashPassword(password);
        Usuario user = new Usuario(usuario, password, email, firstName, lastName, "usuario");
        daoUser.registerUsuario(user);
      }
    }
    response.sendRedirect(request.getContextPath());
  }
}
