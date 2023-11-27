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
 * This class is a wrapper for {@link ApplicationAccess}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationAccess
 * @generated
 */
public class ApplicationAccessWrapper
	extends BaseModelWrapper<ApplicationAccess>
	implements ApplicationAccess, ModelWrapper<ApplicationAccess> {

	public ApplicationAccessWrapper(ApplicationAccess applicationAccess) {
		super(applicationAccess);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationAccessId", getApplicationAccessId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("applicationId", getApplicationId());
		attributes.put("status", getStatus());
		attributes.put("deleted", isDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationAccessId = (Long)attributes.get("applicationAccessId");

		if (applicationAccessId != null) {
			setApplicationAccessId(applicationAccessId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	 * Returns the application access ID of this application access.
	 *
	 * @return the application access ID of this application access
	 */
	@Override
	public long getApplicationAccessId() {
		return model.getApplicationAccessId();
	}

	/**
	 * Returns the application ID of this application access.
	 *
	 * @return the application ID of this application access
	 */
	@Override
	public long getApplicationId() {
		return model.getApplicationId();
	}

	/**
	 * Returns the company ID of this application access.
	 *
	 * @return the company ID of this application access
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this application access.
	 *
	 * @return the create date of this application access
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this application access.
	 *
	 * @return the deleted of this application access
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the employee ID of this application access.
	 *
	 * @return the employee ID of this application access
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this application access.
	 *
	 * @return the group ID of this application access
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this application access.
	 *
	 * @return the modified date of this application access
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this application access.
	 *
	 * @return the primary key of this application access
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this application access.
	 *
	 * @return the status of this application access
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this application access.
	 *
	 * @return the user ID of this application access
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this application access.
	 *
	 * @return the user name of this application access
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this application access.
	 *
	 * @return the user uuid of this application access
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this application access is deleted.
	 *
	 * @return <code>true</code> if this application access is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the application access ID of this application access.
	 *
	 * @param applicationAccessId the application access ID of this application access
	 */
	@Override
	public void setApplicationAccessId(long applicationAccessId) {
		model.setApplicationAccessId(applicationAccessId);
	}

	/**
	 * Sets the application ID of this application access.
	 *
	 * @param applicationId the application ID of this application access
	 */
	@Override
	public void setApplicationId(long applicationId) {
		model.setApplicationId(applicationId);
	}

	/**
	 * Sets the company ID of this application access.
	 *
	 * @param companyId the company ID of this application access
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this application access.
	 *
	 * @param createDate the create date of this application access
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this application access is deleted.
	 *
	 * @param deleted the deleted of this application access
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the employee ID of this application access.
	 *
	 * @param employeeId the employee ID of this application access
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this application access.
	 *
	 * @param groupId the group ID of this application access
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this application access.
	 *
	 * @param modifiedDate the modified date of this application access
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this application access.
	 *
	 * @param primaryKey the primary key of this application access
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this application access.
	 *
	 * @param status the status of this application access
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this application access.
	 *
	 * @param userId the user ID of this application access
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this application access.
	 *
	 * @param userName the user name of this application access
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this application access.
	 *
	 * @param userUuid the user uuid of this application access
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ApplicationAccessWrapper wrap(
		ApplicationAccess applicationAccess) {

		return new ApplicationAccessWrapper(applicationAccess);
	}

}