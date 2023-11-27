<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
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
	int alignLeft=HtmlElementGroup.Align.left.ordinal();
	int alignRight=HtmlElementGroup.Align.right.ordinal();
%>
<%
	Class formClazz=null;
	boolean editMode=false;
	Class[] blankTypes=new Class[]{};
	Object[] blankParams=new Object[] {};
	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	
	//formKey = "com.adjecti.eprocess.core.service.model.State";
	//JetFormBuilderLocalService JetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("JetFormBuilderLocalService");
	HtmlFormWrapper form = JetFormBuilderLocalServiceUtil.rendererForm(formClass);

	Object model=form.getEntity();
	HtmlElementWrapper fkElement=form.getKeyElement();
	Map<String, String> dependingParents=new HashMap<String, String>();
%>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form-list.jsp" />
</portlet:actionURL>

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/json.jsp" />
</portlet:resourceURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form-list.jsp" />
</portlet:renderURL>

<aui:script>
	
	function reloadListOptions(element, list, key, label, placeHolder, value){
		$(element).empty();
		if(placeHolder!=null && placeHolder!=''){
			$(element).append($('<option>', {value : '0'}).text(placeHolder));
		}
		$.each(list, function(i, e){
			$(element).append($('<option>', {value : e[key]}).text(e[label]));
		});
		if(value!=null & value!=''){	
			$(element).val(value);
		}
	}
	
	function renderFormList(){
		location.href='<%=formListRenderURL%>';
	}
	
	$(document).ready(function() {
<%
		for(Map.Entry<String, String> dep:dependingParents.entrySet()){
			System.out.println("function "+dep.getValue());
%>
			$("#<portlet:namespace/><%=dep.getKey()%>").on("change",function(){
				<%=dep.getValue()%>(this.value);
			});
<%	
			if(editMode){
%>
			$("#<portlet:namespace/><%=dep.getKey()%>").trigger("change");
<%			
			}
		}
%>
	});
	
	function renderForm(form){
		//initDefaultGroup();
		//initGroups();
		
		$(form).attr('action','<%=saveFormActionURL %>');
		var ph,source,template,resultHtml;
		
<%
		for(HtmlElementGroupWrapper group: form.getElementGroups()){
%>
			ph=$('#<%=group.getId()%>');
			source = $('#<%=group.getId()%>-group-elements-template').html();
			console.log(source);
			//var template = Handlebars.compile(source);
			//var resultHtml = template(group);
			$(ph).html(source);
<%
		}
%>		

		/*$.each(groups, function(i, group){
			try{
			
			var ph=$('#'+group.id);
			if(ph!=null && ph!='undefined' && ph!=''){
				var source = $('#group-elements-template').html();
				var template = Handlebars.compile(source);
				var resultHtml = template(group);
				$(ph).html(resultHtml);
			}
			}catch(e){console.log(e);}
			
		});*/
		
		ph=$('#action-buttons');
		source = $('#action-button-template').html();
		//var template = Handlebars.compile(source);
		//var resultHtml = template({});
		$(ph).html(source);
	}
	
	Handlebars.registerHelper('if_eq', function(a, b, opts) {
	    if(a === b) // Or === depending on your needs
	        return opts.fn(this);
	    else
	        return opts.inverse(this);
	});
	
	Handlebars.registerHelper('if_ne', function(a, b, opts) {
	    if(a === b) // Or === depending on your needs
	    	return opts.inverse(this);
	    else
	    	return opts.fn(this);
	});
</aui:script>


<script type="text/x-handlebars-template" id="action-button-template">
	<div class="btn-group-item">
		<aui:button cssClass="btn-dark btn-sm" type="submit" name="<portlet:namespace/>submit" value="submit"/>
	</div>
	<div class="btn-group-item">
		<aui:button cssClass="btn-dark btn-sm" type="reset" name="<portlet:namespace/>reset" value="Reset"/>
	</div>							
	<div class="btn-group-item">
		<aui:button cssClass="btn-dark btn-sm" type="button" name="<portlet:namespace/>cancel" value="Cancel" onClick="renderFormList()"/>
	</div>
</script>

	
<%@ include file="/components/form/form-default-elements-template.jsp"%>
<%@ include file="/components/form/form-group-elements-template.jsp"%>	
