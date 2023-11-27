<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final String TOP_ACTION_TEMPLTATE="top.action.template";
private static final String TOP_ACTION_TEMPLTATE_VALUE="/components/list/list-top-actions.jsp";

%>
<%--
form - is defined in the form-list-restful.jsp
--%>	
<%
String topActionTemplate = ParamUtil.getString(request, TOP_ACTION_TEMPLTATE, TOP_ACTION_TEMPLTATE_VALUE);
HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("form");
%>
<div class="card bg-primary text-white mt-2">
	<div class="card-header">
		<div class="row">
			<div class="col-md-6">
				<h5><%=AnnotationUtil.getItemLabel(form.getTitle())%></h5>
			</div>
			<div class="col-md-6">
				<liferay-util:include page="<%=topActionTemplate%>" servletContext="<%=application%>">
				</liferay-util:include>	
			</div>
		</div>
	</div>
</div>
