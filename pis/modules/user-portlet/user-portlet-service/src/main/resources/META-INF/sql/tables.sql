create table UP_UserPortlet (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	portletId VARCHAR(75) null,
	thumbnail VARCHAR(75) null,
	added BOOLEAN
);