<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ include file="/init.jsp"%>

<%

String title = "Deputation Process";
String subTitle = "Fill all the form fields to go to the next step";
String endTitle = "Success!";
String endSubTitle = "The deputation details are submitted successfully!";
String formClass=PISFormConstant.DEPUTATIONPROCESSFLOW;//, com.adjecti.mdm.liferay.model.Address, com.adjecti.mdm.liferay.model.Contact";

%>
<portlet:renderURL var="deputationProcessFormRenderURL">
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>"/>
	<portlet:param name="title" value="<%=title %>"/>
	<portlet:param name="subTitle" value="<%=subTitle %>"/>
	<portlet:param name="endTitle" value="<%=endTitle %>"/>
	<portlet:param name="endSubTitle" value="<%=endSubTitle %>"/>
</portlet:renderURL>

<script>
//alert("OK before redirect ");
	window.location.href='<%=deputationProcessFormRenderURL.toString()%>';
</script>	
 <%--
<liferay-util:include page="/components/form/multi-step-form-flow.jsp" servletContext="<%=application%>">
	<liferay-util:param name="title" value="<%=title %>"/>
	<liferay-util:param name="subTitle" value="<%=subTitle %>"/>
	<liferay-util:param name="formClass" value="<%=formClass%>" />
</liferay-util:include>
 --%>