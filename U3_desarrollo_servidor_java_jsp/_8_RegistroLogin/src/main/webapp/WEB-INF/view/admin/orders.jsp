<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de pedidos</title>
<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-stripped">
					<thead>
						<tr>
							<th>Número</th>
							<th>Fecha</th>
							<th>Fecha envío</th>
							<th>Estado</th>
							<th>Total</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${pedidos}" var="pedido">
							<tr>
							<td>${pedido.orderNumber}</td>
							<td>${pedido.orderDate}</td>
							<td>${pedido.shippedDate}</td>
							<td>${pedido.status}</td>
							<td><fmt:formatNumber type = "number" 
								maxFractionDigits = "2" value ="${pedido.getTotal()}" />
							</td>
							<td><a href="OrderDetails?on=${pedido.orderNumber}"><i class="bi bi-eye-fill"></i></a></td>
							<tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>