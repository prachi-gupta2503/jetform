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
 * This class is a wrapper for {@link EmployeeDigitalSignature}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDigitalSignature
 * @generated
 */
public class EmployeeDigitalSignatureWrapper
	extends BaseModelWrapper<EmployeeDigitalSignature>
	implements EmployeeDigitalSignature,
			   ModelWrapper<EmployeeDigitalSignature> {

	public EmployeeDigitalSignatureWrapper(
		EmployeeDigitalSignature employeeDigitalSignature) {

		super(employeeDigitalSignature);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"employeeDigitalSignatureId", getEmployeeDigitalSignatureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("cid", getCid());
		attributes.put("details", getDetails());
		attributes.put("issueDate", getIssueDate());
		attributes.put("revokeDate", getRevokeDate());
		attributes.put("revoked", isRevoked());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeDigitalSignatureId = (Long)attributes.get(
			"employeeDigitalSignatureId");

		if (employeeDigitalSignatureId != null) {
			setEmployeeDigitalSignatureId(employeeDigitalSignatureId);
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

		String cid = (String)attributes.get("cid");

		if (cid != null) {
			setCid(cid);
		}

		String details = (String)attributes.get("details");

		if (details != null) {
			setDetails(details);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		Date revokeDate = (Date)attributes.get("revokeDate");

		if (revokeDate != null) {
			setRevokeDate(revokeDate);
		}

		Boolean revoked = (Boolean)attributes.get("revoked");

		if (revoked != null) {
			setRevoked(revoked);
		}
	}

	/**
	 * Returns the cid of this employee digital signature.
	 *
	 * @return the cid of this employee digital signature
	 */
	@Override
	public String getCid() {
		return model.getCid();
	}

	/**
	 * Returns the company ID of this employee digital signature.
	 *
	 * @return the company ID of this employee digital signature
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee digital signature.
	 *
	 * @return the create date of this employee digital signature
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the details of this employee digital signature.
	 *
	 * @return the details of this employee digital signature
	 */
	@Override
	public String getDetails() {
		return model.getDetails();
	}

	/**
	 * Returns the employee digital signature ID of this employee digital signature.
	 *
	 * @return the employee digital signature ID of this employee digital signature
	 */
	@Override
	public long getEmployeeDigitalSignatureId() {
		return model.getEmployeeDigitalSignatureId();
	}

	/**
	 * Returns the employee ID of this employee digital signature.
	 *
	 * @return the employee ID of this employee digital signature
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee digital signature.
	 *
	 * @return the group ID of this employee digital signature
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the issue date of this employee digital signature.
	 *
	 * @return the issue date of this employee digital signature
	 */
	@Override
	public Date getIssueDate() {
		return model.getIssueDate();
	}

	/**
	 * Returns the modified date of this employee digital signature.
	 *
	 * @return the modified date of this employee digital signature
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee digital signature.
	 *
	 * @return the primary key of this employee digital signature
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the revoked of this employee digital signature.
	 *
	 * @return the revoked of this employee digital signature
	 */
	@Override
	public boolean getRevoked() {
		return model.getRevoked();
	}

	/**
	 * Returns the revoke date of this employee digital signature.
	 *
	 * @return the revoke date of this employee digital signature
	 */
	@Override
	public Date getRevokeDate() {
		return model.getRevokeDate();
	}

	/**
	 * Returns the user ID of this employee digital signature.
	 *
	 * @return the user ID of this employee digital signature
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee digital signature.
	 *
	 * @return the user name of this employee digital signature
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee digital signature.
	 *
	 * @return the user uuid of this employee digital signature
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee digital signature is revoked.
	 *
	 * @return <code>true</code> if this employee digital signature is revoked; <code>false</code> otherwise
	 */
	@Override
	public boolean isRevoked() {
		return model.isRevoked();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cid of this employee digital signature.
	 *
	 * @param cid the cid of this employee digital signature
	 */
	@Override
	public void setCid(String cid) {
		model.setCid(cid);
	}

	/**
	 * Sets the company ID of this employee digital signature.
	 *
	 * @param companyId the company ID of this employee digital signature
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee digital signature.
	 *
	 * @param createDate the create date of this employee digital signature
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the details of this employee digital signature.
	 *
	 * @param details the details of this employee digital signature
	 */
	@Override
	public void setDetails(String details) {
		model.setDetails(details);
	}

	/**
	 * Sets the employee digital signature ID of this employee digital signature.
	 *
	 * @param employeeDigitalSignatureId the employee digital signature ID of this employee digital signature
	 */
	@Override
	public void setEmployeeDigitalSignatureId(long employeeDigitalSignatureId) {
		model.setEmployeeDigitalSignatureId(employeeDigitalSignatureId);
	}

	/**
	 * Sets the employee ID of this employee digital signature.
	 *
	 * @param employeeId the employee ID of this employee digital signature
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee digital signature.
	 *
	 * @param groupId the group ID of this employee digital signature
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the issue date of this employee digital signature.
	 *
	 * @param issueDate the issue date of this employee digital signature
	 */
	@Override
	public void setIssueDate(Date issueDate) {
		model.setIssueDate(issueDate);
	}

	/**
	 * Sets the modified date of this employee digital signature.
	 *
	 * @param modifiedDate the modified date of this employee digital signature
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee digital signature.
	 *
	 * @param primaryKey the primary key of this employee digital signature
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this employee digital signature is revoked.
	 *
	 * @param revoked the revoked of this employee digital signature
	 */
	@Override
	public void setRevoked(boolean revoked) {
		model.setRevoked(revoked);
	}

	/**
	 * Sets the revoke date of this employee digital signature.
	 *
	 * @param revokeDate the revoke date of this employee digital signature
	 */
	@Override
	public void setRevokeDate(Date revokeDate) {
		model.setRevokeDate(revokeDate);
	}

	/**
	 * Sets the user ID of this employee digital signature.
	 *
	 * @param userId the user ID of this employee digital signature
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee digital signature.
	 *
	 * @param userName the user name of this employee digital signature
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee digital signature.
	 *
	 * @param userUuid the user uuid of this employee digital signature
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeDigitalSignatureWrapper wrap(
		EmployeeDigitalSignature employeeDigitalSignature) {

		return new EmployeeDigitalSignatureWrapper(employeeDigitalSignature);
	}

}