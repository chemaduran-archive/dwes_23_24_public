<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.usuario!=null}">
    <div class="row justify-content-end">
        <div class="col-12 text-end">
            <p class="bg-primary text-white p-2"><c:out value="${sessionScope.usuario}"/>
                <a class="text-white" href="${pageContext.request.contextPath}/LogOut"><i
                        class="bi bi-box-arrow-left"></i></a>
            </p>
        </div>
    </div>
</c:if>