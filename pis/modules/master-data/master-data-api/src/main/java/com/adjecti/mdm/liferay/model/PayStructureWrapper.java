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
 * This class is a wrapper for {@link PayStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayStructure
 * @generated
 */
public class PayStructureWrapper
	extends BaseModelWrapper<PayStructure>
	implements ModelWrapper<PayStructure>, PayStructure {

	public PayStructureWrapper(PayStructure payStructure) {
		super(payStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payStructureId", getPayStructureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("currency", getCurrency());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("name", getName());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payStructureId = (Long)attributes.get("payStructureId");

		if (payStructureId != null) {
			setPayStructureId(payStructureId);
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

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
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
	 * Returns the active of this pay structure.
	 *
	 * @return the active of this pay structure
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this pay structure.
	 *
	 * @return the company ID of this pay structure
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pay structure.
	 *
	 * @return the create date of this pay structure
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this pay structure.
	 *
	 * @return the currency of this pay structure
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the deleted of this pay structure.
	 *
	 * @return the deleted of this pay structure
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the effective date of this pay structure.
	 *
	 * @return the effective date of this pay structure
	 */
	@Override
	public Date getEffectiveDate() {
		return model.getEffectiveDate();
	}

	/**
	 * Returns the expiry date of this pay structure.
	 *
	 * @return the expiry date of this pay structure
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the group ID of this pay structure.
	 *
	 * @return the group ID of this pay structure
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pay structure.
	 *
	 * @return the modified date of this pay structure
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pay structure.
	 *
	 * @return the name of this pay structure
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pay structure ID of this pay structure.
	 *
	 * @return the pay structure ID of this pay structure
	 */
	@Override
	public long getPayStructureId() {
		return model.getPayStructureId();
	}

	/**
	 * Returns the primary key of this pay structure.
	 *
	 * @return the primary key of this pay structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pay structure.
	 *
	 * @return the status of this pay structure
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this pay structure.
	 *
	 * @return the user ID of this pay structure
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pay structure.
	 *
	 * @return the user name of this pay structure
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pay structure.
	 *
	 * @return the user uuid of this pay structure
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pay structure is active.
	 *
	 * @return <code>true</code> if this pay structure is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this pay structure is deleted.
	 *
	 * @return <code>true</code> if this pay structure is deleted; <code>false</code> otherwise
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
	 * Sets whether this pay structure is active.
	 *
	 * @param active the active of this pay structure
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this pay structure.
	 *
	 * @param companyId the company ID of this pay structure
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pay structure.
	 *
	 * @param createDate the create date of this pay structure
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this pay structure.
	 *
	 * @param currency the currency of this pay structure
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets whether this pay structure is deleted.
	 *
	 * @param deleted the deleted of this pay structure
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the effective date of this pay structure.
	 *
	 * @param effectiveDate the effective date of this pay structure
	 */
	@Override
	public void setEffectiveDate(Date effectiveDate) {
		model.setEffectiveDate(effectiveDate);
	}

	/**
	 * Sets the expiry date of this pay structure.
	 *
	 * @param expiryDate the expiry date of this pay structure
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the group ID of this pay structure.
	 *
	 * @param groupId the group ID of this pay structure
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pay structure.
	 *
	 * @param modifiedDate the modified date of this pay structure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pay structure.
	 *
	 * @param name the name of this pay structure
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pay structure ID of this pay structure.
	 *
	 * @param payStructureId the pay structure ID of this pay structure
	 */
	@Override
	public void setPayStructureId(long payStructureId) {
		model.setPayStructureId(payStructureId);
	}

	/**
	 * Sets the primary key of this pay structure.
	 *
	 * @param primaryKey the primary key of this pay structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pay structure.
	 *
	 * @param status the status of this pay structure
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this pay structure.
	 *
	 * @param userId the user ID of this pay structure
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pay structure.
	 *
	 * @param userName the user name of this pay structure
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pay structure.
	 *
	 * @param userUuid the user uuid of this pay structure
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PayStructureWrapper wrap(PayStructure payStructure) {
		return new PayStructureWrapper(payStructure);
	}

}