package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.People;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId = "EmployeeForm_123456", entityClass = Employee.class, advanceFilter = true, elements = {
		@HtmlElement(name = "employeeId", controlType = ControlType.hidden, key = true),

		@HtmlElement(name = "personalNo"),
		@HtmlElement(name = "peopleId", label = "Name", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = People.class, valueField = "peopleId", labelField = "name_En")),
		@HtmlElement(name = "emailId"),
		@HtmlElement(name = "designationId", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = Designation.class, valueField = "designationId", labelField = "name_En")),
		@HtmlElement(name = "organizationId", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = Organization.class, valueField = "organizationId", labelField = "name")),
		@HtmlElement(name = "gradeId", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = Grade.class, valueField = "gradeId", labelField = "name")),
		@HtmlElement(name = "gradeModeId", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = GradeMode.class, valueField = "gradeModeId", labelField = "name"), listable = false),
		@HtmlElement(name = "tradeId", seachable = true, controlType = ControlType.select, relation = @Relation(modelClass = Trade.class, valueField = "tradeId", labelField = "name")),
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
public class EmployeeInfoForm {
	Employee employee;

	public EmployeeInfoForm() {
		super();
	}
}
