<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="java.util.Random"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_default_editable_list_jsp");
%>

<%
response.setHeader("Cache-Control","max-age=0");
String formIndex = ParamUtil.getString(request, "formIndex");
String formId = ParamUtil.getString(request, "formId");
String formClass=ParamUtil.getString(request, "formClass");

HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
if(form==null){
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	form = JetFormBuilderLocalServiceUtil.rendererForm(formClass);
	//request.setAttribute(formId, form);
}

request.setAttribute("formId", form.getId());
request.setAttribute(form.getId(), form);
%>
<portlet:renderURL var="documentBrowserURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-browser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="documentScannerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-scanner.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="documentAdderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-adder.jsp"/>
</portlet:renderURL>

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/json.jsp" />
</portlet:resourceURL>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>
<%
if(form.getElements().size()>0){
	
	//LOGGER.info("form.getElementsPerRow() =========================================== "+form.getElementsPerRow());
	int elementsPerRow=form.getElementsPerRow()==0?7:form.getElementsPerRow();
	String elementColClass=elementColClass="col-md-"+(12/elementsPerRow);
%>
<table id="<%=form.getId()%>dataTable">
	<thead>
		<tr>
			<th style="<%=form.isSelectable()?"width:3%;padding-right:5px;padding-bottom:15px;":"width:0%;"%>">
<%
		if(form.isSelectable()){
%>
			<input type="checkbox" name="<%=form.getId()%>selectAll" value="1">		
<%
		} 
%>	
			</th>
<%
		for (HtmlElementWrapper e : form.getElements()) {
			//LOGGER.info(e.getName()+" - "+e.isTransientElement()+" - "+e.getControlType());
			
			if(e.isControlType(HtmlElement.ControlType.hidden)){
				continue;
			}
%>
			<th style="width:<%=e.getDisplayWidth()%>; padding-right:3px;"><label for="<%=e.getName()%>"><%=e.getLabel()%></label></th>		
<%	
		}
%>
		</tr>
	<thead>
	<tbody>
<%	
	Class[] blankTypes=new Class[]{};
	Object[] blankParams=new Object[] {};
	Class formClazz=form.getEntityClass();
	for(int i=0; i<5; i++){	
%>
	<tr>
		<td style="<%=form.isSelectable()?"width:3%;padding-right:5px;padding-buttom:15px;":"width:0%;"%>">
			<%@ include file="/components/form/hidden-elements.jsp"%>
<%
		if(form.isSelectable()){
%>			
			<input type="checkbox" name="<%=form.getKeyElement().getName()%>" value="<%=(form.getPrimaryKey()!=null? String.valueOf(form.getPrimaryKey()):"0")%>">	
<%
		} 
%>			
		</td>
<%	

		for (HtmlElementWrapper e : form.getElements()) {
			//LOGGER.info(e.getName()+" - "+e.isTransientElement()+" - "+e.getControlType());
			pageContext.setAttribute("htmlElement", e);
			String value="";
			if(form.getEntity()!=null && form.getPrimaryKey()!=null){
				try{
					Method m=formClazz.getMethod("get"+StringUtils.capitalize(e.getAttribute()), blankTypes);
					value=String.valueOf(m.invoke(form.getEntity(), blankParams));
					pageContext.setAttribute(e.getName()+"_savedValue", value);
				}catch(Exception ex){}
			}
			if(e.isControlType(HtmlElement.ControlType.hidden)){
				continue;
			}
			
%>
		<td style="padding-right:5px;">
<%--			<div class="<%=elementColClass%>"> --%>
				<div class="form-group-autofit">
					<div class="form-group-item">
						<%--<label for="<%=e.getName()%>"><%=e.getLabel()%></label> --%>
<%	
		if(e.isControlType(HtmlElement.ControlType.select) || e.isControlType(HtmlElement.ControlType.multiSelect)){
%>
			<liferay-util:include page="/components/form/select-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.checkbox) || e.isControlType(HtmlElement.ControlType.radio)){
%>
			<liferay-util:include page="/components/form/checkbox-radio-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>			
<%
		}else if(e.isControlType(HtmlElement.ControlType.datetime)  || e.isControlType(HtmlElement.ControlType.date)){
%>
			<liferay-util:include page="/components/form/datetime-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.email)){
%>
			<liferay-util:include page="/components/form/email-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileUpload)){
%>	
			<liferay-util:include page="/components/form/document-upload-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
	
		}else if(e.isControlType(HtmlElement.ControlType.fileDragDrop)){

			<liferay-util:include page="/components/form/document-dragdrop-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>		
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileBrowser)){
%>
			<liferay-util:include page="/components/form/document-browser-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>		
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileScan)){
%>
			<liferay-util:include page="/components/form/document-scanner-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileUploadBrowseScan)){
%>
			<liferay-util:include page="/components/form/document-adder-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.textEditor)){
%>
			<liferay-util:include page="/components/form/editor-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.number)){
%>
			<liferay-util:include page="/components/form/number-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.phone)){
%>
			<liferay-util:include page="/components/form/phone-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.text) || e.isControlType(HtmlElement.ControlType.textarea)){
%>
			<liferay-util:include page="/components/form/text-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.currentYear)){
%>
			<liferay-util:include page="/components/form/current-year-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.year)){
%>
			<liferay-util:include page="/components/form/year-select-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.fileUploadBrowseScanView)){
%>
			<liferay-util:include page="/components/form/document-adder-viewer-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
				</div>
			</div>
		<%--</div> --%>
		</td>
<%		
	}
%>
	</tr>
<%
	}
%>
	</tbody>
	</table>
<%	
}
%>

	

		