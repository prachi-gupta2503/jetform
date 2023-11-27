
<%
if(htmlElement.isUnique()){
%>
<script>

	$(document).ready(function(){
		$('#<portlet:namespace/><%=childFormNamespace+htmlElement.getName()%>').blur(function(){
			var fieldValue=$(this).val().trim();
			//alert("unique validator called.");
			//alert(fieldValue);
			if(fieldValue!=""){
				AUI().use('aui-base', function(A){
					Liferay.Service('/jetform.jetformbuilder/is-unique', 
					{
						"className":"<%=form.getEntityClass()%>",
						"id": <%=ParamUtil.getLong(request, "formClassPK", 0)%>,
						"fieldName": "<%=htmlElement.getName()%>",
						"fieldValue": fieldValue
					},
					function(response) {
						//alert(response);
						<portlet:namespace/><%=childFormNamespace+htmlElement.getName()%>Unique=response;
					});
				});
			}
		})
	})
	
<%--	function checkUnique<portlet:namespace/><%=htmlElement.getName()%>(fieldValue){
		//alert("In addFileEntry(repositoryId, folderId, description, fileSelected, callback)");
		if(fieldValue==""){
			return true;
		}
		var form = new FormData();
		form.append("className", "<%=form.getEntityClass().getName()%>");
		form.append("id", <%=ParamUtil.getLong(request, "formClassPK", 0)%>);
		form.append("fieldName", "<%=htmlElement.getName()%>");
		form.append("fieldValue", fieldValue);
		form.append("p_auth", Liferay.authToken);
		
		console.log(form);
		
		var settings = {
			"url": "/api/jsonws/jetform.jetformbuilder/is-unique",
			"method": "POST",
			"timeout": 0,
			"headers": {},
			"async":false,
			"processData": false,
			"mimeType": "multipart/form-data",
			"contentType": false,
			"data": form
		};
		
		$.ajax(settings).done(function (response) {
			console.log(response);
			<portlet:namespace/><%=htmlElement.getName()%>Unique=response;
		}).fail(function (xhr, status, error) { 
			console.log(xhr.responseText);
			<portlet:namespace/><%=htmlElement.getName()%>Unique=false;
			//var err = eval("(" + xhr.responseText + ")");
  			//alert(err.Message); 
		});
	}--%>
</script>
<%
}
%>