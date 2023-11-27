<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.pis.liferay.model.ProcessFile"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ include file="/init.jsp"%>

<%

String title = "Transfer Process";
String subTitle = "Fill all the form fields to go to the next step";
String endTitle = "Success!";
String endSubTitle = "The Transfer details are submitted successfully!";
%>

<portlet:renderURL var="transferProcessFormRenderURL">
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.TRANSFERPROCESSFLOW%>"/>
	<portlet:param name="title" value="<%=title %>"/>
	<portlet:param name="subTitle" value="<%=subTitle %>"/>
	<portlet:param name="endTitle" value="<%=endTitle %>"/>
	<portlet:param name="endSubTitle" value="<%=endSubTitle %>"/>
</portlet:renderURL>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<button class="btn btn-primary" id="btn-new-transfer">New Transfer</button>
		</div>
	</div>
</div>
<%
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper transferProcessForm=JetFormBuilderLocalServiceUtil.rendererForm(PISFormConstant.TRANSFERPROCESSFLOW);
	request.setAttribute("form-"+PISFormConstant.TRANSFERPROCESSFLOW, transferProcessForm);
%>

<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=PISFormConstant.TRANSFERPROCESSFLOW%>" />
</liferay-util:include>

<%
String formFlowKeyCssClass="";
HtmlElementWrapper htmlElement=transferProcessForm.getFormFlowKeyElement();
if(htmlElement!=null){
	formFlowKeyCssClass="form-flow-key";
%>
	<aui:input type="hidden" name="<%=transferProcessForm.getElementNamespace()+htmlElement.getName()%>" value="" cssClass="<%=formFlowKeyCssClass%>"/>
<%
}
%>
<script>
$(document).ready(function(){
	$("#btn-new-transfer").click(function(){
		window.location.href='<%=transferProcessFormRenderURL.toString()%>';
	})
});

function <portlet:namespace/><%=transferProcessForm.getId()%>editBeforeOnClick(actionSource){
	window.location.href='<%=transferProcessFormRenderURL.toString()%>&<portlet:namespace/>formClassPK='+($(actionSource).attr("data-key"));
}
</script>	
