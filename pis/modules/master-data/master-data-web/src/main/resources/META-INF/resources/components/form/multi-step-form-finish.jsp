<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
	String endTitle = ParamUtil.getString(request, "endTitle");
	String endSubTitle = ParamUtil.getString(request, "endSubTitle");
%>
<div class="form-card" style="padding: 30px;">
	<h2 class="fs-title text-center"><%=endTitle %></h2>
	<br> <br>
	<div class="row justify-content-center">
		<div class="col-3 text-center">
			<i class="fa fa-check" aria-hidden="true"
				style="color: #fff;background-color: #4caf50;font-size: 30px;border: 5px solid #4caf50;border-radius: 50%;padding: 10px; margin-bottom:50px;"></i>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col-7 text-center">
			<h5><%=endSubTitle %></h5>
		</div>
	</div>
</div>