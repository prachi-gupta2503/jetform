package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.People;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeSelectionForm_123456",
entityClass=Employee.class, advanceFilter = true, selectable = true,
	elements={
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, key=true),
	
	@HtmlElement(name="personalNo"),
	@HtmlElement(name="peopleId", label="Name", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=People.class, valueField="peopleId", labelField="name_En")),
	@HtmlElement(name="emailId"),
	@HtmlElement(name="designationId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Designation.class, valueField="designationId", labelField="name_En")),
	@HtmlElement(name="organizationId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Organization.class, valueField="organizationId", labelField="name")),
	/*@HtmlElement(name="emailAccess"),	
	@HtmlElement(name="digitalSigning"),	
	@HtmlElement(name="egovAccess"),	
	@HtmlElement(name="pisAccess")*/
})
public class EmployeeSelectionForm {
	Employee employee;
	public EmployeeSelectionForm() {
		super();
	}
}
