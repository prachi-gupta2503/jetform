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
 * This class is a wrapper for {@link Qualification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Qualification
 * @generated
 */
public class QualificationWrapper
	extends BaseModelWrapper<Qualification>
	implements ModelWrapper<Qualification>, Qualification {

	public QualificationWrapper(Qualification qualification) {
		super(qualification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("qualificationId", getQualificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("name", getName());
		attributes.put("shortName", getShortName());
		attributes.put("fullName", getFullName());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long qualificationId = (Long)attributes.get("qualificationId");

		if (qualificationId != null) {
			setQualificationId(qualificationId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
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
	 * Returns the code of this qualification.
	 *
	 * @return the code of this qualification
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this qualification.
	 *
	 * @return the company ID of this qualification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this qualification.
	 *
	 * @return the create date of this qualification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this qualification.
	 *
	 * @return the deleted of this qualification
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this qualification.
	 *
	 * @return the description of this qualification
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the full name of this qualification.
	 *
	 * @return the full name of this qualification
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this qualification.
	 *
	 * @return the group ID of this qualification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this qualification.
	 *
	 * @return the modified date of this qualification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this qualification.
	 *
	 * @return the name of this qualification
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this qualification.
	 *
	 * @return the primary key of this qualification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the qualification ID of this qualification.
	 *
	 * @return the qualification ID of this qualification
	 */
	@Override
	public long getQualificationId() {
		return model.getQualificationId();
	}

	/**
	 * Returns the short name of this qualification.
	 *
	 * @return the short name of this qualification
	 */
	@Override
	public String getShortName() {
		return model.getShortName();
	}

	/**
	 * Returns the status of this qualification.
	 *
	 * @return the status of this qualification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this qualification.
	 *
	 * @return the user ID of this qualification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this qualification.
	 *
	 * @return the user name of this qualification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this qualification.
	 *
	 * @return the user uuid of this qualification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this qualification is deleted.
	 *
	 * @return <code>true</code> if this qualification is deleted; <code>false</code> otherwise
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
	 * Sets the code of this qualification.
	 *
	 * @param code the code of this qualification
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this qualification.
	 *
	 * @param companyId the company ID of this qualification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this qualification.
	 *
	 * @param createDate the create date of this qualification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this qualification is deleted.
	 *
	 * @param deleted the deleted of this qualification
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this qualification.
	 *
	 * @param description the description of this qualification
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the full name of this qualification.
	 *
	 * @param fullName the full name of this qualification
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this qualification.
	 *
	 * @param groupId the group ID of this qualification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this qualification.
	 *
	 * @param modifiedDate the modified date of this qualification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this qualification.
	 *
	 * @param name the name of this qualification
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this qualification.
	 *
	 * @param primaryKey the primary key of this qualification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qualification ID of this qualification.
	 *
	 * @param qualificationId the qualification ID of this qualification
	 */
	@Override
	public void setQualificationId(long qualificationId) {
		model.setQualificationId(qualificationId);
	}

	/**
	 * Sets the short name of this qualification.
	 *
	 * @param shortName the short name of this qualification
	 */
	@Override
	public void setShortName(String shortName) {
		model.setShortName(shortName);
	}

	/**
	 * Sets the status of this qualification.
	 *
	 * @param status the status of this qualification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this qualification.
	 *
	 * @param userId the user ID of this qualification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this qualification.
	 *
	 * @param userName the user name of this qualification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this qualification.
	 *
	 * @param userUuid the user uuid of this qualification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected QualificationWrapper wrap(Qualification qualification) {
		return new QualificationWrapper(qualification);
	}

}