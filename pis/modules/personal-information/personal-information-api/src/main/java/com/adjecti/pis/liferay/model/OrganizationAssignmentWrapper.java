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
 * This class is a wrapper for {@link OrganizationAssignment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationAssignment
 * @generated
 */
public class OrganizationAssignmentWrapper
	extends BaseModelWrapper<OrganizationAssignment>
	implements ModelWrapper<OrganizationAssignment>, OrganizationAssignment {

	public OrganizationAssignmentWrapper(
		OrganizationAssignment organizationAssignment) {

		super(organizationAssignment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"organizationAssignmentId", getOrganizationAssignmentId());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationAssignmentId = (Long)attributes.get(
			"organizationAssignmentId");

		if (organizationAssignmentId != null) {
			setOrganizationAssignmentId(organizationAssignmentId);
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
	}

	/**
	 * Returns the active of this organization assignment.
	 *
	 * @return the active of this organization assignment
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this organization assignment.
	 *
	 * @return the company ID of this organization assignment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this organization assignment.
	 *
	 * @return the create date of this organization assignment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this organization assignment.
	 *
	 * @return the employee ID of this organization assignment
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this organization assignment.
	 *
	 * @return the group ID of this organization assignment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this organization assignment.
	 *
	 * @return the modified date of this organization assignment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization assignment ID of this organization assignment.
	 *
	 * @return the organization assignment ID of this organization assignment
	 */
	@Override
	public long getOrganizationAssignmentId() {
		return model.getOrganizationAssignmentId();
	}

	/**
	 * Returns the organization code of this organization assignment.
	 *
	 * @return the organization code of this organization assignment
	 */
	@Override
	public String getOrganizationCode() {
		return model.getOrganizationCode();
	}

	/**
	 * Returns the organization ID of this organization assignment.
	 *
	 * @return the organization ID of this organization assignment
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the personal no of this organization assignment.
	 *
	 * @return the personal no of this organization assignment
	 */
	@Override
	public String getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the primary key of this organization assignment.
	 *
	 * @return the primary key of this organization assignment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sub organization code of this organization assignment.
	 *
	 * @return the sub organization code of this organization assignment
	 */
	@Override
	public String getSubOrganizationCode() {
		return model.getSubOrganizationCode();
	}

	/**
	 * Returns the sub organization ID of this organization assignment.
	 *
	 * @return the sub organization ID of this organization assignment
	 */
	@Override
	public long getSubOrganizationId() {
		return model.getSubOrganizationId();
	}

	/**
	 * Returns the user ID of this organization assignment.
	 *
	 * @return the user ID of this organization assignment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this organization assignment.
	 *
	 * @return the user name of this organization assignment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this organization assignment.
	 *
	 * @return the user uuid of this organization assignment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this organization assignment is active.
	 *
	 * @return <code>true</code> if this organization assignment is active; <code>false</code> otherwise
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
	 * Sets whether this organization assignment is active.
	 *
	 * @param active the active of this organization assignment
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this organization assignment.
	 *
	 * @param companyId the company ID of this organization assignment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this organization assignment.
	 *
	 * @param createDate the create date of this organization assignment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this organization assignment.
	 *
	 * @param employeeId the employee ID of this organization assignment
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this organization assignment.
	 *
	 * @param groupId the group ID of this organization assignment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this organization assignment.
	 *
	 * @param modifiedDate the modified date of this organization assignment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization assignment ID of this organization assignment.
	 *
	 * @param organizationAssignmentId the organization assignment ID of this organization assignment
	 */
	@Override
	public void setOrganizationAssignmentId(long organizationAssignmentId) {
		model.setOrganizationAssignmentId(organizationAssignmentId);
	}

	/**
	 * Sets the organization code of this organization assignment.
	 *
	 * @param organizationCode the organization code of this organization assignment
	 */
	@Override
	public void setOrganizationCode(String organizationCode) {
		model.setOrganizationCode(organizationCode);
	}

	/**
	 * Sets the organization ID of this organization assignment.
	 *
	 * @param organizationId the organization ID of this organization assignment
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the personal no of this organization assignment.
	 *
	 * @param personalNo the personal no of this organization assignment
	 */
	@Override
	public void setPersonalNo(String personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets the primary key of this organization assignment.
	 *
	 * @param primaryKey the primary key of this organization assignment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sub organization code of this organization assignment.
	 *
	 * @param subOrganizationCode the sub organization code of this organization assignment
	 */
	@Override
	public void setSubOrganizationCode(String subOrganizationCode) {
		model.setSubOrganizationCode(subOrganizationCode);
	}

	/**
	 * Sets the sub organization ID of this organization assignment.
	 *
	 * @param subOrganizationId the sub organization ID of this organization assignment
	 */
	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		model.setSubOrganizationId(subOrganizationId);
	}

	/**
	 * Sets the user ID of this organization assignment.
	 *
	 * @param userId the user ID of this organization assignment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this organization assignment.
	 *
	 * @param userName the user name of this organization assignment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this organization assignment.
	 *
	 * @param userUuid the user uuid of this organization assignment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OrganizationAssignmentWrapper wrap(
		OrganizationAssignment organizationAssignment) {

		return new OrganizationAssignmentWrapper(organizationAssignment);
	}

}