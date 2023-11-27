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
 * This class is a wrapper for {@link OrganizationStation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationStation
 * @generated
 */
public class OrganizationStationWrapper
	extends BaseModelWrapper<OrganizationStation>
	implements ModelWrapper<OrganizationStation>, OrganizationStation {

	public OrganizationStationWrapper(OrganizationStation organizationStation) {
		super(organizationStation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationStationId", getOrganizationStationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationStationId = (Long)attributes.get(
			"organizationStationId");

		if (organizationStationId != null) {
			setOrganizationStationId(organizationStationId);
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
	 * Returns the code of this organization station.
	 *
	 * @return the code of this organization station
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this organization station.
	 *
	 * @return the company ID of this organization station
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this organization station.
	 *
	 * @return the create date of this organization station
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this organization station.
	 *
	 * @return the deleted of this organization station
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this organization station.
	 *
	 * @return the group ID of this organization station
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this organization station.
	 *
	 * @return the modified date of this organization station
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this organization station.
	 *
	 * @return the name of this organization station
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the organization station ID of this organization station.
	 *
	 * @return the organization station ID of this organization station
	 */
	@Override
	public long getOrganizationStationId() {
		return model.getOrganizationStationId();
	}

	/**
	 * Returns the primary key of this organization station.
	 *
	 * @return the primary key of this organization station
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this organization station.
	 *
	 * @return the status of this organization station
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this organization station.
	 *
	 * @return the user ID of this organization station
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this organization station.
	 *
	 * @return the user name of this organization station
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this organization station.
	 *
	 * @return the user uuid of this organization station
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this organization station is deleted.
	 *
	 * @return <code>true</code> if this organization station is deleted; <code>false</code> otherwise
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
	 * Sets the code of this organization station.
	 *
	 * @param code the code of this organization station
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this organization station.
	 *
	 * @param companyId the company ID of this organization station
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this organization station.
	 *
	 * @param createDate the create date of this organization station
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this organization station is deleted.
	 *
	 * @param deleted the deleted of this organization station
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this organization station.
	 *
	 * @param groupId the group ID of this organization station
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this organization station.
	 *
	 * @param modifiedDate the modified date of this organization station
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this organization station.
	 *
	 * @param name the name of this organization station
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the organization station ID of this organization station.
	 *
	 * @param organizationStationId the organization station ID of this organization station
	 */
	@Override
	public void setOrganizationStationId(long organizationStationId) {
		model.setOrganizationStationId(organizationStationId);
	}

	/**
	 * Sets the primary key of this organization station.
	 *
	 * @param primaryKey the primary key of this organization station
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this organization station.
	 *
	 * @param status the status of this organization station
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this organization station.
	 *
	 * @param userId the user ID of this organization station
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this organization station.
	 *
	 * @param userName the user name of this organization station
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this organization station.
	 *
	 * @param userUuid the user uuid of this organization station
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OrganizationStationWrapper wrap(
		OrganizationStation organizationStation) {

		return new OrganizationStationWrapper(organizationStation);
	}

}