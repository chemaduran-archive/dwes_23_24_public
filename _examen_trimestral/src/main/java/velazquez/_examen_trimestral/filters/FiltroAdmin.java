package velazquez._examen_trimestral.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class FiltroAdmin implements Filter {

  public FiltroAdmin() {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sesion = httpRequest.getSession();
    String usuario = (String) sesion.getAttribute("usuario");
    String role = (String) sesion.getAttribute("role");

    if (!sesion.isNew() && usuario != null && role.equals("admin")) {
      chain.doFilter(request, response);
    } else {
      httpResponse.sendRedirect(httpRequest.getContextPath());
    }
  }
}
