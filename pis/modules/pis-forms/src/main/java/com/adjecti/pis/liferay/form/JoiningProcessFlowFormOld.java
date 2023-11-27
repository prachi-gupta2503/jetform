package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElementGroup;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;

@HtmlForm(formId="JoiningProcessFlowForm_123456",
entityClass=JoiningProcessFlowFormOld.class, advanceFilter = true, formFlow = true,  
//template="/employee/peopleForm_add.jsp",
	groups= {
		@HtmlElementGroup(id="1", name="Start",
		elements= {
			@HtmlElement(name="start", controlType = ControlType.form, formClass = JoiningProcessForm.class)
		}),
		
		@HtmlElementGroup(id="2", name="Personal",
		elements= {
			@HtmlElement(name="people", controlType = ControlType.form, formClass = PeopleForm.class)
		}),
		
		@HtmlElementGroup(id="3", name="Address",
		elements= {
			@HtmlElement(name="permanentAddress", controlType = ControlType.form, formClass = AddressForm.class),
			@HtmlElement(name="residenceAddress", controlType = ControlType.form, formClass = AddressForm.class)
		}),
		
		@HtmlElementGroup(id="4", name="Education",
		elements= {
			@HtmlElement(name="Education", controlType = ControlType.list, minLength = 3, maxLength = 10,
				relation=@Relation(modelClass = EmployeeSelectionForm.class, mappingClass = JoiningProcessRequestForm.class, mappingField="employeeId")) 
		})
})
public class JoiningProcessFlowFormOld {

}
