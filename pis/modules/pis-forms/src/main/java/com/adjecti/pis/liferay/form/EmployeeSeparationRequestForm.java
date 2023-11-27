package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.EmployeeSeparationRequest;

@HtmlForm(formId="EmployeeSeparationRequestForm_123456",
entityClass=EmployeeSeparationRequest.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeTransferRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden),
	@HtmlElement(name="officeOrderNo"),
	@HtmlElement(name="separationMode", controlType=ControlType.select),
	@HtmlElement(name="separationDate", controlType=ControlType.date ),
	@HtmlElement(name="lastWorkingDate", controlType=ControlType.date),
	
	@HtmlElement(name="remark"),
	@HtmlElement(name="processFileNo", controlType = ControlType.select)
	
	/*@HtmlElement(name="emailAccess"),	
	@HtmlElement(name="digitalSigning"),	
	@HtmlElement(name="egovAccess"),	
	@HtmlElement(name="pisAccess")*/
})
public class EmployeeSeparationRequestForm {
	public EmployeeSeparationRequestForm() {
		super();
	}
}
