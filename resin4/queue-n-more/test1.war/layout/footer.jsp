<%@ include file="../taglibs.jsp" %>

<s:link beanclass="resinscratchspace.web.action.LoginActionBean">Login</s:link>
|
<s:link beanclass="resinscratchspace.web.action.UsersActionBean">Users List</s:link>
|
<s:link beanclass="resinscratchspace.web.action.EchoActionBean" event="view">Echo Test</s:link>

<c:if test="${loginStatus.loggedIn}">
	|	
	<s:link beanclass="resinscratchspace.web.action.UserActionBean">
		My Account
		<s:param name="id" value="${loginStatus.user.id}" />
	</s:link> | 
	<!--	<s:link href="/user/${loginStatus.user.id}/">Account</s:link>		|-->
	<s:link href="/logout">Logout</s:link> 
</c:if>

