<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@ page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="addPost" var="addPostActionURL">
	<portlet:param name="mvcActionCommand" value="addPost" />
</portlet:actionURL>

<%
	List<Designation> designations = DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);

	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
%>
<aui:container>
	<aui:form action="${addPostActionURL}" name="requestForm" method="POST">

		<aui:input label="Code" name="code" placeholder="Code">
			<aui:validator name="required" errorMessage="The code is a required field and allows (A-Z, 0-9) characters only." />
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>

		<aui:input label="Name(English)" name="name_En" type="text" placeholder="Name(English)">
			<aui:validator name="required" errorMessage="The name is a required field and allows (A-Z) characters only." />
			<aui:validator name="alpha" />
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">100</aui:validator>
		</aui:input>

		<aui:input label="Name(Hindi)" name="name_Hi" type="text" placeholder="Name(Hindi)">
			<aui:validator name="required" errorMessage="The name is a required field and allows (A-Z) characters only." />
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">100</aui:validator>
		</aui:input>

		<aui:select label="Select Designation" name="designationId" showEmptyOption="true">
			<aui:validator name="required" errorMessage="Select a designation." />
			<c:forEach var="designation" items="<%=designations%>">
				<aui:option value="${designation.designationId}">${designation.name_En}</aui:option>
			</c:forEach>
		</aui:select>

		<label for="Post Box">Post Box</label>
		<aui:field-wrapper name="Post Box">
			<aui:input name="postBox" type="checkbox">
			</aui:input>
		</aui:field-wrapper>

		<aui:input label="Description" name="description" type="textarea" placeholder="Description..">
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">1024</aui:validator>
		</aui:input>
		<aui:select label="Select Organization:" name="organizationIds" showEmptyOption="true" multiple="true">
			<aui:validator name="required" errorMessage="Select an organization." />
			<c:forEach var="organization" items="<%=organizations%>">
				<aui:option value="${organization.organizationId}">${organization.name}</aui:option>
			</c:forEach>
		</aui:select>

		<aui:button-row>
			<aui:button name="submitButton" type="submit" value="Submit" />
			<aui:button type="button" name="close" value="close" />
		</aui:button-row>
	</aui:form>
</aui:container>
