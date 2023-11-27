create table OFB_DashboardWidget (
	uuid_ VARCHAR(75) null,
	dashboardWidgetId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	portletName VARCHAR(75) null,
	thumbnail VARCHAR(75) null,
	added BOOLEAN
);