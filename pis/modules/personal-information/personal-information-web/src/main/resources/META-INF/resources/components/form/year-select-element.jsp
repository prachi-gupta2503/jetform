<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.year-select-element_jsp");
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
	String savedValue=(String)request.getAttribute(childFormNamespace+elementName+ "_savedValue");
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	String selectElementName=childFormNamespace+htmlElement.getName();

	if(viewOnlyMode){
		readOnly=true;
		selectElementName+="_readOnly";
	}
	
	Calendar calendar=Calendar.getInstance();
	int min=htmlElement.getMin();
	int max=htmlElement.getMax();
	if(min==0){
		min=calendar.get(Calendar.YEAR)-10;
	}
	if(max==0){
		max=calendar.get(Calendar.YEAR)+10;
	}
	//LOGGER.info("childFormNamespace+elementName : "+(childFormNamespace+elementName)+", savedValue : "+savedValue);

%>

<aui:select type="select" name="<%=selectElementName%>"  label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" disabled="<%=readOnly %>">
<option value="">Select an option</option>
<%
	for(int y=min;y<=max;y++){
		boolean selected=false;
		if(StringUtils.equalsIgnoreCase(savedValue, String.valueOf(y))){
			selected=true;
		}
%>	
		<option value="<%=y%>" <%=selected?"selected":""%>><%=y%></option>
<%
	}
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
       	console.log("<%=htmlElement.getYearBefore() %>");
       	console.log("<%=htmlElement.getYearAfter() %>");
       	var errorMessage="";
       	var beforeMessage="";
       	var afterMessage="";
       	
        var currentYear=new Date().getFullYear();
        console.log("currentYear  :: "+ currentYear)
        var mYear=val;
        var yearBefore;
        var YearAfter;
        
        var yearBeforeField="<%=htmlElement.getYearBefore()%>";
        var yearAfterField="<%=htmlElement.getYearAfter()%>";
        
        var beforeValid=true;
        var afterValid=true;
         
        if(yearBeforeField!=""){
        	if(yearBeforeField=="{currentYear}"){	
				yearBefore=currentYear;
			}else{
				console.log($("#<portlet:namespace/><%=childFormNamespace%>"+yearBeforeField).val());
				yearBefore=new $("#<portlet:namespace/><%=childFormNamespace%>"+yearBeforeField).val();
			}
	
			if(yearBefore < mYear){
			   if(yearBeforeField=="{currentYear}"){
					beforeMessage="  less than the current year";
				}else{
					beforeMessage="less than the "+yearBeforeField;
				}
				beforeValid=false;
			}
        }

		if(yearAfterField!=""){

			if(yearAfterField=="{currentYear}"){	
				yearAfter=currentYear;				
			}else{
				console.log($("#<portlet:namespace/><%=childFormNamespace%>"+yearAfterField).val());
				yearAfter=$("#<portlet:namespace/><%=childFormNamespace%>"+yearAfterField).val();
			}
			
			
			if(yearAfter > mYear){
				console.log("yearAfter"+ yearAfter+" mYear: "+ mYear);
			   	if(yearAfterField=="{currentYear}"){
					afterMessage="more than the current year.";
				}else{
					afterMessage="more than the "+yearAfterField
				}
				afterValid=false;
			}
		}
			
		if(beforeMessage!="" || afterMessage!=""){
			errorMessage="Enter a year ";
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
			
			_ruleData.<%=htmlElement.getName()%>_custom = errorMessage;
		}
		return afterValid && beforeValid;
    }
</aui:validator>
<%
  }
%>
</aui:select>

<%
if(readOnly){
%>
<aui:input type="hidden" name="<%=childFormNamespace+htmlElement.getName()%>" value="<%=savedValue%>" />
<%	
}
%>
	        
	        