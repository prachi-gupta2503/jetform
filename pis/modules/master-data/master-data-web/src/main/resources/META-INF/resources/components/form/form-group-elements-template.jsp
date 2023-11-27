<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
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

<%

if(CollectionUtils.isNotEmpty(form.getElementGroups())){
	Class[] blankTypes=new Class[]{};
	Object[] blankParams=new Object[] {};
	Class formClazz=FormEntityCache.getFormClass(form.getFormClass());
	Class entityClazz=FormEntityCache.getFormClass(form.getEntityClass());

	if(entityClazz==Object.class){
		entityClazz=formClazz;
	}
	
	for(HtmlElementGroupWrapper group: form.getElementGroups()){
%>
		<div id="group-<%=group.getId()%>-elements" style="display:none;">
<%
	int groupColWidth = 12;
		if(group.getWidthPercentage()!=100 && group.getWidthPercentage()>1){
			groupColWidth=Math.round(12/100*group.getWidthPercentage());
		}
		int leftColWidth=(group.getAlign()==alignRight?(12-groupColWidth):0);
		int rightColWidth=(group.getAlign()==alignLeft?(12-groupColWidth):0);
		
		int elementsPerRow=group.getElementsPerRow()==0? (form.getElementsPerRow()==0?1:form.getElementsPerRow()):group.getElementsPerRow();
		if(elementsPerRow>group.getElements().size()){
			elementsPerRow=group.getElements().size();
		}
		//int elementColWidth=(12/elementsPerRow);
		String elementColClass="col-md-12";
		if(elementsPerRow>1){	
			elementColClass="col-md-"+(12/elementsPerRow);		
		}
		
		int elementCtr=0;
		if(CollectionUtils.isNotEmpty(group.getElements())){
	for (HtmlElementWrapper e : group.getElements()) {
		pageContext.setAttribute("htmlElement", e);
		String value="";
		if(form.getEntity()!=null && form.getPrimaryKey()!=null){
	try{
		Method m=entityClazz.getMethod("get"+StringUtils.capitalize(e.getAttribute()), blankTypes);
		value=String.valueOf(m.invoke(form.getEntity(), blankParams));
		pageContext.setAttribute(e.getName()+"_savedValue", value);
	}catch(Exception ex){}
		}

		if(e.isControlType(HtmlElement.ControlType.hidden)){
	continue;
		}
		
		elementCtr++;
		
		if(elementCtr==1 || elementCtr>elementsPerRow){
%>
					<div class="row">
<%
				}
%>
				<div class="<%=elementColClass%>">
					<div class="form-group-autofit">
						<div class="form-group-item">
							<label for="<%=e.getName()%>"><%=e.getLabel()%></label>
<%	
		if(e.isControlType(HtmlElement.ControlType.select) || e.isControlType(HtmlElement.ControlType.multiSelect)){
%>
			<liferay-util:include page="/components/form/select-element.jsp" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.country)){
%>
			<liferay-util:include page="/components/form/country-select.jsp" servletContext="<%=application%>">
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
<%	
				}
%>
						</div>
					</div>
				</div>
<%
				if(elementCtr==elementsPerRow){
%>		
				</div>
<%		
				}	
			}
		}	
%>
	</div>
<%		
	}
}
%>
