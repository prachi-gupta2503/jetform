<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
String formClass = ParamUtil.getString(request, "formClass");
long formClassPK = ParamUtil.getLong(request, "formClassPK", -1);
String dialogId= ParamUtil.getString(request, "dialogId");
String cancelFunc= ParamUtil.getString(request, "cancelFunc");

HtmlFormWrapper form=JetFormBuilderLocalServiceUtil.getHtmlFormByClass(ClassUtils.getClass(formClass));
//dialogMode=true;
%>
<div class="container" style="margin-top:25px;">
	<div class="row">
		<div class="col-md-12">
<%
	if(formClassPK>=1){
%>		
	<i class="fas fa-exclamation-triangle" style="color:black;"></i>
		Are you sure you want to delete the <%=AnnotationUtil.getItemLabel(form.getTitle()) %>?
<%
	}else{
%>		
	<i class="fas fa-exclamation-triangle" style="color:red;"></i>
		No valid <%=AnnotationUtil.getItemLabel(form.getTitle())%> record to delete!
<%
	}
%>	
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="form-group-autofit" style="margin-top:25px;">
				<div class="form-group-item">
					<div class="btn-group">
<%
	if(formClassPK>=1){
%>				
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="button" name="deleteYes" value="Yes" />
						</div>
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="deleteNo" value="No" />
						</div>
<%
	}else{
%>		
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="deleteNo" value="Ok" />
						</div>
<%
	}
%>				
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<aui:script>
$(document).ready(function() {
	
	$('#<portlet:namespace/>deleteYes').on('click', function(event) {
		deleteEntity('<%=form.getEntityClass().getName()%>', '<%=formClassPK%>');
	});
	
	$('#<portlet:namespace/>deleteNo').on('click', function(event) {
		closeDialog('<%=dialogId%>');
	});
});

function deleteEntity(entityClass, entityClassPK){
	Liferay.Service('/jetform.jetformbuilder/delete-entity', 
		{
			"className" : entityClass,
			"id":entityClassPK,
			"logical":false,
		},
		function(response) {	
			//alert(response);
			var message=response;
			var error=false;
			var refresh=true;
			if(response.indexOf("fail")>=0){
				message="Record deletion failed.";
				error=true;
				refresh=false;
			}else{
				message="Record deleted successfully.";
			}
			
			closeDialog('<%=dialogId%>', message, error, refresh);
		}
	);	
}

function closeDialog(dialogId, message, error, refresh){
	var data = {
		"dialogId" : dialogId,
		"message" : message,
		"error" : error,
		"refresh" : refresh
	};
	
	Liferay.Util.getOpener().<%=cancelFunc%>(data);
}

</aui:script>