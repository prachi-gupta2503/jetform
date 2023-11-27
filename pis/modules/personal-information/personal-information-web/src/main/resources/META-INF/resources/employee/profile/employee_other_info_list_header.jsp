<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.pis.liferay.constant.PISUserRole"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@ include file="/init.jsp"%>
<% 
boolean profileEditor=false;
profileEditor=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));
String formClass = null;
String[] formClasses=ParamUtil.getStringValues(request, "formClass");
boolean hasSubFormAndList=false;
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

if(formClasses!=null && formClasses.length>0){
	formClass=formClasses[formClasses.length-1];
}
if(profileEditor){
		
	
%>
	<div class="row" style="display:none;">
		<div class="col-md-12" id="<portlet:namespace/><%=form.getId()%>dataTable_addAction">

<%
	if(formClass.indexOf("Joining")<0){
%>		
			<a title="Add" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fas fa-plus-circle text-white" style="font-size: 1.5em;" aria-hidden="true"></i></a>
<%
	}
%>			
		</div>
	</div>
<%
	}
/*	}*/
%>			