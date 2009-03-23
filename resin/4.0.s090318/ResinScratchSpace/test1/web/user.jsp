<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="${user.friendlyName}">
	<stripes:layout-component name="contents">
		<stripes:errors />
		<stripes:form beanclass="resinscratchspace.web.action.LogoutActionBean">
			<div><s:label for="email" >Email:</s:label>
				<a id="email" href="mailto:///${user.email}">${user.email}</a>
			</div>
			<div><s:label for="fullName" >Name:</s:label>${user.fullName}</div>
			<div><s:label for="friendlyName" >Nick Name:</s:label>${user.friendName}</div>
			
			<div> 
				<a href="/user/0/edit">Edit</a>
<!--				<s:link beanclass="${currentAction.clss}" event="edit">Edit</s:link> -->
			</div>			
		</stripes:form>
	</stripes:layout-component>
</stripes:layout-render>
