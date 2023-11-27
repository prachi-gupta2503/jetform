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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.ProcessFileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProcessFileSoap implements Serializable {

	public static ProcessFileSoap toSoapModel(ProcessFile model) {
		ProcessFileSoap soapModel = new ProcessFileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProcessFileNo(model.getProcessFileNo());

		return soapModel;
	}

	public static ProcessFileSoap[] toSoapModels(ProcessFile[] models) {
		ProcessFileSoap[] soapModels = new ProcessFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProcessFileSoap[][] toSoapModels(ProcessFile[][] models) {
		ProcessFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProcessFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProcessFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProcessFileSoap[] toSoapModels(List<ProcessFile> models) {
		List<ProcessFileSoap> soapModels = new ArrayList<ProcessFileSoap>(
			models.size());

		for (ProcessFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProcessFileSoap[soapModels.size()]);
	}

	public ProcessFileSoap() {
	}

	public long getPrimaryKey() {
		return _processFileId;
	}

	public void setPrimaryKey(long pk) {
		setProcessFileId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProcessFileId() {
		return _processFileId;
	}

	public void setProcessFileId(long processFileId) {
		_processFileId = processFileId;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getProcessFileNo() {
		return _processFileNo;
	}

	public void setProcessFileNo(long processFileNo) {
		_processFileNo = processFileNo;
	}

	private String _uuid;
	private long _processFileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private long _processFileNo;

}