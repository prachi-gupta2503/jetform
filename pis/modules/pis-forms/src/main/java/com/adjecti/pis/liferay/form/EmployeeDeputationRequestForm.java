package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.EmployeeDeputationRequest;

@HtmlForm(formId="EmployeeDeputationRequestForm_123456",
entityClass=EmployeeDeputationRequest.class, advanceFilter = true, elementsPerRow = 2,
	elements={
	@HtmlElement(name="employeeTransferRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden),
	@HtmlElement(name="officeOrderNo"),
	@HtmlElement(name="deputatedOrganization", label="Organization (To be Deputed)"),
	@HtmlElement(name="deputationAddress"),
	@HtmlElement(name="deputationCity"),
	@HtmlElement(name="deputationState", controlType=ControlType.select),
	@HtmlElement(name="deputationStartDate", label="Deputation Date", controlType=ControlType.date ),
	@HtmlElement(name="lastDateInCurrentUnit", label="Last Date In Current Unit", controlType=ControlType.date ),
	@HtmlElement(name="processFileNo", controlType = ControlType.select)
	
	/*@HtmlElement(name="emailAccess"),	
	@HtmlElement(name="digitalSigning"),	
	@HtmlElement(name="egovAccess"),	
	@HtmlElement(name="pisAccess")*/
})
public class EmployeeDeputationRequestForm {
	public EmployeeDeputationRequestForm() {
		super();
	}
}
