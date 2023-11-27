
<%
if(htmlElement.isUnique()){
%>
<script>
	$(document).ready(function(){
		$('#<portlet:namespace/><%=htmlElement.getName()%>').blur(function(){
			var fieldValue=$(this).val().trim();
			if(fieldValue!=""){
				AUI().use('aui-base', function(A){
					Liferay.Service('/jetform.jetformbuilder/is-unique', 
					{
						"className":"<%=form.getEntityClass().getName()%>",
						"id": <%=ParamUtil.getLong(request, "formClassPK", 0)%>,
						"fieldName": "<%=htmlElement.getName()%>",
						"fieldValue": fieldValue
					},
					function(response) {
						//alert(response);
						<portlet:namespace/><%=htmlElement.getName()%>Unique=response;
					});
				});
			}
		})
	})
</script>
<%
}
%>