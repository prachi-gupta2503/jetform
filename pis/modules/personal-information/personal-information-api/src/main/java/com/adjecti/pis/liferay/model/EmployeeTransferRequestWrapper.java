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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeTransferRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferRequest
 * @generated
 */
public class EmployeeTransferRequestWrapper
	extends BaseModelWrapper<EmployeeTransferRequest>
	implements EmployeeTransferRequest, ModelWrapper<EmployeeTransferRequest> {

	public EmployeeTransferRequestWrapper(
		EmployeeTransferRequest employeeTransferRequest) {

		super(employeeTransferRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"employeeTransferRequestId", getEmployeeTransferRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("transferDate", getTransferDate());
		attributes.put("startDateInNewUnit", getStartDateInNewUnit());
		attributes.put("lastDateInCurrentUnit", getLastDateInCurrentUnit());
		attributes.put("officeOrderNo", getOfficeOrderNo());
		attributes.put("processFileId", getProcessFileId());
		attributes.put("processFileNo", getProcessFileNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long employeeTransferRequestId = (Long)attributes.get(
			"employeeTransferRequestId");

		if (employeeTransferRequestId != null) {
			setEmployeeTransferRequestId(employeeTransferRequestId);
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

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String transferDate = (String)attributes.get("transferDate");

		if (transferDate != null) {
			setTransferDate(transferDate);
		}

		Date startDateInNewUnit = (Date)attributes.get("startDateInNewUnit");

		if (startDateInNewUnit != null) {
			setStartDateInNewUnit(startDateInNewUnit);
		}

		Date lastDateInCurrentUnit = (Date)attributes.get(
			"lastDateInCurrentUnit");

		if (lastDateInCurrentUnit != null) {
			setLastDateInCurrentUnit(lastDateInCurrentUnit);
		}

		String officeOrderNo = (String)attributes.get("officeOrderNo");

		if (officeOrderNo != null) {
			setOfficeOrderNo(officeOrderNo);
		}

		Long processFileId = (Long)attributes.get("processFileId");

		if (processFileId != null) {
			setProcessFileId(processFileId);
		}

		String processFileNo = (String)attributes.get("processFileNo");

		if (processFileNo != null) {
			setProcessFileNo(processFileNo);
		}
	}

	/**
	 * Returns the company ID of this employee transfer request.
	 *
	 * @return the company ID of this employee transfer request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee transfer request.
	 *
	 * @return the create date of this employee transfer request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee transfer request.
	 *
	 * @return the employee ID of this employee transfer request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee transfer request ID of this employee transfer request.
	 *
	 * @return the employee transfer request ID of this employee transfer request
	 */
	@Override
	public long getEmployeeTransferRequestId() {
		return model.getEmployeeTransferRequestId();
	}

	/**
	 * Returns the group ID of this employee transfer request.
	 *
	 * @return the group ID of this employee transfer request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last date in current unit of this employee transfer request.
	 *
	 * @return the last date in current unit of this employee transfer request
	 */
	@Override
	public Date getLastDateInCurrentUnit() {
		return model.getLastDateInCurrentUnit();
	}

	/**
	 * Returns the modified date of this employee transfer request.
	 *
	 * @return the modified date of this employee transfer request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office order no of this employee transfer request.
	 *
	 * @return the office order no of this employee transfer request
	 */
	@Override
	public String getOfficeOrderNo() {
		return model.getOfficeOrderNo();
	}

	/**
	 * Returns the organization ID of this employee transfer request.
	 *
	 * @return the organization ID of this employee transfer request
	 */
	@Override
	public Long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this employee transfer request.
	 *
	 * @return the primary key of this employee transfer request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this employee transfer request.
	 *
	 * @return the process file ID of this employee transfer request
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this employee transfer request.
	 *
	 * @return the process file no of this employee transfer request
	 */
	@Override
	public String getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the start date in new unit of this employee transfer request.
	 *
	 * @return the start date in new unit of this employee transfer request
	 */
	@Override
	public Date getStartDateInNewUnit() {
		return model.getStartDateInNewUnit();
	}

	/**
	 * Returns the transfer date of this employee transfer request.
	 *
	 * @return the transfer date of this employee transfer request
	 */
	@Override
	public String getTransferDate() {
		return model.getTransferDate();
	}

	/**
	 * Returns the user ID of this employee transfer request.
	 *
	 * @return the user ID of this employee transfer request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee transfer request.
	 *
	 * @return the user name of this employee transfer request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee transfer request.
	 *
	 * @return the user uuid of this employee transfer request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this employee transfer request.
	 *
	 * @return the uuid of this employee transfer request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employee transfer request.
	 *
	 * @param companyId the company ID of this employee transfer request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee transfer request.
	 *
	 * @param createDate the create date of this employee transfer request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee transfer request.
	 *
	 * @param employeeId the employee ID of this employee transfer request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee transfer request ID of this employee transfer request.
	 *
	 * @param employeeTransferRequestId the employee transfer request ID of this employee transfer request
	 */
	@Override
	public void setEmployeeTransferRequestId(long employeeTransferRequestId) {
		model.setEmployeeTransferRequestId(employeeTransferRequestId);
	}

	/**
	 * Sets the group ID of this employee transfer request.
	 *
	 * @param groupId the group ID of this employee transfer request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last date in current unit of this employee transfer request.
	 *
	 * @param lastDateInCurrentUnit the last date in current unit of this employee transfer request
	 */
	@Override
	public void setLastDateInCurrentUnit(Date lastDateInCurrentUnit) {
		model.setLastDateInCurrentUnit(lastDateInCurrentUnit);
	}

	/**
	 * Sets the modified date of this employee transfer request.
	 *
	 * @param modifiedDate the modified date of this employee transfer request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office order no of this employee transfer request.
	 *
	 * @param officeOrderNo the office order no of this employee transfer request
	 */
	@Override
	public void setOfficeOrderNo(String officeOrderNo) {
		model.setOfficeOrderNo(officeOrderNo);
	}

	/**
	 * Sets the organization ID of this employee transfer request.
	 *
	 * @param organizationId the organization ID of this employee transfer request
	 */
	@Override
	public void setOrganizationId(Long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this employee transfer request.
	 *
	 * @param primaryKey the primary key of this employee transfer request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this employee transfer request.
	 *
	 * @param processFileId the process file ID of this employee transfer request
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this employee transfer request.
	 *
	 * @param processFileNo the process file no of this employee transfer request
	 */
	@Override
	public void setProcessFileNo(String processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the start date in new unit of this employee transfer request.
	 *
	 * @param startDateInNewUnit the start date in new unit of this employee transfer request
	 */
	@Override
	public void setStartDateInNewUnit(Date startDateInNewUnit) {
		model.setStartDateInNewUnit(startDateInNewUnit);
	}

	/**
	 * Sets the transfer date of this employee transfer request.
	 *
	 * @param transferDate the transfer date of this employee transfer request
	 */
	@Override
	public void setTransferDate(String transferDate) {
		model.setTransferDate(transferDate);
	}

	/**
	 * Sets the user ID of this employee transfer request.
	 *
	 * @param userId the user ID of this employee transfer request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee transfer request.
	 *
	 * @param userName the user name of this employee transfer request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee transfer request.
	 *
	 * @param userUuid the user uuid of this employee transfer request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this employee transfer request.
	 *
	 * @param uuid the uuid of this employee transfer request
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EmployeeTransferRequestWrapper wrap(
		EmployeeTransferRequest employeeTransferRequest) {

		return new EmployeeTransferRequestWrapper(employeeTransferRequest);
	}

}