<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>
<%@ page import="java.security.Principal" %>
<%@ page import="com.caucho.security.Login" %>
<%@page import="com.caucho.security.BasicLogin"%>

<%!@Current Login login;%>
<% Principal prince =  login.getUserPrincipal(request);  %>



<html>
	<body>
		<p>
			I am <%= prince %>
		</p>
		<p>
			I am role "user":  <%= login.isUserInRole(prince, "user") %>
		</p>
		
		<p><a href="login.jsp">login</a> (sets Principal)</p>
		<p><a href="client.jsp">echo</a> (echo vi hessian)</p>
		<p><a href="logout.jsp">logout</a></p>
	</body>
</html>
