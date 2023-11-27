create index IX_BEBA953F on pis_Address (accomodationTypeId);
create index IX_A7E9F432 on pis_Address (districtId);
create index IX_70C3BBC5 on pis_Address (joiningProcessId, accomodationTypeId);
create index IX_F3218F27 on pis_Address (stateId);

create index IX_DEEDAD48 on pis_DeputationProcess (approverUserId);
create index IX_2DBB9488 on pis_DeputationProcess (reviewerUserId);
create index IX_61855CDD on pis_DeputationProcess (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5789769F on pis_DeputationProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B67B774F on pis_DeputationProcessRequest (employeeId);
create index IX_A8E67326 on pis_DeputationProcessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_539D8B28 on pis_DeputationProcessRequest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9CF776EB on pis_Employee (cadreId);
create index IX_34244810 on pis_Employee (designationGroupId);
create index IX_7BAB6BA9 on pis_Employee (designationId);
create index IX_F662C48E on pis_Employee (emailId[$COLUMN_LENGTH:75$]);
create index IX_F78DDF42 on pis_Employee (gpfNpsNo[$COLUMN_LENGTH:75$]);
create index IX_B9D5892F on pis_Employee (gradeId, status);
create index IX_43EB898C on pis_Employee (gradeModeId);
create index IX_E33103D7 on pis_Employee (groupId, status);
create index IX_B749899E on pis_Employee (groupId, tradeId, gradeId, designationId);
create index IX_4D90175F on pis_Employee (joiningProcessId);
create index IX_1185B9DB on pis_Employee (loginId[$COLUMN_LENGTH:75$]);
create index IX_3E8816FD on pis_Employee (organizationId, designationGroupId, tradeId, gradeId, designationId);
create index IX_F7C090C0 on pis_Employee (organizationId, groupId, tradeId, gradeId, designationId);
create index IX_8F4B7250 on pis_Employee (organizationId, personalNo[$COLUMN_LENGTH:75$]);
create index IX_D5156C17 on pis_Employee (peopleId);
create index IX_CAD88B50 on pis_Employee (personalNo[$COLUMN_LENGTH:75$], organizationId);
create index IX_D7346BD4 on pis_Employee (retirementDate);
create index IX_C615A8BF on pis_Employee (status);
create index IX_1BE4B2C5 on pis_Employee (subOrganizationId);
create index IX_A4E04656 on pis_Employee (tradeId);
create index IX_6794C213 on pis_Employee (userId);
create index IX_20BE308D on pis_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9D43764F on pis_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E10B5A31 on pis_EmployeeAddress (accomodationTypeId);
create index IX_11BFCB24 on pis_EmployeeAddress (districtId);
create index IX_75AEE44 on pis_EmployeeAddress (employeeId);
create index IX_635A6D75 on pis_EmployeeAddress (stateId);

create index IX_F2750820 on pis_EmployeeApplication (employeeId);

create index IX_E1AD70E4 on pis_EmployeeApplicationAccess (employeeId);
create index IX_C091EDAD on pis_EmployeeApplicationAccess (loginId[$COLUMN_LENGTH:75$]);

create index IX_DBC90FAC on pis_EmployeeBenefitScheme (employeeId);

create index IX_FDF1D682 on pis_EmployeeBiodata (employeeId);

create index IX_94C4F10B on pis_EmployeeConfirmation (employeeId);
create index IX_170E0917 on pis_EmployeeConfirmation (gradeModeId);
create index IX_90BBD510 on pis_EmployeeConfirmation (organizationId);

create index IX_A462B970 on pis_EmployeeContact (employeeId);

create index IX_A5E1DD7E on pis_EmployeeDelegation (employeeId);

create index IX_4CC002DD on pis_EmployeeDeputation (employeeId);

create index IX_D0BAB287 on pis_EmployeeDesignation (employeeId);

create index IX_FB04FC95 on pis_EmployeeDigitalSignature (cid[$COLUMN_LENGTH:75$]);
create index IX_E7A19996 on pis_EmployeeDigitalSignature (employeeId);

create index IX_AAC9A8DE on pis_EmployeeDocument (documentId);
create index IX_9B94BCF1 on pis_EmployeeDocument (employeeId);

create index IX_549E5F67 on pis_EmployeeDsc (cid[$COLUMN_LENGTH:75$]);
create index IX_A9CCC684 on pis_EmployeeDsc (employeeId);

create index IX_F28AF2C on pis_EmployeeEmail (employeeId);

create index IX_F227EE40 on pis_EmployeeExperience (employeeId);
create index IX_5D432FC5 on pis_EmployeeExperience (organizationId);
create index IX_DDC35AD0 on pis_EmployeeExperience (workAreaId);
create index IX_34DF9F7F on pis_EmployeeExperience (workAreaMinorId);

create index IX_D657643A on pis_EmployeeFamily (employeeId);
create index IX_30BD9497 on pis_EmployeeFamily (occupationId);
create index IX_2DB22088 on pis_EmployeeFamily (relationId);

create index IX_A47DA027 on pis_EmployeeGrade (employeeId);
create index IX_FE6B3D7B on pis_EmployeeGrade (gradeModeId);

create index IX_3414DC8 on pis_EmployeeJoining (employeeId);
create index IX_781D43FA on pis_EmployeeJoining (gradeModeId);
create index IX_3117B1B1 on pis_EmployeeJoining (joiningProcessId);
create index IX_7C118B4D on pis_EmployeeJoining (organizationId);
create index IX_A95062B3 on pis_EmployeeJoining (subOrganizationId);

create index IX_98383517 on pis_EmployeeMessage (employeeId);

create index IX_19878F2B on pis_EmployeeOrganization (employeeId, organizationId);
create index IX_91DC6A15 on pis_EmployeeOrganization (employeeId, subOrganizationId);
create index IX_DD8E2AA0 on pis_EmployeeOrganization (organizationCode[$COLUMN_LENGTH:75$]);
create index IX_9017328E on pis_EmployeeOrganization (organizationId);
create index IX_2A925341 on pis_EmployeeOrganization (personalNo[$COLUMN_LENGTH:75$]);
create index IX_9C919EE4 on pis_EmployeeOrganization (subOrganizationCode[$COLUMN_LENGTH:75$]);
create index IX_17F3377 on pis_EmployeeOrganization (subOrganizationId, active_);

create index IX_BF6B2EF2 on pis_EmployeePastExperience (employeeId);
create index IX_725A8B5B on pis_EmployeePastExperience (joiningProcessId);
create index IX_AB069B82 on pis_EmployeePastExperience (workAreaId);

create index IX_A8A47801 on pis_EmployeePayStructure (employeeId);

create index IX_828B45E5 on pis_EmployeePermission (employeeId);
create index IX_B08DDB00 on pis_EmployeePermission (form[$COLUMN_LENGTH:75$]);
create index IX_5D1C600E on pis_EmployeePermission (joiningProcessId);
create index IX_FA32B79 on pis_EmployeePermission (registrationRequestId);
create index IX_21980EE5 on pis_EmployeePermission (singleUserOnboardingId);

create index IX_61BE4936 on pis_EmployeePost (employeeId);

create index IX_D3B2973 on pis_EmployeePromotion (employeeId);
create index IX_AD5EDDAF on pis_EmployeePromotion (gradeModeId);
create index IX_F90F9978 on pis_EmployeePromotion (organizationId);

create index IX_8747773F on pis_EmployeeQualification (employeeId);
create index IX_8F20A5E8 on pis_EmployeeQualification (joiningProcessId);
create index IX_914823CD on pis_EmployeeQualification (levelId);
create index IX_38AD9CB8 on pis_EmployeeQualification (qualificationId);
create index IX_335D509C on pis_EmployeeQualification (specializationId);

create index IX_BB1DE3BE on pis_EmployeeReporting (employeeId);
create index IX_A05F8533 on pis_EmployeeReporting (reportingToId);

create index IX_FBEDBC95 on pis_EmployeeSavingScheme (employeeId);

create index IX_162496F4 on pis_EmployeeTrade (employeeId);

create index IX_2D8FFA70 on pis_EmployeeTraining (employeeId);
create index IX_8FA1C6CD on pis_EmployeeTraining (instituteId);
create index IX_5069A3F5 on pis_EmployeeTraining (organizationId);

create index IX_50C77C1 on pis_EmployeeTransfer (employeeId);
create index IX_8559B590 on pis_EmployeeTransfer (fromOrganizationId);
create index IX_AFB75921 on pis_EmployeeTransfer (gradeModeId);
create index IX_72E4BE1 on pis_EmployeeTransfer (toOrganizationId);

create index IX_4B59F071 on pis_EmployeeVerification (employeeId);
create index IX_A4ABF19A on pis_EmployeeVerification (joiningProcessId);
create index IX_EC56B176 on pis_EmployeeVerification (organizationId);

create index IX_D7790DD4 on pis_EmployeeWorkArea (employeeId);
create index IX_CA54C86F on pis_EmployeeWorkArea (workAreaMajorId);

create index IX_40306293 on pis_EmployeeWorkstation (employeeId);

create index IX_BBFC880A on pis_Employee_transferProcess (companyId);
create index IX_88C30FB on pis_Employee_transferProcess (employeeId);

create index IX_3FC7FB21 on pis_JoiningProcess (approverUserId);
create index IX_8E95E261 on pis_JoiningProcess (reviewerUserId);
create index IX_DCA6B275 on pis_JoiningProcess (unitId);
create index IX_F5039876 on pis_JoiningProcess (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B863C478 on pis_JoiningProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C693A96D on pis_JoiningProcessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F1E1A72F on pis_JoiningProcessRequest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8E5CDF68 on pis_OrganizationAssignment (employeeId);
create index IX_B6A5293F on pis_OrganizationAssignment (organizationCode[$COLUMN_LENGTH:75$]);
create index IX_5CB4CED on pis_OrganizationAssignment (organizationId);
create index IX_E5F87520 on pis_OrganizationAssignment (personalNo[$COLUMN_LENGTH:75$]);
create index IX_977A27E5 on pis_OrganizationAssignment (subOrganizationCode[$COLUMN_LENGTH:75$]);
create index IX_F0FBBD13 on pis_OrganizationAssignment (subOrganizationId);

create index IX_45C4BE42 on pis_People (appellationId);
create index IX_B403F4CE on pis_People (bloodGroupId);
create index IX_C5D73955 on pis_People (casteCategoryId);
create index IX_FC4EC3D5 on pis_People (citizenshipId);
create index IX_ED45CDD0 on pis_People (dateOfBirth);
create index IX_29376AEA on pis_People (genderId);
create index IX_1CA08E00 on pis_People (joiningProcessId);
create index IX_F4F64637 on pis_People (maritalStatusId);
create index IX_58AC1CFB on pis_People (phTypeId);
create index IX_3F8C3E5A on pis_People (religionId);

create index IX_F62BEA29 on pis_ProcessFile (employeeId);
create index IX_FCFF1C50 on pis_ProcessFile (processFileNo);
create index IX_F707DA80 on pis_ProcessFile (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8DC50102 on pis_ProcessFile (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FF08F216 on pis_PromotionProcess (approverUserId);
create index IX_4DD6D956 on pis_PromotionProcess (reviewerUserId);
create index IX_E7E2A62B on pis_PromotionProcess (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_77A4BB6D on pis_PromotionProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FBC757C1 on pis_PromotionProcessRequest (employeeId);
create index IX_8C50B618 on pis_PromotionProcessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_563FE29A on pis_PromotionProcessRequest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_78D61745 on pis_SampleProcess (approverUserId);
create index IX_C7A3FE85 on pis_SampleProcess (reviewerUserId);
create index IX_22FB3B9A on pis_SampleProcess (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F171E09C on pis_SampleProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D10A9134 on pis_SampleProcessRequest (approverUserId);
create index IX_1FD87874 on pis_SampleProcessRequest (reviewerUserId);
create index IX_3FF8F5C9 on pis_SampleProcessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_49A65A8B on pis_SampleProcessRequest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_180A5BA9 on pis_SeparationProcess (approverUserId);
create index IX_66D842E9 on pis_SeparationProcess (reviewerUserId);
create index IX_C62FF6FE on pis_SeparationProcess (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_90A62500 on pis_SeparationProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E724214E on pis_SeparationProcessRequest (employeeId);
create index IX_6A0161E5 on pis_SeparationProcessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4BD31DA7 on pis_SeparationProcessRequest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5B3FA324 on pis_ServiceRequest (deleted);
create index IX_6006D8A2 on pis_ServiceRequest (employeeId);
create index IX_4E1C310B on pis_ServiceRequest (joiningProcessId);
create index IX_24CEA361 on pis_ServiceRequest (serviceRequestTypeId, deleted);
create index IX_714A770D on pis_ServiceRequest (status, organizationId);
create index IX_7065CD7D on pis_ServiceRequest (userId, subject[$COLUMN_LENGTH:75$]);

create index IX_82EEB132 on pis_ServiceRequestWorkflow (employeeId, className[$COLUMN_LENGTH:75$]);
create index IX_5706F02D on pis_ServiceRequestWorkflow (serviceRequestId);

create index IX_52079845 on pis_SingleUserOnboarding (emailAddress[$COLUMN_LENGTH:75$]);
create index IX_3DBC7B57 on pis_SingleUserOnboarding (groupId, status);
create index IX_3A59EB83 on pis_SingleUserOnboarding (loginId[$COLUMN_LENGTH:75$], status, state_[$COLUMN_LENGTH:75$], idamUserCreated);
create index IX_9F4E7C2E on pis_SingleUserOnboarding (personalNo);
create index IX_10895C7F on pis_SingleUserOnboarding (recordNo);
create index IX_53933D7D on pis_SingleUserOnboarding (sectionId, status);
create index IX_73DDC13F on pis_SingleUserOnboarding (status);
create index IX_1AF925F3 on pis_SingleUserOnboarding (unit[$COLUMN_LENGTH:75$], state_[$COLUMN_LENGTH:75$]);
create index IX_1B00B6F7 on pis_SingleUserOnboarding (unit[$COLUMN_LENGTH:75$], status);
create index IX_8E9965AE on pis_SingleUserOnboarding (unitId, state_[$COLUMN_LENGTH:75$]);
create index IX_8EA0F6B2 on pis_SingleUserOnboarding (unitId, status);
create index IX_155CDA93 on pis_SingleUserOnboarding (userId);
create index IX_17A1A90D on pis_SingleUserOnboarding (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8FAB0ECF on pis_SingleUserOnboarding (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B3F8CD64 on pis_TransferProcess (approverUserId);
create index IX_2C6B4A4 on pis_TransferProcess (reviewerUserId);
create index IX_2048E5F9 on pis_TransferProcess (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2C9496BB on pis_TransferProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D02911B3 on pis_TransferProcessRequest (employeeId);
create index IX_3667B28A on pis_TransferProcessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4E6F538C on pis_TransferProcessRequest (uuid_[$COLUMN_LENGTH:75$], groupId);