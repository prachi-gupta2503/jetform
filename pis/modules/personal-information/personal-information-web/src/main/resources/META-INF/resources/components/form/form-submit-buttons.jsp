<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
String submitSaveLabel = ParamUtil.getString(request, "submit.save.label","Save");
Boolean formActionSubmit=ParamUtil.getBoolean(request, "form.action.submit",false);
boolean disabled;
String submitCancelLabel = ParamUtil.getString(request, "submit.cancel.label","Cancel");
disabled=formActionSubmit?true:false;
%>

<div class="row">
	<div class="col-md-12">
		<div class="form-group-autofit">
			<div class="form-group-item">
				<div class="btn-group">
				
					<div class="btn-group-item">
						<aui:button cssClass="bg-primary text-white" type="button" name="<%=form.getId()+"save"%>" value="<%=submitSaveLabel%>" disabled="<%=disabled %>" />
					</div>
                 
					<div class="btn-group-item">
						<aui:button cssClass="bg-secondary text-white" type="button" name="<%=form.getId()+"cancel"%>" value="<%=submitCancelLabel%>" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>