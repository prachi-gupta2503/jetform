package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.Contact;

@HtmlForm(formId="ContactForm_123456",
entityClass=Contact.class, elementsPerRow = 2,
elements={
		@HtmlElement(name="contactId", controlType=ControlType.hidden, key=true),
		@HtmlElement(name="personalEmail", required = true,regExp = "/^[A-Za-z0-9+_.-]+@(.+)$/"),
		@HtmlElement(name="altEmailAddress",regExp = "/^[A-Za-z0-9+_.-]+@(.+)$/"),
		@HtmlElement(name="landline", controlType=ControlType.phone),
		@HtmlElement(name="mobile", controlType=ControlType.phone, required = true),
		@HtmlElement(name="emergencyNo", controlType=ControlType.phone),
		@HtmlElement(name="facebookId", label="Facebook"),
		@HtmlElement(name="linkedInId", label="LinkedIn")
})
public class ContactForm {
	Contact contact;

	public ContactForm(Contact contact) {
		super();
		this.contact = contact;
	}
}
