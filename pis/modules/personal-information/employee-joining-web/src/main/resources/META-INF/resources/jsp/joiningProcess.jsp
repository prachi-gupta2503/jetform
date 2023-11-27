<%@page import="com.adjecti.pis.joining.liferay.constants.EmployeeJoiningWebPortletKeys"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Collection"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayRenderRequest"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../init.jsp"%>

<style>
.form-group {
    margin-bottom: 0.5rem !important;
}
</style>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.joiningProcess_jsp");

//Change the repositoryId and folder id to appropriate values;

%>
<%
	long REPOSITORY_ID = EmployeeJoiningWebPortletKeys.documentRepositoryId;
	long FOLDER_ID = EmployeeJoiningWebPortletKeys.documentFolderId; 
	response.setHeader("Cache-Control", "max-age=0");
	Map<String, String> tabPages=new LinkedHashMap<String, String>();
	tabPages.put("Personal", "/jsp/employee/employee_personal_details_add.jsp");
	tabPages.put("Address", "/jsp/employee/employee_address_detail_add.jsp");
	tabPages.put("Education", "/jsp/employee/employee_qualification_add.jsp");
	tabPages.put("Past Experience", "/jsp/employee/employee_work_experience_add.jsp"); 
	tabPages.put("Verification", "/jsp/employee/employee_verification_add.jsp"); 
	tabPages.put("Joining Details", "/jsp/employee/employee_joining_details_add.jsp"); 
	tabPages.put("Document", "/jsp/employee/employee_documents_add.jsp");
	tabPages.put("Permissions", "/jsp/employee/employee_permission_add.jsp");
	tabPages.put("Submission", "/jsp/employee/employee_joining_submission.jsp");
	long employeeId = ParamUtil.getLong(request, "employeeId", 0);
	int groupIndex = ParamUtil.getInteger(request, "groupIndex",0);
%>

<script>
var employeeId='<%=employeeId%>';
</script>
<portlet:resourceURL var="fileUploadUrl" />
<%--<div class="container-fluid" id="msform-main">
	<div class="row justify-content-center mt-0">
		<div class="col-md-11 text-center p-0 mt-3 mb-2"> --%>
			<div class="card px-0 pt-0 pb-0 mt-2 mb-3" style="text-align: center;">
				<div class="card-header bg-primary text-white ">
					<div class="row">
						<div class="col-md-7 text-right"><h5>New Joining Process</h5></div><div class="col-md-5 text-right">Steps <%=groupIndex+1 %> / <%=tabPages.size() %></div>
					</div>
				</div>
			
				<div class="card-body">
				<div class="row">
					<div class="col-md-12 mx-0">
						<p> <strong>Enter all the mandatory information before going to next step!</strong></p>
					</div>
				</div>
				
				<%--<div class="row">
					<div class="col-md-12 mx-0"> --%>
						<div id="msform">
							<ul id="progressbar">
								<%
									int liIndex = 0;
									for (String tab : tabPages.keySet()) {
										String liClass = "";
										if (liIndex <=groupIndex) {
											liClass = "class=\"active\"";
										}
								%>
								<li <%=liClass%> id="<%="tab"+liIndex%>"><strong><%=tab%></strong></li>
								<%
										liIndex++;
									}
								%>
								<li id="confirm"><strong>Finish</strong></li>
							</ul>
						</div>
					<%--</div>
				</div> --%>
				<%--<div class="row">
					<div class="col-md-12 mx-0">--%>
						
						<%if(groupIndex<tabPages.size()){ %>
						 	<liferay-util:include page="<%=String.valueOf(tabPages.values().toArray()[groupIndex])%>" servletContext="<%=application%>">
							</liferay-util:include> 
						<%} %>
					<%--</div>
				</div> --%>
				<%--<div class="row">
					<div class="col-md-12 mx-0">--%>
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group-autofit">
										<div class="form-group-item">
											<div class="btn-group">
												<div class="btn-group-item">
						<% 
								if (groupIndex > 0) {
						%>
													<input type="button" name="previous" class="btn btn-secondary previous action-button action-button-prev mr-2" value="Previous" index="<%=groupIndex%>">
						<%
								}
								
								if (groupIndex < tabPages.size()-1) {
						%>
													<input type="button" name="next" class="btn btn-primary action-button action-button-next" value="Next Step" index="<%=groupIndex%>">
						<%
								}
						%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
	<%--		</div>
		</div>
		
		</div>
	</div>
</div> --%>
<portlet:renderURL var="joiningProcessRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/joiningProcess.jsp" />
</portlet:renderURL>

<%
if(employeeId>0){	
%>
	<portlet:renderURL var="joiningProcessRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/joiningProcess.jsp" />
		<portlet:param name="employeeId" value="<%=Long.toString(employeeId) %>"/>
	</portlet:renderURL>
<%
}
%>
<script>

$(document).ready(function() {
    $(".action-button-next").click(function() {
       
        saveForm(gotoNextPage);

    });
    try {
        $(".action-button-prev").click(function() {
            gotoPrevPage();
        });
    } catch (e) {}

});

function gotoNextPage() {
    window.location.href = '<%=joiningProcessRenderUrl.toString()%>&<portlet:namespace/>groupIndex=<%=String.valueOf(groupIndex+1)%>&<portlet:namespace/>employeeId=' + employeeId;
}

function gotoPrevPage() {
    window.location.href = '<%=joiningProcessRenderUrl.toString()%>&<portlet:namespace/>groupIndex=<%=String.valueOf(groupIndex-1)%>&<portlet:namespace/>employeeId=' + employeeId;
}

function uploadFile(file, onSuccess) {
 
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
        console.log("uploadFile:done(function(response))");
        console.log(response);
        onSuccess(JSON.parse(response));
    });
}

function updateFile(fileEntryId, file, onSuccess) {
    
    var fileName = file.name;
    var title = Date.now() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    var description = fileName + " is uploaded on " + new Date();
    var form = new FormData();
    form.append("file", file, file.name);
    form.append("fileEntryId", fileEntryId);
    form.append("sourceFileName", file.name);
    form.append("mimeType", file.type);
    form.append("title", title);
    form.append("description", description);
    form.append("changeLog", "Uploaded");
    form.append("dlVersionNumberIncrease", "AUTOMATIC");
    form.append("p_auth", Liferay.authToken);
	
    var settings = {
        "url": "/api/jsonws/dlapp/update-file-entry",
        "method": "POST",
        "timeout": 0,
        "headers": {},
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": form
    };

    $.ajax(settings).done(function(response) {
        
        onSuccess(JSON.parse(response));
    });
}
		
class EmployeeDocument {
    constructor(employeeDocumentId, title, discription, documentTypeId, documentId, employeeId) {
        this.employeeDocumentId = employeeDocumentId;
        this.title = title;
        this.discription = discription;
        this.documentTypeId = documentTypeId;
        this.documentId = documentId;
        this.employeeId = employeeId;
    }
}

var validationBackendError = true;
var documentList = new Array();

function addDocument(documentList) {
    Liferay.Service(
        '/pis.employeedocument/add-employee-document', {
            employeeDocument: documentList
        },
        function(obj) {
            console.log(obj);
            this.documentList = obj;
            this.documentList = new Array();
        }
    );
    this.documentList = new Array();
}
</script>
