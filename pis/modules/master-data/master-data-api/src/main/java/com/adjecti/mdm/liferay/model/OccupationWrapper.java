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
 * This class is a wrapper for {@link Occupation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Occupation
 * @generated
 */
public class OccupationWrapper
	extends BaseModelWrapper<Occupation>
	implements ModelWrapper<Occupation>, Occupation {

	public OccupationWrapper(Occupation occupation) {
		super(occupation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("occupationId", getOccupationId());
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
		Long occupationId = (Long)attributes.get("occupationId");

		if (occupationId != null) {
			setOccupationId(occupationId);
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
	 * Returns the code of this occupation.
	 *
	 * @return the code of this occupation
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this occupation.
	 *
	 * @return the company ID of this occupation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this occupation.
	 *
	 * @return the create date of this occupation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this occupation.
	 *
	 * @return the deleted of this occupation
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this occupation.
	 *
	 * @return the group ID of this occupation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this occupation.
	 *
	 * @return the modified date of this occupation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this occupation.
	 *
	 * @return the name of this occupation
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the occupation ID of this occupation.
	 *
	 * @return the occupation ID of this occupation
	 */
	@Override
	public long getOccupationId() {
		return model.getOccupationId();
	}

	/**
	 * Returns the primary key of this occupation.
	 *
	 * @return the primary key of this occupation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this occupation.
	 *
	 * @return the status of this occupation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this occupation.
	 *
	 * @return the user ID of this occupation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this occupation.
	 *
	 * @return the user name of this occupation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this occupation.
	 *
	 * @return the user uuid of this occupation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this occupation is deleted.
	 *
	 * @return <code>true</code> if this occupation is deleted; <code>false</code> otherwise
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
	 * Sets the code of this occupation.
	 *
	 * @param code the code of this occupation
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this occupation.
	 *
	 * @param companyId the company ID of this occupation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this occupation.
	 *
	 * @param createDate the create date of this occupation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this occupation is deleted.
	 *
	 * @param deleted the deleted of this occupation
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this occupation.
	 *
	 * @param groupId the group ID of this occupation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this occupation.
	 *
	 * @param modifiedDate the modified date of this occupation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this occupation.
	 *
	 * @param name the name of this occupation
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the occupation ID of this occupation.
	 *
	 * @param occupationId the occupation ID of this occupation
	 */
	@Override
	public void setOccupationId(long occupationId) {
		model.setOccupationId(occupationId);
	}

	/**
	 * Sets the primary key of this occupation.
	 *
	 * @param primaryKey the primary key of this occupation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this occupation.
	 *
	 * @param status the status of this occupation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this occupation.
	 *
	 * @param userId the user ID of this occupation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this occupation.
	 *
	 * @param userName the user name of this occupation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this occupation.
	 *
	 * @param userUuid the user uuid of this occupation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OccupationWrapper wrap(Occupation occupation) {
		return new OccupationWrapper(occupation);
	}

}