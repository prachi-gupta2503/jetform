create table mdm_AccomodationType (
	accomodationTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_AmountType (
	amountTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Appellation (
	appellationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Application (
	applicationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	oemId LONG,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_BenefitScheme (
	benefitSchemeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	effectiveFrom DATE null,
	effectiveRate DOUBLE,
	effectiveUpto DATE null,
	name VARCHAR(75) null,
	frequencyId INTEGER,
	rateTypeId INTEGER,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_BloodGroup (
	bloodGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Cadre (
	cadreId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	designationGroupId LONG,
	rank_ INTEGER,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_CadreDesignation (
	cadreDesignationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cadreId LONG,
	designationId LONG,
	rank_ INTEGER,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_CasteCategory (
	casteCategoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Country (
	countryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ INTEGER,
	shortCode VARCHAR(75) null,
	name VARCHAR(75) null
);

create table mdm_Course (
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	categoryId VARCHAR(75) null,
	subjectOfTrainingId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_CourseCategory (
	courseCategoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DeputationType (
	deputationTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Designation (
	designationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name_En VARCHAR(75) null,
	name_Hi VARCHAR(75) null,
	shortName VARCHAR(75) null,
	longName VARCHAR(75) null,
	description VARCHAR(75) null,
	designationClassId LONG,
	designationGroupId LONG,
	designationGroup VARCHAR(75) null,
	gradeId LONG,
	organizationType VARCHAR(75) null,
	sequenceNo VARCHAR(75) null,
	rank_ INTEGER,
	scopeType INTEGER,
	scopeOrganizationId LONG,
	scopeOrganizationTypeId LONG,
	scopePostId LONG,
	designationModeId LONG,
	successorGradeId LONG,
	scopeOrganizationName VARCHAR(75) null,
	scopePostName VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DesignationClass (
	designationClassId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DesignationGrade (
	designationGradeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DesignationGroup (
	designationGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	uuid_ VARCHAR(75) null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DesignationMode (
	designationModeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DesignationScope (
	designationScopeId LONG not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	designationId LONG not null,
	scopeType INTEGER,
	scopeOrganizationId LONG,
	scopeOrganizationTypeId LONG,
	scopePostId LONG,
	deleted BOOLEAN,
	status INTEGER,
	primary key (designationScopeId, designationId)
);

create table mdm_Disease (
	diseaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DiseaseType (
	diseaseTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_District (
	districtId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	stateId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Document (
	documentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	path_ VARCHAR(75) null,
	refNo VARCHAR(75) null,
	typeId VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_DocumentType (
	documentTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Experience (
	experienceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_FamilyRelation (
	familyRelationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Gender (
	genderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Grade (
	gradeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_GradeMode (
	gradeModeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_JoiningMode (
	joiningModeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_LevelWisePayStructure (
	levelWisePayStructureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	fromDate DATE null,
	toDate DATE null,
	levelId LONG,
	structureId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Location (
	locationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	addressId LONG,
	city VARCHAR(75) null,
	stateId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_MaritalStatus (
	maritalStatusId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_MasterEntity (
	masterEntityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	entityClass VARCHAR(75) null,
	icon VARCHAR(75) null,
	link VARCHAR(1024) null,
	description VARCHAR(1024) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_OEM (
	oemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Occupation (
	occupationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_OccupationServiceType (
	occupationServiceTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Organization (
	organizationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	physicalUnit BOOLEAN,
	parentId LONG,
	typeId LONG,
	headOfUnitId LONG,
	code_ VARCHAR(75) null
);

create table mdm_OrganizationDetail (
	organizationDetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	organizationId LONG,
	organizationCode VARCHAR(75) null,
	parentId LONG,
	parentCode VARCHAR(75) null,
	type_ VARCHAR(75) null,
	shortName VARCHAR(75) null,
	longName VARCHAR(75) null,
	division VARCHAR(75) null,
	addressedTo VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	address3 VARCHAR(75) null,
	city VARCHAR(75) null,
	district VARCHAR(75) null,
	stateId LONG,
	zone VARCHAR(75) null,
	pin VARCHAR(75) null,
	nearestRailwayStation VARCHAR(75) null,
	telegram VARCHAR(75) null,
	fax VARCHAR(75) null,
	telex VARCHAR(75) null,
	telephone1 VARCHAR(75) null,
	telephone2 VARCHAR(75) null,
	stationId VARCHAR(75) null,
	unitType VARCHAR(75) null,
	orgStatus VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_OrganizationHierarchy (
	organizationHierarchyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	childId LONG,
	parentId LONG
);

create table mdm_OrganizationHistory (
	organizationHistoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	organizationId LONG,
	previousOrganizationName VARCHAR(75) null,
	previousOrganizationId LONG,
	previousParentOrganizationName VARCHAR(75) null,
	previousParentOrganizationId LONG,
	organizationName VARCHAR(75) null,
	status VARCHAR(75) null
);

create table mdm_OrganizationLocation (
	organizationLocationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	locationId LONG,
	organizationId LONG,
	addressId LONG,
	contactId LONG
);

create table mdm_OrganizationPayStructure (
	organizationPayStructureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	fromDate DATE null,
	toDate DATE null,
	levelId LONG,
	organizationId LONG,
	structureId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_OrganizationStation (
	organizationStationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_OrganizationType (
	organizationTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	longName VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_OrganizationTypeHierarchy (
	organizationTypeHierarchyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	childId LONG,
	parentId LONG
);

create table mdm_PayComponent (
	payComponentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	amount DOUBLE,
	amountType VARCHAR(75) null,
	fromDate DATE null,
	toDate DATE null,
	dependantId LONG,
	headId LONG,
	structureId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PayHead (
	payHeadId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	code_ VARCHAR(75) null,
	disbursePeriod INTEGER,
	fromDate DATE null,
	name VARCHAR(75) null,
	nonTaxable BOOLEAN,
	toDate DATE null,
	headTypeId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PayHeadType (
	payHeadTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	code_ VARCHAR(75) null,
	deduction BOOLEAN,
	deductionType INTEGER,
	fromDate DATE null,
	name VARCHAR(75) null,
	toDate DATE null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PayLevel (
	payLevelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PayStructure (
	payStructureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	currency_ VARCHAR(75) null,
	effectiveDate DATE null,
	expiryDate DATE null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PersonalNoPrefix (
	personalNoPrefixId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	fromDate DATE null,
	prefix VARCHAR(75) null,
	toDate DATE null,
	desigClassId LONG,
	desigGradeId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PhType (
	phTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Post (
	postId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name_En VARCHAR(75) null,
	name_Hi VARCHAR(75) null,
	designationId LONG,
	postBox BOOLEAN,
	description VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PostDelegation (
	postDelegationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	delegationType VARCHAR(75) null,
	delegatedPostId LONG,
	postId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PostHierarchy (
	postHierarchyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lowerPostId LONG,
	upperPostId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PostOrganization (
	postOrganizationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	postId LONG,
	organizationId LONG,
	postBox BOOLEAN,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_PostReporting (
	postReportingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	reporteePostId LONG,
	reporterPostId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Qualification (
	qualificationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	shortName VARCHAR(75) null,
	fullName VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_QualificationGrade (
	qualificationGradeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_QualificationLevel (
	qualificationLevelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_QualificationSubject (
	qualificationSubjectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Religion (
	religionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_ServiceRequestType (
	serviceRequestTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	className VARCHAR(75) null,
	action VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Specialization (
	specializationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_State (
	stateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	countryId LONG,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_SubjectOfQualification (
	subjectOfQualificationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	subjectOfQualification VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_SubjectOfTraining (
	subjectOfTrainingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	trainingSubject VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_TimeFrequency (
	timeFrequencyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_Trade (
	tradeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	parentId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_TrainingCourse (
	trainingCourseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	institution VARCHAR(75) null,
	locationOfInstitute VARCHAR(75) null,
	name VARCHAR(75) null,
	organizationId LONG,
	specializationId LONG,
	stateInstituteId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_TrainingInstitute (
	trainingInstituteId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	locationId LONG,
	stateId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_TrainingSubject (
	trainingSubjectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_UnitType (
	unitTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null,
	shortDiscription VARCHAR(75) null,
	longDiscription VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_VerificationType (
	verificationTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_WorkArea (
	workAreaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	workAreaTypeId LONG,
	parentWorkAreaId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_WorkAreaMajor (
	workAreaMajorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	workAreaTypeId LONG,
	parentWorkAreaId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_WorkAreaMinor (
	workAreaMinorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	workAreaMajorId LONG,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_WorkAreaType (
	workAreaTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);

create table mdm_WorkStation (
	workStationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	deskNo VARCHAR(75) null,
	extnNo VARCHAR(75) null,
	directNo VARCHAR(75) null,
	phoneNo VARCHAR(75) null,
	cabinNo VARCHAR(75) null,
	floorNo VARCHAR(75) null,
	deleted BOOLEAN,
	status INTEGER
);