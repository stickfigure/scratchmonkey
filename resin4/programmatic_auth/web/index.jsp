<%@ page import="test.*" %>

<html>
	<body>
		<p>
			I am <%= request.getUserPrincipal() %>
		</p>
		<p>
			I am role "user":  <%= request.isUserInRole("user") %>
		</p>
		
		<p><a href="login.jsp">login</a> (sets Principal)</p>
		<p><a href="client.jsp">echo</a> (echo via hessian)</p>
		<p><a href="logout.jsp">logout</a></p>
	</body>
</html>
