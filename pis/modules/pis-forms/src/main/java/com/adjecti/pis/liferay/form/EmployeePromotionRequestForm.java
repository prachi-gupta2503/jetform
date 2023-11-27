package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.pis.liferay.model.EmployeePromotionRequest;

@HtmlForm(formId="EmployeePromotionRequestForm_123456",
entityClass=EmployeePromotionRequest.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeePromotionRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden),
	@HtmlElement(name="officeOrderNo"),
	@HtmlElement(name="designationId", label="Promoted Designation", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Designation.class, valueField="designationId", labelField="name_En")),
	@HtmlElement(name="promotionDate", controlType=ControlType.date ),
	@HtmlElement(name="promotionModeId", label="Promoted Mode", seachable = true, controlType = ControlType.select),
	@HtmlElement(name="processFileNo", controlType = ControlType.select)
	
	/*@HtmlElement(name="emailAccess"),	
	@HtmlElement(name="digitalSigning"),	
	@HtmlElement(name="egovAccess"),	
	@HtmlElement(name="pisAccess")*/
})
public class EmployeePromotionRequestForm {
	public EmployeePromotionRequestForm() {
		super();
	}
}
