
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adj.liferay.documentmedia.constants.MVCCommandName"%>
<%@ include file="/init.jsp"%>
	<portlet:actionURL name="<%=MVCCommandName.SETRETENTION%>"
					var="addRetentionURL">
				</portlet:actionURL>
				<%long fileId=ParamUtil.getLong(request, "fileId"); %>
				<% System.out.println(fileId);%>
<div class="p-5">
	<aui:form action="<%=addRetentionURL %>">
	     <div class="form-group-item">
			<input name="<portlet:namespace/>documentId" id="documentId" type="hidden" value="<%=fileId %>" />
		</div>
		<div class="form-check">
		<!-- <aui:input type="radio" class="form-check-input" id="radioOption1" value="option1" label="3 Months" name="radioOptions" checked="true" onClick="show1()"/> --> 
			 <input class="form-check-input" type="radio" name="<portlet:namespace/>radioOptions"
				id="radioOption1" value="3 Months" checked="true" onclick="show1()">
			<label class="form-check-label" for="radioOption1"> 3
				Months </label> 
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="<portlet:namespace/>radioOptions"
				id=radioOption2" value="6 Months" onclick="show1()"> <label
				class="form-check-label" for="radioOption2"> 6 Months </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="<portlet:namespace/>radioOptions"
				id="radioOption3" value="1 Year" onclick="show1()"> <label
				class="form-check-label" for="radioOption3"> 1 Year </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="<portlet:namespace/>radioOptions"
				id="radioOption4" value="2 Year" onclick="show1()"> <label
				class="form-check-label" for="radioOption4"> 2 Years </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="<portlet:namespace/>radioOptions"
				id="radioOption5"  onclick="show2()"> <label
				class="form-check-label" for="radioOption5"> Till Date </label>
		</div>
		<div id="demo-calendar-container" class="show">
			<br> &nbsp;<label>Date:</label>&nbsp;<input
				class="aui-date-picker" id="aui-date-picker" type="date" onChange="getDate(this.value)" name="<portlet:namespace/>date"/>
		</div>
		<div>
			<aui:button type="submit" cssClass="btn-primary btn-sm"
				value="Set"></aui:button>

		</div>
	</aui:form>
</div>

<script>
   
	var timerDate = AJS.$('#aui-date-picker').datePicker({
		overrideBrowserDefault : true,
	//dateFormat: 'yy-mm-dd'
	});

	function show2() {
		document.getElementById('demo-calendar-container').style.display = 'block';			
	}

	function show1() {
		document.getElementById('demo-calendar-container').style.display = 'none';
	}
	function getDate(dateValue){
		document.getElementById('radioOption5').setAttribute("value",dateValue);
	}
</script>
