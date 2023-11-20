<%
	String home = ((String)session.getAttribute("usuario")).equals("admin") ? "/Admin" : "/Usuario";
%>
<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="<%= request.getContextPath()+home %>"><i class="bi bi-house-fill"></i></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="<%= request.getContextPath()+"/LogOut" %>"><i class="bi bi-x-square"></i></a>
  </li>  
</ul>