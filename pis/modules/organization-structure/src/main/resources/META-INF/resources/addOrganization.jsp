<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.RepositoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.liferay.organization.web.constants.MVCCommandNames"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.util.MDMUtils"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.mdm.liferay.util.OrganizationUtils"%>
<%-- <%@page import="com.liferay.expando.kernel.model.ExpandoValue"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoTableConstants"%>
<%@page import="com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoColumn"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoTable"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil"%> --%>

<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>

<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>

<%@include file="/init.jsp"%>
<%@ include file="/organizationUrl.jsp"%>

<portlet:actionURL name="<%=MVCCommandNames.SAVEORGANIZATION%>" var="createOrganizationURL" />

<%
	final String FOLDER_NAME = "OrganizationImages";
	final long FOLDER_ID = DLAppServiceUtil.getFolder(scopeGroupId, 0, FOLDER_NAME).getFolderId();
	final long REPOSITORY_ID = scopeGroupId;
	Organization organization = null;
	String imageUrl = null;

	long organizationId = Long.parseLong(request.getParameter("id"));
	long parentId = ParamUtil.getLong(request, "parentId");
	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	List<String> organizationTypes = MDMUtils.getOrganizationTypes();

	if (organizationId > 0) {
		organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		organizations = organizations.stream().filter(org -> org.getOrganizationId() != organizationId)
				.map(org -> org).collect(Collectors.toList());
		
		
		if (organization.getLogoId() > 0) {
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(organization.getLogoId());
			imageUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
					+ themeDisplay.getScopeGroupId() + "/" + fileEntry.getFolderId() + "/"
					+ fileEntry.getTitle() + "/" + fileEntry.getUuid() + "?t=" + fileEntry.getFileEntryId()
					+ "&download=true";
		}
	}
	/* 	long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getTable(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, "CUSTOM_FIELDS");
		ExpandoColumn expandoColumn =  ExpandoColumnLocalServiceUtil.getColumn(ServiceContextThreadLocal.getServiceContext().getCompanyId(), classNameId, expandoTable.getName(), "Organization Type");
		expandoColumn.getDefaultData();
		String[] defaultData=expandoColumn.getDefaultData().split(",");
		
		ExpandoValue ev=ExpandoValueLocalServiceUtil.getValue(expandoTable.getTableId(), expandoColumn.getColumnId(), organizationId);
	 */
%>

<div class="m-4">
	<aui:form action="<%=createOrganizationURL%>" name="<portlet:namespace />fm" enctype="multipart/form-data">
		<div class="form-group-item">
			<aui:input name="organizationId" id="organizationId" type="hidden" value="<%=organization == null ? 0 : organization.getOrganizationId()%>" />
		</div>

		<div class="form-group-item m-2">
			<aui:input label="Short Name" name="shortName" id="shortName" type="text" value="<%=organizationDetail == null ? "" : organizationDetail.getShortName()%>" required="true" />
		</div>

		<div class="form-group-item m-2">
			<aui:input label="Name" name="name" id="name" type="text" value="<%=organization == null ? "" : organization.getName()%>" required="true" />
		</div>

		<div class="form-group-item m-2">

			<aui:select class="form-control" name="organizationTypeId" required="true" label="Organization Type">
				<!-- <option value="0">select parent organization</option> -->
				<%
					for (String organizationType : organizationTypes) {
				%>
				<option value="<%=organizationType%>"
					<%=organizationDetail == null
								? ""
								: (organizationType.getOrganizationTypeId() == organizationDetail
										.getOrganizationTypeId() ? "selected" : "")%>><%=organizationType.getName()%></option>
				<%
					}
				%>
			</aui:select>

		</div>
		<div class="form-group-item m-2">
			<aui:select class="form-control" name="parentId" required="true" value="<%=organization == null ? 0 : organization.getParentOrganizationId()%>" label="Parent Organization">
				<!-- <option value="0">select parent organization</option> -->
				<%
					for (Organization org : organizations) {
				%>
				<option value="<%=org.getOrganizationId()%>"
					<%=organization == null
								? ((org.getOrganizationId() == parentId) ? "selected" : "")
								: (org.getOrganizationId() == organization.getParentOrganizationId()
										? "selected"
										: "")%>><%=org.getName()%></option>
				<%
					}
				%>
			</aui:select>
		</div>
		<div class="form-group-item m-2">
			<div class="row">
				<div class="col-4">
					<aui:input type="file" name="organizationImage" label="Select Image" accept="image/*"></aui:input>
					<aui:input type="hidden" name="imageId"></aui:input>
				</div>
				<div class="col-1" style="margin-top: 4%;">
					<%
						if (organizationDetail != null && organizationDetail.getImageId() > 0) {
					%>
					<a href="<%=imageUrl%>">download</a>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<div class="btn-group mt-2 mb-2" style="margin-left: 5px;">
			<div class="btn-group-item">
				<aui:button cssClass="btn btn-sm btn-primary rounded-0" id="addbtn" name="addbtn" type="submit"></aui:button>
			</div>
			<div class="btn-group-item">
				<aui:button cssClass="btn btn-sm btn-dark rounded-0" onClick="closePopup()" name="<portlet:namespace/>close" value="Close"></aui:button>
			</div>
		</div>

	</aui:form>
</div>
<script>
	function closePopup() {
		Liferay.Util.getOpener().<portlet:namespace/>closePopup(
				'<portlet:namespace />popUpId', '');
	}
</script>

<aui:script>
 $('#<portlet:namespace />organizationImage').change(function(e) {
        uploadFile(e.target.files[0]);
    });


function uploadFile(file) {

    var fileName = file.name;
    var title = Date.now() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    var description = fileName + " is uploaded on " + new Date();
    var form = new FormData();
    form.append("file", file, file.name);
    form.append("repositoryId", "<%=REPOSITORY_ID%>");
    form.append("folderId", "<%=FOLDER_ID%>");
    form.append("sourceFileName", file.name);
    form.append("mimeType", file.type);
    form.append("title", title);
    form.append("description", description);
    form.append("changeLog", "Uploaded");
    form.append("p_auth", Liferay.authToken);

    var settings = {
        "url": "/api/jsonws/dlapp/add-file-entry",
        "method": "POST",
        "timeout": 0,
        "headers": {},
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": form
    };

    $.ajax(settings).done(function(response) {
     $('#<portlet:namespace />imageId').val(JSON.parse(response).fileEntryId);
    }); 
}

</aui:script>