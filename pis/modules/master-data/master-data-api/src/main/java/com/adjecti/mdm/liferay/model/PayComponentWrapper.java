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
 * This class is a wrapper for {@link PayComponent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayComponent
 * @generated
 */
public class PayComponentWrapper
	extends BaseModelWrapper<PayComponent>
	implements ModelWrapper<PayComponent>, PayComponent {

	public PayComponentWrapper(PayComponent payComponent) {
		super(payComponent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payComponentId", getPayComponentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("amount", getAmount());
		attributes.put("amountType", getAmountType());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("dependantId", getDependantId());
		attributes.put("headId", getHeadId());
		attributes.put("structureId", getStructureId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payComponentId = (Long)attributes.get("payComponentId");

		if (payComponentId != null) {
			setPayComponentId(payComponentId);
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

		Float amount = (Float)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String amountType = (String)attributes.get("amountType");

		if (amountType != null) {
			setAmountType(amountType);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long dependantId = (Long)attributes.get("dependantId");

		if (dependantId != null) {
			setDependantId(dependantId);
		}

		Long headId = (Long)attributes.get("headId");

		if (headId != null) {
			setHeadId(headId);
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
	 * Returns the active of this pay component.
	 *
	 * @return the active of this pay component
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the amount of this pay component.
	 *
	 * @return the amount of this pay component
	 */
	@Override
	public float getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the amount type of this pay component.
	 *
	 * @return the amount type of this pay component
	 */
	@Override
	public String getAmountType() {
		return model.getAmountType();
	}

	/**
	 * Returns the company ID of this pay component.
	 *
	 * @return the company ID of this pay component
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pay component.
	 *
	 * @return the create date of this pay component
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this pay component.
	 *
	 * @return the deleted of this pay component
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the dependant ID of this pay component.
	 *
	 * @return the dependant ID of this pay component
	 */
	@Override
	public long getDependantId() {
		return model.getDependantId();
	}

	/**
	 * Returns the from date of this pay component.
	 *
	 * @return the from date of this pay component
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this pay component.
	 *
	 * @return the group ID of this pay component
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the head ID of this pay component.
	 *
	 * @return the head ID of this pay component
	 */
	@Override
	public long getHeadId() {
		return model.getHeadId();
	}

	/**
	 * Returns the modified date of this pay component.
	 *
	 * @return the modified date of this pay component
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pay component ID of this pay component.
	 *
	 * @return the pay component ID of this pay component
	 */
	@Override
	public long getPayComponentId() {
		return model.getPayComponentId();
	}

	/**
	 * Returns the primary key of this pay component.
	 *
	 * @return the primary key of this pay component
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pay component.
	 *
	 * @return the status of this pay component
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the structure ID of this pay component.
	 *
	 * @return the structure ID of this pay component
	 */
	@Override
	public long getStructureId() {
		return model.getStructureId();
	}

	/**
	 * Returns the to date of this pay component.
	 *
	 * @return the to date of this pay component
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this pay component.
	 *
	 * @return the user ID of this pay component
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pay component.
	 *
	 * @return the user name of this pay component
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pay component.
	 *
	 * @return the user uuid of this pay component
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pay component is active.
	 *
	 * @return <code>true</code> if this pay component is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this pay component is deleted.
	 *
	 * @return <code>true</code> if this pay component is deleted; <code>false</code> otherwise
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
	 * Sets whether this pay component is active.
	 *
	 * @param active the active of this pay component
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the amount of this pay component.
	 *
	 * @param amount the amount of this pay component
	 */
	@Override
	public void setAmount(float amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the amount type of this pay component.
	 *
	 * @param amountType the amount type of this pay component
	 */
	@Override
	public void setAmountType(String amountType) {
		model.setAmountType(amountType);
	}

	/**
	 * Sets the company ID of this pay component.
	 *
	 * @param companyId the company ID of this pay component
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pay component.
	 *
	 * @param createDate the create date of this pay component
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this pay component is deleted.
	 *
	 * @param deleted the deleted of this pay component
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the dependant ID of this pay component.
	 *
	 * @param dependantId the dependant ID of this pay component
	 */
	@Override
	public void setDependantId(long dependantId) {
		model.setDependantId(dependantId);
	}

	/**
	 * Sets the from date of this pay component.
	 *
	 * @param fromDate the from date of this pay component
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this pay component.
	 *
	 * @param groupId the group ID of this pay component
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the head ID of this pay component.
	 *
	 * @param headId the head ID of this pay component
	 */
	@Override
	public void setHeadId(long headId) {
		model.setHeadId(headId);
	}

	/**
	 * Sets the modified date of this pay component.
	 *
	 * @param modifiedDate the modified date of this pay component
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pay component ID of this pay component.
	 *
	 * @param payComponentId the pay component ID of this pay component
	 */
	@Override
	public void setPayComponentId(long payComponentId) {
		model.setPayComponentId(payComponentId);
	}

	/**
	 * Sets the primary key of this pay component.
	 *
	 * @param primaryKey the primary key of this pay component
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pay component.
	 *
	 * @param status the status of this pay component
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the structure ID of this pay component.
	 *
	 * @param structureId the structure ID of this pay component
	 */
	@Override
	public void setStructureId(long structureId) {
		model.setStructureId(structureId);
	}

	/**
	 * Sets the to date of this pay component.
	 *
	 * @param toDate the to date of this pay component
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this pay component.
	 *
	 * @param userId the user ID of this pay component
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pay component.
	 *
	 * @param userName the user name of this pay component
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pay component.
	 *
	 * @param userUuid the user uuid of this pay component
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PayComponentWrapper wrap(PayComponent payComponent) {
		return new PayComponentWrapper(payComponent);
	}

}