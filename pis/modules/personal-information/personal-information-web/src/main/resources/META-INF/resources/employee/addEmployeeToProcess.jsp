<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.addemployeetoprocess_jsp");
%>

<%
String formClass = ParamUtil.getString(request, "formClass");
String formId =  ParamUtil.getString(request, "formId");
String formFlowProcessId = ParamUtil.getString(request, "formFlowProcessId", "0");
if(formFlowProcessId==null || formFlowProcessId.equals("0")){	
	if(request.getAttribute("formFlowProcessId")!=null){
		formFlowProcessId=(String)request.getAttribute("formFlowProcessId");
	}
}else{
	request.setAttribute("formFlowProcessId", formFlowProcessId);
}

Enumeration paramNames = request.getParameterNames();

while(paramNames.hasMoreElements()){
	String paramName=(String)paramNames.nextElement();
	LOGGER.info(paramName + " - "+request.getParameter(paramName));
	
}

HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
%>

<portlet:renderURL var="employeeSelectionListURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/employee/selectEmployeeList.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.EMPLOYEESELECTIONFORM%>" />
	<portlet:param name="formActionAdd" value="no" />
	<portlet:param name="formId" value="employeeList" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<div class="container">
	<div class="row">
		<div class="col-md-12">	
			<button class="btn btn-primary" id="btn-add-employee">Add Employee</button>
		</div>
	</div>
</div>
<%
if(formFlowProcessId==null || formFlowProcessId.equals("0")){
%>
<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=formClass%>" />
	<liferay-util:param name="dataPreload" value="false" />
</liferay-util:include>
<%
}else{
%>	
<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=formClass%>" />
	<liferay-util:param name="searchFilter[transferProcessId]" value="<%=formFlowProcessId%>" />
	<liferay-util:param name="dataPreload" value="false" />
</liferay-util:include>
<%
}
%>
<aui:script>
	
	$(document).ready(function(){
		alert("In addEmployeeToProcess - formFlowProcessId : <%=formFlowProcessId %>");
		$("#btn-add-employee").click(function(){
			var url= '<%=employeeSelectionListURL.toString() %>';
			console.log(url);
			var dialogId='<portlet:namespace/>SelectEmployeeListOpenDialog';
			var title ='Select Employee';
			var width = 1020;
			LiferayUtilOpenWindow(dialogId, title, url, true, 700, true, width);
		});		
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace />SelectEmployeeListCloseDialog',
		function(data) {
			//alert("after close : "+data);
			if(data){
				console.log(data);	
			}
			if(data.action=="save" && data.value!=""){
				alert("data after close: "+data.value);
				var employeeId=data.value;
				var formFlowKeys = $(".form-flow-key");
				var formFlowKey=formFlowKeys[0];
				console.log(formFlowKey);
				var formFlowProcessId=$(formFlowKey).attr("value");
				alert("processKey : "+formFlowProcessId+", employeeId : "+employeeId);
				alert('<%=formClass.substring(formClass.lastIndexOf(".")+1)%>');
				<portlet:namespace/><%=form.getId()%>Save(formFlowProcessId, employeeId);
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/>SelectEmployeeListOpenDialog');
			dialog.destroy();
			//alert("before updateTable()");
			<%--
			<%=form.getId()%>ShowSuccessAlert();
			<%=form.getId()%>updateTable();
			 --%>
		},
		['liferay-util-window']
	);
		
	function <portlet:namespace/><%=form.getId()%>Save(formFlowProcessId, employeeId){
	alert("function <portlet:namespace/><%=form.getId()%>Save(formFlowProcessId, employeeId) called");
		var formDataJson={
			'namespace' : '<portlet:namespace/>',
			'<portlet:namespace/>formClass' : '<%=formClass%>',
			'<portlet:namespace/><%=form.getFormFlowKeyElement().getName()%>' : formFlowProcessId,
			'<portlet:namespace/>employeeId' : employeeId,
			'<portlet:namespace/>mappingField' : 'employeeId'
		};
		
		alert("before submit formDataJson: "+formDataJson);
		console.log(formDataJson);
		submitFormFlowDataJson(2, formDataJson, <portlet:namespace/><%=form.getId()%>SaveSuccess, function(){});
	}
	
	function <portlet:namespace/><%=form.getId()%>SaveSuccess(data, index){
		alert("<portlet:namespace/><%=form.getId()%>SaveSuccess called");
		var formFlowKeys = $(".form-flow-key");
		var formFlowKey=formFlowKeys[0];
		var formFlowProcessId=$(formFlowKey).attr("value");
				
		<%=form.getId()%>updateTableWithSearchFilter("<%=form.getFormFlowKeyElement().getName()%>", formFlowProcessId);
	}
	function <portlet:namespace/><%=form.getId()%>SaveFail(data, index){
		alert("<portlet:namespace/><%=form.getId()%>SaveFail called");
	}
</aui:script>

<aui:script use="liferay-util-window">
	
	<%--Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%>closeDialog',
		function(data) {
			//alert("after close : "+data);
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
			dialog.destroy();
			//alert("before updateTable()");
			<%=form.getId()%>ShowSuccessAlert();
			<%=form.getId()%>updateTable();
			
		},
		['liferay-util-window']
	);
		
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>closeDialog',
		function(data) {
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>openDialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);	--%>
</aui:script>