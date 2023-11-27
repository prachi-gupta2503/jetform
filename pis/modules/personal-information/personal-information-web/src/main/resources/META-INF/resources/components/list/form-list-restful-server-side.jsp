<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="org.apache.commons.collections.MapUtils"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletResponseUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
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
<link href="<%=request.getContextPath()%>/css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/select.dataTables.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jszip.min.js"></script>      
<script type="text/javascript" src="<%=request.getContextPath()%>/js/buttons.html5.min.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.select.min.js"></script>

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
private static final String SEARCH_TEMPLTATE="search.template";
private static final String SEARCH_TEMPLTATE_VALUE="";
private static final int PAGE_SIZE=50;
%>
<style>
	.list-title{
		font-weight: 600;
		margin: auto;
	}
	.thumbnail{
		width:48px;
		height:48px; 
		border:2px solid #686868; 
		border-radius: 24px;
	}
	.data-table-parent{
		width:100%;
		overflow: auto;
	}
</style>

<portlet:renderURL var="imageViewerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/image-viewer.jsp" />
</portlet:renderURL>
<%

String formClass = null;
HtmlFormWrapper form = null;
List<HtmlFormActionWrapper> bulkActions=new ArrayList<HtmlFormActionWrapper>();
List<HtmlFormActionWrapper> rowActions=new ArrayList<HtmlFormActionWrapper>();
Map<String, String> actionsParamMap=new HashMap<String, String>();
Map<String, String> searchFilters=new HashMap<String, String>();

int tooltipLength=0;
int docElementCount=0;
int thumbnailCount=0;

boolean hasSubFormAndList=false;

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
boolean exportExcel=ParamUtil.getBoolean(request, "exportExcel", false);

try{
	tooltipLength=Integer.parseInt(PropsUtil.get("jetform.list.tooltip.length"));
}catch(Exception e){
	//DO nothing
}

String topHeaderTemplate = ParamUtil.getString(request, TOP_HEADER_TEMPLTATE, TOP_HEADER_TEMPLTATE_VALUE);
String topActionTemplate = ParamUtil.getString(request, TOP_ACTION_TEMPLTATE, TOP_ACTION_TEMPLTATE_VALUE);
String rowHeaderTemplate = ParamUtil.getString(request, ROW_ACTION_TEMPLTATE, ROW_ACTION_TEMPLTATE_VALUE);
String redirectionUrl = ParamUtil.getString(request, ACTION_REDIRECT_URL, ACTION_REDIRECT_URL_VALUE);
String searchTemplate = ParamUtil.getString(request, SEARCH_TEMPLTATE, SEARCH_TEMPLTATE_VALUE);

boolean isSelectable = false;

Enumeration<String> paramNames = request.getParameterNames();
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

if(StringUtils.isNotEmpty(formClass)){
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	form =JetFormBuilderLocalServiceUtil.rendererForm(formClass);
	//request.setAttribute("form", form); 
}

request.setAttribute("formId", form.getId());
request.setAttribute(form.getId(), form);

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

	List<HtmlElementWrapper> elements=form.getAllElements();
	
	for(HtmlElementWrapper element:elements){
		if(element.isControlType(HtmlElement.ControlType.form) || element.isControlType(HtmlElement.ControlType.list)){
			hasSubFormAndList=true;
		}else if((element.isControlType(HtmlElement.ControlType.fileUpload)|| element.isControlType(HtmlElement.ControlType.fileBrowser) || element.isControlType(HtmlElement.ControlType.fileDragDrop)) && element.isListable()){
			if(element.isThumbnail()){
				thumbnailCount++;
			}else{
				docElementCount++;
			}
		}
	}
	
	if(form.isAdvanceFilter()){
		//Do not do anything now..
	}

%>
<%@ include file="/components/list/list-action-urls.jsp" %>

<liferay-util:include page="<%=topHeaderTemplate%>" servletContext="<%=application%>">
</liferay-util:include>	

<%
	if(StringUtils.isNotEmpty(searchTemplate)){
%>

<div class="collapse" id="collapseSearch" >
  	<div class="card card-body">
		<liferay-util:include page="<%=searchTemplate%>" servletContext="<%=application%>">
		</liferay-util:include>
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
			<strong>Failure!</strong> Data updation failed.
		</div>
	</div>
</div>

<div class="row">
	<div id="<portlet:namespace/><%=form.getId()%>dataTableContainer" class="col-md-12">
		<div class="card">
			<div class="card-body" style="overflow:auto;">
			
				<table id="<portlet:namespace/><%=form.getId()%>dataTable" class="stripe hover mb-5 pt-2">
				</table>
				<input type="hidden" id="<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys" value="">
			</div>
		</div>
	</div>
<%--
if(form.isAdvanceFilter() && StringUtils.isEmpty(searchTemplate)){
%>		
	<div id="<portlet:namespace/>advSearch_Container" class="col-md-3 d-none">
			<%@ include file="/components/form/form-search.jsp"%>
	</div>
<%
}
--%>			
</div>

<aui:script use="aui-base,aui-modal,aui-overlay-manager,autocomplete-list,datasource-io,liferay-util-window">
var keyElementName='<%=form.getKeyElement().getName()%>';
var <%=form.getId()%>actionLabels=[];
var <%=form.getId()%>actionActions=[];
var <%=form.getId()%>dataTableFilterUpdated=false;
var <%=form.getId()%>dataTableFilters={};
var <%=form.getId()%>dataTableFilterSearchValue='';
var <%=form.getId()%>documentColumns=[];
var <%=form.getId()%>thumbnailColumns=[];

var <%=form.getId()%>columns=[];
var <%=form.getId()%>headers=[];
var <%=form.getId()%>dataPreload=<%=(dataPreload==null ||  dataPreload.equalsIgnoreCase("true") || dataPreload.equalsIgnoreCase("yes"))%>;
var tooltipLength=<%=tooltipLength %>;
var ih=0;
var <%=form.getId()%>selectable=<%=isSelectable%>;

$(document).ready(function() {
	
	<%=form.getId()%>initFilters();
	<%=form.getId()%>initColumns();
	<%=form.getId()%>initHeaders();

	try{
		<%=form.getId()%>beforeDocumentOnReady();
	}catch(e){}
	
	<%=form.getId()%>rowActionsToJson();
	<%=form.getId()%>initTable();
	<%=form.getId()%>initAddAction();
	
	if(<%=form.getId()%>documentColumns.length>0){
		for(var i=0;i < <%=form.getId()%>documentColumns.length;i++){
			<%=form.getId()%>documentColumns[i]=<%=form.getId()%>documentColumns[i]+1;
		}
	}
	
	if(<%=form.getId()%>thumbnailColumns.length>0){
		for(var i=0;i < <%=form.getId()%>thumbnailColumns.length;i++){
			<%=form.getId()%>thumbnailColumns[i]=<%=form.getId()%>thumbnailColumns[i]+1;
		}
	}
	
	/*
	console.log("<%=form.getId()%>thumbnailColumns");
	console.log(<%=form.getId()%>thumbnailColumns);
	console.log(<%=thumbnailCount%>);
	*/
	
	try{
		<%=form.getId()%>afterDocumentOnReady();
	}catch(e){}
});


Liferay.provide(window, '<%=form.getId()%>initFilters', function(){
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
});

Liferay.provide(window, '<%=form.getId()%>initTable', function(){
	$.fn.dataTable.ext.errMode = 'none';
			    
			    var table= $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable({
			    
			    				    	
<%
			if(exportExcel){ 
%>	
	                // "dom": '<"centre"l>Bfr<<t>>ip',
	                dom: '<"centre"l>Bfr<"#<portlet:namespace/><%=form.getId()%>dataTable_table.data-table-parent"t>ip',
			    	responsive: true,	    	
                    buttons: [{
                         extend: 'excel',
                        text: 'Export ' 
                        
                         }],
<%
			}else{
%>              
	                dom: 'lf<"#<portlet:namespace/><%=form.getId()%>dataTable_table.data-table-parent"t>ip',
<%
			}
%>	                

					ajax: function (data, callback, settings) {
						Liferay.Service(
						'/jetform.jetformbuilder/read-objects-as-json', 
				 		{
							"searchFilter" : <%=form.getId()%>dataTableFilters
						},
						function(response) {
							//console.log("service response ================");
						    //console.log(response);
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
						    	
						    	dataRow[dataRow.length]=dataRow[1];
						    	data[idx1]=dataRow;
						    	if(idx1>=10){
						    		return false;
						    	}
						    });
							callback({"data":data});
						});
					},
                    //data: data,
                    processing: true,
                    "language": {
                    	"processing": '<i class="fa fa-spinner fa-spin" style="font-size:24px;color:rgb(75, 183, 245);"></i>',
                    },
        			serverSide: true,
					"pageLength": <%=PAGE_SIZE%>,
					//"deferRender": true,
					"deferLoading": 20000, 
			        columns: <%=form.getId()%>headers,
					
			        'columnDefs': [
				{
			         'targets': 1,
			         'searchable': false,
			         'orderable': false,
			         'className': 'dt-body-center',
					 'visible': <%=form.getId()%>selectable,
					 'render': function (data, type, full, meta){
						if(<%=form.getId()%>selectable){
			            	return '<input type="checkbox" name="id[]" value="' + $('<div/>').text(full[1]).html() + '" onchange="<portlet:namespace/><%=form.getId()%>dataTable_UpdateSelected(this)">';
			             }else{
			             	return data;
			             }
			          }
			      },
<%
	if(docElementCount>0){
%>			      
			      {
			      	'targets':<%=form.getId()%>documentColumns,
			      	'render':function (data, type, full, meta){
			      		if(data!='' && data!='0'){
			      			return '<a onclick="<%=form.getId()%>viewDocument('+data+')" title="View/Download"><i class="fas fa-download"></i></a>';
			      		}else{
			      			return '&nbsp;'
			      		}
			      	}
			      },
<%
	}
%>	
<%
	if(thumbnailCount>0){
%>			      
			      {
			      	'targets':<%=form.getId()%>thumbnailColumns,
			      	'render':function (data, type, full, meta){
			      		if(data.indexOf("/")>=0){
			      			return '<img src="'+data+'" title="Image" class="thumbnail">';
			      		}else{
			      			return '<img src="<%=request.getContextPath()%>/images/no-image.png" title="Image" class="thumbnail">';
			      		}
			      	}
			      },
<%
	}
%>				      
			      			        
<%
	
	for(int i=0;i<elements.size(); i++){
		HtmlElementWrapper hew=elements.get(i);
	
		if(hew.isKey()){
			continue;
		}
	/* updated by prachi gupta on 27-06-2022	 */
	  if(hew.isTooltip()){
		%>
		{
				 'targets': <%=i+1%>,
				 'render': function (data, type, full, meta){
					 	
					 	//console.log(full);
					 	//console.log("render type : "+type);
					 	//console.log("render full : "+full);
					
					 if(tooltipLength>0 && data.length > tooltipLength)
					 {
					    var coldata=data;
					   coldata=data.substring(0,tooltipLength)+"...";
					   return "<span title='"+data+"' >"+coldata+"</span>";
					 }
					 else{
						return '<span>'+data+'</span>'
					 }	
				}
			
		},
		
<%
	}
	if(!hew.getHelpText().isEmpty()){
 		String helpText=hew.getHelpText();
%>
	 {
				'targets': <%=i+1%>,
				 'render': function (data, type, full, meta){
					 	
					 	//console.log(full);
					 	//console.log("render type : "+type);
					 	//console.log("render full : "+full);
					    var helpText="<%=helpText %>"
					   return "<span title='"+helpText+"' >"+data+"</span>";
					 
				}
			
		},
	 
<% 
	} 
	if(hew.isLink() && hew.isListable()){		
%>
			{
				 'targets': <%=i+1%>,
				 'render': function (data, type, full, meta){
					 	//console.log(data);
					 	//console.log(full);
					 	//console.log("render type : "+type);
					 	//console.log("render full : "+full);
					return '<a onClick="<portlet:namespace/><%=form.getId()+hew.getName()%>OnClick('+full[1]+')">' + $('<div/>').text(data).html() + '</a>';
				}
			},
<%
		}
	}

	if(rowActions.size()>0){
/*		String itemIdName="item."+form.getKeyElement().getName();
		String actionStr="";
		for(HtmlFormActionWrapper action:rowActions){
			String actionItemName=renderResponse.getNamespace()+form.getId()+action.getName();
			
			String activeActionClass="row-action row-action-"+action.getName()+" active";
			String inactiveActionClass="row-action row-action-"+action.getName()+" inactive";*/

			/*String btnClass="btn-primary";
			if(StringUtils.endsWithIgnoreCase(action.getName(), "delete")){
				btnClass="btn-danger";
			}*/
/*			
			actionStr+="<a data-key=\"'+data+'\" name=\""+actionItemName+"\" class=\""+action.getCssClass()+" row-action row-action-"+action.getName()+" mr-1\" onclick=\""+actionItemName+"onClick(this)\">"+action.getLabel()+"</a>";
*/			
/*			actionStr+="<a data-key=\"'+$('<div/>').text(data).html()+'\" name=\""+actionItemName+"\" class=\""+activeActionClass+"\">"+action.getLabel()+"</a>";
		
		}*/
%>	
				{
			         'targets': <%=form.getId()%>headers.length-1,
			         'searchable': false,
			         'orderable': false,
			         'className': 'dt-body-center',
					 'render': function (data, type, full, meta){
					 	var actionStr=getActionString(data, full[1]);
					 	//console.log("actionStr : "+actionStr);
					 	return actionStr;
			             <%--return '<%=actionStr%>'; --%>
			         }
			     }
<%
	}
%>
					]
				});
<%--				
				$('#<portlet:namespace/><%=form.getId()%>dataTable tbody').on('click', 'tr', function () {
					var data = table.row( this ).data();
					//alert( 'You clicked on '+data[0]+'\'s row' );
				} );
				
//===========================================
--%>	
			if(!<%=form.getId()%>selectable){			
				table.on( 'order.dt search.dt', function () {
			        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			            cell.innerHTML = i+1;
			        } );
			    } ).draw();
			}
  				<%--
			    table.on('page.dt', function () {
			    	console.log("Pagination clicked and  changed!");
			        table.rows({search:'applied', order:'applied'}).every( function ( rowIdx, tableLoop, rowLoop ) {
				      var data = this.data();
				      data.id = rowLoop + 1;
				      this.data( data );
				    } );
			    	
				    //<%=form.getId()%>initActions();
				} ).draw('page');
				
				$('#<%=form.getId()%>dataTable').on('page.dt', function (){
					console.log("<%=form.getId()%>dataTable Pagination clicked and  changed!");
					<%=form.getId()%>initActions();
				}); --%>
			    <%=form.getId()%>initActions();
			    <%--
			    var tableParentDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable").parent("div:last");//.closest('div');
				$(tableParentDiv).css("width", "100%");
				$(tableParentDiv).css("overflow", "auto");
				$(tableParentDiv).css("min-height", "50vh");
				$(tableParentDiv).css("max-height", "75vh");
				
				var topPagingDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable_paginate");
				$(topPagingDiv).css("width", "100%");
				$(topPagingDiv).css("margin-top", "5px");
				 --%>
		
});

Liferay.provide(window, 'getActionString', function(actions, idvalue){
	var actionStr="";
	<%--var actionStr+="<a data-key=\"'+$('<div/>').text(data).html()+'\" name=\""+actionItemName+"\" class=\""+activeActionClass+"\">"+action.getLabel()+"</a>";
	 --%>
	 //console.log("actions :"+actions);
	 //console.log("idvalue :"+idvalue);
	var actionArr= actions.split(",");
	$(actionArr).each(function(index, item){
		if(item!=''){
			var label=<%=form.getId()%>actionLabels[item+"_label"];
			actionStr+="<a data-key='"+idvalue+"' name='<portlet:namespace/><%=form.getId()%>"+item+"' class='mr-2 row-action-"+item+"'>"+label+"</a>";
		}
	})
	//console.log("actionStr :"+actionStr);
	return actionStr;
});

function <%=form.getId()%>initAddButton(){
	var tableParentDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable").parent("div:last");//.closest('div');
	$(tableParentDiv).css("width", "100%");
	$(tableParentDiv).css("overflow", "auto");
	$(tableParentDiv).css("max-height", "20vh");
	
	var tableFilterDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable_filter");//.closest('div');
	$(tableFilterDiv).append(<%=form.getId()%>addActionHtml);
	<%=form.getId()%>initAddAction();
}

Liferay.provide(window, '<%=form.getId()%>updateTable', function(){
	//alert("<%=form.getId()%>updateTable called");
	//console.log(<%=form.getId()%>dataTableFilters);
	if ($.fn.dataTable.isDataTable('#<portlet:namespace/><%=form.getId()%>dataTable')) {
        $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable().clear().destroy();
    }
    
    <%=form.getId()%>initTable();
});
            
Liferay.provide(window, '<portlet:namespace/><%=form.getId()%>dataTable_UpdateSelected', function(checkbox){
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
});

Liferay.provide(window, '<portlet:namespace/><%=form.getId()%>dataTable_GetSelected', function(){
	var selectedKeysElements=$("#<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys");
	var selectedKeys=$(selectedKeysElements).attr("value");
	return selectedKeys.split(",");
});

Liferay.provide(window, 'reloadListOptions', function(element, list, value, label, placeHolder){
	$(element).empty();
	if(placeHolder!=null && placeHolder!=''){
		$(element).append($('<option>', {value : '0'}).text(placeHolder));
	}
	$.each(list, function(i, e){
		$(element).append($('<option>', {value : e[value]}).text(e[label]));
	});		
});

Liferay.provide(window, '<%=form.getId()%>initColumns', function(){
	<%
	int dc=0;
	int tc=0;
	for(HtmlElementWrapper element:elements){
		
		//LOGGER.info(element.getName()+" - key("+element.isKey()+") - hidden("+element.isHidden()+") - listable("+element.isListable()+")" +" column ("+(!element.isKey() && element.isHidden() && !element.isListable())+")");
		if((!element.isKey() && element.isHidden() && !element.isListable()) || (!element.isHidden() && !element.isListable())){
			continue;
		}
		if(element.isControlType(HtmlElement.ControlType.paragraph) || element.isControlType(HtmlElement.ControlType.page)){
			continue;
		}
	%>
		<%=form.getId()%>columns[ih]={name:"<%=element.getAttribute()%>", label:"<%=element.getLabel() %>", key:<%=element.isKey()%>, hidden:<%=element.isControlType(HtmlElement.ControlType.hidden)%>};
	<%
		if(element.isControlType(HtmlElement.ControlType.fileUpload) && !element.isThumbnail()){
	%>	
		<%=form.getId()%>documentColumns[<%=dc++%>]=ih;
	<%
		}
		if(element.isThumbnail()){
	%>	
			<%=form.getId()%>thumbnailColumns[<%=tc++%>]=ih;
	<%		
		}
	%>	
		ih++;	
	<%
	}
	%>
	<%=form.getId()%>columns[ih]={name:"actions", label:"Actions", key:false, hidden:false};
});
	
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
<%--
	if(rowActions.size()>0){
%>	
		<%=form.getId()%>headers[<%=form.getId()%>headers.length]={ title: 'Actions'};
<%
	}
--%>		
}

Liferay.provide(window, '<%=form.getId()%>initAddAction', function(){
	try{
		$('#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>').click(function(){
			//console.log("#<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%> clicked###");
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
});

Liferay.provide(window, '<%=form.getId()%>rowActionsToJson', function(){
<%
	for(HtmlFormActionWrapper action: rowActions){
%>
		<%=form.getId()%>actionLabels['<%=action.getName()%>_label']='<%=action.getLabel()%>';
		<%=form.getId()%>actionLabels['<%=action.getName()%>_action']='<%=action.getAction()%>';
<%
	}
%>
//console.log(<%=form.getId()%>actionLabels);
});

Liferay.provide(window, '<%=form.getId()%>initActions', function(){
<%
	for(HtmlFormActionWrapper action: rowActions){
%>
		$("#<portlet:namespace/><%=form.getId()%>dataTable").on("click",".row-action-<%=action.getName()%>",function(e){
<%--		$("[name='<portlet:namespace/><%=form.getId()%><%=action.getName()%>']").each(function(index, action){
			//alert('<%=action.getName()%> : '+index);
			$(action).click(function(){
				//alert(action); --%>
				<portlet:namespace/><%=form.getId()%><%=action.getName()%>onClick($(this));
			//});
		});
		<%=form.getId()%>actionLabels['<%=action.getName()%>']='<%=action.getLabel()%>';
<%
	}
%>
});

<%
	for(HtmlFormActionWrapper action: rowActions){
%>
Liferay.provide(window, '<portlet:namespace/><%=form.getId()%><%=action.getName()%>onClick', function(actionSource){
		
		//alert($(actionSource).attr("data-key"));
		var callDefaultOnClick=true;
		try{
			callDefaultOnClick=<portlet:namespace/><%=form.getId()%><%=action.getName()%>BeforeOnClick(actionSource);
		}catch(e){
			//alert(e)
			callDefaultOnClick=true;
		}
		if(callDefaultOnClick){
			try{
				<portlet:namespace/><%=form.getId()%><%=action.getName()%>HandleOnClick(actionSource);
			}catch(e){
				alert("Error : "+e);
			}
		}
		try{
			<portlet:namespace/><%=form.getId()%><%=action.getName()%>AfterOnClick(actionSource);
		}catch(e){
			//Nothing to do
		}	
	});
<%
	}
%>

Liferay.provide(window,'<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>HandleOnClick', function(actionSource){
	var url= '<%=addRenderURL.toString() %>';

<%
	if(!dialogMode){
%>			
		window.location=url;
<%
	}else{
%>	
		var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
		var title ='<%="Add " + formTitle %>';
		var width = <%=form.getElementsPerRow()>1?1020:640%>;
		var height = <%=elements.size()/form.getElementsPerRow() * 84 + 100%>;
		LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
<%
	}
%>	
});

Liferay.provide(window, '<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>HandleOnClick', function(actionSource){
	var url= '<%=editRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	
<%
	if(!dialogMode){
%>			
		window.location=url;
<%
	}else{
%>		
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var title ='<%="Edit " + formTitle %>';
	var width = <%=form.getElementsPerRow()>1?1020:640%>;
	var height = <%=elements.size()/form.getElementsPerRow() * 84 + 100%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
<%
	}
%>
});

Liferay.provide(window, '<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>HandleOnClick',function(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var closeFunc='<portlet:namespace /><%=form.getId()%>closeDialog';
	var url= '<%=deleteRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key")+'&<portlet:namespace/>formId=<%=form.getId()%>';
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	
	var title ='<%="Delete " + formTitle %>';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 240, true, width);
});

Liferay.provide(window,'LiferayUtilOpenWindow', function(id, title, uri, centered, height, modal, width){
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

Liferay.provide(window,'<%=form.getId()%>ShowSuccessAlert',function(message){
	
	$('#<%=form.getId()%>alertSuccess').html("<strong>Success!</strong> "+(message!=""?message:"Data updated successfully."));
	$('#<%=form.getId()%>alertSuccess').show();
	$('#<%=form.getId()%>alertSuccess').delay( 800 ).fadeOut( 400 );
	//$( "#foo" ).slideUp( 300 ).delay( 800 ).fadeIn( 400 );
});

Liferay.provide(window,'<%=form.getId()%>ShowErrorAlert', function(message){
	$('#<%=form.getId()%>alertError').show("<strong>Failure!</strong> "+(message!=""?message:"Data updation failed."));
	$('#<%=form.getId()%>alertError').show();
	$('#<%=form.getId()%>alertError').delay( 800 ).fadeOut( 400 );
});

Liferay.provide(window,'<portlet:namespace /><%=form.getId()%>closeDialog',function(data) {
		//console.log("after close ");
		//console.log(data);
		
		var dialog;
		if(data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{	
			dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
		}
		
		dialog.destroy();
		
		if(data.error){
			<%=form.getId()%>ShowErrorAlert(data.message);
		}else{
			<%=form.getId()%>ShowSuccessAlert(data.message);
		}
		<%=form.getId()%>updateTable();
		
	},
	['liferay-util-window']
);
		

Liferay.provide(window, 'propagateSearch',function(searchParam){
	<%=form.getId()%>dataTableFilters=searchParam;
	<%=form.getId()%>updateTable();
});

Liferay.provide(window, '<%=form.getId()%>viewDocument', function(fileEntryId){
	Liferay.Service('/dlapp/get-file-entry',
	  {
	    fileEntryId: fileEntryId
	  },
	  function(response) {
	    console.log(response);
	    var url="/documents/"+response.repositoryId+"/"+response.folderId+"/"+encodeURI(response.fileName);
		var dialogId="<portlet:namespace /><%=form.getId()%>documentViewer";
		var title="Document Viewer";
		var extn=url.substring(url.lastIndexOf(".")+1).toLowerCase();
		
		if(extn=="pdf" || extn=="jpg" || extn=="jpeg" || extn=="png"){
			if(extn=="jpg" || extn=="jpeg" || extn=="png"){
				url="<%=imageViewerURL.toString()%>"+"&<portlet:namespace/>imageUrl="+encodeURI(url);
				title="Image Viewer";
			}
			LiferayUtilOpenWindow(dialogId, title, url, true, 700, true, 800);
		}else{
			window.open(url, '_blank');
		}
	  }
	);
});
</aui:script>
<%
	}
%>