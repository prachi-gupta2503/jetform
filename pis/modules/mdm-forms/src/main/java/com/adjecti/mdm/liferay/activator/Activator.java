package com.adjecti.mdm.liferay.activator;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.mdm.liferay.form.AccomodationTypeForm;
import com.adjecti.mdm.liferay.form.AddressForm;
import com.adjecti.mdm.liferay.form.AppellationForm;
import com.adjecti.mdm.liferay.form.BenefitSchemeForm;
import com.adjecti.mdm.liferay.form.BloodGroupForm;
import com.adjecti.mdm.liferay.form.CadreForm;
import com.adjecti.mdm.liferay.form.CasteCategoryForm;
import com.adjecti.mdm.liferay.form.CountryForm;
import com.adjecti.mdm.liferay.form.DesignationForm;
import com.adjecti.mdm.liferay.form.DesignationGroupForm;
import com.adjecti.mdm.liferay.form.DesignationModeForm;
import com.adjecti.mdm.liferay.form.DistrictForm;
import com.adjecti.mdm.liferay.form.FamilyRelationForm;
import com.adjecti.mdm.liferay.form.GenderForm;
import com.adjecti.mdm.liferay.form.GradeForm;
import com.adjecti.mdm.liferay.form.GradeModeForm;
import com.adjecti.mdm.liferay.form.JoiningModeForm;
import com.adjecti.mdm.liferay.form.MaritalStatusForm;
import com.adjecti.mdm.liferay.form.OccupationForm;
import com.adjecti.mdm.liferay.form.OrganizationDetailForm;
import com.adjecti.mdm.liferay.form.OrganizationForm;
import com.adjecti.mdm.liferay.form.PhTypeForm;
import com.adjecti.mdm.liferay.form.PostForm;
import com.adjecti.mdm.liferay.form.PostOrganizationForm;
import com.adjecti.mdm.liferay.form.QualificationForm;
import com.adjecti.mdm.liferay.form.QualificationGradeForm;
import com.adjecti.mdm.liferay.form.QualificationLevelForm;
import com.adjecti.mdm.liferay.form.ReligionForm;
import com.adjecti.mdm.liferay.form.SectionForm;
import com.adjecti.mdm.liferay.form.SectionImportForm;
import com.adjecti.mdm.liferay.form.ServiceRequestTypeForm;
import com.adjecti.mdm.liferay.form.SpecializationForm;
import com.adjecti.mdm.liferay.form.StateForm;
import com.adjecti.mdm.liferay.form.SubjectOfQualificationForm;
import com.adjecti.mdm.liferay.form.SubjectOfTrainingForm;
import com.adjecti.mdm.liferay.form.TradeForm;
import com.adjecti.mdm.liferay.form.TrainingCourseForm;
import com.adjecti.mdm.liferay.form.UnitTypeForm;
import com.adjecti.mdm.liferay.form.VerificationTypeForm;
import com.adjecti.mdm.liferay.form.WorkAreaForm;
import com.adjecti.mdm.liferay.form.WorkStationForm;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		FormEntityCache.registerFormClass(GradeModeForm.class);
		FormEntityCache.registerFormClass(DesignationForm.class);
		FormEntityCache.registerFormClass(DesignationGroupForm.class);
		FormEntityCache.registerFormClass(CadreForm.class);
		FormEntityCache.registerFormClass(DesignationModeForm.class);
		FormEntityCache.registerFormClass(AccomodationTypeForm.class);
		FormEntityCache.registerFormClass(FamilyRelationForm.class);
		FormEntityCache.registerFormClass(GenderForm.class);
		FormEntityCache.registerFormClass(GradeForm.class);
		FormEntityCache.registerFormClass(MaritalStatusForm.class);
		FormEntityCache.registerFormClass(OccupationForm.class);
		FormEntityCache.registerFormClass(PhTypeForm.class);
		FormEntityCache.registerFormClass(QualificationForm.class);	
		FormEntityCache.registerFormClass(QualificationGradeForm.class);
		FormEntityCache.registerFormClass(ReligionForm.class);
		FormEntityCache.registerFormClass(SpecializationForm.class);
		FormEntityCache.registerFormClass(TradeForm.class);
		FormEntityCache.registerFormClass(OrganizationDetailForm.class);
		FormEntityCache.registerFormClass(PostForm.class);
		FormEntityCache.registerFormClass(PostOrganizationForm.class);
		FormEntityCache.registerFormClass(CountryForm.class);
		FormEntityCache.registerFormClass(StateForm.class);
		FormEntityCache.registerFormClass(SubjectOfTrainingForm.class);
		FormEntityCache.registerFormClass(SubjectOfQualificationForm.class);
		FormEntityCache.registerFormClass(UnitTypeForm.class);
		FormEntityCache.registerFormClass(DistrictForm.class);
		FormEntityCache.registerFormClass(WorkAreaForm.class);
		FormEntityCache.registerFormClass(VerificationTypeForm.class);
		FormEntityCache.registerFormClass(WorkStationForm.class);
		FormEntityCache.registerFormClass(SectionImportForm.class);
		FormEntityCache.registerFormClass(OrganizationDetailForm.class);
		FormEntityCache.registerFormClass(AddressForm.class);
		FormEntityCache.registerFormClass(OrganizationForm.class);
		FormEntityCache.registerFormClass(QualificationLevelForm.class);
		FormEntityCache.registerFormClass(JoiningModeForm.class);
		FormEntityCache.registerFormClass(ServiceRequestTypeForm.class);
		FormEntityCache.registerFormClass(TrainingCourseForm.class);
		FormEntityCache.registerFormClass(AppellationForm.class);
		FormEntityCache.registerFormClass(BenefitSchemeForm.class);
		FormEntityCache.registerFormClass(BloodGroupForm.class);
		FormEntityCache.registerFormClass(CasteCategoryForm.class);
		FormEntityCache.registerFormClass(SectionForm.class);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
