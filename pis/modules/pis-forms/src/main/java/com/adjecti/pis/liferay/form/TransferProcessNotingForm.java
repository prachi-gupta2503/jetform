package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="TransferProcessNotingForm_123456",
entityClass=OrganizationDetail.class,
	elements={
		@HtmlElement(name="transferProcessId", controlType=ControlType.hidden, key=true, formFlowKey = true),
		@HtmlElement(name="notingContent", controlType = ControlType.textEditor, required = true),
	})
public class TransferProcessNotingForm {

}
