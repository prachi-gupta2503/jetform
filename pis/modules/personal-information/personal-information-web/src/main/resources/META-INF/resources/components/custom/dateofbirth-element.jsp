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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.dateofbirth-element_jsp");
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
	
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute(childFormNamespace+"htmlElement_"+elementName);
	String savedValue=StringUtils.trim((String)request.getAttribute(childFormNamespace+elementName+ "_savedValue"));
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}
	
	LOGGER.info("childFormNamespace+elementName : "+(childFormNamespace+elementName)+", savedValue : "+savedValue);
	
	if(readOnly){
%>	
<aui:input type="<%=HtmlElement.ControlType.date.name()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" readOnly="true" >
</aui:input>

<%
	}else{
%>		
<aui:input type="<%=HtmlElement.ControlType.date.name()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>">
		
<%		
	if(htmlElement.isRequired()){
%>	
		<aui:validator name="required" />
<%
	}

	%>
		<aui:validator name="custom" errorMessage="some-error">
	        function (val, fieldNode, ruleValue) {
	           console.log("val"+ val);
	        	var dateOfBirth= new Date(val);
	       		var year  = dateOfBirth.getFullYear();
  				var month = dateOfBirth.getMonth();
  				var day   = dateOfBirth.getDate();
                var validDateOfBirth  = new Date(year + 18, month, day);
	        	var currentDate=new Date();
	        	
	        	var dateofbirtheValid=true;
	        	var dateofbirthMessage="";
	        	var errorMessage="";
	        	
	        	
	        	if(yearDiff(validDateOfBirth, currentDate) < 0){
	        	   
	        	   dateofbirthMessage="at least 18 year old."
	        	   dateofbirtheValid=false;
	        	   
	        	}else if(monthDiff(validDateOfBirth, currentDate) < 0){
	        	 		
	        	 		dateofbirthMessage="at least 18 year old."
	        	   		dateofbirtheValid=false;
	        	   		
	        	}else if(dayDiff(validDateOfBirth, currentDate) < 0){
	        	
	        		dateofbirthMessage="at least 18 year old."
	        	   	dateofbirtheValid=false;
	        	}
	        	
	        	if(dateofbirthMessage!=""){
					errorMessage="Enter a date ";
					errorMessage+=dateofbirthMessage;
					console.log(errorMessage);
				}
				
				if(errorMessage!=""){
	        		var myFormValidator = Liferay.Form.get('<portlet:namespace /><%=form.getId()%>').formValidator;
					var _ruleData = myFormValidator.get('fieldStrings')[fieldNode.get('name')];
					_ruleData.<%=htmlElement.getName()%>_custom = errorMessage;
					console.log(_ruleData);
					console.log(errorMessage);
				}
				return dateofbirtheValid;
	        	
				
	    	}
	    </aui:validator>
   
</aui:input>
<%
	}
%>	
