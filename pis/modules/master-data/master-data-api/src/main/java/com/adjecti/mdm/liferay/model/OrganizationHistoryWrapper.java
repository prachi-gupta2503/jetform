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
 * This class is a wrapper for {@link OrganizationHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationHistory
 * @generated
 */
public class OrganizationHistoryWrapper
	extends BaseModelWrapper<OrganizationHistory>
	implements ModelWrapper<OrganizationHistory>, OrganizationHistory {

	public OrganizationHistoryWrapper(OrganizationHistory organizationHistory) {
		super(organizationHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationHistoryId", getOrganizationHistoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put(
			"previousOrganizationName", getPreviousOrganizationName());
		attributes.put("previousOrganizationId", getPreviousOrganizationId());
		attributes.put(
			"previousParentOrganizationName",
			getPreviousParentOrganizationName());
		attributes.put(
			"previousParentOrganizationId", getPreviousParentOrganizationId());
		attributes.put("organizationName", getOrganizationName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationHistoryId = (Long)attributes.get(
			"organizationHistoryId");

		if (organizationHistoryId != null) {
			setOrganizationHistoryId(organizationHistoryId);
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

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String previousOrganizationName = (String)attributes.get(
			"previousOrganizationName");

		if (previousOrganizationName != null) {
			setPreviousOrganizationName(previousOrganizationName);
		}

		Long previousOrganizationId = (Long)attributes.get(
			"previousOrganizationId");

		if (previousOrganizationId != null) {
			setPreviousOrganizationId(previousOrganizationId);
		}

		String previousParentOrganizationName = (String)attributes.get(
			"previousParentOrganizationName");

		if (previousParentOrganizationName != null) {
			setPreviousParentOrganizationName(previousParentOrganizationName);
		}

		Long previousParentOrganizationId = (Long)attributes.get(
			"previousParentOrganizationId");

		if (previousParentOrganizationId != null) {
			setPreviousParentOrganizationId(previousParentOrganizationId);
		}

		String organizationName = (String)attributes.get("organizationName");

		if (organizationName != null) {
			setOrganizationName(organizationName);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this organization history.
	 *
	 * @return the company ID of this organization history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this organization history.
	 *
	 * @return the create date of this organization history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this organization history.
	 *
	 * @return the group ID of this organization history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this organization history.
	 *
	 * @return the modified date of this organization history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization history ID of this organization history.
	 *
	 * @return the organization history ID of this organization history
	 */
	@Override
	public long getOrganizationHistoryId() {
		return model.getOrganizationHistoryId();
	}

	/**
	 * Returns the organization ID of this organization history.
	 *
	 * @return the organization ID of this organization history
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the organization name of this organization history.
	 *
	 * @return the organization name of this organization history
	 */
	@Override
	public String getOrganizationName() {
		return model.getOrganizationName();
	}

	/**
	 * Returns the previous organization ID of this organization history.
	 *
	 * @return the previous organization ID of this organization history
	 */
	@Override
	public long getPreviousOrganizationId() {
		return model.getPreviousOrganizationId();
	}

	/**
	 * Returns the previous organization name of this organization history.
	 *
	 * @return the previous organization name of this organization history
	 */
	@Override
	public String getPreviousOrganizationName() {
		return model.getPreviousOrganizationName();
	}

	/**
	 * Returns the previous parent organization ID of this organization history.
	 *
	 * @return the previous parent organization ID of this organization history
	 */
	@Override
	public long getPreviousParentOrganizationId() {
		return model.getPreviousParentOrganizationId();
	}

	/**
	 * Returns the previous parent organization name of this organization history.
	 *
	 * @return the previous parent organization name of this organization history
	 */
	@Override
	public String getPreviousParentOrganizationName() {
		return model.getPreviousParentOrganizationName();
	}

	/**
	 * Returns the primary key of this organization history.
	 *
	 * @return the primary key of this organization history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this organization history.
	 *
	 * @return the status of this organization history
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this organization history.
	 *
	 * @return the user ID of this organization history
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this organization history.
	 *
	 * @return the user name of this organization history
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this organization history.
	 *
	 * @return the user uuid of this organization history
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
	 * Sets the company ID of this organization history.
	 *
	 * @param companyId the company ID of this organization history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this organization history.
	 *
	 * @param createDate the create date of this organization history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this organization history.
	 *
	 * @param groupId the group ID of this organization history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this organization history.
	 *
	 * @param modifiedDate the modified date of this organization history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization history ID of this organization history.
	 *
	 * @param organizationHistoryId the organization history ID of this organization history
	 */
	@Override
	public void setOrganizationHistoryId(long organizationHistoryId) {
		model.setOrganizationHistoryId(organizationHistoryId);
	}

	/**
	 * Sets the organization ID of this organization history.
	 *
	 * @param organizationId the organization ID of this organization history
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the organization name of this organization history.
	 *
	 * @param organizationName the organization name of this organization history
	 */
	@Override
	public void setOrganizationName(String organizationName) {
		model.setOrganizationName(organizationName);
	}

	/**
	 * Sets the previous organization ID of this organization history.
	 *
	 * @param previousOrganizationId the previous organization ID of this organization history
	 */
	@Override
	public void setPreviousOrganizationId(long previousOrganizationId) {
		model.setPreviousOrganizationId(previousOrganizationId);
	}

	/**
	 * Sets the previous organization name of this organization history.
	 *
	 * @param previousOrganizationName the previous organization name of this organization history
	 */
	@Override
	public void setPreviousOrganizationName(String previousOrganizationName) {
		model.setPreviousOrganizationName(previousOrganizationName);
	}

	/**
	 * Sets the previous parent organization ID of this organization history.
	 *
	 * @param previousParentOrganizationId the previous parent organization ID of this organization history
	 */
	@Override
	public void setPreviousParentOrganizationId(
		long previousParentOrganizationId) {

		model.setPreviousParentOrganizationId(previousParentOrganizationId);
	}

	/**
	 * Sets the previous parent organization name of this organization history.
	 *
	 * @param previousParentOrganizationName the previous parent organization name of this organization history
	 */
	@Override
	public void setPreviousParentOrganizationName(
		String previousParentOrganizationName) {

		model.setPreviousParentOrganizationName(previousParentOrganizationName);
	}

	/**
	 * Sets the primary key of this organization history.
	 *
	 * @param primaryKey the primary key of this organization history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this organization history.
	 *
	 * @param status the status of this organization history
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this organization history.
	 *
	 * @param userId the user ID of this organization history
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this organization history.
	 *
	 * @param userName the user name of this organization history
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this organization history.
	 *
	 * @param userUuid the user uuid of this organization history
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OrganizationHistoryWrapper wrap(
		OrganizationHistory organizationHistory) {

		return new OrganizationHistoryWrapper(organizationHistory);
	}

}