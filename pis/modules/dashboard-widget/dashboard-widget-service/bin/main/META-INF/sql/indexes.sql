create index IX_8996A92B on OFB_DashboardWidget (portletName[$COLUMN_LENGTH:75$]);
create index IX_BF72411E on OFB_DashboardWidget (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_34347720 on OFB_DashboardWidget (uuid_[$COLUMN_LENGTH:75$], groupId);