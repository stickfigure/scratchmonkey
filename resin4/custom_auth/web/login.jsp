<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>
<%@ page import="java.security.Principal" %>
<%@ page import="com.caucho.security.Login" %>



<%!@Current Login login;%>

<%
	((OurLogin)login).login("harry", "potter", request);
	Principal prince = request.getUserPrincipal();
%>

<html>
	<body>
		<p>
			I am <%= prince %>
		</p>
		<p>
			I am role "user":  <%= login.isUserInRole(prince, "user") %>
		</p>
	</body>
</html>

