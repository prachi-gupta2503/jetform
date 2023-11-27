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
 * This class is a wrapper for {@link EmployeeBiodata}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBiodata
 * @generated
 */
public class EmployeeBiodataWrapper
	extends BaseModelWrapper<EmployeeBiodata>
	implements EmployeeBiodata, ModelWrapper<EmployeeBiodata> {

	public EmployeeBiodataWrapper(EmployeeBiodata employeeBiodata) {
		super(employeeBiodata);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeBiodataId", getEmployeeBiodataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("biodata", getBiodata());
		attributes.put("biodataFileId", getBiodataFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeBiodataId = (Long)attributes.get("employeeBiodataId");

		if (employeeBiodataId != null) {
			setEmployeeBiodataId(employeeBiodataId);
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

		String biodata = (String)attributes.get("biodata");

		if (biodata != null) {
			setBiodata(biodata);
		}

		Long biodataFileId = (Long)attributes.get("biodataFileId");

		if (biodataFileId != null) {
			setBiodataFileId(biodataFileId);
		}
	}

	/**
	 * Returns the biodata of this employee biodata.
	 *
	 * @return the biodata of this employee biodata
	 */
	@Override
	public String getBiodata() {
		return model.getBiodata();
	}

	/**
	 * Returns the biodata file ID of this employee biodata.
	 *
	 * @return the biodata file ID of this employee biodata
	 */
	@Override
	public long getBiodataFileId() {
		return model.getBiodataFileId();
	}

	/**
	 * Returns the company ID of this employee biodata.
	 *
	 * @return the company ID of this employee biodata
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee biodata.
	 *
	 * @return the create date of this employee biodata
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee biodata ID of this employee biodata.
	 *
	 * @return the employee biodata ID of this employee biodata
	 */
	@Override
	public long getEmployeeBiodataId() {
		return model.getEmployeeBiodataId();
	}

	/**
	 * Returns the employee ID of this employee biodata.
	 *
	 * @return the employee ID of this employee biodata
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee biodata.
	 *
	 * @return the group ID of this employee biodata
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee biodata.
	 *
	 * @return the modified date of this employee biodata
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee biodata.
	 *
	 * @return the primary key of this employee biodata
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee biodata.
	 *
	 * @return the user ID of this employee biodata
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee biodata.
	 *
	 * @return the user name of this employee biodata
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee biodata.
	 *
	 * @return the user uuid of this employee biodata
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the biodata of this employee biodata.
	 *
	 * @param biodata the biodata of this employee biodata
	 */
	@Override
	public void setBiodata(String biodata) {
		model.setBiodata(biodata);
	}

	/**
	 * Sets the biodata file ID of this employee biodata.
	 *
	 * @param biodataFileId the biodata file ID of this employee biodata
	 */
	@Override
	public void setBiodataFileId(long biodataFileId) {
		model.setBiodataFileId(biodataFileId);
	}

	/**
	 * Sets the company ID of this employee biodata.
	 *
	 * @param companyId the company ID of this employee biodata
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee biodata.
	 *
	 * @param createDate the create date of this employee biodata
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee biodata ID of this employee biodata.
	 *
	 * @param employeeBiodataId the employee biodata ID of this employee biodata
	 */
	@Override
	public void setEmployeeBiodataId(long employeeBiodataId) {
		model.setEmployeeBiodataId(employeeBiodataId);
	}

	/**
	 * Sets the employee ID of this employee biodata.
	 *
	 * @param employeeId the employee ID of this employee biodata
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee biodata.
	 *
	 * @param groupId the group ID of this employee biodata
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee biodata.
	 *
	 * @param modifiedDate the modified date of this employee biodata
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee biodata.
	 *
	 * @param primaryKey the primary key of this employee biodata
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee biodata.
	 *
	 * @param userId the user ID of this employee biodata
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee biodata.
	 *
	 * @param userName the user name of this employee biodata
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee biodata.
	 *
	 * @param userUuid the user uuid of this employee biodata
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeBiodataWrapper wrap(EmployeeBiodata employeeBiodata) {
		return new EmployeeBiodataWrapper(employeeBiodata);
	}

}