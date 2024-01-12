<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Examen trimestral</title>
</head>
<div class="container">

	<div class="col-12 text-end">
		<p class="bg-primary text-white p-2">
			<a class="text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
			<a class="text-white" href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a>
			<a class="text-white" href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a>
			<span>Zona de administracion</span> <a class="text-white"
				href="${pageContext.request.contextPath}/LogOut">Salir</a>
		</p>
	</div>
	<div class="row justify-content-end">
		<div class="col-3">
			<a class="btn btn-primary w-100" href="${pageContext.request.contextPath}/Admin/AddEmpleado">AÑADIR EMPLEADO</a>
		</div>
	</div>
	<div class="row justify-content-center">

		<div class="col-10">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Número</th>
						<th>Apellidos</th>
						<th>Nombre</th>
						<th>Puesto</th>
						<th>Oficina</th>
						<th>Jefe</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${empleados}" var="empleado">
						<tr>
							<td>${empleado.employeeNumber}</td>
							<td>${empleado.lastName}</td>
							<td>${empleado.firstName}</td>
							<td>${empleado.jobTitle}</td>
							<td>${empleado.officeName}</td>
							<td>${empleado.reportsToName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>