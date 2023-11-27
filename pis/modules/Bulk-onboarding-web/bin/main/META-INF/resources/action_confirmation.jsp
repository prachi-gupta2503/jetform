<%@ include file="./init.jsp"%>
<style>

/* The Modal (background) */
.upload-registration {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	cursor: context-menu;
	color: #aaaaaa;
	float: right;
	font-size: 10px;/* font-size: 28px; */
	/* font-weight: bold; */
	text-align: center;
}


.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	/* cursor: pointer; */
}

<%--For Serial Number --%> 
body {
	counter-reset: Count-Value;
}

table {
	border-collapse: separate;
}

tr td:first-child:before {
	counter-increment: Count-Value;
	content: counter(Count-Value);
}

</style>

<div id="myModal1" class="upload-registration">
	<div class="modal-content">
		<div>
			<span class="close">&times;</span>
		</div>
		<div title="Dialog box">
			<aui:form name="myForm" action="${approveURL}">
				<div class="row">
				<div class="col">
					<aui:input type="checkbox"  name="disclaimer" id="disclaimer" cssClass="mb-0"><aui:validator name="required"/></aui:input>
					<span class="mt-0">I confirm that, I have read, understand and agreed to the submission guidelines, 
						policies and submission declaration of the document.</span>
					</div>
				</div>
				<aui:input type="textarea" name="remarks" label="Remark"required="true"></aui:input>
				<aui:input type="hidden" name="requestId" id = "requestId"></aui:input>
				<aui:input type="hidden" name="action" id ="currentAction"></aui:input>
				<aui:input type="hidden" name="taskId" id="taskId"></aui:input>
				<aui:button type="submit" value="Submit"></aui:button>
				<aui:button type="cancel" id="cancelBtn" ></aui:button>
			</aui:form>
		</div>
	</div>
</div>