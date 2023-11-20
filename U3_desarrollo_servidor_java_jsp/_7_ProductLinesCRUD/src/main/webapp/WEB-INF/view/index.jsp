<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>	
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div col="3">
				<img class="img-fluid" src="img/coche.jpeg">
			</div>
		</div>
		<div class="row justify-content-end">
			<div class="col-2">
				<a href="CreateCategoria" class="btn btn-primary">Añadir Categoría</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-11">
				<table class="table table-striped table-hover">
					<thead>
						<th>ProductLine</th>
						<th>Text Description</th>
						<th>HTML Description</th>
						<th>Acciones</th>	
					</thead>
					<tbody>
						<c:forEach items="${categorias}" var="categoria">
							<tr>
								<td>${categoria.productLine}</td>
								<td>${categoria.textDescription}</td>
								<td>${categoria.htmlDescription}</td>								
								<td><a href="UpdateCategoria?pl=${categoria.productLine}"><i class="bi bi-pencil-fill"></i></a>
									<a href="RemoveCategoria?pl=${categoria.productLine}"><i class="bi bi-trash-fill"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>