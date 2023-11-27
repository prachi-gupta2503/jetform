<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand"%>
<%@page import="net.ayudh.comnet.admin.constants.MVCCommandNames"%>
<%@include file="../init.jsp" %>

<portlet:actionURL name="<%=MVCCommandNames.USER_ASSIGN_ROLE_FORM%>" var="applicationUserRole" ></portlet:actionURL>
<div class="container mt-1">
	<div class="container">
		<aui:form action="<%=applicationUserRole%>">
			<aui:input lable="" id="applicationUserId" name="applicationUserId" type="hidden" value="${applicationUserId}"/>
			<div class="row">
				<c:if test="${dropdownProp}">
					<aui:input lable="" name="selectedRole" type="hidden" value="${selectedRole}"/>
				</c:if>
				<aui:select label="Role" name="selectedRole" disabled="${dropdownProp}" value="${selectedRole}">
					<%-- <c:forEach items="" var=""> --%>
    					<aui:option value="PIS UPLOADER">Uploader</aui:option>
						<aui:option value="PIS APPROVER">Approver</aui:option>
    				<%-- </c:forEach> --%>
				</aui:select>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<aui:select name="avalibleUnit" label="Avalible Unit" id="defaultUnit" multiple="true" size="4">
						<c:forEach items="${units}" var="unit">
    						<aui:option value="${unit.getOrganizationId()}">${unit.getName()}</aui:option>
    					</c:forEach>
					</aui:select>
				</div>
				<div class="col-sm-1">
					<div class="row mt-5">
						<a onclick="addOption()"><img alt="" src="<%=request.getContextPath()%>/image/arrow-right-square.svg" style="width:200% "></a>
					</div>
					<div class="row mt-1">
						<a onclick="removeOption()"><img alt="" src="<%=request.getContextPath()%>/image/arrow-left-square.svg" style="width:200% "></a>
					</div>	
				</div>
				<div class="col-sm-5" >
					<aui:select name="selectedUnit" label="Selected Unit" id="selectedUnit" multiple="true" size="4">
						<c:forEach items="${selectedUnits}" var="unit">
    						<aui:option value="${unit.getOrganizationId()}">${unit.getName()}</aui:option>
    					</c:forEach>
					</aui:select>
				</div>
			</div>	
			<aui:button-row>
				<aui:button type="submit" value="submit" name="submit" onclick="javascript:onSubmit(e)"></aui:button>
			</aui:button-row>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	function addOption(){
		$("#<portlet:namespace/>defaultUnit option:selected").remove().appendTo("#<portlet:namespace/>selectedUnit");
	}
	function removeOption(){
		$("#<portlet:namespace/>selectedUnit option:selected").remove().appendTo("#<portlet:namespace/>defaultUnit");	
	}
	function onSubmit() {
		$("#<portlet:namespace/>defaultUnit").children().prop("selected","true");
		$("#<portlet:namespace/>selectedUnit").children().prop("selected","true");
		
	}
</script>
