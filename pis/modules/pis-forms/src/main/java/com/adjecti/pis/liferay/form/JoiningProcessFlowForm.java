package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.pis.liferay.model.JoiningProcess;

@HtmlForm(formId="JoiningProcessFlowForm_123456",
entityClass=JoiningProcess.class, advanceFilter = true, formFlow = true,  //template="/employee/peopleForm_add.jsp",
	elements={
		@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, key=true, formFlowKey = true),
//		@HtmlElement(name="start", label="<i class=\"fas fa-play\"></i><p>Start</p>", controlType = ControlType.form, formClass = JoiningProcessForm.class),
		@HtmlElement(name="people", label="<i class=\"fas fa-user\"></i><p>Personal</p>", controlType = ControlType.form, formClass = PeopleForm.class),
		@HtmlElement(name="address",label="<i class=\"fas fa-envelope\"></i><p>Address</p>", controlType = ControlType.list, formClass = AddressForm.class, customTemplate = "/employee/joining/joining_addresses.jsp"),
		@HtmlElement(name="education",label="<i class=\"fas fa-graduation-cap\"></i><p>Education</p>", controlType = ControlType.list, minLength = 3, maxLength = 10, formClass = EmployeeJoiningQualificationForm.class),
//		@HtmlElement(name="experience",label="<i class=\"fas fa-cog\"></i><p>Experience</p>", controlType = ControlType.list, minLength = 3, maxLength = 10, formClass = EmployeeJoiningPastExperienceForm.class),
		@HtmlElement(name="experience",label="<i class=\"fas fa-cog\"></i><p>Past Experience</p>", controlType = ControlType.form, formClass = EmployeeJoiningPastExperienceForm.class),
		@HtmlElement(name="verification",label="<i class=\"fas fa-calendar-check\"></i><p>Verification</p>", controlType = ControlType.list, minLength = 3, maxLength = 10, formClass = EmployeeVerificationForm.class),
		@HtmlElement(name="joining",label="<i class=\"fas fa-handshake\"></i><p>Joining</p>", controlType = ControlType.form, formClass = EmployeeJoiningForm.class),
		@HtmlElement(name="permission",label="<i class=\"fas fa-lock\"></i><p>Permission</p>", controlType = ControlType.form, formClass = EmployeePermissionForm.class),
		@HtmlElement(name="finish", label="<i class=\"fas fa-circle\"></i><p>Finish</p>", controlType = ControlType.form, formClass = JoiningProcessForm.class, customTemplate = "/employee/joining/joining_process_finish.jsp"),
		
})
public class JoiningProcessFlowForm {

}
