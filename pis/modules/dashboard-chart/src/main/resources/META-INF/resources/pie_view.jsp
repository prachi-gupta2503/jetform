<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib prefix="chart" uri="http://liferay.com/tld/chart" %>

<%@ page import="com.liferay.frontend.taglib.chart.model.percentage.pie.PieChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.SingleValueColumn" %>


<%

String[] labelArray = request.getParameter("labels").split(",");
String[] valueArray = request.getParameter("values").split(",");

PieChartConfig _pieChartConfig = new PieChartConfig();

for(int i =0 ; i<labelArray.length ; i++) {
	_pieChartConfig.addColumns(
	  new SingleValueColumn(labelArray[i], Integer.parseInt(valueArray[i]))
	);
}

%>


<chart:pie
  config="<%= _pieChartConfig %>"
/>


