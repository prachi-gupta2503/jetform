package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.AccomodationType;
import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.model.State;
import com.adjecti.pis.liferay.model.Address;
import com.liferay.portal.kernel.model.Country;

@HtmlForm(formId="AddressForm_123456",
entityClass=Address.class, elementsPerRow = 2,
elements={
		
	@HtmlElement(name="addressId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true),
	
	@HtmlElement(name="addressLine1", maxLength = 50, required = true),
	@HtmlElement(name="addressLine2", maxLength = 50, required = true),
	@HtmlElement(name="addressLine3", maxLength = 50),
	@HtmlElement(name="city", required = true,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="stateId", controlType = ControlType.select, relation=@Relation(modelClass=State.class), required = true),
    @HtmlElement(name="districtId", controlType = ControlType.select,relation=@Relation(modelClass=District.class),depends = "stateId",required = true),
	@HtmlElement(name="countryId", controlType = ControlType.country, relation=@Relation(modelClass=Country.class), required = true),
	@HtmlElement(name="pinCode", controlType = ControlType.number, minLength = 6, maxLength = 6, required = true),
	@HtmlElement(name="accomodationTypeId", controlType = ControlType.select, relation=@Relation(modelClass=AccomodationType.class),required = true ),
	@HtmlElement(name="addressProofId",  controlType = ControlType.fileUpload, required = true,accept = "image/png, image/jpeg, application/pdf")
},
actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>")}

)


public class AddressForm {
	Address address;

	public AddressForm(Address address) {
		super();
		this.address = address;
	}
}