create index IX_A567A775 on mdm_Application (code_[$COLUMN_LENGTH:75$]);
create index IX_E5CDA02C on mdm_Application (name[$COLUMN_LENGTH:75$]);
create index IX_F942435 on mdm_Application (oemId);

create index IX_C0C7312C on mdm_Cadre (code_[$COLUMN_LENGTH:75$]);
create index IX_520A8395 on mdm_Cadre (name[$COLUMN_LENGTH:75$]);

create index IX_49CADCF7 on mdm_CadreDesignation (cadreId);
create index IX_34A518B5 on mdm_CadreDesignation (designationId);

create index IX_A27D9540 on mdm_CasteCategory (name[$COLUMN_LENGTH:75$]);

create index IX_8A27D158 on mdm_Course (code_[$COLUMN_LENGTH:75$]);
create index IX_2F3F2DE9 on mdm_Course (name[$COLUMN_LENGTH:75$]);
create index IX_93B219C4 on mdm_Course (subjectOfTrainingId, status);

create index IX_FAFCD8AE on mdm_Designation (code_[$COLUMN_LENGTH:75$]);
create index IX_FFA4B44 on mdm_Designation (designationClassId);
create index IX_A77834B6 on mdm_Designation (designationGroup[$COLUMN_LENGTH:75$], status);
create index IX_F0D4349E on mdm_Designation (designationGroupId, deleted);
create index IX_15A1235B on mdm_Designation (gradeId, deleted);
create index IX_BBEF4A59 on mdm_Designation (name_En[$COLUMN_LENGTH:75$]);
create index IX_E6F01DFA on mdm_Designation (status);

create index IX_FCC39A8B on mdm_DesignationGroup (code_[$COLUMN_LENGTH:75$]);

create index IX_4E602D4B on mdm_DesignationMode (code_[$COLUMN_LENGTH:75$]);
create index IX_6F620796 on mdm_DesignationMode (name[$COLUMN_LENGTH:75$]);

create index IX_F937FFB6 on mdm_DesignationScope (designationId);

create index IX_A3D83585 on mdm_District (code_[$COLUMN_LENGTH:75$]);
create index IX_29E35E2F on mdm_District (districtId, deleted);
create index IX_F0B101C on mdm_District (name[$COLUMN_LENGTH:75$]);
create index IX_A96723AA on mdm_District (stateId, deleted);

create index IX_B7E16803 on mdm_DocumentType (name[$COLUMN_LENGTH:75$]);

create index IX_52B4DD69 on mdm_Experience (code_[$COLUMN_LENGTH:75$]);
create index IX_77C7DBB8 on mdm_Experience (name[$COLUMN_LENGTH:75$]);

create index IX_36B03A8F on mdm_Gender (name[$COLUMN_LENGTH:75$]);

create index IX_E35B0F8E on mdm_Grade (code_[$COLUMN_LENGTH:75$]);
create index IX_743050F3 on mdm_Grade (name[$COLUMN_LENGTH:75$]);

create index IX_CA4CB44E on mdm_OEM (code_[$COLUMN_LENGTH:75$]);
create index IX_4A171433 on mdm_OEM (name[$COLUMN_LENGTH:75$]);

create index IX_DB33AECE on mdm_OrganizationDetail (organizationCode[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_B4D13C67 on mdm_OrganizationDetail (organizationId, parentId, type_[$COLUMN_LENGTH:75$]);
create index IX_BFF29160 on mdm_OrganizationDetail (organizationId, type_[$COLUMN_LENGTH:75$]);
create index IX_12639E52 on mdm_OrganizationDetail (parentCode[$COLUMN_LENGTH:75$], organizationCode[$COLUMN_LENGTH:75$]);
create index IX_D7086D39 on mdm_OrganizationDetail (parentCode[$COLUMN_LENGTH:75$], shortName[$COLUMN_LENGTH:75$]);
create index IX_9E4CEE40 on mdm_OrganizationDetail (parentId, organizationCode[$COLUMN_LENGTH:75$]);
create index IX_93350D0B on mdm_OrganizationDetail (parentId, shortName[$COLUMN_LENGTH:75$]);
create index IX_B6B6C1C9 on mdm_OrganizationDetail (parentId, type_[$COLUMN_LENGTH:75$]);
create index IX_AF842D51 on mdm_OrganizationDetail (shortName[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_9D1261E9 on mdm_OrganizationDetail (stateId);
create index IX_56020376 on mdm_OrganizationDetail (type_[$COLUMN_LENGTH:75$], organizationCode[$COLUMN_LENGTH:75$]);
create index IX_845629CF on mdm_OrganizationDetail (type_[$COLUMN_LENGTH:75$], parentId, organizationCode[$COLUMN_LENGTH:75$]);
create index IX_BCB3245C on mdm_OrganizationDetail (type_[$COLUMN_LENGTH:75$], parentId, shortName[$COLUMN_LENGTH:75$]);
create index IX_98E3E3C5 on mdm_OrganizationDetail (unitType[$COLUMN_LENGTH:75$]);

create index IX_A93B2120 on mdm_OrganizationHistory (organizationId);
create index IX_EF2E9237 on mdm_OrganizationHistory (previousOrganizationId);

create index IX_E3E90F5D on mdm_OrganizationStation (name[$COLUMN_LENGTH:75$]);

create index IX_FBBC41E6 on mdm_OrganizationType (code_[$COLUMN_LENGTH:75$]);
create index IX_5C33739B on mdm_OrganizationType (name[$COLUMN_LENGTH:75$]);

create index IX_F7E4C833 on mdm_Post (code_[$COLUMN_LENGTH:75$]);
create index IX_1E996C9E on mdm_Post (name_En[$COLUMN_LENGTH:75$]);

create index IX_BE775473 on mdm_PostOrganization (postId, organizationId);

create index IX_123F766B on mdm_QualificationGrade (code_[$COLUMN_LENGTH:75$]);
create index IX_3BE51A76 on mdm_QualificationGrade (name[$COLUMN_LENGTH:75$]);

create index IX_43666D5E on mdm_QualificationLevel (code_[$COLUMN_LENGTH:75$]);
create index IX_B959F923 on mdm_QualificationLevel (name[$COLUMN_LENGTH:75$]);

create index IX_566C7F36 on mdm_QualificationSubject (code_[$COLUMN_LENGTH:75$]);
create index IX_56DE4C4B on mdm_QualificationSubject (name[$COLUMN_LENGTH:75$]);

create index IX_5EB1C342 on mdm_Religion (code_[$COLUMN_LENGTH:75$]);
create index IX_361A56BF on mdm_Religion (name[$COLUMN_LENGTH:75$]);

create index IX_EA2716E8 on mdm_Specialization (code_[$COLUMN_LENGTH:75$]);
create index IX_B678F659 on mdm_Specialization (name[$COLUMN_LENGTH:75$]);

create index IX_65648393 on mdm_State (countryId);

create index IX_5B9E4CA1 on mdm_Trade (code_[$COLUMN_LENGTH:75$]);
create index IX_90D7A580 on mdm_Trade (name[$COLUMN_LENGTH:75$]);

create index IX_809B2A1E on mdm_TrainingCourse (code_[$COLUMN_LENGTH:75$]);
create index IX_583AA463 on mdm_TrainingCourse (name[$COLUMN_LENGTH:75$]);

create index IX_B066580A on mdm_TrainingInstitute (code_[$COLUMN_LENGTH:75$]);
create index IX_B49C08F7 on mdm_TrainingInstitute (name[$COLUMN_LENGTH:75$]);

create index IX_26FE1B93 on mdm_TrainingSubject (code_[$COLUMN_LENGTH:75$]);
create index IX_9FA9304E on mdm_TrainingSubject (name[$COLUMN_LENGTH:75$]);

create index IX_45B7F3D5 on mdm_WorkArea (code_[$COLUMN_LENGTH:75$]);
create index IX_4E1247CC on mdm_WorkArea (name[$COLUMN_LENGTH:75$]);
create index IX_A5972604 on mdm_WorkArea (parentWorkAreaId);

create index IX_3D8C21CA on mdm_WorkAreaMajor (code_[$COLUMN_LENGTH:75$]);
create index IX_EAB60737 on mdm_WorkAreaMajor (name[$COLUMN_LENGTH:75$]);
create index IX_D8581CEF on mdm_WorkAreaMajor (parentWorkAreaId);

create index IX_D06AEB4E on mdm_WorkAreaMinor (code_[$COLUMN_LENGTH:75$]);
create index IX_7BD5FD33 on mdm_WorkAreaMinor (name[$COLUMN_LENGTH:75$]);
create index IX_341E83F7 on mdm_WorkAreaMinor (workAreaMajorId, deleted);

create index IX_F79613B on mdm_WorkAreaType (code_[$COLUMN_LENGTH:75$]);
create index IX_6D5A95A6 on mdm_WorkAreaType (name[$COLUMN_LENGTH:75$]);

create index IX_8D289542 on mdm_WorkStation (code_[$COLUMN_LENGTH:75$]);
create index IX_88B3782E on mdm_WorkStation (deskNo[$COLUMN_LENGTH:75$]);