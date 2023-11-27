<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
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
	Class formClazz=null;
	boolean editMode=false;
	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	
	JetFormBuilderLocalService JetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("JetFormBuilderLocalService");
	HtmlFormWrapper form = JetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));

	Object model=form.getEntity();
	HtmlElementWrapper fkElement=form.getKeyElement();
	Set<String> dependingParents=new HashSet<String>();
%>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form-list.jsp" />
</portlet:actionURL>
<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/json.jsp" />
</portlet:resourceURL>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
				<aui:input type="hidden" name="formClass" value="<%=formClass%>"/>
<%
			if(editMode){				
%>
				<aui:input type="hidden" name="<%=fkElement.getName() %>" value="<%=formClassPK%>"/>
				<aui:input type="hidden" name="formClassPK" value="<%=formClassPK%>"/>		
<%
			}
%>				
				<div class="form-group-autofit">
					<div class="form-group-item">
						<%
							Class[] blankTypes=new Class[]{};
							Object[] blankParams=new Object[] {};
							for (HtmlElementWrapper e : form.getElements()) {
								String value="";
								if(editMode){
									try{
										Method m=formClazz.getMethod("get"+StringUtils.capitalize(e.getAttribute()), blankTypes);
										value=String.valueOf(m.invoke(model, blankParams));
									}catch(Exception ex){}
								}
								
								if(e.isControlType(HtmlElement.ControlType.select)){
						%>
							<aui:select class="form-control" type="<%=e.getControlType()%>" name="<%=e.getName()%>" id="<%=e.getName()%>" label="<%=e.getLabel()%>" placeholder="<%=e.getLabel()%>" >
						<%
									if(StringUtils.isNotEmpty(e.getPlaceHolder())){
						%>
								<aui:option value="0" label="<%=e.getPlaceHolder()%>"/>
						<%			
									}
									for(KeyValue kv:e.getListOptions()){
										boolean selected=false;
										if(StringUtils.equalsIgnoreCase(value, kv.getKey())){
											selected=true;
										}
						%>	
								<aui:option value="<%=kv.getKey() %>" label="<%=kv.getValue() %>" selected="<%=selected%>" />
						<%
									}
						%>
							</aui:select>
						<%
								}else if(e.isControlType(HtmlElement.ControlType.checkbox) || e.isControlType(HtmlElement.ControlType.radio)){
						%>
							<label for="<%=e.getName()%>"><%=e.getLabel()%></label>
							<ul style="list-style-type:none; padding-inline-start: 5px; columns: <%=e.getListOptions().size()/10 %>; -webkit-columns: <%=e.getListOptions().size()/10 %>; -moz-columns: <%=e.getListOptions().size()/10 %>;">
						<%
									for(KeyValue kv:e.getListOptions()){
										boolean checked=false;
										if(StringUtils.equalsIgnoreCase(value, kv.getKey())){
											checked=true;
										}
						%>	
									<li><aui:input type="<%=e.getControlType() %>" name="<%=e.getName()%>" id="<%=e.getName()%>"  value="<%=kv.getKey() %>" label="<%=kv.getValue() %>" checked="<%=checked %>"/></li>
						<%
									}
						%>
							</ul>
						<%
								}else{
						%>
							<aui:input class="form-control" type="<%=e.getControlType()%>" name="<%=e.getName()%>" id="<%=e.getName()%>" label="<%=e.getLabel()%>" placeholder="<%=e.getLabel()%>" value="<%=value%>" >
						<%
								if(e.isRequired()){
						%>	
							<aui:validator name="required" />
						<%
								}
						%>	
							</aui:input>
						<%
								}
						%>
							<aui:script>
							
						<%
								for(HtmlEventWrapper event:e.getEvents()){
						%>
									<%--$("#<portlet:namespace/><%=e.getName()%>").on("<%=event.getName()%>",function(){
										alert("<%=e.getName()%>");
										
									}); --%>
						<%
								}
								if(StringUtils.isNotEmpty(e.getDepends())){
									String funcName="load".concat(StringUtils.capitalize(e.getName())).concat("By").concat(e.getDependantKey());
									HtmlElementWrapper de=form.getElementByName(e.getDepends());
									if(de.isControlType(HtmlElement.ControlType.select)){
										dependingParents.add(de.getName());
										
						%>
										$("#<portlet:namespace/><%=de.getName()%>").on("change",function(){
											<%=funcName%>(this.value);
										});
										
										
										function <%=funcName%>(<%=e.getDependantKey()%>){
											AUI().use('aui-io-request', function(A){
									    		A.io.request('<%=listOptionsResourceURL%>', {
													method: 'post',
               										data: {
            	   										<portlet:namespace />elementName: '<%=e.getName()%>',
            	   										<portlet:namespace />dependantValue: <%=e.getDependantKey() %>
               										},
													on : {
														success : function() {
															var str = this.get('responseData');
															var data=$.parseJSON(str);
															reloadListOptions('#<portlet:namespace/><%=e.getName()%>',data,'key', 'value', 'Select a <%=e.getLabel() %>', '<%=value%>');
														}
													}
												});
											});
										}
										
						<%
									}
						%>
									
						<%
								}
						%>
							</aui:script>
						<%		
								
							}
						%>
					</div>
				</div>
				<div class="form-group-autofit">
					<div class="form-group-item">
						<div class="btn-group">

						<div class="btn-group-item">
							<aui:button cssClass="btn-dark btn-sm" type="submit" id="<portlet:namespace/>submit" name="<portlet:namespace/>submit" value="submit"></aui:button>
						</div>
						<div class="btn-group-item">
							<aui:button cssClass="btn-dark btn-sm" name="<portlet:namespace/>reset" value="Reset"></aui:button>
						</div>
					</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<aui:script>
	function reloadListOptions(element, list, key, label, placeHolder, value){
		$(element).empty();
		if(placeHolder!=null && placeHolder!=''){
			$(element).append($('<option>', {value : '0'}).text(placeHolder));
		}
		$.each(list, function(i, e){
			$(element).append($('<option>', {value : e[key]}).text(e[label]));
		});
		if(value!=null & value!=''){	
			$(element).val(value);
		}
	}
	$( document ).ready(function() {
<%
		if(editMode){
			for(String dep:dependingParents){
%>
		$("#<portlet:namespace/><%=dep%>").trigger("change");
<%			
			}
		}
%>
	});
</aui:script>
