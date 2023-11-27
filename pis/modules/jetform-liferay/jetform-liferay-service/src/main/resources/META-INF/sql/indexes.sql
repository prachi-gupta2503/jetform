create index IX_6E081A7A on jetform_EntityWorkflow (className[$COLUMN_LENGTH:75$], classPK);

create index IX_EF54CFE5 on jetform_FormDefinition (formClass[$COLUMN_LENGTH:75$]);
create index IX_ED0EF4B3 on jetform_FormDefinition (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_63230BF5 on jetform_FormDefinition (uuid_[$COLUMN_LENGTH:75$], groupId);