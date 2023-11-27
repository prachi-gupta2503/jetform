create table comnetportal_Notification (
	uuid_ VARCHAR(75) null,
	notificationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	topic VARCHAR(75) null,
	clientId VARCHAR(75) null,
	message VARCHAR(75) null,
	status INTEGER,
	statusDate DATE null
);