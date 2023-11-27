package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElementGroup;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;

@HtmlForm(formId="TransferProcessFlow_123456",
entityClass=TransferProcessFlowForm.class, advanceFilter = true, formFlow = true,
	groups= {
		@HtmlElementGroup(id="1", name="Start",
		elements= {
			@HtmlElement(name="start", controlType = HtmlElement.ControlType.form, formClass = TransferProcessForm.class)
		}),
		
		@HtmlElementGroup(id="2", name="Transfer Details",
		elements= {
			@HtmlElement(name="transferDetails", controlType = HtmlElement.ControlType.list, minLength = 3, maxLength = 10,
				relation=@Relation(modelClass = TransferProcessRequestForm.class), customTemplate = "/employee/addEmployeeToProcess.jsp") 
		}),
		@HtmlElementGroup(id="3", name="Noting",
		elements= {
			@HtmlElement(name="noting", controlType = HtmlElement.ControlType.form, formClass=TransferProcessNotingForm.class) 
		})
		
})
public class TransferProcessFlowForm {

}
