package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Cadre;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.liferay.model.Employee;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeForm_123456",
entityClass=Employee.class, advanceFilter = true, elementsPerRow = 2,
	elements={
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, key=true),
/*	@HtmlElement(name="peopleId", label="Name", seachable = true, controlType = ControlType.hidden, relation=@Relation(modelClass=People.class, labelField="name"), listable = true, link=true, linkAction="viewProfile({employeeId})"),
	@HtmlElement(name="peopleId", label="&nbsp;", controlType = ControlType.fileUpload, thumbnail = true, relation=@Relation(modelClass=People.class, labelField="profileImageId"), listable = true, link=true, linkAction="viewProfile({employeeId})"),
*/	
	@HtmlElement(name="fullName_En", label="Name", seachable = true, controlType = ControlType.hidden, listable = true, link=true, linkAction="viewProfile({employeeId})"),
	
	@HtmlElement(name="personalNo", controlType=ControlType.number, unique = true, customTemplate = "/components/custom/personal-no-element.jsp", required = true,minLength=6,maxLength = 7),

 	@HtmlElement(name="emailId", controlType = ControlType.email, required = true, readOnly = true),
 	@HtmlElement(name="designationId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Designation.class, valueField="designationId", labelField="name_En"), required = true),
/*
	@HtmlElement(name="organizationId", label="Unit", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Unit"}), customTemplate = "/components/custom/employee-unit-select-element.jsp", required = true),
	@HtmlElement(name="subOrganizationId", label="Section", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Section"}), depends = "organizationId", customTemplate = "/components/custom/employee-section-select-element.jsp", required = true),
*/
 	@HtmlElement(name="organizationId", label="Unit", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Organization.class, valueField="organizationId", labelField="name", filter = {"type:Unit"}), customTemplate = "/components/custom/employee-unit-select-element.jsp", required = true),
	@HtmlElement(name="subOrganizationId", label="Section", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Organization.class, valueField="organizationId", labelField="name", filter = {"type:Section"}), depends = "organizationId", customTemplate = "/components/custom/employee-section-select-element.jsp", required = true),
	
	@HtmlElement(name="gradeId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Grade.class, valueField="gradeId", labelField="name"), required = true,depends = "designationId", customTemplate = "/components/custom/desig-grade-select-element.jsp"),// depends = "designationId"),
	@HtmlElement(name="gradeModeId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=GradeMode.class, valueField="gradeModeId", labelField="name"), listable=false),
 	@HtmlElement(name="cadreId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Cadre.class, valueField="cadreId", labelField="name")), //depends = "designationId"),
	@HtmlElement(name="tradeId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Trade.class, valueField="tradeId", labelField="name")),
	@HtmlElement(name="dateOfJoining", controlType = ControlType.date,required = true,dateBefore="{today}"),
	@HtmlElement(name="postName", label="Post Box",required = true),
	/*	@HtmlElement(name="designationClassId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=DesignationClass.class, valueField="designationClassId", labelField="name")),
	@HtmlElement(name="designationGroupId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=DesignationGroup.class, valueField="designationGroupId", labelField="name")),
	/*@HtmlElement(name="emailAccess"),	
	@HtmlElement(name="digitalSigning"),	
	@HtmlElement(name="egovAccess"),	
	@HtmlElement(name="pisAccess")*/
}, actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW, label="<i class=\"fa fa-address-card\" aria-hidden=\"true\"></i>",applyOn = "row"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"}),@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT,visible = {"deleted:2"})}//,@HtmlFormAction(name="changeRank", label = "<i class=\"fa fa-sort\" aria-hidden=\"true\"></i>", applyOn = "row"), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)
)
public class EmployeeForm {
	Employee employee;
	public EmployeeForm() {
		super();
	}
}
