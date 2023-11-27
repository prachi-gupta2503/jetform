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
 * This class is a wrapper for {@link EmployeeDelegation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDelegation
 * @generated
 */
public class EmployeeDelegationWrapper
	extends BaseModelWrapper<EmployeeDelegation>
	implements EmployeeDelegation, ModelWrapper<EmployeeDelegation> {

	public EmployeeDelegationWrapper(EmployeeDelegation employeeDelegation) {
		super(employeeDelegation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeDelegationId", getEmployeeDelegationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("delegationType", getDelegationType());
		attributes.put("delegatedEmployeeId", getDelegatedEmployeeId());
		attributes.put("employeeId", getEmployeeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeDelegationId = (Long)attributes.get(
			"employeeDelegationId");

		if (employeeDelegationId != null) {
			setEmployeeDelegationId(employeeDelegationId);
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

		Long delegationType = (Long)attributes.get("delegationType");

		if (delegationType != null) {
			setDelegationType(delegationType);
		}

		Long delegatedEmployeeId = (Long)attributes.get("delegatedEmployeeId");

		if (delegatedEmployeeId != null) {
			setDelegatedEmployeeId(delegatedEmployeeId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	/**
	 * Returns the company ID of this employee delegation.
	 *
	 * @return the company ID of this employee delegation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee delegation.
	 *
	 * @return the create date of this employee delegation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delegated employee ID of this employee delegation.
	 *
	 * @return the delegated employee ID of this employee delegation
	 */
	@Override
	public long getDelegatedEmployeeId() {
		return model.getDelegatedEmployeeId();
	}

	/**
	 * Returns the delegation type of this employee delegation.
	 *
	 * @return the delegation type of this employee delegation
	 */
	@Override
	public long getDelegationType() {
		return model.getDelegationType();
	}

	/**
	 * Returns the employee delegation ID of this employee delegation.
	 *
	 * @return the employee delegation ID of this employee delegation
	 */
	@Override
	public long getEmployeeDelegationId() {
		return model.getEmployeeDelegationId();
	}

	/**
	 * Returns the employee ID of this employee delegation.
	 *
	 * @return the employee ID of this employee delegation
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee delegation.
	 *
	 * @return the group ID of this employee delegation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee delegation.
	 *
	 * @return the modified date of this employee delegation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee delegation.
	 *
	 * @return the primary key of this employee delegation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee delegation.
	 *
	 * @return the user ID of this employee delegation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee delegation.
	 *
	 * @return the user name of this employee delegation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee delegation.
	 *
	 * @return the user uuid of this employee delegation
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
	 * Sets the company ID of this employee delegation.
	 *
	 * @param companyId the company ID of this employee delegation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee delegation.
	 *
	 * @param createDate the create date of this employee delegation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delegated employee ID of this employee delegation.
	 *
	 * @param delegatedEmployeeId the delegated employee ID of this employee delegation
	 */
	@Override
	public void setDelegatedEmployeeId(long delegatedEmployeeId) {
		model.setDelegatedEmployeeId(delegatedEmployeeId);
	}

	/**
	 * Sets the delegation type of this employee delegation.
	 *
	 * @param delegationType the delegation type of this employee delegation
	 */
	@Override
	public void setDelegationType(long delegationType) {
		model.setDelegationType(delegationType);
	}

	/**
	 * Sets the employee delegation ID of this employee delegation.
	 *
	 * @param employeeDelegationId the employee delegation ID of this employee delegation
	 */
	@Override
	public void setEmployeeDelegationId(long employeeDelegationId) {
		model.setEmployeeDelegationId(employeeDelegationId);
	}

	/**
	 * Sets the employee ID of this employee delegation.
	 *
	 * @param employeeId the employee ID of this employee delegation
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee delegation.
	 *
	 * @param groupId the group ID of this employee delegation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee delegation.
	 *
	 * @param modifiedDate the modified date of this employee delegation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee delegation.
	 *
	 * @param primaryKey the primary key of this employee delegation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee delegation.
	 *
	 * @param userId the user ID of this employee delegation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee delegation.
	 *
	 * @param userName the user name of this employee delegation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee delegation.
	 *
	 * @param userUuid the user uuid of this employee delegation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeDelegationWrapper wrap(
		EmployeeDelegation employeeDelegation) {

		return new EmployeeDelegationWrapper(employeeDelegation);
	}

}