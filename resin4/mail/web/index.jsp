
<html>
	<head><title>Test</title></head>
	
	<body>
		<p>
			Echoing: ${echoer.echo('blah')}
		</p>
		<p>
			Thing: ${echoer.thing}, Echoer: ${echoer}
		</p>
		<ul>
		<%
			java.util.Enumeration enu = application.getAttributeNames();
			while (enu.hasMoreElements())
			{
				String name = (String)enu.nextElement();
				Object value = application.getAttribute(name);
				
				%><li> <%= name %> : <%= value %> </li><%
			}
		%>
		</ul>
	</body>
</html>