create index IX_CF565264 on comnet_ApplicationAccess (applicationId);
create index IX_73C39354 on comnet_ApplicationAccess (employeeId);

create index IX_213708BB on comnet_ApplicationUser (employeeId);
create index IX_30703D36 on comnet_ApplicationUser (loginId[$COLUMN_LENGTH:75$]);