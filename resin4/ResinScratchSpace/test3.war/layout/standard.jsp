<%@ include file="../taglibs.jsp" %>

<stripes:layout-definition>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    <html>
        <head>
            <title>${title}</title>
            <link rel="stylesheet" type="text/css" href="${ctx}/css/sample.css"/>
            <stripes:layout-component name="html-head"/>
        </head>
        <body>
            <div id="contentPanel">
                <stripes:layout-component name="header">
                    <jsp:include page="/layout/header.jsp"/>
                </stripes:layout-component>

                <div id="pageContent">
                    <div class="sectionTitle">${title}</div>
                    <stripes:messages/>
                    <stripes:layout-component name="contents"/>
                </div>

                <div id="footer">
    	            <jsp:include page="/layout/footer.jsp"/>
                </div>
            </div>
        </body>
    </html>
</stripes:layout-definition>
