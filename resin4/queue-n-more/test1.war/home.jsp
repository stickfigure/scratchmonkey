<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="Home">
	<stripes:layout-component name="contents">
	<c:choose>
		<c:when test="${empty loginStatus.user}">
			<div class="sectionTitle"><stripes:link href="/login">Please login!</stripes:link></div>
		</c:when>
		
		<c:otherwise>
			<p>You are logged in as '${loginStatus.user.email}'.</p>

			<br/>
			<c:if test="${isAuthenticatedToBackend}">
				Looks, even the ejbs think so! 
			</c:if>
		</c:otherwise>
		
	</c:choose>
	</stripes:layout-component>
</stripes:layout-render>
