<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saludo JSP</title>
</head>
<body>

<h1>
    Hola: <%=request.getParameter("nombre")%>
</h1>

<a href="<%= application.getContextPath() %>/">Volver atrás</a>

</body>
</html>