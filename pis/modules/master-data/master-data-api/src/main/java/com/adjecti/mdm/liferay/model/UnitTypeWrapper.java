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
 * This class is a wrapper for {@link UnitType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UnitType
 * @generated
 */
public class UnitTypeWrapper
	extends BaseModelWrapper<UnitType>
	implements ModelWrapper<UnitType>, UnitType {

	public UnitTypeWrapper(UnitType unitType) {
		super(unitType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("unitTypeId", getUnitTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("code", getCode());
		attributes.put("shortDiscription", getShortDiscription());
		attributes.put("longDiscription", getLongDiscription());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long unitTypeId = (Long)attributes.get("unitTypeId");

		if (unitTypeId != null) {
			setUnitTypeId(unitTypeId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String shortDiscription = (String)attributes.get("shortDiscription");

		if (shortDiscription != null) {
			setShortDiscription(shortDiscription);
		}

		String longDiscription = (String)attributes.get("longDiscription");

		if (longDiscription != null) {
			setLongDiscription(longDiscription);
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
	 * Returns the code of this unit type.
	 *
	 * @return the code of this unit type
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this unit type.
	 *
	 * @return the company ID of this unit type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this unit type.
	 *
	 * @return the create date of this unit type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this unit type.
	 *
	 * @return the deleted of this unit type
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this unit type.
	 *
	 * @return the description of this unit type
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this unit type.
	 *
	 * @return the group ID of this unit type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the long discription of this unit type.
	 *
	 * @return the long discription of this unit type
	 */
	@Override
	public String getLongDiscription() {
		return model.getLongDiscription();
	}

	/**
	 * Returns the modified date of this unit type.
	 *
	 * @return the modified date of this unit type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this unit type.
	 *
	 * @return the primary key of this unit type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the short discription of this unit type.
	 *
	 * @return the short discription of this unit type
	 */
	@Override
	public String getShortDiscription() {
		return model.getShortDiscription();
	}

	/**
	 * Returns the status of this unit type.
	 *
	 * @return the status of this unit type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the unit type ID of this unit type.
	 *
	 * @return the unit type ID of this unit type
	 */
	@Override
	public long getUnitTypeId() {
		return model.getUnitTypeId();
	}

	/**
	 * Returns the user ID of this unit type.
	 *
	 * @return the user ID of this unit type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this unit type.
	 *
	 * @return the user name of this unit type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this unit type.
	 *
	 * @return the user uuid of this unit type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this unit type is deleted.
	 *
	 * @return <code>true</code> if this unit type is deleted; <code>false</code> otherwise
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
	 * Sets the code of this unit type.
	 *
	 * @param code the code of this unit type
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this unit type.
	 *
	 * @param companyId the company ID of this unit type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this unit type.
	 *
	 * @param createDate the create date of this unit type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this unit type is deleted.
	 *
	 * @param deleted the deleted of this unit type
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this unit type.
	 *
	 * @param description the description of this unit type
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this unit type.
	 *
	 * @param groupId the group ID of this unit type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the long discription of this unit type.
	 *
	 * @param longDiscription the long discription of this unit type
	 */
	@Override
	public void setLongDiscription(String longDiscription) {
		model.setLongDiscription(longDiscription);
	}

	/**
	 * Sets the modified date of this unit type.
	 *
	 * @param modifiedDate the modified date of this unit type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this unit type.
	 *
	 * @param primaryKey the primary key of this unit type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the short discription of this unit type.
	 *
	 * @param shortDiscription the short discription of this unit type
	 */
	@Override
	public void setShortDiscription(String shortDiscription) {
		model.setShortDiscription(shortDiscription);
	}

	/**
	 * Sets the status of this unit type.
	 *
	 * @param status the status of this unit type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the unit type ID of this unit type.
	 *
	 * @param unitTypeId the unit type ID of this unit type
	 */
	@Override
	public void setUnitTypeId(long unitTypeId) {
		model.setUnitTypeId(unitTypeId);
	}

	/**
	 * Sets the user ID of this unit type.
	 *
	 * @param userId the user ID of this unit type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this unit type.
	 *
	 * @param userName the user name of this unit type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this unit type.
	 *
	 * @param userUuid the user uuid of this unit type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UnitTypeWrapper wrap(UnitType unitType) {
		return new UnitTypeWrapper(unitType);
	}

}