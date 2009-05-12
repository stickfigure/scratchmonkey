<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>
<%@ page import="java.security.Principal"%>

<%!@Current OurLogin login;%>

<%
	login.logout(null, request, response);
	Principal prince =  login.getUserPrincipal(request);
%>

<html>
	<body>
		<p>
			I am <%= prince %>
		</p>
		<p>
			I am role "user":  <%= login.isUserInRole(prince, "user") %>
		</p>
		<a href="index.jsp">Home</a>
	</body>
</html>
