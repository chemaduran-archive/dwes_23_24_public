package velazquez._1_filtros_dd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public InicioServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Saco los parámetros a variables para mejorar la legibilidad
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");

    // Check if the value are not null
    if (usuario != null && password != null) {

      // Comprobamos que los datos de Login son los correctos
      if (("admin".equals(usuario) && "admin".equals(password))
          || (("usuario".equals(usuario) && "usuario".equals(password)))) {

        // Creo la sesión y la relleno correctamente
        HttpSession sesion = request.getSession();

        sesion.setAttribute("usuario", usuario);

        response.sendRedirect(
            "admin".equals(usuario)
                ? request.getContextPath() + "/Admin"
                : request.getContextPath() + "/Usuario");
        return;
      }
    }
    // Vuelvo al Login con un GET, pero añado un mensaje de error
    request.setAttribute("error", "Datos incorrectos");
    doGet(request, response);
  }
}
