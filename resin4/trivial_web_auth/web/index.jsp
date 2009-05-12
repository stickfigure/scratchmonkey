
<html>
	<body>
		<p>
			I am <%= request.getUserPrincipal() %>
		</p>
		<p>
			I am role "user":  <%= request.isUserInRole("user") %>
		</p>
		<p><a href="foo/">The secured area</a></p>
	</body>
</html>

