<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles pedido</title>
<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-10">
				<h1 class="bg-primary text-white text-center mb-5">DETALLE DEL PEDIDO ${pedido.orderNumber}</h1>					
				<ul>
					<c:forEach items="${pedido.getOrderDetails()}" var="detalle">
						<li>${detalle.product.productName}:${detalle.quantityOrdered} X ${detalle.priceEach} = <fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${detalle.quantityOrdered*detalle.priceEach}" />  
					</c:forEach>	
				</ul>
				<h1 class="bg-primary text-white text-center mt-3" >TOTAL: 
					<fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${pedido.getTotal()}" />
				</h1>
			</div>
		</div>
	</div>
</body>
</html>