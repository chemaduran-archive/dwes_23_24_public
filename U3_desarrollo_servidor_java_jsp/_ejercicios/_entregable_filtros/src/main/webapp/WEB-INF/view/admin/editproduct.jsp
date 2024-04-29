<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar producto</title>
</head>
<body>

<div class="container mt-5">
    <jsp:include page="../include/barra.jsp"/>
    <div class="row justify-content-center">
        <div class="col-6 mt-5">
            <form method="post">
                <label class="form-label">ProductCode</label>
                <input name="productCode" value="${producto.productCode}" type="text" class="form-control"
                       id="productCode" readonly>

                <label class="form-label">ProductName</label>
                <input name="productName" value="${producto.productName}" type="text" class="form-control"
                       id="productName">

                <label class="form-label">productLine </label>
                <select name="productLine" class="form-control" id="productLine">
                    <c:forEach items="${productLines}" var="productLine">
                        <option value="${productLine.productLine}" ${productLine.productLine == producto.productLine ? 'selected' : ''}>
                                ${productLine.productLine}
                        </option>
                    </c:forEach>
                </select>

                <label>ProductScale</label>
                <input name="productScale" value="${producto.productScale}" type="text" class="form-control"
                       id="productScale">

                <label>ProductVendor</label>
                <input name="productVendor" value="${producto.productVendor}" type="text" class="form-control"
                       id="productVendor">

                <label>ProductDescription</label>
                <textarea name="productDescription" class="form-control" id="productDescription">
                    ${producto.productDescription}
                </textarea>

                <label class="form-label">quantityInStock</label>
                <input name="quantityInStock" value="${producto.quantityInStock}" type="text" class="form-control"
                       id="quantityInStock">

                <label class="form-label">buyPrice </label>
                <input name="buyPrice" value="${producto.buyPrice}" type="text" class="form-control" id="buyPrice">

                <label class="form-label">MSRP</label>
                <input name="msrp" value="${producto.msrp}" type="text" class="form-control" id="msrp">

                <input type="submit" value="Actualizar" class="btn btn-primary w-100 mt-5">

            </form>

        </div>
    </div>

</div>
</body>
</html>