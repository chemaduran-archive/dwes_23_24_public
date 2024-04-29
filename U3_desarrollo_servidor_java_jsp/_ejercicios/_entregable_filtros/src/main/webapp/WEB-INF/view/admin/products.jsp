<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
</head>
<body>

<div class="container">
    <jsp:include page="../include/barra.jsp"/>
    <div class="row justify-content-center">

        <div class="col-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Categoría</th>
                    <th>Stock</th>
                    <th>Precio</th>
                    <th>Acción</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productos}" var="producto">
                    <tr>
                        <td>${producto.productCode}</td>
                        <td>${producto.productName}</td>
                        <td>${producto.productLine}</td>
                        <td>${producto.quantityInStock}</td>
                        <td>${producto.buyPrice}</td>
                        <td><a href="EditarProduct?pc=${producto.productCode}"><i class="bi bi-pencil"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>