<%@ include file="/taglibs.jsp" %>

<div id="imageHeader">
    <table style="padding: 5px; margin: 0px; width: 100%;">
        <tr>
            <td id="pageHeader">Examples: Auth</td>
            <td id="loginInfo">
                <c:if test="${not empty user}">
                    Welcome: <stripes:format value="${user}" 
                    		formatType="full" formatPattern="%F %L" />
                    |
                    <stripes:link beanclass="LogoutActionBean">Logout</stripes:link>
                </c:if>
            </td>
        </tr>
    </table>
    <div id="navLinks">
    	#nav links
    </div>
</div>