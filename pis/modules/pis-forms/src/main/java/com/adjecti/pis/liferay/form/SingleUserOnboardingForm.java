package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElement.ValidType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;



@HtmlForm(formId="SingleUserOnboardingForm_123456",
entityClass=SingleUserOnboarding.class, advanceFilter = true, elementsPerRow = 2,
	elements={
	@HtmlElement(name = "singleUserRegistrationId", controlType=ControlType.hidden, key=true),
	//@HtmlElement(name = "unitId" ),//,required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Unit"})),//, depends = "unitId", customTemplate = "/components/custom/section-select-element.jsp"),
	@HtmlElement(name = "unitId",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Unit"}),customTemplate = "/components/custom/unit-select-element.jsp"),//, depends = "unitId", customTemplate = "/components/custom/section-select-element.jsp"),
	@HtmlElement(name = "personalNo", unique = true, customTemplate = "/components/custom/personal-no-element.jsp", minLength = 6, maxLength = 7, required = true,regExp = "/^[0-9]*$/"),
	@HtmlElement(name = "firstName", required = true, regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name = "middleName", regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name = "lastName",required = true, regExp =HtmlElement.REGEXP_ALPHA_SPACE),
 	@HtmlElement(name = "genderId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Gender.class, valueField="genderId", labelField="name"), required = true),
 	@HtmlElement(name = "dateOfBirth", controlType = ControlType.date, required = true,customTemplate = "/components/custom/dateofbirth-element.jsp"),
 	@HtmlElement(name = "casteCategoryId", required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=CasteCategory.class, valueField="casteCategoryId", labelField="name")),
 	@HtmlElement(name = "emailAddress", required = true,regExp = "/^[A-Za-z0-9+_.-]+@(.+)$/"),
 	@HtmlElement(name = "mobile",controlType = ControlType.phone,required = true, minLength = 10, maxLength = 10),
	
 	@HtmlElement(name = "sectionId",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Section"}), depends = "unitId", customTemplate = "/components/custom/section-select-element.jsp"),
 	@HtmlElement(name = "designationId", required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Designation.class, valueField="designationId", labelField="name_En")),
 	@HtmlElement(name = "tradeId",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Trade.class, valueField="tradeId", labelField="name")),
 	@HtmlElement(name = "gradeId", required = true,seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Grade.class, valueField="gradeId", labelField="name"), depends = "designationId", customTemplate = "/components/custom/desig-grade-select-element.jsp"),// depends = "designationId"),

	@HtmlElement(name = "dateOfJoiningOrganization", controlType = ControlType.date,required = true,dateBefore="{today}"),
	@HtmlElement(name = "dateOfJoiningUnit", controlType = ControlType.date,required = true,dateBefore="{today}"),
	@HtmlElement(name = "postBox", label="Post Box",required = true),
	@HtmlElement(name = "rank", min=0,validType = ValidType.digits,listable=false,required = true),
	@HtmlElement(name = "idamUser", controlType = ControlType.checkbox),
	@HtmlElement(name = "emailAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "digitalSigning", controlType = ControlType.checkbox),
	@HtmlElement(name = "eGovAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "pisAccess", controlType = ControlType.checkbox,readOnly=true,value="true"),
	@HtmlElement(name = "reason", controlType = ControlType.hidden),
	@HtmlElement(name="status",controlType=ControlType.hidden, label="Status",options= {"0:created","1:pending","2:approved","3:rejected","4:return for correction"}, value="0")	
},

	actions = {@HtmlFormAction(name =HtmlFormAction.ACTION_ADD, label = "Add", applyOn = "table" ),@HtmlFormAction(name =HtmlFormAction.ACTION_EDIT, label = "<i class=\"fas fa-edit\"></i>", applyOn = "row" ),@HtmlFormAction(name ="submit", label = "<i class=\"fas fa-paper-plane\" title=\"Send for Approve\"></i>", applyOn = "row"), @HtmlFormAction(name =HtmlFormAction.ACTION_DELETE, label = "<i class=\"fas fa-trash\"></i>", applyOn = "row" )})

public class SingleUserOnboardingForm {
	SingleUserOnboarding SingleUserOnboarding;
	public SingleUserOnboardingForm() {
		super();
	}
}

