package velazquez._3_ejemplo_post;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class EjemploPost extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Muestro un formulario para recoger nombre y apellidos del usuario
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>");
        out.println("Ejemplo de gestión de peticiones POST desde el Servlet");
        out.println("</title></head>");
        out.println("<body>");
        out.println("<h1>Formulario</h1>");
        out.println(
                "<p>El formulario se mostrará la primera vez cuando se haya realizado una petición GET al servlet</p>");

        out.println("<form method=\"post\">");
        out.println("<label for=\"nombre\">Nombre:</label><input id=\"nombre\" type=\"text\" name=\"nombre\"><br>");
        out.println(
                "<label for=\"apellidos\">Apellidos:</label><input id=\"apellidos\" type=\"text\" name=\"apellidos\"><br>");
        out.println("<button type=\"submit\" name=\"submit\">Enviar</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Enumeration<String> paramEnumeration = request.getParameterNames();

        if (paramEnumeration.hasMoreElements()) {
            out.println("<html>");
            out.println("<head><title>");
            out.println("Ejemplo de gestión de peticiones POST desde el Servlet");
            out.println("</title></head>");
            out.println("<body>");

            // Comienzo de la lista de parámetros
            out.println("<h1>Los datos del formulario son los siguientes</h1>");
            out.println("<ul>");
            while (paramEnumeration.hasMoreElements()) {
                String param = paramEnumeration.nextElement();
                out.write("<li>He recibido el parámetro " + param + " con el siguiente valor: "
                        + request.getParameter(param) + "</li>");
            }

            // Fin de la lista de parámetros
            out.println("</ul>");
            out.println("</body></html>");
        } else {
            // No hay parámetros en la petición
            out.println("Estoy en una petición post y no he recibido parámetros");
        }
    }

}