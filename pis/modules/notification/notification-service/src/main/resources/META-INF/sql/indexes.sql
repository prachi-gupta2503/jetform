create index IX_33336102 on comnetportal_Notification (clientId[$COLUMN_LENGTH:75$]);
create index IX_A96C7A2E on comnetportal_Notification (status);
create index IX_5E9146D1 on comnetportal_Notification (topic[$COLUMN_LENGTH:75$], clientId[$COLUMN_LENGTH:75$]);
create index IX_95AD433C on comnetportal_Notification (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F2E568BE on comnetportal_Notification (uuid_[$COLUMN_LENGTH:75$], groupId);