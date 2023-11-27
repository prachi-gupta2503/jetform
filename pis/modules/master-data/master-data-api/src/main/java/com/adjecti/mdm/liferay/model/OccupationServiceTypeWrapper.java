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
 * This class is a wrapper for {@link OccupationServiceType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OccupationServiceType
 * @generated
 */
public class OccupationServiceTypeWrapper
	extends BaseModelWrapper<OccupationServiceType>
	implements ModelWrapper<OccupationServiceType>, OccupationServiceType {

	public OccupationServiceTypeWrapper(
		OccupationServiceType occupationServiceType) {

		super(occupationServiceType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("occupationServiceTypeId", getOccupationServiceTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long occupationServiceTypeId = (Long)attributes.get(
			"occupationServiceTypeId");

		if (occupationServiceTypeId != null) {
			setOccupationServiceTypeId(occupationServiceTypeId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	 * Returns the code of this occupation service type.
	 *
	 * @return the code of this occupation service type
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this occupation service type.
	 *
	 * @return the company ID of this occupation service type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this occupation service type.
	 *
	 * @return the create date of this occupation service type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this occupation service type.
	 *
	 * @return the deleted of this occupation service type
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this occupation service type.
	 *
	 * @return the description of this occupation service type
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this occupation service type.
	 *
	 * @return the group ID of this occupation service type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this occupation service type.
	 *
	 * @return the modified date of this occupation service type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this occupation service type.
	 *
	 * @return the name of this occupation service type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the occupation service type ID of this occupation service type.
	 *
	 * @return the occupation service type ID of this occupation service type
	 */
	@Override
	public long getOccupationServiceTypeId() {
		return model.getOccupationServiceTypeId();
	}

	/**
	 * Returns the primary key of this occupation service type.
	 *
	 * @return the primary key of this occupation service type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this occupation service type.
	 *
	 * @return the status of this occupation service type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this occupation service type.
	 *
	 * @return the user ID of this occupation service type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this occupation service type.
	 *
	 * @return the user name of this occupation service type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this occupation service type.
	 *
	 * @return the user uuid of this occupation service type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this occupation service type is deleted.
	 *
	 * @return <code>true</code> if this occupation service type is deleted; <code>false</code> otherwise
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
	 * Sets the code of this occupation service type.
	 *
	 * @param code the code of this occupation service type
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this occupation service type.
	 *
	 * @param companyId the company ID of this occupation service type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this occupation service type.
	 *
	 * @param createDate the create date of this occupation service type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this occupation service type is deleted.
	 *
	 * @param deleted the deleted of this occupation service type
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this occupation service type.
	 *
	 * @param description the description of this occupation service type
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this occupation service type.
	 *
	 * @param groupId the group ID of this occupation service type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this occupation service type.
	 *
	 * @param modifiedDate the modified date of this occupation service type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this occupation service type.
	 *
	 * @param name the name of this occupation service type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the occupation service type ID of this occupation service type.
	 *
	 * @param occupationServiceTypeId the occupation service type ID of this occupation service type
	 */
	@Override
	public void setOccupationServiceTypeId(long occupationServiceTypeId) {
		model.setOccupationServiceTypeId(occupationServiceTypeId);
	}

	/**
	 * Sets the primary key of this occupation service type.
	 *
	 * @param primaryKey the primary key of this occupation service type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this occupation service type.
	 *
	 * @param status the status of this occupation service type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this occupation service type.
	 *
	 * @param userId the user ID of this occupation service type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this occupation service type.
	 *
	 * @param userName the user name of this occupation service type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this occupation service type.
	 *
	 * @param userUuid the user uuid of this occupation service type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OccupationServiceTypeWrapper wrap(
		OccupationServiceType occupationServiceType) {

		return new OccupationServiceTypeWrapper(occupationServiceType);
	}

}