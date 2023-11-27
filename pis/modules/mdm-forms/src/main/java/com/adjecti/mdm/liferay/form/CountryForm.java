package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.liferay.portal.kernel.model.Country;


@HtmlForm(formId="CountryForm_123456",template =  "/country/country_add.jsp",
entityClass=Country.class, advanceFilter = true,
	elements={
	@HtmlElement(name="countryId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="number", label="Number"),
	@HtmlElement(name="a3", label="Long Code"/*,regExp = HtmlElement.REGEXP_ALPHA_SPACE,minLength = 3, maxLength =3*/),
	@HtmlElement(name="a2", label="Short Code"/*, regExp = HtmlElement.REGEXP_ALPHA_SPACE,minLength = 2, maxLength =2*/),
	@HtmlElement(name="name",label="Country Name"/*,regExp = HtmlElement.REGEXP_ALPHA_SPACE, maxLength = 50*/),
		
},
actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"}),@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT,visible = {"deleted:2"}),
		
		}

)
public class CountryForm {
	Country country;
}
