<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%--link rel="stylesheet"
	href="<%=request.getContextPath()%>/fonts/font-awesome/css/font-awesome.min.css">
 --%>	
<%
boolean isError = ParamUtil.getBoolean(request, "error", false);
String message = ParamUtil.getString(request, "message");
String formId = ParamUtil.getString(request, "formId");
String employeeDscId = ParamUtil.getString(request, "employeeDscId");
String employeeId = ParamUtil.getString(request, "employeeId");
String ofbDSCRevocationStatus = ParamUtil.getString(request, "ofbDSCRevocationStatus");
String ofbDSCReissueStatus = ParamUtil.getString(request, "ofbDSCReissueStatus");
String dscForm = ParamUtil.getString(request, "dscForm");
String closeFunc = ParamUtil.getString(request, "closeFunc");
String dialogId = ParamUtil.getString(request, "dialogId");
boolean confirmation = ParamUtil.getBoolean(request, "confirmation", true);
//dialogMode=true;
%>
<div class="container">
	<div class="row mb-3"></div>
	
	<div class="row">
		<div class="col-md-12">
<%
	if(confirmation){
%>	
	<i class="fas fa-check-circle" style="font-size: 1.5rem;"></i>
		<%=message%>
<%
	}else{
%>		
	<i class="fa fa-exclamation-triangle" style="color:black; font-size: 1.5rem;"></i>
		<%=message%>
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
	if(confirmation){
%>				
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-danger" type="button" name="<%="confYes"%>" value="Yes" />
						</div>
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="<%="confNo"%>" value="No" />
						</div>
<%
	}else{
%>		
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="<%="confNo"%>" value="Ok" />
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
		$("#<portlet:namespace/>confYes").click(function(event) {
			console.log("<portlet:namespace/>confYes clicked ");
			var refresh=true;
			var message='Done';
			var dialogId ='<%=dialogId %>';
			var obj={
				"dialogId" : dialogId,
				"refresh":refresh,
				"message" : message,
			};
			
			update(obj)
			
			
		});
	}catch(e){}
	
/*=======For Closing Dialog=======*/
	try{
		$("#<portlet:namespace/>confNo").click(function(event) {
			var refresh=true;
			var message='Done';
			var dialogId ='<%=dialogId %>';
			var obj={
				"dialogId" : dialogId,
				"refresh":refresh,
				"message" : message,
			};
			
<%
			if(StringUtils.isNotBlank(closeFunc)){
%>			
				Liferay.Util.getOpener().<%=closeFunc%>(obj);
<%
			}else{
%>				
				Liferay.Util.getOpener().<portlet:namespace /><%=formId%>closeDialog(obj);
<%
			}
%>
		});
	}catch(e){}
	
/*======END Dialog Mode save function======*/

function update(popObj){
var employeeDscId='<%=employeeDscId %>'
var employeeId='<%=employeeId %>'
var ofbDSCRevocationStatus='<%=ofbDSCRevocationStatus %>'
var ofbDSCReissueStatus='<%=ofbDSCReissueStatus %>'
var employeeDsc = new EmployeeDsc(employeeDscId, employeeId, ofbDSCRevocationStatus, ofbDSCReissueStatus);
Liferay.Service(
  '/pis.employeedsc/update',
  {
    employeeDsc: employeeDsc
  },
  function(obj) {
    console.log(obj);
    alert("Successfully Done");
    try{
<%
			if(StringUtils.isNotBlank(closeFunc)){
%>			
				Liferay.Util.getOpener().<%=closeFunc%>(popObj);
<%
			}else{
%>				
				Liferay.Util.getOpener().<portlet:namespace /><%=formId%>closeDialog(popObj);
<%
			}
%>				
			}catch(e){
				console.log(e);
			}
  }
);
}


class EmployeeDsc {
    constructor(employeeDscId, employeeId, ofbDSCRevocationStatus, ofbDSCReissueStatus) {
        this.employeeDscId = employeeDscId;
        this.employeeId = employeeId;
        this.ofbDSCRevocationStatus = ofbDSCRevocationStatus;
        this.ofbDSCReissueStatus = ofbDSCReissueStatus;
    }
}
});



</aui:script>