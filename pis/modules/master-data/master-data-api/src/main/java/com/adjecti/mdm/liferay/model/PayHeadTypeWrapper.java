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
 * This class is a wrapper for {@link PayHeadType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadType
 * @generated
 */
public class PayHeadTypeWrapper
	extends BaseModelWrapper<PayHeadType>
	implements ModelWrapper<PayHeadType>, PayHeadType {

	public PayHeadTypeWrapper(PayHeadType payHeadType) {
		super(payHeadType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payHeadTypeId", getPayHeadTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("code", getCode());
		attributes.put("deduction", isDeduction());
		attributes.put("deductionType", getDeductionType());
		attributes.put("fromDate", getFromDate());
		attributes.put("name", getName());
		attributes.put("toDate", getToDate());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payHeadTypeId = (Long)attributes.get("payHeadTypeId");

		if (payHeadTypeId != null) {
			setPayHeadTypeId(payHeadTypeId);
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

		Boolean deduction = (Boolean)attributes.get("deduction");

		if (deduction != null) {
			setDeduction(deduction);
		}

		Integer deductionType = (Integer)attributes.get("deductionType");

		if (deductionType != null) {
			setDeductionType(deductionType);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
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
	 * Returns the active of this pay head type.
	 *
	 * @return the active of this pay head type
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this pay head type.
	 *
	 * @return the code of this pay head type
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this pay head type.
	 *
	 * @return the company ID of this pay head type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pay head type.
	 *
	 * @return the create date of this pay head type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deduction of this pay head type.
	 *
	 * @return the deduction of this pay head type
	 */
	@Override
	public boolean getDeduction() {
		return model.getDeduction();
	}

	/**
	 * Returns the deduction type of this pay head type.
	 *
	 * @return the deduction type of this pay head type
	 */
	@Override
	public int getDeductionType() {
		return model.getDeductionType();
	}

	/**
	 * Returns the deleted of this pay head type.
	 *
	 * @return the deleted of this pay head type
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the from date of this pay head type.
	 *
	 * @return the from date of this pay head type
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this pay head type.
	 *
	 * @return the group ID of this pay head type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pay head type.
	 *
	 * @return the modified date of this pay head type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pay head type.
	 *
	 * @return the name of this pay head type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pay head type ID of this pay head type.
	 *
	 * @return the pay head type ID of this pay head type
	 */
	@Override
	public long getPayHeadTypeId() {
		return model.getPayHeadTypeId();
	}

	/**
	 * Returns the primary key of this pay head type.
	 *
	 * @return the primary key of this pay head type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pay head type.
	 *
	 * @return the status of this pay head type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this pay head type.
	 *
	 * @return the to date of this pay head type
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this pay head type.
	 *
	 * @return the user ID of this pay head type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pay head type.
	 *
	 * @return the user name of this pay head type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pay head type.
	 *
	 * @return the user uuid of this pay head type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pay head type is active.
	 *
	 * @return <code>true</code> if this pay head type is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this pay head type is deduction.
	 *
	 * @return <code>true</code> if this pay head type is deduction; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeduction() {
		return model.isDeduction();
	}

	/**
	 * Returns <code>true</code> if this pay head type is deleted.
	 *
	 * @return <code>true</code> if this pay head type is deleted; <code>false</code> otherwise
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
	 * Sets whether this pay head type is active.
	 *
	 * @param active the active of this pay head type
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this pay head type.
	 *
	 * @param code the code of this pay head type
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this pay head type.
	 *
	 * @param companyId the company ID of this pay head type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pay head type.
	 *
	 * @param createDate the create date of this pay head type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this pay head type is deduction.
	 *
	 * @param deduction the deduction of this pay head type
	 */
	@Override
	public void setDeduction(boolean deduction) {
		model.setDeduction(deduction);
	}

	/**
	 * Sets the deduction type of this pay head type.
	 *
	 * @param deductionType the deduction type of this pay head type
	 */
	@Override
	public void setDeductionType(int deductionType) {
		model.setDeductionType(deductionType);
	}

	/**
	 * Sets whether this pay head type is deleted.
	 *
	 * @param deleted the deleted of this pay head type
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the from date of this pay head type.
	 *
	 * @param fromDate the from date of this pay head type
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this pay head type.
	 *
	 * @param groupId the group ID of this pay head type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pay head type.
	 *
	 * @param modifiedDate the modified date of this pay head type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pay head type.
	 *
	 * @param name the name of this pay head type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pay head type ID of this pay head type.
	 *
	 * @param payHeadTypeId the pay head type ID of this pay head type
	 */
	@Override
	public void setPayHeadTypeId(long payHeadTypeId) {
		model.setPayHeadTypeId(payHeadTypeId);
	}

	/**
	 * Sets the primary key of this pay head type.
	 *
	 * @param primaryKey the primary key of this pay head type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pay head type.
	 *
	 * @param status the status of this pay head type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this pay head type.
	 *
	 * @param toDate the to date of this pay head type
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this pay head type.
	 *
	 * @param userId the user ID of this pay head type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pay head type.
	 *
	 * @param userName the user name of this pay head type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pay head type.
	 *
	 * @param userUuid the user uuid of this pay head type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PayHeadTypeWrapper wrap(PayHeadType payHeadType) {
		return new PayHeadTypeWrapper(payHeadType);
	}

}