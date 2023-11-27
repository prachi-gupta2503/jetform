<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib prefix="chart" uri="http://liferay.com/tld/chart" %>

<%@ page import="com.liferay.frontend.taglib.chart.model.point.bar.BarChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.MultiValueColumn" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.percentage.donut.DonutChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.SingleValueColumn" %>


<%

String[] labelArray = request.getParameter("labels").split(",");
String[] valueArray = request.getParameter("values").split(",");
int chunkSize = valueArray.length/labelArray.length;

List<Integer> convertedValues = new ArrayList<Integer>();
for (String number : valueArray) {
	convertedValues.add(Integer.parseInt(number.trim()));
}

AtomicInteger counter = new AtomicInteger();

Collection<List<Integer>> result = convertedValues.stream()
    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
    .values();

BarChartConfig _barChartConfig = new BarChartConfig();



List<MultiValueColumn> valueColumn = new ArrayList<MultiValueColumn>();
	int i =0;
	for(List<Integer> valueList : result) {
		valueColumn.add(new MultiValueColumn(labelArray[i], valueList));
		i++;
	}
	_barChartConfig.addColumns(valueColumn);
	
%>


<chart:bar
  config="<%= _barChartConfig %>"
/>

