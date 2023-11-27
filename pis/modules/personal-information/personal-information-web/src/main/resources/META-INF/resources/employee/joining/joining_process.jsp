<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.adjecti.common.util.DateUtils"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeJoining"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeVerification"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePastExperience"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeQualification"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePermission"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.pis.liferay.model.Contact"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.pis.liferay.model.JoiningProcess"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.joining.joining_002process_jsp");

%>
<%--
<style>
<!--
.flow-tab.active .fas {
    padding: 10px 10px 10px 10px;
    border: 1px solid #00c5fb;
    font-size: 24px;
    color: #fff;
    border-radius: 22px;
    background: #00c5fb;
}

.flow-tab .fas {
    padding: 10px 10px 10px 10px;
    border: 1px solid #cdced9;
    font-size: 24px;
    color: #616274;
    border-radius: 22px;
    background: #cdced9;
}

.flow-tab .fas:hover{
	background: #00c5fb;
	border: 1px solid #00c5fb;
	color: #fff;
}
-->
</style>
 --%>
<%



String title = "New Joining";
String subTitle = "Fill all the form fields to go to the next step";
String endTitle = "Success!";
String endSubTitle = "The joining details are submitted successfully!";

JoiningProcess joiningProcess=null;
long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);
if(formFlowClassPK==0){
	Calendar date=Calendar.getInstance();
	long joiningProcessId=CounterLocalServiceUtil.increment(JoiningProcess.class.getName());
	joiningProcess=JoiningProcessLocalServiceUtil.createJoiningProcess(joiningProcessId);
	joiningProcess.setName("New Joining - "+DateUtils.format(date.getTime(), "dd-MM-yyyy"));
	joiningProcess.setProcessStatus(-2);
	joiningProcess.setCreateDate(date.getTime());
	joiningProcess.setUserId(user.getUserId());
	joiningProcess.setUserName(user.getFullName());
	JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
	formFlowClassPK=joiningProcessId;//new Date().getTime()*-1;
}else{
	joiningProcess=JoiningProcessLocalServiceUtil.getJoiningProcess(formFlowClassPK);
}
LOGGER.info("joiningProcess.getProcessStatus() : "+joiningProcess.getProcessStatus());
%>
<liferay-util:include page="/components/form/multi-step-form-flow.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formFlowClass" value="<%=PISFormConstant.JOININGPROCESSFLOWFORM%>"/>
<%
    if(formFlowClassPK!=0){
%>    
    <liferay-util:param name="formFlowClassPK" value="<%=String.valueOf(formFlowClassPK)%>"/>
<%
    }

	if(joiningProcess.getProcessStatus()>0 && joiningProcess.getProcessStatus()<4){
%>   
 	<portlet:param name="viewOnlyMode" value="true" />
<%
	}
%>	
	<liferay-util:param name="title" value="<%=title%>"/>
	<liferay-util:param name="subTitle" value="<%=subTitle%>"/>
	<liferay-util:param name="endTitle" value="<%=endTitle%>"/>
	<liferay-util:param name="endSubTitle" value="<%=endSubTitle%>"/>
	<liferay-util:param name="finishPage" value="/employee/joining/joining_process_finish.jsp"/>
	<%--liferay-util:param name="redirectUrl" value="/employee/joining/joining_process.jsp"/> --%>
</liferay-util:include>
<%--
<script>
//alert("OK before redirect ");
	window.location.href='<%=joiningProcessFormRenderURL.toString()%>';
</script>	
--%>
 <%--
<liferay-util:include page="/components/form/multi-step-form-flow.jsp" servletContext="<%=application%>">
	<liferay-util:param name="title" value="<%=title %>"/>
	<liferay-util:param name="subTitle" value="<%=subTitle %>"/>
	<liferay-util:param name="formClass" value="<%=formClass%>" />
</liferay-util:include>
 --%>