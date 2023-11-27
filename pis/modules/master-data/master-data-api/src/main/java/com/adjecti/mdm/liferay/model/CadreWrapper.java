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
 * This class is a wrapper for {@link Cadre}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Cadre
 * @generated
 */
public class CadreWrapper
	extends BaseModelWrapper<Cadre> implements Cadre, ModelWrapper<Cadre> {

	public CadreWrapper(Cadre cadre) {
		super(cadre);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cadreId", getCadreId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("designationGroupId", getDesignationGroupId());
		attributes.put("rank", getRank());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cadreId = (Long)attributes.get("cadreId");

		if (cadreId != null) {
			setCadreId(cadreId);
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

		Long designationGroupId = (Long)attributes.get("designationGroupId");

		if (designationGroupId != null) {
			setDesignationGroupId(designationGroupId);
		}

		Integer rank = (Integer)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
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
	 * Returns the cadre ID of this cadre.
	 *
	 * @return the cadre ID of this cadre
	 */
	@Override
	public long getCadreId() {
		return model.getCadreId();
	}

	/**
	 * Returns the code of this cadre.
	 *
	 * @return the code of this cadre
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this cadre.
	 *
	 * @return the company ID of this cadre
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this cadre.
	 *
	 * @return the create date of this cadre
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this cadre.
	 *
	 * @return the deleted of this cadre
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this cadre.
	 *
	 * @return the description of this cadre
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the designation group ID of this cadre.
	 *
	 * @return the designation group ID of this cadre
	 */
	@Override
	public long getDesignationGroupId() {
		return model.getDesignationGroupId();
	}

	/**
	 * Returns the group ID of this cadre.
	 *
	 * @return the group ID of this cadre
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this cadre.
	 *
	 * @return the modified date of this cadre
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this cadre.
	 *
	 * @return the name of this cadre
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cadre.
	 *
	 * @return the primary key of this cadre
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rank of this cadre.
	 *
	 * @return the rank of this cadre
	 */
	@Override
	public int getRank() {
		return model.getRank();
	}

	/**
	 * Returns the status of this cadre.
	 *
	 * @return the status of this cadre
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this cadre.
	 *
	 * @return the user ID of this cadre
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cadre.
	 *
	 * @return the user name of this cadre
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cadre.
	 *
	 * @return the user uuid of this cadre
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this cadre is deleted.
	 *
	 * @return <code>true</code> if this cadre is deleted; <code>false</code> otherwise
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
	 * Sets the cadre ID of this cadre.
	 *
	 * @param cadreId the cadre ID of this cadre
	 */
	@Override
	public void setCadreId(long cadreId) {
		model.setCadreId(cadreId);
	}

	/**
	 * Sets the code of this cadre.
	 *
	 * @param code the code of this cadre
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this cadre.
	 *
	 * @param companyId the company ID of this cadre
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this cadre.
	 *
	 * @param createDate the create date of this cadre
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this cadre is deleted.
	 *
	 * @param deleted the deleted of this cadre
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this cadre.
	 *
	 * @param description the description of this cadre
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the designation group ID of this cadre.
	 *
	 * @param designationGroupId the designation group ID of this cadre
	 */
	@Override
	public void setDesignationGroupId(long designationGroupId) {
		model.setDesignationGroupId(designationGroupId);
	}

	/**
	 * Sets the group ID of this cadre.
	 *
	 * @param groupId the group ID of this cadre
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this cadre.
	 *
	 * @param modifiedDate the modified date of this cadre
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this cadre.
	 *
	 * @param name the name of this cadre
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cadre.
	 *
	 * @param primaryKey the primary key of this cadre
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rank of this cadre.
	 *
	 * @param rank the rank of this cadre
	 */
	@Override
	public void setRank(int rank) {
		model.setRank(rank);
	}

	/**
	 * Sets the status of this cadre.
	 *
	 * @param status the status of this cadre
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this cadre.
	 *
	 * @param userId the user ID of this cadre
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cadre.
	 *
	 * @param userName the user name of this cadre
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cadre.
	 *
	 * @param userUuid the user uuid of this cadre
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CadreWrapper wrap(Cadre cadre) {
		return new CadreWrapper(cadre);
	}

}