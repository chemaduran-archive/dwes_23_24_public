<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo EL</title>
</head>
<body>

	<c:if test="${tren.maquinista.nombre eq 'Pepe'}">
		<p style="color:red">${tren.maquinista.nombre}</p>
	</c:if>

	<p>${tren.maquinista.nombre}</p>
	<p>${tren.maquinista.apellidos}</p>
	<p>${tren["maquinista"]["nombre"]}</p>
	<p>${tren.vagones[0].longitud}</p>
	<ul>
		<c:forEach items="${tren.vagones}" var="item" >
			<li>Longitud:${item.longitud} Capacidad:${item.capacidad}</li>
		</c:forEach>
	</ul>
	
</body>
</html>