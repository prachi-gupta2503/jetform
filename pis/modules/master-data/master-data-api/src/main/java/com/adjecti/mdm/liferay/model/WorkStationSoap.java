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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.WorkStationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class WorkStationSoap implements Serializable {

	public static WorkStationSoap toSoapModel(WorkStation model) {
		WorkStationSoap soapModel = new WorkStationSoap();

		soapModel.setWorkStationId(model.getWorkStationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setDeskNo(model.getDeskNo());
		soapModel.setExtnNo(model.getExtnNo());
		soapModel.setDirectNo(model.getDirectNo());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setCabinNo(model.getCabinNo());
		soapModel.setFloorNo(model.getFloorNo());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static WorkStationSoap[] toSoapModels(WorkStation[] models) {
		WorkStationSoap[] soapModels = new WorkStationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkStationSoap[][] toSoapModels(WorkStation[][] models) {
		WorkStationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkStationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkStationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkStationSoap[] toSoapModels(List<WorkStation> models) {
		List<WorkStationSoap> soapModels = new ArrayList<WorkStationSoap>(
			models.size());

		for (WorkStation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkStationSoap[soapModels.size()]);
	}

	public WorkStationSoap() {
	}

	public long getPrimaryKey() {
		return _workStationId;
	}

	public void setPrimaryKey(long pk) {
		setWorkStationId(pk);
	}

	public long getWorkStationId() {
		return _workStationId;
	}

	public void setWorkStationId(long workStationId) {
		_workStationId = workStationId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
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

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _workStationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _deskNo;
	private String _extnNo;
	private String _directNo;
	private String _phoneNo;
	private String _cabinNo;
	private String _floorNo;
	private boolean _deleted;
	private int _status;

}