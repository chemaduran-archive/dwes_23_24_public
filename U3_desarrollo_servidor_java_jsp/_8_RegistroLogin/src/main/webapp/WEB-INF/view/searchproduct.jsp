<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda de Productos</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="include/barra.jsp" />
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<form method="post" class="d-flex justify-content-end w-100">
				<input name="busqueda" class="form-control me-2" type="search"
					placeholder="Search" aria-label="Search" required>
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</nav>
		<div class="row justify-content-center">
			<div class="col-8">
				<c:choose>
					<c:when test="${productos!=null and productos.size()>0}">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Nombre</th>
									<th>Categoría</th>
									<th>Descripción</th>
									<th>Precio</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productos}" var="p">
									<tr>
										<td>${p.productName}</td>
										<td>${p.productLine}</td>
										<td>${p.productDescription}</td>
										<td>${p.buyPrice}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:when test="${productos!=null and productos.size()==0}">
						<p class="text-danger">NO HAY RESULTADOS</p>
					</c:when>
				</c:choose>
			</div>

		</div>
	</div>
</body>
</html>