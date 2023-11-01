package velazquez._2_loginlogoutsessions.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import velazquez._2_loginlogoutsessions.model.UsuarioBean;

import java.io.IOException;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public UsuarioServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession sesion = request.getSession();

    if (!sesion.isNew()) {
      UsuarioBean usuario = (UsuarioBean) sesion.getAttribute("usuario");
      if (usuario != null && usuario.getNombre().equals("normal")) {
        request.setAttribute("usuariobean", usuario);
        request.getRequestDispatcher("usuario.jsp").forward(request, response);
        return;
      }
    }
    sesion.invalidate();
    response.sendRedirect(request.getContextPath());
  }
}
