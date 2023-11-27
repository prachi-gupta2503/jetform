create table OFB_Noting (
	uuid_ VARCHAR(75) null,
	noteId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	content STRING null,
	title VARCHAR(75) null,
	pdfId LONG
);