<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.service.IDAMFailedTransactionLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@ include file="/init.jsp"%>

<div class="page-wrapper">
	<div class="content container-fluid">
	<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
		<liferay-util:param name="formClass" value="<%=PISFormConstant.IDAMFAILEDTRANSACTIONFORM%>" />
	</liferay-util:include>
	</div>
</div>

<%
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
%>
<aui:script>  
var status;                                
function <portlet:namespace/><%=form.getId()%>retriggerHandleOnClick(actionSource){

var idamFailedTransactionId=$(actionSource).attr("data-key");
Liferay.Service(
  '/pis.idamfailedtransaction/update-idam-employee',
  {
    idamFailedTransactionId: idamFailedTransactionId,
  },
  function(obj) {
   if(obj){
		
		deleteIdamFailedTransaction(idamFailedTransactionId);
		console.log("Retrigger successfully");
   }else{
   		console.log("Retrigger update IDAM Employee failed");
   }
  }
);
}

function deleteIdamFailedTransaction(idamFailedTransactionId){

Liferay.Service(
  '/pis.idamfailedtransaction/delete-idam-failed-transaction',
  {
    idamFailedTransactionId: idamFailedTransactionId
  },
  function(obj) {
    console.log(obj);
  }
);
}
</aui:script>
