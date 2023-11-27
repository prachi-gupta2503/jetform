package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.pis.liferay.model.EmployeePermission;


@HtmlForm(formId = "IDAMUserPermissionForm_123456", entityClass = EmployeePermission.class, advanceFilter = true, filter = {"idamUserCreated:false"},
elements = {
	@HtmlElement(name = "employeePermissionId", controlType = ControlType.hidden, key = true),
	@HtmlElement(name = "emailAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "digitalSigning", controlType = ControlType.checkbox),
	@HtmlElement(name = "eGovAccess", controlType = ControlType.checkbox),
	@HtmlElement(name = "pisAccess", controlType = ControlType.checkbox),
}, actions = { @HtmlFormAction(name = "updatePermission", label = "Permission", applyOn = "row")})

public class IDAMUserPermissionForm {
	EmployeePermission employeePermission;

	public IDAMUserPermissionForm(EmployeePermission employeePermission) {
		super();
		this.employeePermission = employeePermission;
	}
}
