<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletResponseUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
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

<%	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	String formClassPK = ParamUtil.getString(request, "formClassPK");
	
	int listElementCount=0;
	if(request.getAttribute("listElementCount")!=null){
		listElementCount=(Integer)request.getAttribute("listElementCount");
	}
	//HtmlFormWrapper form;
	for (HtmlElementWrapper e : form.getElements()) {
		
		/** This to check if the field values are set in paramater 
		 ** and element is set as hidden **/
		if(!e.isControlType(HtmlElement.ControlType.list)){
			continue;
		}
		String presetFieldValue  = ParamUtil.getString(request, e.getName());
		String presetHiddenField = ParamUtil.getString(request, e.getName()+".hidden");
		
		boolean isPresetHidden=(StringUtils.equalsIgnoreCase(presetHiddenField, "true") || StringUtils.equalsIgnoreCase(presetHiddenField, "yes"));
		if(isPresetHidden){
			continue;
		}
		
		listElementCount++;
		request.setAttribute("listElementCount", listElementCount);
		
		String childListClass=e.getFormClass();
		request.setAttribute("htmlElement", e);
%>
	<div class="row">
		<div class="col-md-12">
			<label for="<%=e.getName()%>"><%=e.getLabel()%></label>
			<aui:input type="hidden" name="<%=form.getElementNamespace()+"childList"+e.getName()%>" value="<%=e.getName()%>"/>
		</div>
	</div>
	<liferay-util:include page="/components/form/list-element.jsp" servletContext="<%=application%>">
		<liferay-util:param name="childListClass" value="<%=childListClass%>" />
		<liferay-util:param name="parentClassName" value="<%=form.getEntityClass()%>" />
		<liferay-util:param name="parentClassPKName" value="<%=form.getKeyElement().getName()%>" />
		<liferay-util:param name="<%=form.getKeyElement().getName() %>" value="<%=String.valueOf(formClassPK)%>" />
	</liferay-util:include>
	
		
<%
	}
%>