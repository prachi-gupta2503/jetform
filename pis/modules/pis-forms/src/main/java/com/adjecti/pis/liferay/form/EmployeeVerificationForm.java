package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.VerificationType;
import com.adjecti.pis.liferay.model.EmployeeVerification;

@HtmlForm(formId="EmployeeVerificationForm_123456",
entityClass=EmployeeVerification.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeVerificationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true, listable=false),
	@HtmlElement(name="verificationTypeId", controlType=ControlType.select, relation=@Relation(modelClass = VerificationType.class)),
	@HtmlElement(name="authority",maxLength = 75),
	@HtmlElement(name="documentNo", required = true, maxLength = 20),
	@HtmlElement(name="verificationDate", controlType=ControlType.date,  dateBefore="{today}"),
	@HtmlElement(name="remarks", controlType=ControlType.textarea),
	@HtmlElement(name="documentId",controlType = ControlType.fileUpload,  required = true,accept = "image/png, image/jpeg, application/pdf")
}, actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeVerificationForm {
	EmployeeVerification employeeVerification;
	public EmployeeVerificationForm() {
		super();
	}
}
