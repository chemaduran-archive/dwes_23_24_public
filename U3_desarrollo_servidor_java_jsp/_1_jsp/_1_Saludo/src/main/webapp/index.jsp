<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Introduce tu nombre</title>
</head>
<body>
<h1>Introduce tu nombre y te saludaremos</h1>
<form action="saludo.jsp" method="post">
    <p>
        <label for="nombre"><b>Nombre:</b></label>
        <input type="text" name="nombre" id="nombre" required/>
    </p>
    <p>
        <input type="submit" value="Saludar">
    </p>
</form>
</body>
</html>