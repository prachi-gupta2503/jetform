package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.PostOrganization;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="PostOrganizationForm_123456",
entityClass=PostOrganization.class, advanceFilter = true,
	elements={
	@HtmlElement(name="postOrganizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="postId", controlType = ControlType.hidden),
	@HtmlElement(name="organizationId", required = true, relation=@Relation(modelClass = Organization.class, labelField = "name", valueField = "organizationId")),
	@HtmlElement(name="postBox", controlType = ControlType.checkbox),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class PostOrganizationForm {
	PostOrganization postOrganization;

	public PostOrganizationForm(PostOrganization postOrganization) {
		super();
		this.postOrganization = postOrganization;
	}
	
}
