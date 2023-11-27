package com.adjecti.mdm.liferay.util;

import com.adjecti.mdm.liferay.model.AccomodationType;
import com.adjecti.mdm.liferay.model.AmountType;
import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.Application;
import com.adjecti.mdm.liferay.model.BenefitScheme;
import com.adjecti.mdm.liferay.model.BloodGroup;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.mdm.liferay.model.CourseCategory;
import com.adjecti.mdm.liferay.model.DeputationType;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationClass;
import com.adjecti.mdm.liferay.model.DesignationGrade;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Disease;
import com.adjecti.mdm.liferay.model.DiseaseType;
import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.model.Document;
import com.adjecti.mdm.liferay.model.DocumentType;
import com.adjecti.mdm.liferay.model.Experience;
import com.adjecti.mdm.liferay.model.FamilyRelation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.JoiningMode;
import com.adjecti.mdm.liferay.model.LevelWisePayStructure;
import com.adjecti.mdm.liferay.model.Location;
import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.mdm.liferay.model.MasterEntity;
import com.adjecti.mdm.liferay.model.OEM;
import com.adjecti.mdm.liferay.model.Occupation;
import com.adjecti.mdm.liferay.model.OccupationServiceType;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.OrganizationPayStructure;
import com.adjecti.mdm.liferay.model.PayComponent;
import com.adjecti.mdm.liferay.model.PayHead;
import com.adjecti.mdm.liferay.model.PayHeadType;
import com.adjecti.mdm.liferay.model.PayLevel;
import com.adjecti.mdm.liferay.model.PayStructure;
import com.adjecti.mdm.liferay.model.PersonalNoPrefix;
import com.adjecti.mdm.liferay.model.PhType;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.model.PostDelegation;
import com.adjecti.mdm.liferay.model.PostHierarchy;
import com.adjecti.mdm.liferay.model.PostOrganization;
import com.adjecti.mdm.liferay.model.PostReporting;
import com.adjecti.mdm.liferay.model.Qualification;
import com.adjecti.mdm.liferay.model.QualificationGrade;
import com.adjecti.mdm.liferay.model.QualificationLevel;
import com.adjecti.mdm.liferay.model.Religion;
import com.adjecti.mdm.liferay.model.Specialization;
import com.adjecti.mdm.liferay.model.State;
import com.adjecti.mdm.liferay.model.TimeFrequency;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.model.TrainingCourse;
import com.adjecti.mdm.liferay.model.TrainingInstitute;
import com.adjecti.mdm.liferay.model.VerificationType;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.model.WorkAreaType;
import com.adjecti.mdm.liferay.model.WorkStation;
import com.adjecti.mdm.liferay.service.AccomodationTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.AmountTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.AppellationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.ApplicationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.BenefitSchemeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.BloodGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.CasteCategoryLocalServiceUtil;
import com.adjecti.mdm.liferay.service.CourseCategoryLocalServiceUtil;
import com.adjecti.mdm.liferay.service.CourseLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DeputationTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationClassLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationGradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DiseaseLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DiseaseTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DistrictLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DocumentLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DocumentTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.ExperienceLocalServiceUtil;
import com.adjecti.mdm.liferay.service.FamilyRelationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GenderLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeModeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.JoiningModeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.LevelWisePayStructureLocalServiceUtil;
import com.adjecti.mdm.liferay.service.LocationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.MaritalStatusLocalServiceUtil;
import com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OEMLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OccupationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OccupationServiceTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationPayStructureLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PayComponentLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PayHeadLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PayHeadTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PayLevelLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PayStructureLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PersonalNoPrefixLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PhTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostDelegationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostHierarchyLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostOrganizationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostReportingLocalServiceUtil;
import com.adjecti.mdm.liferay.service.QualificationGradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.QualificationLevelLocalServiceUtil;
import com.adjecti.mdm.liferay.service.QualificationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.ReligionLocalServiceUtil;
import com.adjecti.mdm.liferay.service.SpecializationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.StateLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TimeFrequencyLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TrainingCourseLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TrainingInstituteLocalServiceUtil;
import com.adjecti.mdm.liferay.service.VerificationTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil;
import com.adjecti.mdm.liferay.service.WorkAreaTypeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.WorkStationLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.WebsiteLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class MDMUtils {

	private final static Log _logger = LogFactoryUtil.getLog(MDMUtils.class.getName());

	public static List<AccomodationType> getAllAccomodationTypes() {
		return AccomodationTypeLocalServiceUtil.getAccomodationTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static AccomodationType getAccomodationTypeById(long accomodationTypeId) {
		AccomodationType accomodationType = null;
		try {
			accomodationType = AccomodationTypeLocalServiceUtil.getAccomodationType(accomodationTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return accomodationType;
	}

	public static List<AmountType> getAllAmountTypes() {
		return AmountTypeLocalServiceUtil.getAmountTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static AmountType getAmountTypeById(long amountTypeId) {
		AmountType amountType = null;

		try {
			amountType = AmountTypeLocalServiceUtil.getAmountType(amountTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}

		return amountType;
	}

	public static List<Appellation> getAllAppellations() {
		return AppellationLocalServiceUtil.getAppellations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Appellation getAppellationById(long appellationId) {
		Appellation appellation = null;
		try {
			appellation = AppellationLocalServiceUtil.getAppellation(appellationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return appellation;
	}

	public static List<Application> getAllApplications() {
		return ApplicationLocalServiceUtil.getApplications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Application getApplicationById(long applicationId) {
		Application application = null;
		try {
			application = ApplicationLocalServiceUtil.getApplication(applicationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return application;
	}

	public static List<BenefitScheme> getAllBenefitSchemes() {
		return BenefitSchemeLocalServiceUtil.getBenefitSchemes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static BenefitScheme getBenefitSchemeById(long benefitSchemeId) {
		BenefitScheme benefitScheme = null;
		try {
			benefitScheme = BenefitSchemeLocalServiceUtil.getBenefitScheme(benefitSchemeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return benefitScheme;
	}

	public static List<BloodGroup> getAllBloodGroups() {
		return BloodGroupLocalServiceUtil.getBloodGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static BloodGroup getBloodGroupById(long bloodGroupId) {
		BloodGroup bloodGroup = null;
		try {
			bloodGroup = BloodGroupLocalServiceUtil.getBloodGroup(bloodGroupId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return bloodGroup;
	}

	public static List<CasteCategory> getAllCasteCategories() {
		return CasteCategoryLocalServiceUtil.getCasteCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static CasteCategory getCasteCategoryById(long casteCategoryId) {
		CasteCategory casteCategory = null;
		try {
			casteCategory = CasteCategoryLocalServiceUtil.getCasteCategory(casteCategoryId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return casteCategory;
	}

	public static List<Course> getAllCourses() {
		return CourseLocalServiceUtil.getCourses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Course getCourseById(long courseId) {
		Course course = null;
		try {
			course = CourseLocalServiceUtil.getCourse(courseId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return course;
	}

	public static List<CourseCategory> getAllCourseCategories() {
		return CourseCategoryLocalServiceUtil.getCourseCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static CourseCategory getCourseCategoryById(long courseCategoryId) {
		CourseCategory courseCategory = null;
		try {
			courseCategory = CourseCategoryLocalServiceUtil.getCourseCategory(courseCategoryId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return courseCategory;
	}

	public static List<DeputationType> getAllDeputationTypes() {
		return DeputationTypeLocalServiceUtil.getDeputationTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static DeputationType getDeputationTypeById(long deputationTypeId) {
		DeputationType deputationType = null;
		try {
			deputationType = DeputationTypeLocalServiceUtil.getDeputationType(deputationTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return deputationType;
	}

	public static List<Designation> getAllDesignations() {
		return DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Designation getDesignationById(long designationId) {
		Designation designation = null;
		try {
			designation = DesignationLocalServiceUtil.getDesignation(designationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return designation;
	}

	public static List<DesignationClass> getAllDesignationClasss() {
		return DesignationClassLocalServiceUtil.getDesignationClasses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static DesignationClass getDesignationClassById(long designationClassId) {
		DesignationClass designationClass = null;
		try {
			designationClass = DesignationClassLocalServiceUtil.getDesignationClass(designationClassId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return designationClass;
	}

	public static List<DesignationGrade> getAllDesignationGrades() {
		return DesignationGradeLocalServiceUtil.getDesignationGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static DesignationGrade getDesignationGradeById(long designationGradeId) {
		DesignationGrade designationGrade = null;
		try {
			designationGrade = DesignationGradeLocalServiceUtil.getDesignationGrade(designationGradeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return designationGrade;
	}

	public static List<DesignationGroup> getAllDesignationGroups() {
		return DesignationGroupLocalServiceUtil.getDesignationGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static DesignationGroup getDesignationGroupById(long designationGroupId) {
		DesignationGroup designationGroup = null;
		try {
			designationGroup = DesignationGroupLocalServiceUtil.getDesignationGroup(designationGroupId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return designationGroup;
	}

	public static List<District> getAllDistricts() {
		return DistrictLocalServiceUtil.getDistricts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static District getDistrictById(long districtId) {
		District district = null;
		try {
			district = DistrictLocalServiceUtil.getDistrict(districtId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return district;
	}

	public static List<Disease> getAllDiseases() {
		return DiseaseLocalServiceUtil.getDiseases(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Disease getDiseaseById(long diseaseId) {
		Disease disease = null;
		try {
			disease = DiseaseLocalServiceUtil.getDisease(diseaseId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return disease;
	}

	public static List<DiseaseType> getAllDiseaseTypes() {
		return DiseaseTypeLocalServiceUtil.getDiseaseTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static DiseaseType getDiseaseTypeById(long diseaseTypeId) {
		DiseaseType diseaseType = null;
		try {
			diseaseType = DiseaseTypeLocalServiceUtil.getDiseaseType(diseaseTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return diseaseType;
	}

	public static List<Document> getAllDocuments() {
		return DocumentLocalServiceUtil.getDocuments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Document getDocumentById(long documentId) {
		Document document = null;
		try {
			document = DocumentLocalServiceUtil.getDocument(documentId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return document;
	}

	public static List<DocumentType> getAllDocumentTypes() {
		return DocumentTypeLocalServiceUtil.getDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static DocumentType getDocumentTypeById(long documentTypeId) {
		DocumentType documentType = null;
		try {
			documentType = DocumentTypeLocalServiceUtil.getDocumentType(documentTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return documentType;
	}

	public static List<Experience> getAllExperiences() {
		return ExperienceLocalServiceUtil.getExperiences(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Experience getExperienceById(long experienceId) {
		Experience experience = null;
		try {
			experience = ExperienceLocalServiceUtil.getExperience(experienceId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return experience;
	}

	public static List<FamilyRelation> getAllFamilyRelations() {
		return FamilyRelationLocalServiceUtil.getFamilyRelations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static FamilyRelation getFamilyRelationById(long familyRelationId) {
		FamilyRelation familyRelation = null;
		try {
			familyRelation = FamilyRelationLocalServiceUtil.getFamilyRelation(familyRelationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return familyRelation;
	}

	public static List<Gender> getAllGenders() {
		return GenderLocalServiceUtil.getGenders(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Gender getGenderById(long genderId) {
		Gender gender = null;
		try {
			gender = GenderLocalServiceUtil.getGender(genderId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return gender;
	}

	public static List<Grade> getAllGrades() {
		return GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Grade getGradeById(long gradeId) {
		Grade grade = null;
		try {
			grade = GradeLocalServiceUtil.getGrade(gradeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return grade;
	}

	public static List<GradeMode> getAllGradeModes() {
		return GradeModeLocalServiceUtil.getGradeModes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static GradeMode getGradeModeById(long gradeModeId) {
		GradeMode gradeMode = null;
		try {
			gradeMode = GradeModeLocalServiceUtil.getGradeMode(gradeModeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return gradeMode;
	}

	public static List<JoiningMode> getAllJoiningModes() {
		return JoiningModeLocalServiceUtil.getJoiningModes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static JoiningMode getJoiningModeById(long joiningModeId) {
		JoiningMode joiningMode = null;
		try {
			joiningMode = JoiningModeLocalServiceUtil.getJoiningMode(joiningModeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return joiningMode;
	}

	public static List<LevelWisePayStructure> getAllLevelWisePayStructures() {
		return LevelWisePayStructureLocalServiceUtil.getLevelWisePayStructures(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static LevelWisePayStructure getLevelWisePayStructureById(long levelWisePayStructureId) {
		LevelWisePayStructure levelWisePayStructure = null;
		try {
			levelWisePayStructure = LevelWisePayStructureLocalServiceUtil
					.getLevelWisePayStructure(levelWisePayStructureId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return levelWisePayStructure;
	}

	public static List<Location> getAllLocations() {
		return LocationLocalServiceUtil.getLocations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Location getLocationById(long locationId) {
		Location location = null;
		try {
			location = LocationLocalServiceUtil.getLocation(locationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return location;
	}

	public static List<MaritalStatus> getAllMaritalStatuses() {
		return MaritalStatusLocalServiceUtil.getMaritalStatuses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static MaritalStatus getMaritalStatusById(long maritalStatusId) {
		MaritalStatus maritalStatus = null;
		try {
			maritalStatus = MaritalStatusLocalServiceUtil.getMaritalStatus(maritalStatusId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return maritalStatus;
	}

	public static List<MasterEntity> getAllMasterEntities() {
		return MasterEntityLocalServiceUtil.getMasterEntities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static MasterEntity getMasterEntityById(long joiningModeId) {
		MasterEntity masterEntity = null;
		try {
			masterEntity = MasterEntityLocalServiceUtil.getMasterEntity(joiningModeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return masterEntity;
	}

	public static List<Occupation> getAllOccupations() {
		return OccupationLocalServiceUtil.getOccupations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Occupation getOccupationById(long occupationId) {
		Occupation occupation = null;
		try {
			occupation = OccupationLocalServiceUtil.getOccupation(occupationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return occupation;
	}

	public static List<OccupationServiceType> getAllOccupationServiceTypes() {
		return OccupationServiceTypeLocalServiceUtil.getOccupationServiceTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static OccupationServiceType getOccupationServiceTypeById(long occupationServiceTypeId) {
		OccupationServiceType occupationServiceType = null;
		try {
			occupationServiceType = OccupationServiceTypeLocalServiceUtil
					.getOccupationServiceType(occupationServiceTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return occupationServiceType;
	}

	public static List<OrganizationPayStructure> getAllOrganizationPayStructures() {
		return OrganizationPayStructureLocalServiceUtil.getOrganizationPayStructures(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
	}

	public static OrganizationPayStructure getOrganizationPayStructureById(long organizationPayStructureId) {
		OrganizationPayStructure organizationPayStructure = null;
		try {
			organizationPayStructure = OrganizationPayStructureLocalServiceUtil
					.getOrganizationPayStructure(organizationPayStructureId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return organizationPayStructure;
	}

	public static List<OEM> getAllOEMs() {
		return OEMLocalServiceUtil.getOEMs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static OEM getOEMById(long oemId) {
		OEM oem = null;
		try {
			oem = OEMLocalServiceUtil.getOEM(oemId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return oem;
	}

	public static List<Organization> getOrganizations() {
		return OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static List<Organization> getOrganizationsByParentId(long paretOrganizationId) {
		return OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), paretOrganizationId);
	}

	public static Organization getOrganizationById(long organizationId) {
		Organization organization = null;
		try {
			organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return organization;
	}

	public static List<Organization> getOrganizationsByType(String type) {
		List<Organization>  organizationsByType= new ArrayList<Organization>();
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for(Organization organization:organizations) {
				if(StringUtils.equalsIgnoreCase(organization.getType(), type)) {
					organizationsByType.add(organization);
				}
			}
		}catch(Exception e) {}
		return organizationsByType;
	}

	public static List<Organization> getOrganizationsByTypes(String[] types) {
		List<Organization>  organizationsByType= new ArrayList<Organization>();
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for(Organization organization:organizations) {
				for(String type:types) {
					if(StringUtils.equalsIgnoreCase(organization.getType(), type)) {
						organizationsByType.add(organization);
						break;
					}
				}
			}

		}catch(Exception e) {}
		return organizationsByType;
	}
	public static List<Organization> getOrganizationHierarchyByOrganizationId(long organizationId,List<Organization> organizations) {

		List<Organization>org =MDMUtils.getOrganizationsByParentId(organizationId);
		if(CollectionUtils.isEmpty(org)) {
			return organizations;
		}
		for(Organization o:org)
		{
			organizations.add(o);
			getOrganizationHierarchyByOrganizationId(o.getOrganizationId(),organizations);

		}
		return organizations;
	}

	public static List<Organization> getOrganizationsByParentIdAndType(long paretOrganizationId, String type) {
		List<Organization>  organizationsByType= new ArrayList<Organization>();
		if(paretOrganizationId==0) {
			return organizationsByType;
		}
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), paretOrganizationId);
			for(Organization organization:organizations) {

				String status =getExpandoValue(Organization.class, organization.getOrganizationId(), "status");
				if(status==null||status.equals("") || status.equals("Initiate Dissolve") ||status.equals("Initiate Merge") ||status.equals("Initiate Split") ) {
					if(StringUtils.equalsIgnoreCase(organization.getType(), type)) {
						organizationsByType.add(organization);
					}
				}
			}
		}catch(Exception e) {}
		return organizationsByType;
	}
	private static String getExpandoValue(Class<Organization> clazz, long classPK, String columnName) {
		String value="";
		try {
			value=getExpandoValue(clazz, classPK, "CUSTOM_FIELDS", columnName, "");
		} catch (Exception e) {

		}
		return value;
	}

	private static String getExpandoValue(Class<Organization> clazz, long classPK, String tableName, String columnName, String defaultValue) {
		String value="";
		try {
			value=ExpandoValueLocalServiceUtil.getData(CompanyThreadLocal.getCompanyId(), clazz.getName(), "CUSTOM_FIELDS", columnName, classPK, defaultValue);
		}catch (PortalException e) {
		}
		return value;
	}
	public static List<EmailAddress> getEmailAddresses(long companyId, String className, long classPK) {
		List<EmailAddress> emails=new ArrayList<EmailAddress>();
		try {
			emails=EmailAddressLocalServiceUtil.getEmailAddresses(companyId, className, classPK);
		}catch(Exception e) {}
		return emails;
	}

	public static List<Website> getWebsites(long companyId, String className, long classPK) {
		List<Website> websites=new ArrayList<Website>();
		try {
			websites=WebsiteLocalServiceUtil.getWebsites(companyId, className, classPK);
		}catch(Exception e) {}
		return websites;
	}

	public static List<Phone> getPhones(long companyId, String className, long classPK) {
		List<Phone> phones=new ArrayList<Phone>();
		try {
			phones=PhoneLocalServiceUtil.getPhones(companyId, className, classPK);
		}catch(Exception e) {}
		return phones;
	}

	public static List<PayComponent> getAllPayComponents() {
		return PayComponentLocalServiceUtil.getPayComponents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PayComponent getPayComponentById(long payComponentId) {
		PayComponent payComponent = null;
		try {
			payComponent = PayComponentLocalServiceUtil.getPayComponent(payComponentId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return payComponent;
	}

	public static List<PayStructure> getAllPayStructureComponents() {
		return PayStructureLocalServiceUtil.getPayStructures(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PayStructure getPayStructureById(long payStructureId) {
		PayStructure payStructure = null;
		try {
			payStructure = PayStructureLocalServiceUtil.getPayStructure(payStructureId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return payStructure;
	}

	public static List<PostHierarchy> getAllPostHierarchyies() {
		return PostHierarchyLocalServiceUtil.getPostHierarchies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PostHierarchy getPostHierarchyById(long postHierarchyId) {
		PostHierarchy postHierarchy = null;
		try {
			postHierarchy = PostHierarchyLocalServiceUtil.getPostHierarchy(postHierarchyId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return postHierarchy;
	}

	public static List<PostOrganization> getAllPostOrganizations() {
		return PostOrganizationLocalServiceUtil.getPostOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PostOrganization getPostOrganizationById(long postOrganizationId) {
		PostOrganization postOrganization = null;
		try {
			postOrganization = PostOrganizationLocalServiceUtil.getPostOrganization(postOrganizationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return postOrganization;
	}

	public static List<PayHead> getAllPayHeads() {
		return PayHeadLocalServiceUtil.getPayHeads(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PayHead getPayHeadById(long payHeadId) {
		PayHead payHead = null;
		try {
			payHead = PayHeadLocalServiceUtil.getPayHead(payHeadId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return payHead;
	}

	public static List<PayHeadType> getAllPayHeadTypes() {
		return PayHeadTypeLocalServiceUtil.getPayHeadTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PayHeadType getPayHeadTypeById(long payHeadTypeId) {
		PayHeadType payHeadType = null;
		try {
			payHeadType = PayHeadTypeLocalServiceUtil.getPayHeadType(payHeadTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return payHeadType;
	}

	public static List<PayLevel> getAllPayLevels() {
		return PayLevelLocalServiceUtil.getPayLevels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PayLevel getPayLevelById(long payLevelId) {
		PayLevel payLevel = null;
		try {
			payLevel = PayLevelLocalServiceUtil.getPayLevel(payLevelId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return payLevel;
	}

	public static List<PersonalNoPrefix> getAllPersonalNoPrefixes() {
		return PersonalNoPrefixLocalServiceUtil.getPersonalNoPrefixes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PersonalNoPrefix getPersonalNoPrefixById(long personalNoPrefixId) {
		PersonalNoPrefix personalNoPrefix = null;
		try {
			personalNoPrefix = PersonalNoPrefixLocalServiceUtil.getPersonalNoPrefix(personalNoPrefixId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return personalNoPrefix;
	}

	public static List<PhType> getAllPhTypes() {
		return PhTypeLocalServiceUtil.getPhTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PhType getPhTypeById(long phTypeId) {
		PhType phType = null;
		try {
			phType = PhTypeLocalServiceUtil.getPhType(phTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}

		return phType;
	}

	public static List<Post> getAllPosts() {
		return PostLocalServiceUtil.getPosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Post getPostById(long postId) {
		Post post = null;
		try {
			post = PostLocalServiceUtil.getPost(postId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return post;
	}

	public static List<PostDelegation> getAllPostDelegations() {
		return PostDelegationLocalServiceUtil.getPostDelegations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PostDelegation getPostDelegationById(long postDelegationId) {
		PostDelegation postDelegation = null;
		try {
			postDelegation = PostDelegationLocalServiceUtil.getPostDelegation(postDelegationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return postDelegation;
	}

	public static List<PostReporting> getAllPostReportings() {
		return PostReportingLocalServiceUtil.getPostReportings(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static PostReporting getPostReportingById(long postReportingId) {
		PostReporting postReporting = null;
		try {
			postReporting = PostReportingLocalServiceUtil.getPostReporting(postReportingId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return postReporting;
	}

	public static List<Qualification> getAllQualifications() {
		return QualificationLocalServiceUtil.getQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Qualification getQualificationById(long qualificationId) {
		Qualification qualification = null;
		try {
			qualification = QualificationLocalServiceUtil.getQualification(qualificationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return qualification;
	}

	public static List<QualificationGrade> getAllQualificationGrades() {
		return QualificationGradeLocalServiceUtil.getQualificationGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static QualificationGrade getQualificationGradeById(long qualificationGradeId) {
		QualificationGrade qualificationGrade = null;
		try {
			qualificationGrade = QualificationGradeLocalServiceUtil.getQualificationGrade(qualificationGradeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return qualificationGrade;
	}

	public static List<QualificationLevel> getAllQualificationLevels() {
		return QualificationLevelLocalServiceUtil.getQualificationLevels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static QualificationLevel getQualificationLevelById(long qualificationLevelId) {
		QualificationLevel qualificationLevel = null;
		try {
			qualificationLevel = QualificationLevelLocalServiceUtil.getQualificationLevel(qualificationLevelId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return qualificationLevel;
	}

	public static List<Religion> getAllReligions() {
		return ReligionLocalServiceUtil.getReligions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Religion getReligionById(long religionId) {
		Religion religion = null;
		try {
			religion = ReligionLocalServiceUtil.getReligion(religionId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return religion;
	}

	public static List<Specialization> getAllSpecializations() {
		return SpecializationLocalServiceUtil.getSpecializations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Specialization getSpecializationById(long specializationId) {
		Specialization specialization = null;
		try {
			specialization = SpecializationLocalServiceUtil.getSpecialization(specializationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return specialization;
	}

	public static List<State> getAllStates() {
		return StateLocalServiceUtil.getStates(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static State getStateById(long stateId) {
		State state = null;
		try {
			state = StateLocalServiceUtil.getState(stateId);
		} catch (PortalException e) {

		}
		return state;
	}

	public static List<TimeFrequency> getAllTimeFrequencies() {
		return TimeFrequencyLocalServiceUtil.getTimeFrequencies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static TimeFrequency getTimeFrequencyById(long timeFrequencyId) {
		TimeFrequency timeFrequency = null;
		try {
			timeFrequency = TimeFrequencyLocalServiceUtil.getTimeFrequency(timeFrequencyId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return timeFrequency;
	}

	public static List<Trade> getAllTrades() {
		return TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static Trade getTradeById(long tradeId) {
		Trade trade = null;
		try {
			trade = TradeLocalServiceUtil.getTrade(tradeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return trade;
	}

	public static List<TrainingCourse> getAllTrainingCourses() {
		return TrainingCourseLocalServiceUtil.getTrainingCourses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static TrainingCourse getTrainingCourseById(long trainingCourseId) {
		TrainingCourse trainingCourse = null;
		try {
			trainingCourse = TrainingCourseLocalServiceUtil.getTrainingCourse(trainingCourseId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return trainingCourse;
	}

	public static List<TrainingInstitute> getAllTrainingInstitutes() {
		return TrainingInstituteLocalServiceUtil.getTrainingInstitutes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static TrainingInstitute getTrainingInstituteById(long trainingInstituteId) {
		TrainingInstitute trainingInstitute = null;
		try {
			trainingInstitute = TrainingInstituteLocalServiceUtil.getTrainingInstitute(trainingInstituteId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return trainingInstitute;
	}

	public static List<VerificationType> getAllVerificationTypes() {
		return VerificationTypeLocalServiceUtil.getVerificationTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static VerificationType getVerificationTypeById(long verificationTypeId) {
		VerificationType verificationType = null;
		try {
			verificationType = VerificationTypeLocalServiceUtil.getVerificationType(verificationTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return verificationType;
	}

	public static List<WorkArea> getAllWorkAreas() {
		return WorkAreaLocalServiceUtil.getWorkAreas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static WorkArea getWorkAreaById(long workAreaId) {
		WorkArea workArea = null;
		try {
			workArea = WorkAreaLocalServiceUtil.getWorkArea(workAreaId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return workArea;
	}

	public static List<WorkAreaType> getAllWorkAreaTypes() {
		return WorkAreaTypeLocalServiceUtil.getWorkAreaTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static WorkAreaType getWorkAreaTypeById(long workAreaTypeId) {
		WorkAreaType workAreaType = null;
		try {
			workAreaType = WorkAreaTypeLocalServiceUtil.getWorkAreaType(workAreaTypeId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return workAreaType;
	}

	public static List<WorkStation> getAllWorkStations() {
		return WorkStationLocalServiceUtil.getWorkStations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public static WorkStation getWorkStationById(long workStationId) {
		WorkStation workStation = null;
		try {
			workStation = WorkStationLocalServiceUtil.getWorkStation(workStationId);
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		return workStation;
	}

	public static List<String> getOrganizationTypes(){
		List<String> types=new ArrayList<String>();
		try {
			types = Arrays.asList(OrganizationLocalServiceUtil.getTypes());
		}catch(Exception e) {}
		return types;
	}

	private static RequestConfig buildRequestConfig() {
		int connTimeout = 0;
		try {
			connTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.connection.timeout")));
		}catch(Exception e) {}

		int connReqTimeout = 0;
		try {
			connReqTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.connection.request.timeout")));
		}catch(Exception e) {}

		int socketTimeout = 0;
		try {
			socketTimeout=Integer.parseInt(StringUtils.trim(PropsUtil.get("remote.socket.timeout")));
		}catch(Exception e) {}


		if(connTimeout<=0) {
			connTimeout=1000;
		}

		if(connReqTimeout<=0) {
			connReqTimeout=1000;
		}

		if(socketTimeout<=0) {
			socketTimeout=1000;
		}

		RequestConfig config = RequestConfig.custom().setConnectTimeout(connTimeout).setConnectionRequestTimeout(connReqTimeout).setSocketTimeout(socketTimeout).build();
		return config;
	}

	public static boolean createEgovSection(OrganizationDetail organizationByParentIdAndName) throws PortalException {
		String eGovURL=PropsUtil.get("egov.create.section.endpoint");
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();

		OrganizationDetail unit = OrganizationDetailLocalServiceUtil.getOrganizationDetail(organizationByParentIdAndName.getParentId());
		OrganizationDetail division = OrganizationDetailLocalServiceUtil.getOrganizationDetail(unit.getParentId());

		if("section".equalsIgnoreCase(organizationByParentIdAndName.getType())) {
			if(!StringUtils.equals("",organizationByParentIdAndName.getLongName())) {

				attributes.add("sectiondescription");
				oldValues.add("");
				newValues.add(organizationByParentIdAndName.getLongName());
			}
			if(!StringUtils.equals("",organizationByParentIdAndName.getOrganizationCode())) {

				attributes.add("sectioncode");
				oldValues.add("");
				newValues.add(organizationByParentIdAndName.getOrganizationCode());
			}
			if(!StringUtils.equals("",organizationByParentIdAndName.getShortName())) {

				attributes.add("section");
				oldValues.add("");
				newValues.add(organizationByParentIdAndName.getShortName());
			}
			if(!StringUtils.equals("",unit.getOrganizationCode())) {

				attributes.add("unitcode");
				oldValues.add("");
				newValues.add(unit.getOrganizationCode());
			}
			if(!StringUtils.equals("",unit.getShortName())) {

				attributes.add("unit");
				oldValues.add("");
				newValues.add(unit.getShortName());
			}

			if(!StringUtils.equals("",unit.getLongName())) {

				attributes.add("unitdescription");
				oldValues.add("");
				newValues.add(unit.getLongName());
			}

			if(!StringUtils.equals("",division.getOrganizationCode())) {

				attributes.add("divisioncode");
				oldValues.add("");
				newValues.add(division.getOrganizationCode());
			}
			if(!StringUtils.equals("",division.getShortName())) {

				attributes.add("division");
				oldValues.add("");
				newValues.add(division.getShortName());
			}

			if(!StringUtils.equals("",division.getLongName())) {

				attributes.add("divisiondescription");
				oldValues.add("");
				newValues.add(division.getLongName());
			}
		}

		createSectionJson( attributes, oldValues, newValues);
		_logger.info("Before......PISUserUtil.updateIDAMUser");
		return false;
	}



	public static boolean createSectionJson(List<String> attributes, List<String> oldValues, List<String> newValues) {
		if(attributes.isEmpty()) {
			return true;
		}

		String[] arrAttributes=null;
		String[] arrOldValues=null;
		String[] arrNewValues=null;

		if(attributes.size()>0) {
			arrAttributes=new String[attributes.size()];
		}

		if(oldValues.size()>0) {
			arrOldValues=new String[oldValues.size()];
		}

		if(newValues.size()>0) {
			arrNewValues=new String[newValues.size()];
		}

		try {
			if(arrAttributes!=null) {
				for(int i=0;i<attributes.size();i++) {
					arrAttributes[i]=attributes.get(i);
				}
			}

			if(arrOldValues!=null) {
				for(int i=0;i<oldValues.size();i++) {
					arrOldValues[i]=oldValues.get(i);
				}
			}

			if(arrNewValues!=null) {
				for(int i=0;i<newValues.size();i++) {
					arrNewValues[i]=newValues.get(i);
				}
			}

			_logger.info("Before......PISUserUtil.createSection");
			createSectionJson(arrAttributes, arrOldValues, arrNewValues);
			return true;
		}catch(Exception e) {
			_logger.error(e.getMessage());
		}
		return false;
	}
	public static boolean createSectionJson( String[] attributes, String[] oldValues, String[] newValues) {
		_logger.info("Entring createSectionJson("+""+", {"+attributes+"}, {"+oldValues+"}, {"+newValues+"}");
		//JSONObject jsonObjects=JSONFactoryUtil.createJSONObject();
		if(attributes==null || attributes.length==0 ) {
			return false;
		}

		_logger.info("Before for loop ....");
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		for(int i=0;i<attributes.length;i++) {
			String attribute=attributes[i];

			JSONArray arrayOps=JSONFactoryUtil.createJSONArray();

			if(oldValues!=null && oldValues.length>i) {
				String oldValue=oldValues[i];
				JSONObject jsonRemove=JSONFactoryUtil.createJSONObject();
				JSONArray jsonRemoveArray=JSONFactoryUtil.createJSONArray();
				jsonRemoveArray.put(oldValue);
				jsonRemove.put("remove", jsonRemoveArray);
				arrayOps.put(jsonRemove);
			}

			if(newValues!=null && newValues.length>i) {
				String newValue=newValues[i];
				JSONObject jsonAdd=JSONFactoryUtil.createJSONObject();
				JSONArray jsonAddArray=JSONFactoryUtil.createJSONArray();
				jsonAddArray.put(newValue);
				jsonAdd.put("add", jsonAddArray);
				arrayOps.put(jsonAdd);
			}
			jsonObject.put(attribute, arrayOps);

		}
		_logger.info("jsonObject.length() ...."+jsonObject.length());
		if(jsonObject.length()>0) {
			String jsonData=jsonObject.toJSONString();

			_logger.info(jsonData);
			String egovUrl=getEgovAPIEndPoint();
			try {
				return invokeEgovSectionCreationAPI(egovUrl, jsonData);
			} catch (Exception e) {
				_logger.error(e.getMessage());
			}
			return false;
		}
		return false;
	}

	private static String getEgovAPIEndPoint() {
		// TODO Auto-generated method stub
		String eGovURL=PropsUtil.get("egov.create.section.endpoint");
		return eGovURL;
	}

	private static boolean invokeEgovSectionCreationAPI(String egovUrl, String jsonData) throws Exception {
		_logger.info("invokeUpdateAPI("+egovUrl+","+ ""+",jsonData)");
		_logger.info(jsonData);

		RequestConfig config = buildRequestConfig();

		String endPointURL=egovUrl;

		try (CloseableHttpClient httpclient = HttpClientBuilder.create()
				.setDefaultRequestConfig(config).build()) {
			HttpPut httpPut = new HttpPut(endPointURL);
			httpPut.setHeader("Accept", "*/*");
			httpPut.setHeader("Content-type", "application/json");

			StringEntity stringEntity = new StringEntity(jsonData);
			httpPut.setEntity(stringEntity);
			_logger.info("Executing request " + httpPut.getRequestLine());
			//ResponseHandler<String> responseHandler = response -> {
			ResponseHandler<Integer> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				_logger.info(status+" - received from "+endPointURL);

				if (status >= 200 && status < 300) {
					//HttpEntity entity = response.getEntity();
					//return entity != null ? EntityUtils.toString(entity) : null;
					return status;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			//String responseBody = httpclient.execute(httpPut, responseHandler);
			int responseBody = httpclient.execute(httpPut, responseHandler);
			_logger.info("responseBody : "+ responseBody);
			//LOGGER.info(responseBody);
			//if(!responseBody.toLowerCase().contains("error") && !responseBody.toLowerCase().contains("fail")) {
			if (responseBody >= 200 && responseBody < 300) {	
				return true;
			}else {
				throw new IOException("User updation failed by the end point system.");
			}

		} catch (Exception e) {
			_logger.error(e);
			throw e;
		}
	}
}
