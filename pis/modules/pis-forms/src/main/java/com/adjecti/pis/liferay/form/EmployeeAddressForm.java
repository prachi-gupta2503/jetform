package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.AccomodationType;
import com.adjecti.pis.liferay.model.EmployeeAddress;

@HtmlForm(formId="EmployeeAddressForm_123456",
entityClass=EmployeeAddress.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeAddressId",controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="accomodationTypeId", label="Address Type", controlType=ControlType.select, options  = {"1:Permanent","2:Residential"}, displayWidth = "50%"),
	@HtmlElement(name="address", label="Address", controlType = ControlType.form, formClass = AddressForm.class, mappingField="addressId", listField = "fullAddress,stateId,countryId,pinCode"),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
	/*
	@HtmlElement(name="addressLine1", required = true),
	@HtmlElement(name="addressLine2", required = true,listable = false),
	@HtmlElement(name="addressLine3",listable = false),
	@HtmlElement(name="city", required = true,listable = false),
	@HtmlElement(name="districtId",required = true, controlType = ControlType.select, relation=@Relation(modelClass=District.class),listable = false),
	@HtmlElement(name="stateId", controlType = ControlType.select, relation=@Relation(modelClass=State.class), required = true),
	@HtmlElement(name="countryId", controlType = ControlType.country, relation=@Relation(modelClass=Country.class), required = true),
	@HtmlElement(name="pinCode", controlType = ControlType.number, minLength = 6, maxLength = 6, required = true),
	@HtmlElement(name="addressProofId",  controlType = ControlType.fileUpload,listable = false)
	*/
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeAddressForm {
	EmployeeAddress employeeAddress;
	public EmployeeAddressForm() {
		super();
	}
}
