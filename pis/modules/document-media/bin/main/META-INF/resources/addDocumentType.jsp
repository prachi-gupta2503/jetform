<%@page import="com.adj.liferay.documentmedia.constants.MVCCommandName"%>
<%@ include file="/init.jsp" %>
<portlet:actionURL name="<%=MVCCommandName.DOCUMENTTYPE_ADD%>" var="addDocumentTypeUrl"/>


<div class="form-card">

<aui:form action="<%=addDocumentTypeUrl%>" name="<portlet:namespace />fm">
       <aui:input name="name"  class="form-control" label="Name"/>

	   <aui:input label="Description" name="description"  class="form-control" type="textarea" />


	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</aui:form>
</div>