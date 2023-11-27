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
 * This class is a wrapper for {@link TimeFrequency}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeFrequency
 * @generated
 */
public class TimeFrequencyWrapper
	extends BaseModelWrapper<TimeFrequency>
	implements ModelWrapper<TimeFrequency>, TimeFrequency {

	public TimeFrequencyWrapper(TimeFrequency timeFrequency) {
		super(timeFrequency);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timeFrequencyId", getTimeFrequencyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timeFrequencyId = (Long)attributes.get("timeFrequencyId");

		if (timeFrequencyId != null) {
			setTimeFrequencyId(timeFrequencyId);
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
	 * Returns the company ID of this time frequency.
	 *
	 * @return the company ID of this time frequency
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this time frequency.
	 *
	 * @return the create date of this time frequency
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this time frequency.
	 *
	 * @return the deleted of this time frequency
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this time frequency.
	 *
	 * @return the group ID of this time frequency
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this time frequency.
	 *
	 * @return the modified date of this time frequency
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this time frequency.
	 *
	 * @return the name of this time frequency
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this time frequency.
	 *
	 * @return the primary key of this time frequency
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this time frequency.
	 *
	 * @return the status of this time frequency
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the time frequency ID of this time frequency.
	 *
	 * @return the time frequency ID of this time frequency
	 */
	@Override
	public long getTimeFrequencyId() {
		return model.getTimeFrequencyId();
	}

	/**
	 * Returns the user ID of this time frequency.
	 *
	 * @return the user ID of this time frequency
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this time frequency.
	 *
	 * @return the user name of this time frequency
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this time frequency.
	 *
	 * @return the user uuid of this time frequency
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this time frequency is deleted.
	 *
	 * @return <code>true</code> if this time frequency is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this time frequency.
	 *
	 * @param companyId the company ID of this time frequency
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this time frequency.
	 *
	 * @param createDate the create date of this time frequency
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this time frequency is deleted.
	 *
	 * @param deleted the deleted of this time frequency
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this time frequency.
	 *
	 * @param groupId the group ID of this time frequency
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this time frequency.
	 *
	 * @param modifiedDate the modified date of this time frequency
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this time frequency.
	 *
	 * @param name the name of this time frequency
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this time frequency.
	 *
	 * @param primaryKey the primary key of this time frequency
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this time frequency.
	 *
	 * @param status the status of this time frequency
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the time frequency ID of this time frequency.
	 *
	 * @param timeFrequencyId the time frequency ID of this time frequency
	 */
	@Override
	public void setTimeFrequencyId(long timeFrequencyId) {
		model.setTimeFrequencyId(timeFrequencyId);
	}

	/**
	 * Sets the user ID of this time frequency.
	 *
	 * @param userId the user ID of this time frequency
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this time frequency.
	 *
	 * @param userName the user name of this time frequency
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this time frequency.
	 *
	 * @param userUuid the user uuid of this time frequency
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TimeFrequencyWrapper wrap(TimeFrequency timeFrequency) {
		return new TimeFrequencyWrapper(timeFrequency);
	}

}