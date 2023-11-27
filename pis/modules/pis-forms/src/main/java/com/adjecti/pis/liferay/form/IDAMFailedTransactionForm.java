package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;


@HtmlForm(formId="IdamFailedTransactionForm_123456",
entityClass=IDAMFailedTransaction.class, advanceFilter = true,selectable = true,
	elements={
	@HtmlElement(name="idamFailedTransactionId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId",relation=@Relation(modelClass =Employee.class, valueField = "employeeId", labelField = "fullName_En"),label="Employee Name"),
	@HtmlElement(name="idamUrl"),
	@HtmlElement(name="className"),
	@HtmlElement(name="attribute",tooltip = true),
	@HtmlElement(name="oldValue",tooltip=true),
	@HtmlElement(name="newValue",tooltip=true),
	@HtmlElement(name="firedon", seachable = true),
	//@HtmlElement(name="error" ,listable = false),
},
	actions = {@HtmlFormAction(name="retrigger", label="<i class=\"fa fa-repeat\" aria-hidden=\"true\"></i>",applyOn = "row")}

)
public class IDAMFailedTransactionForm {

	IDAMFailedTransaction idamFailedTransaction;

	public IDAMFailedTransactionForm() {
		super();
	
	}
	
}
