package velazquez._1_ejercicioconjunto.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._1_ejercicioconjunto.controllers.ServletMatricular;

import java.io.IOException;

@WebFilter(servletNames={"SeleccionServlet", "ServletMatricular"})
public class FilterAdmin implements Filter {
  static final Logger log = LoggerFactory.getLogger(ServletMatricular.class);

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest req =  (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;

    HttpSession session = req.getSession();
    if (!session.isNew() && (boolean) session.getAttribute("LOGUEADO")) {
      log.info("Filtrando adecuadamente");
      chain.doFilter(request, response);
    } else {
      log.error("No se ha recibido la sesión adecuada");
      session.invalidate();
      resp.sendRedirect(req.getContextPath());
    }
  }
}
