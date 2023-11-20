<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmación de la matriculación</title>
    <jsp:include page="bootstrap.jsp"></jsp:include>

</head>
<body>
<jsp:include page="barra.jsp"></jsp:include>
<div class="container">
    <div class="row mt-5 justify-content-center">
        <div class="col-4 fs-2">
            <p><span class="fw-bold">Nombre:</span><%= ((String) session.getAttribute("nombre")) %>
            </p>
            <p><span class="fw-bold">Apellidos:</span><%= ((String) session.getAttribute("apellidos")) %>
            </p>
            <p><span class="fw-bold">Email:</span><%= ((String) session.getAttribute("email")) %>
            </p>
            <p><span class="fw-bold">Curso:</span><%= (String) request.getAttribute("curso") %>
            </p>
            <h4>Módulos</h4>
            <ul>

                <%
                    String[] modulos = (String[]) session.getAttribute("modulos");
                    if (modulos.length == 0) {
                %>

                <li>No hay módulos seleccionados</li>
                l

                <%
                } else {
                %>
                <% for (int i = 0; i < modulos.length; i++) { %>
                <li><%= modulos[i] %>
                </li>
                <% } %>
                <%
                    }
                %>

            </ul>
        </div>
    </div>
</div>
</body>
</html>