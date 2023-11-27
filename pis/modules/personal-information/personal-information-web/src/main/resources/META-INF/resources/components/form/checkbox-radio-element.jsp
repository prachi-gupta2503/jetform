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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.checkbox_radio_element_jsp");
%>
<%
boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}

boolean childForm=false;
String formId=(String)request.getAttribute("childFormId");
if(StringUtils.isBlank(formId)){
	formId=(String)request.getAttribute("formId");
}else{
	childForm=true;
}

String childFormNamespace="";
if(childForm){
	childFormNamespace=(String)request.getAttribute("childFormNamespace");
}

String elementName=(String)request.getAttribute(childFormNamespace+"elementName");

HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute(childFormNamespace+"htmlElement_"+elementName);
String savedValue=(String)request.getAttribute(childFormNamespace+elementName+ "_savedValue");

boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;

String checkRadioName=childFormNamespace+htmlElement.getName();
String checkRadioReadOnlyName=checkRadioName;
if(viewOnlyMode){
	readOnly=true;
	checkRadioReadOnlyName+="_readOnly";
}

String cssClass=htmlElement.getName().toLowerCase()+"-"+htmlElement.getControlType().toLowerCase();

//LOGGER.info(htmlElement.getName()+ " - htmlElement.getDataType() : "+htmlElement.getDataType()+", htmlElement.getListOptions() : "+htmlElement.getListOptions()+", htmlElement.getControlType(): " +htmlElement.getControlType());

if((StringUtils.equalsIgnoreCase(htmlElement.getDataType(), String.valueOf(Boolean.TYPE)) || StringUtils.equalsIgnoreCase(htmlElement.getDataType(), Boolean.class.getName()))
 || (CollectionUtils.isEmpty(htmlElement.getListOptions()) && htmlElement.isControlType(HtmlElement.ControlType.checkbox))		
		){
	boolean checked=false;
	if(StringUtils.equalsIgnoreCase(savedValue, "1") || StringUtils.equalsIgnoreCase(savedValue, "true")){
		checked=true;
	}
%>
	<label style="margin-top:10px;"><input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=checkRadioReadOnlyName+"_"+htmlElement.getControlType()%>" id="<portlet:namespace/><%=formId+checkRadioReadOnlyName+"_"+htmlElement.getControlType()%>" value="1" <%=checked?"checked":"" %> <%=readOnly?"disabled":"" %>>&nbsp;&nbsp;<%=htmlElement.getLabel()%></label>
	<input type="hidden" name="<portlet:namespace/><%=checkRadioName%>" id="<portlet:namespace/><%=formId+checkRadioName%>" value="<%=savedValue%>">
	
	<script type="text/javascript">
		$("#<portlet:namespace/><%=formId+checkRadioReadOnlyName+"_"+htmlElement.getControlType()%>").on('change', function(){
			$("#<portlet:namespace/><%=formId+checkRadioName%>").val($(this).prop("checked"));
		});
	</script>

<%--
}else if(CollectionUtils.isEmpty(htmlElement.getListOptions()) && htmlElement.isControlType(HtmlElement.ControlType.checkbox)){
	boolean checked=false;
	if(StringUtils.equalsIgnoreCase(savedValue, "1") || StringUtils.equalsIgnoreCase(savedValue, "true")){
		checked=true;
	}
%>	
	<label style="margin-top:10px;"><input type="<%=htmlElement.getControlType()%>"  name="<portlet:namespace/><%=checkRadioReadOnlyName+"_"+htmlElement.getControlType()%>" id="<portlet:namespace/><%=formId+checkRadioReadOnlyName+"_"+htmlElement.getControlType()%>" class="<%=cssClass%>" value="<%=1%>" <%=checked?"checked":"" %> <%=readOnly?"disabled":"" %>>&nbsp;&nbsp;<%=htmlElement.getLabel()%></label>
	<input type="hidden" name="<portlet:namespace/><%=checkRadioName%>" id="<portlet:namespace/><%=formId+checkRadioName%>" value="<%=savedValue%>">
--%>
<%
}else if(CollectionUtils.isNotEmpty(htmlElement.getListOptions())){
	int listColumns=htmlElement.getListOptions().size()/10;
%>
<ul style="list-style-type:none; padding-inline-start: 5px; <%=(listColumns>1?("columns:"+listColumns+"; -webkit-columns:"+ listColumns+"; -moz-columns:"+listColumns+";"):"")%>">
<%
	int ix=0;
	for(KeyValue kv:htmlElement.getListOptions()){
		boolean checked=false;
		if(StringUtils.equalsIgnoreCase(savedValue, kv.getKey())){
			checked=true;
		}
		ix++;
%>	
	<li>
		<input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=checkRadioReadOnlyName%>" id="<portlet:namespace/><%=checkRadioReadOnlyName+ix%>" value="<%=kv.getKey()%>" <%=checked?"checked":"" %> <%=readOnly?"disabled":"" %>> <label><%=kv.getValue()%></label>
<%	
		if(readOnly){
%>
		<input type="hidden" name="<portlet:namespace/><%=checkRadioName%>" id="<portlet:namespace/><%=checkRadioName+ix%>" value="<%=savedValue%>">
<%		
		}
%>
	</li>
<%	
	}
%>
</ul>
<%
}
%>
<%--
if(htmlElement.isControlType(HtmlElement.ControlType.checkbox)){
%>
<script type="text/javascript">
	$("#<portlet:namespace/><%=formId+checkRadioReadOnlyName+"_"+htmlElement.getControlType()%>").on('change', function(){
		$("#<portlet:namespace/><%=formId+checkRadioName%>").val($(this).prop("checked"));
	});
</script>
<%	
}
--%>
