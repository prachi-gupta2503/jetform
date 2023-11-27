<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.adjecti.jetform.liferay.model.EntityWorkflow"%>
<%@page import="com.adjecti.jetform.liferay.service.EntityWorkflowLocalServiceUtil"%>
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
String closeFunc= ParamUtil.getString(request, "closeFunc");
String dialogId= ParamUtil.getString(request, "dialogId");

HtmlFormWrapper form=JetFormBuilderLocalServiceUtil.rendererForm(formClass);
EntityWorkflow workflow=EntityWorkflowLocalServiceUtil.getEntityWorkflow(form.getEntityClass(), formClassPK);

//dialogMode=true;
%>
<div class="container">
	<div class="row mb-3"></div>
	
	<div class="row">
		<div class="col-md-12">
<%
	if(formClassPK<1){
%>	
			<i class="fa fa-exclamation-triangle" style="color:black; font-size: 1.5rem;"></i>
			No valid <%=AnnotationUtil.getItemLabel(form.getTitle())%> record to approve!
				
<%
	}else if(workflow!=null){
		DateFormat df=new SimpleDateFormat("dd MMMM yyyy hh:mm a");
%>	
	<div class="container">
		<div class="row">
			<div class="col-md-6"><label>Status</label></div>
			<div class="col-md-6">Approved</div>
		</div>

		<div class="row">
			<div class="col-md-6"><label>Approved By</label></div>
			<div class="col-md-6"><%=workflow.getUserName() %></div>
		</div>
		
		<div class="row">
			<div class="col-md-6"><label>Approved On</label></div>
			<div class="col-md-6"><%=df.format(workflow.getCreateDate()) %></div>
		</div>
		
		<div class="row">
			<div class="col-md-6"><label>Remark</label></div>
			<div class="col-md-6"><%=workflow.getRemark() %></div>
		</div>	
	</div>
<%
	}else{
%>
	<i class="fa fa-exclamation-triangle" style="color:red; font-size: 1.5rem;"></i>
		Are you sure you want to approve the <%=AnnotationUtil.getItemLabel(form.getTitle())%>?	
<%--		
			<div class="form-group-autofit">
				<div class="form-group-item required">
					<label class="control-label">Remark</label>
					<textarea class="form-control" rows="5" cols="50" name="<portlet:namespace/>remark" id="<portlet:namespace/>remark"></textarea>
				</div>
			</div>
 --%>
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
	if(formClassPK>=1 && workflow==null){
%>				
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="button" name="<%=formId+"approve"%>" value="Approve" />
						</div>
						<%--div class="btn-group-item">
							<aui:button cssClass="btn btn-danger" type="button" name="<%=formId+"reject"%>" value="Reject" />
						</div--%>
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-secondary" type="button" name="<%=formId+"close"%>" value="Cancel" />
						</div>
<%
	}else{
%>	
		
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="button" name="<%=formId+"close"%>" value="Ok" />
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
/*=====START Dialog Mode save function=====*/

$( document ).ready(function() {		
	try{
		$("#<portlet:namespace/><%=formId%>approve").click(function(event) {
			console.log("<portlet:namespace/><%=formId%>approve clicked ");
			Liferay.Service(
				'/jetform.jetformbuilder/approve-entity',
				{
					"className": "<%=form.getEntityClass()%>",
					"classPK":<%=formClassPK%>,
					"userId":<%=user.getUserId()%>,
					"remark":"Approved"
				},
				function(response) {
					console.log(response);
					var flag=(response>0);
					var message=(flag?"Approved successfully":"Approval failed");
					var obj={
						"message":message,
						"status":flag,
						"refresh":flag,
						"dialogId":"<%=dialogId%>"
					};
					try{
						Liferay.Util.getOpener().<%=closeFunc%>(obj);
					}catch(e){
						console.log(e);
					}
				}
			);
		});
	}catch(e){}
<%--	
	try{
		$("#<portlet:namespace/><%=formId%>reject").click(function(event) {
			console.log("<portlet:namespace/><%=formId%>reject clicked ");
			Liferay.Service(
				'/jetform.jetformbuilder/reject-entity',
				{
					"className": "<%=form.getEntityClass().getName()%>",
					"classPK":<%=formClassPK%>,
					"userId":<%=user.getUserId()%>,
					"remark":"Rejected"
				},
				function(response) {
					console.log(response);
					var obj={
						"status":response,
						"refresh":response
					};
					try{
						Liferay.Util.getOpener().<%=cancelFunc %>(obj);
					}catch(e){
						console.log(e);
					}
				}
			);
		});
	}catch(e){}
 --%>	
/*=======For Closing Dialog=======*/
	
	try{
		$("#<portlet:namespace/><%=formId%>close").click(function(event) {
			console.log("<portlet:namespace/><%=formId%>close clicked ");
			var obj={
				"dialogId" :'<%=dialogId %>',
				"refresh":"false",
				"message" : '',
				"error" :  false,
				
			};
			Liferay.Util.getOpener().<%=closeFunc %>(obj);
		});
	}catch(e){}
	
/*======END Dialog Mode save function======*/
});
</aui:script>