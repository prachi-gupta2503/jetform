<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.pis.liferay.model.Contact"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.pis.liferay.model.JoiningProcess"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ include file="/init.jsp"%>

<%
	
String title = "New Joining";
String subTitle = "Fill all the form fields to go to the next step";
String endTitle = "Success!";
String endSubTitle = "The joining details are submitted successfully!";
String formClass=PISFormConstant.JOININGPROCESSFORMFLOW;//, com.adjecti.mdm.liferay.model.Address, com.adjecti.mdm.liferay.model.Contact";
%>
<portlet:renderURL var="employeeJoiningRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/joiningProcess.jsp" />
</portlet:renderURL>

<liferay-util:include page="/components/form/multi-step-form-flow.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=formClass%>"/>
	<liferay-util:param name="title" value="<%=title%>"/>
	<liferay-util:param name="subTitle" value="<%=subTitle%>"/>
	<liferay-util:param name="endTitle" value="<%=endTitle%>"/>
	<liferay-util:param name="endSubTitle" value="<%=endSubTitle%>"/>
	<liferay-util:param name="redirectUrl" value="/employee/joiningProcess.jsp"/>
</liferay-util:include>

<script>
//alert("OK before redirect ");
<%--	window.location.href='<%=joiningProcessFormRenderURL.toString()%>'--%>;
</script>	
 <%--
<liferay-util:include page="/components/form/multi-step-form-flow.jsp" servletContext="<%=application%>">
	<liferay-util:param name="title" value="<%=title %>"/>
	<liferay-util:param name="subTitle" value="<%=subTitle %>"/>
	<liferay-util:param name="formClass" value="<%=formClass%>" />
</liferay-util:include>
 --%>