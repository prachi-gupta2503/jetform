<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
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
	
	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String formAction = ParamUtil.getString(request, "formAction");
	String redirectPage = ParamUtil.getString(request, "redirectPage","/components/list/form-list-restful.jsp");
	String formTitle = ParamUtil.getString(request, "formTitle","");
	boolean hideTitle = ParamUtil.getBoolean(request, "hideTitle",false);
	boolean hideSubmitAction = ParamUtil.getBoolean(request, "hideSubmitAction",false);
	
	boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);

			
	LOGGER.info("formClassPK : "+formClassPK);
	LOGGER.info("redirectPage : "+redirectPage);
	//formClassPK="301";
	
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form = null;
	if(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0")){
		form=JetFormBuilderLocalServiceUtil.getHtmlFormByClass(formClass);
	}else{
		form=JetFormBuilderLocalServiceUtil.getHtmlFormByClass(formClass, formClassPK);
		LOGGER.info(form.getEntity());
	}
	
	boolean editMode=(form.getEntity()!=null && form.getPrimaryKey()!=null);
	
	request.setAttribute("formId", form.getId());
	request.setAttribute(form.getId(), form);
	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	request.setAttribute("childFormCount", childFormCount);
	request.setAttribute("listElementCount", listElementCount);
	
	//pageContext.setAttribute("htmlForm", form);
	//request.setAttribute("htmlForm", form);
	
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
	<portlet:param name="mvcPath" value="<%=redirectPage%>" />
	<%--portlet:param name="redirect" value="<%=redirectPage%>" /> --%>
</portlet:actionURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="<%=redirectPage %>" />
</portlet:renderURL>



<%
	if(!dialogMode){
%>

<div class="card bg-primary text-white mt-2">
<%
if(!hideTitle){
%>
	<div class="card-header">
<%
	if(StringUtils.isBlank(formTitle)){
		if(StringUtils.isBlank(formClassPK)){
			formTitle="Add "+AnnotationUtil.getItemLabel(form.getTitle());
		}else{
			formTitle="Edit "+AnnotationUtil.getItemLabel(form.getTitle());
		}
	}
%>	
		<h5><%=formTitle%></h5>
	</div>
<%
}
%>	
</div>

<%
	}
	
	if(!dialogMode){
%>
<div class="card form-card" style="width:80%;">
<%
	}
%>
	<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
			
		<div class="container <%="container-"+form.getId().toLowerCase()%>">
			<liferay-util:include page="/components/form/form-default-elements.jsp" servletContext="<%=application%>" />
			<liferay-util:include page="/components/form/form-group-elements.jsp" servletContext="<%=application%>" />
			<%--@ include file="/components/form/form-default-elements.jsp"--%>
			<%--@ include file="/components/form/form-group-elements.jsp"--%>
			<liferay-util:include page="/components/form/hidden-elements.jsp" servletContext="<%=application%>" />				
			<%--@ include file="/components/form/hidden-elements.jsp"--%>
		</div>
<%
	if(!hideSubmitAction){
%>		
		
		<hr/>
		<div class="container">
		<liferay-util:include page="/components/form/form-submit-buttons.jsp" servletContext="<%=application%>" />
			<%--@ include file="/components/form/form-submit-buttons.jsp"--%>
		</div>	
<%
	}
%>		
		<div class="container">
				<liferay-util:include page="/components/form/list-elements.jsp" servletContext="<%=application%>" />
		
			<%--@ include file="/components/form/list-elements.jsp"--%>
		</div>
			
	</aui:form>
<%	
	if(!dialogMode){
%>	
</div>
<%
	}
%>

<%--@ include file="/components/form/script-elements.jsp"--%>
<liferay-util:include page="/components/form/script-elements.jsp" servletContext="<%=application%>" />				


