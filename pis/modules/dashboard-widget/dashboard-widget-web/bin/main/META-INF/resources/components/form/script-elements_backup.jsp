<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%
long repositoryId = themeDisplay.getScopeGroupId();
long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
Set<String> dependingParents=new HashSet<String>();
%>
<aui:script use="aui-base, liferay-portlet-url liferay-form">

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
				alert("dependantValue : "+dependantValue);
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
		try{
			$("#<portlet:namespace/><%=form.getId()%>").submit(function(event) {
				  //alert( "<%=form.getId()%> Handler for .submit() called." );
				  event.preventDefault();
				  submit<portlet:namespace/><%=form.getId()%>();
				  return false;
				  
			});
		}catch(e){}
		try{
			$("#<portlet:namespace/><%=form.getId()%>save").click(function(event) {
				//alert("<portlet:namespace/><%=form.getId()%>save clicked ");
				submit<portlet:namespace/><%=form.getId()%>();
			});
		}catch(e){}
		<%-- For Closing Dialog --%>
		try{
			$("#<portlet:namespace/><%=form.getId()%>cancel").click(function(event) {
				//alert("<portlet:namespace/><%=form.getId()%>cancel clicked ");
				<portlet:namespace/><%=form.getId()%>OnCancelClick();
			});
		}catch(e){}
		
		try{
			//This is for enabling select2 plugin for select/dropdown controls
			$(".select2-control").select2({
		 			placeholder: {
				    id: '-1', // the value of the option
				    text: 'Select an option'
				  },
		 			allowClear: true
			});
			
			//$.fn.select2.defaults.reset();
			$( ".select2-control" ).each(function( index ) {
				$(this).val($(this).val()).trigger('change');
			});
			//$('.select2-control').val(null).trigger('change');
		}catch(e){}
	});

	function getListOptions(entityClass, filterField, filterValue, valueField, labelField, selectElement, placeHolder, selectedValue){
		//alert("getListOptions("+entityClass+", "+filterField+", "+filterValue+", "+valueField+", "+labelField+")");
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
		location.href='<%=formListRenderURL%>';
	}

	
<%--####### File upload Code #######--%>
 	 
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
		//alert("uploadFile(fileElement, progressBar, callback)");
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
	}
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

function submit<portlet:namespace/><%=form.getId()%>(){
	if(!validate()){
		return;
	}
	var formDataJson = $('#<portlet:namespace/><%=form.getId()%>').serializeFormJSON();
	formDataJson['namespace']='<portlet:namespace/>';
	formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass().getName()%>';
	console.log("formDataJson");
	console.log(formDataJson);
	submitFormDataJson(formDataJson, <portlet:namespace/><%=form.getId()%>OnSaveSuccess, <portlet:namespace/><%=form.getId()%>OnSaveFailure);
}


function submitFormDataJson(formDataJson, onSuccess, onFailure){
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/save-form',
			{
				params: formDataJson
			},
			function(obj) {
				try{
					onSuccess(obj);
				}catch(e){}
			}
		);
	});	
}

function <portlet:namespace/><%=form.getId()%>OnSaveSuccess(obj){
	console.log("Successful");
	console.log(obj);
	console.log('<%=form.getKeyElement().getName()%>');
<%
	if(listElementCount>0){
%>	
	if(obj){
		var data=$.parseJSON(obj);
		//alert('<%=form.getKeyElement().getName()%>');
		//alert(data["<%=form.getKeyElement().getName()%>"]);
		$(".form-key-<%=form.getKeyElement().getName()%>").val(data["<%=form.getKeyElement().getName()%>"]);
		alert("Data saved successfully.");
	}
	
	return false;
<%
	}
	if(!dialogMode){
%>	
		window.location.href="<%=formListRenderURL.toString()%>";
<%
	}else{
%>
		var data = {
			"refresh":"true"
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
			"refresh":"false"
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
	window.location.href='<%=formListRenderURL.toString()%>';
<%
	}
%>
}


function <portlet:namespace/><%=form.getId()%>OnSaveFailure(obj){
<%
	if(dialogMode){
%>  
		var data = {
			"error":"true"
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

function validate(){
    var liferayForm = Liferay.Form.get('<portlet:namespace/><%=form.getId()%>');

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