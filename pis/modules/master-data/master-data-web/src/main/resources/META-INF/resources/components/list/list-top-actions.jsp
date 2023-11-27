<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>

<%@ include file="/init.jsp"%>
<%--
=======================================================
form - is defined in form-list-restful.jsp
bulkActions -  is defined in form-list-restful.jsp
actionsParamMap -  is defined in form-list-restful.jsp
=======================================================
--%>	
 
<div class="row">
	<div class="col-md-12">
<%
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("form");
	Map<String, String> actionsParamMap = (Map<String, String>)request.getAttribute("actionsParamMap");
	List<HtmlFormActionWrapper> bulkActions = (List<HtmlFormActionWrapper>)request.getAttribute("bulkActions");

	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}if(action.getName().equalsIgnoreCase(HtmlFormAction.ACTION_ADD) && form.isReadOnly()){
			continue;
		}
		
%>
		<a title="<%=StringUtils.capitalise(action.getName())%>" class="btn btn-primary <%=action.getName()%>-link float-right" id="<portlet:namespace/><%=form.getId()%><%=action.getName()%>">
			<i class="fa fa-plus <%=action.getName()%>-icon mr-1" aria-hidden="true"></i><%=StringUtils.capitalize(action.getName())%>&nbsp;<%=AnnotationUtil.getItemLabel(form.getTitle())%>
		</a>
<%			
	}
%>			
	</div>
</div>
