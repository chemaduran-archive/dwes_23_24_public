<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Examen trimestral</title>
</head>
<body>
<div class="container">
    <div class="col-12 text-end">
        <p class="bg-primary text-white p-2">
            <a class="text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
            <span>Zona de usuario</span> <a class="text-white"
                                            href="${pageContext.request.contextPath}/LogOut">Salir</a>
        </p>
    </div>
    <div class="row justify-content-center">
        <h1>Productos de la categoria ${productLine}</h1>
        <div class="col-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Fabricante</th>
                    <th>Precio Compra</th>
                    <th>Stock</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productos}" var="producto">
                    <tr>
                        <td>${producto.productName}</td>
                        <td>${producto.productDescription}</td>
                        <td>${producto.productVendor}</td>
                        <td>${producto.buyPrice}</td>
                        <td>${producto.quantityInStock}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p>${error}</p>
        </div>
    </div>
</div>
</body>
</html>