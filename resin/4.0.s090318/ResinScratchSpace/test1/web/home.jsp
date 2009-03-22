<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="Home">
	<stripes:layout-component name="contents">
	<c:choose>
		<c:when test="${empty loginStatus.user}">
			<div class="sectionTitle"><stripes:link href="/login">Please login!</stripes:link></div>
		</c:when>
		
		<c:otherwise>
			<p>You are already logged in as '${loginStatus.user.email}'. Logging in again will cause you to be logged out, and then
			re-logged in with the email and password supplied.</p>

			<br/>
			Looks like even the ejbs think so ! ${isAuthenticatedToBackend}
		</c:otherwise>
		
	</c:choose>
	</stripes:layout-component>
</stripes:layout-render>
