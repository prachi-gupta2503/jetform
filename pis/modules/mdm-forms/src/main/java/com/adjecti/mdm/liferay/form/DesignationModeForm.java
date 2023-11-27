package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.mdm.liferay.model.DesignationMode;

@HtmlForm(formId="DesignationModeForm_123456",
entityClass=DesignationMode.class, advanceFilter = true,
	elements={
	@HtmlElement(name="designationModeId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="code", seachable = true, required = true, unique=true, controlType = ControlType.number, max = 2147483647, min = 1 ),
	@HtmlElement(name="name", seachable = true, required = true, unique=true,regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
})
public class DesignationModeForm {
	DesignationMode designationMode;
}
