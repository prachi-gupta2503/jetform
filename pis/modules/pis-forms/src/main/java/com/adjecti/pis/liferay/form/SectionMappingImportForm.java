package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.EmployeeOrganization;

@HtmlForm(formId="SectionMappingImportForm_123456", title="Import Section Mapping",
entityClass=EmployeeOrganization.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeOrganizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="personalNo", label = "Personal No"),
	@HtmlElement(name="unitCode", label = "Unit Code"),
	@HtmlElement(name="sectionCode",label = "Section Code")
})
public class SectionMappingImportForm {
	EmployeeOrganization employeeOrganization;
}
