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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.WorkAreaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class WorkAreaSoap implements Serializable {

	public static WorkAreaSoap toSoapModel(WorkArea model) {
		WorkAreaSoap soapModel = new WorkAreaSoap();

		soapModel.setWorkAreaId(model.getWorkAreaId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setWorkAreaTypeId(model.getWorkAreaTypeId());
		soapModel.setParentWorkAreaId(model.getParentWorkAreaId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static WorkAreaSoap[] toSoapModels(WorkArea[] models) {
		WorkAreaSoap[] soapModels = new WorkAreaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkAreaSoap[][] toSoapModels(WorkArea[][] models) {
		WorkAreaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkAreaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkAreaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkAreaSoap[] toSoapModels(List<WorkArea> models) {
		List<WorkAreaSoap> soapModels = new ArrayList<WorkAreaSoap>(
			models.size());

		for (WorkArea model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkAreaSoap[soapModels.size()]);
	}

	public WorkAreaSoap() {
	}

	public long getPrimaryKey() {
		return _workAreaId;
	}

	public void setPrimaryKey(long pk) {
		setWorkAreaId(pk);
	}

	public long getWorkAreaId() {
		return _workAreaId;
	}

	public void setWorkAreaId(long workAreaId) {
		_workAreaId = workAreaId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getWorkAreaTypeId() {
		return _workAreaTypeId;
	}

	public void setWorkAreaTypeId(long workAreaTypeId) {
		_workAreaTypeId = workAreaTypeId;
	}

	public long getParentWorkAreaId() {
		return _parentWorkAreaId;
	}

	public void setParentWorkAreaId(long parentWorkAreaId) {
		_parentWorkAreaId = parentWorkAreaId;
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

	private long _workAreaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private long _workAreaTypeId;
	private long _parentWorkAreaId;
	private boolean _deleted;
	private int _status;

}