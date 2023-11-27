package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElement.ValidType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeePromotion;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeePromotionForm_123456",
entityClass=EmployeePromotion.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeePromotionId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId",controlType=ControlType.hidden,listable=false),
	@HtmlElement(name = "personalNo",controlType=ControlType.text,listable=false,customTemplate = "/components/custom/other-info-read-only-element.jsp" ),
	@HtmlElement(name="organizationId",label="Unit" ,required=true,controlType=ControlType.select, relation=@Relation(modelClass = Organization.class),customTemplate = "/components/custom/unit-select-element.jsp"),
	@HtmlElement(name="designationId",required=true, controlType=ControlType.select, relation=@Relation(modelClass = Designation.class, valueField = "designationId", labelField = "name_En")),
	@HtmlElement(name="gradeId",required=true, controlType=ControlType.select, relation=@Relation(modelClass = Grade.class),depends = "designationId", customTemplate = "/components/custom/desig-grade-select-element.jsp"),
	@HtmlElement(name="gradeModeId",required=true, controlType=ControlType.select, relation=@Relation(modelClass = GradeMode.class)),
	@HtmlElement(name="promotionDate", controlType=ControlType.date),
	@HtmlElement(name="promotionLetterId", controlType=ControlType.fileUpload,accept = "application/pdf"),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeePromotionForm {
	EmployeePromotion employeePromotion;
	public EmployeePromotionForm() {
		super();
	}
}
