<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.liferay.form.ImportDataForm"%>
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
<%@page import="com.adjecti.jetform.liferay.constants.MVCCommandNames"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/init.jsp"%>

<link href="<%=request.getContextPath()%>/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery.dataTables.js" type="text/javascript"></script>
 
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_002dlist_jsp");
%>
<%
	String formClass = ParamUtil.getString(request, "formClass");
	//LOGGER.info("formClass: "+formClass);
	//formClass = "com.adjecti.eprocess.core.service.model.Category";
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form=null;
	if(StringUtils.isNotEmpty(formClass)){
		form = jetFormBuilderLocalService.getHtmlFormByClass(formClass);
	}
	//LOGGER.info("==========" +form);
	List<?> list = null;
	if(form!=null){
		list=jetFormBuilderLocalService.readObjects(form.getEntityClass());
	}
	
	if(StringUtils.isEmpty(formClass) || form==null || list==null){
%>
		<b>Error:</b> Form not initialized due to formClass is "<%=formClass%>" and Form definition is "<%=form==null?"null":form.getTitle() %>".
<%		
	}else{
	//LOGGER.info("==================================================="+list);
	List<HtmlFormActionWrapper> actions=form.getActions();
	List<HtmlElementWrapper> elements=new ArrayList<HtmlElementWrapper>();
	elements.addAll(form.getElements());
	for(HtmlElementGroupWrapper group:form.getElementGroups()){
		elements.addAll(group.getElements());
	}
	boolean addAction=false;
%>

<portlet:renderURL var="addEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:renderURL var="editEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>

<portlet:resourceURL var="deleteEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:resourceURL>

<portlet:renderURL var="importEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
</portlet:renderURL>


<%
	for(HtmlFormActionWrapper act:actions){
		if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_ADD)){
			act.setAction(addEntityRenderURL.toString());
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_EDIT)){
			act.setAction(editEntityRenderURL.toString());
			act.setName("<i class='fa fa-pencil-square-o mr-2' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_DELETE)){
			act.setAction(deleteEntityRenderURL.toString());
			act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}
	}
%>

<div class="card bg-primary text-white mt-2">
	<div class="card-header">
		<div class="row">
			<div class="col-md-8">
				<h5><%=AnnotationUtil.getItemLabel(form.getTitle()) %></h5>
			</div>
			<div class="col-md-4">
		
<%
	HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	LOGGER.info("addActionObj====================================="+addActionObj);
	if(addActionObj!=null){
		addAction=true;
%>
		
		<a style="float:right;" class="text-white fs-5" href="<%=addActionObj.getAction()%>" title="<%=StringUtils.capitalise(addActionObj.getName())%>" id="<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-2" aria-hidden="true"></i>Add <%=AnnotationUtil.getItemLabel(form.getTitle()) %></a>
		<%--<a class="btn btn-primary" href="<%=importEntityRenderURL.toString()%>">Import</a> --%>
<%	
	}
%>	
			</div>
		</div>
	</div>
</div>
<%--
	<div class="row">
		<div class="col-md-12">
<%
	HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	if(addActionObj!=null){
		addAction=true;
%>
		<a href="<%=addActionObj.getAction()%>" title="<%=StringUtils.capitalise(addActionObj.getName())%>" ><i class="fa fa-plus float-right mb-2" style="background-color:#0b5fff; color: #fff;font-size:24px; padding:3px 5px;" aria-hidden="true"></i></a>
<%		
	}
%>	
		
		</div>
	</div> --%>
	
	
	<div class="row">
		<div id="dataTable_Container" class="col-md-12">
			<div class="card">
<%--			<table id="dataTable" class="table-responsive compact stripe mb-5 pt-2"> --%>
			<table id="<portlet:namespace/><%=form.getId()%>dataTable" class="stripe mb-5 pt-2">
				<thead>
					<tr>
						<th class="header-primary" style="color: #495057; background-color: #e9ecef; border-color: #dee2e6;">#</th>
			
<%
			for(HtmlElementWrapper ele:elements){	
				//LOGGER.info(ele.getName()+" - "+ele.isTransientElement());
				if(!ele.isKey() && !ele.isControlType(HtmlElement.ControlType.hidden) && !ele.isControlType(HtmlElement.ControlType.password)  && ele.isListable()){
%>
						<th class="header-primary" style="color: #495057; background-color: #e9ecef; border-color: #dee2e6;"><%=ele.getLabel()%></th>
<%
			
				}
			}
			if((CollectionUtils.size(form.getActions())- (addAction?1:0))>0){
%>
				<th class="header-primary" style="color: #495057; background-color: #e9ecef; border-color: #dee2e6;">Actions</th>
<%
			}
%>
					</tr>
				</thead>
				<tbody>
				
<%
			
			if(CollectionUtils.isNotEmpty(list)){
				request.setAttribute("list", list);				
%>				
				<c:forEach items="${list}" var="item" varStatus="ctr">
					<tr>
						<td style="padding:.75rem; vertical-align: top; border-top: 1px solid #dee2e6;">${ctr.index+1}</td>
<%
					for(HtmlElementWrapper ele:elements){	
						if(!ele.isKey() && !ele.isControlType(HtmlElement.ControlType.hidden) && !ele.isControlType(HtmlElement.ControlType.password) && ele.isListable()){
							request.setAttribute("elementName", ele.getName());
							RelationWrapper relation=ele.getRelation();
							
							if(relation!=null && !relation.isNon()){
								Object obj=pageContext.getAttribute("item");
								String entityId=null;
								try{
									entityId=String.valueOf(ReflectionUtil.getProperty(obj, ele.getName()));
								}catch(Exception e){}
								
								if(entityId!=null &&  !entityId.isEmpty() && !"0".equals(entityId) && relation.getModelClass()!=null){
									KeyValue kv=null;
									FormEntityCache.registerFormClass(relation.getModelClass());
									//if(String.valueOf(relation.getModelClass())!=null){
									//	FormEntityCache.registerFormClass(relation.getModelClass());
										kv=jetFormBuilderLocalService.getRelationObjectAsKeyValue(relation.getModelClass(), entityId, relation.getValueField(), relation.getLabelField());
										if(kv==null || kv.getValue()==null || kv.getValue().isEmpty()){
											kv=new KeyValue(entityId, entityId);
										}
									
%>
							<td style="padding:.75rem; vertical-align: top; border-top: 1px solid #dee2e6;"><%=kv.getValue() %></td>								
<%
								}else{
%>
							<td style="padding:.75rem; vertical-align: top; border-top: 1px solid #dee2e6;">&nbsp;</td>
<%									
								}
								
							}else{
								try{
%>				
							<td style="padding:.75rem; vertical-align: top; border-top: 1px solid #dee2e6;">${item[elementName]}</td>			
<%
								}catch(Exception ex1){
%>
							<td style="padding:.75rem; vertical-align: top; border-top: 1px solid #dee2e6;">&nbsp;</td>
<%									
								}
							}
						}
					}
					if((CollectionUtils.size(form.getActions())- (addAction?1:0))>0){
						HtmlElementWrapper ele=form.getKeyElement();
						request.setAttribute("elementName", ele.getName());
%>
							<td style="padding:.75rem; vertical-align: top; border-top: 1px solid #dee2e6;">
<%
						for(HtmlFormActionWrapper act:form.getActions()){
							if(!StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_ADD)){
%>
							<a href="<%=act.getAction().concat("&")%><portlet:namespace/>formClassPK=${item[elementName]}"><%=act.getName() %></a>
<%
							}
						}
%>
							</td>
<%
					}
%>
					</tr>
				</c:forEach>
<%
				}
%>
				</tbody>
			</table>
			</div>
		</div>
<%
	if(form.isAdvanceFilter()){
%>		
		<div id="advSearch_Container" class="col-md-3 d-none">
			<%@ include file="/components/form/form-search.jsp"%>
		</div>
<%
	}
%>		
	</div>
</div>

<aui:script>
	var dataTableFilterUpdated=false;
	
	$(document).ready(function() {
		var table= $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable({
			"drawCallback": function (oSettings) {
		        $(".dataTables_filter").each(function () {
		        	console.log("$(this).appendTo($(this).parent().siblings(.panel-body))");
		        	if(!dataTableFilterUpdated){
		        		$(this).append("<i class='fa fa-search' style='margin-left:-20px;' aria-hidden='true'></i>");
<%
	if(form.isAdvanceFilter()){
%>		        		
		        		$(this).append("<i id='advSearchBtn' class='fa fa-caret-down' style='color:white;font-size:20px;margin-left:20px;' aria-hidden='true'></i>");
		        		dataTableFilterUpdated=true;
		        		$("#advSearchBtn").click(function () {
		        			$("#dataTable_Container").removeClass("col-md-12");
		        			$("#dataTable_Container").addClass("col-md-9");
		        			$("#advSearch_Container").removeClass("d-none");
		        			$("#advSearch_Container").addClass("d-block");
		        		});
<%
	}
%>		        		
		        	}
		            //$(this).appendTo($(this).parent().siblings(".panel-body"));
		        });
			}
		});
		
		$("#advSearch_Close").click(function(){
			$("#advSearch_Container").removeClass("d-block");
     		$("#advSearch_Container").addClass("d-none");
			$("#dataTable_Container").removeClass("col-md-9");
     		$("#dataTable_Container").addClass("col-md-12");
		});
	});
	
	function reloadListOptions(element, list, value, label, placeHolder){
		$(element).empty();
		if(placeHolder!=null && placeHolder!=''){
			$(element).append($('<option>', {value : '0'}).text(placeHolder));
		}
		$.each(list, function(i, e){
			$(element).append($('<option>', {value : e[value]}).text(e[label]));
		});		
	}
	
</aui:script>
<%
	}
%>
