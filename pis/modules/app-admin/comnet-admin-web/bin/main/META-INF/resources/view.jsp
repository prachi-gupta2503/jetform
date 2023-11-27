<%@page import="net.ayudh.comnet.admin.constants.MVCCommandNames"%>
<%@include file="/init.jsp" %>

 
<style>
	.selectBox{
		width:100%;
		
	}
</style> 
 <%@ include file="/list_application_user.jsp" %>
<%--  <%@ include file="/jsp/userRole.jsp" %> --%>

<%-- <liferay-ui:tabs names="User Role,User Access,Uploaders,Approvers" refresh="false" tabsValues="User Role,User Access,Uploaders,Approvers">
    <liferay-ui:section>
      
    </liferay-ui:section>
    <liferay-ui:section>
    	<%@ include file="/list_application_user.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="/jsp/uploader_role_list.jsp"  %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="/jsp/approver_role_list.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>
 --%>
<!-- personal No , Section, unit, Name -->