<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="java.util.Set"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_step_form_script_element_jsp");
%>

<%
int listElementCount=0;
int childFormCount=0;
boolean dialogMode=false;
Set<String> dependingParents=new HashSet<String>();
int tabIndex = ParamUtil.getInteger(request, "tabIndex", 0);
long repositoryId = themeDisplay.getScopeGroupId();
long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

String formFlowClass = ParamUtil.getString(request, "formFlowClass", "");
long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);

LOGGER.info("formFlowClass : "+formFlowClass+", formFlowClassPK : "+formFlowClassPK);
//HtmlFormWrapper formFlow=(HtmlFormWrapper)request.getAttribute("formFlow");

//HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute("form");

//if(StringUtils.isBlank(formId)){
//	formId=(String)request.getAttribute("formId");
	//form=(HtmlFormWrapper)request.getAttribute(formId);
//}

String flowFormId=(String)request.getAttribute("flowFormId");
HtmlFormWrapper formFlow=(HtmlFormWrapper)request.getAttribute(flowFormId);

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

HtmlElementWrapper formFlowElement=(HtmlElementWrapper)request.getAttribute("formFlowElement");

String formClass=form.getFormClass().getName();

boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}
%>

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/json.jsp" />
</portlet:resourceURL>

<portlet:renderURL var="nextRedirectURL">
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex+1)%>" />
</portlet:renderURL>

<portlet:renderURL var="prevRedirectURL">
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex-1)%>" />
</portlet:renderURL>

<script>
//alert("multi-step-form-add formFlowClassPK: <%=formFlowClassPK%>");
//alert("multi-step-form-add formFlowClass: <%=formFlowClass%>");
</script>

<aui:script use="aui-base,liferay-portlet-url,liferay-form,liferay-util-window">

<%

for(HtmlElementWrapper htmlElement:form.getElements()){

	if(StringUtils.isNotEmpty(htmlElement.getDepends()) && StringUtils.trim(htmlElement.getCustomTemplate()).equals("")){
		String name=htmlElement.getName();
		if(name.endsWith("Id")){
			name=name.substring(0, name.length()-2);
			if(name.endsWith("y")){
				name=name.substring(0, name.length()-1).concat("ies");
			}
		}
		String savedValue=(String)pageContext.getAttribute("savedValue");
		
		String funcName="load".concat(StringUtils.capitalize(name)).concat("By").concat(htmlElement.getDepends());
		HtmlElementWrapper de=form.getElementByName(htmlElement.getDepends());
		if(de.isControlType(HtmlElement.ControlType.select)){
			dependingParents.add(de.getName());
				
%>
			A.one("#<portlet:namespace/><%=de.getName()%>").on("change",function(){
				//alert(this.value +" -");
				<%=funcName%>(this.value);
			});
			
			function <%=funcName%>(<%=htmlElement.getDependantKey()%>){
				console.log('<%=listOptionsResourceURL%>');
				var dependantValue=A.one("#<portlet:namespace/><%=de.getName()%>").val();
				//alert("dependantValue : "+dependantValue);
				AUI().use('aui-io-request', function(A){
		    		A.io.request('<%=listOptionsResourceURL%>', {
						method: 'post',
						data: {
							<portlet:namespace />elementName: '<%=htmlElement.getName()%>',
							<portlet:namespace />dependantValue: dependantValue
						},
						on : {
							success : function() {
								var str = this.get('responseData');
								console.log(str);
								var data=$.parseJSON(str);
								reloadListOptions('#<portlet:namespace/><%=htmlElement.getName()%>',data,'key', 'value', 'Select a <%=htmlElement.getLabel() %>', '<%=savedValue%>');
							}
						}
					});
				});
			}
<%
		}
	}
}

for(HtmlElementGroupWrapper htmlGroup:form.getElementGroups()){
	for(HtmlElementWrapper htmlElement:htmlGroup.getElements()){

		if(StringUtils.isNotEmpty(htmlElement.getDepends())){
			String name=htmlElement.getName();
			if(name.endsWith("Id")){
				name=name.substring(0, name.length()-2);
				if(name.endsWith("y")){
					name=name.substring(0, name.length()-1).concat("ies");
				}
			}
			
			RelationWrapper relation= htmlElement.getRelation();
			
			String savedValue=(String)pageContext.getAttribute("savedValue");
			
			String funcName="load".concat(StringUtils.capitalize(name)).concat("By").concat(htmlElement.getDependantKey());
			
			HtmlElementWrapper de=htmlGroup.getElementByName(htmlElement.getDepends());
			if(de.isControlType(HtmlElement.ControlType.select)){
				dependingParents.add(de.getName());
		
%>
				A.one("#<portlet:namespace/><%=de.getName()%>").on("change",function(){
					//alert("<%=de.getName()%> -- "+this.value);
					<%=funcName%>(this.value);
				});
		
		
				function <%=funcName%>(<%=htmlElement.getDependantKey()%>){
				//console.log('<%=htmlElement.getDependantKey()%> - <%=listOptionsResourceURL%>');
			
					getListOptions('<%=relation.getModelClass().getName()%>', '<%=htmlElement.getDependantKey()%>', <%=htmlElement.getDependantKey()%>, '<%=relation.getValueField()%>', '<%=relation.getLabelField()%>', '#<portlet:namespace/><%=htmlElement.getName()%>', 'Select a <%=htmlElement.getLabel() %>', '<%=savedValue%>' );
<%--					AUI().use('aui-io-request', function(A){
	    				A.io.request('<%=listOptionsResourceURL%>', {
							method: 'post',
							data: {
								<portlet:namespace />elementName: '<%=htmlElement.getName()%>',
								<portlet:namespace />dependantValue: <%=htmlElement.getDependantKey() %>
							},
							on : {
								success : function() {
									var str = this.get('responseData');
									var data=$.parseJSON(str);
									reloadListOptions('#<portlet:namespace/><%=htmlElement.getName()%>',data,'key', 'value', 'Select a <%=htmlElement.getLabel() %>', '<%=savedValue%>');
								}
							}
						});
					});
				 --%>
				}
<%
			}
		}
	}
}
//if(!formFlow){ //if formFlow start
%>

<%--	A.one("#<portlet:namespace/><%=form.getId()%>").on('submit', function(event) {
		  alert( "<%=form.getId()%> Handler for .submit() called." );
		  event.preventDefault();
		  submit<portlet:namespace/><%=form.getId()%>();
		  return false;
		  
	});
	
	A.one('#<portlet:namespace/><%=form.getId()%>save').on('click', function(event) {
		alert("<portlet:namespace/><%=form.getId()%>save clicked ");
		submit<portlet:namespace/><%=form.getId()%>();
	});



	A.one('#<portlet:namespace/><%=form.getId()%>cancel').on('click', function(event) {
		alert("<portlet:namespace/><%=form.getId()%>cancel clicked ");
	    var data = {
	    	"refresh":"false"
	    };
<%
		if(dialogMode){
%>    
		Liferay.Util.getOpener().<portlet:namespace/><%=form.getId()%><%=formAction%>closeDialog(data);
<%
		}else{
		
%>
		window.location.href='<%=formListRenderURL.toString()%>';
<%
		}
%>
	});	 --%>
<%
//} //if formFlow end
%> 		
<%--
		for(Map.Entry<String, String> dep:dependingParents.entrySet()){
			System.out.println("function "+dep.getValue());
%>
			$("#<portlet:namespace/><%=dep.getKey()%>").on("change",function(){
				<%=dep.getValue()%>(this.value);
			});
<%	
		}
--%>
<%
		if(form.getEntity()!=null && form.getPrimaryKey()!=null){
			for(String dep:dependingParents){
%>
				//$("#<portlet:namespace/><%=dep%>").trigger("change");
<%			
			}
		}
%>

Liferay.provide(
		window,"LiferayUtilOpenWindow", function(id, title, uri, centered, height, modal, width){
	Liferay.Util.openWindow({
		dialog: {
			centered: centered,
			height: height,
			modal: modal,
			width: width
		},
		id: id,
		title: title,
		uri: uri
	});
});
</aui:script>
<script type="text/javascript">
<!--

	$( document ).ready(function() {
<%
		if(StringUtils.isNotEmpty(form.getTemplate())){
%>
			//alert("OK before renderForm<%=form.getId()%>");
	
			renderForm<%=form.getId()%>();
<%		
		}
%>

		initSelect2();
<%
		if(!viewOnlyMode){
%>
		try{
			$("#<portlet:namespace/><%=form.getId()%>").submit(function(event) {
				  //alert( "<%=form.getId()%> Handler for .submit() called." );
				  event.preventDefault();
				  submit<portlet:namespace/><%=form.getId()%>();
				  return false;
				  
			});
		}catch(e){}
<%
		}
%>
<%
	//Only enable next/prev actions if the current formFlowElement is a form
	if(formFlowElement!=null && formFlowElement.isControlType(HtmlElement.ControlType.form)){
%>
		try{
			$("#<portlet:namespace/><%=formFlow.getId()%>next").click(function(event) {
				//alert("<portlet:namespace/><%=form.getId()%>save clicked ");
<%
		if(!viewOnlyMode){
%>
			submit<portlet:namespace/><%=form.getId()%>();
<%
		}else{
%>
			window.location.href=prepareUrl('<%=nextRedirectURL.toString()%>');
<%
		}
%>
			});
		}catch(e){}
		<%-- For Closing Dialog --%>
		try{
			$("#<portlet:namespace/><%=formFlow.getId()%>prev").click(function(event) {
<%
		if(!viewOnlyMode){
%>				
			//alert("<portlet:namespace/><%=form.getId()%>cancel clicked ");
			<portlet:namespace/><%=form.getId()%>OnCancelClick();
<%
		}else{
%>
			window.location.href=prepareUrl('<%=prevRedirectURL.toString()%>');
<%
		}
%>			
			});
		}catch(e){}
<%	
	}
%>		
	});


	function getListOptions(entityClass, filterField, filterValue, valueField, labelField, selectElement, placeHolder, selectedValue){
		console.log("getListOptions("+entityClass+", "+filterField+", "+filterValue+", "+valueField+", "+labelField+")");
		Liferay.Service(
		    '/jetform.formfactory/get-list-options',
		    {
		    	entityClass: entityClass,
		    	filterField: filterField,
		    	filterValue: filterValue,
		    	valueField: valueField,
		    	labelField: labelField,
		    },
		    function(result) {
		        console.log(result);
		        reloadListOptions(selectElement,result,'key', 'value', placeHolder, selectedValue);
		    }
		);
	}
	

	function renderFormList(){
		<%--location.href='<%=formListRenderURL%>';--%>
	}

	function initSelect2(){
 		
 		//This is for enabling select2 plugin for select/dropdown controls
		$( "select" ).each(function( index, item ) {
			var selectedVal=$(item).val();
			console.log($(item).attr('name')+' :: '+ $(item).val());
			var itemselect2=$(item).select2({
	 			placeholder:'Select an option',
	 			allowClear: true
			});
			
			if(selectedVal!='' && selectedVal!='0'){
				$(itemselect2).val(selectedVal).trigger('change');
			}
		});
 		
		//This is for enabling select2 plugin for select/dropdown controls
		/*$(".select2-control").select2({
	 			placeholder: {
			    id: '-1', // the value of the option
			    text: 'Select an option'
			  },
	 			allowClear: true
		});
		
		//$.fn.select2.defaults.reset();
		$( ".select2-control" ).each(function( index ) {
			$(this).val($(this).val()).trigger('change');
		});*/
		//$('.select2-control').val(null).trigger('change');
		
		// Add the following code if you want the name of the file appear on select
		$(".custom-file-input").on("change", function() {
		  var fileName = $(this).val().split("\\").pop();
		  $(this).siblings(".custom-file-label").html(fileName);
		  //$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
		});
 		
 	}
<%--####### File upload Code #######--%>
<%-- 	 
	function readFileUrl(fileElement) {
		
		if(!$(fileElement) || !$(fileElement).prop('files') || $(fileElement).prop('files').length<1){
			return null;
		}

		var fileSelected = $(fileElement).prop('files')[0];

		if(fileSelected){	
			return fileSelected;
		}else{
			return null;
		}
	}
	
	function uploadFile(fileElement, progressBar, callback){
		alert("uploadFile(fileElement, progressBar, callback)");
		var fileSelected=readFileUrl(fileElement);
		
		if(!fileSelected){
			return false;
		}
	
		var repositoryId = <%=repositoryId%>;
        var folderId = <%=folderId%>;
        var mimeType='';
        var description="Scanned file";
        var changeLog=description;
        
		if(progressBar){
			progressBar.startProgress();
		}
		
		//alert("Before addFileEntry(repositoryId, folderId, description, fileSelected, callback)");
		addFileEntry(repositoryId, folderId, description, fileSelected, callback);
			//callback(fileElement, response);
		//});
		
		return fileSelected;
	}
	
	function addFileEntry(repositoryId, folderId, description, file, callback){
		//alert("In addFileEntry(repositoryId, folderId, description, fileSelected, callback)");
		var form = new FormData();
		form.append("file", file, file.name);
		form.append("repositoryId", repositoryId);
		form.append("folderId", folderId);
		form.append("sourceFileName", file.name);
		form.append("mimeType", file.type);
		form.append("title", file.name);
		form.append("description", description);
		form.append("changeLog", "Uploaded file");
		form.append("p_auth", Liferay.authToken);
		
		console.log(form);
		
		var settings = {
			"url": "/api/jsonws/dlapp/add-file-entry",
			"method": "POST",
			"timeout": 0,
			"headers": {},
			"processData": false,
			"mimeType": "multipart/form-data",
			"contentType": false,
			"data": form
		};
		
		$.ajax(settings).done(function (response) {
			console.log("addFileEntry");
			console.log("addFileEntry");
			callback(JSON.parse(response));
		});
	}--%>
	function deleteFileEntry(fileEntryId, callback){
		var form = new FormData();
		form.append("fileEntryId", fileEntryId);
		form.append("p_auth", Liferay.authToken);
		
		console.log(form);
		
		var settings = {
			"url": "/api/jsonws/dlapp/delete-file-entry",
			"method": "POST",
			"timeout": 0,
			"headers": {},
			"processData": false,
			"mimeType": "multipart/form-data",
			"contentType": false,
			"data": form
		};
		
		$.ajax(settings).done(function (response) {
			console.log("deleteFileEntry");
			callback(JSON.parse(response));
		});
	}
	
	
	function uploadCallBack(documentElement, response){
		console.log(response);
		$('#'+documentElement).val(response.fileEntryId);
	}	
<%
if(StringUtils.isNotEmpty(form.getTemplate())){
%>	
	function renderForm<%=form.getId()%>(){
		//alert($(formFieldContainer).html());
		
		//$(form).append($(formFieldContainer).html());

		<%--$(form).attr('action','<%=saveFormActionURL %>');--%>
		try{
			var source=$('#group-default-elements');
			var target=$('#defaultGroup');
			$(target).html($(source).html());
			//$(source).html('');
			
			$(source).remove();
			//console.log($(target).html());
		}catch(e){
			console.log(e);
		}
<%
		for(HtmlElementGroupWrapper group:form.getElementGroups()){
%>			
			try{
				var source=$('#group-<%=group.getId()%>-elements');
				var target=$('#<%=group.getId()%>');
				$(target).html($(source).html());
				//$(source).html('');
				$(source).remove();
				//console.log($(target).html());
			}catch(e){
				console.log(e);
			}
<%
		}
%>		
		
/*		var ph=$('#action-buttons');
		var source = $('#action-button-template').html();
		var template = Handlebars.compile(source);
		var resultHtml = template({});
		$(ph).html(resultHtml);*/
		//alert($(formFieldContainer).html());
		
		//initValidation();

	}
<%
}
%>

<%
	if(!viewOnlyMode){
%>
function submit<portlet:namespace/><%=form.getId()%>(){
	if(!validate('<portlet:namespace/><%=form.getId()%>')){
		return;
	}
	var formDataJson = $('#<portlet:namespace/><%=form.getId()%>').serializeFormJSON();
	formDataJson['namespace']='<portlet:namespace/>';
	formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass().getName()%>';
	console.log("formDataJson");
	console.log(formDataJson);
	submitFormDataJson(formDataJson, <portlet:namespace/><%=form.getId()%>OnSaveSuccess, <portlet:namespace/><%=form.getId()%>OnSaveFailure);
}
<%
	}
%>

function submitFormDataJson(formDataJson, onSuccess, onFailure){
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/save-form',
			{
				params: formDataJson
			},
			function(obj) {
				try{
					console.log("499 -- Before console.log(obj)");
					console.log(obj);
					onSuccess(obj);
				}catch(e){
					onFailure(obj);
				}
			}
		);
	});	
}

function <portlet:namespace/><%=form.getId()%>OnSaveSuccess(obj){
	console.log("Successful");
	console.log(obj);
	console.log('<%=form.getKeyElement().getName()%>');
	var data={};
	try{
		data=$.parseJSON(obj);
		
		//alert('<%=form.getKeyElement().getName()%> : '+data['<%=form.getKeyElement().getName()%>']);
<%--
		$(".form-key-<%=form.getKeyElement().getName()%>").val(data["<%=form.getKeyElement().getName()%>"]);
--%>
	}catch(e){
		console.log(e);
	}
<%
	if(listElementCount>0){
%>	
	if(obj){
		
		//alert('<%=form.getKeyElement().getName()%>');
		//alert(data["<%=form.getKeyElement().getName()%>"]);
<%--$(".form-key-<%=form.getKeyElement().getName()%>").val(data["<%=form.getKeyElement().getName()%>"]);--%>
		//alert(data.message);
	}
	
	return false;
<%
	}
	if(!dialogMode){
		
%>	
		var url="<%=nextRedirectURL.toString()%>";
		//alert('<%=form.getKeyElement().getName()%> 1 : '+data['<%=form.getKeyElement().getName()%>']);
<%
		if(formFlowClassPK==0 && form.isFormFlowProcess()){
%>
			url=url+"&<portlet:namespace/>formFlowClassPK="+data["<%=form.getKeyElement().getName()%>"];
<%
		}
%>
		url=prepareUrl(url);
		console.log(url);
		window.location.href=url;
<%	
	}else{
%>		
		try{
			if(data.status.indexOf("fail")>=0){
				data = {
					"refresh":false,
					"error":true,
					"message":data.message
				};	
			}else{
				data = {
					"refresh":true,
					"error":false,
					"message":data.message
				};				
			}
		}catch(e){}
<%
		String cancelFunc=ParamUtil.getString(request, "cancelFunc");
		if(StringUtils.isNotEmpty(cancelFunc)){
			String dialogId=ParamUtil.getString(request, "dialogId");
%>
			console.log("cancelFunc : <%=cancelFunc%>");
			data.dialogId='<%=dialogId%>';
			try{
				Liferay.Util.getOpener().<%=cancelFunc%>(data);
			}catch(e){}
<%
		}else{
%>			
			try{
				Liferay.Util.getOpener().<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>closeDialog(obj);
			}catch(e){}
<%
		}
	}
%>
}

function <portlet:namespace/><%=form.getId()%>OnCancelClick(){
	//alert("Successful : "+obj);

<%
	if(dialogMode){
%>    
		var data = {
			"refresh":false
		};
<%	
		String cancelFunc=ParamUtil.getString(request, "cancelFunc");
		if(StringUtils.isNotEmpty(cancelFunc)){
			String dialogId=ParamUtil.getString(request, "dialogId");
%>
			console.log("cancelFunc : <%=cancelFunc%>");
			data.dialogId='<%=dialogId%>';
			try{
				Liferay.Util.getOpener().<%=cancelFunc%>(data);
			}catch(e){}
<%
		}else{
%>			
			try{
	
				Liferay.Util.getOpener().<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>closeDialog(data);
			}catch(e){}
<%
		}
	}else{
%>
		var url='<%=prevRedirectURL.toString()%>';
		url=prepareUrl(url);
		window.location.href=url;
<%
	}
%>
}


function <portlet:namespace/><%=form.getId()%>OnSaveFailure(obj){
<%
	if(dialogMode){
%>  
		var data = {
			"error":true,
			"refresh":false,
			"message":"Data saving failed."
		};
<%	
		String cancelFunc=ParamUtil.getString(request, "cancelFunc");
		if(StringUtils.isNotEmpty(cancelFunc)){
			String dialogId=ParamUtil.getString(request, "dialogId");
%>
			console.log("cancelFunc : <%=cancelFunc%>");
			data.dialogId='<%=dialogId%>';
			try{
				Liferay.Util.getOpener().<%=cancelFunc%>(data);
			}catch(e){}
<%
		}else{
%>			
			try{	
				Liferay.Util.getOpener().<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>closeDialog(data);
			}catch(e){}
<%
		}
	}
%>
}

function validate(formId){
    //var liferayForm = Liferay.Form.get('<portlet:namespace/><%=form.getId()%>');
	var liferayForm = Liferay.Form.get(formId);
    if (liferayForm) {
        var validator = liferayForm.formValidator;
        
		//alert("A.instanceOf(validator, A.FormValidator): "+(A.instanceOf(validator, A.FormValidator)));
		//if (A.instanceOf(validator, A.FormValidator)) {
            validator.validate();

            var hasErrors = validator.hasErrors();

            if (hasErrors) {
                validator.focusInvalidField();

                return false;
            }
        //}
	}
    return true;
}


function yearDiff(dateFrom, dateTo) {
 	return dateTo.getFullYear() - dateFrom.getFullYear();
}

function monthDiff(dateFrom, dateTo) {
 	return dateTo.getMonth() - dateFrom.getMonth() + 
   	(12 * (dateTo.getFullYear() - dateFrom.getFullYear()))
}

function dayDiff(dateFrom, dateTo) {
	var diff = dateTo.getTime() - dateFrom.getTime();   
	var daydiff = diff / (1000 * 60 * 60 * 24); 
	return daydiff;
}

function prepareUrl(url){
	if(url.indexOf('<portlet:namespace/>formFlowClass=')<0){
		url=url+"&<portlet:namespace/>formFlowClass=<%=formFlowClass%>";
	}
	
	if(url.indexOf('<portlet:namespace/>formFlowClassPK=')<0){
		url=url+"&<portlet:namespace/>formFlowClassPK=<%=formFlowClassPK%>";
	}
	return url;
}
//-->
</script>

<script type="text/x-handlebars-template" id="action-button-template">
	<div class="btn-group-item">
		<aui:button cssClass="btn-dark btn-sm" type="submit" name="submit" value="Submit"/>
	</div>
	<div class="btn-group-item">
		<aui:button cssClass="btn-dark btn-sm" type="reset" name="reset" value="Reset"/>
	</div>							
	<div class="btn-group-item">
		<aui:button cssClass="btn-dark btn-sm" type="button" name="cancel" value="Cancel" onClick="renderFormList()"/>
	</div>
</script>
