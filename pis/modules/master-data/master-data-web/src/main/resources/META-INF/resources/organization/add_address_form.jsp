
<%@page import="com.adjecti.mdm.liferay.form.constants.MDMFormConstant"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Address"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.service.AddressLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%! 
private final static  Log LOGGER = LogFactoryUtil.getLog("add_address_form.jsp");
%>
<% 

long addressId=0;
long organizationId = ParamUtil.getLong(request, "classPK",0);
try{
 List<Address> addresses= AddressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(), Organization.class.getName(), organizationId);

if(addresses.size()>0){
	addressId=addresses.get(0).getAddressId();
}
}catch(Exception e){
	LOGGER.error(e);
	
}	


%>
<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		<liferay-util:param name="formClass" value="<%=MDMFormConstant.ADDRESSFROM %>" />
		<liferay-util:param name="classPK" value="<%=String.valueOf(organizationId) %>" />
		<liferay-util:param name="formClassPK" value="<%=String.valueOf(addressId) %>" />
		
</liferay-util:include>