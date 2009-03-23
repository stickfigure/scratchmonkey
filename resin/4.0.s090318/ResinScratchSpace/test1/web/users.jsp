<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="${loginStatus.user.friendlyName}">
	<stripes:layout-component name="contents">
		<stripes:errors />

		<c:forEach items="${users}" var="user" varStatus="rowstat">
			<div><s:label for="email" >Email:</s:label>
				<a id="email" href="mailto:///${user.email}">${user.email}</a>
			</div>
			<div><s:label for="fullName" >Name:</s:label>${user.fullName}</div>
			<div><s:label for="friendlyName" >Nick Name:</s:label>${user.friendName}</div>
			<div> 
				<s:link beanclass="${com.googlecode.web.action.UserActionBean}" event="View">View
					<s:param name="id" value="${user.id}"></s:param>
				</s:link>
			</div>
			
			<div>
				<c:forEach items="${user.log}" var="log">
					${log.id}: ${log.entry}<br/>
				</c:forEach>
			</div>
		</c:forEach>

	</stripes:layout-component>
</stripes:layout-render>
