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
 * This class is a wrapper for {@link EmployeeExperience}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperience
 * @generated
 */
public class EmployeeExperienceWrapper
	extends BaseModelWrapper<EmployeeExperience>
	implements EmployeeExperience, ModelWrapper<EmployeeExperience> {

	public EmployeeExperienceWrapper(EmployeeExperience employeeExperience) {
		super(employeeExperience);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeExperienceId", getEmployeeExperienceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("designationId", getDesignationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("postId", getPostId());
		attributes.put("tradeId", getTradeId());
		attributes.put("experienceId", getExperienceId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("workAreaId", getWorkAreaId());
		attributes.put("workAreaMinorId", getWorkAreaMinorId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeExperienceId = (Long)attributes.get(
			"employeeExperienceId");

		if (employeeExperienceId != null) {
			setEmployeeExperienceId(employeeExperienceId);
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

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long tradeId = (Long)attributes.get("tradeId");

		if (tradeId != null) {
			setTradeId(tradeId);
		}

		Long experienceId = (Long)attributes.get("experienceId");

		if (experienceId != null) {
			setExperienceId(experienceId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long workAreaId = (Long)attributes.get("workAreaId");

		if (workAreaId != null) {
			setWorkAreaId(workAreaId);
		}

		Long workAreaMinorId = (Long)attributes.get("workAreaMinorId");

		if (workAreaMinorId != null) {
			setWorkAreaMinorId(workAreaMinorId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee experience.
	 *
	 * @return the active of this employee experience
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee experience.
	 *
	 * @return the company ID of this employee experience
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee experience.
	 *
	 * @return the create date of this employee experience
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation ID of this employee experience.
	 *
	 * @return the designation ID of this employee experience
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the employee experience ID of this employee experience.
	 *
	 * @return the employee experience ID of this employee experience
	 */
	@Override
	public long getEmployeeExperienceId() {
		return model.getEmployeeExperienceId();
	}

	/**
	 * Returns the employee ID of this employee experience.
	 *
	 * @return the employee ID of this employee experience
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the experience ID of this employee experience.
	 *
	 * @return the experience ID of this employee experience
	 */
	@Override
	public long getExperienceId() {
		return model.getExperienceId();
	}

	/**
	 * Returns the from date of this employee experience.
	 *
	 * @return the from date of this employee experience
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee experience.
	 *
	 * @return the group ID of this employee experience
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee experience.
	 *
	 * @return the modified date of this employee experience
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee experience.
	 *
	 * @return the organization ID of this employee experience
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the post ID of this employee experience.
	 *
	 * @return the post ID of this employee experience
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this employee experience.
	 *
	 * @return the primary key of this employee experience
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee experience.
	 *
	 * @return the status of this employee experience
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this employee experience.
	 *
	 * @return the to date of this employee experience
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the trade ID of this employee experience.
	 *
	 * @return the trade ID of this employee experience
	 */
	@Override
	public long getTradeId() {
		return model.getTradeId();
	}

	/**
	 * Returns the user ID of this employee experience.
	 *
	 * @return the user ID of this employee experience
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee experience.
	 *
	 * @return the user name of this employee experience
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee experience.
	 *
	 * @return the user uuid of this employee experience
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the work area ID of this employee experience.
	 *
	 * @return the work area ID of this employee experience
	 */
	@Override
	public long getWorkAreaId() {
		return model.getWorkAreaId();
	}

	/**
	 * Returns the work area minor ID of this employee experience.
	 *
	 * @return the work area minor ID of this employee experience
	 */
	@Override
	public long getWorkAreaMinorId() {
		return model.getWorkAreaMinorId();
	}

	/**
	 * Returns <code>true</code> if this employee experience is active.
	 *
	 * @return <code>true</code> if this employee experience is active; <code>false</code> otherwise
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
	 * Sets whether this employee experience is active.
	 *
	 * @param active the active of this employee experience
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee experience.
	 *
	 * @param companyId the company ID of this employee experience
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee experience.
	 *
	 * @param createDate the create date of this employee experience
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation ID of this employee experience.
	 *
	 * @param designationId the designation ID of this employee experience
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the employee experience ID of this employee experience.
	 *
	 * @param employeeExperienceId the employee experience ID of this employee experience
	 */
	@Override
	public void setEmployeeExperienceId(long employeeExperienceId) {
		model.setEmployeeExperienceId(employeeExperienceId);
	}

	/**
	 * Sets the employee ID of this employee experience.
	 *
	 * @param employeeId the employee ID of this employee experience
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the experience ID of this employee experience.
	 *
	 * @param experienceId the experience ID of this employee experience
	 */
	@Override
	public void setExperienceId(long experienceId) {
		model.setExperienceId(experienceId);
	}

	/**
	 * Sets the from date of this employee experience.
	 *
	 * @param fromDate the from date of this employee experience
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee experience.
	 *
	 * @param groupId the group ID of this employee experience
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee experience.
	 *
	 * @param modifiedDate the modified date of this employee experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee experience.
	 *
	 * @param organizationId the organization ID of this employee experience
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the post ID of this employee experience.
	 *
	 * @param postId the post ID of this employee experience
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this employee experience.
	 *
	 * @param primaryKey the primary key of this employee experience
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee experience.
	 *
	 * @param status the status of this employee experience
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this employee experience.
	 *
	 * @param toDate the to date of this employee experience
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the trade ID of this employee experience.
	 *
	 * @param tradeId the trade ID of this employee experience
	 */
	@Override
	public void setTradeId(long tradeId) {
		model.setTradeId(tradeId);
	}

	/**
	 * Sets the user ID of this employee experience.
	 *
	 * @param userId the user ID of this employee experience
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee experience.
	 *
	 * @param userName the user name of this employee experience
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee experience.
	 *
	 * @param userUuid the user uuid of this employee experience
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the work area ID of this employee experience.
	 *
	 * @param workAreaId the work area ID of this employee experience
	 */
	@Override
	public void setWorkAreaId(long workAreaId) {
		model.setWorkAreaId(workAreaId);
	}

	/**
	 * Sets the work area minor ID of this employee experience.
	 *
	 * @param workAreaMinorId the work area minor ID of this employee experience
	 */
	@Override
	public void setWorkAreaMinorId(long workAreaMinorId) {
		model.setWorkAreaMinorId(workAreaMinorId);
	}

	@Override
	protected EmployeeExperienceWrapper wrap(
		EmployeeExperience employeeExperience) {

		return new EmployeeExperienceWrapper(employeeExperience);
	}

}