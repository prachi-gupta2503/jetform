package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.EmployeeTransferRequest;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeTransferRequest_123456",
entityClass=EmployeeTransferRequest.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeTransferRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden),
	@HtmlElement(name="officeOrderNo"),
	@HtmlElement(name="organizationId", label="Transfer Unit", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Organization.class, valueField="organizationId", labelField="name")),
	@HtmlElement(name="transferDate", controlType=ControlType.date ),
	@HtmlElement(name="startDateInNewUnit", label="Start Date (in new unit)", controlType=ControlType.date ),
	@HtmlElement(name="lastDateInCurrentUnit", label="Last Date (in current unit)", controlType=ControlType.date ),
	@HtmlElement(name="processFileNo", controlType = ControlType.select)
	
	/*@HtmlElement(name="emailAccess"),	
	@HtmlElement(name="digitalSigning"),	
	@HtmlElement(name="egovAccess"),	
	@HtmlElement(name="pisAccess")*/
})
public class EmployeeTransferRequestForm {
	public EmployeeTransferRequestForm() {
		super();
	}

}
