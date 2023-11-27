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

package net.ayudh.comnet.admin.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ApplicationUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUser
 * @generated
 */
public class ApplicationUserWrapper
	extends BaseModelWrapper<ApplicationUser>
	implements ApplicationUser, ModelWrapper<ApplicationUser> {

	public ApplicationUserWrapper(ApplicationUser applicationUser) {
		super(applicationUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationUserId", getApplicationUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("loginId", getLoginId());
		attributes.put("status", getStatus());
		attributes.put("deleted", isDeleted());
		attributes.put("idamUser", isIdamUser());
		attributes.put("emailAccess", isEmailAccess());
		attributes.put("digitalSigning", isDigitalSigning());
		attributes.put("eGovAccess", isEGovAccess());
		attributes.put("pisAccess", isPisAccess());
		attributes.put("lastIdamUser", isLastIdamUser());
		attributes.put("lastEmailAccess", isLastEmailAccess());
		attributes.put("lastDigitalSigning", isLastDigitalSigning());
		attributes.put("lastEGovAccess", isLastEGovAccess());
		attributes.put("lastPisAccess", isLastPisAccess());
		attributes.put("idamServiceStatus", isIdamServiceStatus());
		attributes.put("idamServiceMessage", getIdamServiceMessage());
		attributes.put("idamUserCreated", isIdamUserCreated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationUserId = (Long)attributes.get("applicationUserId");

		if (applicationUserId != null) {
			setApplicationUserId(applicationUserId);
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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String loginId = (String)attributes.get("loginId");

		if (loginId != null) {
			setLoginId(loginId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
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

		Boolean lastIdamUser = (Boolean)attributes.get("lastIdamUser");

		if (lastIdamUser != null) {
			setLastIdamUser(lastIdamUser);
		}

		Boolean lastEmailAccess = (Boolean)attributes.get("lastEmailAccess");

		if (lastEmailAccess != null) {
			setLastEmailAccess(lastEmailAccess);
		}

		Boolean lastDigitalSigning = (Boolean)attributes.get(
			"lastDigitalSigning");

		if (lastDigitalSigning != null) {
			setLastDigitalSigning(lastDigitalSigning);
		}

		Boolean lastEGovAccess = (Boolean)attributes.get("lastEGovAccess");

		if (lastEGovAccess != null) {
			setLastEGovAccess(lastEGovAccess);
		}

		Boolean lastPisAccess = (Boolean)attributes.get("lastPisAccess");

		if (lastPisAccess != null) {
			setLastPisAccess(lastPisAccess);
		}

		Boolean idamServiceStatus = (Boolean)attributes.get(
			"idamServiceStatus");

		if (idamServiceStatus != null) {
			setIdamServiceStatus(idamServiceStatus);
		}

		String idamServiceMessage = (String)attributes.get(
			"idamServiceMessage");

		if (idamServiceMessage != null) {
			setIdamServiceMessage(idamServiceMessage);
		}

		Boolean idamUserCreated = (Boolean)attributes.get("idamUserCreated");

		if (idamUserCreated != null) {
			setIdamUserCreated(idamUserCreated);
		}
	}

	/**
	 * Returns the application user ID of this application user.
	 *
	 * @return the application user ID of this application user
	 */
	@Override
	public long getApplicationUserId() {
		return model.getApplicationUserId();
	}

	/**
	 * Returns the application user uuid of this application user.
	 *
	 * @return the application user uuid of this application user
	 */
	@Override
	public String getApplicationUserUuid() {
		return model.getApplicationUserUuid();
	}

	/**
	 * Returns the company ID of this application user.
	 *
	 * @return the company ID of this application user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this application user.
	 *
	 * @return the create date of this application user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this application user.
	 *
	 * @return the deleted of this application user
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the digital signing of this application user.
	 *
	 * @return the digital signing of this application user
	 */
	@Override
	public boolean getDigitalSigning() {
		return model.getDigitalSigning();
	}

	/**
	 * Returns the e gov access of this application user.
	 *
	 * @return the e gov access of this application user
	 */
	@Override
	public boolean getEGovAccess() {
		return model.getEGovAccess();
	}

	/**
	 * Returns the email access of this application user.
	 *
	 * @return the email access of this application user
	 */
	@Override
	public boolean getEmailAccess() {
		return model.getEmailAccess();
	}

	/**
	 * Returns the employee ID of this application user.
	 *
	 * @return the employee ID of this application user
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this application user.
	 *
	 * @return the group ID of this application user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the idam service message of this application user.
	 *
	 * @return the idam service message of this application user
	 */
	@Override
	public String getIdamServiceMessage() {
		return model.getIdamServiceMessage();
	}

	/**
	 * Returns the idam service status of this application user.
	 *
	 * @return the idam service status of this application user
	 */
	@Override
	public boolean getIdamServiceStatus() {
		return model.getIdamServiceStatus();
	}

	/**
	 * Returns the idam user of this application user.
	 *
	 * @return the idam user of this application user
	 */
	@Override
	public boolean getIdamUser() {
		return model.getIdamUser();
	}

	/**
	 * Returns the idam user created of this application user.
	 *
	 * @return the idam user created of this application user
	 */
	@Override
	public boolean getIdamUserCreated() {
		return model.getIdamUserCreated();
	}

	/**
	 * Returns the last digital signing of this application user.
	 *
	 * @return the last digital signing of this application user
	 */
	@Override
	public boolean getLastDigitalSigning() {
		return model.getLastDigitalSigning();
	}

	/**
	 * Returns the last e gov access of this application user.
	 *
	 * @return the last e gov access of this application user
	 */
	@Override
	public boolean getLastEGovAccess() {
		return model.getLastEGovAccess();
	}

	/**
	 * Returns the last email access of this application user.
	 *
	 * @return the last email access of this application user
	 */
	@Override
	public boolean getLastEmailAccess() {
		return model.getLastEmailAccess();
	}

	/**
	 * Returns the last idam user of this application user.
	 *
	 * @return the last idam user of this application user
	 */
	@Override
	public boolean getLastIdamUser() {
		return model.getLastIdamUser();
	}

	/**
	 * Returns the last pis access of this application user.
	 *
	 * @return the last pis access of this application user
	 */
	@Override
	public boolean getLastPisAccess() {
		return model.getLastPisAccess();
	}

	/**
	 * Returns the login ID of this application user.
	 *
	 * @return the login ID of this application user
	 */
	@Override
	public String getLoginId() {
		return model.getLoginId();
	}

	/**
	 * Returns the modified date of this application user.
	 *
	 * @return the modified date of this application user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pis access of this application user.
	 *
	 * @return the pis access of this application user
	 */
	@Override
	public boolean getPisAccess() {
		return model.getPisAccess();
	}

	/**
	 * Returns the primary key of this application user.
	 *
	 * @return the primary key of this application user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this application user.
	 *
	 * @return the status of this application user
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this application user.
	 *
	 * @return the user ID of this application user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this application user.
	 *
	 * @return the user name of this application user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this application user.
	 *
	 * @return the user uuid of this application user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this application user is deleted.
	 *
	 * @return <code>true</code> if this application user is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	/**
	 * Returns <code>true</code> if this application user is digital signing.
	 *
	 * @return <code>true</code> if this application user is digital signing; <code>false</code> otherwise
	 */
	@Override
	public boolean isDigitalSigning() {
		return model.isDigitalSigning();
	}

	/**
	 * Returns <code>true</code> if this application user is e gov access.
	 *
	 * @return <code>true</code> if this application user is e gov access; <code>false</code> otherwise
	 */
	@Override
	public boolean isEGovAccess() {
		return model.isEGovAccess();
	}

	/**
	 * Returns <code>true</code> if this application user is email access.
	 *
	 * @return <code>true</code> if this application user is email access; <code>false</code> otherwise
	 */
	@Override
	public boolean isEmailAccess() {
		return model.isEmailAccess();
	}

	/**
	 * Returns <code>true</code> if this application user is idam service status.
	 *
	 * @return <code>true</code> if this application user is idam service status; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamServiceStatus() {
		return model.isIdamServiceStatus();
	}

	/**
	 * Returns <code>true</code> if this application user is idam user.
	 *
	 * @return <code>true</code> if this application user is idam user; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamUser() {
		return model.isIdamUser();
	}

	/**
	 * Returns <code>true</code> if this application user is idam user created.
	 *
	 * @return <code>true</code> if this application user is idam user created; <code>false</code> otherwise
	 */
	@Override
	public boolean isIdamUserCreated() {
		return model.isIdamUserCreated();
	}

	/**
	 * Returns <code>true</code> if this application user is last digital signing.
	 *
	 * @return <code>true</code> if this application user is last digital signing; <code>false</code> otherwise
	 */
	@Override
	public boolean isLastDigitalSigning() {
		return model.isLastDigitalSigning();
	}

	/**
	 * Returns <code>true</code> if this application user is last e gov access.
	 *
	 * @return <code>true</code> if this application user is last e gov access; <code>false</code> otherwise
	 */
	@Override
	public boolean isLastEGovAccess() {
		return model.isLastEGovAccess();
	}

	/**
	 * Returns <code>true</code> if this application user is last email access.
	 *
	 * @return <code>true</code> if this application user is last email access; <code>false</code> otherwise
	 */
	@Override
	public boolean isLastEmailAccess() {
		return model.isLastEmailAccess();
	}

	/**
	 * Returns <code>true</code> if this application user is last idam user.
	 *
	 * @return <code>true</code> if this application user is last idam user; <code>false</code> otherwise
	 */
	@Override
	public boolean isLastIdamUser() {
		return model.isLastIdamUser();
	}

	/**
	 * Returns <code>true</code> if this application user is last pis access.
	 *
	 * @return <code>true</code> if this application user is last pis access; <code>false</code> otherwise
	 */
	@Override
	public boolean isLastPisAccess() {
		return model.isLastPisAccess();
	}

	/**
	 * Returns <code>true</code> if this application user is pis access.
	 *
	 * @return <code>true</code> if this application user is pis access; <code>false</code> otherwise
	 */
	@Override
	public boolean isPisAccess() {
		return model.isPisAccess();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the application user ID of this application user.
	 *
	 * @param applicationUserId the application user ID of this application user
	 */
	@Override
	public void setApplicationUserId(long applicationUserId) {
		model.setApplicationUserId(applicationUserId);
	}

	/**
	 * Sets the application user uuid of this application user.
	 *
	 * @param applicationUserUuid the application user uuid of this application user
	 */
	@Override
	public void setApplicationUserUuid(String applicationUserUuid) {
		model.setApplicationUserUuid(applicationUserUuid);
	}

	/**
	 * Sets the company ID of this application user.
	 *
	 * @param companyId the company ID of this application user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this application user.
	 *
	 * @param createDate the create date of this application user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this application user is deleted.
	 *
	 * @param deleted the deleted of this application user
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets whether this application user is digital signing.
	 *
	 * @param digitalSigning the digital signing of this application user
	 */
	@Override
	public void setDigitalSigning(boolean digitalSigning) {
		model.setDigitalSigning(digitalSigning);
	}

	/**
	 * Sets whether this application user is e gov access.
	 *
	 * @param eGovAccess the e gov access of this application user
	 */
	@Override
	public void setEGovAccess(boolean eGovAccess) {
		model.setEGovAccess(eGovAccess);
	}

	/**
	 * Sets whether this application user is email access.
	 *
	 * @param emailAccess the email access of this application user
	 */
	@Override
	public void setEmailAccess(boolean emailAccess) {
		model.setEmailAccess(emailAccess);
	}

	/**
	 * Sets the employee ID of this application user.
	 *
	 * @param employeeId the employee ID of this application user
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this application user.
	 *
	 * @param groupId the group ID of this application user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the idam service message of this application user.
	 *
	 * @param idamServiceMessage the idam service message of this application user
	 */
	@Override
	public void setIdamServiceMessage(String idamServiceMessage) {
		model.setIdamServiceMessage(idamServiceMessage);
	}

	/**
	 * Sets whether this application user is idam service status.
	 *
	 * @param idamServiceStatus the idam service status of this application user
	 */
	@Override
	public void setIdamServiceStatus(boolean idamServiceStatus) {
		model.setIdamServiceStatus(idamServiceStatus);
	}

	/**
	 * Sets whether this application user is idam user.
	 *
	 * @param idamUser the idam user of this application user
	 */
	@Override
	public void setIdamUser(boolean idamUser) {
		model.setIdamUser(idamUser);
	}

	/**
	 * Sets whether this application user is idam user created.
	 *
	 * @param idamUserCreated the idam user created of this application user
	 */
	@Override
	public void setIdamUserCreated(boolean idamUserCreated) {
		model.setIdamUserCreated(idamUserCreated);
	}

	/**
	 * Sets whether this application user is last digital signing.
	 *
	 * @param lastDigitalSigning the last digital signing of this application user
	 */
	@Override
	public void setLastDigitalSigning(boolean lastDigitalSigning) {
		model.setLastDigitalSigning(lastDigitalSigning);
	}

	/**
	 * Sets whether this application user is last e gov access.
	 *
	 * @param lastEGovAccess the last e gov access of this application user
	 */
	@Override
	public void setLastEGovAccess(boolean lastEGovAccess) {
		model.setLastEGovAccess(lastEGovAccess);
	}

	/**
	 * Sets whether this application user is last email access.
	 *
	 * @param lastEmailAccess the last email access of this application user
	 */
	@Override
	public void setLastEmailAccess(boolean lastEmailAccess) {
		model.setLastEmailAccess(lastEmailAccess);
	}

	/**
	 * Sets whether this application user is last idam user.
	 *
	 * @param lastIdamUser the last idam user of this application user
	 */
	@Override
	public void setLastIdamUser(boolean lastIdamUser) {
		model.setLastIdamUser(lastIdamUser);
	}

	/**
	 * Sets whether this application user is last pis access.
	 *
	 * @param lastPisAccess the last pis access of this application user
	 */
	@Override
	public void setLastPisAccess(boolean lastPisAccess) {
		model.setLastPisAccess(lastPisAccess);
	}

	/**
	 * Sets the login ID of this application user.
	 *
	 * @param loginId the login ID of this application user
	 */
	@Override
	public void setLoginId(String loginId) {
		model.setLoginId(loginId);
	}

	/**
	 * Sets the modified date of this application user.
	 *
	 * @param modifiedDate the modified date of this application user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this application user is pis access.
	 *
	 * @param pisAccess the pis access of this application user
	 */
	@Override
	public void setPisAccess(boolean pisAccess) {
		model.setPisAccess(pisAccess);
	}

	/**
	 * Sets the primary key of this application user.
	 *
	 * @param primaryKey the primary key of this application user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this application user.
	 *
	 * @param status the status of this application user
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this application user.
	 *
	 * @param userId the user ID of this application user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this application user.
	 *
	 * @param userName the user name of this application user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this application user.
	 *
	 * @param userUuid the user uuid of this application user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ApplicationUserWrapper wrap(ApplicationUser applicationUser) {
		return new ApplicationUserWrapper(applicationUser);
	}

}