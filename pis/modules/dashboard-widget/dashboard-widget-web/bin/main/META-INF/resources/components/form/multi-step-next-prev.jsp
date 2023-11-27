<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%
int tabIndex = ParamUtil.getInteger(request, "tabIndex",0);
String flowFormId=(String)request.getAttribute("flowFormId");
HtmlFormWrapper formFlow=(HtmlFormWrapper)request.getAttribute(flowFormId);
%>
<div class="form-group-item" style="float: right; padding: 0px 30px 15px; margin-top: -10px;">
	<div class="btn-group">
		<div class="btn-group-item">
<%
	if (tabIndex > 0) {
%>
			<input type="button" class="btn btn-secondary previous action-button action-button-prev mr-2" value="Previous" id="<portlet:namespace/><%=formFlow.getId()+"prev"%>" index="<%=tabIndex%>"/>
<%
	}
%>
			<input type="button" class="btn btn-primary next action-button action-button-next" value="Next" id="<portlet:namespace/><%=formFlow.getId()+"next"%>" index="<%=tabIndex%>"/>
		</div>
	</div>
</div>
