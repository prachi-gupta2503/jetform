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

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_002dlist_restful_jsp");
%>

<%
String formClass = null;
String[] formClasses=ParamUtil.getStringValues(request, "formClass");
if(formClasses!=null && formClasses.length>0){
	formClass=formClasses[formClasses.length-1];
	LOGGER.info("formClass from array  ######## "+formClass);
}else{
	formClass=ParamUtil.getString(request, "formClass");
	LOGGER.info("formClass from param  ######## "+formClass);
}

boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
String formId = ParamUtil.getString(request, "formId");
String selectedValueField = ParamUtil.getString(request, "selectedValueField");
String selectable = ParamUtil.getString(request, "selectable");
String dataPreload = ParamUtil.getString(request, "dataPreload", "true");
String quickMenuPath=ParamUtil.getString(request, "quickMenu");

boolean isSelectable = false;
//LOGGER.info("formClass : "+formClass);

Map<String, String> actionsParamMap=new HashMap<String, String>();
Map<String, String> searchFilters=new HashMap<String, String>();

Enumeration paramNames = request.getParameterNames();
String namespace=renderResponse.getNamespace();
String formActionPrefix=namespace+"formAction";
//LOGGER.info("formActionPrefix : "+ formActionPrefix);
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
//LOGGER.info("actions.size : "+actionsParamMap.size());
%>

<portlet:renderURL var="addRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="editRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="deleteRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-delete.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="viewRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-view.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:resourceURL var="listRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-list.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:resourceURL>

<portlet:resourceURL var="searchRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-search.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:resourceURL>

<portlet:renderURL var="printRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-print.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="importRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="exportRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-export.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<%
if(dialogMode){
%>
	<portlet:renderURL var="addRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="dialogMode" value="true" />
	</portlet:renderURL>
	<portlet:renderURL var="editRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="dialogMode" value="true" />
	</portlet:renderURL>
	<portlet:renderURL var="deleteRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-delete.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="dialogMode" value="true" />
	</portlet:renderURL>
<%
}

//LOGGER.info("formClass: "+formClass);

//formClass = "com.adjecti.eprocess.core.service.model.Category";
HtmlFormWrapper form = null;//(HtmlFormWrapper)request.getAttribute(formId);
if(StringUtils.isNotEmpty(formClass)){
	form =(HtmlFormWrapper)request.getAttribute("form-"+formClass);
	if(form==null){
		JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
		form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
	}
	//request.setAttribute(formId, form);
}else{
	 form = (HtmlFormWrapper)request.getAttribute(formId);
}

if(form==null){
%>
	<b>Error:</b> Form not initialized due to formClass is "<%=formClass%>" and Form definition is "<%=form==null?"null":form.getTitle() %>".
<%
}else{
	
	String formTitle=AnnotationUtil.getItemLabel(form.getTitle());
	isSelectable=form.isSelectable();

	if(selectable!=null && (selectable.trim().equalsIgnoreCase("true") || selectable.trim().equalsIgnoreCase("false"))){
		isSelectable=Boolean.parseBoolean(selectable);
	}

	////LOGGER.info("==================================================="+list);
	
	List<HtmlElementWrapper> elements=new ArrayList<HtmlElementWrapper>();
	elements.addAll(form.getElements());
	for(HtmlElementGroupWrapper group:form.getElementGroups()){
		elements.addAll(group.getElements());
	}
		
	boolean addAction=false;
	List<HtmlFormActionWrapper> bulkActions=new ArrayList<HtmlFormActionWrapper>();
	List<HtmlFormActionWrapper> rowActions=new ArrayList<HtmlFormActionWrapper>();
	for(HtmlFormActionWrapper act:form.getActions()){
		if(act.getLabel().equalsIgnoreCase("default")){
			act.setLabel(StringUtils.capitalize(act.getName()));
		}
		if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_ADD)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(addRenderURL.toString());
			}
			bulkActions.add(act);
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_EDIT)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(editRenderURL.toString());
			}
			act.setLabel("<i class=\"fas fa-edit\"></i>");
			rowActions.add(act);
			//act.setName("<i class='fa fa-pencil-square-o mr-2' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_DELETE)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(deleteRenderURL.toString());
			}
			act.setLabel("<i class=\"fas fa-trash-alt\"></i>");
			rowActions.add(act);
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_VIEW)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(viewRenderURL.toString());
			}
			act.setLabel("<i class=\"fas fa-eye\"></i>");
			rowActions.add(act);
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_SEARCH)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(searchRenderURL.toString());
			}
			bulkActions.add(act);
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_PRINT)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(printRenderURL.toString());
			}
			bulkActions.add(act);
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_IMPORT)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(importRenderURL.toString());
			}
			bulkActions.add(act);
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_EXPORT)){
			if(act.getAction().equalsIgnoreCase("default")){
				act.setAction(exportRenderURL.toString());
			}
			bulkActions.add(act);
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}
	}
	

%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<div class="page-header">
		    <div class="row align-items-center">
		        <div class="col">
		            <h3 class="page-title"><%=formTitle%></h3>
		            <ul class="breadcrumb">
		                <li class="breadcrumb-item"><a href="index.html">Master Data</a></li>
		                <li class="breadcrumb-item active"><%=formTitle%></li>
		            </ul>
		        </div>
		        <div class="col-auto float-right ml-auto">
<%
	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}
	
	//HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	//if(addActionObj!=null){
		//addAction=true;
%>
		<a class="btn btn-primary" title="<%=StringUtils.capitalize(action.getName())%>"
					id="<portlet:namespace/><%=form.getId()%><%=action.getName()%>"><i class="fa fa-plus mr-2" aria-hidden="true"></i>Add <%=formTitle%></a>
		<%--<a title="<%=StringUtils.capitalize(action.getName())%>" class="float-right text-white fs-5" id="<portlet:namespace/><%=form.getId()%><%=action.getName()%>"><i class="fa fa-plus mr-1" aria-hidden="true"></i>Add <%=formTitle%></a> --%>
<%			
	}
%>			        
<%--		            <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_employee"><i class="fa fa-plus"></i> Add Employee</a>
		            <div class="view-icons">
		                <a href="employees.html" class="grid-view btn btn-link active"><i class="fa fa-th"></i></a>
		                <a href="employees-list.html" class="list-view btn btn-link"><i class="fa fa-bars"></i></a>
		            </div> --%>
		        </div>
		    </div>
		</div>


<%--	<div class="card bg-primary text-white mt-2">
		<div class="card-header">
			<div class="row">
				<div class="col-md-8">
					<h5><%=formTitle%></h5>
				</div>
				<div class="col-md-4">
<%
	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}
	
	//HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	//if(addActionObj!=null){
		//addAction=true;
%>
		<a style="float: right;" class="text-white fs-5" title="<%=StringUtils.capitalize(action.getName())%>"
					id="<portlet:namespace/><%=form.getId()%><%=action.getName()%>"><i class="fa fa-plus mr-2" aria-hidden="true"></i>Add <%=formTitle%></a>
		<%--<a title="<%=StringUtils.capitalize(action.getName())%>" class="float-right text-white fs-5" id="<portlet:namespace/><%=form.getId()%><%=action.getName()%>"><i class="fa fa-plus mr-1" aria-hidden="true"></i>Add <%=formTitle%></a> --%>
<%--			
	}
%>			
				</div>
			</div>
		</div>
	</div> --%>
	
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-success" id="<%=form.getId() %>alertSuccess" style="display:none;" role="alert">
			  <strong>Success!</strong> Data updated successfully.
			</div>
			<div class="alert alert-danger" id="<%=form.getId() %>alertError" style="display:none;" role="alert">
			  <strong>Failure!</strong> Data saving failed.
			</div>
		</div>
	</div>
<%--
	if(formFlow){
%>	
	<div class="row">
		<div class="col-md-12">
<%
	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}
	
		if(!dialogMode){
%>
		<a href="<%=action.getAction()%>" title="<%=StringUtils.capitalise(action.getName())%>" class="btn btn-primary mb-2 float-right" style="padding-right:50px !important;" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-1" style="background-color:#0b5fff; color:#fff;" aria-hidden="true"></i>Add</a>
<%	
		}else{
%>
		<a title="<%=StringUtils.capitalise(action.getName())%>" class="btn btn-primary mb-2 float-right" style="padding-right:50px !important;" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-1" style="background-color:#0b5fff; color:#fff;" aria-hidden="true"></i>Add</a>
<%			
		}
	}
%>			
		</div>
	</div>
<%
	}
--%>	
	<div class="row">
		<div id="<portlet:namespace/><%=form.getId()%>dataTableContainer" class="col-md-12">
			<div class="card">
				<div class="card-body">
					<table id="<portlet:namespace/><%=form.getId()%>dataTable" class="stripe mb-5 pt-2">
					</table>
				</div>
			</div>
		</div>
<%
	if(form.isAdvanceFilter()){
%>		
		<div id="<portlet:namespace/>advSearch_Container" class="col-md-3 d-none">
			<%@ include file="/components/form/form-search.jsp"%>
		</div>
<%
	}
%>		
	</div>

<input type="hidden" id="<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys" value="">
</div>
</div>
<aui:script>
var keyElementName='<%=form.getKeyElement().getName()%>';
var <%=form.getId()%>dataTableFilterUpdated=false;
var <%=form.getId()%>dataTableFilters={};
var <%=form.getId()%>dataTableFilterSearchValue='';
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
	for(Map.Entry<String, String> entry:searchFilters.entrySet()){
%>
		//"<%=entry.getKey() %>" : "<%=entry.getValue()%>",
		"searchField" : "<%=entry.getKey() %>",
		"searchValue" : "<%=entry.getValue()%>"
<%
	}
%>
		
	};
}

$(document).ready(function() {

//alert("$(document).ready(function() called..");
	<%=form.getId()%>initTable();
	<%=form.getId()%>initAddAction();
});
function <%=form.getId()%>initTable(){
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/read-objects-as-json', <%=form.getId()%>dataTableFilters
<%-- 		{
				"objectClass" : "<%=formClass%>"
			}
--%>			
			,
			function(response) {
				console.log("service response ================");
			    console.log(response);
			    
			    console.log("columns  ================");
			    console.log(<%=form.getId()%>columns);
			    
			    var data=[];
			    
			    $(response).each(function(idx1, object){
			    	var dataRow=[];
			    	dataRow[0]=''; //Blank for index column
			    	dataRow[1]=object[keyElementName];
			    	var colCtr=2;
			    	
			    	$(<%=form.getId()%>columns).each(function(idx2, column){
			    		console.log('object[column["name"]] : '+column["name"]+" : "+object[column["name"]]);
			    		if(column["name"]!=keyElementName){
			    			console.log('gone inside');
				    		if (typeof object[column["name"]] === "undefined") {
					    		dataRow[colCtr]="";
					    	}else{
					    		dataRow[colCtr]=object[column["name"]];
					    	}
					    	colCtr++;
				    	}
			    	});
			    	
			    	dataRow[dataRow.length]=dataRow[1];
			    	console.log("dataRow : "+idx1+"===============");
			    	console.log(dataRow);
		    	
			    	data[idx1]=dataRow;
			    });
			    
<%
	if(rowActions.size()>0){
%>	
		<%=form.getId()%>headers[<%=form.getId()%>headers.length]={ title: 'Actions'};
		//alert("<%=form.getId()%>headers.length : "+<%=form.getId()%>headers.length);
<%
	}
%>			    
				console.log("<%=form.getId()%>headers");
				console.log(<%=form.getId()%>headers);
			    //console.log(<%=form.getId()%>headers);
			    //console.log("<%=form.getId()%>data");
			    console.log("table data");
			    console.log(data);
//===================================			    
			    var table= $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable({
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
	if(rowActions.size()>0){
		String itemIdName="item."+form.getKeyElement().getName();
		String actionStr="";
		for(HtmlFormActionWrapper action:rowActions){
			String actionItemName=renderResponse.getNamespace()+form.getId()+action.getName();
			String btnClass="btn-primary";
			if(StringUtils.endsWithIgnoreCase(action.getName(), "delete")){
				btnClass="btn-danger";
			}
			actionStr+="<a data-key=\"'+data+'\" name=\""+actionItemName+"\" class=\"btn "+btnClass+" mr-1 text-white row-action row-action-"+action.getName()+"\">"+action.getLabel()+"</a>";

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
			             return '<%=actionStr%>';
			         }
			     }
<%
	}
%>
					]
				});
//===========================================				
				table.on( 'order.dt search.dt', function () {
			        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			            cell.innerHTML = i+1;
			        } );
			    } ).draw();
			    <%=form.getId()%>initActions();
			}
		);
	});
}
function <%=form.getId()%>updateTable(){
	//alert("<%=form.getId()%>updateTable called");
	AUI().use('aui-base', function(A){
		Liferay.Service(
		
			'/jetform.jetformbuilder/read-objects-as-json', <%=form.getId()%>dataTableFilters,
			function(response) {
			    //console.log("service response ================");
			    //console.log(response);
			    
			    var data=[];
			    
			    $(response).each(function(idx1, object){
			    	$(response).each(function(idx1, object){
				    	
				    	var dataRow=[];
				    	dataRow[0]=''; //Blank for index column
				    	dataRow[1]=object[keyElementName];
				    	var colCtr=2;
				    	
				    	$(<%=form.getId()%>columns).each(function(idx2, column){
				    		console.log('object[column["name"]] : '+column["name"]+" : "+object[column["name"]]);
				    		if(column["name"]!=keyElementName){
				    			console.log('gone inside');
					    		if (typeof object[column["name"]] === "undefined") {
						    		dataRow[colCtr]="";
						    	}else{
						    		dataRow[colCtr]=object[column["name"]];
						    	}
						    	colCtr++;
					    	}
				    	});
				    	dataRow[dataRow.length]=dataRow[1];
				    	data[idx1]=dataRow;
				    });
			    });
			    
				if ($.fn.dataTable.isDataTable('#<portlet:namespace/><%=form.getId()%>dataTable')) {
		            table = $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable();
		            table.clear();
				    table.rows.add(data).draw();
				    <%=form.getId()%>initActions();
				}
			}
		);
	});
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
		
		//LOGGER.info(element.getName()+" - key("+element.isKey()+") - hidden("+element.isHidden()+") - listable("+element.isListable()+")" +" column ("+(!element.isKey() && element.isHidden() && !element.isListable())+")");
		if((!element.isKey() && element.isHidden() && !element.isListable()) || (!element.isHidden() && !element.isListable())){
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
					
					//LOGGER.info(element.getName()+" - key("+element.isKey()+") - hidden("+element.isHidden()+") - listable("+element.isListable()+")" +" column ("+(!element.isKey() && element.isHidden() && !element.isListable())+")");
					if((!element.isKey() && element.isHidden() && !element.isListable()) || (!element.isHidden() && !element.isListable())){
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
			colCtr++;
		}
	});
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

function <%=form.getId()%>initActions(){
//alert('<%=form.getId()%>initActions()');
<%
	for(HtmlFormActionWrapper action: rowActions){
%>
		$("[name='<portlet:namespace/><%=form.getId()%><%=action.getName()%>']").each(function(index, action){
			//alert('<%=action.getName()%> : '+index);
			$(action).click(function(){
				//alert(action);
				<portlet:namespace/><%=form.getId()%><%=action.getName()%>onClick($(this));
			});
		});
<%
	}
%>
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
	var url= '<%=deleteRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
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

</aui:script>
<%
	}
	
	if(dialogMode){
%>

<aui:script use="liferay-util-window">

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
	);	
</aui:script>
<%
	}
%>
