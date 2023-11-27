<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.fasterxml.jackson.databind.util.ClassUtil"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
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
String redirectPage = ParamUtil.getString(request, "redirectPage","/components/list/form-list-restful.jsp");
String sectionMVCPath = ParamUtil.getString(request, "sectionMVCPath");
boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
String closeFunc=ParamUtil.getString(request, "closeFunc", "");
String dialogId=ParamUtil.getString(request, "dialogId");

String formClass = ParamUtil.getString(request, "childFormClass");
if(StringUtils.isBlank(formClass)){
	formClass=(String)request.getAttribute("formClass");
}
if(formClass.equals("com.adjecti.pis.liferay.form.SectionForm")){
	LOGGER.info("Inside Condition : "+formClass);	
	redirectPage=sectionMVCPath;
}
String formClassPK = ParamUtil.getString(request, "childFormClassPK");
if(StringUtils.isBlank(formClassPK)){
	formClassPK=(String)request.getAttribute("formClassPK");
}

boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}

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

HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

if(StringUtils.isBlank(closeFunc)){
	closeFunc=renderResponse.getNamespace()+form.getId()+"closeDialog";
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
var viewOnlyMode=<%=viewOnlyMode %>;
var dialogMode=<%=dialogMode %>;
var closeFunc='<%=closeFunc%>';
var dialogId='<%=dialogId%>';
var listElementCount=<%=listElementCount%>;

<%
for(HtmlElementWrapper htmlElement:form.getAllElements()){

	if(StringUtils.isNotBlank(htmlElement.getDepends()) && StringUtils.isBlank(htmlElement.getCustomTemplate())){
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

			if(relation.isValidModelClass()){
				System.out.println("is Valid::"+ClassUtils.getClass(relation.getModelClass()));
				FormEntityCache.registerFormClass(ClassUtils.getClass(relation.getModelClass()));
			}
			
			if(relation.isValidMappingClass()){
				FormEntityCache.registerFormClass(ClassUtils.getClass(relation.getModelClass()));
			}
			
			if(de.getRelation().isValidModelClass()){
				FormEntityCache.registerFormClass(ClassUtils.getClass(de.getRelation().getModelClass()));
			}
			
			if(de.getRelation().isValidMappingClass()){
				FormEntityCache.registerFormClass(ClassUtils.getClass(de.getRelation().getMappingClass()));
			}
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
		try{
			$("#<portlet:namespace/><%=form.getId()%>").submit(function(event) {
				validate();
				  //alert( "<%=form.getId()%> Handler for .submit() called." );
				if(!viewOnlyMode){		  
					event.preventDefault();
					
					var callDefaultSubmit=true;
					try{
						callDefaultSubmit=beforeSubmit<portlet:namespace/><%=form.getId()%>();
					}catch(e){}
					
					if(callDefaultSubmit){
						submit<portlet:namespace/><%=form.getId()%>();
					}

					//return false;
				}
			});
		}catch(e){}

		try{
			$("#<portlet:namespace/><%=form.getId()%>save").click(function(event) {
				validate();
				//alert("<portlet:namespace/><%=form.getId()%>save clicked ");
				if(!viewOnlyMode){
					
					var callDefaultSubmit=true;
					try{
						callDefaultSubmit=beforeSubmit<portlet:namespace/><%=form.getId()%>();
					}catch(e){}
					
					if(callDefaultSubmit){
						submit<portlet:namespace/><%=form.getId()%>();
					}


				}else{
					window.location.href='<%=formListRenderURL.toString()%>';
				}
			});
		}catch(e){}
		
		<%-- For Closing Dialog --%>
		try{
			$("#<portlet:namespace/><%=form.getId()%>cancel").click(function(event) {
				//alert("<portlet:namespace/><%=form.getId()%>cancel clicked ");
				if(!viewOnlyMode){
					<portlet:namespace/><%=form.getId()%>OnCancelClick();
				}else{
					window.location.href='<%=formListRenderURL.toString()%>';
				}
			});
		}catch(e){}
		
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
		        console.log(result);
		        reloadListOptions(selectElement,result,'key', 'value', '', selectedValue);
		    }
		);
	});

	Liferay.provide(window,'renderFormList', function(){
		location.href='<%=formListRenderURL%>';
	});

	Liferay.provide(window,'initSelect2', function(){
 		
 		//This is for enabling select2 plugin for select/dropdown controls
		$( "select" ).each(function( index, item ) {
			var selectedVal=$(item).val();
			//console.log($(item).attr('name')+' :: '+ $(item).val());
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
	
	
	Liferay.provide(window,'uploadCallBack', function(documentElement, response){
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

Liferay.provide(window,'submit<portlet:namespace/><%=form.getId()%>', function(){
	if(!validate()){
		return;
	}
	
	var formDataJson = $('#<portlet:namespace/><%=form.getId()%>').serializeFormJSON();
	console.log(formDataJson);
	formDataJson['namespace']='<portlet:namespace/>';
	formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass()%>';
	//console.log("formDataJson");
	//console.log(formDataJson);
	submitFormDataJson(formDataJson, <portlet:namespace/><%=form.getId()%>OnSaveSuccess, <portlet:namespace/><%=form.getId()%>OnSaveFailure);
});

Liferay.provide(window,'submitFormDataJson', function(formDataJson, onSuccess, onFailure){
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
});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>OnSaveSuccess', function(obj){
	console.log("Successful with <%=form.getKeyElement().getName()%>");
	console.log(obj);

	var data={};
	try{
		data=$.parseJSON(obj);
	}catch(e){
		console.log(e);
	}
	
	if(listElementCount>0){
		if(obj){
			//alert('<%=form.getKeyElement().getName()%>');
			//alert(data["<%=form.getKeyElement().getName()%>"]);
			$(".form-key-<%=form.getKeyElement().getName()%>").val(data["<%=form.getKeyElement().getName()%>"]);
			console.log(data.message);
		}
		return false;
	}

	if(!dialogMode){
		window.location.href="<%=formListRenderURL.toString()%>";
		return;
	}

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

	<portlet:namespace/><%=form.getId()%>callCloseDialog(data);

});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>OnCancelClick', function(){

	if(!dialogMode){
		window.location.href="<%=formListRenderURL.toString()%>";
		return;
	}
	
	var data = {
		"refresh":false,
		"message" : '',
		"error" :  false,
	};
	
	<portlet:namespace/><%=form.getId()%>callCloseDialog(data);

});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>OnSaveFailure', function(obj){
	if(!dialogMode){
		window.location.href="<%=formListRenderURL.toString()%>";
		return;
	}
	var data = {
		"error":true,
		"refresh":false,
		"message":"Data saving failed."
	};
	<portlet:namespace/><%=form.getId()%>callCloseDialog(data);

});

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%>callCloseDialog', function(data){
	data.dialogId=dialogId;
	Liferay.Util.getOpener().<%=closeFunc%>(data);
});

Liferay.provide(window,'validate', function(){
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
});

Liferay.provide(window,"LiferayUtilOpenWindow", function(id, title, uri, centered, height, modal, width){
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

//This is written by arjun
Liferay.provide(window,'yearDiff', function(dateFrom, dateTo) {
 	return dateTo.getFullYear() - dateFrom.getFullYear();
});

Liferay.provide(window,'monthDiff', function(dateFrom, dateTo) {
 	return dateTo.getMonth() - dateFrom.getMonth() + 
   	(12 * (dateTo.getFullYear() - dateFrom.getFullYear()))
});

Liferay.provide(window,'dayDiff', function(dateFrom, dateTo) {
	var diff = dateTo.getTime() - dateFrom.getTime();   
	var daydiff = diff / (1000 * 60 * 60 * 24); 
	return daydiff;
});

</aui:script>

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