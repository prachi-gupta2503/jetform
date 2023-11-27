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
 * This class is a wrapper for {@link EmployeeTransfer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransfer
 * @generated
 */
public class EmployeeTransferWrapper
	extends BaseModelWrapper<EmployeeTransfer>
	implements EmployeeTransfer, ModelWrapper<EmployeeTransfer> {

	public EmployeeTransferWrapper(EmployeeTransfer employeeTransfer) {
		super(employeeTransfer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeTransferId", getEmployeeTransferId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("transferDate", getTransferDate());
		attributes.put("designationId", getDesignationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("fromOrganizationId", getFromOrganizationId());
		attributes.put("gradeId", getGradeId());
		attributes.put("gradeModeId", getGradeModeId());
		attributes.put("toOrganizationId", getToOrganizationId());
		attributes.put("transferLetterId", getTransferLetterId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeTransferId = (Long)attributes.get("employeeTransferId");

		if (employeeTransferId != null) {
			setEmployeeTransferId(employeeTransferId);
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

		String personalNo = (String)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		Date transferDate = (Date)attributes.get("transferDate");

		if (transferDate != null) {
			setTransferDate(transferDate);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long fromOrganizationId = (Long)attributes.get("fromOrganizationId");

		if (fromOrganizationId != null) {
			setFromOrganizationId(fromOrganizationId);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		Long gradeModeId = (Long)attributes.get("gradeModeId");

		if (gradeModeId != null) {
			setGradeModeId(gradeModeId);
		}

		Long toOrganizationId = (Long)attributes.get("toOrganizationId");

		if (toOrganizationId != null) {
			setToOrganizationId(toOrganizationId);
		}

		Long transferLetterId = (Long)attributes.get("transferLetterId");

		if (transferLetterId != null) {
			setTransferLetterId(transferLetterId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee transfer.
	 *
	 * @return the active of this employee transfer
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee transfer.
	 *
	 * @return the company ID of this employee transfer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee transfer.
	 *
	 * @return the create date of this employee transfer
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation ID of this employee transfer.
	 *
	 * @return the designation ID of this employee transfer
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the employee ID of this employee transfer.
	 *
	 * @return the employee ID of this employee transfer
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee transfer ID of this employee transfer.
	 *
	 * @return the employee transfer ID of this employee transfer
	 */
	@Override
	public long getEmployeeTransferId() {
		return model.getEmployeeTransferId();
	}

	/**
	 * Returns the from organization ID of this employee transfer.
	 *
	 * @return the from organization ID of this employee transfer
	 */
	@Override
	public long getFromOrganizationId() {
		return model.getFromOrganizationId();
	}

	/**
	 * Returns the grade ID of this employee transfer.
	 *
	 * @return the grade ID of this employee transfer
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the grade mode ID of this employee transfer.
	 *
	 * @return the grade mode ID of this employee transfer
	 */
	@Override
	public long getGradeModeId() {
		return model.getGradeModeId();
	}

	/**
	 * Returns the group ID of this employee transfer.
	 *
	 * @return the group ID of this employee transfer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee transfer.
	 *
	 * @return the modified date of this employee transfer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal no of this employee transfer.
	 *
	 * @return the personal no of this employee transfer
	 */
	@Override
	public String getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the primary key of this employee transfer.
	 *
	 * @return the primary key of this employee transfer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee transfer.
	 *
	 * @return the status of this employee transfer
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to organization ID of this employee transfer.
	 *
	 * @return the to organization ID of this employee transfer
	 */
	@Override
	public long getToOrganizationId() {
		return model.getToOrganizationId();
	}

	/**
	 * Returns the transfer date of this employee transfer.
	 *
	 * @return the transfer date of this employee transfer
	 */
	@Override
	public Date getTransferDate() {
		return model.getTransferDate();
	}

	/**
	 * Returns the transfer letter ID of this employee transfer.
	 *
	 * @return the transfer letter ID of this employee transfer
	 */
	@Override
	public long getTransferLetterId() {
		return model.getTransferLetterId();
	}

	/**
	 * Returns the user ID of this employee transfer.
	 *
	 * @return the user ID of this employee transfer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee transfer.
	 *
	 * @return the user name of this employee transfer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee transfer.
	 *
	 * @return the user uuid of this employee transfer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee transfer is active.
	 *
	 * @return <code>true</code> if this employee transfer is active; <code>false</code> otherwise
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
	 * Sets whether this employee transfer is active.
	 *
	 * @param active the active of this employee transfer
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee transfer.
	 *
	 * @param companyId the company ID of this employee transfer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee transfer.
	 *
	 * @param createDate the create date of this employee transfer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation ID of this employee transfer.
	 *
	 * @param designationId the designation ID of this employee transfer
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the employee ID of this employee transfer.
	 *
	 * @param employeeId the employee ID of this employee transfer
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee transfer ID of this employee transfer.
	 *
	 * @param employeeTransferId the employee transfer ID of this employee transfer
	 */
	@Override
	public void setEmployeeTransferId(long employeeTransferId) {
		model.setEmployeeTransferId(employeeTransferId);
	}

	/**
	 * Sets the from organization ID of this employee transfer.
	 *
	 * @param fromOrganizationId the from organization ID of this employee transfer
	 */
	@Override
	public void setFromOrganizationId(long fromOrganizationId) {
		model.setFromOrganizationId(fromOrganizationId);
	}

	/**
	 * Sets the grade ID of this employee transfer.
	 *
	 * @param gradeId the grade ID of this employee transfer
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the grade mode ID of this employee transfer.
	 *
	 * @param gradeModeId the grade mode ID of this employee transfer
	 */
	@Override
	public void setGradeModeId(long gradeModeId) {
		model.setGradeModeId(gradeModeId);
	}

	/**
	 * Sets the group ID of this employee transfer.
	 *
	 * @param groupId the group ID of this employee transfer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee transfer.
	 *
	 * @param modifiedDate the modified date of this employee transfer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal no of this employee transfer.
	 *
	 * @param personalNo the personal no of this employee transfer
	 */
	@Override
	public void setPersonalNo(String personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets the primary key of this employee transfer.
	 *
	 * @param primaryKey the primary key of this employee transfer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee transfer.
	 *
	 * @param status the status of this employee transfer
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to organization ID of this employee transfer.
	 *
	 * @param toOrganizationId the to organization ID of this employee transfer
	 */
	@Override
	public void setToOrganizationId(long toOrganizationId) {
		model.setToOrganizationId(toOrganizationId);
	}

	/**
	 * Sets the transfer date of this employee transfer.
	 *
	 * @param transferDate the transfer date of this employee transfer
	 */
	@Override
	public void setTransferDate(Date transferDate) {
		model.setTransferDate(transferDate);
	}

	/**
	 * Sets the transfer letter ID of this employee transfer.
	 *
	 * @param transferLetterId the transfer letter ID of this employee transfer
	 */
	@Override
	public void setTransferLetterId(long transferLetterId) {
		model.setTransferLetterId(transferLetterId);
	}

	/**
	 * Sets the user ID of this employee transfer.
	 *
	 * @param userId the user ID of this employee transfer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee transfer.
	 *
	 * @param userName the user name of this employee transfer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee transfer.
	 *
	 * @param userUuid the user uuid of this employee transfer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeTransferWrapper wrap(EmployeeTransfer employeeTransfer) {
		return new EmployeeTransferWrapper(employeeTransfer);
	}

}