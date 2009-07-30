
<%
	String foo = (String)request.getSession().getAttribute("foo");
%>

<html>
	<head><title>Test</title></head>
	
	<body>
		<p>
			Foo is ${foo} (also <%= foo %>)
		</p>
		
		<a href="index.jsp">Go back to 1</a>
	</body>
</html>