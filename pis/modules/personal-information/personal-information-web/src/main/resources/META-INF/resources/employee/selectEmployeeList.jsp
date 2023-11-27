<%@ include file="/components/list/form-list-restful.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<button type="button" class="btn btn-primary" id="<portlet:namespace/><%=form.getId()%>actionOk">OK</button>
			<button type="button" class="btn btn-secondary" id="<portlet:namespace/><%=form.getId()%>actionCancel">Cancel</button>
		</div>
	</div>
</div>

<aui:script>
$(document).ready(function(){
	$('#<portlet:namespace/><%=form.getId()%>actionOk').click(function(){
		try{
			alert($('#<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys').attr('value'));
			var selectedVal=$('#<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys').attr('value');
			if(!selectedVal && selectedVal==''){
				alert("No record has been selected!");
			}else{
				var data={
					"action":"save",
					"value": selectedVal
				}
				Liferay.Util.getOpener().<portlet:namespace/>SelectEmployeeListCloseDialog(data);
			}
		}catch(e){}
		
	})
	
	$('#<portlet:namespace/><%=form.getId()%>actionCancel').click(function(){
		var data={
			"action":"save",
			"value": ''
		}
		Liferay.Util.getOpener().<portlet:namespace/>SelectEmployeeListCloseDialog(data);
	})
});
</aui:script>