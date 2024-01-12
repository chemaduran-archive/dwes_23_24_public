<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface"/>
<jsp:include page="include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Examen trimestral</title>
</head>
<body>
<div class="container">
    <c:if test="${sessionScope.role=='admin'}">
        <div class="col-12 text-end">
            <p class="bg-primary text-white p-2">
                <a class="text-white"
                   href="${pageContext.request.contextPath}/Home">Inicio</a> <a
                    class="text-white"
                    href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar
                Empleados</a> <a class="text-white"
                                 href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir
                Empleado</a> <span>Zona de administracion</span> <a class="text-white"
                                                                    href="${pageContext.request.contextPath}/LogOut">Salir</a>
            </p>
        </div>

        <div class="row justify-content-center">
            <div class="col-6">
                <h2>Operaciones disponibles</h2>
                <ul>
                    <li><a
                            href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar
                        Empleados</a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir
                        Empleado</a></li>
                </ul>
            </div>
        </div>

    </c:if>
    <c:if test="${sessionScope.role=='usuario'}">
        <div class="row justify-content-center">
                <p class="bg-primary text-white p-2">
                    <a class="text-white"
                       href="${pageContext.request.contextPath}/Home"><fmt:message
                            key="inicio"/></a> <span><fmt:message key="zona"/></span> <a
                        class="text-white"
                        href="${pageContext.request.contextPath}/LogOut"><fmt:message
                        key="salir"/></a>
                </p>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <h2><fmt:message key="categorias"/></h2>
                <ul>
                    <c:forEach items="${productLineList}" var="pl">
                        <li><a href="MostrarProductos?pl=${pl.productLine}">${pl.productLine}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>