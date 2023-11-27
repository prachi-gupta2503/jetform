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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.list_element_jsp");
%>

<%
String formClass = null;
String[] formClasses = ParamUtil.getStringValues(request, "childListClass");
String parentClassName = ParamUtil.getString(request, "parentClassName");
String parentClassPKName = ParamUtil.getString(request, "parentClassPKName");
String parentClassPK =  ParamUtil.getString(request, parentClassPKName);
boolean validParentClassPK=(StringUtils.isNotEmpty(parentClassPK) && !StringUtils.equals(parentClassPK, "0"));

String simpleParentClassName=parentClassName.substring(parentClassName.lastIndexOf(".")+1);

if(formClasses!=null && formClasses.length>0){
	formClass=formClasses[formClasses.length-1];
}
String selectedValueField = ParamUtil.getString(request, "selectedValueField");
String selectable = ParamUtil.getString(request, "selectable");
String dataPreload = ParamUtil.getString(request, "dataPreload", "true");

HtmlElementWrapper listElement = (HtmlElementWrapper) request.getAttribute("htmlElement");

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
boolean dialogMode=true;
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

<portlet:renderURL var="alertRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-alert.jsp" />
</portlet:renderURL>

<%

//LOGGER.info("formClass: "+formClass);

//formClass = "com.adjecti.eprocess.core.service.model.Category";
HtmlFormWrapper form = null;//(HtmlFormWrapper)request.getAttribute(formId);
if(StringUtils.isNotEmpty(formClass)){
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
	//request.setAttribute(form.getId(), form);
}

request.setAttribute("formId", form.getId());
request.setAttribute(form.getId(), form);

if(form==null){
%>
	<b>Error:</b> Form not initialized due to formClass is "<%=formClass%>" and Form definition is "<%=form==null?"null":form.getTitle() %>".
<%
}else{
	isSelectable=form.isSelectable();

	if(selectable!=null && (selectable.trim().equalsIgnoreCase("true") || selectable.trim().equalsIgnoreCase("false"))){
		isSelectable=Boolean.parseBoolean(selectable);
	}
	
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
		}
	}
	
	//LOGGER.info("rowActions.size()  : "+rowActions.size());
%>

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
<%--	<div class="row">
		<div class="col-md-7">
			<%=AnnotationUtil.getItemLabel(form.getTitle()) %>
		</div>
		<div class="col-md-5">
<%
	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}
	
	//HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	//if(addActionObj!=null){
		//addAction=true;
		if(!dialogMode){
%>
		<a href="<%=action.getAction()%>" title="<%=StringUtils.capitalize(action.getName())%>" class="btn btn-primary mb-2 float-right" style="padding-right:50px !important;" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-1" style="background-color:#0b5fff; color:#fff;" aria-hidden="true"></i>Add</a>
<%	
		}else{
%>
		<a title="<%=StringUtils.capitalise(action.getName())%>" class="btn btn-primary mb-2 float-right" style="padding-right:50px !important;" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-1" style="background-color:#0b5fff; color:#fff;" aria-hidden="true"></i>Add</a>
<%			
		}
	}
%>			
		</div>
	</div> --%>
	
	<div class="row">
		<div id="<portlet:namespace/><%=form.getId()%>dataTableContainer" class="col-md-12">
			<div class="card">
			<table id="<portlet:namespace/><%=form.getId()%>dataTable" class="stripe mb-5 pt-2">
			</table>
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
<aui:script>
var ih=0;
var <%=form.getId()%>validParentPK=<%=validParentClassPK %>;
var <%=form.getId()%>dataTableFilterUpdated=false;
var <%=form.getId()%>dataTableFilters={};
var <%=form.getId()%>dataTableFilterSearchValue='';
var <%=form.getId()%>columns=[];
var <%=form.getId()%>headers=[];
var <%=form.getId()%>dataPreload=<%=(dataPreload==null ||  dataPreload.equalsIgnoreCase("true") || dataPreload.equalsIgnoreCase("yes"))%>;



<%=form.getId()%>initFilters();
<%=form.getId()%>initColumns();
<%=form.getId()%>initHeaders();

function <%=form.getId()%>initFilters(){
	<%=form.getId()%>dataTableFilters={
		"objectClass" : "<%=formClass%>",
		"<%=listElement.getMappingField() %>" : "<%=StringUtils.isNotEmpty(parentClassPK)?parentClassPK:"-1"%>",
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
	console.log(<%=form.getId()%>dataTableFilters);
	<%=form.getId()%>initTable();
	<%=form.getId()%>initAddAction();
});
function <%=form.getId()%>initTable(){
	console.log("in <%=form.getId()%>initTable()");
	console.log(<%=form.getId()%>dataTableFilters);
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/read-objects-as-json',  //<%=form.getId()%>dataTableFilters
 		    {
				"searchFilter" : <%=form.getId()%>dataTableFilters
			}
			
			,
			function(response) {
				//console.log("service response ================");
			    console.log(response);
			    var data=[];
			    
				//if(<%=form.getId()%>dataPreload){
				    $(response).each(function(idx1, object){
				    	var dataRow=[];
				    	dataRow[0]=''; //Blank for index column
				    	$(<%=form.getId()%>columns).each(function(idx2, column){
				    		if (typeof object[column["name"]] === "undefined") {
					    		dataRow[idx2+1]="";
					    	}else{
					    		dataRow[idx2+1]=object[column["name"]];
					    	}
				    	});
				    	
				    	dataRow[dataRow.length]=dataRow[1];
				    	//console.log("dataRow.length : "+dataRow.length);
			    	
				    	data[idx1]=dataRow;
				    });
			    //}
<%
	if(rowActions.size()>0){
%>	
		<%=form.getId()%>headers[<%=form.getId()%>headers.length]={ title: 'Actions'};
		//alert("<%=form.getId()%>headers.length : "+<%=form.getId()%>headers.length);
<%
	}
%>			    
				//console.log("<%=form.getId()%>headers");
			    //console.log(<%=form.getId()%>headers);
			    //console.log("<%=form.getId()%>data");
			    //console.log(data);
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
			actionStr+="<a data-key=\"'+data+'\" name=\""+actionItemName+"\" class=\"row-action row-action-"+action.getName()+"\">"+action.getLabel()+"</a>";

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
					],
					"drawCallback": function (oSettings) {
		        		$(".dataTables_filter").each(function () {
		        		//console.log("$(this).appendTo($(this).parent().siblings(.panel-body))");
		        			if(!<%=form.getId()%>dataTableFilterUpdated){
			    				$(this).append("<i class='fa fa-search' style='margin-left:-20px;' aria-hidden='true'></i>");
			    				$(this).append("<a id='<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>'><i class='fa fa-plus-square' style='color:#fff; margin-left:20px; font-size:1.5rem;' aria-hidden='true'></i></a>");
			    				<%=form.getId()%>initAddAction();
			    				<%=form.getId()%>dataTableFilterUpdated=true;
			    			}
		    			}
		    		);
		    	}
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
	//alert(".form-key-<%=parentClassPKName%>" + $(".form-key-<%=parentClassPKName%>").val());
	<%=form.getId()%>dataTableFilters={
		"objectClass" : "<%=formClass%>",
		"<%=listElement.getMappingField() %>" : $(".form-key-<%=parentClassPKName%>").val(),
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
	console.log("in <%=form.getId()%>updateTable()");
	console.log(<%=form.getId()%>dataTableFilters);
	AUI().use('aui-base', function(A){
		Liferay.Service(
		
			'/jetform.jetformbuilder/read-objects-as-json',  //<%=form.getId()%>dataTableFilters
 		    {
				"searchFilter" : <%=form.getId()%>dataTableFilters
			},
			function(response) {
			    //console.log("service response ================");
			    //console.log(response);
			    
			    var data=[];
			    
			    $(response).each(function(idx1, object){
			    	$(response).each(function(idx1, object){
				    	var dataRow=[];
				    	dataRow[0]=''; //Blank for index column
				    	$(<%=form.getId()%>columns).each(function(idx2, column){
					    	if (typeof object[column["name"]] === "undefined") {
					    		dataRow[idx2+1]="";
					    	}else{
					    		dataRow[idx2+1]=object[column["name"]];
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
	$(<%=form.getId()%>columns).each(function(index, column){
		if(column.key){
<%
			String titleValue="";
			if(isSelectable){
				titleValue="<input type='checkbox' disabled>";
			}
%>			
			<%=form.getId()%>headers[index+1]={"title": "<%=titleValue%>"};
			
		}else{
			<%=form.getId()%>headers[index+1]={"title": column.label};
		}
	});
}

function <%=form.getId()%>initAddAction(){
	try{
		$('#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>').click(function(){
			alert('(.form-key-<%=parentClassPKName%>).val() : '+ $(".form-key-<%=parentClassPKName%>").val());
			if($(".form-key-<%=parentClassPKName%>").val()!=''){
				<%=form.getId()%>validParentPK=true;
			}
			
			if(!<%=form.getId()%>validParentPK){
				var message="Add a <%=AnnotationUtil.getItemLabel(simpleParentClassName) %> record before adding <%=AnnotationUtil.getItemLabel(form.getTitle())%>.";
				openAlertDialog("Add - <%=AnnotationUtil.getItemLabel(form.getTitle())%>",message , false, false);
				return false;
			}
			
			//alert("#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%> clicked###");
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
	//alert(".form-key-<%=parentClassPKName%> : "+ $(".form-key-<%=parentClassPKName%>").val());
	var url= '<%=addRenderURL.toString() %>';
	var url= url +"&<portlet:namespace/><%=listElement.getMappingField()%>="+$(".form-key-<%=parentClassPKName%>").val();
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog';
	var title ='<%="Add " + form.getTitle() %>';
	var width = <%=form.getElementsPerRow()>1?1020:640%>;
	var height = <%=form.getElements().size()/form.getElementsPerRow() * 84 + 100%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>HandleOnClick(actionSource){
	var url= '<%=editRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	console.log(url);
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog';
	var title ='<%="Edit " + form.getTitle() %>';
	var width = <%=form.getElementsPerRow()>1?1020:640%>;
	var height = <%=form.getElements().size()/form.getElementsPerRow() * 84 + 100%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
	<%--Liferay.Util.openWindow({
		dialog: {
			centered: true,
			height: 700,
			modal: true,
			width: <%=form.getElementsPerRow()>1?1020:900%>
		},
		id: '<portlet:namespace/><%=HtmlFormAction.ACTION_EDIT%>dialog',
		title: 'Edit <%=form.getTitle() %>',
		uri: url
	}); --%>
}

function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>HandleOnClick(actionSource){
	var url= '<%=deleteRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_DELETE%>openDialog';
	var title ='<%="Delete " + form.getTitle() %>';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 300, true, width);
	
	<%--Liferay.Util.Window.getWindow(
		{
			dialog : {
				bodyContent: message,
				height: 250,
				hideOn: [],
				resizable: false,
				toolbars: {
					footer: [
						getButtonConfig(yesButtonLabel, yesFn),
						getButtonConfig(noButtonLabel, noFn)
					]
				},
				width: 700
			},
			title: Liferay.Language.get('are-you-sure')
		}
	); --%>
	
	
	<%--Liferay.Util.openWindow({
		dialog: {
			centered: true,
			height: 700,
			modal: true,
			width: <%=form.getElementsPerRow()>1?1020:900%>
		},
		id: '<portlet:namespace/><%=HtmlFormAction.ACTION_EDIT%>dialog',
		title: 'Edit <%=form.getTitle() %>',
		uri: url
	}); --%>
}
function openAlertDialog(alertTitle, message, error, confirmation){
	var url= '<%=alertRenderURL.toString() %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation;
	var dialogId='<portlet:namespace/>alertDialog';
	var title =alertTitle;
	var width = 460;
	LiferayUtilOpenWindow(dialogId, title, url, true, 200, true, width);
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
	$('#<%=form.getId()%>alertSuccess').delay( 800 ).fadeOut( 400 );
}

</aui:script>
<%
	}
	
	if(dialogMode){
%>

<aui:script use="liferay-util-window">
<%--	A.one('#<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>').on('click', function(event) {
	    <!-- //alert("open"); -->
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				height: 700,
				modal: true,
				width: <%=form.getElementsPerRow()>1?1020:900%>
			},
			id: '<portlet:namespace/><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog',
			title: 'Add <%=form.getTitle() %>',
			uri: '<%=addRenderURL.toString() %>'
		});
	}); --%>
	
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>closeDialog',
		function(data) {
			//alert("after close : "+data);
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog');
			console.log(dialog);
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
	);	
	
	Liferay.provide(
		window,
		'<portlet:namespace/>alertDialogClose',
		function(data) {
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/>alertDialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);	
</aui:script>
<%
	}
%>
