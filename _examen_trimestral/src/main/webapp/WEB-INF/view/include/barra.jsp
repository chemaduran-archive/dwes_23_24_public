<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.usuario!=null}">
	<div class="row justify-content-end">
		<div class="col-12 text-end">
			<p class="bg-primary text-white p-2">
				<a class="text-white" href="${pageContext.request.contextPath}/">Inicio</a>
				<c:if test="${sessionScope.role == 'usuario'}">
					<a class="text-white" href="${pageContext.request.contextPath}/Oficinas">Buscar
						Oficinas</a>
				</c:if>		 
			<c:out
				value="Esta usted logeado como: ${sessionScope.nombre} ${sessionScope.apellido} " />
			<a class="text-white"
				href="${pageContext.request.contextPath}/LogOut">Salir</a>
			</p>
		</div>
	</div>
</c:if>