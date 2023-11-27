<%@ include file="/init.jsp" %>
<%@ taglib prefix="chart" uri="http://liferay.com/tld/chart" %>

<%@ page import="com.liferay.frontend.taglib.chart.model.percentage.donut.DonutChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.SingleValueColumn" %>


<%

String[] labelArray = request.getParameter("labels").split(",");
String[] valueArray = request.getParameter("values").split(",");

DonutChartConfig _donutChartConfig = new DonutChartConfig();
for(int i =0 ; i<labelArray.length ; i++) {
	_donutChartConfig.addColumns(
	  new SingleValueColumn(labelArray[i], Integer.parseInt(valueArray[i]))
	);
}

%>


<chart:donut
  config="<%= _donutChartConfig %>"
/>
