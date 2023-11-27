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
 * This class is a wrapper for {@link EmployeeDeputationRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationRequest
 * @generated
 */
public class EmployeeDeputationRequestWrapper
	extends BaseModelWrapper<EmployeeDeputationRequest>
	implements EmployeeDeputationRequest,
			   ModelWrapper<EmployeeDeputationRequest> {

	public EmployeeDeputationRequestWrapper(
		EmployeeDeputationRequest employeeDeputationRequest) {

		super(employeeDeputationRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"employeeDeputationRequestId", getEmployeeDeputationRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("deputationOrganization", getDeputationOrganization());
		attributes.put("deputationAddress", getDeputationAddress());
		attributes.put("deputationCity", getDeputationCity());
		attributes.put("deputationState", getDeputationState());
		attributes.put("deputationStartDate", getDeputationStartDate());
		attributes.put("lastDateInCurrentUnit", getLastDateInCurrentUnit());
		attributes.put("processFileId", getProcessFileId());
		attributes.put("processFileNo", getProcessFileNo());
		attributes.put("officeOrderNo", getOfficeOrderNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long employeeDeputationRequestId = (Long)attributes.get(
			"employeeDeputationRequestId");

		if (employeeDeputationRequestId != null) {
			setEmployeeDeputationRequestId(employeeDeputationRequestId);
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

		String deputationOrganization = (String)attributes.get(
			"deputationOrganization");

		if (deputationOrganization != null) {
			setDeputationOrganization(deputationOrganization);
		}

		String deputationAddress = (String)attributes.get("deputationAddress");

		if (deputationAddress != null) {
			setDeputationAddress(deputationAddress);
		}

		String deputationCity = (String)attributes.get("deputationCity");

		if (deputationCity != null) {
			setDeputationCity(deputationCity);
		}

		String deputationState = (String)attributes.get("deputationState");

		if (deputationState != null) {
			setDeputationState(deputationState);
		}

		Date deputationStartDate = (Date)attributes.get("deputationStartDate");

		if (deputationStartDate != null) {
			setDeputationStartDate(deputationStartDate);
		}

		Date lastDateInCurrentUnit = (Date)attributes.get(
			"lastDateInCurrentUnit");

		if (lastDateInCurrentUnit != null) {
			setLastDateInCurrentUnit(lastDateInCurrentUnit);
		}

		Long processFileId = (Long)attributes.get("processFileId");

		if (processFileId != null) {
			setProcessFileId(processFileId);
		}

		String processFileNo = (String)attributes.get("processFileNo");

		if (processFileNo != null) {
			setProcessFileNo(processFileNo);
		}

		String officeOrderNo = (String)attributes.get("officeOrderNo");

		if (officeOrderNo != null) {
			setOfficeOrderNo(officeOrderNo);
		}
	}

	/**
	 * Returns the company ID of this employee deputation request.
	 *
	 * @return the company ID of this employee deputation request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee deputation request.
	 *
	 * @return the create date of this employee deputation request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deputation address of this employee deputation request.
	 *
	 * @return the deputation address of this employee deputation request
	 */
	@Override
	public String getDeputationAddress() {
		return model.getDeputationAddress();
	}

	/**
	 * Returns the deputation city of this employee deputation request.
	 *
	 * @return the deputation city of this employee deputation request
	 */
	@Override
	public String getDeputationCity() {
		return model.getDeputationCity();
	}

	/**
	 * Returns the deputation organization of this employee deputation request.
	 *
	 * @return the deputation organization of this employee deputation request
	 */
	@Override
	public String getDeputationOrganization() {
		return model.getDeputationOrganization();
	}

	/**
	 * Returns the deputation start date of this employee deputation request.
	 *
	 * @return the deputation start date of this employee deputation request
	 */
	@Override
	public Date getDeputationStartDate() {
		return model.getDeputationStartDate();
	}

	/**
	 * Returns the deputation state of this employee deputation request.
	 *
	 * @return the deputation state of this employee deputation request
	 */
	@Override
	public String getDeputationState() {
		return model.getDeputationState();
	}

	/**
	 * Returns the employee deputation request ID of this employee deputation request.
	 *
	 * @return the employee deputation request ID of this employee deputation request
	 */
	@Override
	public long getEmployeeDeputationRequestId() {
		return model.getEmployeeDeputationRequestId();
	}

	/**
	 * Returns the employee ID of this employee deputation request.
	 *
	 * @return the employee ID of this employee deputation request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee deputation request.
	 *
	 * @return the group ID of this employee deputation request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last date in current unit of this employee deputation request.
	 *
	 * @return the last date in current unit of this employee deputation request
	 */
	@Override
	public Date getLastDateInCurrentUnit() {
		return model.getLastDateInCurrentUnit();
	}

	/**
	 * Returns the modified date of this employee deputation request.
	 *
	 * @return the modified date of this employee deputation request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office order no of this employee deputation request.
	 *
	 * @return the office order no of this employee deputation request
	 */
	@Override
	public String getOfficeOrderNo() {
		return model.getOfficeOrderNo();
	}

	/**
	 * Returns the primary key of this employee deputation request.
	 *
	 * @return the primary key of this employee deputation request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this employee deputation request.
	 *
	 * @return the process file ID of this employee deputation request
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this employee deputation request.
	 *
	 * @return the process file no of this employee deputation request
	 */
	@Override
	public String getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the user ID of this employee deputation request.
	 *
	 * @return the user ID of this employee deputation request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee deputation request.
	 *
	 * @return the user name of this employee deputation request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee deputation request.
	 *
	 * @return the user uuid of this employee deputation request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this employee deputation request.
	 *
	 * @return the uuid of this employee deputation request
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
	 * Sets the company ID of this employee deputation request.
	 *
	 * @param companyId the company ID of this employee deputation request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee deputation request.
	 *
	 * @param createDate the create date of this employee deputation request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deputation address of this employee deputation request.
	 *
	 * @param deputationAddress the deputation address of this employee deputation request
	 */
	@Override
	public void setDeputationAddress(String deputationAddress) {
		model.setDeputationAddress(deputationAddress);
	}

	/**
	 * Sets the deputation city of this employee deputation request.
	 *
	 * @param deputationCity the deputation city of this employee deputation request
	 */
	@Override
	public void setDeputationCity(String deputationCity) {
		model.setDeputationCity(deputationCity);
	}

	/**
	 * Sets the deputation organization of this employee deputation request.
	 *
	 * @param deputationOrganization the deputation organization of this employee deputation request
	 */
	@Override
	public void setDeputationOrganization(String deputationOrganization) {
		model.setDeputationOrganization(deputationOrganization);
	}

	/**
	 * Sets the deputation start date of this employee deputation request.
	 *
	 * @param deputationStartDate the deputation start date of this employee deputation request
	 */
	@Override
	public void setDeputationStartDate(Date deputationStartDate) {
		model.setDeputationStartDate(deputationStartDate);
	}

	/**
	 * Sets the deputation state of this employee deputation request.
	 *
	 * @param deputationState the deputation state of this employee deputation request
	 */
	@Override
	public void setDeputationState(String deputationState) {
		model.setDeputationState(deputationState);
	}

	/**
	 * Sets the employee deputation request ID of this employee deputation request.
	 *
	 * @param employeeDeputationRequestId the employee deputation request ID of this employee deputation request
	 */
	@Override
	public void setEmployeeDeputationRequestId(
		long employeeDeputationRequestId) {

		model.setEmployeeDeputationRequestId(employeeDeputationRequestId);
	}

	/**
	 * Sets the employee ID of this employee deputation request.
	 *
	 * @param employeeId the employee ID of this employee deputation request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee deputation request.
	 *
	 * @param groupId the group ID of this employee deputation request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last date in current unit of this employee deputation request.
	 *
	 * @param lastDateInCurrentUnit the last date in current unit of this employee deputation request
	 */
	@Override
	public void setLastDateInCurrentUnit(Date lastDateInCurrentUnit) {
		model.setLastDateInCurrentUnit(lastDateInCurrentUnit);
	}

	/**
	 * Sets the modified date of this employee deputation request.
	 *
	 * @param modifiedDate the modified date of this employee deputation request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office order no of this employee deputation request.
	 *
	 * @param officeOrderNo the office order no of this employee deputation request
	 */
	@Override
	public void setOfficeOrderNo(String officeOrderNo) {
		model.setOfficeOrderNo(officeOrderNo);
	}

	/**
	 * Sets the primary key of this employee deputation request.
	 *
	 * @param primaryKey the primary key of this employee deputation request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this employee deputation request.
	 *
	 * @param processFileId the process file ID of this employee deputation request
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this employee deputation request.
	 *
	 * @param processFileNo the process file no of this employee deputation request
	 */
	@Override
	public void setProcessFileNo(String processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the user ID of this employee deputation request.
	 *
	 * @param userId the user ID of this employee deputation request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee deputation request.
	 *
	 * @param userName the user name of this employee deputation request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee deputation request.
	 *
	 * @param userUuid the user uuid of this employee deputation request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this employee deputation request.
	 *
	 * @param uuid the uuid of this employee deputation request
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
	protected EmployeeDeputationRequestWrapper wrap(
		EmployeeDeputationRequest employeeDeputationRequest) {

		return new EmployeeDeputationRequestWrapper(employeeDeputationRequest);
	}

}