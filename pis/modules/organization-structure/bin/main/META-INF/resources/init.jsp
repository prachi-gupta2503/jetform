<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<link href="<%=request.getContextPath()%>/css/orgchart.css" rel="stylesheet">
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js" /></script> --%>
  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/orgchart.js"></script>
 