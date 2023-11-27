<%@ include file="/init.jsp" %>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<portlet:actionURL name="addFormData" var="addFormURL" />
<aui:form action="${addOrUpdateRecordActionURL}" method="post" name="fm">
	<liferay-form:ddm-form-renderer
		ddmFormInstanceId="${formInstanceRecordId}"
		showSubmitButton="false" />

	<aui:button-row>
		<aui:button cssClass="btn btn-primary" id="submit-button"
			value="Submit Test" />
	</aui:button-row>
</aui:form>