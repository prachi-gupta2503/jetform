<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
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
	
	String selectElementName=childFormNamespace+htmlElement.getName();

	if(viewOnlyMode){
		readOnly=true;
		selectElementName+="_readOnly";
	}
	
%>

	<%--cssClass="select2-control"  --%>
	<aui:select type="<%=htmlElement.getControlType()%>" name="<%=selectElementName%>" id="<%=formId+childFormNamespace+htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" disabled="<%=readOnly %>" >
		<option value="">Select an option</option>
<%
		for(KeyValue kv:htmlElement.getListOptions()){
			boolean selected=false;
			if(StringUtils.equalsIgnoreCase(savedValue, kv.getKey())){
				selected=true;
			}
%>	
			<option value="<%=kv.getKey()%>" <%=selected?"selected":""%>><%=kv.getValue() %></option>
<%
		}
%>
		<%@ include file="/components/form/validator-common.jsp" %>
	</aui:select>
<%
if(readOnly){
%>
<aui:input type="hidden" name="<%=childFormNamespace+htmlElement.getName()%>" value="<%=savedValue%>" />
<%	
}
%>