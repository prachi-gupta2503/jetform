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
 * This class is a wrapper for {@link EmployeeGrade}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeGrade
 * @generated
 */
public class EmployeeGradeWrapper
	extends BaseModelWrapper<EmployeeGrade>
	implements EmployeeGrade, ModelWrapper<EmployeeGrade> {

	public EmployeeGradeWrapper(EmployeeGrade employeeGrade) {
		super(employeeGrade);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeGradeId", getEmployeeGradeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("gradeId", getGradeId());
		attributes.put("gradeModeId", getGradeModeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeGradeId = (Long)attributes.get("employeeGradeId");

		if (employeeGradeId != null) {
			setEmployeeGradeId(employeeGradeId);
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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		Long gradeModeId = (Long)attributes.get("gradeModeId");

		if (gradeModeId != null) {
			setGradeModeId(gradeModeId);
		}
	}

	/**
	 * Returns the active of this employee grade.
	 *
	 * @return the active of this employee grade
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee grade.
	 *
	 * @return the company ID of this employee grade
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee grade.
	 *
	 * @return the create date of this employee grade
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee grade ID of this employee grade.
	 *
	 * @return the employee grade ID of this employee grade
	 */
	@Override
	public long getEmployeeGradeId() {
		return model.getEmployeeGradeId();
	}

	/**
	 * Returns the employee ID of this employee grade.
	 *
	 * @return the employee ID of this employee grade
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the from date of this employee grade.
	 *
	 * @return the from date of this employee grade
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the grade ID of this employee grade.
	 *
	 * @return the grade ID of this employee grade
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the grade mode ID of this employee grade.
	 *
	 * @return the grade mode ID of this employee grade
	 */
	@Override
	public long getGradeModeId() {
		return model.getGradeModeId();
	}

	/**
	 * Returns the group ID of this employee grade.
	 *
	 * @return the group ID of this employee grade
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee grade.
	 *
	 * @return the modified date of this employee grade
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee grade.
	 *
	 * @return the primary key of this employee grade
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the to date of this employee grade.
	 *
	 * @return the to date of this employee grade
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee grade.
	 *
	 * @return the user ID of this employee grade
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee grade.
	 *
	 * @return the user name of this employee grade
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee grade.
	 *
	 * @return the user uuid of this employee grade
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee grade is active.
	 *
	 * @return <code>true</code> if this employee grade is active; <code>false</code> otherwise
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
	 * Sets whether this employee grade is active.
	 *
	 * @param active the active of this employee grade
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee grade.
	 *
	 * @param companyId the company ID of this employee grade
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee grade.
	 *
	 * @param createDate the create date of this employee grade
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee grade ID of this employee grade.
	 *
	 * @param employeeGradeId the employee grade ID of this employee grade
	 */
	@Override
	public void setEmployeeGradeId(long employeeGradeId) {
		model.setEmployeeGradeId(employeeGradeId);
	}

	/**
	 * Sets the employee ID of this employee grade.
	 *
	 * @param employeeId the employee ID of this employee grade
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the from date of this employee grade.
	 *
	 * @param fromDate the from date of this employee grade
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the grade ID of this employee grade.
	 *
	 * @param gradeId the grade ID of this employee grade
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the grade mode ID of this employee grade.
	 *
	 * @param gradeModeId the grade mode ID of this employee grade
	 */
	@Override
	public void setGradeModeId(long gradeModeId) {
		model.setGradeModeId(gradeModeId);
	}

	/**
	 * Sets the group ID of this employee grade.
	 *
	 * @param groupId the group ID of this employee grade
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee grade.
	 *
	 * @param modifiedDate the modified date of this employee grade
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee grade.
	 *
	 * @param primaryKey the primary key of this employee grade
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the to date of this employee grade.
	 *
	 * @param toDate the to date of this employee grade
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee grade.
	 *
	 * @param userId the user ID of this employee grade
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee grade.
	 *
	 * @param userName the user name of this employee grade
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee grade.
	 *
	 * @param userUuid the user uuid of this employee grade
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeGradeWrapper wrap(EmployeeGrade employeeGrade) {
		return new EmployeeGradeWrapper(employeeGrade);
	}

}