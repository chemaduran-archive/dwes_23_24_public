<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Examen trimestral</title>
</head>
<body>
<div class="container mt-5">
    <div class="col-12 text-end">
        <p class="bg-primary text-white p-2">
            <a class="text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
            <a class="text-white"
               href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar
                Empleados</a> <a class="text-white"
                                 href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir
            Empleado</a> <span>Zona de administracion</span> <a class="text-white"
                                                                href="${pageContext.request.contextPath}/LogOut">Salir</a>
        </p>
    </div>
    <div class="row justify-content-center">
        <div class="col-6">
            <form method="post">
                <label for="employeeNumber" class="form-label mt-3">Numero de Empleado</label>
                <input type="text" class="form-control" id="employeeNumber" name="employeeNumber" required>

                <label for="lastName" class="form-label mt-3">Apellidos</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>

                <label for="firstName" class="form-label mt-3">Nombre</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>

                <label for="extension" class="form-label mt-3">Extension</label>
                <input type="text" class="form-control" id="extension" name="extension" required>

                <label for="mail" class="form-label mt-3">Email</label>
                <input type="text" class="form-control" id="mail" name="mail" required>

                <label for="jobTitle" class="form-label mt-3">Puesto</label>
                <input type="text" class="form-control" id="jobTitle" name="jobTitle" required>

                <label for="officeCode" class="form-label mt-3">Oficina</label>
                <select class="form-select" id="officeCode" name="officeCode">
                    <c:forEach items="${oficinas}" var="o">
                        <option value="${o.officeCode}">${o.city}</option>
                    </c:forEach>
                </select>

                <label for=jefe class="form-label mt-3">Jefe</label>
                <select class="form-select" id="jefe" name="jefe">
                    <c:forEach items="${empleados}" var="e">
                        <option value="${e.employeeNumber}">${e.firstName} ${e.lastName}</option>
                    </c:forEach>
                </select>

                <input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>