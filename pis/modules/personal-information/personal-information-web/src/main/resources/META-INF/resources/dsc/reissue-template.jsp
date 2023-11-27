<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeDscLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDsc"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("revoke-template.jsp");
%>
<%
String elementName=ParamUtil.getString(request, "elementName");
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");

LOGGER.info("savedValue::"+ savedValue);
User loginUser = themeDisplay.getUser();
Employee employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(loginUser.getEmailAddress());
boolean dscReissueable=EmployeeDscLocalServiceUtil.isDscReissueable(employee.getEmployeeId());
LOGGER.info("dscReissueable::"+ dscReissueable);
%>
<div class="row">
<div class="col-6">
<% 
if(StringUtils.equalsIgnoreCase(htmlElement.getDataType(), String.valueOf(Boolean.TYPE)) || StringUtils.equalsIgnoreCase(htmlElement.getDataType(), Boolean.class.getName())){
%>
<label style="margin-top:10px;"><input type="<%=htmlElement.getControlType()%>" name="<portlet:namespace/><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>" value="1">&nbsp;&nbsp;Reissue</label>
<%		

}else if(CollectionUtils.isEmpty(htmlElement.getListOptions()) && HtmlElement.ControlType.checkbox.name().equals(htmlElement.getControlType())){
	boolean checked=false;
	if(StringUtils.equalsIgnoreCase(savedValue, "1") || StringUtils.equalsIgnoreCase(savedValue, "true")){
		checked=true;
	}
	
%>
	<label style="margin-top:10px;"><input type="<%=htmlElement.getControlType()%>"  name="<portlet:namespace/><%=form.getElementNamespace()+htmlElement.getName()%>" id="<portlet:namespace/><%=form.getElementNamespace()+htmlElement.getName()%>"  class="<%=form.getId()+"_"+htmlElement.getControlType()%>" value="<%=1%>" <%=checked?"checked":"" %> >&nbsp;&nbsp;Reissue</label>
<%} %>
</div>
<div class= col-6>
<ul><li><strong>Reissue:</strong></li>
  <li>
    Use Certificate re-issue Only when Revocation has past 24 Hours and within 24 to 48hrs . Re-issue is process can take up to 24 hours .
     The confirmation mail with New re-issued certificate will be send on your mail 
  </li>
</ul>
</div>
</div>
<script>
$( document ).ready(function() {
	
	 var elementName="<%=form.getElementNamespace()+htmlElement.getName()%>"
	    if(<%=dscReissueable%>)
	    {	
	    	
	    	 $("#<portlet:namespace/>"+elementName). attr("disabled", false);
	    }
	    else {
	    	
	    	 $("#<portlet:namespace/>"+elementName). attr("disabled", true);
	    } 
}); 

</script>
