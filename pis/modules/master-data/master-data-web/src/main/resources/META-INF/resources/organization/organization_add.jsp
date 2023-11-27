<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		</liferay-util:include>
	</div>
</div>
<%

/* String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId); */
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute("form");
String formId=(String)request.getAttribute("formId");
System.out.println("formId:: "+formId);
%>

<aui:script>
function  beforeSubmit<portlet:namespace/><%=form.getId()%>(){
	//alert("calling beforeSubmit<portlet:namespace/><%=form.getId()%>");
   var code=$("#<portlet:namespace/>expando_code").val();
   var name=$("#<portlet:namespace/>name").val();
   var type=$("#<portlet:namespace/>type").val();
   var description=$("#<portlet:namespace/>expando_longName").val();
   var parentId=$("#<portlet:namespace/><%=formId%>parentOrganizationId").val();
   var organizationId=$("#<portlet:namespace/>organizationId").val();
   var comments=$("#<portlet:namespace/>comments").val();
   //alert("organizationId : "+organizationId+ "code123   "+ code+"  name"+name +" type"+ type +" parentId"+ parentId+ "description "+ description+"comments"+ comments);
			Liferay.Service(
				  '/mdm.organizationdetail/save-organization',
 				 {
				    organizationId: organizationId ,
				    code: code,
				    name: name,
				    description: description,
				    type: type,
				    parentId: parentId,
				    comments: comments
					},
				  function(obj) {
				
				    <portlet:namespace/><%=form.getId()%>OnSaveSuccess(obj); 
				  }
);
  return false;
}
		
		
		
</aui:script> 