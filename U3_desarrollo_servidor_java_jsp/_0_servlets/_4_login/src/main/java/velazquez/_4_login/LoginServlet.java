package velazquez._4_login;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

  public void init() {}

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();

    // Establezco configuraciones para la respuesta
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    // Presentamos el formulario
    out.println("<html>");
    out.println("<head><title>Ejemplo de Login</title></head>");
    out.println("<body>");
    out.println("<h1>Introduce los datos para el acceso</h1>");

    // Si vengo de un error tendré algún valor en ese atributo de la petición
    if (request.getAttribute("error") != null && ((boolean) request.getAttribute("error"))) {
      out.println("<p style=color:red>Datos erróneos</p>");
    }

    out.println("<form method=\"post\">");
    out.println("<label for=\"usuario\">Usuario</label>");
    out.println("<input type=\"text\" name=\"usuario\" id=\"nombre\" required>");
    out.println("<label for=\"password\">Contraseña</label>");
    out.println("<input type=\"password\" name=\"password\" id=\"password\" required>");
    out.println("<input type=\"submit\" value=\"Entrar\">");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

    out.close();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    PrintWriter out = response.getWriter();

    // Establezco configuraciones para la respuesta
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    // Obtenemos los parámetros
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");

    if (usuario.equals("admin") && password.equals("admin")) {
      out.println("<h1>Acceso concedido</h1>");
    } else {
      // Añado un valor a la petición, así no tengo que pintar de nuevo el formulario
      request.setAttribute("error", true);
      doGet(request, response);

      // Presentamos el formulario
      // Estoy repitiendo código
//      			out.println("<html>");
//      			out.println("<head><title>Ejemplo de Login</title></head>");
//      			out.println("<body>");
//      			out.println("<h1>Introduce los datos para el acceso</h1>");
//      			out.println("<p style=color:red>Datos erróneos</p>");
//      			out.println("<form method=\"post\">");
//      			out.println("<label for=\"usuario\">Usuario</label>");
//      			out.println("<input type=\"text\" name=\"nombre\" id=\"nombre\">");
//      			out.println("<label for=\"password\">Contraseña</label>");
//      			out.println("<input type=\"password\" name=\"password\" id=\"password\">");
//      			out.println("<input type=\"submit\" value=\"Entrar\">");
//      			out.println("</form>");
//      			out.println("</body>");
//      			out.println("</html>");
    }
    out.close();
  }

}
