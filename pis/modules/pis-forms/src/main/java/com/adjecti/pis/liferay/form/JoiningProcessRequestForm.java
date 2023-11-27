package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.JoiningProcessRequest;

@HtmlForm(formId="JoiningProcessRequestForm_123456",
entityClass=JoiningProcessRequest.class,
	elements={
		@HtmlElement(name="joiningProcessRequestId", controlType=ControlType.hidden, key=true),
		@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true),
		@HtmlElement(name="employeeId",controlType=ControlType.hidden)	
	})
public class JoiningProcessRequestForm {

}
