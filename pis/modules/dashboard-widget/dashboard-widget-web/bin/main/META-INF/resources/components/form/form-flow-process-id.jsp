<%@page import="java.lang.reflect.Method"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%-- <%@page import="com.adjecti.pis.liferay.form.TransferProcessFlow"%> --%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="/init.jsp"%>
<%
//HtmlFormWrapper form;
if(form.getFormFlowKeyElement()!=null){
	String formFlowKeyValue="";
	if(formFlowClassPK>0){
		formFlowKeyValue=String.valueOf(formFlowClassPK);
	}
	
	if(form.getEntity()!=null && form.getPrimaryKey()!=null){
		Method method=ReflectionUtil.getGetterMethod(form.getEntityClass(), form.getFormFlowKeyElement().getName());
		Object savedFormFlowKeyValue=method.invoke(form.getEntity(), new Object[]{});
		if(savedFormFlowKeyValue!=null){
			formFlowKeyValue=String.valueOf(savedFormFlowKeyValue);
		}
	}
%>
<aui:input type="hidden" name="<%=form.getElementNamespace()+form.getFormFlowKeyElement().getName()%>" value="<%=formFlowKeyValue%>" cssClass="form-flow-key" />
<%
}
%>
