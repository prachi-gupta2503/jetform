<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%!
	private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.file_005fviewer_jsp");
%>
<%
	String fileUrl=ParamUtil.getString(request, "imageUrl");
%>

<div class="card">
	<div class="card-body">
		<img src="<%=fileUrl%>" style="border:1px solid grey;" alt="Image Viewer"> 
	</div>
</div>
