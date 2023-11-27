<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%
//HtmlElementWrapper htmlElement;
//HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("form");
String validType=StringUtils.trim(htmlElement.getValidType());
String regExp=StringUtils.trim(htmlElement.getRegExp());
/*
LOGGER.info("htmlElement.getMinLength() : "+htmlElement.getMinLength()+" -- htmlElement.getMaxLength() : "+htmlElement.getMaxLength());
LOGGER.info("htmlElement.getMin() : "+ htmlElement.getMin() + " --  htmlElement.getMax() : "+htmlElement.getMax());
LOGGER.info("htmlElement.isUnique() : "+htmlElement.isUnique());
LOGGER.info("htmlElement.getName() : "+htmlElement.getName());
LOGGER.info("htmlElement.getRegExp() : "+regExp);
LOGGER.info("htmlElement.getValidType() : "+validType);
LOGGER.info((!StringUtils.isEmpty(regExp) && !regExp.equalsIgnoreCase("none")));
*/
%>

<%
if(htmlElement.isControlType(HtmlElement.ControlType.email)){
%>	
	<aui:validator name="email" />
<%
}

if(htmlElement.isControlType(HtmlElement.ControlType.number) || validType.equals(HtmlElement.ValidType.number.name())){
%>	
	<aui:validator name="number" />
<%
}

if(htmlElement.isControlType(HtmlElement.ControlType.phone)){
%>	
	<aui:validator name="digits" />
	<aui:validator name="minLength">10</aui:validator>
	<aui:validator name="maxLength">10</aui:validator>
<%
}

if(htmlElement.isRequired()){
%>	
	<aui:validator name="required" />
<%
}

if(validType.equals(HtmlElement.ValidType.alpha.name()) || validType.equals(HtmlElement.ValidType.alphanum.name()) || validType.equals(HtmlElement.ValidType.digits.name())){
%>	
	<aui:validator name="<%=validType%>"/>
<%
}


if(htmlElement.getMinLength()>0){
%>	
	<aui:validator name="minLength"><%=htmlElement.getMinLength()%></aui:validator>
<%
}

if(htmlElement.getMaxLength()>0){
%>	
	<aui:validator name="maxLength"><%=htmlElement.getMaxLength()%></aui:validator>
<%
}

if(htmlElement.getMin()>0){
%>	
	<aui:validator name="min"><%=htmlElement.getMin()%></aui:validator>
<%
}

if(htmlElement.getMax()>0){
%>	
	<aui:validator name="max"><%=htmlElement.getMax()%></aui:validator>
<%
}

if(htmlElement.isUnique() || (!StringUtils.isEmpty(regExp) && !regExp.equalsIgnoreCase("none"))){
%>
<aui:validator errorMessage="Invalid field value" name="custom">
   function(val, fieldNode, ruleValue) {
   
   		if(val=="" || val==<portlet:namespace/><%=htmlElement.getName()%>ValidatedValue){
			return true;
		}
		var errorMessage="";
		var uniqueValue = true;
		var validValue = true;
<%		
if(htmlElement.isUnique()){		
%>
		console.log("before func call :"+new Date());
		//checkUnique<portlet:namespace/><%=htmlElement.getName()%>(val);
	    console.log("before return :"+new Date()+", "+ <portlet:namespace/><%=htmlElement.getName()%>Unique);
	    if(<portlet:namespace/><%=htmlElement.getName()%>Unique){
	    	<portlet:namespace/><%=htmlElement.getName()%>ValidatedValue=val;
	    }
	    uniqueValue = <portlet:namespace/><%=htmlElement.getName()%>Unique;
<%
}
%>	    
	    //alert(uniqueValue);
        if(uniqueValue){
        	console.log("uniqueValue is true");
<%
			if(!StringUtils.isEmpty(regExp)){
%>        	
	        	var regex = new RegExp(<%=regExp%>);
	         	validValue = regex.test(val);
	         	if(!validValue){
	         		errorMessage="Invalid value entered.";
	         	}
<%
			}
%>         	
        }else{
        	errorMessage="Duplicate <%=htmlElement.getLabel()%>.";
        }
        
        console.log("errorMessage : "+errorMessage);
        if(!uniqueValue || !validValue){
	        var myFormValidator = Liferay.Form.get('<portlet:namespace /><%=form.getId()%>').formValidator;
			var _ruleData = myFormValidator.get('fieldStrings')[fieldNode.get('name')];
				//console.log( myFormValidator.get('fieldStrings'));
				console.log(_ruleData);
			_ruleData.<%=htmlElement.getName()%>_custom = errorMessage;	
<%--		for(var i in _ruleData){
				console.log(i);
				
				if(_ruleData.<%=htmlElement.getName()%>_custom!=errorMessage){
					
					_ruleData.<%=htmlElement.getName()%>_custom = errorMessage;
					
					//myFormValidator.get('fieldStrings')[fieldNode.get('name')].errorMessage = errorMessage;
					break;
				}
			} --%>
			return false;
		}else{
			return true;
		}
		
   }
</aui:validator>
<%	
}

//if(htmlElement.isUnique()){
%>
<%---	
	<aui:validator errorMessage="<%="Duplicate "+htmlElement.getLabel()%>" name="custom">
		function(val, fieldNode, ruleValue) {
			if(val=="" || val==<portlet:namespace/><%=htmlElement.getName()%>ValidatedValue){
				return true;
			}
			
			console.log("before func call :"+new Date());
			//checkUnique<portlet:namespace/><%=htmlElement.getName()%>(val);
	    	console.log("before return :"+new Date()+", "+ <portlet:namespace/><%=htmlElement.getName()%>Unique);
	    	if(<portlet:namespace/><%=htmlElement.getName()%>Unique){
	    		<portlet:namespace/><%=htmlElement.getName()%>ValidatedValue=val;
	    	}
	    	return <portlet:namespace/><%=htmlElement.getName()%>Unique;
	    }
	</aui:validator>
<%
//}
---%>
