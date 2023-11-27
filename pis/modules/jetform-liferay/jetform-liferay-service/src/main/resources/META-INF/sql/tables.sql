create table jetform_EntityWorkflow (
	entityWorkflowId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	className VARCHAR(75) null,
	classPK LONG,
	remark VARCHAR(75) null
);

create table jetform_FormDefinition (
	uuid_ VARCHAR(75) null,
	formDefinitionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	formKey VARCHAR(75) null,
	formClass VARCHAR(75) null,
	entityClass VARCHAR(75) null,
	definition TEXT null
);

create table jetform_ImportMasterEntity (
	importMasterEntityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	entityClass VARCHAR(75) null,
	description VARCHAR(75) null,
	importFileId LONG
);