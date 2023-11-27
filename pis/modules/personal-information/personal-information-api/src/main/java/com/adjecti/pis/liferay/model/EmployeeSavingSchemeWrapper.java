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
 * This class is a wrapper for {@link EmployeeSavingScheme}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSavingScheme
 * @generated
 */
public class EmployeeSavingSchemeWrapper
	extends BaseModelWrapper<EmployeeSavingScheme>
	implements EmployeeSavingScheme, ModelWrapper<EmployeeSavingScheme> {

	public EmployeeSavingSchemeWrapper(
		EmployeeSavingScheme employeeSavingScheme) {

		super(employeeSavingScheme);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeSavingSchemeId", getEmployeeSavingSchemeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("documentNo", getDocumentNo());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("gradeId", getGradeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeSavingSchemeId = (Long)attributes.get(
			"employeeSavingSchemeId");

		if (employeeSavingSchemeId != null) {
			setEmployeeSavingSchemeId(employeeSavingSchemeId);
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

		String documentNo = (String)attributes.get("documentNo");

		if (documentNo != null) {
			setDocumentNo(documentNo);
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
	}

	/**
	 * Returns the active of this employee saving scheme.
	 *
	 * @return the active of this employee saving scheme
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee saving scheme.
	 *
	 * @return the company ID of this employee saving scheme
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee saving scheme.
	 *
	 * @return the create date of this employee saving scheme
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document no of this employee saving scheme.
	 *
	 * @return the document no of this employee saving scheme
	 */
	@Override
	public String getDocumentNo() {
		return model.getDocumentNo();
	}

	/**
	 * Returns the employee ID of this employee saving scheme.
	 *
	 * @return the employee ID of this employee saving scheme
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee saving scheme ID of this employee saving scheme.
	 *
	 * @return the employee saving scheme ID of this employee saving scheme
	 */
	@Override
	public long getEmployeeSavingSchemeId() {
		return model.getEmployeeSavingSchemeId();
	}

	/**
	 * Returns the from date of this employee saving scheme.
	 *
	 * @return the from date of this employee saving scheme
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the grade ID of this employee saving scheme.
	 *
	 * @return the grade ID of this employee saving scheme
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the group ID of this employee saving scheme.
	 *
	 * @return the group ID of this employee saving scheme
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee saving scheme.
	 *
	 * @return the modified date of this employee saving scheme
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee saving scheme.
	 *
	 * @return the primary key of this employee saving scheme
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the to date of this employee saving scheme.
	 *
	 * @return the to date of this employee saving scheme
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee saving scheme.
	 *
	 * @return the user ID of this employee saving scheme
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee saving scheme.
	 *
	 * @return the user name of this employee saving scheme
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee saving scheme.
	 *
	 * @return the user uuid of this employee saving scheme
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee saving scheme is active.
	 *
	 * @return <code>true</code> if this employee saving scheme is active; <code>false</code> otherwise
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
	 * Sets whether this employee saving scheme is active.
	 *
	 * @param active the active of this employee saving scheme
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee saving scheme.
	 *
	 * @param companyId the company ID of this employee saving scheme
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee saving scheme.
	 *
	 * @param createDate the create date of this employee saving scheme
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document no of this employee saving scheme.
	 *
	 * @param documentNo the document no of this employee saving scheme
	 */
	@Override
	public void setDocumentNo(String documentNo) {
		model.setDocumentNo(documentNo);
	}

	/**
	 * Sets the employee ID of this employee saving scheme.
	 *
	 * @param employeeId the employee ID of this employee saving scheme
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee saving scheme ID of this employee saving scheme.
	 *
	 * @param employeeSavingSchemeId the employee saving scheme ID of this employee saving scheme
	 */
	@Override
	public void setEmployeeSavingSchemeId(long employeeSavingSchemeId) {
		model.setEmployeeSavingSchemeId(employeeSavingSchemeId);
	}

	/**
	 * Sets the from date of this employee saving scheme.
	 *
	 * @param fromDate the from date of this employee saving scheme
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the grade ID of this employee saving scheme.
	 *
	 * @param gradeId the grade ID of this employee saving scheme
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the group ID of this employee saving scheme.
	 *
	 * @param groupId the group ID of this employee saving scheme
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee saving scheme.
	 *
	 * @param modifiedDate the modified date of this employee saving scheme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee saving scheme.
	 *
	 * @param primaryKey the primary key of this employee saving scheme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the to date of this employee saving scheme.
	 *
	 * @param toDate the to date of this employee saving scheme
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee saving scheme.
	 *
	 * @param userId the user ID of this employee saving scheme
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee saving scheme.
	 *
	 * @param userName the user name of this employee saving scheme
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee saving scheme.
	 *
	 * @param userUuid the user uuid of this employee saving scheme
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeSavingSchemeWrapper wrap(
		EmployeeSavingScheme employeeSavingScheme) {

		return new EmployeeSavingSchemeWrapper(employeeSavingScheme);
	}

}