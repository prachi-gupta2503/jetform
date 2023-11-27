<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.checkbox_radio_element_jsp");
%>
<%
String elementName=ParamUtil.getString(request, "elementName");

HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	
HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");

if(StringUtils.equalsIgnoreCase(htmlElement.getDataType(), String.valueOf(Boolean.TYPE)) || StringUtils.equalsIgnoreCase(htmlElement.getDataType(), Boolean.class.getName())){
%>
<input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>" value="1">Yes
<%	

}else if(CollectionUtils.isEmpty(htmlElement.getListOptions()) && HtmlElement.ControlType.checkbox.name().equals(htmlElement.getControlType())){
	boolean checked=false;
	if(StringUtils.equalsIgnoreCase(savedValue, "1") || StringUtils.equalsIgnoreCase(savedValue, "true")){
		checked=true;
	}
%>	
	<input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>"  value="<%=1%>" <%=checked?"checked":"" %>> <label>Yes</label>
<%
}else{
	int listColumns=htmlElement.getListOptions().size()/10;
%>
<ul style="list-style-type:none; padding-inline-start: 5px; <%=(listColumns>1?("columns:"+listColumns+"; -webkit-columns:"+ listColumns+"; -moz-columns:"+listColumns+";"):"")%>">
<%
	for(KeyValue kv:htmlElement.getListOptions()){
		boolean checked=false;
		if(StringUtils.equalsIgnoreCase(savedValue, kv.getKey())){
			checked=true;
		}
%>	
			<li><input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>"  value="<%=kv.getKey()%>" <%=checked?"checked":"" %>> <label><%=kv.getValue()%></label></li>
<%
	}
%>
</ul>
<%
}
%>
