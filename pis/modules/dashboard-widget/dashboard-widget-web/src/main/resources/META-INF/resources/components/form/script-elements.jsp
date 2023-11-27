<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
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
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.script-element_jsp");
%>

<%
long repositoryId = themeDisplay.getScopeGroupId();
long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
int listElementCount=0;

Set<String> dependingParents=new HashSet<String>();
String formClass = ParamUtil.getString(request, "formClass");
String formClassPK = ParamUtil.getString(request, "formClassPK");
String redirectPage = ParamUtil.getString(request, "redirectPage","/components/list/form-list-restful.jsp");
boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}
%>

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/json.jsp" />
</portlet:resourceURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="<%=redirectPage %>" />
</portlet:renderURL>
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

				}
<%
			}
		}
	}
}
%>

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
<script>


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

		try{
			$("#<portlet:namespace/><%=form.getId()%>save").click(function(event) {
<%
				if(!viewOnlyMode){
%>
					//alert("<portlet:namespace/><%=form.getId()%>save clicked ");
					submit<portlet:namespace/><%=form.getId()%>();
<%
				}else{
%>
					window.location.href='<%=formListRenderURL.toString()%>';
<%
				}
%>
			});
		}catch(e){}
		
		<%-- For Closing Dialog --%>
		try{
			$("#<portlet:namespace/><%=form.getId()%>cancel").click(function(event) {
				//alert("<portlet:namespace/><%=form.getId()%>cancel clicked ");
<%
				if(!viewOnlyMode){
%>				
					<portlet:namespace/><%=form.getId()%>OnCancelClick();
<%
				}else{
%>
					window.location.href='<%=formListRenderURL.toString()%>';
<%
				}
%>				
			});
		}catch(e){}
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
		location.href='<%=formListRenderURL%>';
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
 		
		// Add the following code if you want the name of the file appear on select
		$(".custom-file-input").on("change", function() {
		  var fileName = $(this).val().split("\\").pop();
		  $(this).siblings(".custom-file-label").html(fileName);
		  //$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
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
	}catch(e){
		console.log(e);
	}
<%
	if(listElementCount>0){
%>	
	if(obj){
		
		//alert('<%=form.getKeyElement().getName()%>');
		//alert(data["<%=form.getKeyElement().getName()%>"]);
		$(".form-key-<%=form.getKeyElement().getName()%>").val(data["<%=form.getKeyElement().getName()%>"]);
		alert(data.message);
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

//This is written by arjun
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