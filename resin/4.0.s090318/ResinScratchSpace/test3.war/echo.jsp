<%@ include file="taglibs.jsp"%>

<stripes:layout-render name="/layout/standard.jsp" title="Echo">
	<stripes:layout-component name="contents">
	<c:if test="${echo != null}">named echo works... ${echo.class.toString()}</c:if>
	<c:if test="${actionBean != null}">
		<div>
			Current Value:${echoString}
		</div>
		
		<s:form beanclass="${actionBean.class}" >
			<s:label for="echoString">Type something to echo:</s:label> <s:text name="echoString" value="echoString" />
			<stripes:submit name="echo" value="Echo" />
		</s:form>
	</c:if>
	</stripes:layout-component>
</stripes:layout-render>
