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
<%@page import="com.adjecti.jetform.liferay.constants.MVCCommandNames"%>
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

<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<%--script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script> --%>
<link href="<%=request.getContextPath()%>/css/select2.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>
<%--<link rel="stylesheet" href="<%=request.getContextPath()%>/fonts/font-awesome/css/font-awesome.min.css"> --%>

<%@ include file="/init.jsp"%>

<%!
//private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_add_jsp");
%>

<%--
	response.setHeader("Cache-Control","max-age=0");

	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String redirectPage = ParamUtil.getString(request, "redirectPage");
	
	LOGGER.info(redirectPage);
	//formClassPK="301";
	
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form = null;
	if(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0")){
		form=jetFormBuilderLocalService.getHtmlFormByClass(formClass);
	}else{
		form=jetFormBuilderLocalService.getHtmlFormByClass(formClass, formClassPK);
	}
	
	pageContext.setAttribute("htmlForm", form);
	
--%>

<%--

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/json.jsp" />
</portlet:resourceURL> 

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>

--%>

<portlet:actionURL name="searchForm" var="searchFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
<%--	<portlet:param name="redirect" value="<%=redirectPage%>" /> --%>
</portlet:actionURL>


<div class="card search-card">
	<div class="card-header header-primary">
		Advance Search<%-- - <%=form.getTitle() %> --%><i id="advSearch_Close" class="fa fa-times float-right" aria-hidden="true"></i>
	</div>	
	<div class="card-body ">
		<aui:form action="<%=searchFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
				
			<%--<div class="container">
				<div class="row">
					<div class="col-md-12">	
						<h3>Add <%=form.getTitle() %></h3>
					</div>
				</div> --%>
		
				<%@ include file="/components/form/form-search-default-elements.jsp"%>
<%--				<%@ include file="/components/form/form-group-elements.jsp"%>	
				<%@ include file="/components/form/hidden-elements.jsp"%>
--%>				
					<%-- <div class="row">
					<div class="col-md-12">		--%>			
						<div class="form-group-autofit search-field-button-group">
							<div class="form-group-item">
								<div class="btn-group">
									<div class="btn-group-item">
										<aui:button cssClass="btn btn-primary" type="submit" name="<portlet:namespace/>search" value="Search"/>
									</div>
									
									<div class="btn-group-item">
										<aui:button cssClass="btn btn-primary" type="button" name="<portlet:namespace/>cancel" value="Cancel" onClick="renderFormList()"/>
									</div>
								</div>
							</div>
						</div>
		<%--			</div>
				</div>
			</div>	 --%>	
		</aui:form>
	</div>
</div>
<%--
<%@ include file="/components/form/script-elements.jsp"%>
 --%>
 

