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

					<aui:select label="Grade" class="form-control" id="grade"
						name="grade">
						<aui:option value=''>Select Grade</aui:option>

					</aui:select>

				</div>
				<div class="col">
					<aui:select label="Trade" class="form-control" id="trade"
						name="trade">

						<aui:option value=''>Select Trade</aui:option>

					</aui:select>
				</div>
				<div class="col">
					<span class="aui-search-bar"> <aui:input
							inlineField="<%=true%>" label="Keyword" id="keywords"
							name="keywords" size="30" title="search-entries" type="text"
							placeholder="Keyword" />
					</span>
				</div>
				<div class="col mt-4">
					<aui:button onClick="searchEmployee()"
						cssClass="form-control fas fa-search bg-primary text-white" value="Search"></aui:button>
				</div>
			</div>
		</aui:form>
	</div>
</div>

<script>
$(document).ready(function() {
var employees=null;	
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
		  '/pis.employee/get-employees',
		  function(employees) {
			  this.employees=employees;
			  console.log(employees);
			  
			  createEmployeeTable(employees);
		    	
		    		
		  });
		  
});
function createEmployeeTable(employees) {
	
	let output = '';
	output+='<table class="table" id="userTable">';
		output+='<thead class="bg-primary text-white">';
			output+='<tr>';

				//output+='<th scope="col"></th>';
				output+='<th scope="col">Name</th>';
/*				output+='<th scope="col">Gender</th>';*/
				output+='<th scope="col">Personal No</th>';
				output+='<th scope="col">Unit</th>';
				output+='<th scope="col">Email ID</th>';
				output+='<th scope="col">Trade</th>';
				output+='<th scope="col">Grade</th>';
/*				output+='<th scope="col">Date of Birth</th>';*/
				output+='<th scope="col">Date of Joining</th>';
/*				output+='<th scope="col">Caste Category</th>';*/


				output+='<th scope="col">Action</th>';
	
			output+='</tr>';
		output+='</thead>';
		output+='<tbody id="employeeTbody">';
	
		output+='</tbody>';
	output+='</table>';
	$('#employeeContent').html(output);
	
	for (var i = 0; i < employees.length; i++) {
		var employeeId=employees[i]['employeeId'];
		var personalNo=employees[i]['personalNo'];
    	var organizationName = employees[i]['organizationName'];
    	var fullName = employees[i]['fullName'];
    	var gender = employees[i]['gender'];
    	var designationName = employees[i]['designationName'];
    	var tradeName = employees[i]['tradeName'];
    	var gradeName = employees[i]['gradeName'];
    	var daterOfBirth = employees[i]['daterOfBirth'];
    	var dateOfJoining = employees[i]['dateOfJoining'];
    	var casteCategory = employees[i]['casteCategory'];
    	var profileImage = employees[i]['profileImage'];
    	var emailId = employees[i]['emailId'];
    	markup='<tr>';
    	
    	if(profileImage==""){
    		profileImage='<img class="card-img-top round_image_avatar" src="<%=request.getContextPath()%>/image/blankUser.jpg" style="width:64; height:64;">'	;
    	}else{
    		profileImage='<img class="card-img-top round_image_avatar" src="/documents/'+profileImage+'" style="width:64; height:64;">';
    	}
    	    //markup+="</td><td>" 
   		markup+="<td>"
   		markup+="<h4 class='table-avatar'>";
   		markup+="<a href='#' class='mr-2'>"+profileImage+"</a>";
        markup+="<a href='#'>" + fullName+"<span style='display:block;'>"+designationName+"</span></a>";
        markup+="</h4>";
        markup+="</td>";
        markup+="<td>"+personalNo +"</td>";
        markup+="<td>"+organizationName +"</td>";
        markup+="<td>"+emailId+"</td>";
        markup+="<td>"+gradeName+"</td>";
        markup+="<td>"+tradeName+"</td>";
        markup+="<td>"+dateOfJoining+"</td>"
        markup+="<td>";
        markup+='<button type="button" class="btn bg-primary" onclick="viewProfile('+employeeId+')">View Profile</button>';
        markup+='<button type="button" class="btn bg-primary" onclick="changeRank('+employeeId+')"><i class="fas fa-sort-alt"></i></button>';
        markup+='</td>';
        markup+='</tr>';
    	let tableBody = $("table tbody");
    	tableBody.append(markup);
    }
}

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
	
	organizationId=0;
	 Liferay.Service(
	  '/pis.employee/get-employee-by-search-filter',
	  {
	    organizationId: organizationId,
	    tradeId: tradeId,
	    gradeId: gradeId,
	    designationId: designationId,
	    keywords: keywords
	  },
	  function(employees) {
		  
		  console.log(employees);
		  
		  createEmployeeTable(employees);
		  
	  }
	); 
}
function viewProfile(employeeId){
	window.location.href="/group/comnet2/pis/employees/profile?view=profile&employeeId="+employeeId;
}
</script>