<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@ include file="/init.jsp"%>
<%--
bulkActions - The list is defined in the form-list-restful.jsp
actionsParamMap - The map is defined in the form-list-restful.jsp
--%>	
<%! 
 private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.master_list_top_actions_jsp");
%>
<%
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("form");
	Map<String, String> actionsParamMap = (Map<String, String>)request.getAttribute("actionsParamMap");
	List<HtmlFormActionWrapper> bulkActions = (List<HtmlFormActionWrapper>)request.getAttribute("bulkActions");
		
	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}
%>
		<a class="btn btn-primary" title="<%=StringUtils.capitalize(action.getName())%>" id="<portlet:namespace/><%=form.getId()%><%=action.getName()%>">
			<i class="fa fa-plus mr-2" aria-hidden="true"></i><%=StringUtils.capitalize(action.getName())%>&nbsp;<%=AnnotationUtil.getItemLabel(form.getTitle())%>
		</a>
<%			
	}
%>		
