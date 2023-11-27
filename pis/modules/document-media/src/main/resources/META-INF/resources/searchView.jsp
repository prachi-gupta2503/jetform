<%@page import="com.adj.liferay.documentmedia.constants.MVCCommandName"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil"%>
<%@page
	import="com.liferay.document.library.kernel.model.DLFileEntryType"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>

<%
	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	List<DLFileEntryType> dlFileEntryTypes = DLFileEntryTypeLocalServiceUtil
			.getDLFileEntryTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<portlet:renderURL var="searchDocumentURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandName.SEARCHDOCUMENT%>" />
</portlet:renderURL>
<aui:form action="<%=searchDocumentURL%>"
	name="<portlet:namespace />fm">
	<div>
		<div class="row">
			<div class="col">
				<aui:select class="form-control" label="Organization"
					name="organization" id="organization">
					<aui:option value="-1">Select Organization</aui:option>
					<%
						for (Organization organization : organizations) {
									String optionText = organization.getName();
									long optionValue = organization.getOrganizationId();
					%>
					<aui:option value="<%=optionValue%>"><%=optionText%>
					</aui:option>
					<%
						}
					%>
				</aui:select>
			</div>
			<div class="col">
				<aui:select class="form-control" label="Document Type"
					name="documentType" id="documentType">
					<aui:option value="-1" selected="true">Select Document Type</aui:option>
					<%
						for (DLFileEntryType dlFileEntryType : dlFileEntryTypes) {
									String optionText = dlFileEntryType.getName();
									long optionValue = dlFileEntryType.getFileEntryTypeId();
					%>
					<aui:option value="<%=optionValue%>"><%=optionText%>
					</aui:option>
					<%
						}
					%>
				</aui:select>
			</div>
			<div class="col">
				<aui:select class="form-control" label="Status" name="status"
					id="status">
					<aui:option value="-1">Select Status</aui:option>
					<aui:option value="1">Active</aui:option>
					<aui:option value="2">Deleted</aui:option>
					<aui:option value="3">Archived</aui:option>

				</aui:select>
			</div>
			<div class="col">
				<aui:select class="form-control" label="Uploaded Duration"
					name="duration" id="duration">
					<aui:option value="-1">Select Uploaded Duration</aui:option>
					<aui:option value="1">Within This Weak</aui:option>
					<aui:option value="2">Within This Month</aui:option>
					<aui:option value="3">Within Last 3 Months</aui:option>
					<aui:option value="4">Within Last 6 Months</aui:option>
					<aui:option value="5">Within Last 1 Year</aui:option>
					<aui:option value="6">Within Last 2 Years</aui:option>
				</aui:select>
			</div>

			<div class="col">
				<span class="aui-search-bar"> <aui:input
						inlineField="<%=true%>" label="Search Keyword" id="keywords"
						name="keywords" size="30" title="search-entries" type="text"
						placeholder="Search KeryWord"  />
				</span>
			</div>
			<div class="col mt-4">
				<aui:button type="submit" cssClass="fas fa-search" value="Search"></aui:button>

			</div>
		</div>
	</div>
</aui:form>

