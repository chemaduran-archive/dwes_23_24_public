package velazquez._2_ejemplo_get;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/EjemploGet")
public class EjemploGet extends HttpServlet {

  public void init() {}

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("utf8");

    // Obtengo el elemento para la salida
    PrintWriter out = response.getWriter();

    // Genero la salida de la página
    out.println("");
    out.println("<html>");
    out.println("<head><title></title></head>");
    out.println("Ejemplo de gestión de peticiones GET desde el Servlet");
    out.println("</title></head>");
    out.println("<body>");

    // Si no recibo parámetros muestro un enlace con parámetros en la query
    // También podré obtener un mapa, tengo varias formas de hacerlo
    Enumeration<String> paramEnumeration = request.getParameterNames();

    // Si viene con parámetros, muestra la lista de parámetros
    if (paramEnumeration.hasMoreElements()) {
      // Generamos una lista no ordenada
      out.println("<ul>");
      while (paramEnumeration.hasMoreElements()) {
        // Recorro la lista de parámetros
        String param = paramEnumeration.nextElement();
        out.write(
                "<li>He recibido el parámetro "
                        + param
                        + " con el valor: "
                        + request.getParameter(param)
                        + "</li>");
      }
      out.println("</ul>");
    } else {
      // No hay parámetros en la petición
      out.println(
              "<p><a href=\"?modulo=servidor&profesor=Chema Durán \">Pasando parámetros</a></p>");
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

}
