package velazquez._1_ejerciciotema3a.controller;

import java.io.IOException;
import java.util.regex.Pattern;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {

  static final Logger logger = LoggerFactory.getLogger(SeleccionServlet.class);
  private static final long serialVersionUID = 1L;
  // Atributos necesarios para validar el correo electrónico que nos viene del formulario
  private static final String EMAIL_REGEX =
      "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" + "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

  public SeleccionServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    logger.info("SeleccionServlet - dentro del get");
    // Obtenemos la sesión
    HttpSession sesion = request.getSession();
    // Compruebo si existe sesión
    if (!sesion.isNew()
        && sesion.getAttribute("LOGEADO") != null
        && ((boolean) sesion.getAttribute("LOGEADO"))) {
      // Existe la sesion hago forward a la vista
      request.getRequestDispatcher("seleccionar.jsp").forward(request, response);
      return;
    }
    // Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
    logger.error("Intento de entrar en Seleccionar sin tener sesión");
    // No tengo sesion.
    sesion.invalidate();
    response.sendRedirect(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    logger.info("SeleccionServlet - dentro del post");
    // Obtenemos la sesión
    HttpSession sesion = request.getSession();
    // Antes de obtener los acentos me aseguro de que no voy a perder caracteres
    request.setCharacterEncoding("UTF-8");
    // Compruebo si existe sesión
    if (!sesion.isNew()
        && sesion.getAttribute("LOGEADO") != null
        && ((boolean) sesion.getAttribute("LOGEADO"))) {
      // Compruebo que todos los campos requeridos están en los parámetros del formulario
      // y válido que el campo del correo electrónico no es válido
      // Sería correcto sacar esta validación a una función
      if (request.getParameter("nombre") != null
          || request.getParameter("apellidos") != null
              && request.getParameter("email") != null
              && request.getParameter("curso") != null
              && request.getParameter("modulos") != null
              && EMAIL_PATTERN.matcher(request.getParameter("email")).matches()) {
        // Meto los valores en sesión o en cookies
        sesion.setAttribute("nombre", request.getParameter("nombre"));
        sesion.setAttribute("apellidos", request.getParameter("apellidos"));
        sesion.setAttribute("email", request.getParameter("email"));
        sesion.setAttribute("curso", request.getParameter("curso"));
        sesion.setAttribute("modulos", request.getParameterValues("modulos"));
        logger.error("Redireccionando a MatricularServlet");
        // Añado la cookie que debo crear
//        Cookie cookie = new Cookie("curso", request.getParameter("curso"));
//        response.addCookie(cookie);
        // Redirecciono el flujo de trabajo
        response.sendRedirect(request.getContextPath() + "/MatricularServlet");
        return;
      } else {
        // Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
        logger.error("Faltan parámetros o el email es incorrecto");
        response.sendRedirect(request.getContextPath() + "/SeleccionarServlet");
        return;
      }
    }
    // Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
    logger.error("Intento de entrar en Seleccionar sin tener sesión");
    // No tengo sesion.
    sesion.invalidate();
    response.sendRedirect(request.getContextPath());
  }
}
