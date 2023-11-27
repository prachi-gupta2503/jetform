<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.adjecti.common.util.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="/init.jsp"%>
<%-- script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>--%>
<script>
	//var $=jQuery.noConflict();
</script>
<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.info_card_jsp");%>

<%
	response.setHeader("Cache-Control", "max-age=0");

	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String childFormElementName = ParamUtil.getString(request, "childFormElement");
	String employeeId = ParamUtil.getString(request, "employeeId");
	
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	

	HtmlFormWrapper form = null;
	if (!(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0"))) {
		
		form = JetFormBuilderLocalServiceUtil.rendererForm(formClass, formClassPK);
	}else{
		form = JetFormBuilderLocalServiceUtil.rendererForm(formClass);
	}
	
	//LOGGER.info("formClass : " + formClass + ", formClassPK : " + formClassPK +", childFormElementName : "+childFormElementName+", employeeId : "+employeeId);
	Class entityClass = FormEntityCache.getFormClass(form.getEntityClass());
	Object entity = form.getEntity();
	
	/*for(HtmlElementWrapper e: form.getElements()){
		LOGGER.info("e.getName() : "+e);
	}*/
	HtmlFormWrapper childForm = null;
	HtmlElementWrapper childFormElement=form.getElementByName(childFormElementName);
	//LOGGER.info("childFormElement : " + childFormElement);
	
	if(childFormElement!=null){
		Method method=ReflectionUtil.getAccessorMethodByFieldName(entityClass, childFormElement.getMappingField());
		String childFormClassPK = null;
		try{
			childFormClassPK=String.valueOf(method.invoke(entity, new Object[]{}));
			LOGGER.info("childFormClassPK : " + childFormClassPK);
			childForm = JetFormBuilderLocalServiceUtil.rendererForm(childFormElement.getFormClass(), childFormClassPK);
			LOGGER.info("childForm : " + childForm);
		}catch(Exception e){}
		
		if(childForm==null){
			
			childForm=JetFormBuilderLocalServiceUtil.rendererForm(childFormElement.getFormClass());
			//LOGGER.info("childForm==null : " + childForm);
		}
	}
	
	HtmlFormWrapper displayForm=form;
	
	if(childForm!=null){
		displayForm=childForm;
		entity=childForm.getEntity();
		entityClass=FormEntityCache.getFormClass(displayForm.getEntityClass());
	}
	//LOGGER.info("displayForm : " + displayForm);
	//LOGGER.info("formClass : " + formClass + ", formClassPK : " + formClassPK +", childFormElementName : "+childFormElementName+", employeeId : "+employeeId);
	pageContext.setAttribute("htmlForm", form);
%>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<portlet:renderURL var="addRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="formClassPK" value="<%=formClassPK%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<div class="card profile-box flex-fill">
	<div class="card-body">
		<h3 class="card-title">
			<%=AnnotationUtil.getItemLabel(form.getTitle())%>
			<%--a id="<%=form.getId()%>edit" class="edit-icon" data-toggle="modal" data-target="#personal_info_modal"><i class="fas fa-pencil-alt"></i></a> --%>
			<a id="<portlet:namespace/><%=form.getId()%>edit" class="edit-icon"><i class="fas fa-pencil-alt"></i></a>
		</h3>
		<ul class="personal-info" style="columns:<%=(displayForm.getElements().size()/10)+1%>;">
<%

				for (HtmlElementWrapper element : displayForm.getElements()) {
					
					if (element.isControlType(HtmlElement.ControlType.hidden)) {
						continue;
					}
					String value = "-";
					String filePath="";
					String fileTitle="";
					boolean fileEntryType=element.isControlType(HtmlElement.ControlType.fileUpload);
					if (entity != null && displayForm.getPrimaryKey() != null) {
						
						try {
							Method method = entityClass.getMethod("get" + StringUtils.capitalize(element.getAttribute()),
									new Class[] {});
							
							try{
								Object objValue=method.invoke(entity, new Object[] {});
								
								if(objValue instanceof Date){
									value=DateUtils.format((Date)objValue, DateUtils.DD_MMM_YYYY);
								}else if(objValue instanceof Boolean){
									Boolean boolVal=(Boolean)objValue;
									value=(boolVal.booleanValue()?"Yes":"No");
								}else{
									value=String.valueOf(objValue);
									
								}
							}catch(Exception e){
								LOGGER.info(e);
							}
							
							pageContext.setAttribute(element.getName() + "_savedValue", value);
							
							
							if(fileEntryType){
								try{
									DLFileEntry fileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(value));
									fileTitle=fileEntry.getTitle();
									filePath="/documents/"+fileEntry.getRepositoryId()+"/"+fileEntry.getFolderId()+"/"+URLEncoder.encode(fileEntry.getFileName());
								}catch(Exception fex){}
							}else{
							
							//e.setValue(value);
								RelationWrapper relation = element.getRelation();
								if (relation.isValidModelClass()) {
									Method modelMethod = null;
									String modelClass =relation.getModelClass();
									Class modelClazz= FormEntityCache.getFormClass(modelClass);
									Object relObject = JetFormBuilderLocalServiceUtil.readObject(modelClass, value);
									if (relObject != null) {
										if (StringUtils.isNotEmpty(relation.getLabelField())) {
											modelMethod = modelClazz.getMethod(
													"get" + StringUtils.capitalize(relation.getLabelField()), new Class[] {});
										} else {
											try {
												modelMethod = modelClazz.getMethod("get" + modelClazz.getSimpleName(),
														new Class[] {});
											} catch (Exception ex) {
												modelMethod = modelClazz.getMethod("getName", new Class[] {});
											}
										}
										if (method != null) {
											value = String.valueOf(modelMethod.invoke(relObject, new Object[] {}));
										}
									}
								}
							}
						} catch (Exception ex) {
							
						}
						if (value == null || value.equals("null") || value.equals("0") || value.equals("")) {
							value = "-";
						}
					}
			%>
			<li>
				<div class="title"><%=element.getLabel()%></div>
<%
			if(fileEntryType){
%>		
				<div class="text">
<%
					if(StringUtils.isNotBlank(filePath)){
%>				
					<a href="<%=filePath %>" target="_blank"><%=fileTitle%>&nbsp;<i class="icon-download-alt"></i></a>
<%
					}else{
%>
					<div class="text">--</div>					
<%
					}
%>
				</div>
<%
			}else{
%>		
				<div class="text"><%=value%></div>
<%
			}
%>				
			</li>
<%
		}
%>
		</ul>
	</div>
</div>
<script>
$(document).ready(function(){
	$('#<portlet:namespace/><%=form.getId()%>edit').click(function(){
		<portlet:namespace/><%=form.getId()%>editHandleOnClick(this);
	});
});

function <portlet:namespace/><%=form.getId()%>editHandleOnClick(actionSource){
	<%--window.location.href="<%=addRenderURL%>";--%>
	
	var dialogId='<portlet:namespace/><%=form.getId()%>editOpenDialog';
	var url="<%=addRenderURL%>&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog";
	var title ='<%="Add " + AnnotationUtil.getItemLabel(form.getTitle()) %>';
	var width = <%=form.getElementsPerRow()>1?960:640%>;
	var height = 540;//<%=form.getElements().size()/form.getElementsPerRow() * 84 + 100%>;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
	
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
</script>
<aui:script use="liferay-util-window">
	Liferay.provide(
		window,
		'<portlet:namespace /><%=form.getId()%>closeDialog',
		function(data) {
			//alert("after close : "+data);
			if(data){
				console.log(data);	
			}
			//alert("before updateTable()");
			var dialog = Liferay.Util.Window.getById(data.dialogId);
			dialog.destroy();
			if(data.refresh){
				window.location.reload();
			}
<%--			
			if(!(typeof data.error === "undefined")){
				<%=form.getId()%>ShowErrorAlert();
			}else if(typeof data.refresh === "undefined"){
				<%=form.getId()%>ShowSuccessAlert();
				<%=form.getId()%>updateTable();
			}
--%>
		},
		['liferay-util-window']
	);
</aui:script>
