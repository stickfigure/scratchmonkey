<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>
<%@ page import="java.security.Principal" %>
<%@ page import="com.caucho.security.Login" %>

<%!@Current Login login;%>

<html>
	<body>
		<p>
			I am <%= request.getUserPrincipal() %>
		</p>
		<p>
			I am role "user":  <%= login.isUserInRole(request.getUserPrincipal(), "user") %>
		</p>
		
		<p><a href="login.jsp">login</a> (sets Principal)</p>
		<p><a href="client.jsp">echo</a> (echo vi hessian)</p>
		<p><a href="logout.jsp">logout</a></p>
	</body>
</html>
