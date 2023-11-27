<%@page import="com.adjecti.mdm.liferay.service.VerificationTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeVerificationLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeVerification"%>
<%@page import="com.adjecti.mdm.liferay.model.VerificationType"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../../init.jsp"%>

<style>
	tbody{
		border: 1px solid #e7e7ed; 
	}
	td{
		padding:10px;
	}
	
	#vertable {
		border-collapse: collapse;
		width: 100%;
		padding: 10px;
	}

</style>
<%

List<VerificationType> verificationTypes=VerificationTypeLocalServiceUtil.getVerificationTypes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
long employeeId = ParamUtil.getLong(request, "employeeId", 0);

%>
<div class="card form-card m-4">
	<div class="card-header bg-primary text-white">
		<h5>Background Verification</h5>
	</div>
<div class="card-body">
<div class="form-card-inner">
	<button type="button" class="btn btn-primary" id="verBtnAdd">Add Verification</button>
	<p id="VerificationErrorMessage"></p>
		<aui:form>
			<table id="vertable">
				<tbody id="vertbody">
					<tr>
						<td><aui:input id="employeeVerificationId"
								name="employeeVerificationId" type="hidden" /> <aui:input
								label="Document No" type="text" name="verification_Document_No"
								class="form-control" id="verification_Document_No1">
								<aui:validator
									errorMessage="The Document No is a required field"
									name="required" />

							</aui:input></td>

						<td><aui:select label="Verification Type"
								class="form-control" name="verification_Type"
								id="verification_Type1">
								<aui:option selected="">Select Verification Type</aui:option>
								<%
									for (VerificationType verificationType : verificationTypes) {
								%>
								<aui:option
									value="<%=verificationType.getVerificationTypeId()%>"><%=verificationType.getName()%>

								</aui:option>
								<%
									}
								%>

							</aui:select></td>
					
						<td><aui:input label=" Verification Date" type="date"
								name="verification_Date" class="form-control"
								id="verification_Date1" /></td>
					</tr>

					<tr>			
						<td><aui:input label="Verification Authority" type="text"
								name="verification_Authority" class="form-control"
								id="verification_Authority1" /></td>
					<%--</tr>

					<tr> --%>
						<td><aui:input label="Verification Remarks" type="text"
								name="verification_Remarks" class="form-control"
								id="verification_Remarks1" /></td>


						<td><aui:input type="file" label="Verification Document"
								class="custom-file-input" name="verification_Document"
								id="verification_Document1"
								onchange="getVerificationFileId(this.id)">
								<aui:validator
									errorMessage="The Verification Document is a required field"
									name="required" />
							</aui:input></td>
					</tr>
				</tbody>
			</table>
		</aui:form>
	</div>
</div>
</div>

<script>
var iCnt = 1;
var verificatonList=new Array();
var verificationFileId=[];
var fileElementIdNo=-1;

$(document).ready(function(){
	var employeeId='<%=employeeId%>';
	Liferay.Service(
			  '/pis.employeeverification/get-employee-verification-by-employee-id',
			  {
			    employeeId: employeeId
			  },
			  function(obj) {
			    console.log(obj);
			    verificatonList=obj;
			    editVerificaton();
			  }
			);
	
	
	$('#verBtnAdd').click(function() {

		addMoreVerificaton();
	});
	
	
	$("#vertable").on('click', '#btnRemove', function () {

		$(this).closest('tbody').remove();
		$('#verBtnAdd').attr('disabled', false);
		iCnt=iCnt-1;
	});
	
});

function editVerificaton(){
	
	for(let i=0;i<verificatonList.length-1;i++){
		addMoreVerificaton();
	}
	
	setValuesInVerificatonField();
}

function addMoreVerificaton(){
	iCnt = iCnt + 1;

	if (iCnt <= 8) {
		var markup="<td><button type='button' class='btn btn-secondary' id='btnRemove' name='btnRemove'> Remove <button/><td>";	
		var cloneData = $('#vertbody').clone();
		cloneData.find("input").val('');
		cloneData.find('#<portlet:namespace/>verification_Document1').prop("id","verification_Document"+iCnt);
		cloneData.append(markup);
		$('#vertable').append(cloneData);
	}
	else{
		$('#verBtnAdd').attr('disabled', true);
	}
}

function setValuesInVerificatonField(){
	var documentNoArray = document.getElementsByName("<portlet:namespace/>verification_Document_No");
	var verificationTypeIdArray =document.getElementsByName("<portlet:namespace/>verification_Type");
	var verificationDateArray = document.getElementsByName("<portlet:namespace/>verification_Date");
	var authorityArray = document.getElementsByName("<portlet:namespace/>verification_Authority");
	var remarksArray = document.getElementsByName("<portlet:namespace/>verification_Remarks");
	employeeVerificationIdArray= document.getElementsByName("<portlet:namespace/>employeeVerificationId");
	for(let i=0;i<verificatonList.length;i++){
		employeeVerificationIdArray[i].value=verificatonList[i].employeeVerificationId;
		documentNoArray[i].value = verificatonList[i].documentNo;
		verificationTypeIdArray[i].value = verificatonList[i].verificationTypeId;
		verificationDateArray[i].value = convertDateFormat(verificatonList[i].verificationDate);
		authorityArray[i].value = verificatonList[i].authority;
		remarksArray[i].value = verificatonList[i].remarks;
		verificationFileId[i]=verificatonList[i].documentId;
	}
	
}
function convertDateFormat(date){
	var date=new Date(date);
	return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}
function getVerificationFileId(value) {
	fileElementIdNo = value.charAt(value.length - 1);
	if(verificationFileId[fileElementIdNo-1] > 0 )
		updateFile(verificationFileId[fileElementIdNo-1],document.getElementById(value).files[0], setVerificationFileId);
	else{
    	uploadFile(document.getElementById(value).files[0], setVerificationFileId);
	}
    
}

function setVerificationFileId(data){
	
		verificationFileId[fileElementIdNo-1]=data.fileEntryId;
		var employeeDocumentId=0;
		
		var title="Verification Document";
		var discription="Verification Document";

		Liferay.Service(
		 	'/mdm.documenttype/get-document-type-id-by-name',
		  	{
			 	name: "Verification Proof"
		  	},
		  	function(obj) {
			    console.log(obj);
		    	this.documentTypeId=obj;
		    	var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId, verificationFileId[fileElementIdNo-1],employeeId);
			 	documentList.push(empDocument);
			 	addDocument(documentList);
		  	});
}

var employeeVerificationIdArray =null;
function saveForm(onSuccess){

	
	 var documentNoArray = document.getElementsByName("<portlet:namespace/>verification_Document_No");
	 
	 var verificationTypeIdArray =document.getElementsByName("<portlet:namespace/>verification_Type");
	 
	 var verificationDateArray = document.getElementsByName("<portlet:namespace/>verification_Date");
	 var authorityArray = document.getElementsByName("<portlet:namespace/>verification_Authority");
	 var remarksArray = document.getElementsByName("<portlet:namespace/>verification_Remarks");
	 employeeVerificationIdArray= document.getElementsByName("<portlet:namespace/>employeeVerificationId");
	 
	 for(var i = 0 ; i < iCnt ; i++){
		var employeeVerificationId= employeeVerificationIdArray[i].value;
		
		var documentNo=documentNoArray[i].value;
		 
		var verificationTypeId=verificationTypeIdArray[i].value;
		var verificationDate=verificationDateArray[i].value;
		var authority=authorityArray[i].value;
		var remarks=remarksArray[i].value;
		var documentId=verificationFileId[i];
		
	 	var empVerification=new EmployeeVerification(employeeVerificationId,documentNo,verificationTypeId,verificationDate,authority,remarks,documentId,employeeId);
	 	verificatonList.push(empVerification);
	 
	 }
	Liferay.Service(
		'/pis.employeeverification/add-employee-verifications',
		{
			employeeVerifications: verificatonList
		},
		function(obj) {
			console.log(obj);
			this.verificatonList=obj;
			if(typeof obj == "string")
				if(obj.startsWith("error")){
	 				$("#VerificationErrorMessage").text(obj);
	 				validationBackendError=false;
				}
			this.employeeVerificationIdArray=[];
			for(i=0;i<iCnt;i++){
				this.employeeVerificationIdArray[i]=verificatonList[i].employeeVerificationId;
		
			}
			this.verificatonList=new Array();
			if(validationBackendError){
				onSuccess();
				validationBackendError=true;
			}
		}
	);
	this.verificatonList=new Array();
}

class EmployeeVerification {
constructor(employeeVerificationId,documentNo,verificationTypeId,verificationDate,authority,remarks,documentId,employeeId){

	this.employeeVerificationId=employeeVerificationId;
	this.documentNo = documentNo;
	this.verificationTypeId = verificationTypeId;
	this.verificationDate = verificationDate;
	this.authority = authority;
	this.remarks = remarks;
	this.documentId = documentId;
	this.employeeId=employeeId;
	}
}

</script>