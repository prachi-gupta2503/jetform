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

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_add_jsp");
%>

<%
	response.setHeader("Cache-Control","max-age=0");

	
	//LOGGER.info(redirectPage);
	//formClassPK="301";
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	int formIndex = ParamUtil.getInteger(request, "formIndex", 0);
	String formId = ParamUtil.getString(request, "formId");
	String formClass=ParamUtil.getString(request, "formClass");
	
	
	HtmlFormWrapper form = (HtmlFormWrapper) request.getAttribute(formId);
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

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>
<!-- ============================================================== -->
<div class="card form-card">
	<div class="card-header header-primary">
		Add - <%=form.getTitle() %>
	</div>
	<div class="card-body">
		<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
				
			<div class="container">
			
				<%@ include file="/components/form/form-default-elements.jsp"%>
				<%@ include file="/components/form/form-group-elements.jsp"%>	
				<%@ include file="/components/form/hidden-elements.jsp"%>
				<div class="row">
					<div class="col-md-12">					
						<div class="form-group-autofit">
							<div class="form-group-item">
								<div class="btn-group">
									<div class="btn-group-item">
<%
	if(formIndex>1){
%>
										<input type="button" name="previous" class="btn btn-secondary previous action-button-previous" value="Previous" index="<%=formIndex%>">
<%
	}
%>										 
										<input type="button" name="next" class="btn btn-primary next action-button" value="Next Step" index="<%=formIndex%>">
											<%--<aui:button cssClass="btn btn-primary" type="submit" name="submit" value="submit"/> --%>
									</div>
										<%--<div class="btn-group-item">
											<aui:button cssClass="btn btn-primary" type="reset" name="reset" value="Reset"/>
										</div>
										
										<div class="btn-group-item">
											<aui:button cssClass="btn btn-primary" type="button" name="cancel" value="Cancel"/>
										</div> --%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>		
		</aui:form>
	</div>
</div>
<%--@ include file="/components/form/script-elements.jsp"--%>

