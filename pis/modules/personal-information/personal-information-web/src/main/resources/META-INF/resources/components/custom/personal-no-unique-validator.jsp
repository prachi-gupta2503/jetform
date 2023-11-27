
<%
if(htmlElement.isUnique()){
%>
<script>
	$(document).ready(function(){
		$('#<portlet:namespace/><%=childFormNamespace+htmlElement.getName()%>').blur(function(){
			console.log("Onblur is called");
			var personalNo=$(this).val().trim();
			if(personalNo=="" || personalNo=="<%=savedValue%>"){
				return;
			}
			  var unitId=$('#<portlet:namespace/><%=childFormNamespace+unitElementName%>').val();  
			
			console.log("unitId : "+unitId);
			if(unitId.trim()=='' || unitId.trim()=='0'){
				alert('Please select the unit before editing personal no.');
				<portlet:namespace/><%=childFormNamespace+htmlElement.getName()%>Unique=false;
				return;
			}
			//if(personalNo!=""){
				AUI().use('aui-base', function(A){
					Liferay.Service('/pis.employee/is-unique', 
					{
						"employeeId": <%=ParamUtil.getLong(request, "formClassPK", 0)%>,
						"fieldValues": {
							"personalNo": personalNo,
							"organizationId": unitId
						}
					},
					function(response) {
						console.log(response);
						<portlet:namespace/><%=childFormNamespace+htmlElement.getName()%>Unique=response;
					});
				});
			//}
		})
	})
</script>
<%
}
%>