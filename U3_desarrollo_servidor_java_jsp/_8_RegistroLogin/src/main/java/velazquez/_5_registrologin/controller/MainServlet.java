package velazquez._5_registrologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import velazquez._5_registrologin.bd.DBConnection;
import velazquez._5_registrologin.dao.DAOUsuarioImpl;
import velazquez._5_registrologin.model.Usuario;
import velazquez._5_registrologin.utils.PasswordHashGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class MainServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(MainServlet.class);
  private static final long serialVersionUID = 1L;

  public MainServlet() {
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
        logger.info("Usuario encontrado: " + user.getUsuario());
        logger.info("Password DB: " + user.getPassword());
        logger.info("Password Request: " + password);
        if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {

          HttpSession sesion = request.getSession();

          sesion.setAttribute("usuario", user.getUsuario());
          sesion.setAttribute("email", user.getEmail());
          sesion.setAttribute("role", user.getRole());

          if ("admin".equals(user.getRole())) {
            response.sendRedirect("Admin/");
          } else {
            response.sendRedirect("Search");
          }
        } else {
          request.setAttribute("error", "login inválido");
          doGet(request, response);
          return;
        }
      } else {
        request.setAttribute("error", "Usuario no existente");
        doGet(request, response);
      }
    }
  }
}
