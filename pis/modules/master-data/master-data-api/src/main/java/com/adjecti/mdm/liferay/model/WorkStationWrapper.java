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

package com.adjecti.mdm.liferay.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkStation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkStation
 * @generated
 */
public class WorkStationWrapper
	extends BaseModelWrapper<WorkStation>
	implements ModelWrapper<WorkStation>, WorkStation {

	public WorkStationWrapper(WorkStation workStation) {
		super(workStation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workStationId", getWorkStationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("deskNo", getDeskNo());
		attributes.put("extnNo", getExtnNo());
		attributes.put("directNo", getDirectNo());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("cabinNo", getCabinNo());
		attributes.put("floorNo", getFloorNo());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workStationId = (Long)attributes.get("workStationId");

		if (workStationId != null) {
			setWorkStationId(workStationId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String deskNo = (String)attributes.get("deskNo");

		if (deskNo != null) {
			setDeskNo(deskNo);
		}

		String extnNo = (String)attributes.get("extnNo");

		if (extnNo != null) {
			setExtnNo(extnNo);
		}

		String directNo = (String)attributes.get("directNo");

		if (directNo != null) {
			setDirectNo(directNo);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		String cabinNo = (String)attributes.get("cabinNo");

		if (cabinNo != null) {
			setCabinNo(cabinNo);
		}

		String floorNo = (String)attributes.get("floorNo");

		if (floorNo != null) {
			setFloorNo(floorNo);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the cabin no of this work station.
	 *
	 * @return the cabin no of this work station
	 */
	@Override
	public String getCabinNo() {
		return model.getCabinNo();
	}

	/**
	 * Returns the code of this work station.
	 *
	 * @return the code of this work station
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this work station.
	 *
	 * @return the company ID of this work station
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this work station.
	 *
	 * @return the create date of this work station
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this work station.
	 *
	 * @return the deleted of this work station
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the desk no of this work station.
	 *
	 * @return the desk no of this work station
	 */
	@Override
	public String getDeskNo() {
		return model.getDeskNo();
	}

	/**
	 * Returns the direct no of this work station.
	 *
	 * @return the direct no of this work station
	 */
	@Override
	public String getDirectNo() {
		return model.getDirectNo();
	}

	/**
	 * Returns the extn no of this work station.
	 *
	 * @return the extn no of this work station
	 */
	@Override
	public String getExtnNo() {
		return model.getExtnNo();
	}

	/**
	 * Returns the floor no of this work station.
	 *
	 * @return the floor no of this work station
	 */
	@Override
	public String getFloorNo() {
		return model.getFloorNo();
	}

	/**
	 * Returns the group ID of this work station.
	 *
	 * @return the group ID of this work station
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this work station.
	 *
	 * @return the modified date of this work station
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone no of this work station.
	 *
	 * @return the phone no of this work station
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the primary key of this work station.
	 *
	 * @return the primary key of this work station
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this work station.
	 *
	 * @return the status of this work station
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this work station.
	 *
	 * @return the user ID of this work station
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this work station.
	 *
	 * @return the user name of this work station
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this work station.
	 *
	 * @return the user uuid of this work station
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the work station ID of this work station.
	 *
	 * @return the work station ID of this work station
	 */
	@Override
	public long getWorkStationId() {
		return model.getWorkStationId();
	}

	/**
	 * Returns <code>true</code> if this work station is deleted.
	 *
	 * @return <code>true</code> if this work station is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cabin no of this work station.
	 *
	 * @param cabinNo the cabin no of this work station
	 */
	@Override
	public void setCabinNo(String cabinNo) {
		model.setCabinNo(cabinNo);
	}

	/**
	 * Sets the code of this work station.
	 *
	 * @param code the code of this work station
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this work station.
	 *
	 * @param companyId the company ID of this work station
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this work station.
	 *
	 * @param createDate the create date of this work station
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this work station is deleted.
	 *
	 * @param deleted the deleted of this work station
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the desk no of this work station.
	 *
	 * @param deskNo the desk no of this work station
	 */
	@Override
	public void setDeskNo(String deskNo) {
		model.setDeskNo(deskNo);
	}

	/**
	 * Sets the direct no of this work station.
	 *
	 * @param directNo the direct no of this work station
	 */
	@Override
	public void setDirectNo(String directNo) {
		model.setDirectNo(directNo);
	}

	/**
	 * Sets the extn no of this work station.
	 *
	 * @param extnNo the extn no of this work station
	 */
	@Override
	public void setExtnNo(String extnNo) {
		model.setExtnNo(extnNo);
	}

	/**
	 * Sets the floor no of this work station.
	 *
	 * @param floorNo the floor no of this work station
	 */
	@Override
	public void setFloorNo(String floorNo) {
		model.setFloorNo(floorNo);
	}

	/**
	 * Sets the group ID of this work station.
	 *
	 * @param groupId the group ID of this work station
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this work station.
	 *
	 * @param modifiedDate the modified date of this work station
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone no of this work station.
	 *
	 * @param phoneNo the phone no of this work station
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the primary key of this work station.
	 *
	 * @param primaryKey the primary key of this work station
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this work station.
	 *
	 * @param status the status of this work station
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this work station.
	 *
	 * @param userId the user ID of this work station
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this work station.
	 *
	 * @param userName the user name of this work station
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this work station.
	 *
	 * @param userUuid the user uuid of this work station
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the work station ID of this work station.
	 *
	 * @param workStationId the work station ID of this work station
	 */
	@Override
	public void setWorkStationId(long workStationId) {
		model.setWorkStationId(workStationId);
	}

	@Override
	protected WorkStationWrapper wrap(WorkStation workStation) {
		return new WorkStationWrapper(workStation);
	}

}