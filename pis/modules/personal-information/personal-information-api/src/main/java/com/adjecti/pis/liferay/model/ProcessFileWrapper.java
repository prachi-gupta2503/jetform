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
 * This class is a wrapper for {@link ProcessFile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessFile
 * @generated
 */
public class ProcessFileWrapper
	extends BaseModelWrapper<ProcessFile>
	implements ModelWrapper<ProcessFile>, ProcessFile {

	public ProcessFileWrapper(ProcessFile processFile) {
		super(processFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("processFileId", getProcessFileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("processFileNo", getProcessFileNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long processFileId = (Long)attributes.get("processFileId");

		if (processFileId != null) {
			setProcessFileId(processFileId);
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

		Long processFileNo = (Long)attributes.get("processFileNo");

		if (processFileNo != null) {
			setProcessFileNo(processFileNo);
		}
	}

	/**
	 * Returns the company ID of this process file.
	 *
	 * @return the company ID of this process file
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this process file.
	 *
	 * @return the create date of this process file
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this process file.
	 *
	 * @return the employee ID of this process file
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this process file.
	 *
	 * @return the group ID of this process file
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this process file.
	 *
	 * @return the modified date of this process file
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this process file.
	 *
	 * @return the primary key of this process file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this process file.
	 *
	 * @return the process file ID of this process file
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this process file.
	 *
	 * @return the process file no of this process file
	 */
	@Override
	public long getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the user ID of this process file.
	 *
	 * @return the user ID of this process file
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this process file.
	 *
	 * @return the user name of this process file
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this process file.
	 *
	 * @return the user uuid of this process file
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this process file.
	 *
	 * @return the uuid of this process file
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
	 * Sets the company ID of this process file.
	 *
	 * @param companyId the company ID of this process file
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this process file.
	 *
	 * @param createDate the create date of this process file
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this process file.
	 *
	 * @param employeeId the employee ID of this process file
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this process file.
	 *
	 * @param groupId the group ID of this process file
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this process file.
	 *
	 * @param modifiedDate the modified date of this process file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this process file.
	 *
	 * @param primaryKey the primary key of this process file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this process file.
	 *
	 * @param processFileId the process file ID of this process file
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this process file.
	 *
	 * @param processFileNo the process file no of this process file
	 */
	@Override
	public void setProcessFileNo(long processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the user ID of this process file.
	 *
	 * @param userId the user ID of this process file
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this process file.
	 *
	 * @param userName the user name of this process file
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this process file.
	 *
	 * @param userUuid the user uuid of this process file
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this process file.
	 *
	 * @param uuid the uuid of this process file
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
	protected ProcessFileWrapper wrap(ProcessFile processFile) {
		return new ProcessFileWrapper(processFile);
	}

}