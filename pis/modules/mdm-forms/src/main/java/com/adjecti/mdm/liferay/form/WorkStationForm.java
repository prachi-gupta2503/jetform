package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.mdm.liferay.model.WorkStation;

@HtmlForm(formId="WorkStationForm_123456",
entityClass=WorkStation.class, advanceFilter = true,
	elements={
	@HtmlElement(name="workStationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="deskNo", seachable = true, required = true, unique=true, controlType = ControlType.number, max = 999999, min = 1 ),
	@HtmlElement(name="cabinNo", seachable = true, validType = HtmlElement.ValidType.digits, maxLength = 5),
	@HtmlElement(name="floorNo", seachable = true, validType = HtmlElement.ValidType.digits, maxLength = 3, max=100),
	@HtmlElement(name="phoneNo", seachable = true, validType = HtmlElement.ValidType.digits, minLength = 10, maxLength = 10),
	@HtmlElement(name="directNo", seachable = true, validType = HtmlElement.ValidType.digits, minLength = 10, maxLength = 10),
	@HtmlElement(name="extnNo", seachable = true, validType = HtmlElement.ValidType.digits, minLength = 3, maxLength = 5),
	//@HtmlElement(name="name", seachable = true, required = true, regExp = HtmlElement.REGEXP_NAME, maxLength = 50),
	//@HtmlElement(name="parentWorkAreaId", label="Parent WorkArea", relation=@Relation(modelClass =WorkArea.class, valueField = "workAreaId", labelField = "name")),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>")/*,
	        @HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-reply-all\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})*/
	})
public class WorkStationForm {
	WorkStation workStation;
}
