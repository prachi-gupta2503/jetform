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
 * This class is a wrapper for {@link EmployeeVerification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerification
 * @generated
 */
public class EmployeeVerificationWrapper
	extends BaseModelWrapper<EmployeeVerification>
	implements EmployeeVerification, ModelWrapper<EmployeeVerification> {

	public EmployeeVerificationWrapper(
		EmployeeVerification employeeVerification) {

		super(employeeVerification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeVerificationId", getEmployeeVerificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("authority", getAuthority());
		attributes.put("documentNo", getDocumentNo());
		attributes.put("remarks", getRemarks());
		attributes.put("verificationDate", getVerificationDate());
		attributes.put("verificationTypeId", getVerificationTypeId());
		attributes.put("documentId", getDocumentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeVerificationId = (Long)attributes.get(
			"employeeVerificationId");

		if (employeeVerificationId != null) {
			setEmployeeVerificationId(employeeVerificationId);
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

		String authority = (String)attributes.get("authority");

		if (authority != null) {
			setAuthority(authority);
		}

		String documentNo = (String)attributes.get("documentNo");

		if (documentNo != null) {
			setDocumentNo(documentNo);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Date verificationDate = (Date)attributes.get("verificationDate");

		if (verificationDate != null) {
			setVerificationDate(verificationDate);
		}

		Long verificationTypeId = (Long)attributes.get("verificationTypeId");

		if (verificationTypeId != null) {
			setVerificationTypeId(verificationTypeId);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee verification.
	 *
	 * @return the active of this employee verification
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the authority of this employee verification.
	 *
	 * @return the authority of this employee verification
	 */
	@Override
	public String getAuthority() {
		return model.getAuthority();
	}

	/**
	 * Returns the company ID of this employee verification.
	 *
	 * @return the company ID of this employee verification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee verification.
	 *
	 * @return the create date of this employee verification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document ID of this employee verification.
	 *
	 * @return the document ID of this employee verification
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the document no of this employee verification.
	 *
	 * @return the document no of this employee verification
	 */
	@Override
	public String getDocumentNo() {
		return model.getDocumentNo();
	}

	/**
	 * Returns the employee ID of this employee verification.
	 *
	 * @return the employee ID of this employee verification
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee verification ID of this employee verification.
	 *
	 * @return the employee verification ID of this employee verification
	 */
	@Override
	public long getEmployeeVerificationId() {
		return model.getEmployeeVerificationId();
	}

	/**
	 * Returns the group ID of this employee verification.
	 *
	 * @return the group ID of this employee verification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining process ID of this employee verification.
	 *
	 * @return the joining process ID of this employee verification
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the modified date of this employee verification.
	 *
	 * @return the modified date of this employee verification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee verification.
	 *
	 * @return the organization ID of this employee verification
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this employee verification.
	 *
	 * @return the primary key of this employee verification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this employee verification.
	 *
	 * @return the remarks of this employee verification
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the status of this employee verification.
	 *
	 * @return the status of this employee verification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this employee verification.
	 *
	 * @return the user ID of this employee verification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee verification.
	 *
	 * @return the user name of this employee verification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee verification.
	 *
	 * @return the user uuid of this employee verification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the verification date of this employee verification.
	 *
	 * @return the verification date of this employee verification
	 */
	@Override
	public Date getVerificationDate() {
		return model.getVerificationDate();
	}

	/**
	 * Returns the verification type ID of this employee verification.
	 *
	 * @return the verification type ID of this employee verification
	 */
	@Override
	public long getVerificationTypeId() {
		return model.getVerificationTypeId();
	}

	/**
	 * Returns <code>true</code> if this employee verification is active.
	 *
	 * @return <code>true</code> if this employee verification is active; <code>false</code> otherwise
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
	 * Sets whether this employee verification is active.
	 *
	 * @param active the active of this employee verification
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the authority of this employee verification.
	 *
	 * @param authority the authority of this employee verification
	 */
	@Override
	public void setAuthority(String authority) {
		model.setAuthority(authority);
	}

	/**
	 * Sets the company ID of this employee verification.
	 *
	 * @param companyId the company ID of this employee verification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee verification.
	 *
	 * @param createDate the create date of this employee verification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document ID of this employee verification.
	 *
	 * @param documentId the document ID of this employee verification
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the document no of this employee verification.
	 *
	 * @param documentNo the document no of this employee verification
	 */
	@Override
	public void setDocumentNo(String documentNo) {
		model.setDocumentNo(documentNo);
	}

	/**
	 * Sets the employee ID of this employee verification.
	 *
	 * @param employeeId the employee ID of this employee verification
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee verification ID of this employee verification.
	 *
	 * @param employeeVerificationId the employee verification ID of this employee verification
	 */
	@Override
	public void setEmployeeVerificationId(long employeeVerificationId) {
		model.setEmployeeVerificationId(employeeVerificationId);
	}

	/**
	 * Sets the group ID of this employee verification.
	 *
	 * @param groupId the group ID of this employee verification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining process ID of this employee verification.
	 *
	 * @param joiningProcessId the joining process ID of this employee verification
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the modified date of this employee verification.
	 *
	 * @param modifiedDate the modified date of this employee verification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee verification.
	 *
	 * @param organizationId the organization ID of this employee verification
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this employee verification.
	 *
	 * @param primaryKey the primary key of this employee verification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this employee verification.
	 *
	 * @param remarks the remarks of this employee verification
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the status of this employee verification.
	 *
	 * @param status the status of this employee verification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this employee verification.
	 *
	 * @param userId the user ID of this employee verification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee verification.
	 *
	 * @param userName the user name of this employee verification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee verification.
	 *
	 * @param userUuid the user uuid of this employee verification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the verification date of this employee verification.
	 *
	 * @param verificationDate the verification date of this employee verification
	 */
	@Override
	public void setVerificationDate(Date verificationDate) {
		model.setVerificationDate(verificationDate);
	}

	/**
	 * Sets the verification type ID of this employee verification.
	 *
	 * @param verificationTypeId the verification type ID of this employee verification
	 */
	@Override
	public void setVerificationTypeId(long verificationTypeId) {
		model.setVerificationTypeId(verificationTypeId);
	}

	@Override
	protected EmployeeVerificationWrapper wrap(
		EmployeeVerification employeeVerification) {

		return new EmployeeVerificationWrapper(employeeVerification);
	}

}