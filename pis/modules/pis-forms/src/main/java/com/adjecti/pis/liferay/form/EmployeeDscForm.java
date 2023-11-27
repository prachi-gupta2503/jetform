package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.EmployeeDsc;

@HtmlForm(formId="EmployeeDscForm_123456",
entityClass=EmployeeDsc.class, elementsPerRow = 1,

elements={
		
	@HtmlElement(name="employeeDscId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden),
	@HtmlElement(name="ofbDSCRevocationStatus",controlType = ControlType.checkbox,customTemplate = "/dsc/revoke-template.jsp", label="DSC Revoction Status" ),
	@HtmlElement(name="ofbDSCReissueStatus",controlType = ControlType.checkbox,customTemplate = "/dsc/reissue-template.jsp" ,label="DSC Reissue Status")
})

public class EmployeeDscForm {

	EmployeeDsc EmployeeDsc;

	public EmployeeDscForm(EmployeeDsc employeeDsc) {
		super();
		EmployeeDsc = employeeDsc;
	}
	
	
}
