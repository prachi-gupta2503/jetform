package com.adjecti.pis.liferay.form.card;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.pis.liferay.model.Contact;

@HtmlForm(formId = "EmployeeContactInfo_123456", title = "Contact", entityClass = Contact.class, elements = {
		@HtmlElement(name = "contactId", controlType = ControlType.hidden, key = true),
		@HtmlElement(name="mobile", listable = false),
		@HtmlElement(name="landline", listable = false),
		@HtmlElement(name="emergencyNo", listable = true),
		@HtmlElement(name="personalEmail", seachable = true),
		@HtmlElement(name="altEmailAddress", seachable = true),
		@HtmlElement(name="facebookId", seachable = true),
		@HtmlElement(name="linkedInId", seachable = true),
		@HtmlElement(name="instagramId", seachable = true),
		/*
		 * @HtmlElement(name="designationClassId", seachable = true, controlType =
		 * ControlType.select, relation=@Relation(modelClass=DesignationClass.class,
		 * valueField="designationClassId", labelField="name")),
		 * 
		 * @HtmlElement(name="designationGroupId", seachable = true, controlType =
		 * ControlType.select, relation=@Relation(modelClass=DesignationGroup.class,
		 * valueField="designationGroupId", labelField="name")),
		 * /*@HtmlElement(name="emailAccess"),
		 * 
		 * @HtmlElement(name="digitalSigning"),
		 * 
		 * @HtmlElement(name="egovAccess"),
		 * 
		 * @HtmlElement(name="pisAccess")
		 */
}, actions = { @HtmlFormAction(name = HtmlFormAction.ACTION_VIEW) })
public class EmployeeQualificationInfoList {
	Contact contact;

	public EmployeeQualificationInfoList() {
		super();
	}
}
