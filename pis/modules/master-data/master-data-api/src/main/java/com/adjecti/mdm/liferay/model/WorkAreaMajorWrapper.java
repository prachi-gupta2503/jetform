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

package com.adjecti.mdm.liferay.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkAreaMajor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMajor
 * @generated
 */
public class WorkAreaMajorWrapper
	extends BaseModelWrapper<WorkAreaMajor>
	implements ModelWrapper<WorkAreaMajor>, WorkAreaMajor {

	public WorkAreaMajorWrapper(WorkAreaMajor workAreaMajor) {
		super(workAreaMajor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workAreaMajorId", getWorkAreaMajorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("workAreaTypeId", getWorkAreaTypeId());
		attributes.put("parentWorkAreaId", getParentWorkAreaId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workAreaMajorId = (Long)attributes.get("workAreaMajorId");

		if (workAreaMajorId != null) {
			setWorkAreaMajorId(workAreaMajorId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long workAreaTypeId = (Long)attributes.get("workAreaTypeId");

		if (workAreaTypeId != null) {
			setWorkAreaTypeId(workAreaTypeId);
		}

		Long parentWorkAreaId = (Long)attributes.get("parentWorkAreaId");

		if (parentWorkAreaId != null) {
			setParentWorkAreaId(parentWorkAreaId);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the code of this work area major.
	 *
	 * @return the code of this work area major
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this work area major.
	 *
	 * @return the company ID of this work area major
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this work area major.
	 *
	 * @return the create date of this work area major
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this work area major.
	 *
	 * @return the deleted of this work area major
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this work area major.
	 *
	 * @return the group ID of this work area major
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this work area major.
	 *
	 * @return the modified date of this work area major
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this work area major.
	 *
	 * @return the name of this work area major
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent work area ID of this work area major.
	 *
	 * @return the parent work area ID of this work area major
	 */
	@Override
	public long getParentWorkAreaId() {
		return model.getParentWorkAreaId();
	}

	/**
	 * Returns the primary key of this work area major.
	 *
	 * @return the primary key of this work area major
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this work area major.
	 *
	 * @return the status of this work area major
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this work area major.
	 *
	 * @return the user ID of this work area major
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this work area major.
	 *
	 * @return the user name of this work area major
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this work area major.
	 *
	 * @return the user uuid of this work area major
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the work area major ID of this work area major.
	 *
	 * @return the work area major ID of this work area major
	 */
	@Override
	public long getWorkAreaMajorId() {
		return model.getWorkAreaMajorId();
	}

	/**
	 * Returns the work area type ID of this work area major.
	 *
	 * @return the work area type ID of this work area major
	 */
	@Override
	public long getWorkAreaTypeId() {
		return model.getWorkAreaTypeId();
	}

	/**
	 * Returns <code>true</code> if this work area major is deleted.
	 *
	 * @return <code>true</code> if this work area major is deleted; <code>false</code> otherwise
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
	 * Sets the code of this work area major.
	 *
	 * @param code the code of this work area major
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this work area major.
	 *
	 * @param companyId the company ID of this work area major
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this work area major.
	 *
	 * @param createDate the create date of this work area major
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this work area major is deleted.
	 *
	 * @param deleted the deleted of this work area major
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this work area major.
	 *
	 * @param groupId the group ID of this work area major
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this work area major.
	 *
	 * @param modifiedDate the modified date of this work area major
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this work area major.
	 *
	 * @param name the name of this work area major
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent work area ID of this work area major.
	 *
	 * @param parentWorkAreaId the parent work area ID of this work area major
	 */
	@Override
	public void setParentWorkAreaId(long parentWorkAreaId) {
		model.setParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Sets the primary key of this work area major.
	 *
	 * @param primaryKey the primary key of this work area major
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this work area major.
	 *
	 * @param status the status of this work area major
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this work area major.
	 *
	 * @param userId the user ID of this work area major
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this work area major.
	 *
	 * @param userName the user name of this work area major
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this work area major.
	 *
	 * @param userUuid the user uuid of this work area major
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the work area major ID of this work area major.
	 *
	 * @param workAreaMajorId the work area major ID of this work area major
	 */
	@Override
	public void setWorkAreaMajorId(long workAreaMajorId) {
		model.setWorkAreaMajorId(workAreaMajorId);
	}

	/**
	 * Sets the work area type ID of this work area major.
	 *
	 * @param workAreaTypeId the work area type ID of this work area major
	 */
	@Override
	public void setWorkAreaTypeId(long workAreaTypeId) {
		model.setWorkAreaTypeId(workAreaTypeId);
	}

	@Override
	protected WorkAreaMajorWrapper wrap(WorkAreaMajor workAreaMajor) {
		return new WorkAreaMajorWrapper(workAreaMajor);
	}

}