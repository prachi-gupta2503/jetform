package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.DesignationScope;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="DesignationScopeForm_123456",
entityClass=DesignationScope.class, advanceFilter = true,
	elements={
	@HtmlElement(name="designationScopeId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="designationId", controlType = ControlType.hidden),
	
	@HtmlElement(name="scopeType", required = true, controlType=ControlType.select, options = {"1:Orgnanization", "2:Orgnanization Type"}),
	@HtmlElement(name="scopeOrganizationId", required = true, relation=@Relation(modelClass = Organization.class, labelField = "name", valueField = "organizationId")),
	@HtmlElement(name="scopeOrganizationTypeId", controlType=ControlType.select, options = {"1:Division", "2:Unit"}),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
}, actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class DesignationScopeForm {
	DesignationScope designationScope;

	public DesignationScopeForm(DesignationScope designationScope) {
		super();
		this.designationScope = designationScope;
	}
	
}
