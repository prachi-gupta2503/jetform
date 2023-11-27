create table OFB_BulkOnbordingFile (
	uuid_ VARCHAR(75) null,
	bulkOnbordingFileId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fileEntryId LONG,
	fileName VARCHAR(75) null,
	remarks VARCHAR(75) null,
	title VARCHAR(75) null,
	totalRecords LONG,
	unitId LONG
);

create table OFB_RegistrationRequest (
	uuid_ VARCHAR(75) null,
	registrationRequestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	recordNo LONG,
	unitId LONG,
	unit VARCHAR(75) null,
	personalNo LONG,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	genderId LONG,
	gender VARCHAR(75) null,
	designationId LONG,
	designation VARCHAR(75) null,
	designationCode VARCHAR(75) null,
	tradeId LONG,
	trade VARCHAR(75) null,
	tradeCode VARCHAR(75) null,
	gradeId LONG,
	grade VARCHAR(75) null,
	gradeCode VARCHAR(75) null,
	dateOfBirth DATE null,
	dateOfJoiningOrganization DATE null,
	casteCategoryId LONG,
	casteCategory VARCHAR(75) null,
	mobile LONG,
	emailAddress VARCHAR(75) null,
	dateOfJoiningUnit DATE null,
	gpfnpsType VARCHAR(75) null,
	gpfnpsNumber LONG,
	sectionId LONG,
	section VARCHAR(75) null,
	sectionCode VARCHAR(75) null,
	loginId VARCHAR(75) null,
	idamUser BOOLEAN,
	emailAccess BOOLEAN,
	digitalSigning BOOLEAN,
	eGovAccess BOOLEAN,
	pisAccess BOOLEAN,
	state_ VARCHAR(75) null,
	idamUserCreated BOOLEAN,
	employeeCreated BOOLEAN,
	appUserCreated BOOLEAN,
	postBox VARCHAR(75) null,
	rank_ LONG,
	errorMessage STRING null,
	bulkOnbordingFileId LONG
);