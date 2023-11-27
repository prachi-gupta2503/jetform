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
 * This class is a wrapper for {@link EmployeeBenefitScheme}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBenefitScheme
 * @generated
 */
public class EmployeeBenefitSchemeWrapper
	extends BaseModelWrapper<EmployeeBenefitScheme>
	implements EmployeeBenefitScheme, ModelWrapper<EmployeeBenefitScheme> {

	public EmployeeBenefitSchemeWrapper(
		EmployeeBenefitScheme employeeBenefitScheme) {

		super(employeeBenefitScheme);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeBenefitSchemeId", getEmployeeBenefitSchemeId());
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
		attributes.put("benefitSchemeId", getBenefitSchemeId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeBenefitSchemeId = (Long)attributes.get(
			"employeeBenefitSchemeId");

		if (employeeBenefitSchemeId != null) {
			setEmployeeBenefitSchemeId(employeeBenefitSchemeId);
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

		Long benefitSchemeId = (Long)attributes.get("benefitSchemeId");

		if (benefitSchemeId != null) {
			setBenefitSchemeId(benefitSchemeId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee benefit scheme.
	 *
	 * @return the active of this employee benefit scheme
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit scheme ID of this employee benefit scheme.
	 *
	 * @return the benefit scheme ID of this employee benefit scheme
	 */
	@Override
	public long getBenefitSchemeId() {
		return model.getBenefitSchemeId();
	}

	/**
	 * Returns the company ID of this employee benefit scheme.
	 *
	 * @return the company ID of this employee benefit scheme
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee benefit scheme.
	 *
	 * @return the create date of this employee benefit scheme
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document no of this employee benefit scheme.
	 *
	 * @return the document no of this employee benefit scheme
	 */
	@Override
	public String getDocumentNo() {
		return model.getDocumentNo();
	}

	/**
	 * Returns the employee benefit scheme ID of this employee benefit scheme.
	 *
	 * @return the employee benefit scheme ID of this employee benefit scheme
	 */
	@Override
	public long getEmployeeBenefitSchemeId() {
		return model.getEmployeeBenefitSchemeId();
	}

	/**
	 * Returns the employee ID of this employee benefit scheme.
	 *
	 * @return the employee ID of this employee benefit scheme
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the from date of this employee benefit scheme.
	 *
	 * @return the from date of this employee benefit scheme
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee benefit scheme.
	 *
	 * @return the group ID of this employee benefit scheme
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee benefit scheme.
	 *
	 * @return the modified date of this employee benefit scheme
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee benefit scheme.
	 *
	 * @return the primary key of this employee benefit scheme
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee benefit scheme.
	 *
	 * @return the status of this employee benefit scheme
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this employee benefit scheme.
	 *
	 * @return the to date of this employee benefit scheme
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee benefit scheme.
	 *
	 * @return the user ID of this employee benefit scheme
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee benefit scheme.
	 *
	 * @return the user name of this employee benefit scheme
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee benefit scheme.
	 *
	 * @return the user uuid of this employee benefit scheme
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee benefit scheme is active.
	 *
	 * @return <code>true</code> if this employee benefit scheme is active; <code>false</code> otherwise
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
	 * Sets whether this employee benefit scheme is active.
	 *
	 * @param active the active of this employee benefit scheme
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit scheme ID of this employee benefit scheme.
	 *
	 * @param benefitSchemeId the benefit scheme ID of this employee benefit scheme
	 */
	@Override
	public void setBenefitSchemeId(long benefitSchemeId) {
		model.setBenefitSchemeId(benefitSchemeId);
	}

	/**
	 * Sets the company ID of this employee benefit scheme.
	 *
	 * @param companyId the company ID of this employee benefit scheme
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee benefit scheme.
	 *
	 * @param createDate the create date of this employee benefit scheme
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document no of this employee benefit scheme.
	 *
	 * @param documentNo the document no of this employee benefit scheme
	 */
	@Override
	public void setDocumentNo(String documentNo) {
		model.setDocumentNo(documentNo);
	}

	/**
	 * Sets the employee benefit scheme ID of this employee benefit scheme.
	 *
	 * @param employeeBenefitSchemeId the employee benefit scheme ID of this employee benefit scheme
	 */
	@Override
	public void setEmployeeBenefitSchemeId(long employeeBenefitSchemeId) {
		model.setEmployeeBenefitSchemeId(employeeBenefitSchemeId);
	}

	/**
	 * Sets the employee ID of this employee benefit scheme.
	 *
	 * @param employeeId the employee ID of this employee benefit scheme
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the from date of this employee benefit scheme.
	 *
	 * @param fromDate the from date of this employee benefit scheme
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee benefit scheme.
	 *
	 * @param groupId the group ID of this employee benefit scheme
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee benefit scheme.
	 *
	 * @param modifiedDate the modified date of this employee benefit scheme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee benefit scheme.
	 *
	 * @param primaryKey the primary key of this employee benefit scheme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee benefit scheme.
	 *
	 * @param status the status of this employee benefit scheme
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this employee benefit scheme.
	 *
	 * @param toDate the to date of this employee benefit scheme
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee benefit scheme.
	 *
	 * @param userId the user ID of this employee benefit scheme
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee benefit scheme.
	 *
	 * @param userName the user name of this employee benefit scheme
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee benefit scheme.
	 *
	 * @param userUuid the user uuid of this employee benefit scheme
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeBenefitSchemeWrapper wrap(
		EmployeeBenefitScheme employeeBenefitScheme) {

		return new EmployeeBenefitSchemeWrapper(employeeBenefitScheme);
	}

}