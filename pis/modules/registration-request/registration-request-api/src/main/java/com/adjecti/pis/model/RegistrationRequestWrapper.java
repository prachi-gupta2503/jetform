/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adjecti.pis.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RegistrationRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequest
 * @generated
 */
public class RegistrationRequestWrapper
	extends BaseModelWrapper<RegistrationRequest>
	implements ModelWrapper<RegistrationRequest>, RegistrationRequest {

	public RegistrationRequestWrapper(RegistrationRequest registrationRequest) {
		super(registrationRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("registrationRequestId", getRegistrationRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("recordNo", getRecordNo());
		attributes.put("unitId", getUnitId());
		attributes.put("unit", getUnit());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("genderId", getGenderId());
		attributes.put("gender", getGender());
		attributes.put("designationId", getDesignationId());
		attributes.put("designation", getDesignation());
		attributes.put("designationCode", getDesignationCode());
		attributes.put("tradeId", getTradeId());
		attributes.put("trade", getTrade());
		attributes.put("tradeCode", getTradeCode());
		attributes.put("gradeId", getGradeId());
		attributes.put("grade", getGrade());
		attributes.put("gradeCode", getGradeCode());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put(
			"dateOfJoiningOrganization", getDateOfJoiningOrganization());
		attributes.put("casteCategoryId", getCasteCategoryId());
		attributes.put("casteCategory", getCasteCategory());
		attributes.put("mobile", getMobile());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("dateOfJoiningUnit", getDateOfJoiningUnit());
		attributes.put("gpfnpsType", getGpfnpsType());
		attributes.put("gpfnpsNumber", getGpfnpsNumber());
		attributes.put("sectionId", getSectionId());
		attributes.put("section", getSection());
		attributes.put("sectionCode", getSectionCode());
		attributes.put("loginId", getLoginId());
		attributes.put("idamUser", isIdamUser());
		attributes.put("emailAccess", isEmailAccess());
		attributes.put("digitalSigning", isDigitalSigning());
		attributes.put("eGovAccess", isEGovAccess());
		attributes.put("pisAccess", isPisAccess());
		attributes.put("state", getState());
		attributes.put("idamUserCreated", isIdamUserCreated());
		attributes.put("employeeCreated", isEmployeeCreated());
		attributes.put("appUserCreated", isAppUserCreated());
		attributes.put("postBox", getPostBox());
		attributes.put("rank", getRank());
		attributes.put("errorMessage", getErrorMessage());
		attributes.put("bulkOnbordingFileId", getBulkOnbordingFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long registrationRequestId = (Long)attributes.get(
			"registrationRequestId");

		if (registrationRequestId != null) {
			setRegistrationRequestId(registrationRequestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long recordNo = (Long)attributes.get("recordNo");

		if (recordNo != null) {
			setRecordNo(recordNo);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		Long personalNo = (Long)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Long genderId = (Long)attributes.get("genderId");

		if (genderId != null) {
			setGenderId(genderId);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		String designationCode = (String)attributes.get("designationCode");

		if (designationCode != null) {
			setDesignationCode(designationCode);
		}

		Long tradeId = (Long)attributes.get("tradeId");

		if (tradeId != null) {
			setTradeId(tradeId);
		}

		String trade = (String)attributes.get("trade");

		if (trade != null) {
			setTrade(trade);
		}

		String tradeCode = (String)attributes.get("tradeCode");

		if (tradeCode != null) {
			setTradeCode(tradeCode);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		String grade = (String)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}

		String gradeCode = (String)attributes.get("gradeCode");

		if (gradeCode != null) {
			setGradeCode(gradeCode);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Date dateOfJoiningOrganization = (Date)attributes.get(
			"dateOfJoiningOrganization");

		if (dateOfJoiningOrganization != null) {
			setDateOfJoiningOrganization(dateOfJoiningOrganization);
		}

		Long casteCategoryId = (Long)attributes.get("casteCategoryId");

		if (casteCategoryId != null) {
			setCasteCategoryId(casteCategoryId);
		}

		String casteCategory = (String)attributes.get("casteCategory");

		if (casteCategory != null) {
			setCasteCategory(casteCategory);
		}

		Long mobile = (Long)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Date dateOfJoiningUnit = (Date)attributes.get("dateOfJoiningUnit");

		if (dateOfJoiningUnit != null) {
			setDateOfJoiningUnit(dateOfJoiningUnit);
		}

		String gpfnpsType = (String)attributes.get("gpfnpsType");

		if (gpfnpsType != null) {
			setGpfnpsType(gpfnpsType);
		}

		Long gpfnpsNumber = (Long)attributes.get("gpfnpsNumber");

		if (gpfnpsNumber != null) {
			setGpfnpsNumber(gpfnpsNumber);
		}

		Long sectionId = (Long)attributes.get("sectionId");

		if (sectionId != null) {
			setSectionId(sectionId);
		}

		String section = (String)attributes.get("section");

		if (section != null) {
			setSection(section);
		}

		String sectionCode = (String)attributes.get("sectionCode");

		if (sectionCode != null) {
			setSectionCode(sectionCode);
		}

		String loginId = (String)attributes.get("loginId");

		if (loginId != null) {
			setLoginId(loginId);
		}

		Boolean idamUser = (Boolean)attributes.get("idamUser");

		if (idamUser != null) {
			setIdamUser(idamUser);
		}

		Boolean emailAccess = (Boolean)attributes.get("emailAccess");

		if (emailAccess != null) {
			setEmailAccess(emailAccess);
		}

		Boolean digitalSigning = (Boolean)attributes.get("digitalSigning");

		if (digitalSigning != null) {
			setDigitalSigning(digitalSigning);
		}

		Boolean eGovAccess = (Boolean)attributes.get("eGovAccess");

		if (eGovAccess != null) {
			setEGovAccess(eGovAccess);
		}

		Boolean pisAccess = (Boolean)attributes.get("pisAccess");

		if (pisAccess != null) {
			setPisAccess(pisAccess);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Boolean idamUserCreated = (Boolean)attributes.get("idamUserCreated");

		if (idamUserCreated != null) {
			setIdamUserCreated(idamUserCreated);
		}

		Boolean employeeCreated = (Boolean)attributes.get("employeeCreated");

		if (employeeCreated != null) {
			setEmployeeCreated(employeeCreated);
		}

		Boolean appUserCreated = (Boolean)attributes.get("appUserCreated");

		if (appUserCreated != null) {
			setAppUserCreated(appUserCreated);
		}

		String postBox = (String)attributes.get("postBox");

		if (postBox != null) {
			setPostBox(postBox);
		}

		Long rank = (Long)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
		}

		String errorMessage = (String)attributes.get("errorMessage");

		if (errorMessage != null) {
			setErrorMessage(errorMessage);
		}

		Long bulkOnbordingFileId = (Long)attributes.get("bulkOnbordingFileId");

		if (bulkOnbordingFileId != null) {
			setBulkOnbordingFileId(bulkOnbordingFileId);
		}
	}

	/**
	 * Returns the app user created of this registration request.
	 *
	 * @return the app user created of this registration request
	 */
	@Override
	public boolean getAppUserCreated() {
		return model.getAppUserCreated();
	}

	/**
	 * Returns the bulk onbording file ID of this registration request.
	 *
	 * @return the bulk onbording file ID of this registration request
	 */
	@Override
	public long getBulkOnbordingFileId() {
		return model.getBulkOnbordingFileId();
	}

	/**
	 * Returns the caste category of this registration request.
	 *
	 * @return the caste category of this registration request
	 */
	@Override
	public String getCasteCategory() {
		return model.getCasteCategory();
	}

	/**
	 * Returns the caste category ID of this registration request.
	 *
	 * @return the caste category ID of this registration request
	 */
	@Override
	public long getCasteCategoryId() {
		return model.getCasteCategoryId();
	}

	/**
	 * Returns the company ID of this registration request.
	 *
	 * @return the company ID of this registration request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this registration request.
	 *
	 * @return the create date of this registration request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of birth of this registration request.
	 *
	 * @return the date of birth of this registration request
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the date of joining organization of this registration request.
	 *
	 * @return the date of joining organization of this registration request
	 */
	@Override
	public Date getDateOfJoiningOrganization() {
		return model.getDateOfJoiningOrganization();
	}

	/**
	 * Returns the date of joining unit of this registration request.
	 *
	 * @return the date of joining unit of this registration request
	 */
	@Override
	public Date getDateOfJoiningUnit() {
		return model.getDateOfJoiningUnit();
	}

	/**
	 * Returns the designation of this registration request.
	 *
	 * @return the designation of this registration request
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the designation code of this registration request.
	 *
	 * @return the designation code of this registration request
	 */
	@Override
	public String getDesignationCode() {
		return model.getDesignationCode();
	}

	/**
	 * Returns the designation ID of this registration request.
	 *
	 * @return the designation ID of this registration request
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the digital signing of this registration request.
	 *
	 * @return the digital signing of this registration request
	 */
	@Override
	public boolean getDigitalSigning() {
		return model.getDigitalSigning();
	}

	/**
	 * Returns the e gov access of this registration request.
	 *
	 * @return the e gov access of this registration request
	 */
	@Override
	public boolean getEGovAccess() {
		return model.getEGovAccess();
	}

	/**
	 * Returns the email access of this registration request.
	 *
	 * @return the email access of this registration request
	 */
	@Override
	public boolean getEmailAccess() {
		return model.getEmailAccess();
	}

	/**
	 * Returns the email address of this registration request.
	 *
	 * @return the email address of this registration request
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the employee created of this registration request.
	 *
	 * @return the employee created of this registration request
	 */
	@Override
	public boolean getEmployeeCreated() {
		return model.getEmployeeCreated();
	}

	/**
	 * Returns the error message of this registration request.
	 *
	 * @return the error message of this registration request
	 */
	@Override
	public String getErrorMessage() {
		return model.getErrorMessage();
	}

	/**
	 * Returns the first name of this registration request.
	 *
	 * @return the first name of this registration request
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the gender of this registration request.
	 *
	 * @return the gender of this registration request
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the gender ID of this registration request.
	 *
	 * @return the gender ID of this registration request
	 */
	@Override
	public long getGenderId() {
		return model.getGenderId();
	}

	/**
	 * Returns the gpfnps number of this registration request.
	 *
	 * @return the gpfnps number of this registration request
	 */
	@Override
	public long getGpfnpsNumber() {
		return model.getGpfnpsNumber();
	}

	/**
	 * Returns the gpfnps type of this registration request.
	 *
	 * @return the gpfnps type of this registration request
	 */
	@Override
	public String getGpfnpsType() {
		return model.getGpfnpsType();
	}

	/**
	 * Returns the grade of this registration request.
	 *
	 * @return the grade of this registration request
	 */
	@Override
	public String getGrade() {
		return model.getGrade();
	}

	/**
	 * Returns the grade code of this registration request.
	 *
	 * @return the grade code of this registration request
	 */
	@Override
	public String getGradeCode() {
		return model.getGradeCode();
	}

	/**
	 * Returns the grade ID of this registration request.
	 *
	 * @return the grade ID of this registration request
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the group ID of this registration request.
	 *
	 * @return the group ID of this registration request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the idam user of this registration request.
	 *
	 * @return the idam user of this registration request
	 */
	@Override
	public boolean getIdamUser() {
		return model.getIdamUser();
	}

	/**
	 * Returns the idam user created of this registration request.
	 *
	 * @return the idam user created of this registration request
	 */
	@Override
	public boolean getIdamUserCreated() {
		return model.getIdamUserCreated();
	}

	/**
	 * Returns the last name of this registration request.
	 *
	 * @return the last name of this registration request
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the login ID of this registration request.
	 *
	 * @return the login ID of this registration request
	 */
	@Override
	public String getLoginId() {
		return model.getLoginId();
	}

	/**
	 * Returns the middle name of this registration request.
	 *
	 * @return the middle name of this registration request
	 */
	@Override
	public String getMiddleName() {
		return model.getMiddleName();
	}

	/**
	 * Returns the mobile of this registration request.
	 *
	 * @return the mobile of this registration request
	 */
	@Override
	public long getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the modified date of this registration request.
	 *
	 * @return the modified date of this registration request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal no of this registration request.
	 *
	 * @return the personal no of this registration request
	 */
	@Override
	public long getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the pis access of this registration request.
	 *
	 * @return the pis access of this registration request
	 */
	@Override
	public boolean getPisAccess() {
		return model.getPisAccess();
	}

	/**
	 * Returns the post box of this registration request.
	 *
	 * @return the post box of this registration request
	 */
	@Override
	public String getPostBox() {
		return model.getPostBox();
	}

	/**
	 * Returns the primary key of this registration request.
	 *
	 * @return the primary key of this registration request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rank of this registration request.
	 *
	 * @return the rank of this registration request
	 */
	@Override
	public long getRank() {
		return model.getRank();
	}

	/**
	 * Returns the record no of this registration request.
	 *
	 * @return the record no of this registration request
	 */
	@Override
	public long getRecordNo() {
		return model.getRecordNo();
	}

	/**
	 * Returns the registration request ID of this registration request.
	 *
	 * @return the registration request ID of this registration request
	 */
	@Override
	public long getRegistrationRequestId() {
		return model.getRegistrationRequestId();
	}

	/**
	 * Returns the section of this registration request.
	 *
	 * @return the section of this registration request
	 */
	@Override
	public String getSection() {
		return model.getSection();
	}

	/**
	 * Returns the section code of this registration request.
	 *
	 * @return the section code of this registration request
	 */
	@Override
	public String getSectionCode() {
		return model.getSectionCode();
	}

	/**
	 * Returns the section ID of this registration request.
	 *
	 * @return the section ID of this registration request
	 */
	@Override
	public long getSectionId() {
		return model.getSectionId();
	}

	/**
	 * Returns the state of this registration request.
	 *
	 * @return the state of this registration request
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the status of this registration request.
	 *
	 * @return the status of this registration request
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this registration request.
	 *
	 * @return the status by user ID of this registration request
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this registration request.
	 *
	 * @return the status by user name of this registration request
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this registration request.
	 *
	 * @return the status by user uuid of this registration request
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this registration request.
	 *
	 * @return the status date of this registration request
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trade of this registration request.
	 *
	 * @return the trade of this registration request
	 */
	@Override
	public String getTrade() {
		return model.getTrade();
	}

	/**
	 * Returns the trade code of this registration request.
	 *
	 * @return the trade code of this registration request
	 */
	@Override
	public String getTradeCode() {
		return model.getTradeCode();
	}

	/**
	 * Returns the trade ID of this registration request.
	 *
	 * @return the trade ID of this registration request
	 */
	@Override
	public long getTradeId() {
		return model.getTradeId();
	}

	/**
	 * Returns the unit of this registration request.
	 *
	 * @return the unit of this registration request
	 */
	@Override
	public String getUnit() {
		return model.getUnit();
	}

	/**
	 * Returns the unit ID of this registration request.
	 *
	 * @return the unit ID of this registration request
	 */
	@Override
	public long getUnitId() {
		return model.getUnitId();
	}

	/**
	 * Returns the user ID of this registration request.
	 *
	 * @return the user ID of this registration request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this registration request.
	 *
	 * @return the user name of this registration request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this registration request.
	 *
	 * @return the user uuid of this registration request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this registration request.
	 *
	 * @return the uuid of this registration request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this registration request is approved.
	 *
	 * @return <code>true</code> if this registration request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this registration request is app user created.
	 *
	 * @return <code>true</code> if this registration request is app user created; <code>false</code> otherwise
	 */
	@Override
	public boolean isAppUserCreated() {
		return model.isAppUserCreated();
	}

	/**
	 * Returns <code>true</code> if this registration request is denied.
	 *
	 * @return <code>true</code> if this registration request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this registration request is digital signing.
	 *
	 * @return <code>true</code> if this registration request is digital signing; <code>false</code> otherwise
	 */
	@Override
	public boolean isDigitalSigning() {
		return model.isDigitalSigning();
	}

	/**
	 * Returns <code>true</code> if this registration request is a draft.
	 *
	 * @return <code>true</code> if this registration request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this registration request is e gov access.
	 *
	 * @return <code>true</code> if this registration request is e gov access; <code>false</code> otherwise
	 */
	@Override
	public boolean isEGovAccess() {
		return model.isEGovAccess();
	}

	/**
	 * Returns <code>true</code> if this registration request is email access.
	 *
	 * @return <code>true</code> if this registration request is email access; <code>false</code> otherwise
	 */
	@Override
	public boolean isEmailAccess() {
		return model.isEmailAccess();
	}

	/**
	 * Returns <code>true</code> if this registration request is employee created.
	 *
	 * @return <code>true</code> if this registration request is employee created; <code>false</code> otherwise
	 */
	@Override
	public boolean isEmployeeCreated() {
		return model.isEmployeeCreated();
	}

	/**
	 * Returns <code>true</code> if this registration request is expired.
	 *
	 * @return <code>true</code> if this registration request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this registration request is idam user.
	 *
	 * @return <code>true</code> if this registration request is idam user; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamUser() {
		return model.isIdamUser();
	}

	/**
	 * Returns <code>true</code> if this registration request is idam user created.
	 *
	 * @return <code>true</code> if this registration request is idam user created; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamUserCreated() {
		return model.isIdamUserCreated();
	}

	/**
	 * Returns <code>true</code> if this registration request is inactive.
	 *
	 * @return <code>true</code> if this registration request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this registration request is incomplete.
	 *
	 * @return <code>true</code> if this registration request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this registration request is pending.
	 *
	 * @return <code>true</code> if this registration request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this registration request is pis access.
	 *
	 * @return <code>true</code> if this registration request is pis access; <code>false</code> otherwise
	 */
	@Override
	public boolean isPisAccess() {
		return model.isPisAccess();
	}

	/**
	 * Returns <code>true</code> if this registration request is scheduled.
	 *
	 * @return <code>true</code> if this registration request is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this registration request is app user created.
	 *
	 * @param appUserCreated the app user created of this registration request
	 */
	@Override
	public void setAppUserCreated(boolean appUserCreated) {
		model.setAppUserCreated(appUserCreated);
	}

	/**
	 * Sets the bulk onbording file ID of this registration request.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID of this registration request
	 */
	@Override
	public void setBulkOnbordingFileId(long bulkOnbordingFileId) {
		model.setBulkOnbordingFileId(bulkOnbordingFileId);
	}

	/**
	 * Sets the caste category of this registration request.
	 *
	 * @param casteCategory the caste category of this registration request
	 */
	@Override
	public void setCasteCategory(String casteCategory) {
		model.setCasteCategory(casteCategory);
	}

	/**
	 * Sets the caste category ID of this registration request.
	 *
	 * @param casteCategoryId the caste category ID of this registration request
	 */
	@Override
	public void setCasteCategoryId(long casteCategoryId) {
		model.setCasteCategoryId(casteCategoryId);
	}

	/**
	 * Sets the company ID of this registration request.
	 *
	 * @param companyId the company ID of this registration request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this registration request.
	 *
	 * @param createDate the create date of this registration request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of birth of this registration request.
	 *
	 * @param dateOfBirth the date of birth of this registration request
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the date of joining organization of this registration request.
	 *
	 * @param dateOfJoiningOrganization the date of joining organization of this registration request
	 */
	@Override
	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization) {
		model.setDateOfJoiningOrganization(dateOfJoiningOrganization);
	}

	/**
	 * Sets the date of joining unit of this registration request.
	 *
	 * @param dateOfJoiningUnit the date of joining unit of this registration request
	 */
	@Override
	public void setDateOfJoiningUnit(Date dateOfJoiningUnit) {
		model.setDateOfJoiningUnit(dateOfJoiningUnit);
	}

	/**
	 * Sets the designation of this registration request.
	 *
	 * @param designation the designation of this registration request
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the designation code of this registration request.
	 *
	 * @param designationCode the designation code of this registration request
	 */
	@Override
	public void setDesignationCode(String designationCode) {
		model.setDesignationCode(designationCode);
	}

	/**
	 * Sets the designation ID of this registration request.
	 *
	 * @param designationId the designation ID of this registration request
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets whether this registration request is digital signing.
	 *
	 * @param digitalSigning the digital signing of this registration request
	 */
	@Override
	public void setDigitalSigning(boolean digitalSigning) {
		model.setDigitalSigning(digitalSigning);
	}

	/**
	 * Sets whether this registration request is e gov access.
	 *
	 * @param eGovAccess the e gov access of this registration request
	 */
	@Override
	public void setEGovAccess(boolean eGovAccess) {
		model.setEGovAccess(eGovAccess);
	}

	/**
	 * Sets whether this registration request is email access.
	 *
	 * @param emailAccess the email access of this registration request
	 */
	@Override
	public void setEmailAccess(boolean emailAccess) {
		model.setEmailAccess(emailAccess);
	}

	/**
	 * Sets the email address of this registration request.
	 *
	 * @param emailAddress the email address of this registration request
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets whether this registration request is employee created.
	 *
	 * @param employeeCreated the employee created of this registration request
	 */
	@Override
	public void setEmployeeCreated(boolean employeeCreated) {
		model.setEmployeeCreated(employeeCreated);
	}

	/**
	 * Sets the error message of this registration request.
	 *
	 * @param errorMessage the error message of this registration request
	 */
	@Override
	public void setErrorMessage(String errorMessage) {
		model.setErrorMessage(errorMessage);
	}

	/**
	 * Sets the first name of this registration request.
	 *
	 * @param firstName the first name of this registration request
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the gender of this registration request.
	 *
	 * @param gender the gender of this registration request
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the gender ID of this registration request.
	 *
	 * @param genderId the gender ID of this registration request
	 */
	@Override
	public void setGenderId(long genderId) {
		model.setGenderId(genderId);
	}

	/**
	 * Sets the gpfnps number of this registration request.
	 *
	 * @param gpfnpsNumber the gpfnps number of this registration request
	 */
	@Override
	public void setGpfnpsNumber(long gpfnpsNumber) {
		model.setGpfnpsNumber(gpfnpsNumber);
	}

	/**
	 * Sets the gpfnps type of this registration request.
	 *
	 * @param gpfnpsType the gpfnps type of this registration request
	 */
	@Override
	public void setGpfnpsType(String gpfnpsType) {
		model.setGpfnpsType(gpfnpsType);
	}

	/**
	 * Sets the grade of this registration request.
	 *
	 * @param grade the grade of this registration request
	 */
	@Override
	public void setGrade(String grade) {
		model.setGrade(grade);
	}

	/**
	 * Sets the grade code of this registration request.
	 *
	 * @param gradeCode the grade code of this registration request
	 */
	@Override
	public void setGradeCode(String gradeCode) {
		model.setGradeCode(gradeCode);
	}

	/**
	 * Sets the grade ID of this registration request.
	 *
	 * @param gradeId the grade ID of this registration request
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the group ID of this registration request.
	 *
	 * @param groupId the group ID of this registration request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this registration request is idam user.
	 *
	 * @param idamUser the idam user of this registration request
	 */
	@Override
	public void setIdamUser(boolean idamUser) {
		model.setIdamUser(idamUser);
	}

	/**
	 * Sets whether this registration request is idam user created.
	 *
	 * @param idamUserCreated the idam user created of this registration request
	 */
	@Override
	public void setIdamUserCreated(boolean idamUserCreated) {
		model.setIdamUserCreated(idamUserCreated);
	}

	/**
	 * Sets the last name of this registration request.
	 *
	 * @param lastName the last name of this registration request
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the login ID of this registration request.
	 *
	 * @param loginId the login ID of this registration request
	 */
	@Override
	public void setLoginId(String loginId) {
		model.setLoginId(loginId);
	}

	/**
	 * Sets the middle name of this registration request.
	 *
	 * @param middleName the middle name of this registration request
	 */
	@Override
	public void setMiddleName(String middleName) {
		model.setMiddleName(middleName);
	}

	/**
	 * Sets the mobile of this registration request.
	 *
	 * @param mobile the mobile of this registration request
	 */
	@Override
	public void setMobile(long mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the modified date of this registration request.
	 *
	 * @param modifiedDate the modified date of this registration request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal no of this registration request.
	 *
	 * @param personalNo the personal no of this registration request
	 */
	@Override
	public void setPersonalNo(long personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets whether this registration request is pis access.
	 *
	 * @param pisAccess the pis access of this registration request
	 */
	@Override
	public void setPisAccess(boolean pisAccess) {
		model.setPisAccess(pisAccess);
	}

	/**
	 * Sets the post box of this registration request.
	 *
	 * @param postBox the post box of this registration request
	 */
	@Override
	public void setPostBox(String postBox) {
		model.setPostBox(postBox);
	}

	/**
	 * Sets the primary key of this registration request.
	 *
	 * @param primaryKey the primary key of this registration request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rank of this registration request.
	 *
	 * @param rank the rank of this registration request
	 */
	@Override
	public void setRank(long rank) {
		model.setRank(rank);
	}

	/**
	 * Sets the record no of this registration request.
	 *
	 * @param recordNo the record no of this registration request
	 */
	@Override
	public void setRecordNo(long recordNo) {
		model.setRecordNo(recordNo);
	}

	/**
	 * Sets the registration request ID of this registration request.
	 *
	 * @param registrationRequestId the registration request ID of this registration request
	 */
	@Override
	public void setRegistrationRequestId(long registrationRequestId) {
		model.setRegistrationRequestId(registrationRequestId);
	}

	/**
	 * Sets the section of this registration request.
	 *
	 * @param section the section of this registration request
	 */
	@Override
	public void setSection(String section) {
		model.setSection(section);
	}

	/**
	 * Sets the section code of this registration request.
	 *
	 * @param sectionCode the section code of this registration request
	 */
	@Override
	public void setSectionCode(String sectionCode) {
		model.setSectionCode(sectionCode);
	}

	/**
	 * Sets the section ID of this registration request.
	 *
	 * @param sectionId the section ID of this registration request
	 */
	@Override
	public void setSectionId(long sectionId) {
		model.setSectionId(sectionId);
	}

	/**
	 * Sets the state of this registration request.
	 *
	 * @param state the state of this registration request
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the status of this registration request.
	 *
	 * @param status the status of this registration request
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this registration request.
	 *
	 * @param statusByUserId the status by user ID of this registration request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this registration request.
	 *
	 * @param statusByUserName the status by user name of this registration request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this registration request.
	 *
	 * @param statusByUserUuid the status by user uuid of this registration request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this registration request.
	 *
	 * @param statusDate the status date of this registration request
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the trade of this registration request.
	 *
	 * @param trade the trade of this registration request
	 */
	@Override
	public void setTrade(String trade) {
		model.setTrade(trade);
	}

	/**
	 * Sets the trade code of this registration request.
	 *
	 * @param tradeCode the trade code of this registration request
	 */
	@Override
	public void setTradeCode(String tradeCode) {
		model.setTradeCode(tradeCode);
	}

	/**
	 * Sets the trade ID of this registration request.
	 *
	 * @param tradeId the trade ID of this registration request
	 */
	@Override
	public void setTradeId(long tradeId) {
		model.setTradeId(tradeId);
	}

	/**
	 * Sets the unit of this registration request.
	 *
	 * @param unit the unit of this registration request
	 */
	@Override
	public void setUnit(String unit) {
		model.setUnit(unit);
	}

	/**
	 * Sets the unit ID of this registration request.
	 *
	 * @param unitId the unit ID of this registration request
	 */
	@Override
	public void setUnitId(long unitId) {
		model.setUnitId(unitId);
	}

	/**
	 * Sets the user ID of this registration request.
	 *
	 * @param userId the user ID of this registration request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this registration request.
	 *
	 * @param userName the user name of this registration request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this registration request.
	 *
	 * @param userUuid the user uuid of this registration request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this registration request.
	 *
	 * @param uuid the uuid of this registration request
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected RegistrationRequestWrapper wrap(
		RegistrationRequest registrationRequest) {

		return new RegistrationRequestWrapper(registrationRequest);
	}

}