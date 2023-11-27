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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.script-element-child-form_jsp");
%>

<%
long repositoryId = themeDisplay.getScopeGroupId();
long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
int listElementCount=0;

Set<String> dependingParents=new HashSet<String>();
String redirectPage = ParamUtil.getString(request, "redirectPage","/components/list/form-list-restful.jsp");
boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
String closeFunc=ParamUtil.getString(request, "closeFunc", "");
String dialogId=ParamUtil.getString(request, "dialogId");

String formClass = ParamUtil.getString(request, "childFormClass");
if(StringUtils.isBlank(formClass)){
	formClass=(String)request.getAttribute("formClass");
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
				FormEntityCache.registerFormClass(relation.getModelClass().getClass());
			}
			
			if(relation.isValidMappingClass()){
				FormEntityCache.registerFormClass(relation.getMappingClass().getClass());
			}
			
			if(de.getRelation().isValidModelClass()){
				FormEntityCache.registerFormClass(de.getRelation().getModelClass().getClass());
			}
			
			if(de.getRelation().isValidMappingClass()){
				FormEntityCache.registerFormClass(de.getRelation().getMappingClass().getClass());
			}			
			//LOGGER.info("Creating "+childFormNamespace+de.getName()+".onChange()");				
%>
			//console.log("Creating <%=childFormNamespace+de.getName()%>.onChange()");

			$("#<portlet:namespace/><%=formId+childFormNamespace+de.getName()%>").on("change",function(){
				console.log("<%=de.getName()%> : "+this.value +", <%=htmlElement.getName()%> : "+selectedValue);
				//alert(this.value +" -");
				var entityClass='<%=relation.getModelClass()%>';
				var filterField='<%=htmlElement.getDependantKey()%>';
				var filterValue=$(this).val();
				var valueField='<%=relation.getValueField()%>';
				var labelField='<%=relation.getLabelField()%>';
				var dependingElement=$("#<portlet:namespace/><%=formId+childFormNamespace+htmlElement.getName()%>");
				var placeHolder='Select <%=htmlElement.getLabel()%>';
				var selectedValue='<%=savedValue%>';
				//alert("selectedValue : "+selectedValue);
				getListOptions(entityClass, filterField, filterValue, valueField, labelField, dependingElement, placeHolder, selectedValue);
				//<%=funcName%>(this.value);
			});		
<%
		}
	}
}

%>

	$( document ).ready(function() {
<%
		if(form.getEntity()!=null && form.getPrimaryKey()!=null){
			for(String dep:dependingParents){
%>
				$("#<portlet:namespace/><%=formId+childFormNamespace+dep%>").trigger("change");
<%			
			}
		}
%>	
		initSelect2();
	});

</aui:script>
