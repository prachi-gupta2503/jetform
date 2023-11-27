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

package com.adjecti.pis.liferay.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MonthlySalaryComponent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryComponent
 * @generated
 */
public class MonthlySalaryComponentWrapper
	extends BaseModelWrapper<MonthlySalaryComponent>
	implements ModelWrapper<MonthlySalaryComponent>, MonthlySalaryComponent {

	public MonthlySalaryComponentWrapper(
		MonthlySalaryComponent monthlySalaryComponent) {

		super(monthlySalaryComponent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"monthlySalaryComponentId", getMonthlySalaryComponentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("amount", getAmount());
		attributes.put("componentId", getComponentId());
		attributes.put("salaryId", getSalaryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long monthlySalaryComponentId = (Long)attributes.get(
			"monthlySalaryComponentId");

		if (monthlySalaryComponentId != null) {
			setMonthlySalaryComponentId(monthlySalaryComponentId);
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

		Float amount = (Float)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long componentId = (Long)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		Long salaryId = (Long)attributes.get("salaryId");

		if (salaryId != null) {
			setSalaryId(salaryId);
		}
	}

	/**
	 * Returns the amount of this monthly salary component.
	 *
	 * @return the amount of this monthly salary component
	 */
	@Override
	public float getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this monthly salary component.
	 *
	 * @return the company ID of this monthly salary component
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the component ID of this monthly salary component.
	 *
	 * @return the component ID of this monthly salary component
	 */
	@Override
	public long getComponentId() {
		return model.getComponentId();
	}

	/**
	 * Returns the create date of this monthly salary component.
	 *
	 * @return the create date of this monthly salary component
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this monthly salary component.
	 *
	 * @return the group ID of this monthly salary component
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this monthly salary component.
	 *
	 * @return the modified date of this monthly salary component
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthly salary component ID of this monthly salary component.
	 *
	 * @return the monthly salary component ID of this monthly salary component
	 */
	@Override
	public long getMonthlySalaryComponentId() {
		return model.getMonthlySalaryComponentId();
	}

	/**
	 * Returns the primary key of this monthly salary component.
	 *
	 * @return the primary key of this monthly salary component
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the salary ID of this monthly salary component.
	 *
	 * @return the salary ID of this monthly salary component
	 */
	@Override
	public long getSalaryId() {
		return model.getSalaryId();
	}

	/**
	 * Returns the user ID of this monthly salary component.
	 *
	 * @return the user ID of this monthly salary component
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this monthly salary component.
	 *
	 * @return the user name of this monthly salary component
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this monthly salary component.
	 *
	 * @return the user uuid of this monthly salary component
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amount of this monthly salary component.
	 *
	 * @param amount the amount of this monthly salary component
	 */
	@Override
	public void setAmount(float amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this monthly salary component.
	 *
	 * @param companyId the company ID of this monthly salary component
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the component ID of this monthly salary component.
	 *
	 * @param componentId the component ID of this monthly salary component
	 */
	@Override
	public void setComponentId(long componentId) {
		model.setComponentId(componentId);
	}

	/**
	 * Sets the create date of this monthly salary component.
	 *
	 * @param createDate the create date of this monthly salary component
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this monthly salary component.
	 *
	 * @param groupId the group ID of this monthly salary component
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this monthly salary component.
	 *
	 * @param modifiedDate the modified date of this monthly salary component
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthly salary component ID of this monthly salary component.
	 *
	 * @param monthlySalaryComponentId the monthly salary component ID of this monthly salary component
	 */
	@Override
	public void setMonthlySalaryComponentId(long monthlySalaryComponentId) {
		model.setMonthlySalaryComponentId(monthlySalaryComponentId);
	}

	/**
	 * Sets the primary key of this monthly salary component.
	 *
	 * @param primaryKey the primary key of this monthly salary component
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the salary ID of this monthly salary component.
	 *
	 * @param salaryId the salary ID of this monthly salary component
	 */
	@Override
	public void setSalaryId(long salaryId) {
		model.setSalaryId(salaryId);
	}

	/**
	 * Sets the user ID of this monthly salary component.
	 *
	 * @param userId the user ID of this monthly salary component
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this monthly salary component.
	 *
	 * @param userName the user name of this monthly salary component
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this monthly salary component.
	 *
	 * @param userUuid the user uuid of this monthly salary component
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MonthlySalaryComponentWrapper wrap(
		MonthlySalaryComponent monthlySalaryComponent) {

		return new MonthlySalaryComponentWrapper(monthlySalaryComponent);
	}

}