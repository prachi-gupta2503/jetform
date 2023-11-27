package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.pis.liferay.model.EmployeePost;

@HtmlForm(formId="EmployeePostForm_123456",
entityClass=EmployeePost.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeePostId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="postId", controlType=ControlType.select, relation=@Relation(modelClass = Post.class, valueField = "postId", labelField = "name_En")),
	@HtmlElement(name="fromDate", controlType=ControlType.date),
	@HtmlElement(name="toDate", controlType=ControlType.date),
	@HtmlElement(name="delegatedPostId", controlType=ControlType.select, relation=@Relation(modelClass = Post.class, valueField = "postId", labelField = "name_En"))
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeePostForm {
	EmployeePost employeePost;
	public EmployeePostForm() {
		super();
	}
}
