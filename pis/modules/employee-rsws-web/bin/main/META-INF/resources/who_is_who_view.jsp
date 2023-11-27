

<%
String tradeId = null;
String designationId = null;
String unitId = null;
%><div class="card">
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
<%-- function httpGet() {
	 alert("<%=baseUrl%>");
   var xmlHttp = new XMLHttpRequest();
   xmlHttp.open( "GET", "<%=baseUrl%>", false ); 
   xmlHttp.send( null );
   alert(xmlHttp.responseText);
   $.ajax({
	   url : '${baseUrl}',
	   //data : data,//person id to sent
	   type: 'GET',
	   //dataType : "json",
	   success : function(data) {
		   alert(data);
	     // get person data back from controller
	   }
	 });
}  --%>
$(document).ready(function() {
	/* alert("inside document ready");
	 httpGet(); */
var employees=null;	
/* Liferay.Service(
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
		); */
		


/*  Liferay.Service(
		  '/pis.employee/get-employees',
		  function(employees) {
			  this.employees=employees;
			  
			  createEmployeeWhoIsWhoView(employees);
		    	
		    		
		  });
  */
/* getGrades();
getTrades();
getDesignations(); */
getMasterData();
getEmployees();
		  
});

function getEmployees(){
	var baseUrl='<%=baseUrl%>';
	
$.ajax({url: baseUrl+"/get-employees/0/0/0/0/\'\'", 
	crossDomain: true,
	headers: {
		"Access-Control-Allow-Origin": "*"
	},
	success: function(employees){
	 createEmployeeWhoIsWhoView(employees);
	  }});
}

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
			  if(<%=gradeId%>!=null)
			  	document.getElementById("<portlet:namespace />grade").value=<%=gradeId%>;
	
	
		 }
	});
}
<%-- function getGrades(){
	var baseUrl='<%=baseUrl%>';
	$.ajax({
		url: baseUrl+"/get-grades",
		success:  function(grades) {
			
			  for (var i = 0; i < grades.length; i++) {
	                var id = grades[i]['gradeId'];
	                var name = grades[i]['name'];
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
		 function(trades) {
			  
			  for (var i = 0; i < trades.length; i++) {
	                var id = trades[i]['tradeId'];
	                var name = trades[i]['name'];
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
	              var id = designations[i]['designationId'];
	              var name = designations[i]['name_En'];
	              
	              $('#<portlet:namespace />designation').append(new Option(name, id));
	          }
	          if(<%=designationId%>!=null)
	          	document.getElementById("<portlet:namespace />designation").value=<%=designationId%>;
		        
			  }
	});
}
  
 --%>	  
function createEmployeeWhoIsWhoView(employees) {
	
	let output = '';
	$.each(employees, function(key, val){
		output+='<div class="card" style="min-height: 200px;">'
			output+='<div class="card-body">'
				output+='<div>'
				output+='<h1>'+val.fullName+'</h1>'
				output+='<p>Honble Minister of Railways,Minister of Communications and Minister of Electronics and Technology</p>'
				output+='</div>'
				output+='<hr>'
				output+='<div class="row align-items-center">'
					output+='<div class="col-md-3 text-center">'
						output+="<div class='apex-user-image'>";
							if(val.profileImage!="")
								output+="<img src='/documents/"+ val.profileImage+"'>";
							else
								output+="<img src='<%=request.getContextPath()%>/image/blankUser.jpg'>";
						output+='</div>'
					output+='</div>'
					output+='<div class="col-md-4">'
						output+='<p>'+val.phoneNo+'</p>'
					output+='</div>'
					output+='<div class="col-md-5">'
						output+='<p>'+val.emailId+'</p>'
					output+='</div>'
				output+='</div>'
			output+='</div>'
		output+='</div>'
	});
	$('#employeeContent').html(output);
}

function searchEmployee(){
	var baseUrl='<%=baseUrl%>';
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
			  	  
			  createEmployeeWhoIsWhoView(employees);
			  
		  });  */
		  
	$.ajax({url: baseUrl+"/get-employees/"+gradeId+"/"+tradeId+"/"+designationId+"/"+organizationId+"/"+keywords,
		crossDomain: true,
		headers: {
			"Access-Control-Allow-Origin": "*"
		},
		success: function(employees){
		createEmployeeWhoIsWhoView(employees);
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