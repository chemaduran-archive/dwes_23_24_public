<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<jsp:include page="/WEB-INF/view/includes/bootstrap.jsp"/>
</head>
<body>

	<% if (!session.isNew() && session.getAttribute("usuario")!=null) { %>
		<jsp:include page="/WEB-INF/view/includes/actionBar.jsp" />		
		<div class="container">
			<div class="row justify-content-center mt-5">
				<div class="col-6 mt-5">
					<h1>Bienvenido a la aplicación</h1>
				</div>
			</div>
		</div>
	<% } else { %>
	
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-4">
				<form method="post">
					
					<label for="usuario" class="form-label">Usuario</label>
  					<input name="usuario" id="usuario" type="text" class="form-control" required>	
  					<label for="password" class="form-label mt-3">Password</label>
  					<input name="password" id="password" type="password" class="form-control" required>
  					<% if (request.getAttribute("error")!=null) { %>
						<h6 class="text-danger mt-3"><%=request.getAttribute("error") %></h6>
					<% } %>
  					<input type="submit" class="btn btn-primary w-100 mt-5" value="ENTRAR" >
				</form>				
			</div>
		</div>
	</div>
	
	<% } %>
</body>
</html>