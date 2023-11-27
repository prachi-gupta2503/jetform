
<%@page import="com.adjecti.pis.util.BulkOnboardUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="./init.jsp"%>


<liferay-ui:success key="entryAdded" message="entry-added" />
<liferay-ui:success key="entryDeleted" message="entry-deleted" />
<liferay-ui:error key="errorUpload" message="Sorry, Admin can upload record for his organization only " />
<liferay-ui:success key="successUpload" message="Document saved successfully!" />
<liferay-ui:error key="actionError" message="There is no valid record to process" />


<style>

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

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
<%--
For Serial Number --%> body {
	counter-reset: Count-Value;
}

table {
	border-collapse: separate;
}

tr td:first-child:before {
	counter-increment: Count-Value;
	content: counter(Count-Value);
}

table.dataTable thead th, table.dataTable tfoot th {
    font-weight: 600 !important;
}

.valign-m{
	vertical-align: middle;
}

</style>

<%
String backURL = ParamUtil.getString(request, "backURL");
if(backURL==null || backURL.equals("")){%>
		<portlet:renderURL var="backPageURL"/>
<%}else{ %>
		<c:set var="backPageURL" value='<%=backURL %>'/>
<%} %>

<portlet:actionURL name="selectedProcessed" var="selectedProcessed" />
<c:set var="requestList" value='${requestScope["requestList"]}' />

<c:set var="errorRecords" value='${requestScope["errorRecords"]}' />

<c:set var="currentAction" value='${requestScope["currentAction"]}' />

<portlet:actionURL name="selectedProcessed" var="processAll">
	<portlet:param name="action" value="${action}" />
</portlet:actionURL>

<aui:form name="performAction" action="${processAll}" id="multi-select-form" onSubmit="validateCheckboxIsChecked(event)">
	<div class="row">
	    <div class="col-12">
	    <div id="success-alert"></div>
	         <div class="card shadow rounded">
	            <div class="card-heading bg-primary text-white p-4">
	               <h3>Disclaimer</h3>
	            </div>
	            <div class="card-body p-4">
	            	<aui:field-wrapper name="disclaimer" cssClass="d-inline-block">
	            	   <aui:input type="checkbox" name="disclaimer" id="disclaimer" cssClass="valign-m" label=""><aui:validator name="required"/></aui:input>
						<label for="disclaimer">
						<span style="color: #b80c0c;font-weight: bold;">*</span>
						I confirm that, I have read, understand and agreed to the submission guidelines, 
						policies and submission declaration of the document.</label>
	            	</aui:field-wrapper>
					<aui:field-wrapper name="remarks">
					    <aui:input type="textarea" name="remarks" label="Remarks">
					    	<aui:validator name="maxLength">250</aui:validator>
					    </aui:input>
					</aui:field-wrapper>
						
					<aui:input type="hidden" name="action" value="${currentAction}"></aui:input>
					
                    <div class="row">
                        <div class="col-1 ml-auto mr-4">
                            <aui:button type="submit" value="${currentAction}"></aui:button>
                        </div>
                    </div>
                
                <div class="col-12 mt-3">
	             <div id="checkbox-alert-msg"></div>
		
		<table id="userTable" class="display table table-striped"	cellspacing="0" width="100%">
			<thead>
				<tr>
					<th class="p-0 no-sort" >Sr No </th>
					<th class="p-0 no-sort"><input type="checkbox"  id="select_all"  /></th>
					<th class="p-0">Unit</th>
					<th class="p-0">Personal No</th>
					<th class="p-0">Name</th>
					<th class="p-0">Email Address</th>
					<th class="p-0">Mobile</th>
					<th class="p-0">Updated on</th>
					<th class="p-0">Status</th>
				</tr>
			</thead>
	
			<tbody>
				<c:if test="${not empty requestList}">
					<c:forEach items="${requestList}" var="requestDto">
	
						<portlet:renderURL var="editEntryURL"
							windowState="<%=LiferayWindowState.POP_UP.toString()%>">
							<portlet:param name="mvcPath" value="/edit_entry.jsp" />
							<portlet:param name="registrationId"
								value="${requestDto.registrationRequestId}" />
						</portlet:renderURL>
						<portlet:renderURL var="detailEntryURL"
							windowState="<%=LiferayWindowState.POP_UP.toString()%>">
							<portlet:param name="mvcPath" value="/detail_entry.jsp" />
							<portlet:param name="detailRegistrationId"
								value="${requestDto.registrationRequestId}" />
						</portlet:renderURL>
						<tr id='${requestDto.registrationRequestId}'>
					    <td class="tbdata">	</td>
							<td class="tbdata">
							<!-- input form="performAction" type="checkbox" name="<portlet:namespace/>selected-request" class="checkbox" value="${requestDto.registrationRequestId}" /-->
							<aui:input type="checkbox" label="" name="selected-request" value="${requestDto.registrationRequestId}" cssClass="checkbox"></aui:input>
							</td>
							<td class="tbdata" id='${requestDto.registrationRequestId}unit'>${requestDto.unit}</td>
							<td class="tbdata" id='${requestDto.registrationRequestId}personalNo'>${requestDto.personalNo}</td>
							<td class="tbdata"><c:if test="${ not requestDto.editable }">
									<button id='${requestDto.registrationRequestId}name'
										type="button" class="btn btn-link"
										onclick='viewActionPopup("${detailEntryURL}","${requestDto.fullName}","${requestDto.registrationRequestId}","VIEW")'>${requestDto.fullName}</button>
								</c:if> <c:if test="${requestDto.editable }">
									<button id='${requestDto.registrationRequestId}name'
										type="button" class="btn btn-link"
										onclick='viewActionPopup("${editEntryURL}","Edit registration request","${requestDto.registrationRequestId}","EDIT")'>${requestDto.fullName}</button>
								</c:if></td>
							<td id='${requestDto.registrationRequestId}email'>${requestDto.emailAddress}</td>
							<td id='${requestDto.registrationRequestId}mobile'>${requestDto.mobile}</td>
							<td ><fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value = "${requestDto.modifiedDate}" /></td>
							<td id='${requestDto.registrationRequestId}status'>${requestDto.status}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty requestList}">
					<tr>
						<td colspan="9" align="center">No records to process.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
				</div>
			</div>
		</div>
	</div>
</div>	
</aui:form>

<script>
var firstPageLoad = true;
$(document).ready( function() {
		    var table=$('#userTable').DataTable({
		     "pageLength": 50,     
		     "lengthMenu": [[10, 25, 50,100,250, -1], [10, 25, 50,100,250, "All"]],
		     "aoColumnDefs": [
		   	  {
		   	     "bSortable": false,
		   	     "aTargets": ['no-sort']
		   	  }
		   	],
		    
		     "aaSorting": [[7, 'desc']],
		     "drawCallback": function( settings ) {
		    	if(firstPageLoad){
			    	 $('#select_all').prop('checked',true);
			    	 $('#userTable> tbody > tr').each(function() 
	    				{
	    	        	 	$(this).find('.checkbox').prop('checked',true);
	    				});
			    	 firstPageLoad =false;
		    	}
		     }
	} );  

    $('#select_all').on('click',function(){
    	
    	if(this.checked){
           $('#userTable> tbody > tr').each(function() 
			{
        	 	$(this).find('.checkbox').prop('checked',true);
			});
        }else{
             $('.checkbox').each(function(){
                this.checked = false;
            });
        }
    });
    
    $('.checkbox').on('click',function(){
        if($('.checkbox:checked').length == $('.checkbox').length){
            $('#select_all').prop('checked',true);
        }else{
            $('#select_all').prop('checked',false);
        }
    });
    
    $('#userTable').on( 'page.dt', function () {
	    	
    		$('#select_all').prop('checked',false);
	    	
	    	$('.checkbox').each(function(){
	            this.checked = false;
	        });
  
    });
});       
  
function validateCheckboxIsChecked(event){
	var count=0;
		$.each($('.checkbox'),function (key,entry) {
			   if ($(this).is(':checked')) {
				 count++;
			      }

   				 });
   		 if(count==0){
   			event.preventDefault();
   			$('#checkbox-alert-msg').addClass( "alert alert-danger" ).css({
								    "opacity":"500",
								    "display":"block" 
								}).text("Please select a record..."); 
							    $('#checkbox-alert-msg').fadeTo(2000, 500).slideUp(500, function() {
				                   $('#checkbox-alert-msg').slideUp(500);
			                       });
   		}
}

</script>