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
 * This class is a wrapper for {@link EmployeeTraining}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTraining
 * @generated
 */
public class EmployeeTrainingWrapper
	extends BaseModelWrapper<EmployeeTraining>
	implements EmployeeTraining, ModelWrapper<EmployeeTraining> {

	public EmployeeTrainingWrapper(EmployeeTraining employeeTraining) {
		super(employeeTraining);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeTrainingId", getEmployeeTrainingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("durationMonths", getDurationMonths());
		attributes.put("fromMonth", getFromMonth());
		attributes.put("toMonth", getToMonth());
		attributes.put("courseId", getCourseId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("certificateId", getCertificateId());
		attributes.put("endDate", getEndDate());
		attributes.put("startDate", getStartDate());
		attributes.put("instituteId", getInstituteId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeTrainingId = (Long)attributes.get("employeeTrainingId");

		if (employeeTrainingId != null) {
			setEmployeeTrainingId(employeeTrainingId);
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

		Integer durationMonths = (Integer)attributes.get("durationMonths");

		if (durationMonths != null) {
			setDurationMonths(durationMonths);
		}

		Date fromMonth = (Date)attributes.get("fromMonth");

		if (fromMonth != null) {
			setFromMonth(fromMonth);
		}

		Date toMonth = (Date)attributes.get("toMonth");

		if (toMonth != null) {
			setToMonth(toMonth);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long certificateId = (Long)attributes.get("certificateId");

		if (certificateId != null) {
			setCertificateId(certificateId);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long instituteId = (Long)attributes.get("instituteId");

		if (instituteId != null) {
			setInstituteId(instituteId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee training.
	 *
	 * @return the active of this employee training
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the certificate ID of this employee training.
	 *
	 * @return the certificate ID of this employee training
	 */
	@Override
	public long getCertificateId() {
		return model.getCertificateId();
	}

	/**
	 * Returns the company ID of this employee training.
	 *
	 * @return the company ID of this employee training
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the course ID of this employee training.
	 *
	 * @return the course ID of this employee training
	 */
	@Override
	public long getCourseId() {
		return model.getCourseId();
	}

	/**
	 * Returns the create date of this employee training.
	 *
	 * @return the create date of this employee training
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the duration months of this employee training.
	 *
	 * @return the duration months of this employee training
	 */
	@Override
	public int getDurationMonths() {
		return model.getDurationMonths();
	}

	/**
	 * Returns the employee ID of this employee training.
	 *
	 * @return the employee ID of this employee training
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee training ID of this employee training.
	 *
	 * @return the employee training ID of this employee training
	 */
	@Override
	public long getEmployeeTrainingId() {
		return model.getEmployeeTrainingId();
	}

	/**
	 * Returns the end date of this employee training.
	 *
	 * @return the end date of this employee training
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the from month of this employee training.
	 *
	 * @return the from month of this employee training
	 */
	@Override
	public Date getFromMonth() {
		return model.getFromMonth();
	}

	/**
	 * Returns the group ID of this employee training.
	 *
	 * @return the group ID of this employee training
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institute ID of this employee training.
	 *
	 * @return the institute ID of this employee training
	 */
	@Override
	public long getInstituteId() {
		return model.getInstituteId();
	}

	/**
	 * Returns the modified date of this employee training.
	 *
	 * @return the modified date of this employee training
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee training.
	 *
	 * @return the organization ID of this employee training
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this employee training.
	 *
	 * @return the primary key of this employee training
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this employee training.
	 *
	 * @return the start date of this employee training
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this employee training.
	 *
	 * @return the status of this employee training
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to month of this employee training.
	 *
	 * @return the to month of this employee training
	 */
	@Override
	public Date getToMonth() {
		return model.getToMonth();
	}

	/**
	 * Returns the user ID of this employee training.
	 *
	 * @return the user ID of this employee training
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee training.
	 *
	 * @return the user name of this employee training
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee training.
	 *
	 * @return the user uuid of this employee training
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee training is active.
	 *
	 * @return <code>true</code> if this employee training is active; <code>false</code> otherwise
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
	 * Sets whether this employee training is active.
	 *
	 * @param active the active of this employee training
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the certificate ID of this employee training.
	 *
	 * @param certificateId the certificate ID of this employee training
	 */
	@Override
	public void setCertificateId(long certificateId) {
		model.setCertificateId(certificateId);
	}

	/**
	 * Sets the company ID of this employee training.
	 *
	 * @param companyId the company ID of this employee training
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the course ID of this employee training.
	 *
	 * @param courseId the course ID of this employee training
	 */
	@Override
	public void setCourseId(long courseId) {
		model.setCourseId(courseId);
	}

	/**
	 * Sets the create date of this employee training.
	 *
	 * @param createDate the create date of this employee training
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the duration months of this employee training.
	 *
	 * @param durationMonths the duration months of this employee training
	 */
	@Override
	public void setDurationMonths(int durationMonths) {
		model.setDurationMonths(durationMonths);
	}

	/**
	 * Sets the employee ID of this employee training.
	 *
	 * @param employeeId the employee ID of this employee training
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee training ID of this employee training.
	 *
	 * @param employeeTrainingId the employee training ID of this employee training
	 */
	@Override
	public void setEmployeeTrainingId(long employeeTrainingId) {
		model.setEmployeeTrainingId(employeeTrainingId);
	}

	/**
	 * Sets the end date of this employee training.
	 *
	 * @param endDate the end date of this employee training
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the from month of this employee training.
	 *
	 * @param fromMonth the from month of this employee training
	 */
	@Override
	public void setFromMonth(Date fromMonth) {
		model.setFromMonth(fromMonth);
	}

	/**
	 * Sets the group ID of this employee training.
	 *
	 * @param groupId the group ID of this employee training
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institute ID of this employee training.
	 *
	 * @param instituteId the institute ID of this employee training
	 */
	@Override
	public void setInstituteId(long instituteId) {
		model.setInstituteId(instituteId);
	}

	/**
	 * Sets the modified date of this employee training.
	 *
	 * @param modifiedDate the modified date of this employee training
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee training.
	 *
	 * @param organizationId the organization ID of this employee training
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this employee training.
	 *
	 * @param primaryKey the primary key of this employee training
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this employee training.
	 *
	 * @param startDate the start date of this employee training
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this employee training.
	 *
	 * @param status the status of this employee training
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to month of this employee training.
	 *
	 * @param toMonth the to month of this employee training
	 */
	@Override
	public void setToMonth(Date toMonth) {
		model.setToMonth(toMonth);
	}

	/**
	 * Sets the user ID of this employee training.
	 *
	 * @param userId the user ID of this employee training
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee training.
	 *
	 * @param userName the user name of this employee training
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee training.
	 *
	 * @param userUuid the user uuid of this employee training
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeTrainingWrapper wrap(EmployeeTraining employeeTraining) {
		return new EmployeeTrainingWrapper(employeeTraining);
	}

}