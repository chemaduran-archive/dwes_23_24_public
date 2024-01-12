package velazquez._examen_trimestral.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LogOutServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(LogOutServlet.class);
  private static final long serialVersionUID = 1L;

  public LogOutServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession sesion = request.getSession();

    sesion.invalidate();

    response.sendRedirect(request.getContextPath());
    logger.info("Ha salido de la sesion");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
