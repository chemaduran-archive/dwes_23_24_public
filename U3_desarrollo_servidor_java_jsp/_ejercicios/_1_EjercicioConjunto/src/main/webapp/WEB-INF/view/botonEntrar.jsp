<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ejercicio conjunto</title>
</head>
<body>

<c:if test="${sessionScope.LOGUEADO==null}">
    <form method="post">
        <button id="boton_entrar" name="boton_entrar" value="Entrar">ENTRAR</button>
    </form>
</c:if>

<c:if test="${sessionScope.LOGUEADO!=null}">
    <form>
        <button id="boton_salir" name="boton_salir" value="Salir"
                formaction="${pageContext.request.contextPath}/ServletLogout">SALIR
        </button>
    </form>
</c:if>

</body>
</html>