<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp"/>
<title>Editar Pagos</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<label for="customerNumber mt-3" class="form-label mt-3">CustomerNumber</label>
					<select class="form-select" id="customerNumber" name="customerNumber">
						<c:forEach  items="${customers}" var="c">
							<c:choose>
								<c:when test="${c.customerNumber == pago.customerNumber}">
									<option value="${c.customerNumber}" selected>${c.customerName}-${c.customerNumber}</option>
								</c:when>
								<c:otherwise>
									<option value="${c.customerNumber}">${c.customerName}-${c.customerNumber}</option>
								</c:otherwise>
							</c:choose>							
						</c:forEach>					
					</select>
					<label for="checkNumber" class="form-label mt-3">CheckNumber</label>
    				<input type="text" class="form-control" id="checkNumber" name="checkNumber" value="${pago.checkNumber}" required >	
    				<label for="paymentDate" class="form-label mt-3">Fecha de Pago</label>
    				<input type="date" class="form-control" id="paymentDate" name="paymentDate" value="${pago.date}" required>
    				<label for="amount" class="form-label mt-3">Cantidad</label>
    				<input type="number" class="form-control" id="amount" name="amount" value="${pago.amount}" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>