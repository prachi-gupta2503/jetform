package com.adjecti.pis.liferay.activator;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.pis.liferay.form.AddressForm;
import com.adjecti.pis.liferay.form.ContactForm;
import com.adjecti.pis.liferay.form.DeputationProcessFlow;
import com.adjecti.pis.liferay.form.DeputationProcessForm;
import com.adjecti.pis.liferay.form.DeputationProcessRequestForm;
import com.adjecti.pis.liferay.form.DivisionForm;
import com.adjecti.pis.liferay.form.EmployeeAddressForm;
import com.adjecti.pis.liferay.form.EmployeeBenefitSchemeForm;
import com.adjecti.pis.liferay.form.EmployeeBiodataForm;
import com.adjecti.pis.liferay.form.EmployeeConfirmationForm;
import com.adjecti.pis.liferay.form.EmployeeContactForm;
import com.adjecti.pis.liferay.form.EmployeeDeputationForm;
import com.adjecti.pis.liferay.form.EmployeeDeputationRequestForm;
import com.adjecti.pis.liferay.form.EmployeeDscForm;
import com.adjecti.pis.liferay.form.EmployeeExperienceForm;
import com.adjecti.pis.liferay.form.EmployeeFamilyForm;
import com.adjecti.pis.liferay.form.EmployeeForm;
import com.adjecti.pis.liferay.form.EmployeeInfoForm;
import com.adjecti.pis.liferay.form.EmployeeJoiningForm;
import com.adjecti.pis.liferay.form.EmployeeJoiningPastExperienceForm;
import com.adjecti.pis.liferay.form.EmployeeJoiningQualificationForm;
import com.adjecti.pis.liferay.form.EmployeeOrganizationForm;
import com.adjecti.pis.liferay.form.EmployeePastExperienceForm;
import com.adjecti.pis.liferay.form.EmployeePermissionForm;
import com.adjecti.pis.liferay.form.EmployeePostForm;
import com.adjecti.pis.liferay.form.EmployeePromotionForm;
import com.adjecti.pis.liferay.form.EmployeePromotionRequestForm;
import com.adjecti.pis.liferay.form.EmployeeQualificationForm;
import com.adjecti.pis.liferay.form.EmployeeReportingForm;
import com.adjecti.pis.liferay.form.EmployeeSelectionForm;
import com.adjecti.pis.liferay.form.EmployeeSeparationRequestForm;
import com.adjecti.pis.liferay.form.EmployeeTrainingForm;
import com.adjecti.pis.liferay.form.EmployeeTransferForm;
import com.adjecti.pis.liferay.form.EmployeeTransferRequestForm;
import com.adjecti.pis.liferay.form.EmployeeVerificationForm;
import com.adjecti.pis.liferay.form.EmployeeWorkstationForm;
import com.adjecti.pis.liferay.form.EntityWorkflowForm;
import com.adjecti.pis.liferay.form.IDAMFailedTransactionForm;
import com.adjecti.pis.liferay.form.IDAMUserForm;
import com.adjecti.pis.liferay.form.IDAMUserPermissionForm;
import com.adjecti.pis.liferay.form.InstituteForm;
import com.adjecti.pis.liferay.form.JoiningProcessApproverForm;
import com.adjecti.pis.liferay.form.JoiningProcessFlowForm;
import com.adjecti.pis.liferay.form.JoiningProcessForm;
import com.adjecti.pis.liferay.form.JoiningProcessRequestForm;
import com.adjecti.pis.liferay.form.JoiningProcessReturnForm;
import com.adjecti.pis.liferay.form.MyApprovalForm;
import com.adjecti.pis.liferay.form.MyRequestForm;
import com.adjecti.pis.liferay.form.OrganizationAddressForm;
import com.adjecti.pis.liferay.form.PeopleForm;
import com.adjecti.pis.liferay.form.PermanentAddressForm;
import com.adjecti.pis.liferay.form.PersonalInfoForm;
import com.adjecti.pis.liferay.form.ProfileImageForm;
import com.adjecti.pis.liferay.form.RegistrationRequestForm;
import com.adjecti.pis.liferay.form.ResidenceAddressForm;
import com.adjecti.pis.liferay.form.SectionForm;
import com.adjecti.pis.liferay.form.SectionImportForm;
import com.adjecti.pis.liferay.form.SectionMappingForm;
import com.adjecti.pis.liferay.form.SectionMappingImportForm;
import com.adjecti.pis.liferay.form.SingleUserOnboardingApproverForm;
import com.adjecti.pis.liferay.form.SingleUserOnboardingForm;
import com.adjecti.pis.liferay.form.TransferProcessForm;
import com.adjecti.pis.liferay.form.TransferProcessNotingForm;
import com.adjecti.pis.liferay.form.TransferProcessRequestForm;
import com.adjecti.pis.liferay.form.UnitForm;
import com.adjecti.pis.liferay.form.card.EmployeeContactInfo;
import com.adjecti.pis.liferay.form.card.EmployeePersonalInfo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		FormEntityCache.registerFormClass(TransferProcessNotingForm.class);	
		FormEntityCache.registerFormClass(EmployeeContactInfo.class);
		FormEntityCache.registerFormClass(EmployeeForm.class);
		FormEntityCache.registerFormClass(DeputationProcessFlow.class);
		FormEntityCache.registerFormClass(EmployeePostForm.class);
		FormEntityCache.registerFormClass(DeputationProcessRequestForm.class);
		FormEntityCache.registerFormClass(RegistrationRequestForm.class);
		FormEntityCache.registerFormClass(PersonalInfoForm.class);
		FormEntityCache.registerFormClass(EmployeeForm.class);
		FormEntityCache.registerFormClass(EmployeePersonalInfo.class);
		FormEntityCache.registerFormClass(EmployeeQualificationForm.class);
		FormEntityCache.registerFormClass(EmployeeExperienceForm.class);
		FormEntityCache.registerFormClass(EmployeeFamilyForm.class);
		FormEntityCache.registerFormClass(IDAMFailedTransactionForm.class);
		FormEntityCache.registerFormClass(EmployeeReportingForm.class);
		FormEntityCache.registerFormClass(EmployeeJoiningForm.class);
		FormEntityCache.registerFormClass(EmployeeBenefitSchemeForm.class);
		FormEntityCache.registerFormClass(SectionMappingForm.class);
		FormEntityCache.registerFormClass(MyRequestForm.class);
		FormEntityCache.registerFormClass(EmployeeTrainingForm.class);
		FormEntityCache.registerFormClass(EmployeeDeputationRequestForm.class);
		FormEntityCache.registerFormClass(InstituteForm.class);
		FormEntityCache.registerFormClass(EmployeeDeputationForm.class);
		FormEntityCache.registerFormClass(EmployeeSeparationRequestForm.class);
		FormEntityCache.registerFormClass(EmployeeConfirmationForm.class);
		FormEntityCache.registerFormClass(EmployeePastExperienceForm.class);
		FormEntityCache.registerFormClass(SectionMappingImportForm.class);
		FormEntityCache.registerFormClass(PeopleForm.class);
		FormEntityCache.registerFormClass(EmployeeAddressForm.class);
		FormEntityCache.registerFormClass(EmployeeWorkstationForm.class);
		FormEntityCache.registerFormClass(EmployeePromotionForm.class);
		FormEntityCache.registerFormClass(EmployeeTransferRequestForm.class);
		FormEntityCache.registerFormClass(AddressForm.class);
		FormEntityCache.registerFormClass(EmployeeTransferForm.class);
		FormEntityCache.registerFormClass(SectionImportForm.class);
		FormEntityCache.registerFormClass(EmployeePromotionRequestForm.class);
		FormEntityCache.registerFormClass(EmployeeContactForm.class);
		FormEntityCache.registerFormClass(MyApprovalForm.class);
		FormEntityCache.registerFormClass(ContactForm.class);
		FormEntityCache.registerFormClass(EmployeeBiodataForm.class);
		FormEntityCache.registerFormClass(PeopleForm.class);

		
		
		FormEntityCache.registerFormClass(EmployeeSelectionForm.class);
		FormEntityCache.registerFormClass(DeputationProcessForm.class);
		FormEntityCache.registerFormClass(DeputationProcessRequestForm.class);
		FormEntityCache.registerFormClass(DeputationProcessFlow.class);
		FormEntityCache.registerFormClass(DeputationProcessFlow.class);
		
		FormEntityCache.registerFormClass(SingleUserOnboardingForm.class);
		FormEntityCache.registerFormClass(SingleUserOnboardingApproverForm.class);
		
		
		FormEntityCache.registerFormClass(JoiningProcessForm.class);
		FormEntityCache.registerFormClass(JoiningProcessFlowForm.class);
		FormEntityCache.registerFormClass(JoiningProcessApproverForm.class);
		
		FormEntityCache.registerFormClass(IDAMUserPermissionForm.class);
		FormEntityCache.registerFormClass(IDAMUserForm.class);
		FormEntityCache.registerFormClass(EntityWorkflowForm.class);
		FormEntityCache.registerFormClass(EmployeeOrganizationForm.class);
		FormEntityCache.registerFormClass(EmployeeInfoForm.class);
		
		FormEntityCache.registerFormClass(IDAMUserPermissionForm.class);
		FormEntityCache.registerFormClass(IDAMUserForm.class);
		FormEntityCache.registerFormClass(EntityWorkflowForm.class);
		
		FormEntityCache.registerFormClass(EmployeeDscForm.class);
		
		
		FormEntityCache.registerFormClass(EmployeeBenefitSchemeForm.class);
		FormEntityCache.registerFormClass(EmployeeConfirmationForm.class);
		FormEntityCache.registerFormClass(EmployeeDeputationForm.class);
		FormEntityCache.registerFormClass(EmployeeExperienceForm.class);
		
		
		FormEntityCache.registerFormClass(EmployeeFamilyForm.class);
		FormEntityCache.registerFormClass(EmployeeJoiningForm.class);
		
		FormEntityCache.registerFormClass(EmployeePastExperienceForm.class);
		FormEntityCache.registerFormClass(EmployeeQualificationForm.class);
		FormEntityCache.registerFormClass(EmployeePromotionForm.class);
		
		
		FormEntityCache.registerFormClass(EmployeeTransferForm.class);
		FormEntityCache.registerFormClass(EmployeeJoiningForm.class);
		
		FormEntityCache.registerFormClass(EmployeeReportingForm.class);
		FormEntityCache.registerFormClass(EmployeeTrainingForm.class);
		FormEntityCache.registerFormClass(EmployeeWorkstationForm.class);
		FormEntityCache.registerFormClass(ProfileImageForm.class);
		
		
		FormEntityCache.registerFormClass(PeopleForm.class);

		FormEntityCache.registerFormClass(AddressForm.class);
		FormEntityCache.registerFormClass(PermanentAddressForm.class);
		FormEntityCache.registerFormClass(ResidenceAddressForm.class);

		
		FormEntityCache.registerFormClass(EmployeeJoiningQualificationForm.class);

		FormEntityCache.registerFormClass(EmployeeJoiningPastExperienceForm.class);

		
		FormEntityCache.registerFormClass(EmployeeVerificationForm.class);
		FormEntityCache.registerFormClass(OrganizationAddressForm.class);
		
		FormEntityCache.registerFormClass(OrganizationAddressForm.class);
		
		FormEntityCache.registerFormClass(EmployeePermissionForm.class);
		FormEntityCache.registerFormClass(JoiningProcessReturnForm.class);
		FormEntityCache.registerFormClass(JoiningProcessRequestForm.class);
		FormEntityCache.registerFormClass(EmployeePostForm.class);
		FormEntityCache.registerFormClass(SectionForm.class);
		FormEntityCache.registerFormClass(DivisionForm.class);
		FormEntityCache.registerFormClass(TransferProcessForm.class);
		FormEntityCache.registerFormClass(TransferProcessRequestForm.class);
		FormEntityCache.registerFormClass(UnitForm.class);
		
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
