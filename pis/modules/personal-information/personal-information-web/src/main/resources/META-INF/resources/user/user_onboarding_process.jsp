<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.pis.liferay.model.SingleUserOnboarding"%>
<%@page import="com.adjecti.pis.liferay.service.SingleUserOnboardingLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_add_jsp");
%>
<%

%>
<% 
User loginUser = themeDisplay.getUser();
boolean isApprover=loginUser.getRoles().stream().anyMatch(r->r.getName().equalsIgnoreCase("PIS Approver - Regular"));
   
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String formId = ParamUtil.getString(request, "formId");
	
if(!formClassPK.isEmpty()){
SingleUserOnboarding singleUserOnboarding=SingleUserOnboardingLocalServiceUtil.getSingleUserOnboarding(Long.parseLong(formClassPK));
if(singleUserOnboarding.getStatus()==1 || isApprover){
	request.setAttribute("viewOnlyMode",true);
}
}
%>
<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
</liferay-util:include>
<script>
$('#<portlet:namespace/><%=formId%>pisAccess_checkbox').prop('checked', true);


</script>