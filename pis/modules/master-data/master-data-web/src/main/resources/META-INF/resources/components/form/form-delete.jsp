<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%--link rel="stylesheet"
	href="<%=request.getContextPath()%>/fonts/font-awesome/css/font-awesome.min.css">
 --%>	
<%
String formClass = ParamUtil.getString(request, "formClass");
long formClassPK = ParamUtil.getLong(request, "formClassPK", -1);
String formId = ParamUtil.getString(request, "formId");
String dialogId= ParamUtil.getString(request, "dialogId");
String closeFunc= ParamUtil.getString(request, "closeFunc");
HtmlFormWrapper form=JetFormBuilderLocalServiceUtil.rendererForm(formClass);
//dialogMode=true;
%>
<div class="container">
	<div class="row mb-3"></div>
	
	<div class="row">
		<div class="col-md-12">
<%
	if(formClassPK>=1){
%>		
	<i class="fa fa-exclamation-triangle" style="color:red; font-size: 1.5rem;"></i>
			Are you sure you want to deactivate the <%=AnnotationUtil.getItemLabel(form.getTitle())%>?
<%
	}else{
%>		
	<i class="fa fa-exclamation-triangle" style="color:black; font-size: 1.5rem;"></i>
			No valid <%=AnnotationUtil.getItemLabel(form.getTitle())%> record to delete!
<%
	}
%>	
		</div>
	</div>
	<div class="row mb-5"></div>
	
	<div class="row">
		<div class="col-md-12">
			<div class="form-group-autofit">
				<div class="form-group-item">
					<div class="btn-group">
<%
	if(formClassPK>=1){
%>				
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-danger" type="button" name="deleteYes" value="Yes" />
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

<aui:script position="inline" use="aui-base liferay-util-window">

$(document).ready(function() {
	
	$('#<portlet:namespace/>deleteYes').on('click', function(event) {
		deleteEntity('<%=form.getEntityClass()%>', '<%=formClassPK%>');
	});
	
	$('#<portlet:namespace/>deleteNo').on('click', function(event) {
		console.log("<portlet:namespace/><%=formId%>close clicked ");
			var obj={
				"dialogId" :'<%=dialogId %>',
				"refresh":"false",
				"message" : '',
				"error" :  false,
				
			};
			Liferay.Util.getOpener().<%=closeFunc %>(obj);
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
			console.log(response);
			var message=response;
			var error=false;
			var refresh=true;
			var lowerResponse=response.toLowerCase();
			var status=(lowerResponse.indexOf("error")<0 && lowerResponse.indexOf("fail")<0); 
					
			if(status){
				message="Record deactivated successfully.";
			}else{
				
				message="Record deactivation failed.";
				error=true;
				refresh=false;
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
<%
	if(StringUtils.isNotBlank(closeFunc)){
%>	
		Liferay.Util.getOpener().<%=closeFunc%>(data);
<%
	}else{
%>	
		Liferay.Util.getOpener().<portlet:namespace/><%=form.getId()%>closeDialog(data);
<%
	}
%>		
}

/*=====START Dialog Mode save function=====*/
<%-- 
$( document ).ready(function() {		
	try{
		$("#<portlet:namespace/><%=formId%>deleteYes").click(function(event) {
			console.log("<portlet:namespace/><%=formId%>deleteYes clicked ");
			Liferay.Service(
				'/jetform.jetformbuilder/delete-entity',
				{
					"className": "<%=form.getEntityClass().getName()%>",
					"id":<%=formClassPK%>,
					"logical" : false
				},
				
			 function(response) {
					console.log(response);
					var lowerResponse=response.toLowerCase();
					var status=(lowerResponse.indexOf("error")<0 && lowerResponse.indexOf("fail")<0); 
					var obj={
						"status":status,
						"refresh":true,
						"message":response
					};
					try{
						//Liferay.Util.getOpener().<portlet:namespace /><%=formId%><%=HtmlFormAction.ACTION_DELETE%>closeDialog(obj);
						Liferay.Util.getOpener().<portlet:namespace/><%=form.getId()%>closeDialog(obj);
					
					}catch(e){
						console.log(e);
					}
				} 
				
				
			);
		});
	}catch(e){}
	
/*=======For Closing Dialog=======*/
	
	try{
		$("#<portlet:namespace/><%=formId%>deleteNo").click(function(event) {
			console.log("<portlet:namespace/><%=formId%>deleteNo clicked ");
			var obj={
				"dialogId" : dialogId,
				"message" : message,
				"error" : error,
				"refresh" : refresh
				
				
			};
			//Liferay.Util.getOpener().<portlet:namespace /><%=formId%><%=HtmlFormAction.ACTION_DELETE%>closeDialog(obj);
			Liferay.Util.getOpener().<portlet:namespace/><%=form.getId()%>closeDialog(obj);
			
		});
	}catch(e){}
	
/*======END Dialog Mode save function======*/
});
 --%>

</aui:script>