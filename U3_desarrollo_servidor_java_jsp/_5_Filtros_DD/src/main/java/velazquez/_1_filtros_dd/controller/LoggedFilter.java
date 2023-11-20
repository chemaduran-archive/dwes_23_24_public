package velazquez._1_filtros_dd.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoggedFilter implements Filter {

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sesion = httpRequest.getSession();
    String usuario = (String) sesion.getAttribute("usuario");

    if (!sesion.isNew() && usuario != null && usuario.equals("usuario")) {
      chain.doFilter(request, response);
    } else {

      httpResponse.sendRedirect(httpRequest.getContextPath());
    }
  }
}
