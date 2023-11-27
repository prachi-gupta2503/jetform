<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%
/* HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
String tradeId = httpReq.getParameter("tradeId");
String gradeId = httpReq.getParameter("gradeId");
String designationId = httpReq.getParameter("designationId");
String unitId = httpReq.getParameter("unitId"); */
String tradeId = null;
String designationId = null;
String unitId = null;
%>
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
							inlineField="<%=true%>" label="Search Keyword" id="keywords"
							name="keywords" size="30" title="search-entries" type="text"
							placeholder="Search Keyword" />
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

<script>
$(document).ready(function() {
var employees=null;	
<%-- Liferay.Service(
		  '/mdm.designation/get-designations',
		  function(designations) {
			  
          for (var i = 0; i < designations.length; i++) {
              var id = designations[i]['designationId'];
              var name = designations[i]['name_En'];
              
              $('#<portlet:namespace />designation').append(new Option(name, id));
          }
          if(<%=designationId%>!=null)
          	document.getElementById("<portlet:namespace />designation").value=<%=designationId%>;
	        
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
			  if(<%=gradeId%>!=null)
			  	document.getElementById("<portlet:namespace />grade").value=<%=gradeId%>;
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
			  if(<%=tradeId%>!=null)
			  	document.getElementById("<portlet:namespace />trade").value=<%=tradeId%>;
		  }
		); --%>
/* Liferay.Service(
		  '/pis.employee/get-employees',
		  function(employees) {
			  this.employees=employees;
			  
			  createEmployeeTable(employees);
		    	
		    		
		  }); */
getMasterData();
/* getGrades();
getTrades();
getDesignations(); */
getEmployees();	  
});

<%-- function getGrades(){
	
	var baseUrl='<%=baseUrl%>';
	
	$.ajax({
		url: baseUrl+"/get-grades",
		success:  function(grades) {
			console.log(grades);
			  for (var i = 0; i < grades.length; i++) {
	                var id = grades[i]['key'];
	                var name = grades[i]['value'];
	                $('#<portlet:namespace />grade').append(new Option(name, id));
	            }
			  if(<%=gradeId%>!=null)
			  	document.getElementById("<portlet:namespace />grade").value=<%=gradeId%>;
		  }
	});
}
function getTrades(){
	var baseUrl='<%=baseUrl%>';
	$.ajax({
		url: baseUrl+"/get-trades",
		success:  function(trades) {
			  
			  for (var i = 0; i < trades.length; i++) {
	                var id = trades[i]['key'];
	                var name = trades[i]['value'];
	                $('#<portlet:namespace />trade').append(new Option(name, id));
	            }
			  if(<%=tradeId%>!=null)
			  	document.getElementById("<portlet:namespace />trade").value=<%=tradeId%>;
		  }
	});
}
function getDesignations(){
	var baseUrl='<%=baseUrl%>';
	$.ajax({
		url: baseUrl+"/get-designations",
		success:  function(designations) {
			  
	          for (var i = 0; i < designations.length; i++) {
	              var id = designations[i]['key'];
	              var name = designations[i]['value'];
	              
	              $('#<portlet:namespace />designation').append(new Option(name, id));
	          }
	          if(<%=designationId%>!=null)
	          	document.getElementById("<portlet:namespace />designation").value=<%=designationId%>;
		        
			  }
	});
}
 --%>
function getMasterData(){
	var baseUrl='<%=baseUrl%>';
	$.ajax({
		url: baseUrl+"/get-master-data",
		crossDomain: true,
		headers: {
			"Access-Control-Allow-Origin": "*"
		},
		success: function(masterData){
			
			
			
			 var  designations=masterData['designation'];
			var  trades=masterData['trade']; 
			var  grades=masterData['grade'];
			var  units=masterData['unit'];
			
			
			
			 for (var i = 0; i < designations.length; i++) {
	              var id = designations[i]['key'];
	              var name = designations[i]['value'];
	              
	              $('#<portlet:namespace />designation').append(new Option(name, id));
	          }
	          if(<%=designationId%>!=null)
	          	document.getElementById("<portlet:namespace />designation").value=<%=designationId%>;
		        
          	 for (var i = 0; i < trades.length; i++) {
	                var id = trades[i]['key'];
	                var name = trades[i]['value'];
	                $('#<portlet:namespace />trade').append(new Option(name, id));
	            }
			  if(<%=tradeId%>!=null)
			  	document.getElementById("<portlet:namespace />trade").value=<%=tradeId%>;
		   
		  	 for (var i = 0; i < grades.length; i++) {
	                var id = grades[i]['key'];
	                var name = grades[i]['value'];
	                $('#<portlet:namespace />grade').append(new Option(name, id));
	            }
		  	 for (var i = 0; i < units.length; i++) {
	                var id = units[i]['key'];
	                var name = units[i]['value'];
	                $('#<portlet:namespace />unit').append(new Option(name, id));
	            }
			   if(<%=gradeId%>!=null)
			  	document.getElementById("<portlet:namespace />grade").value=<%=gradeId%>;
	
	
		 }
	});
}
function getEmployees(){
	
	var baseUrl='<%=baseUrl%>';
	$.ajax({
		url: baseUrl+"/get-employees/0/0/0/0/\'\'",
		crossDomain: true,
		headers: {
			"Access-Control-Allow-Origin": "*"
		},
		success: function(employees){
			createEmployeeTable(employees);
		 }
	});
}

function createEmployeeTable(employees) {
	
	let output = '';
	output+='<table class="table" id="userTable">';
		output+='<thead class="bg-primary text-white">';
			output+='<tr>';

				output+='<th scope="col">Unit</th>';
				output+='<th scope="col">Full Name</th>';
				output+='<th scope="col">Gender</th>';
				output+='<th scope="col">Designation</th>';
				output+='<th scope="col">Trade</th>';
				output+='<th scope="col">Grade</th>';
				output+='<th scope="col">Date of Birth</th>';
				output+='<th scope="col">Date of Joining</th>';
				output+='<th scope="col">Caste Category</th>';
				output+='<th scope="col">Email ID</th>';

				
	
			output+='</tr>';
		output+='</thead>';
		output+='<tbody id="employeeTbody">';
	
		output+='</tbody>';
	output+='</table>';
	$('#employeeContent').html(output);
	for (var i = 0; i < employees.length; i++) {
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
    
    	
    	
    	markup="<tr><td>" 
            + organizationId +"</td><td>"
            + fullName+ "</td><td>"
            + gender+	"</td><td>"
            + designationId+"</td><td>" 
            + tradeId+"</td><td>"
            + gradeId+"</td><td nowrap>"
            + daterOfBirth+	"</td><td nowrap>"
            + dateOfJoining+"</td><td>"
            + casteCategory+"</td><td>"
            + emailId+"</td><tr>";
    let tableBody = $("table tbody");
    tableBody.append(markup);
    }
}

function searchEmployee(){
	var baseUrl='<%=baseUrl%>';
	let organizationId=$('#<portlet:namespace />unit').val();
	let tradeId=$('#<portlet:namespace />designation').val();
	let gradeId=$('#<portlet:namespace />grade').val();
	let designationId=$('#<portlet:namespace />trade').val();
	let keywords=$('#<portlet:namespace />keywords').val();
	
	if(organizationId=="" || organizationId==null)
		organizationId=0;
	if(tradeId=="" || tradeId==null)
		tradeId=0;
	if(gradeId=="" || gradeId==null)
		gradeId=0;
	if(designationId=="" || designationId==null)
		designationId=0;
	if(keywords=="")
		keywords=null;
	organizationId=0;
	
		/*  Liferay.Service(
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
		);  */
		
	$.ajax({url: baseUrl+"/get-employees/"+gradeId+"/"+tradeId+"/"+designationId+"/"+organizationId+"/"+keywords,
		crossDomain: true,
		headers: {
			"Access-Control-Allow-Origin": "*"
		},
		success: function(employees){
		createEmployeeTable(employees);
		  }});
		
}
function submitSearchForm(){
	if(null!="<%=tradeId%>" || null!="<%=gradeId%>" || null!="<%=unitId%>" || null!="<%=designationId%>"){
		searchEmployee();
	}
}
setTimeout(function(){
	submitSearchForm();
},1000)

</script>