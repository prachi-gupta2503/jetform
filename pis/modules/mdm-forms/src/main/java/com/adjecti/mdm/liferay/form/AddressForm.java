package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;

@HtmlForm(formId="AddressForm_123456",
entityClass=Address.class, advanceFilter = true,
	elements={
	@HtmlElement(name="addressId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="classPK",controlType=ControlType.hidden),
	@HtmlElement(name="classNameId",controlType=ControlType.hidden),
	@HtmlElement(name="primary",controlType=ControlType.checkbox,label = "Make Primary",listable = false),	
	@HtmlElement(name="street1", seachable = true),
	@HtmlElement(name="street2", seachable = true),
	@HtmlElement(name="street3", seachable = true),
	@HtmlElement(name="city", seachable = true),
	@HtmlElement(name="countryId", seachable = true,relation=@Relation(modelClass =Country.class, valueField = "countryId", labelField = "name"),controlType = ControlType.select),
	@HtmlElement(name="regionId", seachable = true,relation=@Relation(modelClass =Region.class, valueField = "regionId", labelField = "name"),controlType = ControlType.select),
	@HtmlElement(name="zip", seachable = true,label="Postal Code "),
	@HtmlElement(name="mailing", seachable = true,controlType=ControlType.checkbox,listable = false),
	
})
public class AddressForm {
	
	Address Address;
	
}
