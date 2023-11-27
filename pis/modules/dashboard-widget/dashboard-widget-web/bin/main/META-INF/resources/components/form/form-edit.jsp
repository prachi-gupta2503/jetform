<%@page import="org.apache.commons.lang.ClassUtils"%>
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
	String formClass = ParamUtil.getString(request, "formClass");
	formFactoryLocalService formFactoryLocalService=(FormFactoryLocalService) request.getAttribute("formFactoryLocalService");
	HtmlFormWrapper form = formFactoryLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
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
				
				<div class="form-group-autofit">
					<div class="form-group-item">
						<%
							for (HtmlElementWrapper e : form.getElements()) {
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
						%>	
									<aui:option value="<%=kv.getKey() %>" label="<%=kv.getValue() %>"/>
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
						%>	
									<li><aui:input type="<%=e.getControlType() %>" name="<%=e.getName()%>" id="<%=e.getName()%>"  value="<%=kv.getKey() %>" label="<%=kv.getValue() %>"/></li>
						<%
									}
						%>
							</ul>
						<%
								}else{
						%>
						<aui:input class="form-control" type="<%=e.getControlType()%>" name="<%=e.getName()%>" id="<%=e.getName()%>" label="<%=e.getLabel()%>" placeholder="<%=e.getLabel()%>" />
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
									System.out.println("==============>>>>>"+funcName);
									HtmlElementWrapper de=form.getElementByName(e.getDepends());
									if(de.isControlType(HtmlElement.ControlType.select)){
										
						%>
										$("#<portlet:namespace/><%=de.getName()%>").on("change",function(){
											//alert(this.value);
											<%=funcName%>(this.value);
										});
										
										
										function <%=funcName%>(<%=e.getDependantKey()%>){
											//alert(<%=e.getDependantKey()%>);
											AUI().use('aui-io-request', function(A){
									    		A.io.request('<%=listOptionsResourceURL%>', {
													method: 'post',
               										data: {
               											<%--<portlet:namespace />formClass: '<%=formClass%>', --%>
            	   										<portlet:namespace />elementName: '<%=e.getName()%>',
            	   										<portlet:namespace />dependantValue: <%=e.getDependantKey() %>
               										},
													on : {
														success : function() {
															
															var str = this.get('responseData');
															var data=$.parseJSON(str);
															reloadListOptions('#<portlet:namespace/><%=e.getName()%>',data,'key', 'value', 'Select a <%=e.getLabel() %>');
															/*console.log(data);
															$.each(data, function(i, e){
																console.log(i+" - "+e["key"]+" - "+e.value);
															});*/
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
	function reloadListOptions(element, list, value, label, placeHolder){
		$(element).empty();
		if(placeHolder!=null && placeHolder!=''){
			$(element).append($('<option>', {value : '0'}).text(placeHolder));
		}
		$.each(list, function(i, e){
			$(element).append($('<option>', {value : e[value]}).text(e[label]));
		});
		
	}
</aui:script>
