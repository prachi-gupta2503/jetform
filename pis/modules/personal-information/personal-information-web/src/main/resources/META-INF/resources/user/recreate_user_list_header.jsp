<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_002dlist_restful_jsp");
private static final String TOP_ACTION_TEMPLTATE="top.action.template";
private static final String TOP_ACTION_TEMPLTATE_VALUE="/components/list/list-top-actions.jsp";
%>
<%--
formTitle - is defined in the form-list-restful.jsp
--%>

<style>
.buttons-excel{
	display:none !important;
}
</style>
<%
String topActionTemplate = ParamUtil.getString(request, TOP_ACTION_TEMPLTATE, TOP_ACTION_TEMPLTATE_VALUE);
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
String formTitle = AnnotationUtil.getItemLabel(form.getTitle());
%>
<portlet:renderURL var="ssoUserRenderURL">
	<portlet:param name="mvcPath" value="/user/recreate_user_list.jsp" />
	<portlet:param name="idamUserCreated" value="true" />
	
</portlet:renderURL>

<portlet:renderURL var="nonSsoUserRenderURL">
	<portlet:param name="mvcPath" value="/user/recreate_user_list.jsp" />
	<portlet:param name="idamUserCreated" value="false" />
	</portlet:renderURL>
	
<div class="page-header">
	<div class="row align-items-center">
		<div class="col-10">
			<!-- <h3 class="page-title">IDAM Users</h3> -->
			<ul class="nav nav-tabs">
			         <li id="ssouser" class="active"><a  href="<%=ssoUserRenderURL.toString()%>">SSO USER</a></li>
                     <li id="nonssouser" ><a href="<%=nonSsoUserRenderURL.toString()%>">NON-SSO USER</a></li>
                     
  
            </ul>
            
            </div>
            <div class="col-2 ">
            <ul class="nav nav-tabs" style="float:right;">
			         <li> <a id="exportExcelBtn" class="btn-primary active" >Export</a></li>
            </ul>
            
            </div>
		<div class="col-auto float-right ml-auto">
			<liferay-util:include page="<%=topActionTemplate%>" servletContext="<%=application%>">
			</liferay-util:include>	
		</div>
	</div>
</div>
<script>
$(document).ready(function(){	
	
		$("#ssouser").click(function(){
		removeClass=$('#nonssouser').removeClass("active");
		addClass=$('#ssouser').addClass("active");
		
	})
	
	
		$("#exportExcelBtn").click(function(){
			$(".buttons-excel").click();
		});
		
		$("#nonssouser").click(function(){
			setTimeout(function(){
		$('#ssouser').removeClass("active");
		$('#nonssouser').addClass("active");
	},500);
	
		
	})
})
</script>