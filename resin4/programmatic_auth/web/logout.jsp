<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>

<%!
	@Current ExtraLogin login;
%>

<%
	login.logout(null, request, response);
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
