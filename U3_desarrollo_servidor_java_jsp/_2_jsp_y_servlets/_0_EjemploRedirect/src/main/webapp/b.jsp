<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>B</title>
</head>
<body>
<h1>HOLA ESTOY EN B</h1>

<jsp:useBean id="usuario" scope="request" class="velazquez._0_ejemploredirect.model.UsuarioBean"/>
<p>Parámetro "destino":<%= (String) request.getParameter("destino") %> </p>
<p>Usuario: <%= usuario.getUsuario() %>
</p>
</body>
</html>