<%--
  Created by IntelliJ IDEA.
  User: jgdur
  Date: 08/11/2023
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:useBean id="matriculaBean" scope="session" class="Model.MatriculaBean" />
    <h2>Nombre: <%= matriculaBean.getNombre() %></h2>
    <h2>Apellidos: <%= matriculaBean.getApellidos() %></h2>
    <h2>Email: <%= matriculaBean.getEmail() %></h2>
    <h2>Curso: <%= matriculaBean.getCurso() %></h2>
    <ul id="asignaturas">
        <%
            for (String asignatura : matriculaBean.getAsignaturas()){
        %>
                <li><%= asignatura %></li>
        <%
            }
        %>

    </ul>
</body>
</html>
