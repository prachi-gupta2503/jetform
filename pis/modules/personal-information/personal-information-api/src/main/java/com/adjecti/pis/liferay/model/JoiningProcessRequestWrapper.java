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
 * This class is a wrapper for {@link JoiningProcessRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessRequest
 * @generated
 */
public class JoiningProcessRequestWrapper
	extends BaseModelWrapper<JoiningProcessRequest>
	implements JoiningProcessRequest, ModelWrapper<JoiningProcessRequest> {

	public JoiningProcessRequestWrapper(
		JoiningProcessRequest joiningProcessRequest) {

		super(joiningProcessRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("joiningProcessRequestId", getJoiningProcessRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("processFileId", getProcessFileId());
		attributes.put("processFileNo", getProcessFileNo());
		attributes.put("officeOrderNo", getOfficeOrderNo());
		attributes.put("doPart1Content", getDoPart1Content());
		attributes.put("doPart1FileId", getDoPart1FileId());
		attributes.put("doPart2Content", getDoPart2Content());
		attributes.put("doPart2FileId", getDoPart2FileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long joiningProcessRequestId = (Long)attributes.get(
			"joiningProcessRequestId");

		if (joiningProcessRequestId != null) {
			setJoiningProcessRequestId(joiningProcessRequestId);
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

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String doPart1Content = (String)attributes.get("doPart1Content");

		if (doPart1Content != null) {
			setDoPart1Content(doPart1Content);
		}

		Long doPart1FileId = (Long)attributes.get("doPart1FileId");

		if (doPart1FileId != null) {
			setDoPart1FileId(doPart1FileId);
		}

		String doPart2Content = (String)attributes.get("doPart2Content");

		if (doPart2Content != null) {
			setDoPart2Content(doPart2Content);
		}

		Long doPart2FileId = (Long)attributes.get("doPart2FileId");

		if (doPart2FileId != null) {
			setDoPart2FileId(doPart2FileId);
		}
	}

	/**
	 * Returns the company ID of this joining process request.
	 *
	 * @return the company ID of this joining process request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this joining process request.
	 *
	 * @return the create date of this joining process request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the do part1 content of this joining process request.
	 *
	 * @return the do part1 content of this joining process request
	 */
	@Override
	public String getDoPart1Content() {
		return model.getDoPart1Content();
	}

	/**
	 * Returns the do part1 file ID of this joining process request.
	 *
	 * @return the do part1 file ID of this joining process request
	 */
	@Override
	public long getDoPart1FileId() {
		return model.getDoPart1FileId();
	}

	/**
	 * Returns the do part2 content of this joining process request.
	 *
	 * @return the do part2 content of this joining process request
	 */
	@Override
	public String getDoPart2Content() {
		return model.getDoPart2Content();
	}

	/**
	 * Returns the do part2 file ID of this joining process request.
	 *
	 * @return the do part2 file ID of this joining process request
	 */
	@Override
	public long getDoPart2FileId() {
		return model.getDoPart2FileId();
	}

	/**
	 * Returns the employee ID of this joining process request.
	 *
	 * @return the employee ID of this joining process request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this joining process request.
	 *
	 * @return the group ID of this joining process request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining process ID of this joining process request.
	 *
	 * @return the joining process ID of this joining process request
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the joining process request ID of this joining process request.
	 *
	 * @return the joining process request ID of this joining process request
	 */
	@Override
	public long getJoiningProcessRequestId() {
		return model.getJoiningProcessRequestId();
	}

	/**
	 * Returns the modified date of this joining process request.
	 *
	 * @return the modified date of this joining process request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office order no of this joining process request.
	 *
	 * @return the office order no of this joining process request
	 */
	@Override
	public String getOfficeOrderNo() {
		return model.getOfficeOrderNo();
	}

	/**
	 * Returns the primary key of this joining process request.
	 *
	 * @return the primary key of this joining process request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this joining process request.
	 *
	 * @return the process file ID of this joining process request
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this joining process request.
	 *
	 * @return the process file no of this joining process request
	 */
	@Override
	public String getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the user ID of this joining process request.
	 *
	 * @return the user ID of this joining process request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this joining process request.
	 *
	 * @return the user name of this joining process request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this joining process request.
	 *
	 * @return the user uuid of this joining process request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this joining process request.
	 *
	 * @return the uuid of this joining process request
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
	 * Sets the company ID of this joining process request.
	 *
	 * @param companyId the company ID of this joining process request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this joining process request.
	 *
	 * @param createDate the create date of this joining process request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the do part1 content of this joining process request.
	 *
	 * @param doPart1Content the do part1 content of this joining process request
	 */
	@Override
	public void setDoPart1Content(String doPart1Content) {
		model.setDoPart1Content(doPart1Content);
	}

	/**
	 * Sets the do part1 file ID of this joining process request.
	 *
	 * @param doPart1FileId the do part1 file ID of this joining process request
	 */
	@Override
	public void setDoPart1FileId(long doPart1FileId) {
		model.setDoPart1FileId(doPart1FileId);
	}

	/**
	 * Sets the do part2 content of this joining process request.
	 *
	 * @param doPart2Content the do part2 content of this joining process request
	 */
	@Override
	public void setDoPart2Content(String doPart2Content) {
		model.setDoPart2Content(doPart2Content);
	}

	/**
	 * Sets the do part2 file ID of this joining process request.
	 *
	 * @param doPart2FileId the do part2 file ID of this joining process request
	 */
	@Override
	public void setDoPart2FileId(long doPart2FileId) {
		model.setDoPart2FileId(doPart2FileId);
	}

	/**
	 * Sets the employee ID of this joining process request.
	 *
	 * @param employeeId the employee ID of this joining process request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this joining process request.
	 *
	 * @param groupId the group ID of this joining process request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining process ID of this joining process request.
	 *
	 * @param joiningProcessId the joining process ID of this joining process request
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the joining process request ID of this joining process request.
	 *
	 * @param joiningProcessRequestId the joining process request ID of this joining process request
	 */
	@Override
	public void setJoiningProcessRequestId(long joiningProcessRequestId) {
		model.setJoiningProcessRequestId(joiningProcessRequestId);
	}

	/**
	 * Sets the modified date of this joining process request.
	 *
	 * @param modifiedDate the modified date of this joining process request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office order no of this joining process request.
	 *
	 * @param officeOrderNo the office order no of this joining process request
	 */
	@Override
	public void setOfficeOrderNo(String officeOrderNo) {
		model.setOfficeOrderNo(officeOrderNo);
	}

	/**
	 * Sets the primary key of this joining process request.
	 *
	 * @param primaryKey the primary key of this joining process request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this joining process request.
	 *
	 * @param processFileId the process file ID of this joining process request
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this joining process request.
	 *
	 * @param processFileNo the process file no of this joining process request
	 */
	@Override
	public void setProcessFileNo(String processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the user ID of this joining process request.
	 *
	 * @param userId the user ID of this joining process request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this joining process request.
	 *
	 * @param userName the user name of this joining process request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this joining process request.
	 *
	 * @param userUuid the user uuid of this joining process request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this joining process request.
	 *
	 * @param uuid the uuid of this joining process request
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
	protected JoiningProcessRequestWrapper wrap(
		JoiningProcessRequest joiningProcessRequest) {

		return new JoiningProcessRequestWrapper(joiningProcessRequest);
	}

}