<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%
/* String elementName=ParamUtil.getString(request, "elementName");
HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	

HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
String selectElementName=form.getElementNamespace()+htmlElement.getName(); */


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

String elementName=(String)request.getAttribute(childFormNamespace+"elementName");

HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute(childFormNamespace+"htmlElement_"+elementName);
String savedValue=(String)request.getAttribute(childFormNamespace+elementName+ "_savedValue");

boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;

String selectElementName=childFormNamespace+htmlElement.getName();

if(viewOnlyMode){
	readOnly=true;
	selectElementName+="_readOnly";
}

%>

<aui:select type="<%=htmlElement.getControlType()%>" name="<%=selectElementName%>" id="<%=formId+childFormNamespace+htmlElement.getName()%>" disabled="<%=readOnly %>" label=""  >
<%@ include file="/components/form/validator-common.jsp" %>
</aui:select>
<script>
	$(document).ready(function() {
		
	   $("#<portlet:namespace/>type").change(function(){
		   console.log("<%=htmlElement.getName()%>");
		   var type=$(this).val();
		   <portlet:namespace/>loadOrganization(type)
		   //$("#<portlet:namespace/>parentOrganizationId").empty();
		  
	   });
	   <portlet:namespace/>loadOrganization()
	   
	});
	
	function <portlet:namespace/>loadOrganization(type){
		
		//var type=$(this).val();
		   var types=[];
		   
		   if(type=="Division"){
			   types[0]="Organization";
		   }
		   else if(type=="Unit"){
			   types[0]="Division";
		   }
		   else if(type=="Section"){
			   types[0]="Unit";
			   types[1]="Division"
		   }
			   console.log("types::"+types);
			 if(types.length!= 0){
				AUI().use('aui-base', function(A){
		  		 Liferay.Service(
				   '/mdm.organizationdetail/get-organization-detail-by-types',
				   {
				     type: types
				   },
				   function(response) {
					   console.log(response)
					   reloadListOptions($('#<portlet:namespace/><%=formId+childFormNamespace+htmlElement.getName()%>'), response, 'organizationId', 'name', '', '<%=savedValue%>');
						
				   }
				 );
			});
		}else{
			console.log("else condition")
			$('#<portlet:namespace/><%=htmlElement.getName()%>').empty();
		}		
	}
	
</script>