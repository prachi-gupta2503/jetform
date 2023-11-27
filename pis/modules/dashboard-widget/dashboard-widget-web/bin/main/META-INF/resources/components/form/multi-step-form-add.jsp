<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_step_form_add_jsp");
%>
<%
	response.setHeader("Cache-Control","max-age=0");

	int listElementCount=0;
	int childFormCount=0;
	//LOGGER.info(redirectPage);
	//formClassPK="301";
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	int tabIndex = ParamUtil.getInteger(request, "tabIndex",0);
	String formIndex = ParamUtil.getString(request, "formIndex");
	//String formId = ParamUtil.getString(request, "formId");
	String formTitle = ParamUtil.getString(request, "formTitle");
	String formClass = ParamUtil.getString(request, "formClass");	
	
	long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);
	String formFlowClass = ParamUtil.getString(request, "formFlowClass", "");
	String formAction = ParamUtil.getString(request, "formAction");
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	
	String formId = null;
	HtmlFormWrapper form = null;
	if(request.getAttribute("formId")!=null){
		formId=(String) request.getAttribute("formId");
		if(request.getAttribute(formId)!=null){
			form=(HtmlFormWrapper)request.getAttribute(formId);
		}
	}
	//LOGGER.info("formId : "+formId);
	
	if(form==null){
		form = JetFormBuilderLocalServiceUtil.getHtmlFormByClassAndFormFlowProcessId(ClassUtils.getClass(formClass), String.valueOf(formFlowClassPK));
	}
	
	boolean editMode=(form.getEntity()!=null && form.getPrimaryKey()!=null);

	request.setAttribute("formId", form.getId());
	request.setAttribute(form.getId(), form);
	//request.setAttribute("form", form);
	//request.setAttribute("htmlForm", form);
	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
%>

<portlet:renderURL var="documentBrowserURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-browser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="documentScannerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-scanner.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="documentAdderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-adder.jsp"/>
</portlet:renderURL>

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/json.jsp" />
</portlet:resourceURL>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<%--
<portlet:renderURL var="nextRedirectURL">
	<portlet:param name="formFlowClass" value="<%=formFlowClass%>" />
	<portlet:param name="mvcPath" value="/components/list/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex+1)%>" />
</portlet:renderURL>

<portlet:renderURL var="prevRedirectURL">
	<portlet:param name="formFlowClass" value="<%=formFlowClass%>" />
	<portlet:param name="mvcPath" value="/components/list/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex-1)%>" />
</portlet:renderURL>
--%>

<aui:form name="<%=form.getId()+form.getElementNamespace()%>" action="<%=saveFormActionURL%>" index="<%=formIndex%>">
	<%--@ include file="/components/form/form-flow-process-id.jsp" --%>
	<div class="card form-card" style="padding:30px; margin:30px;">
		<div class="container <%="container-"+form.getId().toLowerCase()%>">
<%
	if(StringUtils.isNotBlank(formTitle)){
%>	
		<div class="row">
			<div class="col-md-12">
				<h4 class="font-weight-bold mb-3" style="text-decoration:underline;"><%=formTitle%></h4>
			</div>			
		</div>
<%
	}
%>	
			<liferay-util:include page="/components/form/form-default-elements.jsp" servletContext="<%=application%>" />
			<liferay-util:include page="/components/form/form-group-elements.jsp" servletContext="<%=application%>" />
		</div>
	</div>
	
	<liferay-util:include page="/components/form/hidden-elements.jsp" servletContext="<%=application%>" />
	
	<%--@ include file="/components/form/hidden-elements.jsp" --%>
	<aui:input type="hidden" name="tabIndex" value="<%=String.valueOf(tabIndex)%>"/>
	
	<%--@include file="/components/form/multi-step-next-prev.jsp"--%>
</aui:form>
<liferay-util:include page="/components/form/multi-step-form-script-elements.jsp" servletContext="<%=application%>" />