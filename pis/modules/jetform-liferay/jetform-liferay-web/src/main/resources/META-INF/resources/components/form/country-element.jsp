<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.country_element_jsp");
%>
<%
	String elementName=ParamUtil.getString(request, "elementName");

	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	List<Country> countires=CountryServiceUtil.getCountries();
	Country india=CountryServiceUtil.getCountryByA2("IN");
	if(StringUtils.isEmpty(savedValue)){
		savedValue=String.valueOf(india.getCountryId());
	}
%>
<%--cssClass="select2-control"  --%>
<aui:select type="<%=htmlElement.getControlType()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>">
<%
	for(Country c:countires){
		boolean selected=false;
		
		if(StringUtils.equalsIgnoreCase(savedValue, String.valueOf(c.getCountryId()))){
			selected=true;
		}
		//LOGGER.info("In select-element : "+htmlElement.getName()+" - "+kv.getKey()+" - selected "+selected);
%>	
		<option value="<%=c.getCountryId()%>" <%=selected?"selected":""%>><%=c.getName(Locale.US) %></option>
<%
	}
%>
</aui:select>

