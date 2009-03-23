<%@ include file="../taglibs.jsp" %>

<s:link href="/login">Login</s:link>	|
<c:if test="${loginStatus.loggedIn}">
	<s:link href="/user/${loginStatus.user.id}/">Account</s:link>		|
</c:if>
<s:link href="/logout">Logout</s:link> 	| 

