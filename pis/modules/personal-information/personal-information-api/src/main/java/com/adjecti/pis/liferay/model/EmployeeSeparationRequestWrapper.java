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
 * This class is a wrapper for {@link EmployeeSeparationRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSeparationRequest
 * @generated
 */
public class EmployeeSeparationRequestWrapper
	extends BaseModelWrapper<EmployeeSeparationRequest>
	implements EmployeeSeparationRequest,
			   ModelWrapper<EmployeeSeparationRequest> {

	public EmployeeSeparationRequestWrapper(
		EmployeeSeparationRequest employeeSeparationRequest) {

		super(employeeSeparationRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"employeeSeparationRequestId", getEmployeeSeparationRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("separationMode", getSeparationMode());
		attributes.put("separationDate", getSeparationDate());
		attributes.put("remarks", getRemarks());
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

		Long employeeSeparationRequestId = (Long)attributes.get(
			"employeeSeparationRequestId");

		if (employeeSeparationRequestId != null) {
			setEmployeeSeparationRequestId(employeeSeparationRequestId);
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

		String separationMode = (String)attributes.get("separationMode");

		if (separationMode != null) {
			setSeparationMode(separationMode);
		}

		Date separationDate = (Date)attributes.get("separationDate");

		if (separationDate != null) {
			setSeparationDate(separationDate);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
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
	 * Returns the company ID of this employee separation request.
	 *
	 * @return the company ID of this employee separation request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee separation request.
	 *
	 * @return the create date of this employee separation request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee separation request.
	 *
	 * @return the employee ID of this employee separation request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee separation request ID of this employee separation request.
	 *
	 * @return the employee separation request ID of this employee separation request
	 */
	@Override
	public long getEmployeeSeparationRequestId() {
		return model.getEmployeeSeparationRequestId();
	}

	/**
	 * Returns the group ID of this employee separation request.
	 *
	 * @return the group ID of this employee separation request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee separation request.
	 *
	 * @return the modified date of this employee separation request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office order no of this employee separation request.
	 *
	 * @return the office order no of this employee separation request
	 */
	@Override
	public String getOfficeOrderNo() {
		return model.getOfficeOrderNo();
	}

	/**
	 * Returns the primary key of this employee separation request.
	 *
	 * @return the primary key of this employee separation request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this employee separation request.
	 *
	 * @return the process file ID of this employee separation request
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this employee separation request.
	 *
	 * @return the process file no of this employee separation request
	 */
	@Override
	public String getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the remarks of this employee separation request.
	 *
	 * @return the remarks of this employee separation request
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the separation date of this employee separation request.
	 *
	 * @return the separation date of this employee separation request
	 */
	@Override
	public Date getSeparationDate() {
		return model.getSeparationDate();
	}

	/**
	 * Returns the separation mode of this employee separation request.
	 *
	 * @return the separation mode of this employee separation request
	 */
	@Override
	public String getSeparationMode() {
		return model.getSeparationMode();
	}

	/**
	 * Returns the user ID of this employee separation request.
	 *
	 * @return the user ID of this employee separation request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee separation request.
	 *
	 * @return the user name of this employee separation request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee separation request.
	 *
	 * @return the user uuid of this employee separation request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this employee separation request.
	 *
	 * @return the uuid of this employee separation request
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
	 * Sets the company ID of this employee separation request.
	 *
	 * @param companyId the company ID of this employee separation request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee separation request.
	 *
	 * @param createDate the create date of this employee separation request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee separation request.
	 *
	 * @param employeeId the employee ID of this employee separation request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee separation request ID of this employee separation request.
	 *
	 * @param employeeSeparationRequestId the employee separation request ID of this employee separation request
	 */
	@Override
	public void setEmployeeSeparationRequestId(
		long employeeSeparationRequestId) {

		model.setEmployeeSeparationRequestId(employeeSeparationRequestId);
	}

	/**
	 * Sets the group ID of this employee separation request.
	 *
	 * @param groupId the group ID of this employee separation request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee separation request.
	 *
	 * @param modifiedDate the modified date of this employee separation request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office order no of this employee separation request.
	 *
	 * @param officeOrderNo the office order no of this employee separation request
	 */
	@Override
	public void setOfficeOrderNo(String officeOrderNo) {
		model.setOfficeOrderNo(officeOrderNo);
	}

	/**
	 * Sets the primary key of this employee separation request.
	 *
	 * @param primaryKey the primary key of this employee separation request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this employee separation request.
	 *
	 * @param processFileId the process file ID of this employee separation request
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this employee separation request.
	 *
	 * @param processFileNo the process file no of this employee separation request
	 */
	@Override
	public void setProcessFileNo(String processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the remarks of this employee separation request.
	 *
	 * @param remarks the remarks of this employee separation request
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the separation date of this employee separation request.
	 *
	 * @param separationDate the separation date of this employee separation request
	 */
	@Override
	public void setSeparationDate(Date separationDate) {
		model.setSeparationDate(separationDate);
	}

	/**
	 * Sets the separation mode of this employee separation request.
	 *
	 * @param separationMode the separation mode of this employee separation request
	 */
	@Override
	public void setSeparationMode(String separationMode) {
		model.setSeparationMode(separationMode);
	}

	/**
	 * Sets the user ID of this employee separation request.
	 *
	 * @param userId the user ID of this employee separation request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee separation request.
	 *
	 * @param userName the user name of this employee separation request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee separation request.
	 *
	 * @param userUuid the user uuid of this employee separation request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this employee separation request.
	 *
	 * @param uuid the uuid of this employee separation request
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
	protected EmployeeSeparationRequestWrapper wrap(
		EmployeeSeparationRequest employeeSeparationRequest) {

		return new EmployeeSeparationRequestWrapper(employeeSeparationRequest);
	}

}