<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ejemplo de JSP Forward</title>
</head>
<body>

<% if (request.getParameter("error") != null) {
%>
<p style="color:red"><%= request.getParameter("error") %>
</p>
<% } %>

<form method="post" action="forward.jsp">
    <p><label for="usuario">Usuario</label><input type="text" name="usuario" id="usuario" required></p>
    <p><label for="password">Password</label><input type="password" name="password" id="password" required></p>
    <p><input type="submit" name="submit" value="Entrar"/></p>
</form>
</body>
</html>