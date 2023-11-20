package velazquez._1_ejerciciotema3a.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Servlet implementation class MatricularServlet */
@WebServlet("/MatricularServlet")
public class MatricularServlet extends HttpServlet {

  static final Logger logger = LoggerFactory.getLogger(MatricularServlet.class);
  private static final long serialVersionUID = 1L;

  public MatricularServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    logger.info("MatricularServlet - dentro del get");
    // Obtenemos la sesión
    HttpSession sesion = request.getSession();

    // Compruebo si existe sesión
    if (!sesion.isNew()
        && sesion.getAttribute("LOGEADO") != null
        && ((boolean) sesion.getAttribute("LOGEADO"))) {
      // Obtengo el valor de la Cookie que me interesa (curso)
      Cookie[] cookies = request.getCookies();
      // Recorro las cookies hasta obtener la que estoy buscando
      for (Cookie c : cookies) {
        if (c.getName().equals("curso")) {
          request.setAttribute("curso", c.getValue().equals("primero") ? "1º DAW" : "2º DAW");
        }
      }
      request.getRequestDispatcher("matricular.jsp").forward(request, response);
      return;
    }
    // Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
    logger.error("Intento de entrar en Matricular sin tener sesión");
    sesion.invalidate();
    response.sendRedirect(request.getContextPath());
  }
}
