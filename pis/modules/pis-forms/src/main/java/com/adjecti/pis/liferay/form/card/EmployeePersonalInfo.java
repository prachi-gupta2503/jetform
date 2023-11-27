package com.adjecti.pis.liferay.form.card;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.BloodGroup;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.mdm.liferay.model.PhType;
import com.adjecti.mdm.liferay.model.Religion;
import com.adjecti.pis.liferay.model.People;
import com.liferay.portal.kernel.model.Country;

@HtmlForm(formId = "EmployeePersonalInfo_123456", title = "Personal Information", entityClass = People.class, elementsPerRow = 2, elements = {
	@HtmlElement(name="peopleId", controlType = ControlType.hidden, key = true),
	@HtmlElement(name="appellationId", listable = false, required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Appellation.class, valueField="appellationId", labelField="name")),
	@HtmlElement(name="firstName_En", label="First Name", readOnly = true, regExp=HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="middleName_En", label="Middle Name",  readOnly = true, regExp=HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="lastName_En", label="Last Name",  readOnly = true, regExp=HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="dateOfBirth", controlType = HtmlElement.ControlType.date,required = true,customTemplate = "/components/custom/dateofbirth-element.jsp"),
	@HtmlElement(name="fatherName_En", label="Father Name", regExp=HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="genderId",  required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Gender.class, valueField="genderId", labelField="name")),
	@HtmlElement(name="maritalStatusId",  required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=MaritalStatus.class, valueField="maritalStatusId", labelField="name")),
	@HtmlElement(name="casteCategoryId", required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=CasteCategory.class, valueField="casteCategoryId", labelField="name")),
	@HtmlElement(name="bloodGroupId", required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=BloodGroup.class, valueField="bloodGroupId", labelField="name")),
	@HtmlElement(name="phTypeId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=PhType.class, valueField="phTypeId", labelField="name")),	
	@HtmlElement(name="citizenshipId",  required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Country.class, valueField="countryId", labelField="name")),
	@HtmlElement(name="religionId",  required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Religion.class, valueField="religionId", labelField="name")),
	@HtmlElement(name="aadhaarNo", listable = false,minLength=12, maxLength = 12, validType = HtmlElement.ValidType.digits, required = true),
	@HtmlElement(name="panNo", listable = false,minLength=10, maxLength = 10, regExp =HtmlElement.REGEXP_PANNO, required = true),
	@HtmlElement(name="exServiceMan", label="Ex. Service Man",listable = false, controlType = ControlType.checkbox, displayWidth = "10%"),
	@HtmlElement(name="identificationMark", listable = false),
	@HtmlElement(name="identityProofId", controlType=ControlType.fileUpload, accept="image/*, application/pdf", folder="/pis/profile/idproof"),
}, actions = { @HtmlFormAction(name = HtmlFormAction.ACTION_VIEW) })
public class EmployeePersonalInfo {
	People people;

	public EmployeePersonalInfo() {
		super();
	}
}
