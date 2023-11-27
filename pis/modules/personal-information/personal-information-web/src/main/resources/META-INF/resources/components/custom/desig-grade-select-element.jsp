<%@page import="com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeModeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.JoiningModeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.common.util.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.other-info-read-only-element_jsp");
%>

<%
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

	Long employeeId=ParamUtil.getLong(request, "employeeId", 0);
	Employee employee=null;
	if(employeeId >0 ){
	employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
	}
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute(childFormNamespace+"htmlElement_"+elementName);
	
	
	
	LOGGER.info("childFormNamespace+elementName : "+(childFormNamespace+elementName));
	
	
%>
<%
	if(viewOnlyMode){
%>
		<aui:select type="<%=htmlElement.getControlType()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" disabled="true">
		</aui:select>
<%
	} else{
%>
<aui:select type="<%=htmlElement.getControlType()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" >
</aui:select>
<%} %>



<script type="text/javascript">
$("#<portlet:namespace/><%=form.getId()%><%=htmlElement.getDepends()%>").change(function(){
	
	var designationId=$("#<portlet:namespace/><%=form.getId()%><%=htmlElement.getDepends()%>").val();
	getGradeByDesignationId(designationId);
	
});
function getGradeByDesignationId(designationId){
	
	Liferay.Service(
			  '/mdm.designation/get-grades-by-designation-id',
			  {
			    designationId: designationId
			  },
			  function(obj) {
			    console.log(obj);
			    addOption(obj.gradeId,obj.name)
			  }
			);
			
}

function addOption(id,name) {
	
    optionText = name;
    optionValue = id;
    $('#<portlet:namespace/><%=childFormNamespace+elementName%>').empty();
    $('#<portlet:namespace/><%=childFormNamespace+elementName%>').append(new Option(optionText, optionValue));
}
</script>




		
   

