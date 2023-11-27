<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.AccomodationTypeEnum"%>
<%@page import="com.adjecti.pis.liferay.service.AddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.joining_addresses_jsp");
%>
<%

	String flowFormId=(String)request.getAttribute("flowFormId");
	HtmlFormWrapper formFlow=(HtmlFormWrapper)request.getAttribute(flowFormId);
	Address permAddress=null;
	Address resiAddress=null;
	//LOGGER.info("AccomodationTypeEnum.PARMANENT.getAccomodationTypeCode() : "+AccomodationTypeEnum.PARMANENT.getAccomodationTypeCode());
	//LOGGER.info("AccomodationTypeEnum.RESIDENCE.getAccomodationTypeCode() : "+AccomodationTypeEnum.RESIDENCE.getAccomodationTypeCode());
	long formFlowClassPK=ParamUtil.getLong(request, "formFlowClassPK",0);
	//LOGGER.info("formFlowClassPK : "+formFlowClassPK);
	if(formFlowClassPK>0){
		List<Address> result=AddressLocalServiceUtil.getAddressesByJoiningProcessId(formFlowClassPK);
		if(CollectionUtils.isNotEmpty(result)){
			//LOGGER.info("CollectionUtils.isNotEmpty(result) : ");
			for(Address a:result){
				//LOGGER.info("a.getAccomodationTypeId() : "+a.getAccomodationTypeId());
				if(a.getAddressTypeId()==AccomodationTypeEnum.PARMANENT.getAccomodationTypeCode()){
					//LOGGER.info("Permanent Address found a.getAddressId() : "+a.getAddressId());
					permAddress=a;
				}else if(a.getAddressTypeId()==AccomodationTypeEnum.RESIDENCE.getAccomodationTypeCode()){
					resiAddress=a;
					//LOGGER.info("Residence Address found a.getAddressId() : "+a.getAddressId());
				}
			}
		}
	}
%>
<%	
	
	HtmlFormWrapper formPerm=JetFormBuilderLocalServiceUtil.rendererForm(PISFormConstant.PERMANENTADDRESSFORM);
	if(permAddress!=null){	
		formPerm.setEntity(permAddress);
	}
	request.setAttribute("formId",formPerm.getId());
	request.setAttribute(formPerm.getId(), formPerm);
%>
<liferay-util:include page="/components/form/multi-step-form-add.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formTitle" value="Permanent Address" />
	<liferay-util:param name="formClass" value="<%=PISFormConstant.PERMANENTADDRESSFORM%>" />
</liferay-util:include>

<%

HtmlFormWrapper formResi=JetFormBuilderLocalServiceUtil.rendererForm(PISFormConstant.RESIDENCEADDRESSFORM);
if(resiAddress!=null){	
	formResi.setEntity(resiAddress);
}
request.setAttribute("formId",formResi.getId());
request.setAttribute(formResi.getId(), formResi);

%>

<liferay-util:include page="/components/form/multi-step-form-add.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formTitle" value="Residence Address" />
	<liferay-util:param name="formClass" value="<%=PISFormConstant.RESIDENCEADDRESSFORM%>" />
</liferay-util:include>

<script type="text/javascript">
<!--
//beforeNextOnClick is the life cycle method for next button onclick
function beforeNextOnClick(source){
	validateAndSubmitAddresses();
	return false;
}
function validateAndSubmitAddresses(){
	//alert("validated is called");
	var validated=true;
	if(!validate('<portlet:namespace/><%=formPerm.getId()%>')){
		validated=false;
	}
	if(!validate('<portlet:namespace/><%=formResi.getId()%>')){
		validated=false;
	}
	if(!validated){
		return;
	}
	submitPermanentAddressForm();//This will trigger submitResidenceAddressForm if success
	
}
function submitPermanentAddressForm(){
	var formDataJson = $('#<portlet:namespace/><%=formPerm.getId()%>').serializeFormJSON();
	formDataJson['namespace']='<portlet:namespace/>';
	formDataJson['<portlet:namespace/>formClass']='<%=PISFormConstant.PERMANENTADDRESSFORM%>';
	console.log("formDataJson");
	console.log(formDataJson);
	submitFormDataJson(formDataJson, submitResidenceAddressForm);
	
}

function submitResidenceAddressForm(){
	var formDataJson = $('#<portlet:namespace/><%=formResi.getId()%>').serializeFormJSON();
	formDataJson['namespace']='<portlet:namespace/>';
	formDataJson['<portlet:namespace/>formClass']='<%=PISFormConstant.RESIDENCEADDRESSFORM%>';
	console.log("formDataJson");
	console.log(formDataJson);
	<%--
		 <portlet:namespace/><%=formFlow.getId()%>next() has been defined in multi-step-form-list-script;
	--%>
	submitFormDataJson(formDataJson, <portlet:namespace/><%=formFlow.getId()%>next());
}

//-->
</script>
