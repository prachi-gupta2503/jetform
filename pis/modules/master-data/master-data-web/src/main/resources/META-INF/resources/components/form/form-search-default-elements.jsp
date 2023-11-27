<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="java.util.Random"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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

<%
	if(form.getElements().size()>0){
	Class[] blankTypes=new Class[]{};
	Object[] blankParams=new Object[] {};
	Class formClazz=FormEntityCache.getFormClass(form.getFormClass());
	Class entityClazz=FormEntityCache.getFormClass(form.getEntityClass());

	if(entityClazz==Object.class){
		entityClazz=formClazz;
	}
	
	for (HtmlElementWrapper e : form.getElements()) {
		if(e.isTransientElement() || !e.isSeachable()){
			continue;
		}
		pageContext.setAttribute("htmlElement", e);
		pageContext.setAttribute("elementName", e.getName());
		String value="";
		if(form.getEntity()!=null && form.getPrimaryKey()!=null){
			try{
				Method m=entityClazz.getMethod("get"+StringUtils.capitalize(e.getAttribute()), blankTypes);
				value=String.valueOf(m.invoke(form.getEntity(), blankParams));
				pageContext.setAttribute(e.getName()+"_savedValue", value);
			}catch(Exception ex){
				LOGGER.warn("No value found for "+e.getName()+" and attribute "+StringUtils.capitalize(e.getAttribute()));
			}
		}
		
		if(e.isControlType(HtmlElement.ControlType.hidden) || e.isKey()){
			continue;
		}
%>
<%-- 	<div class="row">
		<div class="col-md-12">--%>
			<div class="form-group-autofit search-field-group">
				<div class="form-group-item">
					<label for="<%=e.getName()%>"><%=e.getLabel()%></label>
<%	
		if(e.isControlType(HtmlElement.ControlType.select) || e.isControlType(HtmlElement.ControlType.multiSelect)){
%>
			<liferay-util:include page="/components/form/select-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>					
<%
		}else if(e.isControlType(HtmlElement.ControlType.country)){
%>
			<liferay-util:include page="/components/form/country-select.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.checkbox) || e.isControlType(HtmlElement.ControlType.radio)){
%>
			<liferay-util:include page="/components/form/checkbox-radio-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.datetime) || e.isControlType(HtmlElement.ControlType.date)){
%>
			<liferay-util:include page="/components/form/datetime-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.text) || e.isControlType(HtmlElement.ControlType.textarea)){
%>
			<liferay-util:include page="/components/form/text-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.year)){
%>
			<liferay-util:include page="/components/form/year-select-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}
%>
				</div>
			</div>
<%--		</div>
	</div> --%>
<%		
		
	}
}	
%>
