<%@page import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoValue"%>
<%@page import="com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoColumn"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoTable"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalService"%>
<%@page import="com.adj.liferay.documentmedia.constants.MVCCommandName"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntryType"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<portlet:actionURL name="<%=MVCCommandName.DOCUMENTMEDIA_ADD%>" var="addDocumentMediaUrl"/>
<%List<DLFileEntryType> dlFileEntryTypes=DLFileEntryTypeLocalServiceUtil.getDLFileEntryTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
List<Organization> organizations=OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
long fileEntryId=ParamUtil.getLong(request, "fileEntryId");

DLFileEntry dlFileEntry=null;
if(fileEntryId>-1){
 dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
}
String title=dlFileEntry ==null ? " " :dlFileEntry.getTitle();
String description=dlFileEntry ==null ? " " :dlFileEntry.getDescription();
long documentType=dlFileEntry ==null ? -1 :dlFileEntry.getFileEntryTypeId();
String fileName=dlFileEntry ==null ? " " :dlFileEntry.getFileName();

%>
<div class="form-card">

<aui:form action="<%=addDocumentMediaUrl%>" name="<portlet:namespace />fm">
	<div class="form-group-item">
			<aui:input name="fileEntryId" type="hidden" value="<%=fileEntryId%>" />
		</div>
       <aui:input name="title"  class="form-control" label="Title" value="<%=title %>"/>

       <aui:select class="form-control" label="Document Type" name="documentType">
			<aui:option value="">Select Document Type</aui:option>
			 <%
				for (DLFileEntryType dlFileEntryType : dlFileEntryTypes) {
					 boolean selected=false;
					String optionText = dlFileEntryType.getName();
					long optionValue = dlFileEntryType.getFileEntryTypeId();
					System.out.println(optionValue+" : optionValue");
					if(optionValue==documentType){
						selected=true;
					}
					
			%>
				 <aui:option value="<%=optionValue%>" selected="<%=selected %>"><%=optionText%> </aui:option>
				 <%
				}
				 %>
		</aui:select>
		<aui:input name="subject"  class="form-control" label="Subject" value="<%=description %>"/>
		<aui:select class="form-control" label="Organization" name="organization">
			<aui:option value="">Select Organization</aui:option>
			 <%
				for (Organization organization : organizations) {
					 boolean selected=false;
					String optionText = organization.getName();
					long optionValue = organization.getOrganizationId();
					System.out.println(optionValue+" : optionValue");
					if(optionValue==documentType){
						selected=true;
					}
					
			%>
				 <aui:option value="<%=optionValue%>" selected="<%=selected %>"><%=optionText%> </aui:option>
				 <%
				}
				 %>
				 </aui:select>
						<aui:input type="file" label="Document"
								class="custom-file-input" name="document" value="<%=fileName %>">
							</aui:input>
<aui:button type="submit" label="Submit"/>
</aui:form>
</div>