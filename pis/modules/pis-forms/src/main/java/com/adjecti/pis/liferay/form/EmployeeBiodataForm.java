package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.pis.liferay.model.Employee;

@HtmlForm(formId="EmployeeBiodataForm_123456",
entityClass=Employee.class, advanceFilter = true,
	elements={
	//@HtmlElement(name="employeeBiodataId",controlType=ControlType.hidden, key=true),
		@HtmlElement(name="employeeId", controlType=ControlType.hidden,  key=true),
		@HtmlElement(name="bioData", controlType=ControlType.textarea, rows = 50, cols=150),
		//@HtmlElement(name="biodataFileId", label="Biodata File", controlType=ControlType.fileUpload)
	}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeBiodataForm {
	Employee employee;
	public EmployeeBiodataForm() {
		super();
	}
}
