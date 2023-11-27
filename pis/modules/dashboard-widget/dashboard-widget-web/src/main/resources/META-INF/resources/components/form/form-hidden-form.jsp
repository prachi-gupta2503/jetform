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

	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String formAction = ParamUtil.getString(request, "formAction");
	String formId = ParamUtil.getString(request, "formId");
	
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
	if(form==null){
		JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
		if(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0")){
			form=jetFormBuilderLocalService.getHtmlFormByClass(formClass);
		}else{
			form=jetFormBuilderLocalService.getHtmlFormByClass(formClass, formClassPK);
		}
	}
	pageContext.setAttribute("htmlForm", form);	
%>

<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>">
	<div class="container">
		<%@ include file="/components/form/hidden-elements.jsp"%>
	</div>		
</aui:form>

