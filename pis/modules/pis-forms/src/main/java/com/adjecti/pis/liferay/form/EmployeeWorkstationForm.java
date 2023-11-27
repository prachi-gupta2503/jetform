package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.pis.liferay.model.EmployeeWorkstation;

@HtmlForm(formId="EmployeeWorkstationForm_123456",
entityClass=EmployeeWorkstation.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeWorkstationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	//@HtmlElement(name="workStationId", controlType=ControlType.select, relation=@Relation(modelClass = WorkStation.class, valueField = "workStationId", labelField = "deskNo"), required=true),
    @HtmlElement(name="deskNo", seachable = true,controlType = ControlType.number, maxLength = 6 ),
    @HtmlElement(name="phoneNo", seachable = true, validType = HtmlElement.ValidType.digits, minLength = 10, maxLength = 10),
    @HtmlElement(name="directNo", seachable = true, validType = HtmlElement.ValidType.digits, minLength = 10, maxLength = 10),
    @HtmlElement(name="extnNo", seachable = true, validType = HtmlElement.ValidType.digits, minLength = 3, maxLength = 6),
	
	//@HtmlElement(name="fromMonth", label="From Date", controlType=ControlType.date, required=true, dateBefore="{today}"),
	//@HtmlElement(name="toMonth", label="To Date", controlType=ControlType.date, dateBefore="{today}", dateAfter="fromMonth"),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeWorkstationForm {
	EmployeeWorkstation employeeWorkstation;
	public EmployeeWorkstationForm() {
		super();
	}
}
