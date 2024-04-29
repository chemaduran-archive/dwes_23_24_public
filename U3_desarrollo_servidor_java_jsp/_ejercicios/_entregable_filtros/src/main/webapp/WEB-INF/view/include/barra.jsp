<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.usuario!=null}">
    <div class="container-fluid">
        <div class="row justify-content-end">
            <div class="col p-0">
                <p class="bg-primary text-white p-2 text-left">
                    <c:choose>
                        <c:when test="${sessionScope.role == 'usuario'}">
                            <a href="${pageContext.request.contextPath}/Oficinas" class="link-light">Buscar Oficinas</a>
                        </c:when>
                        <c:when test="${sessionScope.role == 'admin'}">
                            <a href="${pageContext.request.contextPath}/Admin/Inicio" class="link-light">Lista
                                Productos</a>
                        </c:when>
                    </c:choose>
                </p>
            </div>
            <div class="col p-0 text-right text-end">
                <p class="bg-primary text-white p-2 text-right">Está usted logeado como:
                        <c:out value="${sessionScope.nombre} ${sessionScope.apellido}"/>
                    <a class="text-white" href="${pageContext.request.contextPath}/LogOut">Salir</a>
            </div>
        </div>
    </div>
</c:if>