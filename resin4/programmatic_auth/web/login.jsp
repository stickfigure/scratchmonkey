<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>
<%@ page import="java.security.Principal" %>
<%@ page import="com.caucho.security.Login" %>



<%!@Current Login login;%>

<%
	((OurLogin)login).login("harry", "potter", request);
%>

<html>
	<body>
		<p>
			I am <%= request.getUserPrincipal() %>
		</p>
		<p>
			I am role "user":  <%= request.isUserInRole("user") %>
		</p>
	</body>
</html>

