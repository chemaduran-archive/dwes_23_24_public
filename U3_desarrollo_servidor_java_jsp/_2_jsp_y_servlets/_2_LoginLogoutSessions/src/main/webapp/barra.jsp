
<%@ page import="velazquez._2_loginlogoutsessions.model.UsuarioBean" %>
<div class="d-flex justify-content-end">
	<h4>
	<%
		UsuarioBean user = (UsuarioBean) session.getAttribute("usuario");
		out.println(user.getNombre());
	%>
	</h4>
	<a href="Logout">Logout</a>
</div>
