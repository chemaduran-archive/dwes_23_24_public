package velazquez._examen_trimestral.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._examen_trimestral.dao.DAOUsuarioImpl;
import velazquez._examen_trimestral.model.Usuario;
import velazquez._examen_trimestral.utils.PasswordHashGenerator;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (email != null && password != null) {
      DAOUsuarioImpl dao = new DAOUsuarioImpl();
      Usuario user = dao.getUsuario(email);

      if (user != null) {
        if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
          HttpSession sesion = request.getSession();

          sesion.setAttribute("usuario", user.getUsuario());
          sesion.setAttribute("email", user.getEmail());
          sesion.setAttribute("nombre", user.getFirstName());
          sesion.setAttribute("apellido", user.getLastName());
          sesion.setAttribute("role", user.getRole());

          if ("admin".equals(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/Home");
            logger.info("El Admin a entrado en sesion");
          } else {
            response.sendRedirect(request.getContextPath() + "/Home");
            logger.info("El usuario a entrado en sesion");
          }

        } else {

          request.setAttribute("error", "login inválido");
          doGet(request, response);
          return;
        }
      } else {
        request.setAttribute("error", "Usuario no existente");
        doGet(request, response);
        return;
      }
    }
  }
}
