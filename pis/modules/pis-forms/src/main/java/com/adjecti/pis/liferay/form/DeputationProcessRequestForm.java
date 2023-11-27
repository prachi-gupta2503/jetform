package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="DeputationProcessRequestForm_123456",
entityClass=OrganizationDetail.class,
	elements={
		@HtmlElement(name="deputationProcessRequestId", controlType=ControlType.hidden, key=true),
		@HtmlElement(name="deputationProcessId", controlType=ControlType.hidden, formFlowKey = true),
		@HtmlElement(name="employeeId",controlType=ControlType.hidden)	
	})
public class DeputationProcessRequestForm {

}
