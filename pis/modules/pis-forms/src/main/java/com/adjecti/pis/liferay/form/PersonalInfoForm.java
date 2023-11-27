package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.People;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId = "PersonalInfoForm_123456", title = "Personal Information", entityClass = People.class, advanceFilter = true, elements = {
		@HtmlElement(name = "peopleId", controlType = ControlType.hidden, key = true),
		
		@HtmlElement(name = "appellationId", label = "Appellation", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = Appellation.class, valueField = "appellationId", labelField = "name")),
		@HtmlElement(name="firstName_En", label="First Name(English)"),
		@HtmlElement(name="middleName_En", label="Middle Name(English)", listable = false),
		@HtmlElement(name="lastName_En", label="Last Name(English)"),
		@HtmlElement(name="fatherName_En", label="Father's Name(English)"),
		@HtmlElement(name="dateOfBirth", controlType = ControlType.date,customTemplate = "/components/custom/dateofbirth-element.jsp"),
		@HtmlElement(name="genderId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Gender.class, valueField="genderId", labelField="name")),
		@HtmlElement(name="maritalStatusId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=MaritalStatus.class, valueField="maritalStatusId", labelField="name")),
		@HtmlElement(name="aadhaarNo", listable = false,minLength=12, maxLength = 12, validType = HtmlElement.ValidType.digits, required = true),
		@HtmlElement(name="panNo", listable = false,minLength=10, maxLength = 10, regExp =HtmlElement.REGEXP_PANNO, required = true),
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
public class PersonalInfoForm {
	People people;

	public PersonalInfoForm() {
		super();
	}
}
