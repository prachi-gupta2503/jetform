<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="org.apache.commons.collections.MapUtils"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletResponseUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp"%>
<link href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/select.dataTables.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.select.min.js"></script>
<style>
.deleted-row {
  font-style: italic !important;
}
.delete.active{
	color:red;
}
.delete.inactive, .edit.inactive{
	color:#a5a5a5;
}
.row-action.inactive{
	color:#a5a5a5 !important;
}
/*#a7a2a2;*/
.edit.active{
	color:blue;
}

.fas.inactive{
color:#fff;
}
</style>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_002dlist_restful_jsp");

private static final String TOP_HEADER_TEMPLTATE="top.header.template";
private static final String TOP_HEADER_TEMPLTATE_VALUE="/components/list/list-header.jsp";
private static final String TOP_ACTION_TEMPLTATE="top.action.template";
private static final String TOP_ACTION_TEMPLTATE_VALUE="/components/list/list-top-actions.jsp";
private static final String ROW_ACTION_TEMPLTATE="row.action.template";
private static final String ROW_ACTION_TEMPLTATE_VALUE="/components/list/list-row-actions.jsp";
private static final String ACTION_REDIRECT_URL="action.redirect.url";
private static final String ACTION_REDIRECT_URL_VALUE="/components/list/form-list-restful.jsp";
%>

<%
String formClass = null;
HtmlFormWrapper form = null;
List<HtmlFormActionWrapper> bulkActions=new ArrayList<HtmlFormActionWrapper>();
List<HtmlFormActionWrapper> rowActions=new ArrayList<HtmlFormActionWrapper>();
Map<String, String> actionsParamMap=new HashMap<String, String>();
Map<String, String> searchFilters=new HashMap<String, String>();

String[] formClasses=ParamUtil.getStringValues(request, "formClass");
if(formClasses!=null && formClasses.length>0){
	formClass=formClasses[formClasses.length-1];
}else{
	formClass=ParamUtil.getString(request, "formClass");
}

boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
String selectedValueField = ParamUtil.getString(request, "selectedValueField");
String selectable = ParamUtil.getString(request, "selectable");
String dataPreload = ParamUtil.getString(request, "dataPreload", "true");
String lastSaveSuccess = StringUtils.trim(ParamUtil.getString(request, "success",""));

String topHeaderTemplate = ParamUtil.getString(request, TOP_HEADER_TEMPLTATE, TOP_HEADER_TEMPLTATE_VALUE);
String topActionTemplate = ParamUtil.getString(request, TOP_ACTION_TEMPLTATE, TOP_ACTION_TEMPLTATE_VALUE);
String rowHeaderTemplate = ParamUtil.getString(request, ROW_ACTION_TEMPLTATE, ROW_ACTION_TEMPLTATE_VALUE);
String redirectionUrl = ParamUtil.getString(request, ACTION_REDIRECT_URL, ACTION_REDIRECT_URL_VALUE);

boolean isSelectable = false;

Enumeration<String> paramNames = request.getParameterNames();
String namespace=renderResponse.getNamespace();
String formActionPrefix=namespace+"formAction";
while(paramNames.hasMoreElements()){
	String paramName=(String)paramNames.nextElement();
	String paramValue=ParamUtil.getString(request, paramName);
	if(paramName.startsWith("formAction")){
		if(paramValue!=null ){
			String actionName=paramName.substring("formAction".length());
			actionsParamMap.put(actionName.toLowerCase(), paramValue);
		}
	}else if(paramName.startsWith("searchFilter[")){
		if(paramValue!=null ){
			String filterName=paramName.substring("searchFilter[".length(), paramName.length()-1);
			searchFilters.put(filterName, paramValue);
		}
	}
}

if(StringUtils.isNotEmpty(formClass)){
	form = JetFormBuilderLocalServiceUtil.getHtmlFormByClass(ClassUtils.getClass(formClass));
	request.setAttribute("form", form); 
}

%>

<%
if(form==null){
%>
	<strong>Error:</strong> Form not initialized due to formClass is "<%=formClass%>" and Form definition is "<%=form==null?"null":form.getTitle() %>".
<%
}else{
	
	String formTitle=AnnotationUtil.getItemLabel(form.getTitle());
	isSelectable=form.isSelectable();

	if(selectable!=null && (selectable.trim().equalsIgnoreCase("true") || selectable.trim().equalsIgnoreCase("false"))){
		isSelectable=Boolean.parseBoolean(selectable);
	}

	List<HtmlElementWrapper> elements=new ArrayList<HtmlElementWrapper>();
	elements.addAll(form.getElements());
	for(HtmlElementGroupWrapper group:form.getElementGroups()){
		elements.addAll(group.getElements());
	}
	
	if(form.isAdvanceFilter()){
		
	}

%>
<%@ include file="/components/list/list-action-urls.jsp" %>

<liferay-util:include page="<%=topHeaderTemplate%>" servletContext="<%=application%>">
</liferay-util:include>	


<div class="row">
	<div class="col-md-12">
		<div class="alert alert-success" id="<%=form.getId() %>alertSuccess" style="display:none;" role="alert">
		  <strong>Success!</strong> Data updated successfully.
		</div>
		<div class="alert alert-danger" id="<%=form.getId() %>alertError" style="display:none;" role="alert">
		  <strong>Failure!</strong> Data updation failed.
		</div>
	</div>
</div>

<div class="row">
	<div id="<portlet:namespace/><%=form.getId()%>dataTableContainer" class="col-md-12">
		<div class="card">
			<div class="card-body" style="overflow:auto; padding: 0 0 0 0 !important;">
				<table id="<portlet:namespace/><%=form.getId()%>dataTable" class="stripe mb-5 pt-2" style="width: 96% !important;">
				</table>
				<input type="hidden" id="<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys" value="">
			</div>
		</div>
	</div>
<%--
if(form.isAdvanceFilter()){
%>		
	<div id="<portlet:namespace/>advSearch_Container" class="col-md-3 d-none">
			<%@ include file="/components/form/form-search.jsp"%>
	</div>
<%
}
--%>			
	</div>
<aui:script>
var keyElementName='<%=form.getKeyElement().getName()%>';
var <%=form.getId()%>dataTableFilterUpdated=false;
var <%=form.getId()%>dataTableFilters={};
var <%=form.getId()%>dataTableFilterSearchValue='';
var <%=form.getId()%>deletedColumn=-1;
var <%=form.getId()%>columns=[];
var <%=form.getId()%>headers=[];
var <%=form.getId()%>dataPreload=<%=(dataPreload==null ||  dataPreload.equalsIgnoreCase("true") || dataPreload.equalsIgnoreCase("yes"))%>;
var ih=0;

<%=form.getId()%>initFilters();
<%=form.getId()%>initColumns();
<%=form.getId()%>initHeaders();

function <%=form.getId()%>initFilters(){
	<%=form.getId()%>dataTableFilters={
		"objectClass" : "<%=formClass%>",
<%
	if(MapUtils.isNotEmpty(searchFilters)){
		for(Map.Entry<String, String> entry:searchFilters.entrySet()){
%>
			"<%=entry.getKey() %>" : "<%=entry.getValue()%>",
<%
		}
	}
	
	if(MapUtils.isNotEmpty(form.getFilter())){
		for(Map.Entry<String, String> entry:form.getFilter().entrySet()){
%>
		"<%=entry.getKey() %>":"<%=entry.getValue()%>",
<%
		}
	}
%>
	};
}

$(document).ready(function() {
	try{
		<%=form.getId()%>beforeDocumentOnReady();
	}catch(e){}
<%
	if(StringUtils.equalsIgnoreCase(lastSaveSuccess,"true")){
%>
		$('#<%=form.getId()%>alertSuccess').html('Data saved successfully.');
		<%=form.getId()%>ShowSuccessAlert();
<%
	}else if(StringUtils.equalsIgnoreCase(lastSaveSuccess,"false")){
%>
		$('#<%=form.getId()%>alertError').html('Data saving failed.');
		<%=form.getId()%>ShowErrorAlert();
<%
	}
%>
	var processInitTable=true;
	try{
		processInitTable=<%=form.getId()%>beforeInitTable();
	}catch(e){}
	
	if(processInitTable){
		<%=form.getId()%>initTable();
	}
	if(processInitTable){
		try{
			<%=form.getId()%>afterInitTable();
		}catch(e){}
	}
	
	var processInitAddAction=true;
	try{
		processInitAddAction=<%=form.getId()%>beforeInitAddAction();
	}catch(e){}
	
	if(processInitAddAction){
		<%=form.getId()%>initAddAction();
	}
	
	if(processInitAddAction){
		try{
			<%=form.getId()%>afterInitAddAction();
		}catch(e){}
	}
	
	try{
		<%=form.getId()%>afterDocumentOnReady();
	}catch(e){}
});

function <%=form.getId()%>initTable(){
	//console.log("<%=form.getId()%>initTable()");
	//console.log(<%=form.getId()%>dataTableFilters);
	$.fn.dataTable.ext.errMode = 'none';
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/read-objects-as-json',
			{ 
				"searchFilter":<%=form.getId()%>dataTableFilters
			}
<%-- 		{
				"objectClass" : "<%=formClass%>"
			}
--%>			
			,
			function(response) {
				console.log("service response ================");
			    console.log(response);
			    var data=[];
			    
			    $(response).each(function(idx1, object){
		    		var dataRow=[];
			    	dataRow[0]=''; //Blank for index column
			    	$(<%=form.getId()%>columns).each(function(idx2, column){
			    		if (typeof object[column["name"]] === "undefined" || object[column["name"]]=="null") {
				    		dataRow[idx2+1]="";
				    	}else{
				    		dataRow[idx2+1]=object[column["name"]];
				    	}
			    	});
			    	
			    	data[idx1]=dataRow;
			    });
			    
<%--
	if(rowActions.size()>0){
%>	
		<%=form.getId()%>headers[<%=form.getId()%>headers.length]={ title: 'Actions'};
		//alert("<%=form.getId()%>headers.length : "+<%=form.getId()%>headers.length);
<%
	}
--%>			    
				/*
				console.log("<%=form.getId()%>headers");
				console.log(<%=form.getId()%>headers);
			    console.log("<%=form.getId()%>data");
			    console.log("table data");
			    console.log(data);
			    */
//===================================			    
			    var table= $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable({
			    	"dom": '<<"dataTables_length_filter"lf><t><"dataTables_info_paginate"ip>>',
			    	responsive: true,
					data: data,
			        columns: <%=form.getId()%>headers,
			        'columnDefs': [
				{
			         'targets': 1,
			         'searchable': false,
			         'orderable': false,
			         'className': 'dt-body-center'
<%
	if(!isSelectable){
%>	
					,'visible': false
<%
	}else{
%>							         
					,'render': function (data, type, full, meta){
			             return '<input type="checkbox" name="id[]" value="' + $('<div/>').text(data).html() + '" onchange="<portlet:namespace/><%=form.getId()%>dataTable_UpdateSelected(this)">';
			         }
<%
	}		        
%>			         
			      },			        
<%
	int hiddenIndex=0;
	for(HtmlElementWrapper ele:form.getElements()){
		if(!ele.isKey() && ele.getControlType().equalsIgnoreCase(HtmlElement.ControlType.hidden.name())){
%>
			{
			
			         'targets': <%=hiddenIndex+1 %>,
			         'visible': false
			},
<%	
		}
		hiddenIndex++;
	}

	if(rowActions.size()>0){
		String itemIdName="item."+form.getKeyElement().getName();
		String activeActionStr="";
		String inactiveActionStr="";	
		if(!form.getId().equalsIgnoreCase("CountryForm_123456")){
		for(HtmlFormActionWrapper action:rowActions){
			String actionItemName=renderResponse.getNamespace()+form.getId()+action.getName();
			String activeActionClass="row-action row-action-"+action.getName()+" active";
			//String inactiveActionClass="row-action row-action-"+action.getName()+"-inactive inactive";
			String inactiveActionClass="row-action inactive";
			activeActionStr+="<a data-key=\"'+full[1]+'\" name=\""+actionItemName+"\" class=\""+activeActionClass+" mr-1\">"+action.getLabel()+"</a>";
			inactiveActionStr+="<span class=\""+inactiveActionClass+" mr-1\">"+action.getLabel()+"</span>";

/*			actionStr+="<a data-key=\"'+$('<div/>').text(data).html()+'\" name=\""+actionItemName+"\" class=\"row-action row-action-"+action.getName()+"\">"+action.getLabel()+"</a>";
*/		
		}
%>	
				{
			         'targets': <%=form.getId()%>headers.length-1,
			         'searchable': false,
			         'orderable': false,
			         'className': 'dt-body-center',
					 'render': function (data, type, full, meta){
					 	//console.log("Deleted column : "+<%=form.getId()%>deletedColumn)
					 	
					 	if(<%=form.getId()%>deletedColumn==-1 || full[<%=form.getId()%>deletedColumn]!="Yes"){
			         		return '<%=activeActionStr%>';
			         	}else{
			         		var rowIndex = meta.row+1;
            				$('#<portlet:namespace/><%=form.getId()%>dataTable tbody tr:nth-child('+rowIndex+')').addClass('deleted-row');
			         		return '<%=inactiveActionStr %>';
			         	}
			         }
			     }
<%
	}
	}
%>
					],
					"initComplete": function(settings, json) {
					    //alert( 'initComplete - DataTables has finished its initialisation.' );
					    <%=form.getId()%>initRowActions();
					 },
					 "drawCallback": function( settings ) {
				        //alert( 'drawCallback DataTables has redrawn the table' );
				        
				    }
				});
//===========================================				
				table.on( 'order.dt search.dt', function () {
			        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			            cell.innerHTML = i+1;
			        } );
			    } ).draw();
<%--			    
			    table.on('page.dt', function () {
					<%=form.getId()%>initRowActions();
				} );
--%>				
			    
			}
		);
	});
}

function <%=form.getId()%>updateTable(){
	//alert("<%=form.getId()%>updateTable called");
	if ($.fn.dataTable.isDataTable('#<portlet:namespace/><%=form.getId()%>dataTable')) {
        $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable().clear().destroy();
    }
    
    <%=form.getId()%>initTable();
}
            
function <portlet:namespace/><%=form.getId()%>dataTable_UpdateSelected(checkbox){
	//alert(checkbox.checked +" -- "+checkbox.value);
	var selectedKeysElements=$("#<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys");
	var selectedKeys=$(selectedKeysElements).attr("value");
	//alert(selectedKeys);
	if(checkbox.checked){
		selectedKeys+=checkbox.value+",";
	}else{
		selectedKeys=selectedKeys.replace(checkbox.value+",", "");
	}
	
	//alert("after replace : "+selectedKeys);
	$(selectedKeysElements).attr("value", selectedKeys);
	//alert("$(selectedKeysElements).attr(value) : "+$(selectedKeysElements).attr("value"));
	try{
		$("#<portlet:namespace/><%=selectedValueField%>").attr("value", $(selectedKeysElements).attr("value"));
	}catch(e){
		console.log(e);
	}
}

function <portlet:namespace/><%=form.getId()%>dataTable_GetSelected(){
	var selectedKeysElements=$("#<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys");
	var selectedKeys=$(selectedKeysElements).attr("value");
	return selectedKeys.split(",");
}

function reloadListOptions(element, list, value, label, placeHolder){
	$(element).empty();
	if(placeHolder!=null && placeHolder!=''){
		$(element).append($('<option>', {value : '0'}).text(placeHolder));
	}
	$.each(list, function(i, e){
		$(element).append($('<option>', {value : e[value]}).text(e[label]));
	});		
}

function <%=form.getId()%>initColumns(){
	<%
	for(HtmlElementWrapper element:form.getElements()){
		
		if(!element.isListable()){
			continue;
		}
	%>
		<%=form.getId()%>columns[ih++]={name:"<%=element.getAttribute()%>", label:"<%=element.getLabel() %>", key:<%=element.isKey()%>, hidden:<%=element.isControlType(HtmlElement.ControlType.hidden)%>};
	<%
	}
	if(CollectionUtils.isNotEmpty(form.getElementGroups())){
		for(HtmlElementGroupWrapper group:form.getElementGroups()){
			if(CollectionUtils.isNotEmpty(group.getElements())){
				for(HtmlElementWrapper element:group.getElements()){
					
					if(!element.isListable()){
						continue;
					}
	%>
			<%=form.getId()%>columns[ih++]={name:"<%=element.getAttribute()%>", label:"<%=element.getLabel() %>", key:<%=element.isKey()%>, hidden:<%=element.isControlType(HtmlElement.ControlType.hidden)%>};
	<%
				}
			}
		}
	}
	%>
}
	
function <%=form.getId()%>initHeaders(){
	<%=form.getId()%>headers[0]={"title": "#"};  //Blank for index column
	
	<%=form.getId()%>headers[1]={"title": keyElementName};
<%	
	if(isSelectable){
%>	
		var titleValue="<input type='checkbox' disabled>";
		<%=form.getId()%>headers[1]={"title": titleValue};
<%		
	}
%>	
	var colCtr=2;		
	$(<%=form.getId()%>columns).each(function(index, column){
		if(!column.key){
			<%=form.getId()%>headers[colCtr]={"title": column.label};
			//console.log("checking for Deleted column : "+column.label+", colCtr :"+colCtr );
			//To find the column index of "Deleted"
			if(column.label=="Deleted"){
				<%=form.getId()%>deletedColumn=colCtr;
			}
			colCtr++;
		}
	});
	
	<%
	if(rowActions.size()>0 ){
		if(!form.getId().equalsIgnoreCase("CountryForm_123456")){
	
	%>	
		<%=form.getId()%>headers[<%=form.getId()%>headers.length]={ title: 'Actions'};
		//alert("<%=form.getId()%>headers.length : "+<%=form.getId()%>headers.length);
	<%
	}
	}
	%>	
}

function <%=form.getId()%>initAddAction(){
	try{
		$('#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>').click(function(){
			console.log("#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%> clicked###");
			var callDefaultOnClick=true;
			try{
				callDefaultOnClick=<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>BeforeOnClick($(this));
			}catch(e){
				callDefaultOnClick=true;
			}
			if(callDefaultOnClick){
				<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>HandleOnClick($(this));
			}
			try{
				<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>AfterOnClick(actionSource);
			}catch(e){
				//Nothing to do
			}
		});
	}catch(e){}
}

function <%=form.getId()%>initRowActions(){
	var processInitRowActions=true;
	try{
		processInitRowActions=<%=form.getId()%>beforeInitRowActions();
	}catch(e){}
	
	if(processInitRowActions){
<%
		for(HtmlFormActionWrapper action: rowActions){
%>
			$("#<portlet:namespace/><%=form.getId()%>dataTable").on("click",".row-action-<%=action.getName()%>.active",function(e){
			//alert("clicked");
			<%--$("[name='<portlet:namespace/><%=form.getId()%><%=action.getName()%>']").each(function(index, action){
				//alert('<%=action.getName()%> : '+index);
				$(action).click(function(){
					//alert(action); --%>
				//$(".row-action-<%=action.getName()%>-active").click(function(){
				//alert("clicked");
					<portlet:namespace/><%=form.getId()%><%=action.getName()%>onClick($(this));
				//});
			});
<%
		}
%>
	}
	try{
		<%=form.getId()%>afterInitRowActions();
	}catch(e){}
	
}
<%
	for(HtmlFormActionWrapper action: rowActions){
%>
function <portlet:namespace/><%=form.getId()%><%=action.getName()%>onClick(actionSource){
		
		//alert($(actionSource).attr("data-key"));
		var callDefaultOnClick=true;
		try{
			callDefaultOnClick=<portlet:namespace/><%=form.getId()%><%=action.getName()%>BeforeOnClick(actionSource);
		}catch(e){
			//alert(e)
			callDefaultOnClick=true;
		}
		if(callDefaultOnClick){
			<portlet:namespace/><%=form.getId()%><%=action.getName()%>HandleOnClick(actionSource);
		}
		try{
			<portlet:namespace/><%=form.getId()%><%=action.getName()%>AfterOnClick(actionSource);
		}catch(e){
			//Nothing to do
		}	
	}
<%
	}
%>

function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>HandleOnClick(actionSource){
	var url= '<%=addRenderURL.toString() %>';

<%
	if(!dialogMode){
%>			
		window.location=url;
<%
	}else{
%>	
		var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog';
		var title ='<%="Add " + formTitle %>';
		var width = <%=form.getElementsPerRow()>1?1020:640%>;
		var height = <%=form.getElements().size()/form.getElementsPerRow() * 84 + 100%>;
		LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
<%
	}
%>	
}
function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>HandleOnClick(actionSource){
	var url= '<%=editRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
<%
	if(!dialogMode){
%>			
		window.location=url;
<%
	}else{
%>		
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog';
	var title ='<%="Edit " + formTitle %>';
	var width = <%=form.getElementsPerRow()>1?1020:640%>;
	var height = <%=form.getElements().size()/form.getElementsPerRow() * 84 + 100%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
<%
	}
%>
}

function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>HandleOnClick(actionSource){
	var url= '<%=deleteRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key")+'&<portlet:namespace/>formId=<%=form.getId()%>';
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_DELETE%>openDialog';
	var title ='<%="Delete " + formTitle %>';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 240, true, width);
}

function LiferayUtilOpenWindow(id, title, uri, centered, height, modal, width){
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
}

function <%=form.getId()%>ShowSuccessAlert(){
	$('#<%=form.getId()%>alertSuccess').show();
	$('#<%=form.getId()%>alertSuccess').delay( 800 ).fadeOut( 400 );
	//$( "#foo" ).slideUp( 300 ).delay( 800 ).fadeIn( 400 );
}

function <%=form.getId()%>ShowErrorAlert(){
	$('#<%=form.getId()%>alertError').show();
	$('#<%=form.getId()%>alertError').delay( 800 ).fadeOut( 400 );
}

<%--
function <%=form.getId()%>beforeInitRowActions(){
	var editLink=$("a[name='<portlet:namespace/><%=form.getId()%>edit']");
	//editLink.removeClass("active");
	editLink.children("i").addClass("inactive");
	
	var deleteLink=$("a[name='<portlet:namespace/><%=form.getId()%>delete']");
	//deleteLink.removeClass("active");
	deleteLink.children("i").addClass("inactive");
	
	var approveLink=$("a[name='<portlet:namespace/><%=form.getId()%>approve']");
	//approveLink.removeClass("active");
	approveLink.children("i").addClass("inactive");
	
	return false;
}
--%>
</aui:script>
<%
	}
%>

<aui:script use="liferay-util-window">
<%
if(dialogMode){
%>
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>closeDialog',
		function(data) {
			//alert("after close : "+data);
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog');
			dialog.destroy();
			//alert("before updateTable()");
			
			
			if(!(typeof data.error === "undefined")){
				<%=form.getId()%>ShowErrorAlert();
			}else if(typeof data.refresh === "undefined"){
				<%=form.getId()%>ShowSuccessAlert();
				<%=form.getId()%>updateTable();
			}
		},
		['liferay-util-window']
	);
<%
}
%>		
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>closeDialog',
		function(data) {
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>openDialog');
			dialog.destroy();
			
			if(data.status){
				$('#<%=form.getId()%>alertSuccess').html(data.message);
				<%=form.getId()%>ShowSuccessAlert();
			}else{
				$('#<%=form.getId()%>alertError').html(data.message);
				<%=form.getId()%>ShowErrorAlert();
			}
			<%=form.getId()%>updateTable();
		},
		['liferay-util-window']
	);	
</aui:script>

