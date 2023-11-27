package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElementGroup;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.BloodGroup;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.mdm.liferay.model.PhType;
import com.adjecti.mdm.liferay.model.Religion;
import com.adjecti.pis.liferay.model.People;
import com.liferay.portal.kernel.model.Country;

@HtmlForm(formId="PeopleForm_123456",
entityClass=People.class, advanceFilter = true, 
//template="/employee/peopleForm_add.jsp",
elementsPerRow=3,
	elements={
	@HtmlElement(name="peopleId", controlType=HtmlElement.ControlType.hidden, key=true),
	@HtmlElement(name="joiningProcessId", controlType=HtmlElement.ControlType.hidden, formFlowKey = true),
	/*
	@HtmlElement(name="blank", label="&nbsp;", controlType=ControlType.paragraph),
	@HtmlElement(name="blank1", label="&nbsp;", controlType=ControlType.paragraph),
	@HtmlElement(name="blank2", label="&nbsp;", controlType=ControlType.paragraph),*/
	@HtmlElement(name="appellationId", controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=Appellation.class, valueField="appellationId", labelField="name"), required = true),
	@HtmlElement(name="paragraph1", label="&nbsp;", controlType=HtmlElement.ControlType.paragraph),
	@HtmlElement(name="profileImageId", label="&nbsp;", controlType=HtmlElement.ControlType.fileUpload, thumbnail = true, value="/images/passport.png", width = 132, height = 170, accept = "image/*"),
	
},
			
	groups= {
			
			@HtmlElementGroup(id="appellationGroup", name="appellationGroup", elementsPerRow=3,
				elements= {
					
				//@HtmlElement(name="appellationId", controlType = ControlType.select, relation=@Relation(modelClass=Appellation.class, valueField="appellationId", labelField="name")),
				@HtmlElement(name="firstName_En", label="First Name(English)", maxLength = 50, required = true,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
				@HtmlElement(name="middleName_En", label="Middle Name(English)", listable = false, maxLength = 50,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
				@HtmlElement(name="lastName_En", label="Last Name(English)", maxLength = 50,regExp =HtmlElement.REGEXP_ALPHA_SPACE),

				
			}),
			@HtmlElementGroup(id="nameEnGroup", name="nameEnGroup", elementsPerRow=3,
		elements= {
			@HtmlElement(name="firstName_Hi", label="First Name(Hindi)", listable = false, maxLength = 50),
			@HtmlElement(name="middleName_Hi", label="Middle Name(Hindi)", listable = false, maxLength = 50),
			@HtmlElement(name="lastName_Hi", label="Last Name(Hindi)", listable = false, maxLength = 50),	
		}),
		@HtmlElementGroup(id="fatherName", name="fatherName", elementsPerRow=2,
		elements= {
			@HtmlElement(name="fatherName_En", label="Father's Name(English)", maxLength = 75,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
			@HtmlElement(name="fatherName_Hi", label="Father's Name(Hindi)", listable = false, maxLength = 75),
		}),
		@HtmlElementGroup(id="nameHiGroup", name="nameHiGroup", elementsPerRow=3,
		elements= {
			@HtmlElement(name="dateOfBirth", controlType = HtmlElement.ControlType.date,required = true,customTemplate = "/components/custom/dateofbirth-element.jsp"),
			@HtmlElement(name="genderId", seachable = true, controlType = HtmlElement.ControlType. select, relation=@Relation(modelClass=Gender.class),required = true),
			@HtmlElement(name="maritalStatusId", seachable = true, controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=MaritalStatus.class), required = true),
		}),

		@HtmlElementGroup(id="demoGraph1", name="demoGraph1", elementsPerRow=3,
		elements= {
			//@HtmlElement(name="casteCategoryId", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=CasteCategory.class, valueField="casteCategoryId", labelField="name"), listable = false, required = true),
			@HtmlElement(name="casteCategoryId", seachable = true, controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=CasteCategory.class), listable = false, required = true),
			@HtmlElement(name="religionId", seachable = true, controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=Religion.class), listable = false, required = true),
			@HtmlElement(name="citizenshipId", seachable = true, controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=Country.class), listable = false, required = true),
			@HtmlElement(name="bloodGroupId", seachable = true, controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=BloodGroup.class), listable = false, required = true),
			@HtmlElement(name="height",label="height (cm)" ,listable = false, maxLength=6, regExp = "/^[0-9][0-9.]*[0-9]+$/"),
			@HtmlElement(name="color", listable = false, maxLength = 20,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
		}),
		
		@HtmlElementGroup(id="demoGraph2", name="demoGraph2", elementsPerRow=3,
		elements= {
			@HtmlElement(name="identificationMark", listable = false, maxLength = 75,regExp =HtmlElement.REGEXP_ALPHANUM_SPACE),
			@HtmlElement(name="phTypeId", label="Physically Handicap", seachable = true, controlType = HtmlElement.ControlType.select, relation=@Relation(modelClass=PhType.class)),
		}),
		
		@HtmlElementGroup(id="demoGraph3", name="demoGraph3", elementsPerRow=3,
		elements= {
			@HtmlElement(name="aadhaarNo", listable = false,minLength=12, maxLength = 12, validType = HtmlElement.ValidType.digits, required = true),
			@HtmlElement(name="panNo", listable = false,minLength=10, maxLength = 10, regExp =HtmlElement.REGEXP_PANNO, required = true),
		}),
		/*@HtmlElementGroup(id="demoGraph4", name="demoGraph5", elementsPerRow=2,
		elements= {
			@HtmlElement(name="exServiceMan", controlType = ControlType.checkbox , listable = false),
			
		}),*/
		
		@HtmlElementGroup(id="demoGraph5", name="demoGraph6", elementsPerRow=2,
		elements= {
			@HtmlElement(name="identityProofId", seachable = true, controlType = HtmlElement.ControlType.fileUpload ,required = true,accept = "image/png, image/jpeg, application/pdf"),
			
		}),

})
public class PeopleForm {
	People people;
	public PeopleForm() {
		super();
	}
}
