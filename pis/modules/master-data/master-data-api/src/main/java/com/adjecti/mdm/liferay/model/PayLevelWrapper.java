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
 * This class is a wrapper for {@link PayLevel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayLevel
 * @generated
 */
public class PayLevelWrapper
	extends BaseModelWrapper<PayLevel>
	implements ModelWrapper<PayLevel>, PayLevel {

	public PayLevelWrapper(PayLevel payLevel) {
		super(payLevel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payLevelId", getPayLevelId());
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
		Long payLevelId = (Long)attributes.get("payLevelId");

		if (payLevelId != null) {
			setPayLevelId(payLevelId);
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
	 * Returns the code of this pay level.
	 *
	 * @return the code of this pay level
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this pay level.
	 *
	 * @return the company ID of this pay level
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pay level.
	 *
	 * @return the create date of this pay level
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this pay level.
	 *
	 * @return the deleted of this pay level
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this pay level.
	 *
	 * @return the group ID of this pay level
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pay level.
	 *
	 * @return the modified date of this pay level
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pay level.
	 *
	 * @return the name of this pay level
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pay level ID of this pay level.
	 *
	 * @return the pay level ID of this pay level
	 */
	@Override
	public long getPayLevelId() {
		return model.getPayLevelId();
	}

	/**
	 * Returns the primary key of this pay level.
	 *
	 * @return the primary key of this pay level
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pay level.
	 *
	 * @return the status of this pay level
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this pay level.
	 *
	 * @return the user ID of this pay level
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pay level.
	 *
	 * @return the user name of this pay level
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pay level.
	 *
	 * @return the user uuid of this pay level
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pay level is deleted.
	 *
	 * @return <code>true</code> if this pay level is deleted; <code>false</code> otherwise
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
	 * Sets the code of this pay level.
	 *
	 * @param code the code of this pay level
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this pay level.
	 *
	 * @param companyId the company ID of this pay level
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pay level.
	 *
	 * @param createDate the create date of this pay level
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this pay level is deleted.
	 *
	 * @param deleted the deleted of this pay level
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this pay level.
	 *
	 * @param groupId the group ID of this pay level
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pay level.
	 *
	 * @param modifiedDate the modified date of this pay level
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pay level.
	 *
	 * @param name the name of this pay level
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pay level ID of this pay level.
	 *
	 * @param payLevelId the pay level ID of this pay level
	 */
	@Override
	public void setPayLevelId(long payLevelId) {
		model.setPayLevelId(payLevelId);
	}

	/**
	 * Sets the primary key of this pay level.
	 *
	 * @param primaryKey the primary key of this pay level
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pay level.
	 *
	 * @param status the status of this pay level
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this pay level.
	 *
	 * @param userId the user ID of this pay level
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pay level.
	 *
	 * @param userName the user name of this pay level
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pay level.
	 *
	 * @param userUuid the user uuid of this pay level
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PayLevelWrapper wrap(PayLevel payLevel) {
		return new PayLevelWrapper(payLevel);
	}

}