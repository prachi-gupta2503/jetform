<%@page import="com.adjecti.common.util.FormEntityCache"%>
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

boolean childForm=false;
String formId=(String)request.getAttribute("childFormId");
if(StringUtils.isBlank(formId)){
	formId=(String)request.getAttribute("formId");
}else{
	childForm=true;
}

String parentFormId=(String)request.getAttribute("formId");
if(request.getAttribute("parentFormId")!=null){
	parentFormId=(String)request.getAttribute("parentFormId");
}

String childFormNamespace="";
if(childForm){
	childFormNamespace=(String)request.getAttribute("childFormNamespace");
}

//String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

HtmlElementWrapper formFlowElement=(HtmlElementWrapper)request.getAttribute("formFlowElement");

String formClass=form.getFormClass();

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
<%
	if(viewOnlyMode){
%>
	<portlet:param name="viewOnlyMode" value="true" />
<%
	}
%>	
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex+1)%>" />
</portlet:renderURL>

<portlet:renderURL var="prevRedirectURL">
<%
	if(viewOnlyMode){
%>
	<portlet:param name="viewOnlyMode" value="true" />
<%
	}
%>	
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex-1)%>" />
</portlet:renderURL>

<aui:script use="aui-base,liferay-portlet-url,liferay-form,liferay-util-window">
//alert("multi-step-form-add formFlowClassPK: <%=formFlowClassPK%>");
//alert("multi-step-form-add formFlowClass: <%=formFlowClass%>");

<%

for(HtmlElementWrapper htmlElement:form.getAllElements()){

	if(StringUtils.isNotEmpty(htmlElement.getDepends()) && StringUtils.trim(htmlElement.getCustomTemplate()).equals("")){
		String name=htmlElement.getName();
		if(name.endsWith("Id")){
			name=name.substring(0, name.length()-2);
			if(name.endsWith("y")){
				name=name.substring(0, name.length()-1).concat("ies");
			}
		}
		String savedValue=(String)request.getAttribute(childFormNamespace+htmlElement.getName()+ "_savedValue");
		
		String funcName="load".concat(StringUtils.capitalize(name)).concat("By").concat(htmlElement.getDepends());
		HtmlElementWrapper de=form.getElementByName(htmlElement.getDepends());
		RelationWrapper relation= htmlElement.getRelation();
		if(de.isControlType(HtmlElement.ControlType.select)){
			dependingParents.add(de.getName());

			
%>
			$("#<portlet:namespace/><%=formId+childFormNamespace+de.getName()%>").on("change",function(){
				var selectedValue='<%=savedValue%>';
				console.log("<%=de.getName()%> : "+this.value +", <%=htmlElement.getName()%> : "+selectedValue);
				//alert(this.value +" -");
				var entityClass='<%=relation.getModelClass()%>';
				var filterField='<%=htmlElement.getDependantKey()%>';
				var filterValue=$(this).val();
				var valueField='<%=relation.getValueField()%>';
				var labelField='<%=relation.getLabelField()%>';
				var dependingElement=$("#<portlet:namespace/><%=formId+childFormNamespace+htmlElement.getName()%>");
				var placeHolder='Select <%=htmlElement.getLabel()%>';
				
				//alert("selectedValue : "+selectedValue);
				getListOptions(entityClass, filterField, filterValue, valueField, labelField, dependingElement, placeHolder, selectedValue);
				<%--<%=funcName%>(this.value);--%>
			});
<%
		}
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

<%--<script type="text/javascript">--%>

	$( document ).ready(function() {
<%
		if(StringUtils.isNotEmpty(form.getTemplate())){
%>
			//alert("OK before renderForm<%=form.getId()%>");
	
			renderForm<%=form.getId()%>();
<%		
		}
		if(form.getEntity()!=null && form.getPrimaryKey()!=null){
			for(String dep:dependingParents){
%>
				$("#<portlet:namespace/><%=formId+childFormNamespace+dep%>").trigger("change");
<%			
			}
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
		//		alert("<portlet:namespace/><%=form.getId()%>save clicked ");
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


	Liferay.provide(window,'getListOptions', function(entityClass, searchField, searchValue, valueField, labelField, selectElement, placeHolder, selectedValue){
		console.log("getListOptions("+entityClass+", "+searchField+", "+searchValue+", "+valueField+", "+labelField+")");
		Liferay.Service(
		    '/jetform.jetformbuilder/get-list-options',
		    {
		    	entityClass: entityClass,
		    	searchField: searchField,
		    	searchValue: searchValue,
		    	valueField: valueField,
		    	labelField: labelField,
		    	p_auth: Liferay.authToken
		    },
		    function(result) {
		        reloadListOptions(selectElement,result,'key', 'value', '', selectedValue);
		    }
		);
	});
	

	Liferay.provide(window,'renderFormList', function(){
		<%--location.href='<%=formListRenderURL%>';--%>
	});

	Liferay.provide(window,'initSelect2', function(){
 		
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
 		
 	});

	Liferay.provide(window,'deleteFileEntry', function(fileEntryId, callback){
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
	});
	
	
	Liferay.provide(window,'uploadCallBack',function(documentElement, response){
		console.log(response);
		$('#'+documentElement).val(response.fileEntryId);
	});	
<%
if(StringUtils.isNotEmpty(form.getTemplate())){
%>	
	Liferay.provide(window,'renderForm<%=form.getId()%>', function(){
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

	});
<%
}
%>

<%
	if(!viewOnlyMode){
%>
Liferay.provide(window,'submit<portlet:namespace/><%=form.getId()%>', function(){
//	alert("submit<portlet:namespace/><%=form.getId()%>() called");
	if(!validate('<portlet:namespace/><%=form.getId()%>')){
		return;
	}
	var formDataJson = $('#<portlet:namespace/><%=form.getId()%>').serializeFormJSON();
	formDataJson['namespace']='<portlet:namespace/>';
	formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass()%>';
	console.log("formDataJson");
	console.log(formDataJson);
	submitFormDataJson(formDataJson, <portlet:namespace/><%=form.getId()%>OnSaveSuccess, <portlet:namespace/><%=form.getId()%>OnSaveFailure);
});
<%
	}
%>

Liferay.provide(window,'submitFormDataJson', function(formDataJson, onSuccess, onFailure){
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
});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>OnSaveSuccess', function(obj){
	console.log("Successful");
	console.log(obj);
	console.log('<%=form.getKeyElement().getName()%>');
	//console.log('<%=form.getFormFlowKeyElement().getName()%>');
	var data={};
	try{
		data=$.parseJSON(obj);
		
		//alert('<%=form.getKeyElement().getName()%> : '+data['<%=form.getKeyElement().getName()%>']);
		//alert('<%=form.getFormFlowKeyElement().getName()%> : '+data['<%=form.getFormFlowKeyElement().getName()%>']);
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
		//console.log("before prepare: "+url);
		url=prepareUrl(url);
		//console.log("after prepare: "+url);
		window.location.href=url;
<%	
	}else{
%>		
		//alert("in dialogMode");
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
		String closeFunc=ParamUtil.getString(request, "closeFunc");
		if(StringUtils.isNotEmpty(closeFunc)){
			String dialogId=ParamUtil.getString(request, "dialogId");
%>
			console.log("closeFunc : <%=closeFunc%>");
			data.dialogId='<%=dialogId%>';
			try{
				Liferay.Util.getOpener().<%=closeFunc%>(data);
			}catch(e){}
<%
		}else{
%>			
			try{
				Liferay.Util.getOpener().<portlet:namespace /><%=form.getId()%>closeDialog(obj);
			}catch(e){}
<%
		}
	}
%>
});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>OnCancelClick', function(){
	//alert("Successful : "+obj);

<%
	if(dialogMode){
%>    
		var data = {
			"refresh":false
		};
<%	
		String closeFunc=ParamUtil.getString(request, "closeFunc");
		if(StringUtils.isNotEmpty(closeFunc)){
			String dialogId=ParamUtil.getString(request, "dialogId");
%>
			console.log("closeFunc : <%=closeFunc%>");
			data.dialogId='<%=dialogId%>';
			try{
				Liferay.Util.getOpener().<%=closeFunc%>(data);
			}catch(e){}
<%
		}else{
%>			
			try{
	
				Liferay.Util.getOpener().<portlet:namespace /><%=form.getId()%>closeDialog(data);
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
});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>OnSaveFailure', function(obj){
<%
	if(dialogMode){
%>  
		var data = {
			"error":true,
			"refresh":false,
			"message":"Data saving failed."
		};
<%	
		String closeFunc=ParamUtil.getString(request, "closeFunc");
		if(StringUtils.isNotEmpty(closeFunc)){
			String dialogId=ParamUtil.getString(request, "dialogId");
%>
			console.log("closeFunc : <%=closeFunc%>");
			data.dialogId='<%=dialogId%>';
			try{
				Liferay.Util.getOpener().<%=closeFunc%>(data);
			}catch(e){}
<%
		}else{
%>			
			try{	
				Liferay.Util.getOpener().<portlet:namespace /><%=form.getId()%>closeDialog(data);
			}catch(e){}
<%
		}
	}
%>
});

</aui:script>

<script>

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

function prepareUrl(url){
	if(url.indexOf('<portlet:namespace/>formFlowClass=')<0){
		url=url+"&<portlet:namespace/>formFlowClass=<%=formFlowClass%>";
	}
	
	if(url.indexOf('<portlet:namespace/>formFlowClassPK=')<0){
		url=url+"&<portlet:namespace/>formFlowClassPK=<%=formFlowClassPK%>";
	}
	return url;
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
