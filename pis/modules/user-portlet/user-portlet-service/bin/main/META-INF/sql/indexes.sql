create index IX_24F45994 on UP_UserPortlet (portletId[$COLUMN_LENGTH:75$]);
create index IX_DC81CCA5 on UP_UserPortlet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_94EF3867 on UP_UserPortlet (uuid_[$COLUMN_LENGTH:75$], groupId);