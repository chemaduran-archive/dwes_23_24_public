<%--
  Created by IntelliJ IDEA.
  User: jgdur
  Date: 08/11/2023
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
        <label>
            Nombre
            <input id="Nombre" type="text" name="Nombre">
        </label>
        <br>
        <label >
            Apellidos
            <input id="Apellidos" type="text" name="Apellidos">
        </label>
        <br>
        <label for="Email">
            Email
            <input id="Email" type="text" name="Email">
        </label>
        <br>
        <span>Primer curso:</span>
        <label>
            1º DAW
            <input id="1º DAW" type="radio" name="Curso" value="1º DAW">
        </label>
        <label>
            2º DAW
            <input id="2º DAW" type="radio" name="Curso" value="2º DAW">
        </label>
        <br>
        <select name="asignaturas" id="asig" multiple>
            <option value="lenguajeDeMarcas">Lenguaje de marcas</option>
            <option value="programacion">Programación</option>
            <option value="baseDeDatos">Bases de datos</option>
            <option value="entornosDeDesarrollo">Entornos de desarrollo</option>
        </select>
        <br>
        <input type="submit" value="Enviar datos">
    </form>
</body>
</html>
