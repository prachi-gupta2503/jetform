package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.pis.liferay.model.People;

@HtmlForm(formId="ProfileImageForm_123456",
entityClass=People.class, advanceFilter = true, 
//template="/employee/peopleForm_add.jsp",
	elements={
			@HtmlElement(name="peopleId", controlType=ControlType.hidden, key=true),
			@HtmlElement(name="profileImageId", controlType=ControlType.fileUpload, accept="image/*", folder="/pis/profile/image"),
	}
)
public class ProfileImageForm {

}
