package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.liferay.model.EntityWorkflow;

@HtmlForm(formId="EntityWorkflowForm_123456",
entityClass=EntityWorkflow.class, elementsPerRow = 2,
elements={
	@HtmlElement(name="entityWorkflowId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="userId", controlType=ControlType.hidden),
	@HtmlElement(name="className", required = true, controlType=ControlType.hidden),
	@HtmlElement(name="classPK", required = true, controlType=ControlType.hidden),
	@HtmlElement(name="status", required = true, controlType=ControlType.hidden),
	@HtmlElement(name="remark", required = true)
	
})
public class EntityWorkflowForm {
	EntityWorkflow entityWorkflow;

	public EntityWorkflowForm(EntityWorkflow entityWorkflow) {
		super();
		this.entityWorkflow = entityWorkflow;
	}
}
