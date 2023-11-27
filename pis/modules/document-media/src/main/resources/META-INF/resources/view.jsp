<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.OrganizationLocalServiceWrapper"%>
<%@page
	import="com.liferay.document.library.kernel.model.DLFileEntryType"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.calendar.service.CalendarLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.DateFormatFactoryImpl"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoValue"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoRowLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoColumn"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoTable"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="com.adj.liferay.documentmedia.constants.MVCCommandName"%>
<%@page
	import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ include file="/init.jsp"%>
<%@ include file="/searchView.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>


<script src="<%=request.getContextPath()%>/js/popper.min.js" /></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" /></script>
<portlet:renderURL var="setRetentionURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/setRetention-select.jsp" />
</portlet:renderURL>
<%
List<DLFileEntry> dlFileEntries = (List<DLFileEntry>) request.getAttribute("dlFileEntries");
if(dlFileEntries==null){
	dlFileEntries=DLFileEntryLocalServiceUtil.getFileEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
}
	System.out.println(dlFileEntries.size() + " : dlFileEntries jsp");
%>
<div class="container">

	<div class="row">
		<div class="col-md-12">

			<span class="dropdown"> <a href="#" class="link-btn"
				data-toggle="dropdown">Add Document <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<%
						for (DLFileEntryType dlFileEntryType : dlFileEntryTypes) {
							String fileEntryTypeName = dlFileEntryType.getName();
							long fileEntryTypeId = dlFileEntryType.getFileEntryTypeId();
					%>
					<li><a
						href="/group/guest/~/control_panel/manage?p_p_id=com_liferay_document_library_web_portlet_DLAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&_com_liferay_document_library_web_portlet_DLAdminPortlet_mvcRenderCommandName=%2Fdocument_library%2Fedit_file_entry&_com_liferay_document_library_web_portlet_DLAdminPortlet_cmd=add&_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect=%2Fgroup%2Fguest%2Fdownloads?_com_liferay_document_library_web_portlet_DLAdminPortlet_mvcRenderCommandName%3D%252Fdocument_library%252Fview%26_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect%3Dhttp%253A%252F%252Flocalhost%253A8080%252Fgroup%252Fguest%252F~%252Fcontrol_panel%252Fmanage%253Fp_p_id%253Dcom_liferay_document_library_web_portlet_DLAdminPortlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dmaximized%2526p_p_mode%253Dview%2526_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect%253Dhttp%25253A%25252F%25252Flocalhost%25253A8080%25252Fgroup%25252Fguest%25252F%25257E%25252Fcontrol_panel%25252Fmanage%25253Fp_p_id%25253Dcom_liferay_document_library_web_portlet_DLAdminPortlet%252526p_p_lifecycle%25253D0%252526p_p_state%25253Dmaximized%252526p_p_mode%25253Dview%252526p_p_auth%25253D6TcZYue3%2526_com_liferay_document_library_web_portlet_DLAdminPortlet_navigation%253Dfile_entry_types%2526p_p_auth%253D7dcNjmkw%26p_p_auth%3D7dcNjmkw&_com_liferay_document_library_web_portlet_DLAdminPortlet_repositoryId=37150&_com_liferay_document_library_web_portlet_DLAdminPortlet_folderId=0&_com_liferay_document_library_web_portlet_DLAdminPortlet_fileEntryTypeId=<%=fileEntryTypeId%>&p_p_auth=7dcNjmkw %>&p_p_auth=7dcNjmkw"><%=fileEntryTypeName%></a></li>
					<%
						}
					%>
				</ul>
			</span> <a
				href="/group/guest/~/control_panel/manage?p_p_id=com_liferay_document_library_web_portlet_DLAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_document_library_web_portlet_DLAdminPortlet_mvcRenderCommandName=%2Fdocument_library%2Fedit_file_entry_type&_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect=%2Fgroup%2Fguest%2Fdownloads"
				class="link-btn"> Add Document Type</a>
			<p></p>

		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered table-heading-nowrap">
				<thead class="thead-dark">
					<tr>

						<th scope="col">S.no</th>
						<th scope="col">Unit / Organization</th>
						<th scope="col">Title</th>
						<th scope="col">Description</th>
						<th scope="col">Document Type</th>
						<th scope="col">Created / Modified By</th>
						<th scope="col">Created / Modified Date</th>
						<th scope="col">DownLoad</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<%
					int count = 0;
					for (DLFileEntry dlFileEntry : dlFileEntries) {
				%>
				<portlet:resourceURL id="<%=MVCCommandName.DOCUMENTMEDIA_DOWNLOAD%>"
					var="dowloadMediaURL">
					<portlet:param name="downloadId"
						value="<%=String.valueOf(dlFileEntry.getFileEntryId())%>" />
				</portlet:resourceURL>
				<portlet:actionURL name="<%=MVCCommandName.DOCUMENTMEDIA_DELETE%>"
					var="deleteDocumentUrl">
					<portlet:param name="deleteId"
						value="<%=String.valueOf(dlFileEntry.getFileEntryId())%>" />
				</portlet:actionURL>

				<%
					String documentType = DLFileEntryTypeLocalServiceUtil
								.getDLFileEntryType(dlFileEntry.getFileEntryTypeId()).getName();
						SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
						String dfFileEntryEditUrl = "/group/guest/~/control_panel/manage?p_p_id=com_liferay_document_library_web_portlet_DLAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&_com_liferay_document_library_web_portlet_DLAdminPortlet_mvcRenderCommandName=%2Fdocument_library%2Fedit_file_entry&_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect=http%3A%2F%2Flocalhost%3A8080%2Fgroup%2Fguest%2Fdownloads?com_liferay_document_library_web_portlet_DLAdminPortlet%26p_p_lifecycle%3D0%26p_p_state%3Dmaximized%26p_p_mode%3Dview%26p_p_auth%3Dv8BlnWDo&_com_liferay_document_library_web_portlet_DLAdminPortlet_fileEntryId="
								+ dlFileEntry.getFileEntryId()
								+ "&_com_liferay_document_library_web_portlet_DLAdminPortlet_backURL=http%3A%2F%2Flocalhost%3A8080%2Fgroup%2Fguest%2Fdownloads";
						List<Organization> orgList = UserLocalServiceUtil.getUser(dlFileEntry.getUserId()).getOrganizations();
						String orgName = "";
						for (Organization org : orgList) {
							System.out.println(org.getName() + " : organizationName");
							orgName = orgName + " / " + org.getName();
						}
				%>
				<tr>
					<td class="file-doc"><%=++count%></td>
					<td class="file-doc"><%=orgName%></td>
					<td class="file-doc"><%=dlFileEntry.getTitle()%></td>
					<td class="file-doc"><%=dlFileEntry.getDescription()%></td>
					<td class="file-doc"><%=documentType%></td>
					<td class="file-doc"><%=dlFileEntry.getUserName()%></td>
					<td class="file-doc"><%=dateFormatter.format(dlFileEntry.getModifiedDate())%></td>
					<td class="file-doc"><a href="<%=dowloadMediaURL%>">Download</a></td>
					<td>
					 <liferay-ui:icon-menu>
							<button type="button" class="btn btn-link"
								style="color: #6b6c7e;"
								onclick='setRetention("<%=dlFileEntry.getFileEntryId()%>")'
								name="<portlet:namespace />setretention_btn"
								id="<portlet:namespace />setretention_btn">
								<liferay-ui:icon message="Set Retention" />
								<br />
								<button type="button" class="btn btn-link"
									style="color: #6b6c7e;"
									onclick="location.href='<%=dfFileEntryEditUrl%>';"
									name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
									<liferay-ui:icon message="Update" />
									<br>
									<button type="button" class="btn btn-link"
										style="color: #6b6c7e;"
										onclick="location.href='<%=deleteDocumentUrl%>';"
										name="<portlet:namespace />delete_btn"
										id="<portlet:namespace />delete_btn">
										<liferay-ui:icon message="Delete" />
										<%--       <a class="btn" onclick="setRetention()">Set Retention</a>
						 <a class="btn" href="<%=dfFileEntryEditUrl %>">Update </a>
						 <a class="btn" href="<%=deleteDocumentUrl %>">Delete</a> --%>
						</liferay-ui:icon-menu>
					</td>

				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	var abc=document.getElementsByName("<portlet:namespace/>documentType").value="-1";
});
 function setRetention(value){
	var url= "<%=setRetentionURL%>&<portlet:namespace/>fileId=" + value;
	  Liferay.Util.openWindow({
					dialog: {
					    cssClass: 'aui-popup-example',
						destroyOnHide: true,
						height: 400,
						width: 500,
						resizable: false,
					},
					title: 'Set Retention',
					id: '<portlet:namespace/>dialog',
					uri: url

		});
	}
</script>

