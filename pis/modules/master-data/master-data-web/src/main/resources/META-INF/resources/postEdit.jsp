<%@ include file="/init.jsp"%>
<%@page import="com.adjecti.mdm.liferay.service.PostOrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.PostOrganization"%>
<%@page import="com.adjecti.mdm.liferay.service.PostLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@ page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="com.adjecti.mdm.liferay.model.Post"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>




<%
	List<Designation> designations = DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);

	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	long postId = ParamUtil.getLong(request, "postId");

	Post post = PostLocalServiceUtil.getPost(postId);
	List<PostOrganization> postOrganizations = PostOrganizationLocalServiceUtil.getPostOrganizationsByPostId(postId);
%>

<script>
$(document).ready(function() {         
	 $("#<portlet:namespace/>isPostBox").prop("checked",<%=post.isPostBox()%>); 
	 $("#<portlet:namespace/>designationId").val('<%=post.getDesignationId()%>');
});
</script>



<portlet:actionURL name="updatePost" var="updatePostActionURL">
	<portlet:param name="mvcActionCommand" value="updatePost" />
</portlet:actionURL>

<aui:container>

	<aui:form action="${updatePostActionURL}" name="requestForm" method="POST">

		<aui:input name="postId" type="hidden" value="<%=postId%>" />


		<aui:input label="Code" name="code" type="" placeholder="Code" value="<%=post.getCode()%>">
			<aui:validator name="required" errorMessage="The code is a required field and allows (A-Z, 0-9) characters only." />
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>

		<aui:input label="Name(English)" name="name_En" type="text" placeholder="Name(English)" value="<%=post.getName_En()%>">
			<aui:validator name="required" errorMessage="The name is a required field and allows (A-Z) characters only." />
			<aui:validator name="alpha" />
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">100</aui:validator>
		</aui:input>

		<aui:input label="Name(Hindi)" name="name_Hi" type="text" placeholder="Name(Hindi)" value="<%=post.getName_Hi()%>">
			<aui:validator name="required" errorMessage="The name is a required field and allows (A-Z) characters only." />
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">100</aui:validator>
		</aui:input>

		<aui:select label="Designation" name="designationId" showEmptyOption="true">
			<aui:validator name="required" errorMessage="Select a designation." />
			<c:forEach var="designation" items="<%=designations%>">
				<aui:option value="${designation.designationId}">${designation.name_En}</aui:option>
			</c:forEach>
		</aui:select>

		<aui:input name="postBox" value="" type="checkbox" checked="<%=post.isPostBox()%>"/>

		<aui:input label="Description" name="description" type="textarea" placeholder="Description.." value="<%=post.getDescription()%>">
			<aui:validator name="minLength">1</aui:validator>
			<aui:validator name="maxLength">1024</aui:validator>
		</aui:input>
		<aui:select label="Organization" name="organizationIds" multiple="true">
			<aui:validator name="required" errorMessage="Select an organization." />
			<%
				for (Organization o : organizations) {
					boolean selected = false;
					for (PostOrganization po : postOrganizations) {
						if (o.getOrganizationId() == po.getOrganizationId()) {
							selected = true;
							break;
						}
					}
			%>
			<aui:option value="<%=o.getOrganizationId()%>" selected="<%=selected%>"><%=o.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>

		<aui:button-row>
			<aui:button name="submitButton" type="submit" value="Submit" />
			<aui:button type="button" name="close" value="close" />
		</aui:button-row>
	</aui:form>
</aui:container>
