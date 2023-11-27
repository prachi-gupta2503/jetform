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
 * This class is a wrapper for {@link EmployeeReporting}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeReporting
 * @generated
 */
public class EmployeeReportingWrapper
	extends BaseModelWrapper<EmployeeReporting>
	implements EmployeeReporting, ModelWrapper<EmployeeReporting> {

	public EmployeeReportingWrapper(EmployeeReporting employeeReporting) {
		super(employeeReporting);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeReportingId", getEmployeeReportingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("reportingToId", getReportingToId());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeReportingId = (Long)attributes.get("employeeReportingId");

		if (employeeReportingId != null) {
			setEmployeeReportingId(employeeReportingId);
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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long reportingToId = (Long)attributes.get("reportingToId");

		if (reportingToId != null) {
			setReportingToId(reportingToId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee reporting.
	 *
	 * @return the active of this employee reporting
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee reporting.
	 *
	 * @return the company ID of this employee reporting
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee reporting.
	 *
	 * @return the create date of this employee reporting
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee reporting.
	 *
	 * @return the employee ID of this employee reporting
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee reporting ID of this employee reporting.
	 *
	 * @return the employee reporting ID of this employee reporting
	 */
	@Override
	public long getEmployeeReportingId() {
		return model.getEmployeeReportingId();
	}

	/**
	 * Returns the from date of this employee reporting.
	 *
	 * @return the from date of this employee reporting
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee reporting.
	 *
	 * @return the group ID of this employee reporting
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee reporting.
	 *
	 * @return the modified date of this employee reporting
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee reporting.
	 *
	 * @return the primary key of this employee reporting
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reporting to ID of this employee reporting.
	 *
	 * @return the reporting to ID of this employee reporting
	 */
	@Override
	public long getReportingToId() {
		return model.getReportingToId();
	}

	/**
	 * Returns the status of this employee reporting.
	 *
	 * @return the status of this employee reporting
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this employee reporting.
	 *
	 * @return the to date of this employee reporting
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee reporting.
	 *
	 * @return the user ID of this employee reporting
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee reporting.
	 *
	 * @return the user name of this employee reporting
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee reporting.
	 *
	 * @return the user uuid of this employee reporting
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee reporting is active.
	 *
	 * @return <code>true</code> if this employee reporting is active; <code>false</code> otherwise
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
	 * Sets whether this employee reporting is active.
	 *
	 * @param active the active of this employee reporting
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee reporting.
	 *
	 * @param companyId the company ID of this employee reporting
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee reporting.
	 *
	 * @param createDate the create date of this employee reporting
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee reporting.
	 *
	 * @param employeeId the employee ID of this employee reporting
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee reporting ID of this employee reporting.
	 *
	 * @param employeeReportingId the employee reporting ID of this employee reporting
	 */
	@Override
	public void setEmployeeReportingId(long employeeReportingId) {
		model.setEmployeeReportingId(employeeReportingId);
	}

	/**
	 * Sets the from date of this employee reporting.
	 *
	 * @param fromDate the from date of this employee reporting
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee reporting.
	 *
	 * @param groupId the group ID of this employee reporting
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee reporting.
	 *
	 * @param modifiedDate the modified date of this employee reporting
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee reporting.
	 *
	 * @param primaryKey the primary key of this employee reporting
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reporting to ID of this employee reporting.
	 *
	 * @param reportingToId the reporting to ID of this employee reporting
	 */
	@Override
	public void setReportingToId(long reportingToId) {
		model.setReportingToId(reportingToId);
	}

	/**
	 * Sets the status of this employee reporting.
	 *
	 * @param status the status of this employee reporting
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this employee reporting.
	 *
	 * @param toDate the to date of this employee reporting
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee reporting.
	 *
	 * @param userId the user ID of this employee reporting
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee reporting.
	 *
	 * @param userName the user name of this employee reporting
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee reporting.
	 *
	 * @param userUuid the user uuid of this employee reporting
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeReportingWrapper wrap(
		EmployeeReporting employeeReporting) {

		return new EmployeeReportingWrapper(employeeReporting);
	}

}