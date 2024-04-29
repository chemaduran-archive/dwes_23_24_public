<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <jsp:include page="../include/bootstrap.jsp"/>
    <title>Oficinas</title>
</head>
<body>
<div class="container mt-5">
    <jsp:include page="../include/barra.jsp"/>
    <div class="row justify-content-center mt-5">
        <div class="col-6">
            <c:if test="${sessionScope.usuario == null}">
                <!-- Solo saco este mensaje si no tengo sesion -->
                <h2 class="text-primary text-center mt-3">
                    Debes estar registrado para acceder a esta página
                </h2>
            </c:if>
            <c:if test="${sessionScope.usuario != null}">
                <%--					Formulario de selección de oficinas, y un botón "Obtener datos" --%>
                <form method="post">
                    <div class="form-group">
                        <c:if test="${not empty listado_oficinas}">
                            <label for="oficina">Oficina</label>
                            <select class="form-control" id="oficina" name="oficinas">
                                <c:forEach items="${listado_oficinas}" var="oficina">
                                    <option value="${oficina.officeCode}">${oficina.city}</option>
                                </c:forEach>
                            </select>
                        </c:if>
                    </div>
                    <button type="submit" class="btn btn-primary">Obtener datos</button>
                </form>
                <c:if test="${not empty oficina}">
                    <h2 class="text-primary text-center mt-3">Datos de la oficina</h2>
                    <ul>
                        <li>
                            <p>Code: <c:out value="${oficina.officeCode}"/></p>
                        </li>

                        <li>
                            <p>Ciudad: <c:out value="${oficina.city}"/></p>
                        </li>

                        <li>
                            <p>Teléfono: <c:out value="${oficina.phone}"/></p>
                        </li>

                        <li>
                            <p>Dirección 1: <c:out value="${oficina.addressLine1}"/></p>
                        </li>

                        <li>
                            <p>Dirección 2: <c:out value="${oficina.addressLine2}"/></p>
                        </li>

                        <li>
                            <p>Estado: <c:out value="${oficina.state}"/></p>
                        </li>

                        <li>
                            <p>País: <c:out value="${oficina.country}"/></p>
                        </li>

                        <li>
                            <p>Código Postal:<c:out value="${oficina.postalCode}"/></p>
                        </li>

                        <li>
                            <p>Territorio: <c:out value="${oficina.territory}"/></p>
                        </li>
                    </ul>
                </c:if>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
