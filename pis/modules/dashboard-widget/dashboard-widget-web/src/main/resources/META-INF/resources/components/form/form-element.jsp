<%@page import="java.util.Enumeration"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_add_jsp");
%>

<%
	response.setHeader("Cache-Control","max-age=0");

	int listElementCount=0;
	int childFormCount=0;

	String formClass = ParamUtil.getString(request, "childFormClass");
	String formClassPK = ParamUtil.getString(request, "childFormClassPK");
	String formAction = ParamUtil.getString(request, "childFormAction");
	String redirectPage = ParamUtil.getString(request, "redirectPage");
	
	boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	
	HtmlElementWrapper formElement=(HtmlElementWrapper)request.getAttribute("htmlElement");
	
	//LOGGER.info("formHtmlElement  "+formElement);
	String elementValue=(String)request.getAttribute(formElement.getName()+"_savedValue");
	//LOGGER.info("formHtmlElement saved value "+elementValue);
	
	Map<String, String> presetFieldValues=new HashMap<String, String>();
	Map<String, String> presetHiddenFields=new HashMap<String, String>();
	Enumeration<String> parameterNames=request.getParameterNames();
	
	while(parameterNames.hasMoreElements()){
		String paramName=parameterNames.nextElement();
		String fieldName=null;
		if(paramName.startsWith("field.")){
			fieldName=paramName.substring(paramName.indexOf(".")+1, paramName.lastIndexOf("."));
			//LOGGER.info("ParameterNames.fieldName : "+fieldName);
			if(paramName.endsWith(".value")){
				presetFieldValues.put(fieldName, ParamUtil.getString(request, paramName));
			}else if(paramName.endsWith(".hidden")){
				//LOGGER.info("ParameterNames.fieldName : "+fieldName);
				presetHiddenFields.put(fieldName, ParamUtil.getString(request, paramName));
			}/*else if(paramName.endsWith(".hidden")){
				presetFieldHidden.put(fieldName, ParamUtil.getString(request, paramName));
			}*/
		}
	}
			
	//LOGGER.info("formClassPK : "+formClassPK);
	//formClassPK="301";
	
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form = null;
	if(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0")){
		form=jetFormBuilderLocalService.getHtmlFormByClass(formClass);
	}else{
		form=jetFormBuilderLocalService.getHtmlFormByClass(formClass, formClassPK);
		LOGGER.info(form.getEntity());
	}
	
	//Namespace with "." was added.
	form.setElementNamespace(formElement.getName()+".");
	
	request.setAttribute("formId", form.getId());
	request.setAttribute(form.getId(), form);
	
	//pageContext.setAttribute("htmlForm", form);
	request.setAttribute("childFormId", form.getId());
	
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
	<portlet:param name="redirect" value="<%=redirectPage%>" />
</portlet:actionURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>

<%--
	if(!dialogMode){
%>

<div class="card bg-primary text-white mt-2">
	<div class="card-header">
		<h5>Add - <%=AnnotationUtil.getItemLabel(form.getTitle()) %></h5>
	</div>
</div>

<%
	}
	
	if(!dialogMode){
%>
<div class="card form-card" style="width:80%;">
<%
	}
--%>
<%---<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>"> --%>	
			
		<div class="container">
			<liferay-util:include page="/components/form/form-default-elements.jsp" servletContext="<%=application%>" />
			<liferay-util:include page="/components/form/form-group-elements.jsp" servletContext="<%=application%>" />
			<liferay-util:include page="/components/form/hidden-elements.jsp" servletContext="<%=application%>" />				
		
			<%--@ include file="/components/form/form-default-elements.jsp"--%>
			<%--@ include file="/components/form/form-group-elements.jsp"--%>	
			<%--@ include file="/components/form/hidden-elements.jsp"--%>
		</div>
<%--		<hr/>
		<div class="container">
			<%@ include file="/components/form/form-submit-buttons.jsp"%>
		</div>	
--%>			
<%--	</aui:form> --%>
<%--	
	if(!dialogMode){
%>	
</div>
<%
	}
--%>
<liferay-util:include page="/components/form/script-elements.jsp" servletContext="<%=application%>" />
<%--@ include file="/components/form/script-elements.jsp"--%>

