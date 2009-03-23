<%@ page language="java" %>
<%@ page import="javax.naming.*" %>
<%@ page import="test.*" %>

<%
	Context ctx = new InitialContext();
	Front f = (Front)ctx.lookup("ContainerTest/Front/local");
%>

<p>
	This version uses BASIC auth.
	<a href="index.jsp">Another</a> version programmatically sets the principal and credential.
</p>

<p>1st time: <%= f.doNothingAndGetThePrincipal() %></p>
<p>2nd time: <%= f.doNothingAndGetThePrincipal() %></p> 
<p>3rd time: <%= f.doNothingAndGetThePrincipal() %></p>
<p>4th time: <%= f.doNothingAndGetThePrincipal() %></p>

