<%@ include file="/init.jsp"%>

<%
	//int groupIndex=Integer.parseInt((String)request.getAttribute("groupIndex"));
%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="form-group-autofit">
				<div class="form-group-item">
					<div class="btn-group">
						<div class="btn-group-item">
<%
	if (groupIndex > 0) {
%>
							<input type="button" name="previous" class="btn btn-secondary previous action-button action-button-prev mr-2" value="Previous" index="<%=groupIndex%>">
<%
	}
%>
							<input type="button" name="next" class="btn btn-primary next action-button action-button-next" value="Next Step" index="<%=groupIndex%>">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
