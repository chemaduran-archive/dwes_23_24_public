package velazquez._entregable_filtros.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.dao.DAOUsuarioImpl;
import velazquez._entregable_filtros.models.Usuario;
import velazquez._entregable_filtros.utils.PasswordHashGenerator;

@WebServlet("/MainServlet")
public class InicioServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(InicioServlet.class);
  private static final long serialVersionUID = 1L;

  public InicioServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Comprobamos si tenemos los datos de la petición del formulario
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");

    if (usuario != null && password != null) {

      DAOUsuarioImpl dao = new DAOUsuarioImpl();

      Usuario user = dao.getUsuario(usuario);

      if (user != null) {
        if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {

          HttpSession sesion = request.getSession();

          sesion.setAttribute("usuario", user.getUsuario());
          sesion.setAttribute("email", user.getEmail());
          sesion.setAttribute("nombre", user.getFirstName());
          sesion.setAttribute("apellido", user.getLastName());
          sesion.setAttribute("role", user.getRole());

          logger.info("El usuario ha entrado en sesion");

          if ("admin".equals(user.getRole())) {
            logger.info("Usuario con rol admin");
            response.sendRedirect("Admin/Inicio");
            return;
          } else {
            logger.info("Usuario con rol user");
            response.sendRedirect("Oficinas");
          }

        } else {
          logger.info("Login no válido");
          request.setAttribute("error", "login inválido");
          doGet(request, response);
        }
      } else {
        logger.info("Usuario inexistente");
        request.setAttribute("error", "Usuario inexistente");
        doGet(request, response);
      }
    }
  }
}
