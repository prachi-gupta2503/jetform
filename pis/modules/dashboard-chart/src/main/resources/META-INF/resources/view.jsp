<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ResourceURL" %>
<%@ page import="javax.portlet.WindowState" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>


<%@ include file="/init.jsp"%>


<portlet:defineObjects />

<html>
<body>
<%
	Map<String, String> labelValueMap = new HashMap<String, String>();
	String[] labelArray = labels.split(",");
	String[] valueArray = values.split(",");
	for(int i =0 ; i<labelArray.length ; i++) {
		labelValueMap.put(labelArray[i], valueArray[i]);
	}

%>
<div class="row align-center">
  <div class="col-lg-12 text-center" >
    <label><%=name %></label>
  </div>
</div>

	<div id="tabs">
		<div class="aui-tabview-content aui-widget-bd" id="docsContent">
			<div class="aui-tabview-content-item">
				<%
					if (chart.equalsIgnoreCase("bar")) {
				%>
						<liferay-util:include page="/bar_view.jsp" servletContext="<%= application %>">
       						 <liferay-util:param name="labels" value="<%=labels %>" />
       						 <liferay-util:param name="values" value="<%= values %>" />
						</liferay-util:include>
				<%
					} else if (chart.equalsIgnoreCase("donut")) {
				%>
						<liferay-util:include page="/donut_view.jsp" servletContext="<%= application %>">
       						 <liferay-util:param name="labels" value="<%=labels %>" />
       						 <liferay-util:param name="values" value="<%= values %>" />
						</liferay-util:include>
				<%
					} else if (chart.equalsIgnoreCase("pie")) {
				%>
						<liferay-util:include page="/pie_view.jsp" servletContext="<%= application %>">
       						  <liferay-util:param name="labels" value="<%=labels %>" />
       						 <liferay-util:param name="values" value="<%= values %>" />
						</liferay-util:include>
				<%
					}
				%>
			</div>
			<div class="aui-tabview-content-item">
			</div>
		</div>
	</div>
</body>
</html>