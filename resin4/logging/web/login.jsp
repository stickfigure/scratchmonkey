<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>

<%!
	@Current ExtraLogin login;
%>

<%
	login.login("harry", "potter", request);
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
