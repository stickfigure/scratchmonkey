<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="Home">
	<stripes:layout-component name="contents">

	<div>
		Current Value:<s:label>${actionBean.echo}</s:label>
	</div>
	<s:form beanclass="${actionBean.class}" >
		Type something to echo: <s:text name="echoString" value="${echo}" />
		<stripes:submit name="echo" value="Echo" />
	</s:form>

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
