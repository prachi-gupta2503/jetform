<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%
	String elementName=ParamUtil.getString(request, "elementName");
	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	Calendar calendar=Calendar.getInstance();
	int min=htmlElement.getMin();
	int max=htmlElement.getMax();
	if(min==0){
		min=calendar.get(Calendar.YEAR)-10;
	}
	if(max==0){
		max=calendar.get(Calendar.YEAR)+10;
	}
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}
%>

<aui:select cssClass="select2-control" type="<%=htmlElement.getControlType()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>"  label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" readOnly="<%=readOnly %>">
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
%>
</aui:select>