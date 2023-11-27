package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.model.RegistrationRequest;

@HtmlForm(formId = "IDAMUserForm_123456", entityClass = EmployeePermission.class, advanceFilter = true, filter = {"currentState:APPROVED"},
elements = {
	@HtmlElement(name = "employeePermissionId", controlType = ControlType.hidden, key = true),
	@HtmlElement(name = "personalNo", format = "########"),
	@HtmlElement(name = "firstName"),
	@HtmlElement(name = "lastName"),
	@HtmlElement(name="designationId",controlType=ControlType.select, relation=@Relation(modelClass = Designation.class, valueField = "designationId", labelField = "name_En")),
	@HtmlElement(name = "emailAddress"),
	@HtmlElement(name = "idamUserCreated",label="User Created", controlType = ControlType.checkbox),
}, actions = {
		@HtmlFormAction(name = "recreateUser", label = "<i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>", applyOn = "row", criterias = {"idamUserCreated:No"}), @HtmlFormAction(name = "updatePermission", label = "<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>", applyOn = "row", criterias = {"idamUserCreated:Yes"}),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"}),@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT,visible = {"deleted:2"})})

public class IDAMUserForm {
	EmployeePermission employeePermission;

	public IDAMUserForm(EmployeePermission employeePermission) {
		super();
		this.employeePermission = employeePermission;
	}
}
