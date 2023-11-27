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

	if(htmlElement.hasDateValidation()){
%>	
		<aui:validator name="custom" errorMessage="some-error">
	        function (val, fieldNode, ruleValue) {
	        	console.log(val+"fieldNode "+fieldNode+" ruleValue :"+ ruleValue);
	        	console.log("<%=htmlElement.getDateBefore() %>");
	        	console.log("<%=htmlElement.getDateAfter() %>");
	        	var errorMessage="";
	        	var beforeMessage="";
	        	var afterMessage="";
	        	var durationMessage="";
	        	
	            var today=new Date();
	            var mDate=new Date(val);
	            var dateBefore;
	            var dateAfter;
	            
	            var dateBeforeField="<%=htmlElement.getDateBefore()%>";
	            var dateAfterField="<%=htmlElement.getDateAfter()%>";
	            var monthBeforeFailed="<%=htmlElement.getMonthBefore()%>"
	            
	            var yearBefore='<%=htmlElement.getYearBefore() %>';
	            var monthBefore='<%=htmlElement.getMonthBefore() %>';
	            var dayBefore='<%=htmlElement.getDayBefore() %>';
	            var yearAfter='<%=htmlElement.getYearAfter() %>';
	            var monthAfter='<%=htmlElement.getMonthAfter() %>';
	            var dayAfter='<%=htmlElement.getDayAfter() %>';
	            
	            console.log("yearBefore:"+ yearBefore+ "yearAfter :"+ yearAfter+" dayBefore :"+ dayBefore);
	            
	            var beforeValid=true;
	            var afterValid=true;
	            var durationValid=true;

				if(dateBeforeField!=""){	
					if(dateBeforeField=="{today}"){	
						dateBefore=today;				
					}else{
						console.log($("#<portlet:namespace/><%=childFormNamespace%>"+dateBeforeField).val());
						dateBefore=new Date($("#<portlet:namespace/><%=childFormNamespace%>"+dateBeforeField).val());
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
							beforeMessage="less than the current date.";
						}else{
							beforeMessage="less than the "+dateBeforeField;
						}
					}
				}
	
				if(dateAfterField!=""){
	
					if(dateAfterField=="{today}"){	
						dateAfter=today;				
					}else{
					    console.log("dateAfter")
						console.log($("#<portlet:namespace/><%=childFormNamespace%>"+dateAfterField).val());
						dateAfter=new Date($("#<portlet:namespace/><%=childFormNamespace%>"+dateAfterField).val());
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
				
				
				if(monthBeforeFailed!=""){
					
					   
						console.log($("#<portlet:namespace/><%=childFormNamespace%>"+monthBeforeFailed).val());
						 monthBefore=$("#<portlet:namespace/><%=childFormNamespace%>"+monthBeforeFailed).val();
						 console.log("monthDiff::"+ monthDiff(dateAfter,mDate));
						 console.log("monthBefore::"+ monthBefore);
						 console.log("dateAfter:: "+ mDate)
						 console.log("dateBefore:: "+ dateAfter);
						 if(monthDiff(dateAfter,mDate)!=monthBefore){
						 		durationMessage="according to duration"
						 		durationValid=false;
						 }
						
				}
				
				if(beforeMessage!="" || afterMessage!="" ||  durationMessage!=""){
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
					if(durationMessage!=""){
						errorMessage+=durationMessage;
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
				return afterValid && beforeValid && durationValid;
	    	}
	    </aui:validator>
<%
	}
%>    
</aui:input>
<%
	}
%>	