<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login con JSP en la misma URL</title>
</head>
<%
    String error = null;

    // Compruebo si vengo de una petición del formulario
    if (request.getMethod().equals("POST") && request.getParameter("submit") != null) {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        if (usuario.equals("admin") && password.equals("admin")) {
            out.println("Bienvenido a la zona de administración");
            return;
        } else {
            // invalid user. Set error message
            error = "Credenciales erróneas. Pruebe de nuevo";
        }
    }
%>
<body>

<h2>Introduzca su usuario y contraseña:</h2>
<!--  Comprueba el mensaje de error por si tengo que mostrarlo -->
<%
    if (error != null) {
%>
<p style="color: red;">
    <%
        out.print(error);
    %>
</p>
<%
    }
%>

<form method="post">
    <p><label for="usuario">Usuario</label><input type="text" name="usuario" id="usuario" required></p>
    <p><label for="password">Password</label><input type="password" name="password" id="pasword" required></p>
    <p><input type="submit" name="submit" value="Entrar"/></p>
</form>

</body>
</html>