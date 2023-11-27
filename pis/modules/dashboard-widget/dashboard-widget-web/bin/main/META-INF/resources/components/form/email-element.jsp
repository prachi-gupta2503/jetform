<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.email_element_jsp");
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
	

	String elementNamespace="";
	if(request.getAttribute("childHtmlForm")!=null){
		HtmlFormWrapper childForm = (HtmlFormWrapper)request.getAttribute("childHtmlForm");
		elementNamespace=childForm.getElementNamespace();
	}
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;

	if(readOnly){
%>
	<aui:input type="<%=htmlElement.getControlType()%>" name="<%=elementNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" readOnly="true" >
	<%--@ include file="/components/form/validator-common.jsp"--%>
	</aui:input>
<%
	}else{
%>
	<aui:input type="<%=htmlElement.getControlType()%>" name="<%=elementNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" >
	<%@ include file="/components/form/validator-common.jsp"%>
	</aui:input>
	<%@ include file="/components/form/validator-unique-script.jsp"%>
<%
	}
%>

