<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DocumentTypeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.DocumentType"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeDocumentLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDocument"%>
<%@ include file="../../init.jsp"%>
<style>

	tbody{
		border: 1px solid #e7e7ed; 
	}
	td{
		padding:10px;
		
	}

	#doctable {
		border-collapse: collapse;
		width: 100%;
		padding: 10px;
	}

</style>

<%
List<DocumentType> documentTypes=DocumentTypeLocalServiceUtil.getDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
long employeeId = ParamUtil.getLong(request, "employeeId", 0);

%>
<div class="card form-card m-4">
	<div class="card-header bg-primary text-white">
		<h5>Documents</h5>
	</div>
<div class="card-body">
<div class="form-card-inner">
	<button type="button" class="btn btn-primary" id="docBtnAdd">Add Documents</button>
	<p id="documentErrorMessage"></p>
	<div style="padding: 5px;">
		<aui:form>
			<table id="doctable">
				<tbody id="doctbody">
					<tr>
						<td><aui:input name="employeeDocumentId"
								id="employeeDocumentId" type="hidden" /> <aui:input
								label="Title" type="text" name="document_title"
								class="form-control" id="document_title1">
								<aui:validator
									errorMessage="The Title field is a required field"
									name="required" />

							</aui:input></td>

						<td><aui:input label="Description" type="text"
								name="document_discription" class="form-control"
								id="document_discription1" /></td>
					
						<td><aui:select label="Document Type" class="form-control"
								name="document_type" id="document_type1">
								<aui:option selected="">Document Type</aui:option>
								<%
									for (DocumentType documentType : documentTypes) {
								%>
								<aui:option value="<%=documentType.getDocumentTypeId()%>"><%=documentType.getName()%>

								</aui:option>
								<%
									}
								%>

							</aui:select></td>
						</tr>

					<tr>	
						<td><aui:input type="file" label="Document"
								class="custom-file-input" name="employee_document"
								id="employee_document1" onchange="getDocumentFileId(this.id)">
								<aui:validator errorMessage="The Document is a required field"
									name="required" />
							</aui:input></td>
					</tr>
				</tbody>
			</table>
		</aui:form>
	</div>
</div>
</div>
</div>


<script>
	var documentList=new Array();
	var documentCnt=1;
	var documentTypeList=new Array();
	var documentFileId = [];
	var fileElementIdNo=-1;
	var employeeDocumentIdArray=null;
	$(document).ready(function(){
		var employeeId='<%=employeeId%>';
		Liferay.Service(
				  '/pis.employeedocument/get-employee-document-by-emp-id',
				  {
				    employeeId: employeeId 
				  },
				  function(obj) {
				    console.log(obj);
				    documentList=obj;
				    console.log(documentList);
				    editDocument();
				  }
				);
		
		
		$('#docBtnAdd').click(function() {
			addMoreDocument();
			
		});
		$("#doctable").on('click', '#btnRemove', function () {
		
			$(this).closest('tbody').remove();
			$('#docBtnAdd').attr('disabled', false);
			documentCnt=documentCnt-1;
		});
	});
	
	
	function editDocument(){
		for(let i=0;i<documentList.length-1;i++){
			addMoreDocument();
		}
		
		setValuesInDocumentField();
	}
	
	function setValuesInDocumentField(){
		
		var titleArray = document.getElementsByName("<portlet:namespace/>document_title");
		var discriptionArray = document.getElementsByName("<portlet:namespace/>document_discription");
		var documentTypeIdArray = document.getElementsByName("<portlet:namespace/>document_type");
		
		employeeDocumentIdArray=document.getElementsByName("<portlet:namespace/>employeeDocumentId");
        for(let i=0;i<documentList.length;i++){
        	employeeDocumentIdArray[i].value=documentList[i].employeeDocumentId;
        	titleArray[i].value = documentList[i].title;
        	discriptionArray[i].value = documentList[i].discription;
        	documentTypeIdArray[i].value = documentList[i].documentTypeId;
        	documentFileId[i]=documentList[i].documentId;
        }
		
	}
	
	
	function addMoreDocument(){
		documentCnt = documentCnt + 1;
		
		if (documentCnt <= 100) {

			var markup="<td><button type='button' id='btnRemove' class='btn btn-secondary' name='btnRemove'> Remove </button><td>";	
			var cloneData = $('#doctbody').clone();
			cloneData.find("input").val('');
			cloneData.find('#<portlet:namespace/>employee_document1').prop("id","employee_document"+documentCnt);
			cloneData.append(markup);
			$('#doctable').append(cloneData);

		}	
		else{
			$('#docBtnAdd').attr('disabled', true);
		}
	}
	
	
	function getDocumentFileId(value) {
		fileElementIdNo = value.charAt(value.length - 1);
		if(documentFileId[fileElementIdNo-1] > 0 )
			updateFile(documentFileId[fileElementIdNo-1],document.getElementById(value).files[0], setDocumentFileId);
		else{
	    	uploadFile(document.getElementById(value).files[0], setDocumentFileId);
		}
	}
	
	function setDocumentFileId(data){
	
		documentFileId[fileElementIdNo-1]=data.fileEntryId;
	
	}
	
	
	
	
	
	function saveForm(onSuccess){
	
	var titleArray = document.getElementsByName("<portlet:namespace/>document_title");
	var discriptionArray = document.getElementsByName("<portlet:namespace/>document_discription");
	var documentTypeIdArray = document.getElementsByName("<portlet:namespace/>document_type");
	for(var i = 0 ; i < documentCnt ; i++){
		 
		 var employeeDocumentId=employeeDocumentIdArray[i].value;
		 var title=titleArray[i].value;
		 var discription=discriptionArray[i].value;
		 var documentTypeId=documentTypeIdArray[i].value;
		 var documentId=documentFileId[i];
		 
		 var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,documentId,employeeId);
		 documentList.push(empDocument);
	
	}
	Liferay.Service(
			 '/pis.employeedocument/add-employee-document',
			  {
			    employeeDocument: documentList
			  },
			  function(obj) {
			    console.log(obj);
			    this.documentList=obj;
			    if(typeof obj == "string")
			    if(obj.startsWith("error")){
			    	 $("#documentErrorMessage").text(obj);
			    	 validationBackendError=false;
			    }
				this.employeeDocumentIdArray=[];
				for(i=0;i<documentCnt;i++){
					this.employeeDocumentIdArray[i]=this.documentList[i].employeeDocumentId;
				}
				this.documentList=new Array();
				if(validationBackendError){
					onSuccess();
					validationBackendError=true;
				}
			  }
			);
	this.documentList=new Array();
	}
	



</script>