create table comnet_ApplicationAccess (
	applicationAccessId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	employeeId LONG,
	applicationId LONG,
	status INTEGER,
	deleted BOOLEAN
);

create table comnet_ApplicationUser (
	applicationUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	employeeId LONG,
	loginId VARCHAR(75) null,
	status INTEGER,
	deleted BOOLEAN,
	idamUser BOOLEAN,
	emailAccess BOOLEAN,
	digitalSigning BOOLEAN,
	eGovAccess BOOLEAN,
	pisAccess BOOLEAN,
	lastIdamUser BOOLEAN,
	lastEmailAccess BOOLEAN,
	lastDigitalSigning BOOLEAN,
	lastEGovAccess BOOLEAN,
	lastPisAccess BOOLEAN,
	idamServiceStatus BOOLEAN,
	idamServiceMessage VARCHAR(75) null,
	idamUserCreated BOOLEAN
);