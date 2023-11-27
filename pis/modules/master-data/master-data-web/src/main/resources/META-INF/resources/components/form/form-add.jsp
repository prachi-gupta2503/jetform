<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationScopeLocalServiceUtil"%>
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
<%@page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ include file="/init.jsp"%>

<link href="<%=request.getContextPath()%>/css/select2.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>
<style>

.select2-container--default .select2-selection--single .select2-selection__rendered{  
    font-size: 15px !important;
    
}

.select2-container{
	height: 44px !important;
    width:100% !important;
    background-color: #f1f2f5 !important;
    border-color: #e7e7ed !important;
    border-style: solid !important;
    border-bottom-width: 0.0625rem !important;
    border-left-width: 0.0625rem !important;
    border-right-width: 0.0625rem !important;
    border-top-width: 0.0625rem !important;
    border-radius: 0.25rem !important;
    box-shadow: 0 0 rgb(0 0 0 / 0%) !important;
    color: #272833 !important;
    display: block !important;
    font-size: 1rem !important;
    font-weight: 400 !important;
    /*height: 2.7rem;*/
    line-height: 1.5 !important;
    min-width: 0 !important;
    /*padding-bottom: 0.4375rem !important;*/
    padding-bottom: 0.01rem !important;
    padding-left: 0.01rem !important;
    padding-right: 0.01rem !important;
    padding-top: 0.01rem !important;
}
.select2-container .select2-selection--single {
    
    height: 42px !important;

}
</style>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_add_jsp");

private static final String ACTION_REDIRECT_URL="action.redirect.url";
private static final String ACTION_REDIRECT_URL_VALUE="/components/list/form-list-restful.jsp";
%>

<%
	response.setHeader("Cache-Control","max-age=0");
	int listElementCount=0;
	int childFormCount=0;

	String formClass = StringUtils.trim(ParamUtil.getString(request, "formClass"));
	String formClassPK = StringUtils.trim(ParamUtil.getString(request, "formClassPK"));
	String redirectPage = ParamUtil.getString(request, "redirectPage");
	String strDialogMode = ParamUtil.getString(request, "dialogMode");
	String redirectionUrl = ParamUtil.getString(request, ACTION_REDIRECT_URL, ACTION_REDIRECT_URL_VALUE);
	boolean dialogMode = (StringUtils.equalsIgnoreCase(strDialogMode,"true") || StringUtils.equalsIgnoreCase(strDialogMode,"yes"));
	
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form = null;
	
	if(StringUtils.isBlank(formClassPK) || StringUtils.equals(formClassPK, "0")){
		form=JetFormBuilderLocalServiceUtil.rendererForm(formClass);
	}else{
		System.out.println("formClassPK"+ formClassPK);
		form=JetFormBuilderLocalServiceUtil.rendererForm(formClass, formClassPK);
	}
	
	if(form.getId()==null){
		form.setId(form.getFormClass()+"_"+12345);
	}
	Class formCls=FormEntityCache.getFormClass(form.getFormClass());
	ExpandoBridge expandoBridge=null;
	
	try{
		if(StringUtils.isNotBlank(formClassPK)){
			Method expMethod=formCls.getMethod("getExpandoBridge", new Class[]{});
			expandoBridge=(ExpandoBridge)expMethod.invoke(form.getEntity(), new Object[]{});
		}else{
			expandoBridge=ExpandoBridgeFactoryUtil.getExpandoBridge(themeDisplay.getCompanyId(), form.getEntityClass());
		}
	}catch(Exception exp){}
	
	pageContext.setAttribute("htmlForm", form);
	request.setAttribute("htmlForm", form);
	request.setAttribute("form", form);
	request.setAttribute("formId", form.getId());
	request.setAttribute(form.getId(), form);
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
	<portlet:param name="mvcPath" value="<%=redirectionUrl %>" />
	<portlet:param name="redirect" value="<%=redirectPage%>" />
	<portlet:param name="status" value="true" />
</portlet:actionURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="<%=redirectionUrl %>" />
</portlet:renderURL>

<%
	if(!dialogMode){
%>
<div class="card bg-primary text-white mt-2">
	<div class="card-header">
		<h5><%=(StringUtils.isBlank(formClassPK)?"Add":"Edit")%> - <%=AnnotationUtil.getItemLabel(form.getTitle()) %></h5>
	</div>
</div>
<div class="card form-card" style="width:80%;">
	<div class="card-body">
<%
	}else{
%>	
	<div class="mt-3"></div>
<%
	}
%>
		<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
				
			<div class="container">
				<%--<div class="row">
					<div class="col-md-12">	
						<h3>Add <%=form.getTitle() %></h3>
					</div>
				</div> --%>
		
				<%@ include file="/components/form/form-default-elements.jsp"%>
				<%@ include file="/components/form/form-group-elements.jsp"%>	
				<%@ include file="/components/form/hidden-elements.jsp"%>
			</div>	
			<hr/>
			<div class="container">
				<%@ include file="/components/form/form-submit-buttons.jsp"%>
			</div>	
			<div class="container">
				<%@ include file="/components/form/list-elements.jsp"%>
			</div>
		</aui:form>
<%
	if(!dialogMode){
%>		
	</div>
</div>
<%
	}
%>
<%@ include file="/components/form/script-elements.jsp"%>

