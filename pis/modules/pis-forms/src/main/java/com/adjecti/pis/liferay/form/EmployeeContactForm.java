package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.pis.liferay.model.EmployeeContact;

@HtmlForm(formId="EmployeeContactForm_123456",
entityClass=EmployeeContact.class, title = "Contact Info", advanceFilter = true,
	elements={
	@HtmlElement(name="employeeContactId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="contact", label="Contact Details", controlType = ControlType.form, formClass = ContactForm.class, mappingField="contactId", listField = "fullContact")
}, actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeContactForm {
	EmployeeContact employeeContact;
	public EmployeeContactForm() {
		super();
	}
}
