<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="top.header.template" value="/mdm/master_list_header.jsp" />
			<liferay-util:param name="top.action.template" value="/mdm/master_list_top_actions.jsp" />
			<liferay-util:param name="action.redirect.url" value="/mdm/master_list.jsp" />
		</liferay-util:include>
	</div>
</div>
