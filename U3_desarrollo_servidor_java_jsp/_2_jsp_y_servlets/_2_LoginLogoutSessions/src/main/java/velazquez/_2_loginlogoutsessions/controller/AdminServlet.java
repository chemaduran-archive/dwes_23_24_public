package velazquez._2_loginlogoutsessions.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import velazquez._2_loginlogoutsessions.model.UsuarioBean;

import java.io.IOException;

/** Servlet implementation class AdminServlet */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AdminServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    if (!session.isNew()) {
      UsuarioBean usuario = (UsuarioBean) session.getAttribute("usuario");
      if (usuario != null && usuario.getNombre().equals("admin")) {
        request.setAttribute("usuariobean", usuario);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
        return;
      }
    }
    session.invalidate();
    response.sendRedirect(request.getContextPath());
  }
}
