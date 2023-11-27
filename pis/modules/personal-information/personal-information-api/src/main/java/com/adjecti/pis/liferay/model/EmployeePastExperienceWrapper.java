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
 * This class is a wrapper for {@link EmployeePastExperience}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperience
 * @generated
 */
public class EmployeePastExperienceWrapper
	extends BaseModelWrapper<EmployeePastExperience>
	implements EmployeePastExperience, ModelWrapper<EmployeePastExperience> {

	public EmployeePastExperienceWrapper(
		EmployeePastExperience employeePastExperience) {

		super(employeePastExperience);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"employeePastExperienceId", getEmployeePastExperienceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("organization", getOrganization());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("experienceLetterId", getExperienceLetterId());
		attributes.put("workAreaId", getWorkAreaId());
		attributes.put("designation", getDesignation());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("exServiceMan", isExServiceMan());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeePastExperienceId = (Long)attributes.get(
			"employeePastExperienceId");

		if (employeePastExperienceId != null) {
			setEmployeePastExperienceId(employeePastExperienceId);
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

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long experienceLetterId = (Long)attributes.get("experienceLetterId");

		if (experienceLetterId != null) {
			setExperienceLetterId(experienceLetterId);
		}

		Long workAreaId = (Long)attributes.get("workAreaId");

		if (workAreaId != null) {
			setWorkAreaId(workAreaId);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Boolean exServiceMan = (Boolean)attributes.get("exServiceMan");

		if (exServiceMan != null) {
			setExServiceMan(exServiceMan);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee past experience.
	 *
	 * @return the active of this employee past experience
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee past experience.
	 *
	 * @return the company ID of this employee past experience
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee past experience.
	 *
	 * @return the create date of this employee past experience
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation of this employee past experience.
	 *
	 * @return the designation of this employee past experience
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the employee ID of this employee past experience.
	 *
	 * @return the employee ID of this employee past experience
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee past experience ID of this employee past experience.
	 *
	 * @return the employee past experience ID of this employee past experience
	 */
	@Override
	public long getEmployeePastExperienceId() {
		return model.getEmployeePastExperienceId();
	}

	/**
	 * Returns the experience letter ID of this employee past experience.
	 *
	 * @return the experience letter ID of this employee past experience
	 */
	@Override
	public long getExperienceLetterId() {
		return model.getExperienceLetterId();
	}

	/**
	 * Returns the ex service man of this employee past experience.
	 *
	 * @return the ex service man of this employee past experience
	 */
	@Override
	public boolean getExServiceMan() {
		return model.getExServiceMan();
	}

	/**
	 * Returns the from date of this employee past experience.
	 *
	 * @return the from date of this employee past experience
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee past experience.
	 *
	 * @return the group ID of this employee past experience
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining process ID of this employee past experience.
	 *
	 * @return the joining process ID of this employee past experience
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the modified date of this employee past experience.
	 *
	 * @return the modified date of this employee past experience
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization of this employee past experience.
	 *
	 * @return the organization of this employee past experience
	 */
	@Override
	public String getOrganization() {
		return model.getOrganization();
	}

	/**
	 * Returns the primary key of this employee past experience.
	 *
	 * @return the primary key of this employee past experience
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee past experience.
	 *
	 * @return the status of this employee past experience
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this employee past experience.
	 *
	 * @return the to date of this employee past experience
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee past experience.
	 *
	 * @return the user ID of this employee past experience
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee past experience.
	 *
	 * @return the user name of this employee past experience
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee past experience.
	 *
	 * @return the user uuid of this employee past experience
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the work area ID of this employee past experience.
	 *
	 * @return the work area ID of this employee past experience
	 */
	@Override
	public long getWorkAreaId() {
		return model.getWorkAreaId();
	}

	/**
	 * Returns <code>true</code> if this employee past experience is active.
	 *
	 * @return <code>true</code> if this employee past experience is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this employee past experience is ex service man.
	 *
	 * @return <code>true</code> if this employee past experience is ex service man; <code>false</code> otherwise
	 */
	@Override
	public boolean isExServiceMan() {
		return model.isExServiceMan();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee past experience is active.
	 *
	 * @param active the active of this employee past experience
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee past experience.
	 *
	 * @param companyId the company ID of this employee past experience
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee past experience.
	 *
	 * @param createDate the create date of this employee past experience
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation of this employee past experience.
	 *
	 * @param designation the designation of this employee past experience
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the employee ID of this employee past experience.
	 *
	 * @param employeeId the employee ID of this employee past experience
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee past experience ID of this employee past experience.
	 *
	 * @param employeePastExperienceId the employee past experience ID of this employee past experience
	 */
	@Override
	public void setEmployeePastExperienceId(long employeePastExperienceId) {
		model.setEmployeePastExperienceId(employeePastExperienceId);
	}

	/**
	 * Sets the experience letter ID of this employee past experience.
	 *
	 * @param experienceLetterId the experience letter ID of this employee past experience
	 */
	@Override
	public void setExperienceLetterId(long experienceLetterId) {
		model.setExperienceLetterId(experienceLetterId);
	}

	/**
	 * Sets whether this employee past experience is ex service man.
	 *
	 * @param exServiceMan the ex service man of this employee past experience
	 */
	@Override
	public void setExServiceMan(boolean exServiceMan) {
		model.setExServiceMan(exServiceMan);
	}

	/**
	 * Sets the from date of this employee past experience.
	 *
	 * @param fromDate the from date of this employee past experience
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee past experience.
	 *
	 * @param groupId the group ID of this employee past experience
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining process ID of this employee past experience.
	 *
	 * @param joiningProcessId the joining process ID of this employee past experience
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the modified date of this employee past experience.
	 *
	 * @param modifiedDate the modified date of this employee past experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization of this employee past experience.
	 *
	 * @param organization the organization of this employee past experience
	 */
	@Override
	public void setOrganization(String organization) {
		model.setOrganization(organization);
	}

	/**
	 * Sets the primary key of this employee past experience.
	 *
	 * @param primaryKey the primary key of this employee past experience
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee past experience.
	 *
	 * @param status the status of this employee past experience
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this employee past experience.
	 *
	 * @param toDate the to date of this employee past experience
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee past experience.
	 *
	 * @param userId the user ID of this employee past experience
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee past experience.
	 *
	 * @param userName the user name of this employee past experience
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee past experience.
	 *
	 * @param userUuid the user uuid of this employee past experience
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the work area ID of this employee past experience.
	 *
	 * @param workAreaId the work area ID of this employee past experience
	 */
	@Override
	public void setWorkAreaId(long workAreaId) {
		model.setWorkAreaId(workAreaId);
	}

	@Override
	protected EmployeePastExperienceWrapper wrap(
		EmployeePastExperience employeePastExperience) {

		return new EmployeePastExperienceWrapper(employeePastExperience);
	}

}