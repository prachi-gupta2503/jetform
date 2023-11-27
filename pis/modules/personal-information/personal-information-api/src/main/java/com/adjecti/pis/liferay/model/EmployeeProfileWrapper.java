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
 * This class is a wrapper for {@link EmployeeProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProfile
 * @generated
 */
public class EmployeeProfileWrapper
	extends BaseModelWrapper<EmployeeProfile>
	implements EmployeeProfile, ModelWrapper<EmployeeProfile> {

	public EmployeeProfileWrapper(EmployeeProfile employeeProfile) {
		super(employeeProfile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeProfileId", getEmployeeProfileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("profileDocumentId", getProfileDocumentId());
		attributes.put("profileDescription", getProfileDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeProfileId = (Long)attributes.get("employeeProfileId");

		if (employeeProfileId != null) {
			setEmployeeProfileId(employeeProfileId);
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

		Long profileDocumentId = (Long)attributes.get("profileDocumentId");

		if (profileDocumentId != null) {
			setProfileDocumentId(profileDocumentId);
		}

		String profileDescription = (String)attributes.get(
			"profileDescription");

		if (profileDescription != null) {
			setProfileDescription(profileDescription);
		}
	}

	/**
	 * Returns the company ID of this employee profile.
	 *
	 * @return the company ID of this employee profile
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee profile.
	 *
	 * @return the create date of this employee profile
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee profile.
	 *
	 * @return the employee ID of this employee profile
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee profile ID of this employee profile.
	 *
	 * @return the employee profile ID of this employee profile
	 */
	@Override
	public long getEmployeeProfileId() {
		return model.getEmployeeProfileId();
	}

	/**
	 * Returns the group ID of this employee profile.
	 *
	 * @return the group ID of this employee profile
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee profile.
	 *
	 * @return the modified date of this employee profile
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee profile.
	 *
	 * @return the primary key of this employee profile
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile description of this employee profile.
	 *
	 * @return the profile description of this employee profile
	 */
	@Override
	public String getProfileDescription() {
		return model.getProfileDescription();
	}

	/**
	 * Returns the profile document ID of this employee profile.
	 *
	 * @return the profile document ID of this employee profile
	 */
	@Override
	public long getProfileDocumentId() {
		return model.getProfileDocumentId();
	}

	/**
	 * Returns the user ID of this employee profile.
	 *
	 * @return the user ID of this employee profile
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee profile.
	 *
	 * @return the user name of this employee profile
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee profile.
	 *
	 * @return the user uuid of this employee profile
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employee profile.
	 *
	 * @param companyId the company ID of this employee profile
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee profile.
	 *
	 * @param createDate the create date of this employee profile
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee profile.
	 *
	 * @param employeeId the employee ID of this employee profile
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee profile ID of this employee profile.
	 *
	 * @param employeeProfileId the employee profile ID of this employee profile
	 */
	@Override
	public void setEmployeeProfileId(long employeeProfileId) {
		model.setEmployeeProfileId(employeeProfileId);
	}

	/**
	 * Sets the group ID of this employee profile.
	 *
	 * @param groupId the group ID of this employee profile
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee profile.
	 *
	 * @param modifiedDate the modified date of this employee profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee profile.
	 *
	 * @param primaryKey the primary key of this employee profile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile description of this employee profile.
	 *
	 * @param profileDescription the profile description of this employee profile
	 */
	@Override
	public void setProfileDescription(String profileDescription) {
		model.setProfileDescription(profileDescription);
	}

	/**
	 * Sets the profile document ID of this employee profile.
	 *
	 * @param profileDocumentId the profile document ID of this employee profile
	 */
	@Override
	public void setProfileDocumentId(long profileDocumentId) {
		model.setProfileDocumentId(profileDocumentId);
	}

	/**
	 * Sets the user ID of this employee profile.
	 *
	 * @param userId the user ID of this employee profile
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee profile.
	 *
	 * @param userName the user name of this employee profile
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee profile.
	 *
	 * @param userUuid the user uuid of this employee profile
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeProfileWrapper wrap(EmployeeProfile employeeProfile) {
		return new EmployeeProfileWrapper(employeeProfile);
	}

}