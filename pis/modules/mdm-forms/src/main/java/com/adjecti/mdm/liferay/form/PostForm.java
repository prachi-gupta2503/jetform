package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Post;

@HtmlForm(formId="PostForm_123456",
entityClass=Post.class, advanceFilter = true,
	elements={
	@HtmlElement(name="postId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="name_En", label="Name(English) ", required = true),
	@HtmlElement(name="name_Hi", label="Name(Hindi) "),
	@HtmlElement(name="designationId", required = true, relation=@Relation(modelClass = Designation.class, labelField = "name_En", valueField = "designationId")),
	@HtmlElement(name="organizations", controlType = ControlType.list, mappingField="postId", formClass = PostOrganizationForm.class),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE),  @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class PostForm {
	Post post;

	public PostForm(Post post) {
		super();
		this.post = post;
	}
	
}
