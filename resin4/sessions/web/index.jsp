
<%
	request.getSession().setAttribute("foo", "bar");
%>

<html>
	<head><title>Test</title></head>
	
	<body>
		<p>
			Foo is ${foo}
		</p>
		
		<a href="two.jsp">Try another page</a>
	</body>
</html>