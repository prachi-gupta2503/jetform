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
 * This class is a wrapper for {@link EmployeeWorkstation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstation
 * @generated
 */
public class EmployeeWorkstationWrapper
	extends BaseModelWrapper<EmployeeWorkstation>
	implements EmployeeWorkstation, ModelWrapper<EmployeeWorkstation> {

	public EmployeeWorkstationWrapper(EmployeeWorkstation employeeWorkstation) {
		super(employeeWorkstation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeWorkstationId", getEmployeeWorkstationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromMonth", getFromMonth());
		attributes.put("toMonth", getToMonth());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("workStationId", getWorkStationId());
		attributes.put("deskNo", getDeskNo());
		attributes.put("extnNo", getExtnNo());
		attributes.put("directNo", getDirectNo());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("cabinNo", getCabinNo());
		attributes.put("floorNo", getFloorNo());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeWorkstationId = (Long)attributes.get(
			"employeeWorkstationId");

		if (employeeWorkstationId != null) {
			setEmployeeWorkstationId(employeeWorkstationId);
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

		Date fromMonth = (Date)attributes.get("fromMonth");

		if (fromMonth != null) {
			setFromMonth(fromMonth);
		}

		Date toMonth = (Date)attributes.get("toMonth");

		if (toMonth != null) {
			setToMonth(toMonth);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long workStationId = (Long)attributes.get("workStationId");

		if (workStationId != null) {
			setWorkStationId(workStationId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee workstation.
	 *
	 * @return the active of this employee workstation
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the cabin no of this employee workstation.
	 *
	 * @return the cabin no of this employee workstation
	 */
	@Override
	public String getCabinNo() {
		return model.getCabinNo();
	}

	/**
	 * Returns the company ID of this employee workstation.
	 *
	 * @return the company ID of this employee workstation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee workstation.
	 *
	 * @return the create date of this employee workstation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the desk no of this employee workstation.
	 *
	 * @return the desk no of this employee workstation
	 */
	@Override
	public String getDeskNo() {
		return model.getDeskNo();
	}

	/**
	 * Returns the direct no of this employee workstation.
	 *
	 * @return the direct no of this employee workstation
	 */
	@Override
	public String getDirectNo() {
		return model.getDirectNo();
	}

	/**
	 * Returns the employee ID of this employee workstation.
	 *
	 * @return the employee ID of this employee workstation
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee workstation ID of this employee workstation.
	 *
	 * @return the employee workstation ID of this employee workstation
	 */
	@Override
	public long getEmployeeWorkstationId() {
		return model.getEmployeeWorkstationId();
	}

	/**
	 * Returns the extn no of this employee workstation.
	 *
	 * @return the extn no of this employee workstation
	 */
	@Override
	public String getExtnNo() {
		return model.getExtnNo();
	}

	/**
	 * Returns the floor no of this employee workstation.
	 *
	 * @return the floor no of this employee workstation
	 */
	@Override
	public String getFloorNo() {
		return model.getFloorNo();
	}

	/**
	 * Returns the from month of this employee workstation.
	 *
	 * @return the from month of this employee workstation
	 */
	@Override
	public Date getFromMonth() {
		return model.getFromMonth();
	}

	/**
	 * Returns the group ID of this employee workstation.
	 *
	 * @return the group ID of this employee workstation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee workstation.
	 *
	 * @return the modified date of this employee workstation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone no of this employee workstation.
	 *
	 * @return the phone no of this employee workstation
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the primary key of this employee workstation.
	 *
	 * @return the primary key of this employee workstation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee workstation.
	 *
	 * @return the status of this employee workstation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to month of this employee workstation.
	 *
	 * @return the to month of this employee workstation
	 */
	@Override
	public Date getToMonth() {
		return model.getToMonth();
	}

	/**
	 * Returns the user ID of this employee workstation.
	 *
	 * @return the user ID of this employee workstation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee workstation.
	 *
	 * @return the user name of this employee workstation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee workstation.
	 *
	 * @return the user uuid of this employee workstation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the work station ID of this employee workstation.
	 *
	 * @return the work station ID of this employee workstation
	 */
	@Override
	public long getWorkStationId() {
		return model.getWorkStationId();
	}

	/**
	 * Returns <code>true</code> if this employee workstation is active.
	 *
	 * @return <code>true</code> if this employee workstation is active; <code>false</code> otherwise
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
	 * Sets whether this employee workstation is active.
	 *
	 * @param active the active of this employee workstation
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the cabin no of this employee workstation.
	 *
	 * @param cabinNo the cabin no of this employee workstation
	 */
	@Override
	public void setCabinNo(String cabinNo) {
		model.setCabinNo(cabinNo);
	}

	/**
	 * Sets the company ID of this employee workstation.
	 *
	 * @param companyId the company ID of this employee workstation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee workstation.
	 *
	 * @param createDate the create date of this employee workstation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the desk no of this employee workstation.
	 *
	 * @param deskNo the desk no of this employee workstation
	 */
	@Override
	public void setDeskNo(String deskNo) {
		model.setDeskNo(deskNo);
	}

	/**
	 * Sets the direct no of this employee workstation.
	 *
	 * @param directNo the direct no of this employee workstation
	 */
	@Override
	public void setDirectNo(String directNo) {
		model.setDirectNo(directNo);
	}

	/**
	 * Sets the employee ID of this employee workstation.
	 *
	 * @param employeeId the employee ID of this employee workstation
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee workstation ID of this employee workstation.
	 *
	 * @param employeeWorkstationId the employee workstation ID of this employee workstation
	 */
	@Override
	public void setEmployeeWorkstationId(long employeeWorkstationId) {
		model.setEmployeeWorkstationId(employeeWorkstationId);
	}

	/**
	 * Sets the extn no of this employee workstation.
	 *
	 * @param extnNo the extn no of this employee workstation
	 */
	@Override
	public void setExtnNo(String extnNo) {
		model.setExtnNo(extnNo);
	}

	/**
	 * Sets the floor no of this employee workstation.
	 *
	 * @param floorNo the floor no of this employee workstation
	 */
	@Override
	public void setFloorNo(String floorNo) {
		model.setFloorNo(floorNo);
	}

	/**
	 * Sets the from month of this employee workstation.
	 *
	 * @param fromMonth the from month of this employee workstation
	 */
	@Override
	public void setFromMonth(Date fromMonth) {
		model.setFromMonth(fromMonth);
	}

	/**
	 * Sets the group ID of this employee workstation.
	 *
	 * @param groupId the group ID of this employee workstation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee workstation.
	 *
	 * @param modifiedDate the modified date of this employee workstation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone no of this employee workstation.
	 *
	 * @param phoneNo the phone no of this employee workstation
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the primary key of this employee workstation.
	 *
	 * @param primaryKey the primary key of this employee workstation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee workstation.
	 *
	 * @param status the status of this employee workstation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to month of this employee workstation.
	 *
	 * @param toMonth the to month of this employee workstation
	 */
	@Override
	public void setToMonth(Date toMonth) {
		model.setToMonth(toMonth);
	}

	/**
	 * Sets the user ID of this employee workstation.
	 *
	 * @param userId the user ID of this employee workstation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee workstation.
	 *
	 * @param userName the user name of this employee workstation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee workstation.
	 *
	 * @param userUuid the user uuid of this employee workstation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the work station ID of this employee workstation.
	 *
	 * @param workStationId the work station ID of this employee workstation
	 */
	@Override
	public void setWorkStationId(long workStationId) {
		model.setWorkStationId(workStationId);
	}

	@Override
	protected EmployeeWorkstationWrapper wrap(
		EmployeeWorkstation employeeWorkstation) {

		return new EmployeeWorkstationWrapper(employeeWorkstation);
	}

}