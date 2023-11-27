package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElementGroup;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="DeputationProcessFlow_123456",
entityClass=DeputationProcessFlow.class, advanceFilter = true, formFlow = true,
	groups= {
		@HtmlElementGroup(id="1", name="Start",
		elements= {
			@HtmlElement(name="start", controlType = ControlType.form, formClass = DeputationProcessForm.class)
		}),
		
		@HtmlElementGroup(id="2", name="Select Employees",
		elements= {
			@HtmlElement(name="selectEmployees", controlType = ControlType.list, minLength = 3, maxLength = 10,
				relation=@Relation(modelClass = EmployeeSelectionForm.class, mappingClass = TransferProcessRequestForm.class, mappingField="employeeId")) 
		}),
		@HtmlElementGroup(id="3", name="Deputation Details",
		elements= {
			@HtmlElement(name="DeputationDetails", controlType = ControlType.list, minLength = 3, maxLength = 10,
				relation=@Relation(modelClass = OrganizationDetail.class)) 
		})
})
public class DeputationProcessFlow {

}
