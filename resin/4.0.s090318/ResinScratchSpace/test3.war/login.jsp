<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="Login">
	<stripes:layout-component name="contents">

		<table style="vertical-align: top;">
			<tr>
				<td style="width: 25%; vertical-align: top;">
				<stripes:errors />
				<stripes:form beanclass="resinscratchspace.web.action.LoginActionBean" 
							  focus="email">
					<table>
						<tr>
							<td style="font-weight: bold;"><stripes:label for="email" />:</td>
						</tr>
						<tr>
							<td><stripes:text name="email" value="${user.email}" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold;"><stripes:label for="password" />:</td>
						</tr>
						<tr>
							<td><stripes:password name="password" /></td>
						</tr>
						<tr>
							<td style="text-align: center;">
							<%-- If the security interceptor attached a targetUrl, carry that along. --%>
							<stripes:hidden name="targetUrl" />
							<stripes:submit name="login" value="Login" />
							</td>
						</tr>
					</table>
				</stripes:form></td>
				<td style="vertical-align: top;"><c:choose>
					<c:when test="${empty user}">
						<div class="sectionTitle">Welcome</div>
					</c:when>

					<c:otherwise>
						<p>You are already logged in as '${user.email}'. Logging in again will cause you to be logged out, and then
						re-logged in with the email and password supplied.</p>
					</c:otherwise>
				</c:choose></td>
			</tr>
		</table>

	</stripes:layout-component>
</stripes:layout-render>
