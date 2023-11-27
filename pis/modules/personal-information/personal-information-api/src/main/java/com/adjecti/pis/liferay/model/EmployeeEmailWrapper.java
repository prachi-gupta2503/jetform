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
 * This class is a wrapper for {@link EmployeeEmail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEmail
 * @generated
 */
public class EmployeeEmailWrapper
	extends BaseModelWrapper<EmployeeEmail>
	implements EmployeeEmail, ModelWrapper<EmployeeEmail> {

	public EmployeeEmailWrapper(EmployeeEmail employeeEmail) {
		super(employeeEmail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeEmailId", getEmployeeEmailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("emailAddressType", getEmailAddressType());
		attributes.put("active", isActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeEmailId = (Long)attributes.get("employeeEmailId");

		if (employeeEmailId != null) {
			setEmployeeEmailId(employeeEmailId);
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

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String emailAddressType = (String)attributes.get("emailAddressType");

		if (emailAddressType != null) {
			setEmailAddressType(emailAddressType);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this employee email.
	 *
	 * @return the active of this employee email
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee email.
	 *
	 * @return the company ID of this employee email
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee email.
	 *
	 * @return the create date of this employee email
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email address of this employee email.
	 *
	 * @return the email address of this employee email
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the email address type of this employee email.
	 *
	 * @return the email address type of this employee email
	 */
	@Override
	public String getEmailAddressType() {
		return model.getEmailAddressType();
	}

	/**
	 * Returns the employee email ID of this employee email.
	 *
	 * @return the employee email ID of this employee email
	 */
	@Override
	public long getEmployeeEmailId() {
		return model.getEmployeeEmailId();
	}

	/**
	 * Returns the employee ID of this employee email.
	 *
	 * @return the employee ID of this employee email
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee email.
	 *
	 * @return the group ID of this employee email
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee email.
	 *
	 * @return the modified date of this employee email
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee email.
	 *
	 * @return the primary key of this employee email
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee email.
	 *
	 * @return the user ID of this employee email
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee email.
	 *
	 * @return the user name of this employee email
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee email.
	 *
	 * @return the user uuid of this employee email
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee email is active.
	 *
	 * @return <code>true</code> if this employee email is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee email is active.
	 *
	 * @param active the active of this employee email
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee email.
	 *
	 * @param companyId the company ID of this employee email
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee email.
	 *
	 * @param createDate the create date of this employee email
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email address of this employee email.
	 *
	 * @param emailAddress the email address of this employee email
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the email address type of this employee email.
	 *
	 * @param emailAddressType the email address type of this employee email
	 */
	@Override
	public void setEmailAddressType(String emailAddressType) {
		model.setEmailAddressType(emailAddressType);
	}

	/**
	 * Sets the employee email ID of this employee email.
	 *
	 * @param employeeEmailId the employee email ID of this employee email
	 */
	@Override
	public void setEmployeeEmailId(long employeeEmailId) {
		model.setEmployeeEmailId(employeeEmailId);
	}

	/**
	 * Sets the employee ID of this employee email.
	 *
	 * @param employeeId the employee ID of this employee email
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee email.
	 *
	 * @param groupId the group ID of this employee email
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee email.
	 *
	 * @param modifiedDate the modified date of this employee email
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee email.
	 *
	 * @param primaryKey the primary key of this employee email
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee email.
	 *
	 * @param userId the user ID of this employee email
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee email.
	 *
	 * @param userName the user name of this employee email
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee email.
	 *
	 * @param userUuid the user uuid of this employee email
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeEmailWrapper wrap(EmployeeEmail employeeEmail) {
		return new EmployeeEmailWrapper(employeeEmail);
	}

}