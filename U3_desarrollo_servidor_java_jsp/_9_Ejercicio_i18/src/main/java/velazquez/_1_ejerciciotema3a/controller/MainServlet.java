package velazquez._1_ejerciciotema3a.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Servlet implementation class Main */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {

  static final Logger logger = LoggerFactory.getLogger(MainServlet.class);
  private static final long serialVersionUID = 1L;
  protected String myParam = null;

  public MainServlet() {
    super();
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.myParam = config.getInitParameter("myParam");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Redirijo al jsp que mostrará distintos elementos dependiendo de si hay sesión o no
    logger.info("MainServlet - dentro del get");
    request.getRequestDispatcher("main.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Compruebo que efectivamente vengo de pulsar el botón ENTRAR
    logger.info("dentro del post");
    logger.info("El valor de entrar es: " + request.getParameter("entrar"));
    Locale locale = request.getLocale();
    logger.info("El locale es: " + locale.getDisplayName());
    ResourceBundle bundle = ResourceBundle.getBundle("interface", locale);
    logger.info("El valor de la clave es: " + bundle.getString("entrar"));

    if (request.getParameter("entrar") != null && request.getParameter("entrar").equalsIgnoreCase(bundle.getString("entrar"))) {
      // Creo la sesión y le voy a añadir una variable booleana para realizar las comprobaciones
      // posteriores
      HttpSession sesion = request.getSession();
      // Logeo que he entrado en sesión
      logger.info("El usuario ha entrado en sesión");
      sesion.setAttribute("LOGEADO", true);
      // Redirijo el flujo de la aplicación al formulario de matriculación
      response.sendRedirect(request.getContextPath() + "/SeleccionServlet");
      return;
    }
    // No vengo de presionar al botón entrar y he recibido un POST. Vuelvo al GET de este mismo
    // Servlet
    response.sendRedirect(request.getContextPath());
  }
}
