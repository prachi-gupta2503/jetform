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
	String savedValue=StringUtils.trim((String)request.getAttribute(childFormNamespace+elementName+ "_savedValue"));
	savedValue=savedValue.equals("0")?"":savedValue;
	long savedId=0;
	
	
	
	
	switch(childFormNamespace+elementName){
		case "personalNo":
			try{
			savedValue=StringUtils.isBlank(savedValue)?employee.getPersonalNo():savedValue;	
			} catch (Exception e) {}
			break;
		case "fromOrganizationId":	
		case "organizationId":
			try{
			savedValue=OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId()).getName();
			savedId=employee.getOrganizationId();
	        } catch (Exception e) {}
			break;
			
		case "gradeId":
			try{
			savedValue=GradeLocalServiceUtil.getGrade(employee.getGradeId()).getName();
			savedId=employee.getGradeId();
	        } catch (Exception e) {}
			break;
			
		case "employeeName":
			try{
			savedValue=StringUtils.isBlank(savedValue)?employee.getFullName_En():savedValue;
	        } catch (Exception e) {}
			break;
			
		case "trade":
			try{
			savedValue=StringUtils.isBlank(savedValue)?TradeLocalServiceUtil.getTrade(employee.getTradeId()).getName():savedValue;
			savedId=employee.getTradeId();
            } catch (Exception e) {}
			break;
			
		case "designationId":
			try{
			savedValue=DesignationLocalServiceUtil.getDesignation(employee.getDesignationId()).getName_En();
			savedId=employee.getDesignationId();
            } catch (Exception e) {}
			break;
			
		case "gradeModeId":
			try{
			savedValue=GradeModeLocalServiceUtil.getGradeMode(employee.getGradeModeId()).getName();
			savedId=employee.getGradeModeId();
			} catch (Exception e) {}
			break;
			
		case "joiningDate":
			try{
			savedValue=StringUtils.isBlank(savedValue)?employee.getDateOfJoining().toInstant().toString().substring(0, 10):savedValue;
			} catch (Exception e) {}
			break;
	}
	
	LOGGER.info("childFormNamespace+elementName : "+(childFormNamespace+elementName)+", savedValue : "+savedValue);
	
	
%>

 <%-- <%
if(htmlElement.isControlType(HtmlElement.ControlType.select)){ 	
%>

<aui:select type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+htmlElement.getName()%>" id="<%=formId+childFormNamespace+htmlElement.getName()%>"  readOnly="true" label="" placeholder="  ---  ---  ---" >
<option style="color:#000000;font-weight: bold;" selected value="<%=savedId%>"><%=savedValue %></option>

</aui:select>
<%
} else{
%>  --%>
 <!--  -->
<aui:input type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="  ---  ---  ---" value="<%=savedValue%>" readOnly="true"style="color:#000000;font-weight: 800;border-style: hidden;
padding-left: 0;">
</aui:input>

 <%-- <%
} 
%> --%> 






		
   

