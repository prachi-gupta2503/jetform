<%@page import="java.util.Calendar"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
Calendar calendar=Calendar.getInstance();
int min=htmlElement.getMin();
int max=htmlElement.getMax();
min=calendar.get(Calendar.YEAR);
if(max==0){
	max=calendar.get(Calendar.YEAR)+10;
}
String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
%>

<aui:select cssClass="select2-control" type="<%=htmlElement.getControlType()%>" name="<%=htmlElement.getName()%>" id="<%=htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>">
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