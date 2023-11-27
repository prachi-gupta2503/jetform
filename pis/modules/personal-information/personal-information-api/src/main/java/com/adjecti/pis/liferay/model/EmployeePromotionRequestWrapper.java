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
 * This class is a wrapper for {@link EmployeePromotionRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionRequest
 * @generated
 */
public class EmployeePromotionRequestWrapper
	extends BaseModelWrapper<EmployeePromotionRequest>
	implements EmployeePromotionRequest,
			   ModelWrapper<EmployeePromotionRequest> {

	public EmployeePromotionRequestWrapper(
		EmployeePromotionRequest employeePromotionRequest) {

		super(employeePromotionRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"employeePromotionRequestId", getEmployeePromotionRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("designationId", getDesignationId());
		attributes.put("promotionModeId", getPromotionModeId());
		attributes.put("promotionDate", getPromotionDate());
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

		Long employeePromotionRequestId = (Long)attributes.get(
			"employeePromotionRequestId");

		if (employeePromotionRequestId != null) {
			setEmployeePromotionRequestId(employeePromotionRequestId);
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

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long promotionModeId = (Long)attributes.get("promotionModeId");

		if (promotionModeId != null) {
			setPromotionModeId(promotionModeId);
		}

		Date promotionDate = (Date)attributes.get("promotionDate");

		if (promotionDate != null) {
			setPromotionDate(promotionDate);
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
	 * Returns the company ID of this employee promotion request.
	 *
	 * @return the company ID of this employee promotion request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee promotion request.
	 *
	 * @return the create date of this employee promotion request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation ID of this employee promotion request.
	 *
	 * @return the designation ID of this employee promotion request
	 */
	@Override
	public Long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the employee ID of this employee promotion request.
	 *
	 * @return the employee ID of this employee promotion request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee promotion request ID of this employee promotion request.
	 *
	 * @return the employee promotion request ID of this employee promotion request
	 */
	@Override
	public long getEmployeePromotionRequestId() {
		return model.getEmployeePromotionRequestId();
	}

	/**
	 * Returns the group ID of this employee promotion request.
	 *
	 * @return the group ID of this employee promotion request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee promotion request.
	 *
	 * @return the modified date of this employee promotion request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office order no of this employee promotion request.
	 *
	 * @return the office order no of this employee promotion request
	 */
	@Override
	public String getOfficeOrderNo() {
		return model.getOfficeOrderNo();
	}

	/**
	 * Returns the primary key of this employee promotion request.
	 *
	 * @return the primary key of this employee promotion request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this employee promotion request.
	 *
	 * @return the process file ID of this employee promotion request
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this employee promotion request.
	 *
	 * @return the process file no of this employee promotion request
	 */
	@Override
	public String getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the promotion date of this employee promotion request.
	 *
	 * @return the promotion date of this employee promotion request
	 */
	@Override
	public Date getPromotionDate() {
		return model.getPromotionDate();
	}

	/**
	 * Returns the promotion mode ID of this employee promotion request.
	 *
	 * @return the promotion mode ID of this employee promotion request
	 */
	@Override
	public Long getPromotionModeId() {
		return model.getPromotionModeId();
	}

	/**
	 * Returns the user ID of this employee promotion request.
	 *
	 * @return the user ID of this employee promotion request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee promotion request.
	 *
	 * @return the user name of this employee promotion request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee promotion request.
	 *
	 * @return the user uuid of this employee promotion request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this employee promotion request.
	 *
	 * @return the uuid of this employee promotion request
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
	 * Sets the company ID of this employee promotion request.
	 *
	 * @param companyId the company ID of this employee promotion request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee promotion request.
	 *
	 * @param createDate the create date of this employee promotion request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation ID of this employee promotion request.
	 *
	 * @param designationId the designation ID of this employee promotion request
	 */
	@Override
	public void setDesignationId(Long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the employee ID of this employee promotion request.
	 *
	 * @param employeeId the employee ID of this employee promotion request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee promotion request ID of this employee promotion request.
	 *
	 * @param employeePromotionRequestId the employee promotion request ID of this employee promotion request
	 */
	@Override
	public void setEmployeePromotionRequestId(long employeePromotionRequestId) {
		model.setEmployeePromotionRequestId(employeePromotionRequestId);
	}

	/**
	 * Sets the group ID of this employee promotion request.
	 *
	 * @param groupId the group ID of this employee promotion request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee promotion request.
	 *
	 * @param modifiedDate the modified date of this employee promotion request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office order no of this employee promotion request.
	 *
	 * @param officeOrderNo the office order no of this employee promotion request
	 */
	@Override
	public void setOfficeOrderNo(String officeOrderNo) {
		model.setOfficeOrderNo(officeOrderNo);
	}

	/**
	 * Sets the primary key of this employee promotion request.
	 *
	 * @param primaryKey the primary key of this employee promotion request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this employee promotion request.
	 *
	 * @param processFileId the process file ID of this employee promotion request
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this employee promotion request.
	 *
	 * @param processFileNo the process file no of this employee promotion request
	 */
	@Override
	public void setProcessFileNo(String processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the promotion date of this employee promotion request.
	 *
	 * @param promotionDate the promotion date of this employee promotion request
	 */
	@Override
	public void setPromotionDate(Date promotionDate) {
		model.setPromotionDate(promotionDate);
	}

	/**
	 * Sets the promotion mode ID of this employee promotion request.
	 *
	 * @param promotionModeId the promotion mode ID of this employee promotion request
	 */
	@Override
	public void setPromotionModeId(Long promotionModeId) {
		model.setPromotionModeId(promotionModeId);
	}

	/**
	 * Sets the user ID of this employee promotion request.
	 *
	 * @param userId the user ID of this employee promotion request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee promotion request.
	 *
	 * @param userName the user name of this employee promotion request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee promotion request.
	 *
	 * @param userUuid the user uuid of this employee promotion request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this employee promotion request.
	 *
	 * @param uuid the uuid of this employee promotion request
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
	protected EmployeePromotionRequestWrapper wrap(
		EmployeePromotionRequest employeePromotionRequest) {

		return new EmployeePromotionRequestWrapper(employeePromotionRequest);
	}

}