

<script>
$(document).ready(function() {
/* Liferay.Service(
		  '/pis.employee/get-by-grade-name',
		  {
		    gradeName: 'APPEX'
		  },
		  function(employees) {
		    console.log(employees);
		    createEmployeeAppex(employees);
		  }
		); */
	getEmployees();
});
function getEmployees(){
	
	var baseUrl='<%=baseUrl%>';
	
	
$.ajax({url: baseUrl+"/by-grade-name/APPEX",
	
	crossDomain: true,
	headers: {
		"Access-Control-Allow-Origin": "*"
	},
	success: function(employees){
	createEmployeeAppex(employees);
  }});
}
function createEmployeeAppex(employees){

	let output = '';
	$.each(employees, function(key, val){
		output+='<div>';
			output+='<p>';
				output+='<strong>'+val.designationName +' ,' +val.organizationName+' </strong>';
			output+='</p>';
			output+='<div class="row">';
				output+="<div class='col-md-3'>";
					output+="<div class='apex-user-image'>";
					if(val.profileImage!="")
						output+="<img src='/documents/"+ val.profileImage+"'>";
					else
						output+="<img src='<%=request.getContextPath()%>/image/blankUser.jpg'>";			
					output+="</div>";
				output+="</div>";
				output+="<div class='col-md-9'>";
					output+="<p>";
						output+="<strong>Name : "+val.fullName+"</strong>";
						output+="<br>";
						output+="Joinied "+val.joiningDesignation+" on "+val.currentDesignationDate;
						output+="<br>";
						output+=val.designationName +" since "+val.dateOfJoining;
						output+="<br>";
						output+="Email :"+ val.emailId;
						output+="</p>";
					
				output+="</div>";
				output+="</div>";
				
					
		output+="</div>";
		output+="<br>";
		
		
	});
	$('#employeeContent').html(output);
	
}
</script>