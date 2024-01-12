package velazquez._entregable_filtros.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.controller.OficinasServlet;

import java.io.IOException;

@WebFilter("/Oficinas/*")
public class FiltroUsuario implements Filter {
  static final Logger logger = LoggerFactory.getLogger(FiltroUsuario.class);

  public FiltroUsuario() {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    logger.info("doFilter()");
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sesion = httpRequest.getSession();
    String usuario = (String) sesion.getAttribute("usuario");
    String role = (String) sesion.getAttribute("role");

    if (!sesion.isNew() && usuario != null && role.equals("usuario")) {
      logger.info("El usuario ha entrado en sesion");
      chain.doFilter(request, response);
    } else {
      logger.info("El usuario no ha entrado en sesion");
      httpResponse.sendRedirect(httpRequest.getContextPath());
    }
  }
}
