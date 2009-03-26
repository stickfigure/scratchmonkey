<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="${user.friendlyName}">
	<stripes:layout-component name="contents">
		<stripes:errors />
		<stripes:form beanclass="resinscratchspace.web.action.UserActionBean">
			<div>
				<s:label for="email" >Email:</s:label>
				<s:text name="email" value="${user.email}"/><s:errors field="user.email"/>
			</div>
			
			<div>
				<s:label for="fullName" >Name:</s:label>
				<s:text name="fullName" value="${user.fullName}"/><s:errors field="user.fullName"/>
			</div>
			
			<div>
				<s:label for="friendlyName" >Nick Name:</s:label>
				<s:text name="friendlyName" value="${user.friendlyName}"/> <s:errors field="user.friendlyName"/>
			</div>
			
			<div> 
				<s:link beanclass="${class}" event="edit">View
					<s:param name="id" value="${id}" />
				</s:link> 
			</div>
			<s:hidden name="id" value="${id}" />
			<s:submit name="update" value="Update"/>
		</stripes:form>
	</stripes:layout-component>
</stripes:layout-render>
