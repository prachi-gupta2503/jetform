<%@ taglib uri="http://liferay.com/tld/adaptive-media-image"
	prefix="liferay-adaptive-media"%>

<link href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css"
	rel="stylesheet">
<%--script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"> --%>


<style>
.round_image_avatar {
	border-radius: 50%;
	width: 50px;
	height: 50px;
}

.emptydiv {
	margin-top: 10px;
}
</style>

<portlet:renderURL var="editPersonalInformationRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_personal_details_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editAddressRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_address_detail_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editQualificationRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_qualification_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editPastExperienceRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_work_experience_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editVerificationRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_verification_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editJoiningDetailRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_joining_details_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editDocumentRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_documents_add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editPermissionRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/employee/employee_permission_add.jsp" />
</portlet:renderURL>

<div class="card">
	<div class="card-body">
		<aui:form>
			<div class="row">
				<div class="col">
					<aui:select label="Unit" class="form-control" name="unit">
						<aui:option value=''>Select Unit</aui:option>
					</aui:select>
				</div>
				<div class="col">
					<aui:select label="Designation" class="form-control"
						id="designation" name="designation">
						<aui:option value=''>Select Designation</aui:option>
					</aui:select>
				</div>
				<div class="col">
					<aui:select label="Grade" class="form-control" id="grade" name="grade">
						<aui:option value=''>Select Grade</aui:option>
					</aui:select>
				</div>
				<div class="col">
					<aui:select label="Trade" class="form-control" id="trade" name="trade">
						<aui:option value=''>Select Trade</aui:option>
					</aui:select>
				</div>
				<div class="col">
					<span class="aui-search-bar"> 
					<aui:input
							inlineField="<%=true%>" label="Keyword" id="keywords"
							name="keywords" size="30" title="search-entries" type="text"
							placeholder="Keyword" />
					</span>
				</div>
				<div class="col mt-4">
					<aui:button onClick="searchEmployee()"
						cssClass="form-control fas fa-search bg-primary text-white"
						value="Search"></aui:button>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div class="card">
	<div class="card-body" style="overflow:scroll;">
		<table class="table" id="joiningTable">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col"></th>
					<th scope="col">Unit</th>
					<th scope="col">Full Name</th>
					<th scope="col">Email ID</th>
					<th scope="col">Date of Joining</th>
					<th scope="col">Gender</th>
					<th scope="col">Date of Birth</th>
					<th scope="col">Caste Category</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody id="employeeTbody">
			</tbody>
		</table>
	</div>
</div>

<script>
function searchEmployee(){
	let organizationId=$('#<portlet:namespace />unit').val();
	let tradeId=$('#<portlet:namespace />designation').val();
	let gradeId=$('#<portlet:namespace />grade').val();
	let designationId=$('#<portlet:namespace />trade').val();
	let keywords=$('#<portlet:namespace />keywords').val();
	if(organizationId==null)
		organizationId=0;
	if(tradeId=="")
		tradeId=0;
	if(gradeId=="")
		gradeId=0;
	if(designationId=="")
		designationId=0;
	
	var designationGroupId=0;
	organizationId=0;
	
		 Liferay.Service(
		'/pis.employee/get-employees-by-keywords',
		  {
		    organizationId: organizationId,
		    tradeId: tradeId,
		    gradeId: gradeId,
		    designationId: designationId,
		    designationGroupId: 0,
		    keywords: keywords
		  },
		  function(employees) {
			  console.log(employees);
			  createEmployeeTable(employees);
		  }
		); 
}


	$(document).ready(function() {

		Liferay.Service(
				  '/mdm.designation/get-designations',
				  function(designations) {
					  
		          for (var i = 0; i < designations.length; i++) {
		              var id = designations[i]['designationId'];
		              var name = designations[i]['name_En'];
		              
		              $('#<portlet:namespace />designation').append(new Option(name, id));
		          }
			        
				  }
				);


		Liferay.Service(
				  '/mdm.grade/get-grades',
				  function(grades) {
					  
					  for (var i = 0; i < grades.length; i++) {
			                var id = grades[i]['gradeId'];
			                var name = grades[i]['name'];
			                $('#<portlet:namespace />grade').append(new Option(name, id));
			            }
				    
				  }
				);
				
		Liferay.Service(
				  '/mdm.trade/get-trades',
				  function(trades) {
					  
					  for (var i = 0; i < trades.length; i++) {
			                var id = trades[i]['tradeId'];
			                var name = trades[i]['name'];
			                $('#<portlet:namespace />trade').append(new Option(name, id));
			            }
				  }
				);
		
		Liferay.Service(
				  '/pis.employee/get-employee-list',
				  function(employees) {
				    console.log(employees);
				    createEmployeeTable(employees);
			    	
				  }
				);
		
		Liferay.Service(
				  '/pis.employee/get-user-unit',
				  function(unit) {
				    
				    for (var i = 0; i < unit.length; i++) {
					    var id = unit[i]['organizationId'];
		                var name = unit[i]['name'];
		                $('#<portlet:namespace />unit').append(new Option(name, id));
				  	}
				  }
				);

	});
	function editPersonalInformation(employeeId){
		window.location.href = '<%=editPersonalInformationRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editAddress(employeeId){
		window.location.href = '<%=editAddressRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editQualification(employeeId){
		window.location.href = '<%=editQualificationRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editPastExperience(employeeId){
		window.location.href = '<%=editPastExperienceRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editVerification(employeeId){
		window.location.href = '<%=editVerificationRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editJoiningDetails(employeeId){
		window.location.href = '<%=editJoiningDetailRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editDocuments(employeeId){
		window.location.href = '<%=editDocumentRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editPermission(employeeId){
		window.location.href = '<%=editPermissionRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	function editJoiningProcess(employeeId){
		window.location.href = '<%=editJoiningProcessRenderUrl.toString()%>&<portlet:namespace/>employeeId=' + employeeId;
	}
	
	
	
	function createEmployeeTable(employees) {
		
		//let output = '';
		
		//$('#employeeContent').html(output);
		let tableBody = $("#employeeTbody");
		tableBody.html('');
		for (var i = 0; i < employees.length; i++) {
			let markup='';
	    	var organizationId = employees[i]['organizationName'];
	    	var fullName = employees[i]['fullName'];
	    	var gender = employees[i]['gender'];
	    	var designationId = employees[i]['designationName'];
	    	var tradeId = employees[i]['tradeName'];
	    	var gradeId = employees[i]['gradeName'];
	    	var daterOfBirth = employees[i]['daterOfBirth'];
	    	var dateOfJoining = employees[i]['dateOfJoining'];
	    	var casteCategory = employees[i]['casteCategory'];
	    	var emailId = employees[i]['emailId'];
	    	var profileImage = employees[i]['profileImage'];
	    	var actionList = employees[i]['actionList'];
	    	var employeeId = employees[i]['employeeId'];
	    	var status = employees[i]['status'];
	    	
	    	if(profileImage==""){
	    		markup=' <tr><td> <img class="card-img-top round_image_avatar" src="<%=request.getContextPath()%>/image/blankUser.jpg"></td>'	;
	    	}else{
	    		markup='<tr><td><img class="card-img-top round_image_avatar" src="/documents/'+profileImage+'"></td>';
	    	}
    	    markup+="<td>" 
            + organizationId +"</td><td>"
            + fullName+"<br>"+designationId+"<br>"+gradeId+"<br>"+tradeId+"</td><td>"
            + emailId+"</td><td>"
            + dateOfJoining+"</td><td>"
            + gender+	"</td><td>"
            + daterOfBirth+	"</td><td nowrap>"
            + casteCategory+"</td><td>"
            
            + status+"</td>"
            + '<td><div class="dropdown">'
            + '<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'
			+ 'Edit'
			+ '</button>'
          	+ '<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">';
            
            var isApprover=<%=isApprover%>;
            if(isApprover){
            /* 	markup+='<a class="dropdown-item" href="javascript:void(0)" onclick="editPersonalInformation('+employeeId+')">Edit Personal Information</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editAddress('+employeeId+')">Edit Address</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editQualification('+employeeId+')">Edit Qualification</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editPastExperience('+employeeId+')">Edit Past Experience</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editVerification('+employeeId+')">Edit Verification</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editJoiningDetails('+employeeId+')">Edit Joining Detail</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editDocuments('+employeeId+')">Edit Document</a>'
           		+ '<a class="dropdown-item" href="javascript:void(0)" onclick="editPermission('+employeeId+')">Edit Edit Permission</a>'
				 */
				 
				markup+='<a class="dropdown-item" href="javascript:void(0)" onclick="editJoiningProcess('+employeeId+')">Edit</a>'
				var action =actionList[0]+"";
				markup+='<a class="dropdown-item" href="javascript:void(0)" onclick="performWorkflow('+employeeId+',\''+action+'\')">'+action+'</a>';
            }else{
            	if(status!='APPROVAL PENDING'){
            	markup+='<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="editJoiningProcess('+employeeId+')">'
            	+ "Edit";
            	markup+='</button>';
            	}else{
            		markup+='<button type="button" class="btn btn-link" style="color: #6b6c7e;" >'
                	+ "View Profile";
                	markup+='</button>';
            	}
            }
            markup+='</div>';
            markup+='</div>';
            
            markup+='</td></tr>';
    
		    tableBody.append(markup);
		    markup='';
	    }
		$("#joiningTable").dataTable();
	}
	
	function performWorkflow(employeeId,actionResult){
		//alert(actionResult);
		Liferay.Service('/pis.employee/perform-work-flow-action',
		{
		    employeeId: employeeId,
		    action: actionResult
		},
		function(obj) {
		    console.log(obj);
		    
			document.location.reload(true);
		});
	}

</script>
