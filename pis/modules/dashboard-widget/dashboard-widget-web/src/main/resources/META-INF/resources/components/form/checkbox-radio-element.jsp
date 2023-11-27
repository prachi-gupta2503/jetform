<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
//private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.checkbox_radio_element_jsp");
%>
<%
	String elementName=ParamUtil.getString(request, "elementName");
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}

	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}

//LOGGER.info(CollectionUtils.isEmpty(htmlElement.getListOptions()) +" - " +HtmlElement.ControlType.checkbox.name()+" -- "+htmlElement.getControlType());
if(StringUtils.equalsIgnoreCase(htmlElement.getDataType(), String.valueOf(Boolean.TYPE)) || StringUtils.equalsIgnoreCase(htmlElement.getDataType(), Boolean.class.getName())){
%>
<label style="margin-top:10px;"><input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>" value="1" <%=readOnly?"disabled":"" %>>&nbsp;&nbsp;<%=htmlElement.getLabel()%></label>
<%	

}else if(CollectionUtils.isEmpty(htmlElement.getListOptions()) && htmlElement.isControlType(HtmlElement.ControlType.checkbox)){
	boolean checked=false;
	if(StringUtils.equalsIgnoreCase(savedValue, "1") || StringUtils.equalsIgnoreCase(savedValue, "true")){
		checked=true;
	}
%>	
	<label style="margin-top:10px;"><input type="<%=htmlElement.getControlType()%>"  name="<portlet:namespace/><%=form.getElementNamespace()+htmlElement.getName()%>" id="<portlet:namespace/><%=form.getElementNamespace()+htmlElement.getName()%>"  class="<%=form.getId()+"_"+htmlElement.getControlType()%>" value="<%=1%>" <%=checked?"checked":"" %> <%=readOnly?"disabled":"" %>>&nbsp;&nbsp;<%=htmlElement.getLabel()%></label>
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
	<li><input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=form.getElementNamespace()+htmlElement.getName()%>" id="<portlet:namespace/><%=form.getElementNamespace()+htmlElement.getName()%>" value="<%=kv.getKey()%>" <%=checked?"checked":"" %> <%=readOnly?"disabled":"" %>> <label><%=kv.getValue()%></label></li>
<%
	}
%>
</ul>
<%
}
if(HtmlElement.ControlType.checkbox.name().equals(htmlElement.getControlType())){
%>
<script type="text/javascript">
<%--$(document).ready(function(){
	$('.<%=form.getId()+"_"+htmlElement.getControlType()%>').change(function(){
		if(this.checked) {
			alert("checked");
        	$(this).val="1";
	    }else{
	    	alert("unchecked");
	        $(this).val="0";
	    }
	});
});--%>
</script>
<%	
}

%>
