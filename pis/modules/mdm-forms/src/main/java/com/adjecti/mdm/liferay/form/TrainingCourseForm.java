package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.mdm.liferay.model.SubjectOfTraining;

@HtmlForm(formId="TrainingCourseForm_123456",
entityClass=Course.class, advanceFilter = true, title = "Training Course",
	elements={
	@HtmlElement(name="courseId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="code", seachable = true, required = true, unique=true, controlType = ControlType.number, max = 2147483647, min = 1),
	@HtmlElement(name="name", seachable = true,unique = true, required = true, regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255),
	@HtmlElement(name="subjectOfTrainingId", label = "Subject Of Training",required = true, relation=@Relation(modelClass =SubjectOfTraining.class, valueField ="subjectOfTrainingId", labelField = "trainingSubject")),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>"),
	        @HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
	})
public class TrainingCourseForm {
	Course course;
}
