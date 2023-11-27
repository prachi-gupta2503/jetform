<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_002dlist_jsp");
%>

<%
String formClass = ParamUtil.getString(request, "formClass");
boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
//dialogMode=true;
%>

<portlet:renderURL var="addEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="formAction" value="<%=HtmlFormAction.ACTION_ADD%>" />
</portlet:renderURL>

<portlet:renderURL var="editEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="formAction" value="<%=HtmlFormAction.ACTION_EDIT%>" />
</portlet:renderURL>

<portlet:resourceURL var="deleteEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-list.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="formAction" value="list" />
</portlet:resourceURL>

<portlet:renderURL var="importEntityRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="formAction" value="import" />
</portlet:renderURL>

<%
if(dialogMode){
%>
	<portlet:renderURL var="addEntityRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="formAction" value="<%=HtmlFormAction.ACTION_ADD%>" />
		<portlet:param name="dialogMode" value="true" />
	</portlet:renderURL>
	<portlet:renderURL var="editEntityRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
		<portlet:param name="formClass" value="<%=formClass%>" />
		<portlet:param name="formAction" value="<%=HtmlFormAction.ACTION_EDIT%>" />
		<portlet:param name="dialogMode" value="true" />
	</portlet:renderURL>
<%
}

LOGGER.info("formClass: "+formClass);
//formClass = "com.adjecti.eprocess.core.service.model.Category";
//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
HtmlFormWrapper form=null;
if(StringUtils.isNotEmpty(formClass)){
	form =JetFormBuilderLocalServiceUtil.rendererForm(formClass);
}
LOGGER.info("==========" +form);
List<?> list = null;
if(form!=null){
	list=JetFormBuilderLocalServiceUtil.readObjects(form.getEntityClass());
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

	for(HtmlFormActionWrapper act:actions){
		LOGGER.info("==================================================="+act);
		if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_ADD)){
			act.setAction(addEntityRenderURL.toString());
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_EDIT)){
			act.setAction(editEntityRenderURL.toString());
			//act.setName("<i class='fa fa-pencil-square-o mr-2' aria-hidden='true'></i>");
		}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_DELETE)){
			act.setAction(deleteEntityRenderURL.toString());
			//act.setName("<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>");
		}
	}
%>

<%
	if(!formFlow){
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
		<a style="float:right;" class="text-white fs-5" action-url="<%=addActionObj.getAction()%>" title="<%=StringUtils.capitalise(addActionObj.getName())%>" id="<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus mr-2" aria-hidden="true"></i>Add <%=AnnotationUtil.getItemLabel(form.getTitle()) %></a>
		<%--<a class="btn btn-primary" href="<%=importEntityRenderURL.toString()%>">Import</a> --%>
<%	
	}
%>	
			</div>
		</div>
	</div>
</div>
<%
	}else{
%>	
	<div class="row">
		<div class="col-md-12">
<%
	HtmlFormActionWrapper addActionObj=form.getActionByName(HtmlFormAction.ACTION_ADD);
	LOGGER.info("addActionObj====================================="+addActionObj);
	if(addActionObj!=null){
		addAction=true;
%>
		<a action-url="<%=addActionObj.getAction()%>" title="<%=StringUtils.capitalise(addActionObj.getName())%>" id="<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>"><i class="fa fa-plus float-right mb-2" style="background-color:#0b5fff; color: #fff;font-size:24px; padding:3px 5px;" aria-hidden="true"></i></a>
		<%--<a class="btn btn-primary" href="<%=importEntityRenderURL.toString()%>">Import</a> --%>
<%	
	}
%>			
		</div>
	</div>
<%
	}
%>	
<div class="card">
	<div class="card-body">
	<div class="row">
		<div id="<%=form.getId()%>dataTableContainer" class="col-md-12">
			
			<table id="<%=form.getId()%>dataTable" class="stripe mb-5 pt-2">
				<thead>
					<tr>
						<th class="header-primary" style="color: #495057; background-color: #e9ecef; border-color: #dee2e6;">#</th>
<%
			if(form.isSelectable()){
%>	
				<th class="header-primary" style="color: #495057; background-color: #e9ecef; border-color: #dee2e6;">		
					<input type="checkbox" name="<%=form.getKeyElement().getName()%>" value="<%=(form.getPrimaryKey()!=null? String.valueOf(form.getPrimaryKey()):"0")%>">
				</th>	
<%
			} 

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
					if(form.isSelectable()){
%>	
						<td>		
							<input type="checkbox" name="<%=form.getKeyElement().getName()%>" value="<%=(form.getPrimaryKey()!=null? String.valueOf(form.getPrimaryKey()):"0")%>">
						</td>	
<%
					} 

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
								
								//LOGGER.info(ele.getName()+ " - " +entityId + " - "+ relation.getModelClass());
								if(entityId!=null &&  !entityId.isEmpty() && !"0".equals(entityId) && relation.getModelClass()!=null){
									KeyValue kv=null;
									
									//if(String.valueOf(relation.getModelClass())!=null){
									//	FormEntityCache.registerFormClass(relation.getModelClass());
										kv=jetFormBuilderLocalService.getRelationObjectAsKeyValue(relation.getModelClass(), entityId, relation.getValueField(), relation.getLabelField());
										if(kv==null || kv.getValue()==null || kv.getValue().isEmpty()){
											kv=new KeyValue(entityId, entityId);
										}

									//}
									
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
									if(ele.isControlType(HtmlElement.ControlType.date) || ele.isControlType(HtmlElement.ControlType.datetime)){
%>
										<td style="padding: .75rem; vertical-align: top; border-top: 1px solid #dee2e6;"><fmt:formatDate pattern="yyyy-MM-dd" value="${item[elementName]}"/></td>
<%					
									}else{
%>
										<td style="padding: .75rem; vertical-align: top; border-top: 1px solid #dee2e6;">${item[elementName]}</td>
<%													
									}
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
							String linkLabel="";
							if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_ADD)){
								continue;
							}
							if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_EDIT)){
								linkLabel="<i class='fa fa-pencil-square-o mr-2' aria-hidden='true'></i>";
							}else if(StringUtils.equalsIgnoreCase(act.getName(), HtmlFormAction.ACTION_DELETE)){
								linkLabel="<i class='fa fa-trash mr-2' style='color:#de1d1d;' aria-hidden='true'></i>";
							}
%>
							<a href="javascript:onClick<%=act.getName()%>('<%=act.getAction().concat("&")%><portlet:namespace/>formClassPK=${item[elementName]}',<%=dialogMode%>)"><%=linkLabel%></a>
<%
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
		$.fn.dataTable.ext.errMode = 'none';
		var table= $('#<%=form.getId()%>dataTable').DataTable({
			"drawCallback": function (oSettings) {
		        $(".dataTables_filter").each(function () {
		        	//console.log("$(this).appendTo($(this).parent().siblings(.panel-body))");
<%
	if(!formFlow ){
%>		        	
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
<%
	}else{
%>	
					$("#<%=form.getId()%>dataTable_length").remove();
					$("#<%=form.getId()%>dataTable_filter").remove();
<%
	}
%>          
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
	
	function onClick<%=HtmlFormAction.ACTION_EDIT%>(linkActionUrl, dialogMode){
		if(dialogMode){
		    //alert("open");
			Liferay.Util.openWindow({
				dialog: {
					centered: true,
					height: 700,
					modal: true,
					width: <%=(form.getElementsPerRow()>1 || form.getElementGroups().size()>0) ?1020:900%>
				},
				id: '<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>dialog',
				title: 'Edit <%=form.getTitle() %>',
				uri: linkActionUrl
			});
		}else{
			window.location.href=linkActionUrl;
		}
	}
</aui:script>
<%
	}
	
%>

<aui:script use="aui-base, liferay-preview, liferay-util-window">
	A.one('#<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>').on('click', function(event) {
	
	var linkElement=A.one('#<portlet:namespace/><%=form.getId()%>action<%=HtmlFormAction.ACTION_ADD%>');
	var linkActionUrl=linkElement.attr("action-url");
<%
	if(dialogMode){
%>
	    //alert("open");
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				height: 700,
				modal: true,
				width: <%=(form.getElementsPerRow()>1 || form.getElementGroups().size()>0) ?1020:900%>
			},
			id: '<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>dialog',
			title: 'Add <%=form.getTitle() %>',
			uri: linkActionUrl
		});
<%
	}else{
%>		
		window.location.href=linkActionUrl;
<%
	}
%>
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>closeDialog',
		function(data) {
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>dialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>closeDialog',
		function(data) {
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_EDIT%>dialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);
</aui:script>

