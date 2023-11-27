<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>

<%@page import="com.adjecti.pis.liferay.constant.PISUserRole"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_other_info_002dlist_restful_jsp");
%>

<%
String formClass = null;
String[] formClasses=ParamUtil.getStringValues(request, "formClass");
boolean hasSubFormAndList=false;

if(formClasses!=null && formClasses.length>0){
	formClass=formClasses[formClasses.length-1];
}
boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
boolean titleBar = ParamUtil.getBoolean(request, "titleBar", false);
String formId = ParamUtil.getString(request, "formId");
String selectedValueField = ParamUtil.getString(request, "selectedValueField");
String selectable = ParamUtil.getString(request, "selectable");
String dataPreload = ParamUtil.getString(request, "dataPreload", "true");
long employeeId = ParamUtil.getLong(request, "employeeId", 0);
String className = ParamUtil.getString(request, "className");
String formActionSubmit="false";
Employee employee = null;
try {
	if(employeeId>0){
		employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
	}else{
		employee=EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
		employeeId=employee.getEmployeeId();
	}
} catch (Exception e) {
	LOGGER.info("Error : "+e.getMessage());
}

//LOGGER.info("employeeId : "+employeeId+", "+user.getEmailAddress());

boolean isSelectable = false;
int docElementCount=0;
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
dialogMode=true;
%>

<portlet:renderURL var="addRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	
</portlet:renderURL>

<portlet:renderURL var="editRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
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

<portlet:renderURL var="approveRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-approve.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="imageViewerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/image-viewer.jsp" />
</portlet:renderURL>

<%
if(className.equalsIgnoreCase("confirmation") ||className.equalsIgnoreCase("deputation")||className.equalsIgnoreCase("transfer")||className.equalsIgnoreCase("promotion") ){
	 formActionSubmit="true";
}
if(dialogMode){
%>
	<portlet:renderURL var="addRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
		<portlet:param name="form.action.submit" value="<%=formActionSubmit %>" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="dialogMode" value="true" />
		<portlet:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
		<portlet:param name="employeeId.hidden" value="true" />
<%
		if(formClass.equalsIgnoreCase(PISFormConstant.EMPLOYEEORGANIZATIONFORM)){
%>		
		<portlet:param name="organizationId" value="<%=String.valueOf(employee.getOrganizationId())%>" />
		<portlet:param name="organizationId.hidden" value="true" />

<%
		}
%>		
	</portlet:renderURL>
	<portlet:renderURL var="editRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="dialogMode" value="true" />
		<portlet:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
		<portlet:param name="employeeId.hidden" value="true" />
<%
		if(formClass.equalsIgnoreCase(PISFormConstant.EMPLOYEEORGANIZATIONFORM)){
%>		
		<portlet:param name="organizationId" value="<%=String.valueOf(employee.getOrganizationId())%>" />
		<portlet:param name="organizationId.hidden" value="true" />

<%
		}
%>
	</portlet:renderURL>
	<portlet:renderURL var="deleteRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-delete.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="dialogMode" value="true" />
		<portlet:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
		<portlet:param name="employeeId.hidden" value="true" />
<%
		if(formClass.equalsIgnoreCase(PISFormConstant.EMPLOYEEORGANIZATIONFORM)){
%>		
		<portlet:param name="organizationId" value="<%=String.valueOf(employee.getOrganizationId())%>" />
		<portlet:param name="organizationId.hidden" value="true" />

<%
		}
%>		
	</portlet:renderURL>
	
	
<%
}

//LOGGER.info("formClass: "+formClass);

//formClass = "com.adjecti.eprocess.core.service.model.Category";
HtmlFormWrapper form = null;//(HtmlFormWrapper)request.getAttribute(formId);

if(StringUtils.isNotEmpty(formClass)){
	//form =(HtmlFormWrapper)request.getAttribute("form-"+formClass);
	//if(form==null){
		form = JetFormBuilderLocalServiceUtil.rendererForm(formClass);
	//}
	//request.setAttribute(formId, form);
}else{
	 form = (HtmlFormWrapper)request.getAttribute(formId);
}

request.setAttribute("formId", form.getId());
request.setAttribute(form.getId(), form);
Class formClazz=FormEntityCache.getFormClass(form.getFormClass());
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

	if(form.getId()==null){
		//form.setId(form.getFormClass().getSimpleName()+"_"+(new Date().getTime()));
		form.setId(formClazz.getSimpleName()+"_"+12345);
	}
	////LOGGER.info("==================================================="+list);
	
	/*List<HtmlElementWrapper> elements=new ArrayList<HtmlElementWrapper>();
	elements.addAll(form.getElements());
	for(HtmlElementGroupWrapper group:form.getElementGroups()){
		elements.addAll(group.getElements());
	}*/
	
	List<HtmlElementWrapper> elements=form.getAllElements();
	List<HtmlElementWrapper> subFormElements=new LinkedList<HtmlElementWrapper>();
	for(HtmlElementWrapper element:elements){
		if(element.isControlType(HtmlElement.ControlType.form) || element.isControlType(HtmlElement.ControlType.list)){
			hasSubFormAndList=true;
		}else if(element.isControlType(HtmlElement.ControlType.fileUpload)|| element.isControlType(HtmlElement.ControlType.fileBrowser) || element.isControlType(HtmlElement.ControlType.fileDragDrop) && !element.isThumbnail()){
			if(element.isListable()){
				docElementCount++;
			}
		}
		if(element.isControlType(HtmlElement.ControlType.form)){
			if(StringUtils.isNotBlank(element.getListField())){
				
				HtmlFormWrapper childForm = JetFormBuilderLocalServiceUtil.rendererForm(element.getFormClass());
				String fields[]=StringUtils.split(element.getListField(), ",");
				
				for(String f:fields) {
					HtmlElementWrapper sfe=null;
					HtmlElementWrapper tsfe=childForm.getElementByName(f);
					if(tsfe!=null){
						sfe=new HtmlElementWrapper(tsfe.getName());
						sfe.setLabel(tsfe.getLabel());
						sfe.setControlType(HtmlElement.ControlType.text.name());
						sfe.setAttribute(tsfe.getAttribute());
						subFormElements.add(sfe);
					}
				}
			}
		}
	}
	elements.addAll(subFormElements);
	
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
		}else{
			if(act.getApplyOn().equals("row")){
				rowActions.add(act);
			}else{
				bulkActions.add(act);
			}
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}
	}
	
	if(formClass.indexOf("Joining")>=0){
		rowActions.clear();
	}
	//LOGGER.info("rowActions.size()  : "+rowActions.size());
%>

<%
	if(titleBar){
%>
<div class="card bg-primary text-white">
	<div class="card-header">
		<h5><%=AnnotationUtil.getItemLabel(form.getTitle()) %></h5>
	</div>
</div>
<%--	<div class="row">
		<div class="col-md-12">
			<h3><%=form.getTitle() %></h3>
		</div>
	</div> --%>
<%
	}
%>	
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-success" id="<%=form.getId() %>alertSuccess" style="display:none;" role="alert">
			  <strong>Success!</strong> <span id="alertSuccessMessage"></span>
			</div>
			<div class="alert alert-danger" id="<%=form.getId() %>alertError" style="display:none;" role="alert">
			  <strong>Failure!</strong> <span id="alertFailureMessage"></span>
			</div>
		</div>
	</div>

<%		
	boolean profileEditor=false;
	profileEditor=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));
		

/*	for(HtmlFormActionWrapper action:bulkActions){
		String enableValue=actionsParamMap.get(action.getName().toLowerCase());
		if(StringUtils.equalsIgnoreCase(enableValue, "false") || StringUtils.equalsIgnoreCase(enableValue, "no")){
			continue;
		}
*/	
	//HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	//if(addActionObj!=null){
		//addAction=true;
		

//LOGGER.info("Profile Editor : "+profileEditor);
//LOGGER.info(PISUserUtil.isAdmin(user.getUserId()) +" - "+PISUserUtil.isCreater(user.getUserId())  +" - "+ PISUserUtil.isApprover(user.getUserId())  +" - "+ request.isUserInRole(PISUserRole.POWER_USER.name())  +" - "+ request.isUserInRole("administrator") );

	if(profileEditor){
		
	
%>
	<div class="row" style="display:none;">
		<div class="col-md-12" id="<portlet:namespace/><%=form.getId()%>dataTable_addAction">
<%
	if(formClass.indexOf("Joining")<0){
%>		
			<a title="Add" id="<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>"><i class="fas fa-plus-circle text-white" style="font-size: 1.5em;" aria-hidden="true"></i></a>
<%
	}
%>			
		</div>
	</div>
<%
	}
/*	}*/
%>			
	<div class="row">
		<div id="<portlet:namespace/><%=form.getId()%>dataTableContainer" class="col-md-12">
			<div class="card">
				<div class="card-body" style="overflow:auto; padding: 0 0 0 0 !important;">
					<table id="<portlet:namespace/><%=form.getId()%>dataTable" class="stripe hover no-footer mb-5 pt-2" style="width:96%">
					</table>
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
<input type="hidden" id="<portlet:namespace/><%=form.getId()%>dataTable_SelectedKeys" value="">
<aui:script>
var <%=form.getId()%>dataTableFilterUpdated=false;
var <%=form.getId()%>dataTableFilters={};
var <%=form.getId()%>dataTableFilterSearchValue='';
var <%=form.getId()%>columns=[];
var <%=form.getId()%>headers=[];
var <%=form.getId()%>documentColumns=[];
var <%=form.getId()%>dataPreload=<%=(dataPreload==null ||  dataPreload.equalsIgnoreCase("true") || dataPreload.equalsIgnoreCase("yes"))%>;
var ih=0;
var <%=form.getId()%>selectable=<%=isSelectable%>;
var <%=form.getId()%>addActionHtml = "";

<%=form.getId()%>initFilters();
<%=form.getId()%>initColumns();
<%=form.getId()%>initHeaders();
	
$(document).ready(function() {

	<%=form.getId()%>addActionHtml=$("#<portlet:namespace/><%=form.getId()%>dataTable_addAction").html();
	$("#<portlet:namespace/><%=form.getId()%>dataTable_addAction").html("");
	
	if(<%=form.getId()%>documentColumns.length>0){
		for(var i=0;i < <%=form.getId()%>documentColumns.length;i++){
			<%=form.getId()%>documentColumns[i]=<%=form.getId()%>documentColumns[i]+1;
		}
	}
//	console.log(<%=docElementCount%>);
//	console.log(<%=form.getId()%>documentColumns);
	
	<%=form.getId()%>initTable();
	
		
});

function <%=form.getId()%>initFilters(){
	<%=form.getId()%>dataTableFilters={
		"objectClass" : "<%=formClass%>",
		"employeeId" : "<%=employeeId%>",
<%
		if(formClass.equalsIgnoreCase(PISFormConstant.EMPLOYEEORGANIZATIONFORM)){
%>		
		"organizationId" : "<%=employee.getOrganizationId()%>",
<%
		}
%>		
<%
	for(Map.Entry<String, String> entry:searchFilters.entrySet()){
		
%>
		"<%=entry.getKey() %>" : "<%=entry.getValue()%>",
		//"searchField" : "<%=entry.getKey() %>",
		//"searchValue" : "<%=entry.getValue()%>"
<%
	}
%>
		
	};
}

function <%=form.getId()%>initTable(){
	$.fn.dataTable.ext.errMode = 'none';
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/read-objects-as-json', 
	 		{
				"searchFilter" : <%=form.getId()%>dataTableFilters
			}
			,
			function(response) {
				//console.log("service response ================");
			    //console.log(response);
			    var data=[];
			    
				//if(<%=form.getId()%>dataPreload){
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
				    	
				    	//dataRow[dataRow.length]=dataRow[1];
				    	//console.log("dataRow.length : "+dataRow.length);
			    	
				    	data[idx1]=dataRow;
				    });
			    //}
		    
				console.log("<%=form.getId()%>headers");
			    console.log(<%=form.getId()%>headers);
			    //console.log("<%=form.getId()%>data");
			    console.log(data);
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
	if(rowActions.size()>0){
		String itemIdName="item."+form.getKeyElement().getName();
		String actionStr="";
		if(profileEditor){
			for(HtmlFormActionWrapper action:rowActions){
				
				String actionItemName=renderResponse.getNamespace()+form.getId()+action.getName();
				actionStr+="<a data-key=\"'+full[1]+'\" name=\""+actionItemName+"\" class=\"row-action row-action-"+action.getName()+" active\" title=\""+action.getTitle()+"\">"+action.getLabel()+"</a>";
		
			} 
		
		
		
%>	  
				{
			         'targets': <%=form.getId()%>headers.length-1,
			         'searchable': false,
			         'orderable': false,
			         'className': 'dt-body-center text-nowrap',
					 'render': function (data, type, full, meta){
			            console.log("data  ::  "+ data)
			             return '<%=actionStr%>';
			         }
			     }
<%
		}
	}
%>
					],					
					/*"drawCallback": function (oSettings) {
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
   				}*/
			});
//===========================================				
				table.on( 'order.dt search.dt', function () {
			        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			            cell.innerHTML = i+1;
			        } );
			    } ).draw();
			    
			    <%=form.getId()%>initAddButton();
				<%=form.getId()%>initActions();
				
			}
		);
	});
}
function <%=form.getId()%>initAddButton(){
	var tableParentDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable").parent("div:last");//.closest('div');
	$(tableParentDiv).css("width", "100%");
	$(tableParentDiv).css("overflow", "auto");
	$(tableParentDiv).css("max-height", "50vh");
	
	var tableFilterDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable_filter");//.closest('div');
	$(tableFilterDiv).append(<%=form.getId()%>addActionHtml);
	<%=form.getId()%>initAddAction();
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
	int dc=0;
	for(HtmlElementWrapper element:elements){
		
		//LOGGER.info(element.getName()+" - key("+element.isKey()+") - hidden("+element.isHidden()+") - listable("+element.isListable()+")" +" column ("+(!element.isKey() && element.isHidden() && !element.isListable())+")");
		if(!element.isListable()){
			continue;
		}
		
	%>
		<%=form.getId()%>columns[ih]={name:"<%=element.getAttribute()%>", label:"<%=element.getLabel() %>", key:<%=element.isKey()%>, hidden:<%=element.isControlType(HtmlElement.ControlType.hidden)%>};
	
	<%
		if(element.isControlType(HtmlElement.ControlType.fileUpload)){
	%>	
		<%=form.getId()%>documentColumns[<%=dc++%>]=ih;
	<%
		}
	%>
		ih++;	
	<%
	}
	%>
	<%=form.getId()%>columns[ih]={name:"actions", label:"Actions", key:false, hidden:false};
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
	
<%
	if(rowActions.size()>0 && profileEditor){
%>	
		<%=form.getId()%>headers[<%=form.getId()%>headers.length]={ title: 'Actions'};
<%
	}
%>	
}

function <%=form.getId()%>initAddAction(){
	try{
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
	var dialogId='<portlet:namespace/>editOpenDialog';
	
	var url= '<%=addRenderURL.toString() %>';
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog';
	
	var title ='<%="Add - " + formTitle%>';
	var width = <%=hasSubFormAndList? 960 :(form.getElementsPerRow()>1?960:640)%>;
	var height = <%=hasSubFormAndList? 720 :(form.getElements().size()/form.getElementsPerRow() * 84 + 100)%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>HandleOnClick(actionSource){
	//console.log(url);
	var dialogId='<portlet:namespace/>editOpenDialog';
	var url= '<%=editRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog';
	var title ='<%="Edit - " + formTitle %>';
	var width = <%=hasSubFormAndList? 960 :(form.getElementsPerRow()>1?960:640)%>;
	var height = <%=hasSubFormAndList? 720 :(form.getElements().size()/form.getElementsPerRow() * 84 + 100)%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
	<%--Liferay.Util.openWindow({
		dialog: {
			centered: true,
			height: 700,
			modal: true,
			width: <%=form.getElementsPerRow()>1?1020:900%>
		},
		id: '<portlet:namespace/><%=form.getId()%>dialog',
		title: 'Edit <%=form.getTitle() %>',
		uri: url
	}); --%>
}

function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_DELETE%>HandleOnClick(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var url= '<%=deleteRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog';
	var title ='<%="Delete " + formTitle %>';
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
<%--
<div class="alert alert-success" id="<%=form.getId() %>alertSuccess" style="display:none;" role="alert">
	<strong>Success!</strong> <span id="alertSuccessMessage"></span>
</div>
<div class="alert alert-danger" id="<%=form.getId() %>alertError" style="display:none;" role="alert">
	<strong>Failure!</strong> <span id="alertFailureMessage"></span>
</div>
 --%>			
function <%=form.getId()%>ShowSuccessAlert(message){
	if(message==''){
		$('#<%=form.getId()%>alertSuccess').html("<strong>Success!</strong> Data saved successfully.");
	}else{
		$('#<%=form.getId()%>alertSuccess').html("<strong>Success!</strong> "+message);
	}
	$('#<%=form.getId()%>alertSuccess').show();
	$('#<%=form.getId()%>alertSuccess').delay( 800 ).fadeOut( 400 );
	//$( "#foo" ).slideUp( 300 ).delay( 800 ).fadeIn( 400 );
}

function <%=form.getId()%>ShowErrorAlert(message){
	if(message==''){
		$('#<%=form.getId()%>alertError').html("<strong>Failure!</strong> Data saving failed.");
	}else{
		$('#<%=form.getId()%>alertError').html("<strong>Failure!</strong> "+message);
	}
	$('#<%=form.getId()%>alertError').show();
	$('#<%=form.getId()%>alertError').delay( 800 ).fadeOut( 400 );
}

function <portlet:namespace/><%=form.getId()%>approveHandleOnClick(actionSource){
	console.log($(actionSource).attr("data-key"));
	var formClassPK=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var closeFunc='<portlet:namespace/><%=form.getId()%>closeDialog';
	
	var url= '<%=approveRenderURL.toString()%>';
	url+='&<portlet:namespace/>formClassPK='+formClassPK;
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	
	var title ='Approve <%=form.getTitle()%>';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 320, true, width);
}

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
	
	if(dialogMode){
%>

<aui:script use="liferay-util-window">
<%--	
	A.one('#<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>').on('click', function(event) {
	    <!-- //alert("open"); -->
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				height: 700,
				modal: true,
				width: <%=form.getElementsPerRow()>1?1020:900%>
			},
			id: '<portlet:namespace/>openDialog',
			title: 'Add <%=form.getTitle() %>',
			uri: '<%=addRenderURL.toString() %>'
		});
	}); 
	
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%>closeDialog',
		function(data) {
			//alert("after close : "+data);
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
			dialog.destroy();
			//alert("before updateTable()");
			if(!data.refresh || data.refresh !="false"){
				<%=form.getId()%>ShowSuccessAlert();
				<%=form.getId()%>updateTable();
			}
			
		},
		['liferay-util-window']
	);
		
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%>closeDialog',
		function(data) {
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
			dialog.destroy();
			if(!data.refresh || data.refresh !="false"){
				<%=form.getId()%>ShowSuccessAlert();
				try{
					<%=form.getId()%>updateTable();
				}catch(e){
					window.location.reload();
				}
			}
		},
		['liferay-util-window']
	);	
	--%>
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%>closeDialog',
		function(data) {
			<%--
			alert("Called -- '<portlet:namespace /><%=form.getId()%>closeDialog'");
			 --%>
			if(data){
				console.log(data);	
			}
			
			var dialog;
			if(data.dialogId!=''){
				dialog = Liferay.Util.Window.getById(data.dialogId);
			}else{	
				dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
			}
			dialog.destroy();
			
			if(data.error){
				if(data.message && data.message!=''){
					<%=form.getId()%>ShowErrorAlert(data.message);
				}else{
					<%=form.getId()%>ShowErrorAlert('');
				}
			}else if(data.refresh){
				if(data.message && data.message!=''){
					<%=form.getId()%>ShowSuccessAlert(data.message);
				}else if(data.message!=''){
					<%=form.getId()%>ShowSuccessAlert(data.message);
		   		 }
				try{
					<%=form.getId()%>updateTable();
				}catch(e){
					window.location.reload();
				}
			}
			
		},
		['liferay-util-window']
	);
	

     	
  
</aui:script>
<%
	}
%>
