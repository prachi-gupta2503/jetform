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
 * This class is a wrapper for {@link OrganizationPayStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationPayStructure
 * @generated
 */
public class OrganizationPayStructureWrapper
	extends BaseModelWrapper<OrganizationPayStructure>
	implements ModelWrapper<OrganizationPayStructure>,
			   OrganizationPayStructure {

	public OrganizationPayStructureWrapper(
		OrganizationPayStructure organizationPayStructure) {

		super(organizationPayStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"organizationPayStructureId", getOrganizationPayStructureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("levelId", getLevelId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("structureId", getStructureId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationPayStructureId = (Long)attributes.get(
			"organizationPayStructureId");

		if (organizationPayStructureId != null) {
			setOrganizationPayStructureId(organizationPayStructureId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long structureId = (Long)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
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
	 * Returns the active of this organization pay structure.
	 *
	 * @return the active of this organization pay structure
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this organization pay structure.
	 *
	 * @return the company ID of this organization pay structure
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this organization pay structure.
	 *
	 * @return the create date of this organization pay structure
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this organization pay structure.
	 *
	 * @return the deleted of this organization pay structure
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the from date of this organization pay structure.
	 *
	 * @return the from date of this organization pay structure
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this organization pay structure.
	 *
	 * @return the group ID of this organization pay structure
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level ID of this organization pay structure.
	 *
	 * @return the level ID of this organization pay structure
	 */
	@Override
	public long getLevelId() {
		return model.getLevelId();
	}

	/**
	 * Returns the modified date of this organization pay structure.
	 *
	 * @return the modified date of this organization pay structure
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this organization pay structure.
	 *
	 * @return the organization ID of this organization pay structure
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the organization pay structure ID of this organization pay structure.
	 *
	 * @return the organization pay structure ID of this organization pay structure
	 */
	@Override
	public long getOrganizationPayStructureId() {
		return model.getOrganizationPayStructureId();
	}

	/**
	 * Returns the primary key of this organization pay structure.
	 *
	 * @return the primary key of this organization pay structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this organization pay structure.
	 *
	 * @return the status of this organization pay structure
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the structure ID of this organization pay structure.
	 *
	 * @return the structure ID of this organization pay structure
	 */
	@Override
	public long getStructureId() {
		return model.getStructureId();
	}

	/**
	 * Returns the to date of this organization pay structure.
	 *
	 * @return the to date of this organization pay structure
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this organization pay structure.
	 *
	 * @return the user ID of this organization pay structure
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this organization pay structure.
	 *
	 * @return the user name of this organization pay structure
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this organization pay structure.
	 *
	 * @return the user uuid of this organization pay structure
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this organization pay structure is active.
	 *
	 * @return <code>true</code> if this organization pay structure is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this organization pay structure is deleted.
	 *
	 * @return <code>true</code> if this organization pay structure is deleted; <code>false</code> otherwise
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
	 * Sets whether this organization pay structure is active.
	 *
	 * @param active the active of this organization pay structure
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this organization pay structure.
	 *
	 * @param companyId the company ID of this organization pay structure
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this organization pay structure.
	 *
	 * @param createDate the create date of this organization pay structure
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this organization pay structure is deleted.
	 *
	 * @param deleted the deleted of this organization pay structure
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the from date of this organization pay structure.
	 *
	 * @param fromDate the from date of this organization pay structure
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this organization pay structure.
	 *
	 * @param groupId the group ID of this organization pay structure
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level ID of this organization pay structure.
	 *
	 * @param levelId the level ID of this organization pay structure
	 */
	@Override
	public void setLevelId(long levelId) {
		model.setLevelId(levelId);
	}

	/**
	 * Sets the modified date of this organization pay structure.
	 *
	 * @param modifiedDate the modified date of this organization pay structure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this organization pay structure.
	 *
	 * @param organizationId the organization ID of this organization pay structure
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the organization pay structure ID of this organization pay structure.
	 *
	 * @param organizationPayStructureId the organization pay structure ID of this organization pay structure
	 */
	@Override
	public void setOrganizationPayStructureId(long organizationPayStructureId) {
		model.setOrganizationPayStructureId(organizationPayStructureId);
	}

	/**
	 * Sets the primary key of this organization pay structure.
	 *
	 * @param primaryKey the primary key of this organization pay structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this organization pay structure.
	 *
	 * @param status the status of this organization pay structure
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the structure ID of this organization pay structure.
	 *
	 * @param structureId the structure ID of this organization pay structure
	 */
	@Override
	public void setStructureId(long structureId) {
		model.setStructureId(structureId);
	}

	/**
	 * Sets the to date of this organization pay structure.
	 *
	 * @param toDate the to date of this organization pay structure
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this organization pay structure.
	 *
	 * @param userId the user ID of this organization pay structure
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this organization pay structure.
	 *
	 * @param userName the user name of this organization pay structure
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this organization pay structure.
	 *
	 * @param userUuid the user uuid of this organization pay structure
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OrganizationPayStructureWrapper wrap(
		OrganizationPayStructure organizationPayStructure) {

		return new OrganizationPayStructureWrapper(organizationPayStructure);
	}

}