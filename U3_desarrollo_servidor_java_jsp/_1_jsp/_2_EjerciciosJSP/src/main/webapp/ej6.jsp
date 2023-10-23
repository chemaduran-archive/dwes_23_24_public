<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Conversor de euros <-> dolares</title>
</head>
<body>

<form method="post">
    <p><label for="cantidad">Introduce cantidad</label>
        <input type="text" name="cantidad" id="cantidad" required/></p>
    <input type="submit" name="dae" value="DOLARES A EUROS"/>
    <input type="submit" name="ead" value="EUROS A DOLARES"/>
</form>

<%
    if (request.getMethod().equals("POST")) {

        String mensaje;
        Double cantidad;

        if (request.getParameter("dae") != null) {
            cantidad = 0.86 * (Double.parseDouble(request.getParameter("cantidad")));
            mensaje = request.getParameter("cantidad") + " dolares son:" + cantidad + " euros";
        } else {
            cantidad = 1.16 * (Double.parseDouble(request.getParameter("cantidad")));
            mensaje = request.getParameter("cantidad") + " euron son:" + cantidad + " dolares";
        }
%>
<p>
    <%= mensaje %>
</p>
<%
    }
%>

</body>
</html>