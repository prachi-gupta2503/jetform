<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.select_element_jsp");
%>
<%
	String elementName=ParamUtil.getString(request, "elementName");

	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
%>
<%--cssClass="select2-control" --%>
<aui:select showEmptyOption="true" type="<%=htmlElement.getControlType()%>" name="<%=htmlElement.getName()%>" id="<%=htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" required="<%=htmlElement.isRequired() %>">
<%
	if(htmlElement.getListOptions()!=null){
		for(KeyValue kv:htmlElement.getListOptions()){
			boolean selected=false;
			if(StringUtils.equalsIgnoreCase(savedValue, kv.getKey())){
				selected=true;
			}
%>	
		<aui:option value="<%=kv.getKey()%>" selected="<%=selected%>"><%=kv.getValue() %></aui:option>
<%
		}
	}
%>
<%@ include file="/components/form/validator-common.jsp" %>
</aui:select>