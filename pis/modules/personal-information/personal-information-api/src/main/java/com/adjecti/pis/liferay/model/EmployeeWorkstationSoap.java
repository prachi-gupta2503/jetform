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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeWorkstationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeWorkstationSoap implements Serializable {

	public static EmployeeWorkstationSoap toSoapModel(
		EmployeeWorkstation model) {

		EmployeeWorkstationSoap soapModel = new EmployeeWorkstationSoap();

		soapModel.setEmployeeWorkstationId(model.getEmployeeWorkstationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromMonth(model.getFromMonth());
		soapModel.setToMonth(model.getToMonth());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setWorkStationId(model.getWorkStationId());
		soapModel.setDeskNo(model.getDeskNo());
		soapModel.setExtnNo(model.getExtnNo());
		soapModel.setDirectNo(model.getDirectNo());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setCabinNo(model.getCabinNo());
		soapModel.setFloorNo(model.getFloorNo());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeWorkstationSoap[] toSoapModels(
		EmployeeWorkstation[] models) {

		EmployeeWorkstationSoap[] soapModels =
			new EmployeeWorkstationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeWorkstationSoap[][] toSoapModels(
		EmployeeWorkstation[][] models) {

		EmployeeWorkstationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeWorkstationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeWorkstationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeWorkstationSoap[] toSoapModels(
		List<EmployeeWorkstation> models) {

		List<EmployeeWorkstationSoap> soapModels =
			new ArrayList<EmployeeWorkstationSoap>(models.size());

		for (EmployeeWorkstation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeWorkstationSoap[soapModels.size()]);
	}

	public EmployeeWorkstationSoap() {
	}

	public long getPrimaryKey() {
		return _employeeWorkstationId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeWorkstationId(pk);
	}

	public long getEmployeeWorkstationId() {
		return _employeeWorkstationId;
	}

	public void setEmployeeWorkstationId(long employeeWorkstationId) {
		_employeeWorkstationId = employeeWorkstationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getFromMonth() {
		return _fromMonth;
	}

	public void setFromMonth(Date fromMonth) {
		_fromMonth = fromMonth;
	}

	public Date getToMonth() {
		return _toMonth;
	}

	public void setToMonth(Date toMonth) {
		_toMonth = toMonth;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getWorkStationId() {
		return _workStationId;
	}

	public void setWorkStationId(long workStationId) {
		_workStationId = workStationId;
	}

	public String getDeskNo() {
		return _deskNo;
	}

	public void setDeskNo(String deskNo) {
		_deskNo = deskNo;
	}

	public String getExtnNo() {
		return _extnNo;
	}

	public void setExtnNo(String extnNo) {
		_extnNo = extnNo;
	}

	public String getDirectNo() {
		return _directNo;
	}

	public void setDirectNo(String directNo) {
		_directNo = directNo;
	}

	public String getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
	}

	public String getCabinNo() {
		return _cabinNo;
	}

	public void setCabinNo(String cabinNo) {
		_cabinNo = cabinNo;
	}

	public String getFloorNo() {
		return _floorNo;
	}

	public void setFloorNo(String floorNo) {
		_floorNo = floorNo;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeWorkstationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromMonth;
	private Date _toMonth;
	private long _employeeId;
	private long _workStationId;
	private String _deskNo;
	private String _extnNo;
	private String _directNo;
	private String _phoneNo;
	private String _cabinNo;
	private String _floorNo;
	private int _status;

}