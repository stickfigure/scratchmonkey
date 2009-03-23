<%@ page language="java" %>
<%@ page import="javax.naming.*" %>
<%@ page import="test.*" %>
<%@ page import="org.jboss.security.*" %>

<%
	SecurityAssociation.setPrincipal(new SimplePrincipal("Bob"));
	SecurityAssociation.setCredential(null);

	Context ctx = new InitialContext();
	Front f = (Front)ctx.lookup("ContainerTest/Front/local");
%>

<p>
	This version programmatically sets the principal and credential.
	<a href="index2.jsp">Another</a> version uses BASIC auth.
</p>

<p>1st time: <%= f.doNothingAndGetThePrincipal() %></p>
<p>2nd time: <%= f.doNothingAndGetThePrincipal() %></p> 
<p>3rd time: <%= f.doNothingAndGetThePrincipal() %></p>
<p>4th time: <%= f.doNothingAndGetThePrincipal() %></p>

<%	
	SecurityAssociation.setPrincipal(null);
	SecurityAssociation.setCredential(null);
%>