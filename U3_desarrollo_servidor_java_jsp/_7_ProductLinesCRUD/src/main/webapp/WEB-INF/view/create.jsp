<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creación de Categoría</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-8">
				<form method="post">
					<label for="productline" class="form-label">Product Line</label>
    				<input type="text" class="form-control" id="productLine" name="productLine" value="${categoria}" required >
    					<c:if test="${error != null }">
    						<p><small class="text-danger">Categoría ya existente</small></p>
    					</c:if>    					
    				<label for="textDescription" class="form-label mt-3">Text Descriptin</label>
    				<textarea class="form-control" id="textDescription" name="textDescription" required>
    					<c:if test="${error != null }">
    						<c:out value="${texto}" />
    					</c:if>
    				</textarea>
    				<label for="htmlDescription" class="form-label mt-3">HTML Description</label>
    				<textarea class="form-control" id="htmlDescription" name="htmlDescription" required>
    					<c:if test="${error != null }">
    						<c:out value="${html}" />
    					</c:if>
    				</textarea>
    				<input type="submit" value="Insertar" class="btn btn-primary mt-3 w-100" />
    				
				</form>			
			</div>
		</div>
	</div>	
</body>
</html>