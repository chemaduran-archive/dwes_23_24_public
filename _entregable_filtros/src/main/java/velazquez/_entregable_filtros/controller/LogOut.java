package velazquez._entregable_filtros.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(InicioServlet.class);
  private static final long serialVersionUID = 1L;

  public LogOut() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession sesion = request.getSession();

    sesion.invalidate();

    response.sendRedirect(request.getContextPath());
    logger.info("El usuario a salido de la sesion");
  }
}
