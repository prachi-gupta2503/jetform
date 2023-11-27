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
String formClass = ParamUtil.getString(request, "formClass");
boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
String formId = ParamUtil.getString(request, "formId");
String selectedValueField = ParamUtil.getString(request, "selectedValueField");
String selectable = ParamUtil.getString(request, "selectable", null);
//LOGGER.info("formClass : "+formClass);

Map<String, String> actions=new HashMap<String, String>();
Enumeration paramNames = request.getParameterNames();
while(paramNames.hasMoreElements()){
	String paramName=(String)paramNames.nextElement();
}

dialogMode=true;
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
HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
if(form==null && StringUtils.isNotEmpty(formClass)){
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
	request.setAttribute(formId, form);
}
boolean isSelectable=form.isSelectable();

if(selectable!=null && (selectable.trim().equalsIgnoreCase("true") || selectable.trim().equalsIgnoreCase("false"))){
	isSelectable=Boolean.parseBoolean(selectable);
}
if(StringUtils.isEmpty(formClass) || form==null){
%>
	<b>Error:</b> Form not initialized due to formClass is "<%=formClass%>" and Form definition is "<%=form==null?"null":form.getTitle() %>".
<%
}else{
	if(form.getId()==null){
		form.setId(form.getFormClass().getSimpleName()+"_"+(new Date().getTime()));
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
	
	//LOGGER.info("rowActions.size()  : "+rowActions.size());
%>

<div class="container">
<%
	if(!formFlow){
%>
	<div class="row">
		<div class="col-md-12">
			<h3><%=form.getTitle() %></h3>
		</div>
	</div>
<%
	}
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
	<div class="row">
		<div class="col-md-12">
<%
	HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	if(addActionObj!=null){
		addAction=true;
		if(!dialogMode){
%>
		<a href="<%=addActionObj.getAction()%>" title="<%=StringUtils.capitalise(addActionObj.getName())%>" class="btn btn-primary mb-2 float-right" style="padding-right:50px !important;" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-1" style="background-color:#0b5fff; color:#fff;" aria-hidden="true"></i>Add</a>
<%	
		}else{
%>
		<a title="<%=StringUtils.capitalise(addActionObj.getName())%>" class="btn btn-primary mb-2 float-right" style="padding-right:50px !important;" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-1" style="background-color:#0b5fff; color:#fff;" aria-hidden="true"></i>Add</a>
<%			
		}
	}
%>			
		</div>
	</div>
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
</div>
<input type="hidden" id="<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys" value="">
<aui:script>
var <%=form.getId()%>dataTableFilterUpdated=false;
var <%=form.getId()%>columns=[];
var <%=form.getId()%>headers=[];
var ih=0;

<%=form.getId()%>initColumns();
<%=form.getId()%>initHeaders();

$(document).ready(function() {
	<%=form.getId()%>initTable();
	<%=form.getId()%>initAddAction();
});
function <%=form.getId()%>initTable(){
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/read-objects-as-json',
			{
				"objectClass" : "<%=formClass%>"
			},
			function(response) {
			    console.log(response);
			    var data=[];
			    
			    $(response).each(function(idx1, object){
			    	var dataRow=[];
			    	dataRow[0]=''; //Blank for index column
			    	$(<%=form.getId()%>columns).each(function(idx2, column){
			    		dataRow[idx2+1]=object[column["name"]];
			    	});
			    	
			    	dataRow[dataRow.length]=dataRow[1];
			    	console.log("dataRow.length : "+dataRow.length);
		    	
			    	
			
		    	
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
			    console.log(<%=form.getId()%>headers);
			    console.log(data);
			    
			    var table= $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable({
					data: data,
			        columns: <%=form.getId()%>headers,
			        'columnDefs': [{
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
<%------------------ --%>			      
			      
<%
	if(rowActions.size()>0){
		String itemIdName="item."+form.getKeyElement().getName();
		String actionStr="";
		for(HtmlFormActionWrapper action:rowActions){
			String actionItemName=renderResponse.getNamespace()+form.getId()+action.getName();
			actionStr+="<a data-key=\"'+$('<div/>').text(data).html()+'\" name=\""+actionItemName+"\" class=\"row-action row-action-"+action.getName()+"\">"+action.getLabel()+"</a>";
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
<%------------------- --%>			      
			      ]/*,
			        select: {
			            style:    'os',
			            selector: 'td:first-child'
			        }*/,
			        order: [[ 1, 'asc' ]]
				});
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
		
			'/jetform.jetformbuilder/read-objects-as-json',
			{
				"objectClass" : "<%=formClass%>"
			},
			function(response) {
			    console.log(response);
			    var data=[];
			    
			    $(response).each(function(idx1, object){
			    	var dataRow=[];
			    	dataRow[0]=''; //Blank for index column
			    	$(<%=form.getId()%>columns).each(function(idx2, column){
			    		dataRow[idx2+1]=object[column["name"]];
			    	});
			    	data[idx1]=dataRow;
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
		if(!element.isKey() && (element.isHidden() || !element.isListable())){
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
					if(!element.isKey() && (element.isHidden() || !element.isListable())){
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
			<%=form.getId()%>headers[index+1]={"title": "<input type='checkbox'>"};
		}else{
			<%=form.getId()%>headers[index+1]={"title": column.label};
		}
	});
}

function <%=form.getId()%>initAddAction(){
	$('#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>').click(function(){
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
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog';
	var title ='<%="Add " + form.getTitle() %>';
	var width = <%=form.getElementsPerRow()>1?1020:900%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, 700, true, width);
}
function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>HandleOnClick(actionSource){
	var url= '<%=editRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/><%=form.getId()+HtmlFormAction.ACTION_ADD+HtmlFormAction.ACTION_EDIT%>openDialog';
	var title ='<%="Edit " + form.getTitle() %>';
	var width = <%=form.getElementsPerRow()>1?1020:900%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, 700, true, width);
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
	var width = 700;
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
<%----This function to be taken to the wrapper list.jsp --%>
function <%=form.getId()%>updateTableWithFormFlowKeyFilter(){
	alert("<%=form.getId()%>updateTableWithFormFlowKeyFilter called");
	var formFlowKey=$(".form-flow-key").attr("value");
	alert("formFlowKey : "+formFlowKey);
	var searchFieldName='<%=form.getFormFlowKeyElement()!=null?form.getFormFlowKeyElement().getName():""%>';
	alert("searchFieldName : "+searchFieldName);
	AUI().use('aui-base', function(A){
		Liferay.Service(
		
			'/jetform.jetformbuilder/read-objects-as-json',
			{
				"objectClass" : "<%=formClass%>",
				"searchField" : searchFieldName,
				"searchValue" : formFlowKey,
			},
			function(response) {
				console.log("updateTableWithFormFlowKeyFilter response : "+response);
			    var data=[];
			    
			    $(response).each(function(idx1, object){
			    	var dataRow=[];
			    	dataRow[0]=''; //Blank for index column
			    	$(<%=form.getId()%>columns).each(function(idx2, column){
			    		dataRow[idx2+1]=object[column["name"]];
			    	});
			    	data[idx1]=dataRow;
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
function <%=form.getId()%>ShowSuccessAlert(){
	$('#<%=form.getId()%>alertSuccess').show();
}

function <%=form.getId()%>ShowErrorAlert(){
	$('#<%=form.getId()%>alertError').show();
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
</aui:script>
<%
	}
%>
