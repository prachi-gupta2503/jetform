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
 * This class is a wrapper for {@link EmployeeOrganization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganization
 * @generated
 */
public class EmployeeOrganizationWrapper
	extends BaseModelWrapper<EmployeeOrganization>
	implements EmployeeOrganization, ModelWrapper<EmployeeOrganization> {

	public EmployeeOrganizationWrapper(
		EmployeeOrganization employeeOrganization) {

		super(employeeOrganization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeOrganizationId", getEmployeeOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("organizationCode", getOrganizationCode());
		attributes.put("subOrganizationId", getSubOrganizationId());
		attributes.put("subOrganizationCode", getSubOrganizationCode());
		attributes.put("active", isActive());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeOrganizationId = (Long)attributes.get(
			"employeeOrganizationId");

		if (employeeOrganizationId != null) {
			setEmployeeOrganizationId(employeeOrganizationId);
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

		String personalNo = (String)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String organizationCode = (String)attributes.get("organizationCode");

		if (organizationCode != null) {
			setOrganizationCode(organizationCode);
		}

		Long subOrganizationId = (Long)attributes.get("subOrganizationId");

		if (subOrganizationId != null) {
			setSubOrganizationId(subOrganizationId);
		}

		String subOrganizationCode = (String)attributes.get(
			"subOrganizationCode");

		if (subOrganizationCode != null) {
			setSubOrganizationCode(subOrganizationCode);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee organization.
	 *
	 * @return the active of this employee organization
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee organization.
	 *
	 * @return the company ID of this employee organization
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee organization.
	 *
	 * @return the create date of this employee organization
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee organization.
	 *
	 * @return the employee ID of this employee organization
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee organization ID of this employee organization.
	 *
	 * @return the employee organization ID of this employee organization
	 */
	@Override
	public long getEmployeeOrganizationId() {
		return model.getEmployeeOrganizationId();
	}

	/**
	 * Returns the group ID of this employee organization.
	 *
	 * @return the group ID of this employee organization
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee organization.
	 *
	 * @return the modified date of this employee organization
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization code of this employee organization.
	 *
	 * @return the organization code of this employee organization
	 */
	@Override
	public String getOrganizationCode() {
		return model.getOrganizationCode();
	}

	/**
	 * Returns the organization ID of this employee organization.
	 *
	 * @return the organization ID of this employee organization
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the personal no of this employee organization.
	 *
	 * @return the personal no of this employee organization
	 */
	@Override
	public String getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the primary key of this employee organization.
	 *
	 * @return the primary key of this employee organization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee organization.
	 *
	 * @return the status of this employee organization
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the sub organization code of this employee organization.
	 *
	 * @return the sub organization code of this employee organization
	 */
	@Override
	public String getSubOrganizationCode() {
		return model.getSubOrganizationCode();
	}

	/**
	 * Returns the sub organization ID of this employee organization.
	 *
	 * @return the sub organization ID of this employee organization
	 */
	@Override
	public long getSubOrganizationId() {
		return model.getSubOrganizationId();
	}

	/**
	 * Returns the user ID of this employee organization.
	 *
	 * @return the user ID of this employee organization
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee organization.
	 *
	 * @return the user name of this employee organization
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee organization.
	 *
	 * @return the user uuid of this employee organization
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee organization is active.
	 *
	 * @return <code>true</code> if this employee organization is active; <code>false</code> otherwise
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
	 * Sets whether this employee organization is active.
	 *
	 * @param active the active of this employee organization
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee organization.
	 *
	 * @param companyId the company ID of this employee organization
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee organization.
	 *
	 * @param createDate the create date of this employee organization
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee organization.
	 *
	 * @param employeeId the employee ID of this employee organization
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee organization ID of this employee organization.
	 *
	 * @param employeeOrganizationId the employee organization ID of this employee organization
	 */
	@Override
	public void setEmployeeOrganizationId(long employeeOrganizationId) {
		model.setEmployeeOrganizationId(employeeOrganizationId);
	}

	/**
	 * Sets the group ID of this employee organization.
	 *
	 * @param groupId the group ID of this employee organization
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee organization.
	 *
	 * @param modifiedDate the modified date of this employee organization
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization code of this employee organization.
	 *
	 * @param organizationCode the organization code of this employee organization
	 */
	@Override
	public void setOrganizationCode(String organizationCode) {
		model.setOrganizationCode(organizationCode);
	}

	/**
	 * Sets the organization ID of this employee organization.
	 *
	 * @param organizationId the organization ID of this employee organization
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the personal no of this employee organization.
	 *
	 * @param personalNo the personal no of this employee organization
	 */
	@Override
	public void setPersonalNo(String personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets the primary key of this employee organization.
	 *
	 * @param primaryKey the primary key of this employee organization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee organization.
	 *
	 * @param status the status of this employee organization
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the sub organization code of this employee organization.
	 *
	 * @param subOrganizationCode the sub organization code of this employee organization
	 */
	@Override
	public void setSubOrganizationCode(String subOrganizationCode) {
		model.setSubOrganizationCode(subOrganizationCode);
	}

	/**
	 * Sets the sub organization ID of this employee organization.
	 *
	 * @param subOrganizationId the sub organization ID of this employee organization
	 */
	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		model.setSubOrganizationId(subOrganizationId);
	}

	/**
	 * Sets the user ID of this employee organization.
	 *
	 * @param userId the user ID of this employee organization
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee organization.
	 *
	 * @param userName the user name of this employee organization
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee organization.
	 *
	 * @param userUuid the user uuid of this employee organization
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeOrganizationWrapper wrap(
		EmployeeOrganization employeeOrganization) {

		return new EmployeeOrganizationWrapper(employeeOrganization);
	}

}