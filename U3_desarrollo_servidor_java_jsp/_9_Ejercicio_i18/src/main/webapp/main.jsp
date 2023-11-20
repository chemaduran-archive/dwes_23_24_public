<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="interface"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Principal</title>
    <jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

<div class="container">
    <div class="row justify-content-center mt-5">
        <% if (!session.isNew() && session.getAttribute("LOGEADO") != null &&
                ((boolean) session.getAttribute("LOGEADO"))) { %>

        <!-- ELEMENTOS DE LA PÁGINA QUE SE SACAN SI ESTAMOS LOGEADOS -->
        <div class="col-3">
            <a href="<%= request.getContextPath()+"/Logout" %>"><input
                    type="button" class="btn btn-primary w-100" value="SALIR"></a>
        </div>

        <% } else { %>

        <!-- ELEMENTOS DE LA PÁGINA QUE SE SACAN SI NO ESTAMOS LOGEADOS -->
        <div class="col-3">
            <form method="post">
                <input name="entrar" type="submit" class="btn btn-primary w-100"
                       value="<fmt:message key="entrar"/>"/>
            </form>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>