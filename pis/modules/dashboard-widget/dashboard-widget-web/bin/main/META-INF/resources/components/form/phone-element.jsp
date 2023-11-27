<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
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

String elementNamespace="";
if(request.getAttribute("childHtmlForm")!=null){
	HtmlFormWrapper childForm = (HtmlFormWrapper)request.getAttribute("childHtmlForm");
	elementNamespace=childForm.getElementNamespace();
}

boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;

if(viewOnlyMode){
	readOnly=true;
}
%>
<script>
	var <portlet:namespace/><%=htmlElement.getName()%>Unique=false;
</script>
<aui:input type="text" name="<%=elementNamespace+htmlElement.getName()%>" maxLength="10" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" readOnly="<%=readOnly %>">
	<%@ include file="/components/form/validator-common.jsp"%>
</aui:input>

<%@ include file="/components/form/validator-unique-script.jsp"%>