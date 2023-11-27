package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.model.RegistrationRequest;

@HtmlForm(formId="RegistrationRequestForm_123456",
entityClass=RegistrationRequest.class, advanceFilter = true, elementsPerRow = 2,
	elements={
	@HtmlElement(name = "registrationRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name = "unitId", controlType=ControlType.hidden),
	@HtmlElement(name = "personalNo", controlType=ControlType.number, unique = true, customTemplate = "/components/custom/personal-no-element.jsp", minLength = 6, maxLength = 7, required = true),
	@HtmlElement(name = "firstName", required = true, regExp = "/^[A-Za-z.]+$/"),
	@HtmlElement(name = "middleName", regExp = "/^[A-Za-z.]+$/"),
	@HtmlElement(name = "lastName", regExp = "/^[A-Za-z.]+$/", controlType = ControlType.hidden),
 	@HtmlElement(name = "genderId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Gender.class, valueField="genderId", labelField="name"), required = true),
 	@HtmlElement(name = "dateOfBirth", controlType = ControlType.date, required = true),
 	@HtmlElement(name = "casteCategoryId", required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=CasteCategory.class, valueField="casteCategoryId", labelField="name")),
 	@HtmlElement(name = "emailAddress", controlType = ControlType.email, required = true),
 	@HtmlElement(name = "mobile",required = true, validType = HtmlElement.ValidType.digits, minLength = 10, maxLength = 10),
	
 	@HtmlElement(name = "sectionId",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Section"})),//, depends = "unitId", customTemplate = "/components/custom/section-select-element.jsp"),
 	@HtmlElement(name = "designationId", required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Designation.class, valueField="designationId", labelField="name_En")),
 	@HtmlElement(name = "tradeId",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Trade.class, valueField="tradeId", labelField="name")),
 	@HtmlElement(name = "gradeId", required = true,seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Grade.class, valueField="gradeId", labelField="name")),// depends = "designationId"),

	@HtmlElement(name = "dateOfJoiningOrganization", controlType = ControlType.date,required = true),
	@HtmlElement(name = "dateOfJoiningUnit", controlType = ControlType.date,required = true),
	@HtmlElement(name = "postBox", label="Post Box",required = true, controlType = ControlType.hidden),
	@HtmlElement(name = "rank", controlType=ControlType.number, max=1000000),
	@HtmlElement(name = "idamUser", controlType = ControlType.checkbox),
	@HtmlElement(name = "emailAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "digitalSigning", controlType = ControlType.checkbox),
	@HtmlElement(name = "eGovAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "pisAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "status", controlType = ControlType.hidden)
	
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row"),@HtmlFormAction(name="submit", applyOn = "row", criterias = {"status:0"}), @HtmlFormAction(name="approve", applyOn = "row", criterias = {"status:1"}), @HtmlFormAction(name="reject", applyOn = "row", criterias = {"status:1"}),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row"),  @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)})
public class RegistrationRequestForm {
	RegistrationRequest registrationRequest;
	public RegistrationRequestForm() {
		super();
	}
}

