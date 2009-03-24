<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="${actionBean.user.friendlyName}">
	<stripes:layout-component name="contents">
		<stripes:errors />
		<stripes:form beanclass="resinscratchspace.web.action.UserActionBean">
			<div>
				<s:label for="email" >Email:</s:label>
				<s:text name="email" value="${actionBean.user.email}"/>
			</div>
			
			<div>
				<s:label for="fullName" >Name:</s:label>
				<s:text name="fullName" value="${actionBean.user.fullName}"/>
			</div>
			
			<div>
				<s:label for="friendlyName" >Nick Name:</s:label>
				<s:text name="friendlyName" value="${actionBean.user.friendlyName}"/> 
			</div>
			
			<div> 
				<s:link beanclass="${actionBean.class}" event="edit">View
					<s:param name="id" value="${actionBean.id}" />
				</s:link> 
			</div>
			<s:hidden name="id" value="${actionBean.id}"/>
			<s:submit name="update" value="Update"/>
		</stripes:form>
	</stripes:layout-component>
</stripes:layout-render>
