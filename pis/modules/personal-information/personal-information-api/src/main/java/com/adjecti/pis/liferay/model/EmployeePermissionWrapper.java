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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeePermission}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePermission
 * @generated
 */
public class EmployeePermissionWrapper
	extends BaseModelWrapper<EmployeePermission>
	implements EmployeePermission, ModelWrapper<EmployeePermission> {

	public EmployeePermissionWrapper(EmployeePermission employeePermission) {
		super(employeePermission);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeePermissionId", getEmployeePermissionId());
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
		attributes.put("idamUser", isIdamUser());
		attributes.put("digitalSigning", isDigitalSigning());
		attributes.put("pisAccess", isPisAccess());
		attributes.put("emailAccess", isEmailAccess());
		attributes.put("eGovAccess", isEGovAccess());
		attributes.put("idamUserCreated", isIdamUserCreated());
		attributes.put("userCreated", isUserCreated());
		attributes.put("employeeCreated", isEmployeeCreated());
		attributes.put("firstName", getFirstName());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("designationId", getDesignationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("singleUserOnboardingId", getSingleUserOnboardingId());
		attributes.put("registrationRequestId", getRegistrationRequestId());
		attributes.put("form", getForm());
		attributes.put("currentState", getCurrentState());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeePermissionId = (Long)attributes.get(
			"employeePermissionId");

		if (employeePermissionId != null) {
			setEmployeePermissionId(employeePermissionId);
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

		Boolean idamUser = (Boolean)attributes.get("idamUser");

		if (idamUser != null) {
			setIdamUser(idamUser);
		}

		Boolean digitalSigning = (Boolean)attributes.get("digitalSigning");

		if (digitalSigning != null) {
			setDigitalSigning(digitalSigning);
		}

		Boolean pisAccess = (Boolean)attributes.get("pisAccess");

		if (pisAccess != null) {
			setPisAccess(pisAccess);
		}

		Boolean emailAccess = (Boolean)attributes.get("emailAccess");

		if (emailAccess != null) {
			setEmailAccess(emailAccess);
		}

		Boolean eGovAccess = (Boolean)attributes.get("eGovAccess");

		if (eGovAccess != null) {
			setEGovAccess(eGovAccess);
		}

		Boolean idamUserCreated = (Boolean)attributes.get("idamUserCreated");

		if (idamUserCreated != null) {
			setIdamUserCreated(idamUserCreated);
		}

		Boolean userCreated = (Boolean)attributes.get("userCreated");

		if (userCreated != null) {
			setUserCreated(userCreated);
		}

		Boolean employeeCreated = (Boolean)attributes.get("employeeCreated");

		if (employeeCreated != null) {
			setEmployeeCreated(employeeCreated);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		Long personalNo = (Long)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Long singleUserOnboardingId = (Long)attributes.get(
			"singleUserOnboardingId");

		if (singleUserOnboardingId != null) {
			setSingleUserOnboardingId(singleUserOnboardingId);
		}

		Long registrationRequestId = (Long)attributes.get(
			"registrationRequestId");

		if (registrationRequestId != null) {
			setRegistrationRequestId(registrationRequestId);
		}

		String form = (String)attributes.get("form");

		if (form != null) {
			setForm(form);
		}

		String currentState = (String)attributes.get("currentState");

		if (currentState != null) {
			setCurrentState(currentState);
		}
	}

	/**
	 * Returns the company ID of this employee permission.
	 *
	 * @return the company ID of this employee permission
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee permission.
	 *
	 * @return the create date of this employee permission
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the current state of this employee permission.
	 *
	 * @return the current state of this employee permission
	 */
	@Override
	public String getCurrentState() {
		return model.getCurrentState();
	}

	/**
	 * Returns the designation ID of this employee permission.
	 *
	 * @return the designation ID of this employee permission
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the digital signing of this employee permission.
	 *
	 * @return the digital signing of this employee permission
	 */
	@Override
	public boolean getDigitalSigning() {
		return model.getDigitalSigning();
	}

	/**
	 * Returns the e gov access of this employee permission.
	 *
	 * @return the e gov access of this employee permission
	 */
	@Override
	public boolean getEGovAccess() {
		return model.getEGovAccess();
	}

	/**
	 * Returns the email access of this employee permission.
	 *
	 * @return the email access of this employee permission
	 */
	@Override
	public boolean getEmailAccess() {
		return model.getEmailAccess();
	}

	/**
	 * Returns the email address of this employee permission.
	 *
	 * @return the email address of this employee permission
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the employee created of this employee permission.
	 *
	 * @return the employee created of this employee permission
	 */
	@Override
	public boolean getEmployeeCreated() {
		return model.getEmployeeCreated();
	}

	/**
	 * Returns the employee ID of this employee permission.
	 *
	 * @return the employee ID of this employee permission
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee permission ID of this employee permission.
	 *
	 * @return the employee permission ID of this employee permission
	 */
	@Override
	public long getEmployeePermissionId() {
		return model.getEmployeePermissionId();
	}

	/**
	 * Returns the first name of this employee permission.
	 *
	 * @return the first name of this employee permission
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the form of this employee permission.
	 *
	 * @return the form of this employee permission
	 */
	@Override
	public String getForm() {
		return model.getForm();
	}

	/**
	 * Returns the group ID of this employee permission.
	 *
	 * @return the group ID of this employee permission
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the idam user of this employee permission.
	 *
	 * @return the idam user of this employee permission
	 */
	@Override
	public boolean getIdamUser() {
		return model.getIdamUser();
	}

	/**
	 * Returns the idam user created of this employee permission.
	 *
	 * @return the idam user created of this employee permission
	 */
	@Override
	public boolean getIdamUserCreated() {
		return model.getIdamUserCreated();
	}

	/**
	 * Returns the joining process ID of this employee permission.
	 *
	 * @return the joining process ID of this employee permission
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the last name of this employee permission.
	 *
	 * @return the last name of this employee permission
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this employee permission.
	 *
	 * @return the modified date of this employee permission
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal no of this employee permission.
	 *
	 * @return the personal no of this employee permission
	 */
	@Override
	public long getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the pis access of this employee permission.
	 *
	 * @return the pis access of this employee permission
	 */
	@Override
	public boolean getPisAccess() {
		return model.getPisAccess();
	}

	/**
	 * Returns the primary key of this employee permission.
	 *
	 * @return the primary key of this employee permission
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registration request ID of this employee permission.
	 *
	 * @return the registration request ID of this employee permission
	 */
	@Override
	public long getRegistrationRequestId() {
		return model.getRegistrationRequestId();
	}

	/**
	 * Returns the single user onboarding ID of this employee permission.
	 *
	 * @return the single user onboarding ID of this employee permission
	 */
	@Override
	public long getSingleUserOnboardingId() {
		return model.getSingleUserOnboardingId();
	}

	/**
	 * Returns the status of this employee permission.
	 *
	 * @return the status of this employee permission
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this employee permission.
	 *
	 * @return the status by user ID of this employee permission
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this employee permission.
	 *
	 * @return the status by user name of this employee permission
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this employee permission.
	 *
	 * @return the status by user uuid of this employee permission
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this employee permission.
	 *
	 * @return the status date of this employee permission
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user created of this employee permission.
	 *
	 * @return the user created of this employee permission
	 */
	@Override
	public boolean getUserCreated() {
		return model.getUserCreated();
	}

	/**
	 * Returns the user ID of this employee permission.
	 *
	 * @return the user ID of this employee permission
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee permission.
	 *
	 * @return the user name of this employee permission
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee permission.
	 *
	 * @return the user uuid of this employee permission
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee permission is approved.
	 *
	 * @return <code>true</code> if this employee permission is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this employee permission is denied.
	 *
	 * @return <code>true</code> if this employee permission is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this employee permission is digital signing.
	 *
	 * @return <code>true</code> if this employee permission is digital signing; <code>false</code> otherwise
	 */
	@Override
	public boolean isDigitalSigning() {
		return model.isDigitalSigning();
	}

	/**
	 * Returns <code>true</code> if this employee permission is a draft.
	 *
	 * @return <code>true</code> if this employee permission is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this employee permission is e gov access.
	 *
	 * @return <code>true</code> if this employee permission is e gov access; <code>false</code> otherwise
	 */
	@Override
	public boolean isEGovAccess() {
		return model.isEGovAccess();
	}

	/**
	 * Returns <code>true</code> if this employee permission is email access.
	 *
	 * @return <code>true</code> if this employee permission is email access; <code>false</code> otherwise
	 */
	@Override
	public boolean isEmailAccess() {
		return model.isEmailAccess();
	}

	/**
	 * Returns <code>true</code> if this employee permission is employee created.
	 *
	 * @return <code>true</code> if this employee permission is employee created; <code>false</code> otherwise
	 */
	@Override
	public boolean isEmployeeCreated() {
		return model.isEmployeeCreated();
	}

	/**
	 * Returns <code>true</code> if this employee permission is expired.
	 *
	 * @return <code>true</code> if this employee permission is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this employee permission is idam user.
	 *
	 * @return <code>true</code> if this employee permission is idam user; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamUser() {
		return model.isIdamUser();
	}

	/**
	 * Returns <code>true</code> if this employee permission is idam user created.
	 *
	 * @return <code>true</code> if this employee permission is idam user created; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamUserCreated() {
		return model.isIdamUserCreated();
	}

	/**
	 * Returns <code>true</code> if this employee permission is inactive.
	 *
	 * @return <code>true</code> if this employee permission is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this employee permission is incomplete.
	 *
	 * @return <code>true</code> if this employee permission is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this employee permission is pending.
	 *
	 * @return <code>true</code> if this employee permission is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this employee permission is pis access.
	 *
	 * @return <code>true</code> if this employee permission is pis access; <code>false</code> otherwise
	 */
	@Override
	public boolean isPisAccess() {
		return model.isPisAccess();
	}

	/**
	 * Returns <code>true</code> if this employee permission is scheduled.
	 *
	 * @return <code>true</code> if this employee permission is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this employee permission is user created.
	 *
	 * @return <code>true</code> if this employee permission is user created; <code>false</code> otherwise
	 */
	@Override
	public boolean isUserCreated() {
		return model.isUserCreated();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employee permission.
	 *
	 * @param companyId the company ID of this employee permission
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee permission.
	 *
	 * @param createDate the create date of this employee permission
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the current state of this employee permission.
	 *
	 * @param currentState the current state of this employee permission
	 */
	@Override
	public void setCurrentState(String currentState) {
		model.setCurrentState(currentState);
	}

	/**
	 * Sets the designation ID of this employee permission.
	 *
	 * @param designationId the designation ID of this employee permission
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets whether this employee permission is digital signing.
	 *
	 * @param digitalSigning the digital signing of this employee permission
	 */
	@Override
	public void setDigitalSigning(boolean digitalSigning) {
		model.setDigitalSigning(digitalSigning);
	}

	/**
	 * Sets whether this employee permission is e gov access.
	 *
	 * @param eGovAccess the e gov access of this employee permission
	 */
	@Override
	public void setEGovAccess(boolean eGovAccess) {
		model.setEGovAccess(eGovAccess);
	}

	/**
	 * Sets whether this employee permission is email access.
	 *
	 * @param emailAccess the email access of this employee permission
	 */
	@Override
	public void setEmailAccess(boolean emailAccess) {
		model.setEmailAccess(emailAccess);
	}

	/**
	 * Sets the email address of this employee permission.
	 *
	 * @param emailAddress the email address of this employee permission
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets whether this employee permission is employee created.
	 *
	 * @param employeeCreated the employee created of this employee permission
	 */
	@Override
	public void setEmployeeCreated(boolean employeeCreated) {
		model.setEmployeeCreated(employeeCreated);
	}

	/**
	 * Sets the employee ID of this employee permission.
	 *
	 * @param employeeId the employee ID of this employee permission
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee permission ID of this employee permission.
	 *
	 * @param employeePermissionId the employee permission ID of this employee permission
	 */
	@Override
	public void setEmployeePermissionId(long employeePermissionId) {
		model.setEmployeePermissionId(employeePermissionId);
	}

	/**
	 * Sets the first name of this employee permission.
	 *
	 * @param firstName the first name of this employee permission
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the form of this employee permission.
	 *
	 * @param form the form of this employee permission
	 */
	@Override
	public void setForm(String form) {
		model.setForm(form);
	}

	/**
	 * Sets the group ID of this employee permission.
	 *
	 * @param groupId the group ID of this employee permission
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this employee permission is idam user.
	 *
	 * @param idamUser the idam user of this employee permission
	 */
	@Override
	public void setIdamUser(boolean idamUser) {
		model.setIdamUser(idamUser);
	}

	/**
	 * Sets whether this employee permission is idam user created.
	 *
	 * @param idamUserCreated the idam user created of this employee permission
	 */
	@Override
	public void setIdamUserCreated(boolean idamUserCreated) {
		model.setIdamUserCreated(idamUserCreated);
	}

	/**
	 * Sets the joining process ID of this employee permission.
	 *
	 * @param joiningProcessId the joining process ID of this employee permission
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the last name of this employee permission.
	 *
	 * @param lastName the last name of this employee permission
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this employee permission.
	 *
	 * @param modifiedDate the modified date of this employee permission
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal no of this employee permission.
	 *
	 * @param personalNo the personal no of this employee permission
	 */
	@Override
	public void setPersonalNo(long personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets whether this employee permission is pis access.
	 *
	 * @param pisAccess the pis access of this employee permission
	 */
	@Override
	public void setPisAccess(boolean pisAccess) {
		model.setPisAccess(pisAccess);
	}

	/**
	 * Sets the primary key of this employee permission.
	 *
	 * @param primaryKey the primary key of this employee permission
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registration request ID of this employee permission.
	 *
	 * @param registrationRequestId the registration request ID of this employee permission
	 */
	@Override
	public void setRegistrationRequestId(long registrationRequestId) {
		model.setRegistrationRequestId(registrationRequestId);
	}

	/**
	 * Sets the single user onboarding ID of this employee permission.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID of this employee permission
	 */
	@Override
	public void setSingleUserOnboardingId(long singleUserOnboardingId) {
		model.setSingleUserOnboardingId(singleUserOnboardingId);
	}

	/**
	 * Sets the status of this employee permission.
	 *
	 * @param status the status of this employee permission
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this employee permission.
	 *
	 * @param statusByUserId the status by user ID of this employee permission
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this employee permission.
	 *
	 * @param statusByUserName the status by user name of this employee permission
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this employee permission.
	 *
	 * @param statusByUserUuid the status by user uuid of this employee permission
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this employee permission.
	 *
	 * @param statusDate the status date of this employee permission
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets whether this employee permission is user created.
	 *
	 * @param userCreated the user created of this employee permission
	 */
	@Override
	public void setUserCreated(boolean userCreated) {
		model.setUserCreated(userCreated);
	}

	/**
	 * Sets the user ID of this employee permission.
	 *
	 * @param userId the user ID of this employee permission
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee permission.
	 *
	 * @param userName the user name of this employee permission
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee permission.
	 *
	 * @param userUuid the user uuid of this employee permission
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeePermissionWrapper wrap(
		EmployeePermission employeePermission) {

		return new EmployeePermissionWrapper(employeePermission);
	}

}