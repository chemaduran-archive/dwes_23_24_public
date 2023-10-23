<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Generación Lista desde JSP</title>
</head>
<body>
<h1>Generación de una lista de manera auto</h1>
<ul>
    <%
        for (int i = 0; i < 10; i++) {
    %>
    <li><%= i %>
    </li>
    <% } %>
</ul>

</body>
</html>