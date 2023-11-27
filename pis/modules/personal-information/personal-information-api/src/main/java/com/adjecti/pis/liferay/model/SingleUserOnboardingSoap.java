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

package com.adjecti.pis.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.SingleUserOnboardingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SingleUserOnboardingSoap implements Serializable {

	public static SingleUserOnboardingSoap toSoapModel(
		SingleUserOnboarding model) {

		SingleUserOnboardingSoap soapModel = new SingleUserOnboardingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSingleUserRegistrationId(
			model.getSingleUserRegistrationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setRecordNo(model.getRecordNo());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setUnit(model.getUnit());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setGenderId(model.getGenderId());
		soapModel.setGender(model.getGender());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setDesignation(model.getDesignation());
		soapModel.setDesignationCode(model.getDesignationCode());
		soapModel.setTradeId(model.getTradeId());
		soapModel.setTrade(model.getTrade());
		soapModel.setTradeCode(model.getTradeCode());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setGrade(model.getGrade());
		soapModel.setGradeCode(model.getGradeCode());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setDateOfJoiningOrganization(
			model.getDateOfJoiningOrganization());
		soapModel.setCasteCategoryId(model.getCasteCategoryId());
		soapModel.setCasteCategory(model.getCasteCategory());
		soapModel.setMobile(model.getMobile());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setDateOfJoiningUnit(model.getDateOfJoiningUnit());
		soapModel.setGpfnpsType(model.getGpfnpsType());
		soapModel.setGpfnpsNumber(model.getGpfnpsNumber());
		soapModel.setSectionId(model.getSectionId());
		soapModel.setSection(model.getSection());
		soapModel.setSectionCode(model.getSectionCode());
		soapModel.setLoginId(model.getLoginId());
		soapModel.setIdamUser(model.isIdamUser());
		soapModel.setEmailAccess(model.isEmailAccess());
		soapModel.setDigitalSigning(model.isDigitalSigning());
		soapModel.setEGovAccess(model.isEGovAccess());
		soapModel.setPisAccess(model.isPisAccess());
		soapModel.setState(model.getState());
		soapModel.setIdamUserCreated(model.isIdamUserCreated());
		soapModel.setEmployeeCreated(model.isEmployeeCreated());
		soapModel.setAppUserCreated(model.isAppUserCreated());
		soapModel.setPostBox(model.getPostBox());
		soapModel.setRank(model.getRank());
		soapModel.setDescription(model.getDescription());
		soapModel.setReason(model.getReason());

		return soapModel;
	}

	public static SingleUserOnboardingSoap[] toSoapModels(
		SingleUserOnboarding[] models) {

		SingleUserOnboardingSoap[] soapModels =
			new SingleUserOnboardingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SingleUserOnboardingSoap[][] toSoapModels(
		SingleUserOnboarding[][] models) {

		SingleUserOnboardingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SingleUserOnboardingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SingleUserOnboardingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SingleUserOnboardingSoap[] toSoapModels(
		List<SingleUserOnboarding> models) {

		List<SingleUserOnboardingSoap> soapModels =
			new ArrayList<SingleUserOnboardingSoap>(models.size());

		for (SingleUserOnboarding model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SingleUserOnboardingSoap[soapModels.size()]);
	}

	public SingleUserOnboardingSoap() {
	}

	public long getPrimaryKey() {
		return _singleUserRegistrationId;
	}

	public void setPrimaryKey(long pk) {
		setSingleUserRegistrationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSingleUserRegistrationId() {
		return _singleUserRegistrationId;
	}

	public void setSingleUserRegistrationId(long singleUserRegistrationId) {
		_singleUserRegistrationId = singleUserRegistrationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getRecordNo() {
		return _recordNo;
	}

	public void setRecordNo(long recordNo) {
		_recordNo = recordNo;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public long getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(long personalNo) {
		_personalNo = personalNo;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public long getGenderId() {
		return _genderId;
	}

	public void setGenderId(long genderId) {
		_genderId = genderId;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
	}

	public String getDesignation() {
		return _designation;
	}

	public void setDesignation(String designation) {
		_designation = designation;
	}

	public String getDesignationCode() {
		return _designationCode;
	}

	public void setDesignationCode(String designationCode) {
		_designationCode = designationCode;
	}

	public long getTradeId() {
		return _tradeId;
	}

	public void setTradeId(long tradeId) {
		_tradeId = tradeId;
	}

	public String getTrade() {
		return _trade;
	}

	public void setTrade(String trade) {
		_trade = trade;
	}

	public String getTradeCode() {
		return _tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		_tradeCode = tradeCode;
	}

	public long getGradeId() {
		return _gradeId;
	}

	public void setGradeId(long gradeId) {
		_gradeId = gradeId;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
	}

	public String getGradeCode() {
		return _gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		_gradeCode = gradeCode;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoiningOrganization() {
		return _dateOfJoiningOrganization;
	}

	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization) {
		_dateOfJoiningOrganization = dateOfJoiningOrganization;
	}

	public long getCasteCategoryId() {
		return _casteCategoryId;
	}

	public void setCasteCategoryId(long casteCategoryId) {
		_casteCategoryId = casteCategoryId;
	}

	public String getCasteCategory() {
		return _casteCategory;
	}

	public void setCasteCategory(String casteCategory) {
		_casteCategory = casteCategory;
	}

	public long getMobile() {
		return _mobile;
	}

	public void setMobile(long mobile) {
		_mobile = mobile;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public Date getDateOfJoiningUnit() {
		return _dateOfJoiningUnit;
	}

	public void setDateOfJoiningUnit(Date dateOfJoiningUnit) {
		_dateOfJoiningUnit = dateOfJoiningUnit;
	}

	public String getGpfnpsType() {
		return _gpfnpsType;
	}

	public void setGpfnpsType(String gpfnpsType) {
		_gpfnpsType = gpfnpsType;
	}

	public long getGpfnpsNumber() {
		return _gpfnpsNumber;
	}

	public void setGpfnpsNumber(long gpfnpsNumber) {
		_gpfnpsNumber = gpfnpsNumber;
	}

	public long getSectionId() {
		return _sectionId;
	}

	public void setSectionId(long sectionId) {
		_sectionId = sectionId;
	}

	public String getSection() {
		return _section;
	}

	public void setSection(String section) {
		_section = section;
	}

	public String getSectionCode() {
		return _sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		_sectionCode = sectionCode;
	}

	public String getLoginId() {
		return _loginId;
	}

	public void setLoginId(String loginId) {
		_loginId = loginId;
	}

	public boolean getIdamUser() {
		return _idamUser;
	}

	public boolean isIdamUser() {
		return _idamUser;
	}

	public void setIdamUser(boolean idamUser) {
		_idamUser = idamUser;
	}

	public boolean getEmailAccess() {
		return _emailAccess;
	}

	public boolean isEmailAccess() {
		return _emailAccess;
	}

	public void setEmailAccess(boolean emailAccess) {
		_emailAccess = emailAccess;
	}

	public boolean getDigitalSigning() {
		return _digitalSigning;
	}

	public boolean isDigitalSigning() {
		return _digitalSigning;
	}

	public void setDigitalSigning(boolean digitalSigning) {
		_digitalSigning = digitalSigning;
	}

	public boolean getEGovAccess() {
		return _eGovAccess;
	}

	public boolean isEGovAccess() {
		return _eGovAccess;
	}

	public void setEGovAccess(boolean eGovAccess) {
		_eGovAccess = eGovAccess;
	}

	public boolean getPisAccess() {
		return _pisAccess;
	}

	public boolean isPisAccess() {
		return _pisAccess;
	}

	public void setPisAccess(boolean pisAccess) {
		_pisAccess = pisAccess;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public boolean getIdamUserCreated() {
		return _idamUserCreated;
	}

	public boolean isIdamUserCreated() {
		return _idamUserCreated;
	}

	public void setIdamUserCreated(boolean idamUserCreated) {
		_idamUserCreated = idamUserCreated;
	}

	public boolean getEmployeeCreated() {
		return _employeeCreated;
	}

	public boolean isEmployeeCreated() {
		return _employeeCreated;
	}

	public void setEmployeeCreated(boolean employeeCreated) {
		_employeeCreated = employeeCreated;
	}

	public boolean getAppUserCreated() {
		return _appUserCreated;
	}

	public boolean isAppUserCreated() {
		return _appUserCreated;
	}

	public void setAppUserCreated(boolean appUserCreated) {
		_appUserCreated = appUserCreated;
	}

	public String getPostBox() {
		return _postBox;
	}

	public void setPostBox(String postBox) {
		_postBox = postBox;
	}

	public long getRank() {
		return _rank;
	}

	public void setRank(long rank) {
		_rank = rank;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	private String _uuid;
	private long _singleUserRegistrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _recordNo;
	private long _unitId;
	private String _unit;
	private long _personalNo;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private long _genderId;
	private String _gender;
	private long _designationId;
	private String _designation;
	private String _designationCode;
	private long _tradeId;
	private String _trade;
	private String _tradeCode;
	private long _gradeId;
	private String _grade;
	private String _gradeCode;
	private Date _dateOfBirth;
	private Date _dateOfJoiningOrganization;
	private long _casteCategoryId;
	private String _casteCategory;
	private long _mobile;
	private String _emailAddress;
	private Date _dateOfJoiningUnit;
	private String _gpfnpsType;
	private long _gpfnpsNumber;
	private long _sectionId;
	private String _section;
	private String _sectionCode;
	private String _loginId;
	private boolean _idamUser;
	private boolean _emailAccess;
	private boolean _digitalSigning;
	private boolean _eGovAccess;
	private boolean _pisAccess;
	private String _state;
	private boolean _idamUserCreated;
	private boolean _employeeCreated;
	private boolean _appUserCreated;
	private String _postBox;
	private long _rank;
	private String _description;
	private String _reason;

}