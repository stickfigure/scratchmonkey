<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="Home">
	<stripes:layout-component name="contents">
		<stripes:errors />
		<stripes:form beanclass="resinscratchspace.web.action.LogoutActionBean">
			<stripes:label for="logout">Do you really want to log out?</stripes:label>
			<stripes:submit name="logout" value="Logout" > Logout </stripes:submit>
		</stripes:form>
	</stripes:layout-component>
</stripes:layout-render>
