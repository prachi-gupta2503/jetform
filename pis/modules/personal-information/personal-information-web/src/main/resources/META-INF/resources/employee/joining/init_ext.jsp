<%@page import="com.adjecti.mdm.liferay.enumeration.model.Gender"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.CasteCategory"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.MaritalStatus"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.BloodGroup"%>
<%@page import="com.adjecti.mdm.liferay.service.EnumerationEntityServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Application"%>
<%@page import="com.adjecti.mdm.liferay.service.OEMLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.OEM"%>
<%@page import="com.adjecti.mdm.liferay.service.DocumentTypeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.DocumentType"%>
<%@page import="com.adjecti.mdm.liferay.service.PostLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeePostLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeModeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.VerificationType"%>
<%@page import="com.adjecti.mdm.liferay.service.VerificationTypeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkArea"%>
<%@page import="com.adjecti.mdm.liferay.model.PostDelegation"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationClassLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.PayLevelLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.PostDelegationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.JoiningModeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>

<%@page import="com.adjecti.mdm.liferay.service.SpecializationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationLevelLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationGradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Specialization"%>
<%@page import="com.adjecti.mdm.liferay.model.QualificationLevel"%>
<%@page import="com.adjecti.mdm.liferay.model.QualificationGrade"%>
<%@page import="com.adjecti.mdm.liferay.model.Qualification"%>
<%@page import="com.adjecti.mdm.liferay.service.PhTypeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.PhType"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.ReligionLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Religion"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationGroup"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationClass"%>
<%@page import="com.adjecti.mdm.liferay.model.PayLevel"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePost"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.model.JoiningMode"%>
<%@page import="com.adjecti.mdm.liferay.model.GradeMode"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>

<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/multistep.form.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script> --%>
<link href="<%=request.getContextPath()%>/css/multistep.form.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css">


<% 
List<Religion> religionList=ReligionLocalServiceUtil.getReligions(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<PhType> phTypeList= PhTypeLocalServiceUtil.getPhTypes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<Qualification> qualifcationList=QualificationLocalServiceUtil.getQualifications(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<QualificationGrade> gradeList=QualificationGradeLocalServiceUtil.getQualificationGrades(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<QualificationLevel> levelList=QualificationLevelLocalServiceUtil.getQualificationLevels(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<Specialization> specializationList=SpecializationLocalServiceUtil.getSpecializations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List <Grade> grades=GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,
		QueryUtil.ALL_POS);
List <Designation> designationList=DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List <JoiningMode> joiningModeList=JoiningModeLocalServiceUtil.getJoiningModes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List <Trade> tradeList=TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List <PostDelegation> postList= PostDelegationLocalServiceUtil.getPostDelegations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List <PayLevel> paylevelList=PayLevelLocalServiceUtil.getPayLevels(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List <DesignationClass> designationClasseList=DesignationClassLocalServiceUtil.getDesignationClasses(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List <DesignationGroup> designationGroupList=DesignationGroupLocalServiceUtil.getDesignationGroups(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<Religion> religions=ReligionLocalServiceUtil.getReligions(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<PhType> phTypes=PhTypeLocalServiceUtil.getPhTypes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<Qualification> qualifications=QualificationLocalServiceUtil.getQualifications(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<Specialization> specializations=SpecializationLocalServiceUtil.getSpecializations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<WorkArea> workAreas=WorkAreaLocalServiceUtil.getWorkAreas(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<VerificationType> verificationTypes=VerificationTypeLocalServiceUtil.getVerificationTypes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

List<GradeMode> gradeModes=GradeModeLocalServiceUtil.getGradeModes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<Post > posts=PostLocalServiceUtil.getPosts(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<DocumentType> documentTypes=DocumentTypeLocalServiceUtil.getDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
List<OEM> oemList=OEMLocalServiceUtil.getOEMs(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<Application> applications=null;
List<BloodGroup> bloodGroupList= EnumerationEntityServiceUtil.getBloodGroups();
List<MaritalStatus> maritalStatusList=	EnumerationEntityServiceUtil.getMaritalStatuses();
List<CasteCategory> casteCategoryList= EnumerationEntityServiceUtil.getCasteCategorys();
List<Gender> genderList=EnumerationEntityServiceUtil.getGenders();
%>
