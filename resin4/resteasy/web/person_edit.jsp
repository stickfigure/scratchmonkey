
<h1>Person Edit</h1>

<form method="post" action="${pageContext.request.contextPath}/person/${model.id}">
	<input type="text" name="nickname" value="${model.nickname}"/>
	<input type="submit"/>
</form>

Errors:  ${model.errors}
