<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de JSP Forward</title>
</head>
<body>
	<% if (request.getMethod().equals("POST")) {
		   if (request.getParameter("usuario").equals("admin") &&
				   request.getParameter("password").equals("admin")) { 
		%>
			<jsp:forward page="admin.jsp" />
		<%} else if (request.getParameter("usuario").equals("usuario") &&
				   request.getParameter("password").equals("usuario"))  {
		
		%>
			<jsp:forward page="usuario.jsp" />
		<% } else { %>
			<p style="color:red">ERROR EN LOGIN</p>
		<% }
	} %>
    
	<form method="post">
		<p><label for="usuario">Usuario</label><input type="text" name="usuario" id="usuario" required></p>
		<p><label for="password">Password</label><input type="password" name="password" id="password" required></p>
		<p><input type="submit" name="submit" value="Entrar"/></p>
	</form>
</body>
</html>