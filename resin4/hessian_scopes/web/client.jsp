<%@ page import="test.*" %>
<%@ page import="javax.inject.*" %>

<%!@Current Client client;%>

<%
	String s = "say hello, echo";
%>

<html>
	<body>
		<p>
			Said: <%= s %>
		</p>
		
		<p> 
			Echo said: <%= client.echo(s)%> 
		</p>
	</body>
</html>