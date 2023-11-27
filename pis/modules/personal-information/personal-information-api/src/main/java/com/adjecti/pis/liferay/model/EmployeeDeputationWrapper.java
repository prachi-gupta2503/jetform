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
 * This class is a wrapper for {@link EmployeeDeputation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputation
 * @generated
 */
public class EmployeeDeputationWrapper
	extends BaseModelWrapper<EmployeeDeputation>
	implements EmployeeDeputation, ModelWrapper<EmployeeDeputation> {

	public EmployeeDeputationWrapper(EmployeeDeputation employeeDeputation) {
		super(employeeDeputation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeDeputationId", getEmployeeDeputationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("officeAddress", getOfficeAddress());
		attributes.put("remark", getRemark());
		attributes.put("toDate", getToDate());
		attributes.put("deputationTypeId", getDeputationTypeId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("ministryId", getMinistryId());
		attributes.put("postId", getPostId());
		attributes.put("deputedPostId", getDeputedPostId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeDeputationId = (Long)attributes.get(
			"employeeDeputationId");

		if (employeeDeputationId != null) {
			setEmployeeDeputationId(employeeDeputationId);
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

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		String officeAddress = (String)attributes.get("officeAddress");

		if (officeAddress != null) {
			setOfficeAddress(officeAddress);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long deputationTypeId = (Long)attributes.get("deputationTypeId");

		if (deputationTypeId != null) {
			setDeputationTypeId(deputationTypeId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long ministryId = (Long)attributes.get("ministryId");

		if (ministryId != null) {
			setMinistryId(ministryId);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long deputedPostId = (Long)attributes.get("deputedPostId");

		if (deputedPostId != null) {
			setDeputedPostId(deputedPostId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee deputation.
	 *
	 * @return the active of this employee deputation
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee deputation.
	 *
	 * @return the company ID of this employee deputation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee deputation.
	 *
	 * @return the create date of this employee deputation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the department ID of this employee deputation.
	 *
	 * @return the department ID of this employee deputation
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the deputation type ID of this employee deputation.
	 *
	 * @return the deputation type ID of this employee deputation
	 */
	@Override
	public long getDeputationTypeId() {
		return model.getDeputationTypeId();
	}

	/**
	 * Returns the deputed post ID of this employee deputation.
	 *
	 * @return the deputed post ID of this employee deputation
	 */
	@Override
	public long getDeputedPostId() {
		return model.getDeputedPostId();
	}

	/**
	 * Returns the employee deputation ID of this employee deputation.
	 *
	 * @return the employee deputation ID of this employee deputation
	 */
	@Override
	public long getEmployeeDeputationId() {
		return model.getEmployeeDeputationId();
	}

	/**
	 * Returns the employee ID of this employee deputation.
	 *
	 * @return the employee ID of this employee deputation
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the from date of this employee deputation.
	 *
	 * @return the from date of this employee deputation
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee deputation.
	 *
	 * @return the group ID of this employee deputation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ministry ID of this employee deputation.
	 *
	 * @return the ministry ID of this employee deputation
	 */
	@Override
	public long getMinistryId() {
		return model.getMinistryId();
	}

	/**
	 * Returns the modified date of this employee deputation.
	 *
	 * @return the modified date of this employee deputation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office address of this employee deputation.
	 *
	 * @return the office address of this employee deputation
	 */
	@Override
	public String getOfficeAddress() {
		return model.getOfficeAddress();
	}

	/**
	 * Returns the post ID of this employee deputation.
	 *
	 * @return the post ID of this employee deputation
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this employee deputation.
	 *
	 * @return the primary key of this employee deputation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remark of this employee deputation.
	 *
	 * @return the remark of this employee deputation
	 */
	@Override
	public String getRemark() {
		return model.getRemark();
	}

	/**
	 * Returns the status of this employee deputation.
	 *
	 * @return the status of this employee deputation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this employee deputation.
	 *
	 * @return the to date of this employee deputation
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee deputation.
	 *
	 * @return the user ID of this employee deputation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee deputation.
	 *
	 * @return the user name of this employee deputation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee deputation.
	 *
	 * @return the user uuid of this employee deputation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee deputation is active.
	 *
	 * @return <code>true</code> if this employee deputation is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee deputation is active.
	 *
	 * @param active the active of this employee deputation
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee deputation.
	 *
	 * @param companyId the company ID of this employee deputation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee deputation.
	 *
	 * @param createDate the create date of this employee deputation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the department ID of this employee deputation.
	 *
	 * @param departmentId the department ID of this employee deputation
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the deputation type ID of this employee deputation.
	 *
	 * @param deputationTypeId the deputation type ID of this employee deputation
	 */
	@Override
	public void setDeputationTypeId(long deputationTypeId) {
		model.setDeputationTypeId(deputationTypeId);
	}

	/**
	 * Sets the deputed post ID of this employee deputation.
	 *
	 * @param deputedPostId the deputed post ID of this employee deputation
	 */
	@Override
	public void setDeputedPostId(long deputedPostId) {
		model.setDeputedPostId(deputedPostId);
	}

	/**
	 * Sets the employee deputation ID of this employee deputation.
	 *
	 * @param employeeDeputationId the employee deputation ID of this employee deputation
	 */
	@Override
	public void setEmployeeDeputationId(long employeeDeputationId) {
		model.setEmployeeDeputationId(employeeDeputationId);
	}

	/**
	 * Sets the employee ID of this employee deputation.
	 *
	 * @param employeeId the employee ID of this employee deputation
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the from date of this employee deputation.
	 *
	 * @param fromDate the from date of this employee deputation
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee deputation.
	 *
	 * @param groupId the group ID of this employee deputation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ministry ID of this employee deputation.
	 *
	 * @param ministryId the ministry ID of this employee deputation
	 */
	@Override
	public void setMinistryId(long ministryId) {
		model.setMinistryId(ministryId);
	}

	/**
	 * Sets the modified date of this employee deputation.
	 *
	 * @param modifiedDate the modified date of this employee deputation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office address of this employee deputation.
	 *
	 * @param officeAddress the office address of this employee deputation
	 */
	@Override
	public void setOfficeAddress(String officeAddress) {
		model.setOfficeAddress(officeAddress);
	}

	/**
	 * Sets the post ID of this employee deputation.
	 *
	 * @param postId the post ID of this employee deputation
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this employee deputation.
	 *
	 * @param primaryKey the primary key of this employee deputation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remark of this employee deputation.
	 *
	 * @param remark the remark of this employee deputation
	 */
	@Override
	public void setRemark(String remark) {
		model.setRemark(remark);
	}

	/**
	 * Sets the status of this employee deputation.
	 *
	 * @param status the status of this employee deputation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this employee deputation.
	 *
	 * @param toDate the to date of this employee deputation
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee deputation.
	 *
	 * @param userId the user ID of this employee deputation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee deputation.
	 *
	 * @param userName the user name of this employee deputation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee deputation.
	 *
	 * @param userUuid the user uuid of this employee deputation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeDeputationWrapper wrap(
		EmployeeDeputation employeeDeputation) {

		return new EmployeeDeputationWrapper(employeeDeputation);
	}

}