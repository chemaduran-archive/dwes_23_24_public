<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
    <title>Lista de Oficinas</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-10">
            <h1 class="bg-primary text-white text-center">Lista de oficinas - POOLDB como clase</h1>
            <table class="table table-stripped table-hover">
                <thead>
                <tr class="table-dark">
                    <th>OfficeCode</th>
                    <th>City</th>
                    <th>AddressLine</th>
                    <th>State</th>
                    <th>Country</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${oficinas}" var="oficina">
                    <tr>
                        <td>${oficina.officeCode}</td>
                        <td>${oficina.city}</td>
                        <td>${oficina.addressLine1}</td>
                        <td>${oficina.state}</td>
                        <td>${oficina.country}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h1 class="bg-primary text-white text-center">Lista de oficinas - POOLDB desde el contexto</h1>
            <table class="table table-stripped table-hover">
                <thead>
                <tr class="table-dark">
                    <th>OfficeCode</th>
                    <th>City</th>
                    <th>AddressLine</th>
                    <th>State</th>
                    <th>Country</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${oficinasContexto}" var="oficina">
                    <tr>
                        <td>${oficina.officeCode}</td>
                        <td>${oficina.city}</td>
                        <td>${oficina.addressLine1}</td>
                        <td>${oficina.state}</td>
                        <td>${oficina.country}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>