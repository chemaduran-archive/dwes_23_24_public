<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

    <%
        if (!session.isNew() && (boolean) session.getAttribute("LOGUEADO")) {
    %>
            <form>
                <button id="boton_salir" name="boton_salir" value="Salir" formaction=<%= request.getContextPath()  + "/ServletLogout" %>>SALIR</button>
            </form>
    <%
        } else {
    %>
            <form method="post">
                <button id="boton_entrar" name="boton_entrar" value="Entrar" >ENTRAR</button>
            </form>
    <%
        }
    %>

</body>
</html>