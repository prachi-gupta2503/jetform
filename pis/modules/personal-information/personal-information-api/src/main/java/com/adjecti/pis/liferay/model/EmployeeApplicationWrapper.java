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
 * This class is a wrapper for {@link EmployeeApplication}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplication
 * @generated
 */
public class EmployeeApplicationWrapper
	extends BaseModelWrapper<EmployeeApplication>
	implements EmployeeApplication, ModelWrapper<EmployeeApplication> {

	public EmployeeApplicationWrapper(EmployeeApplication employeeApplication) {
		super(employeeApplication);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeApplicationId", getEmployeeApplicationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("applicationId", getApplicationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeApplicationId = (Long)attributes.get(
			"employeeApplicationId");

		if (employeeApplicationId != null) {
			setEmployeeApplicationId(employeeApplicationId);
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

		Long applicationId = (Long)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
		}
	}

	/**
	 * Returns the application ID of this employee application.
	 *
	 * @return the application ID of this employee application
	 */
	@Override
	public long getApplicationId() {
		return model.getApplicationId();
	}

	/**
	 * Returns the company ID of this employee application.
	 *
	 * @return the company ID of this employee application
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee application.
	 *
	 * @return the create date of this employee application
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee application ID of this employee application.
	 *
	 * @return the employee application ID of this employee application
	 */
	@Override
	public long getEmployeeApplicationId() {
		return model.getEmployeeApplicationId();
	}

	/**
	 * Returns the employee ID of this employee application.
	 *
	 * @return the employee ID of this employee application
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee application.
	 *
	 * @return the group ID of this employee application
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee application.
	 *
	 * @return the modified date of this employee application
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee application.
	 *
	 * @return the primary key of this employee application
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee application.
	 *
	 * @return the user ID of this employee application
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee application.
	 *
	 * @return the user name of this employee application
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee application.
	 *
	 * @return the user uuid of this employee application
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
	 * Sets the application ID of this employee application.
	 *
	 * @param applicationId the application ID of this employee application
	 */
	@Override
	public void setApplicationId(long applicationId) {
		model.setApplicationId(applicationId);
	}

	/**
	 * Sets the company ID of this employee application.
	 *
	 * @param companyId the company ID of this employee application
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee application.
	 *
	 * @param createDate the create date of this employee application
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee application ID of this employee application.
	 *
	 * @param employeeApplicationId the employee application ID of this employee application
	 */
	@Override
	public void setEmployeeApplicationId(long employeeApplicationId) {
		model.setEmployeeApplicationId(employeeApplicationId);
	}

	/**
	 * Sets the employee ID of this employee application.
	 *
	 * @param employeeId the employee ID of this employee application
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee application.
	 *
	 * @param groupId the group ID of this employee application
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee application.
	 *
	 * @param modifiedDate the modified date of this employee application
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee application.
	 *
	 * @param primaryKey the primary key of this employee application
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee application.
	 *
	 * @param userId the user ID of this employee application
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee application.
	 *
	 * @param userName the user name of this employee application
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee application.
	 *
	 * @param userUuid the user uuid of this employee application
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeApplicationWrapper wrap(
		EmployeeApplication employeeApplication) {

		return new EmployeeApplicationWrapper(employeeApplication);
	}

}