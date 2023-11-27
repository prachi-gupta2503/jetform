<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.util.ClassUtil"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.view002_jsp");
private static final String ACTION_ADD="add";
private static final String ACTION_EDIT="edit";
private static final String ACTION_LIST="list";
%>

<%

/*	String formClass=ParamUtil.getString(request, "formClass");
	HttpServletRequest hsRequest=PortalUtil.getOriginalServletRequest(request);
	
	Enumeration<String> en= hsRequest.getParameterNames();
	while(en.hasMoreElements()){
		String param=en.nextElement();
		LOGGER.info("param    :"+param+"  # value = ["+hsRequest.getParameter(param)+"]");
		
	}
*/
	String formClasses=ParamUtil.getString(request, "formClasses");
	String formClass=ParamUtil.getString(request, "formClass");
	String formAction=ParamUtil.getString(request, "formAction");
	String title=ParamUtil.getString(request, "title");
	String subTitle=ParamUtil.getString(request, "subTitle");
	String successPage=ParamUtil.getString(request, "successPage");
	String failurePage=ParamUtil.getString(request, "failurePage");
	
	if(StringUtils.isEmpty(formClass) || StringUtils.isEmpty(formAction)){
		HttpServletRequest hsRequest=PortalUtil.getOriginalServletRequest(request);
		
		if(StringUtils.isEmpty(formClasses)){
			formClasses=hsRequest.getParameter("formClasses");
		}
		
		if(StringUtils.isEmpty(formClass)){
			formClass=hsRequest.getParameter("formClass");
		}
		
		if(StringUtils.isEmpty(formAction)){
			formAction=hsRequest.getParameter("formAction");
		}
		
		if(StringUtils.isEmpty(successPage)){
			successPage=hsRequest.getParameter("successPage");
		}
		
		if(StringUtils.isEmpty(failurePage)){
			failurePage=hsRequest.getParameter("failurePage");
		}
		
		if(StringUtils.isEmpty(title)){
			title=hsRequest.getParameter("title");
		}
		
		if(StringUtils.isEmpty(subTitle)){
			subTitle=hsRequest.getParameter("subTitle");
		}
	}
	
	String mvcPath=null;
	String paramClassParam="formClass";
	String paramClassParamValue=formClass;
	if(StringUtils.isNotEmpty(formClasses)){
		mvcPath="/components/form/multi-step-form-flow.jsp";
		paramClassParam="formClasses";
		paramClassParamValue=formClasses;
	}else if(StringUtils.isEmpty(formAction) || StringUtils.equals(formAction, ACTION_LIST)){
		mvcPath="/components/list/form-list.jsp";
	}else if(StringUtils.equals(formAction, ACTION_ADD)){ 
		mvcPath="/components/form/form-add.jsp";
	}else if(StringUtils.equals(formAction, ACTION_EDIT)){ 
		mvcPath="/components/form/form-edit.jsp";
	}
	if(mvcPath!=null){
%>
<portlet:renderURL var="formRenderURL">
	<portlet:param name="mvcPath" value="<%=mvcPath%>" />
	<portlet:param name="<%=paramClassParam%>" value="<%=paramClassParamValue%>" />
	<portlet:param name="title" value="<%=title%>" />
	<portlet:param name="subTitle" value="<%=subTitle%>" />
	<portlet:param name="successPage" value="<%=successPage%>" />
	<portlet:param name="failurePage" value="<%=failurePage%>" />
</portlet:renderURL>
<script>
	window.location.href="<%=formRenderURL%>";
</script>
<%
	}else{
%>
	<h3>Jet Form Portlet</h3>
<%
	}
%>
	