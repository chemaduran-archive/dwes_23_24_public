<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:useBean id="matriculaBean" scope="session" class="velazquez._1_ejercicioconjunto.Model.MatriculaBean" />
    <h2>Nombre: ${matriculaBean.getNombre()} </h2>
    <h2>Apellidos: ${matriculaBean.getApellidos()} </h2>
    <h2>Email: ${matriculaBean.getEmail()}</h2>
    <h2>Curso: ${matriculaBean.getCurso()}</h2>
    <ul id="asignaturas">

    <c:forEach var="item" items="${matriculaBean.getAsignaturas()}">
        <li>${item}</li>
    </c:forEach>

    </ul>
</body>
</html>
