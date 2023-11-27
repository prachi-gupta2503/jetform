<%@ include file="/init.jsp"%>

<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>

<link href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css"
	rel="stylesheet"> --%>


<portlet:renderURL var="editJoiningProcessRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/joiningProcess.jsp" />
</portlet:renderURL>



<!-- <div class="card bg-primary text-white">
	<div class="card-header">
		<div class="row">
			<div class="col-md-8">
				<h5>Employee</h5>
			</div>
			
		</div>
	</div>
</div> -->


<div class="card" style="min-height: 200px;">
	<div class="card-body">
		<%-- 	<%
			if (isApprover) {
		%>
		<%@include file="/approver_view.jsp"%>

		<%
			} else {
		%>
		<%@include file="/creater_view.jsp"%>
		<%
			}
		%> --%>
		
		<%if(portletView.equals("view")){ %>
		<%@ include file="/table_view.jsp"%>
		<%}else if(portletView.equals("appex")){ %>
		<%@ include file="/appex_view.jsp"%>
		<%}else{ %>
		<%@ include file="/who_is_who_view.jsp"%>
		<%} %>
	<div id="employeeContent">
	</div>
		

	</div>
</div>


<script>
var employees=null;		

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}


</script>


