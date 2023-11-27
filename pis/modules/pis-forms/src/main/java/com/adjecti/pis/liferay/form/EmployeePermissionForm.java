package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlForm;

import com.adjecti.jetform.annotation.HtmlElement.ControlType;


import com.adjecti.pis.liferay.model.EmployeePermission;

@HtmlForm(formId="EmployeePermissionForm_123456",
entityClass=EmployeePermission.class, elementsPerRow = 2,

elements={
		
	@HtmlElement(name="employeePermissionId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden),
	@HtmlElement(name="idamUser", controlType=ControlType.checkbox,label="Idam User"),
	@HtmlElement(name="digitalSigning", controlType=ControlType.checkbox ,label="Digital Signing"),
	@HtmlElement(name="pisAccess", controlType=ControlType.checkbox,label="Pis Access",readOnly=true,value="true"),
	@HtmlElement(name="emailAccess", controlType=ControlType.checkbox,label="Email Access"),
	@HtmlElement(name="eGovAccess", controlType=ControlType.checkbox,label="eGov Access"),
	
})

public class EmployeePermissionForm {
	EmployeePermission employeePermission;
	public EmployeePermissionForm() {
		super();
	}
}

