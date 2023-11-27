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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.datetime-element_jsp");
%>
<%
	String formattedInputValue="";
	
	String elementName=ParamUtil.getString(request, "elementName");
	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	
	/*if(savedValue!=null){
		formattedInputValue=DateUtils.format(savedValue, "yyyy-MM-dd");
	}*/
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}
	
	if(readOnly){
%>	
<aui:input type="<%=HtmlElement.ControlType.date.name()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" readOnly="true" >
</aui:input>

<%
	}else{
%>		
<aui:input type="<%=HtmlElement.ControlType.date.name()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>">
		
<%		
	if(htmlElement.isRequired()){
%>	
		<aui:validator name="required" />
<%
	}

	if(htmlElement.hasDateValidation()){
%>	
		<aui:validator name="custom" errorMessage="some-error">
	        function (val, fieldNode, ruleValue) {
	        	console.log(val);
	        	console.log("<%=htmlElement.getDateBefore() %>");
	        	console.log("<%=htmlElement.getDateAfter() %>");
	        	var errorMessage="";
	        	var beforeMessage="";
	        	var afterMessage="";
	        	
	            var today=new Date();
	            var mDate=new Date(val);
	            var dateBefore;
	            var dateAfter;
	            
	            var dateBeforeField="<%=htmlElement.getDateBefore()%>";
	            var dateAfterField="<%=htmlElement.getDateAfter()%>";
	            
	            var yearBefore=<%=htmlElement.getYearBefore() %>;
	            var monthBefore=<%=htmlElement.getMonthBefore() %>;
	            var dayBefore=<%=htmlElement.getDayBefore() %>;
	            var yearAfter=<%=htmlElement.getYearAfter() %>;
	            var monthAfter=<%=htmlElement.getMonthAfter() %>;
	            var dayAfter=<%=htmlElement.getDayAfter() %>;
	            
	            var beforeValid=true;
	            var afterValid=true;

				if(dateBeforeField!=""){	
					if(dateBeforeField=="{today}"){	
						dateBefore=today;				
					}else{
						console.log($("#<%=form.getElementNamespace()%><portlet:namespace/>"+dateBeforeField).val());
						dateBefore=new Date($("#<%=form.getElementNamespace()%><portlet:namespace/>"+dateBeforeField).val());
					}
					
					console.log("dateBefore : "+dateBefore + "  -  today : "+today);
					if(dateBefore.getTime() >= mDate.getTime()){
						
						if(yearBefore>0){	
	
							if(yearDiff(mDate, dateBefore) < yearBefore){
							
								if(dateBeforeField=="{today}"){
									beforeMessage=yearBefore+" years less than the current date.";
								}else{
									beforeMessage=yearBefore+" years less than the "+dateBeforeField;
								}
								
								beforeValid=false;
							}
	
						}else if(monthBefore>0){	
							if(monthDiff(mDate, dateBefore) < monthBefore ){
								beforeValid=false;
								
								if(dateBeforeField=="{today}"){
									beforeMessage=monthBefore+" months less than the current date.";
								}else{
									beforeMessage=monthBefore+" months less than the "+dateBeforeField;
								}
						
							}
	
						}else if(dayBefore>0){	
							if(dayDiff(mDate, dateBefore) < dayBefore ){
								if(dateBeforeField=="{today}"){
									beforeMessage=dayBefore+" days less than the current date.";
								}else{
									beforeMessage=dayBefore+" days less than the "+dateBeforeField;
								}
								beforeValid=false;
							}
						}
					}else{
						beforeValid=false;
						if(dateBeforeField=="{today}"){
							beforeMessage="less than current the date.";
						}else{
							beforeMessage="less than the "+dateBeforeField;
						}
					}
				}
	
				if(dateAfterField!=""){
	
					if(dateAfterField=="{today}"){	
						dateAfter=today;				
					}else{
						console.log($("#<%=form.getElementNamespace()%><portlet:namespace/>"+dateAfterField).val());
						dateAfter=new Date($("#<%=form.getElementNamespace()%><portlet:namespace/>"+dateAfterField).val());
					}
					
					console.log("dateAfter : "+dateAfter + "  -  today : "+today+", mDate : "+mDate);
					
					if(mDate.getTime() >= dateAfter.getTime()){
						if(yearAfter>0){	
							if(yearDiff(mDate, dateAfter) < yearAfter ){
								
								if(dateAfterField=="{today}"){
									afterMessage=yearAfter+" years more than the current date.";
								}else{
									afterMessage=yearAfter+" years more than the "+dateAfterField;
								}
								
								afterValid=false;
							}
	
						}else if(monthAfter>0){	
							if(monthDiff(mDate, dateAfter) < monthAfter ){

								if(dateAfterField=="{today}"){
									afterMessage=monthAfter+" months more than the current date.";
								}else{
									afterMessage=monthAfter+" months more than the "+dateAfterField;
								}
							
								afterValid=false;
							}
	
						}else if(dayAfter>0){	
							if(dayDiff(mDate, dateAfter) < dayAfter){
							
								if(dateAfterField=="{today}"){
									afterMessage=dayAfter+" days more than current date.";
								}else{
									afterMessage=dayAfter+" days more than "+dateAfterField;
								}							
								afterValid=false;
							}
						}
					}else{
						afterValid=false;
						
						if(dateAfterField=="{today}"){
							afterMessage="more than the current date.";
						}else{
							afterMessage="more than the "+dateAfterField;
						}
					}
				}
				
				if(beforeMessage!="" || afterMessage!=""){
					errorMessage="Enter a date ";
					if(beforeMessage!=""){
						errorMessage+=beforeMessage;
					}
					
					if(afterMessage!=""){
						if(beforeMessage==""){
							errorMessage+=afterMessage;
						}else{
							errorMessage+=" and "+afterMessage;
						}
					}
					
				}
				
				if(errorMessage!=""){
	        		var myFormValidator = Liferay.Form.get('<portlet:namespace /><%=form.getId()%>').formValidator;
					var _ruleData = myFormValidator.get('fieldStrings')[fieldNode.get('name')];
					//console.log( myFormValidator.get('fieldStrings'));
					console.log(_ruleData);
				
					<%--for(var i in _ruleData){
				console.log(i);
				
				if(_ruleData.<%=htmlElement.getName()%>_custom!=errorMessage){
					 --%>
					_ruleData.<%=htmlElement.getName()%>_custom = errorMessage;
					
					//myFormValidator.get('fieldStrings')[fieldNode.get('name')].errorMessage = errorMessage;
					//break;
					//}
					//}
				}
				return afterValid && beforeValid;
	    	}
	    </aui:validator>
<%
	}
%>    
</aui:input>
<%
	}
%>	