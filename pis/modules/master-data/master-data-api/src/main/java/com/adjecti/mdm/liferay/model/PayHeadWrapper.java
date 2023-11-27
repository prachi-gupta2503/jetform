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
 * This class is a wrapper for {@link PayHead}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHead
 * @generated
 */
public class PayHeadWrapper
	extends BaseModelWrapper<PayHead>
	implements ModelWrapper<PayHead>, PayHead {

	public PayHeadWrapper(PayHead payHead) {
		super(payHead);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payHeadId", getPayHeadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("code", getCode());
		attributes.put("disbursePeriod", getDisbursePeriod());
		attributes.put("fromDate", getFromDate());
		attributes.put("name", getName());
		attributes.put("nonTaxable", isNonTaxable());
		attributes.put("toDate", getToDate());
		attributes.put("headTypeId", getHeadTypeId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payHeadId = (Long)attributes.get("payHeadId");

		if (payHeadId != null) {
			setPayHeadId(payHeadId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer disbursePeriod = (Integer)attributes.get("disbursePeriod");

		if (disbursePeriod != null) {
			setDisbursePeriod(disbursePeriod);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean nonTaxable = (Boolean)attributes.get("nonTaxable");

		if (nonTaxable != null) {
			setNonTaxable(nonTaxable);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long headTypeId = (Long)attributes.get("headTypeId");

		if (headTypeId != null) {
			setHeadTypeId(headTypeId);
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
	 * Returns the active of this pay head.
	 *
	 * @return the active of this pay head
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this pay head.
	 *
	 * @return the code of this pay head
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this pay head.
	 *
	 * @return the company ID of this pay head
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pay head.
	 *
	 * @return the create date of this pay head
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this pay head.
	 *
	 * @return the deleted of this pay head
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the disburse period of this pay head.
	 *
	 * @return the disburse period of this pay head
	 */
	@Override
	public int getDisbursePeriod() {
		return model.getDisbursePeriod();
	}

	/**
	 * Returns the from date of this pay head.
	 *
	 * @return the from date of this pay head
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this pay head.
	 *
	 * @return the group ID of this pay head
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the head type ID of this pay head.
	 *
	 * @return the head type ID of this pay head
	 */
	@Override
	public long getHeadTypeId() {
		return model.getHeadTypeId();
	}

	/**
	 * Returns the modified date of this pay head.
	 *
	 * @return the modified date of this pay head
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pay head.
	 *
	 * @return the name of this pay head
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the non taxable of this pay head.
	 *
	 * @return the non taxable of this pay head
	 */
	@Override
	public boolean getNonTaxable() {
		return model.getNonTaxable();
	}

	/**
	 * Returns the pay head ID of this pay head.
	 *
	 * @return the pay head ID of this pay head
	 */
	@Override
	public long getPayHeadId() {
		return model.getPayHeadId();
	}

	/**
	 * Returns the primary key of this pay head.
	 *
	 * @return the primary key of this pay head
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pay head.
	 *
	 * @return the status of this pay head
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this pay head.
	 *
	 * @return the to date of this pay head
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this pay head.
	 *
	 * @return the user ID of this pay head
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pay head.
	 *
	 * @return the user name of this pay head
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pay head.
	 *
	 * @return the user uuid of this pay head
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pay head is active.
	 *
	 * @return <code>true</code> if this pay head is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this pay head is deleted.
	 *
	 * @return <code>true</code> if this pay head is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	/**
	 * Returns <code>true</code> if this pay head is non taxable.
	 *
	 * @return <code>true</code> if this pay head is non taxable; <code>false</code> otherwise
	 */
	@Override
	public boolean isNonTaxable() {
		return model.isNonTaxable();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this pay head is active.
	 *
	 * @param active the active of this pay head
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this pay head.
	 *
	 * @param code the code of this pay head
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this pay head.
	 *
	 * @param companyId the company ID of this pay head
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pay head.
	 *
	 * @param createDate the create date of this pay head
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this pay head is deleted.
	 *
	 * @param deleted the deleted of this pay head
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the disburse period of this pay head.
	 *
	 * @param disbursePeriod the disburse period of this pay head
	 */
	@Override
	public void setDisbursePeriod(int disbursePeriod) {
		model.setDisbursePeriod(disbursePeriod);
	}

	/**
	 * Sets the from date of this pay head.
	 *
	 * @param fromDate the from date of this pay head
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this pay head.
	 *
	 * @param groupId the group ID of this pay head
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the head type ID of this pay head.
	 *
	 * @param headTypeId the head type ID of this pay head
	 */
	@Override
	public void setHeadTypeId(long headTypeId) {
		model.setHeadTypeId(headTypeId);
	}

	/**
	 * Sets the modified date of this pay head.
	 *
	 * @param modifiedDate the modified date of this pay head
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pay head.
	 *
	 * @param name the name of this pay head
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets whether this pay head is non taxable.
	 *
	 * @param nonTaxable the non taxable of this pay head
	 */
	@Override
	public void setNonTaxable(boolean nonTaxable) {
		model.setNonTaxable(nonTaxable);
	}

	/**
	 * Sets the pay head ID of this pay head.
	 *
	 * @param payHeadId the pay head ID of this pay head
	 */
	@Override
	public void setPayHeadId(long payHeadId) {
		model.setPayHeadId(payHeadId);
	}

	/**
	 * Sets the primary key of this pay head.
	 *
	 * @param primaryKey the primary key of this pay head
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pay head.
	 *
	 * @param status the status of this pay head
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this pay head.
	 *
	 * @param toDate the to date of this pay head
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this pay head.
	 *
	 * @param userId the user ID of this pay head
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pay head.
	 *
	 * @param userName the user name of this pay head
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pay head.
	 *
	 * @param userUuid the user uuid of this pay head
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PayHeadWrapper wrap(PayHead payHead) {
		return new PayHeadWrapper(payHead);
	}

}