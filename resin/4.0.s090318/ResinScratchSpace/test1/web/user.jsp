<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="${actionBean.user.friendlyName}">
	<stripes:layout-component name="contents">
		<stripes:errors />
		<stripes:form beanclass="resinscratchspace.web.action.LogoutActionBean">
			<div><s:label for="email" >Email:</s:label>
				<a id="email" href="mailto://${actionBean.user.email}">${actionBean.user.email}</a>
			</div>
			<div><s:label for="fullName" >Name:</s:label>${actionBean.user.fullName}</div>
			<div><s:label for="friendlyName" >Nick Name:</s:label>${actionBean.user.friendlyName}</div>
			
			<div> 
				<s:link beanclass="${actionBean.class}" event="edit">Edit
					<s:param name="id" value="${actionBean.id}"/>
				</s:link> 
			</div>			
		</stripes:form>
	</stripes:layout-component>
</stripes:layout-render>
