package com.adjecti.mdm.liferay.activator;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.jetform.liferay.activator.JetformActivator;
import com.adjecti.mdm.liferay.model.AccomodationType;
import com.adjecti.mdm.liferay.model.Address;
import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.BenefitScheme;
import com.adjecti.mdm.liferay.model.BloodGroup;
import com.adjecti.mdm.liferay.model.Cadre;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Country;
import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationClass;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.DesignationMode;
import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.model.FamilyRelation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.JoiningMode;
import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.mdm.liferay.model.MasterEntity;
import com.adjecti.mdm.liferay.model.Occupation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.PhType;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.model.PostDelegation;
import com.adjecti.mdm.liferay.model.PostOrganization;
import com.adjecti.mdm.liferay.model.PostReporting;
import com.adjecti.mdm.liferay.model.Qualification;
import com.adjecti.mdm.liferay.model.QualificationGrade;
import com.adjecti.mdm.liferay.model.QualificationLevel;
import com.adjecti.mdm.liferay.model.Religion;
import com.adjecti.mdm.liferay.model.ServiceRequestType;
import com.adjecti.mdm.liferay.model.Specialization;
import com.adjecti.mdm.liferay.model.State;
import com.adjecti.mdm.liferay.model.SubjectOfQualification;
import com.adjecti.mdm.liferay.model.SubjectOfTraining;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.model.UnitType;
import com.adjecti.mdm.liferay.model.VerificationType;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.model.WorkStation;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.util.PropsUtil;

import org.osgi.framework.BundleActivator;

/*@Component(
		property = { 
				"jetform.definition.pathname=jetform.formDefinition.location",
				"jetform.form.location=jetform.mdmforms.location"
				})*/
public class MDMActivator extends JetformActivator  implements BundleActivator  {

	public MDMActivator() {
		super();
		log.info("mdm-Activator");
		formDefinationPath = PropsUtil.get("jetform.formDefinition.location");
		formsLocation = PropsUtil.get("jetform.mdmforms.location");
		registerFormEntity();
	}

	@Override
	public void registerFormEntity() {

		FormEntityCache.registerFormClass(MasterEntity.class);
		FormEntityCache.registerFormClass(AccomodationType.class);
		FormEntityCache.registerFormClass(Appellation.class);
		FormEntityCache.registerFormClass(BenefitScheme.class);
		FormEntityCache.registerFormClass(BloodGroup.class);
		FormEntityCache.registerFormClass(CasteCategory.class);
		FormEntityCache.registerFormClass(Cadre.class);
		FormEntityCache.registerFormClass(Course.class);
		FormEntityCache.registerFormClass(Designation.class);
		FormEntityCache.registerFormClass(DesignationGroup.class);
		FormEntityCache.registerFormClass(DesignationMode.class);
		FormEntityCache.registerFormClass(DesignationClass.class);
		FormEntityCache.registerFormClass(FamilyRelation.class);
		FormEntityCache.registerFormClass(Gender.class);
		FormEntityCache.registerFormClass(MaritalStatus.class);
		FormEntityCache.registerFormClass(Grade.class);
		FormEntityCache.registerFormClass(Qualification.class);
		FormEntityCache.registerFormClass(GradeMode.class);
		FormEntityCache.registerFormClass(Religion.class);
		FormEntityCache.registerFormClass(PhType.class);
		FormEntityCache.registerFormClass(VerificationType.class);
		FormEntityCache.registerFormClass(SubjectOfQualification.class);
		FormEntityCache.registerFormClass(District.class);
		FormEntityCache.registerFormClass(PostDelegation.class);
		FormEntityCache.registerFormClass(UnitType.class);
		FormEntityCache.registerFormClass(Organization.class);
		FormEntityCache.registerFormClass(PostReporting.class);
		FormEntityCache.registerFormClass(SubjectOfTraining.class);
		FormEntityCache.registerFormClass(WorkStation.class);
		FormEntityCache.registerFormClass(QualificationGrade.class);
		FormEntityCache.registerFormClass(Specialization.class);
		FormEntityCache.registerFormClass(State.class);
		FormEntityCache.registerFormClass(OrganizationDetail.class);
		FormEntityCache.registerFormClass(JoiningMode.class);
		FormEntityCache.registerFormClass(Organization.class);
		FormEntityCache.registerFormClass(PostOrganization.class);
		FormEntityCache.registerFormClass(Address.class);
		FormEntityCache.registerFormClass(QualificationLevel.class);
		FormEntityCache.registerFormClass(Post.class);
		FormEntityCache.registerFormClass(ServiceRequestType.class);
		FormEntityCache.registerFormClass(Occupation.class);
		FormEntityCache.registerFormClass(WorkArea.class);
		FormEntityCache.registerFormClass(Country.class);
		FormEntityCache.registerFormClass(Trade.class);

	}

	private Log log = LogFactoryUtil.getLog(this.getClass());

}
