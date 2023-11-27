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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeSeparationRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeSeparationRequestSoap implements Serializable {

	public static EmployeeSeparationRequestSoap toSoapModel(
		EmployeeSeparationRequest model) {

		EmployeeSeparationRequestSoap soapModel =
			new EmployeeSeparationRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeeSeparationRequestId(
			model.getEmployeeSeparationRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setSeparationMode(model.getSeparationMode());
		soapModel.setSeparationDate(model.getSeparationDate());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());
		soapModel.setOfficeOrderNo(model.getOfficeOrderNo());

		return soapModel;
	}

	public static EmployeeSeparationRequestSoap[] toSoapModels(
		EmployeeSeparationRequest[] models) {

		EmployeeSeparationRequestSoap[] soapModels =
			new EmployeeSeparationRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSeparationRequestSoap[][] toSoapModels(
		EmployeeSeparationRequest[][] models) {

		EmployeeSeparationRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeSeparationRequestSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSeparationRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSeparationRequestSoap[] toSoapModels(
		List<EmployeeSeparationRequest> models) {

		List<EmployeeSeparationRequestSoap> soapModels =
			new ArrayList<EmployeeSeparationRequestSoap>(models.size());

		for (EmployeeSeparationRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeSeparationRequestSoap[soapModels.size()]);
	}

	public EmployeeSeparationRequestSoap() {
	}

	public long getPrimaryKey() {
		return _employeeSeparationRequestId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeSeparationRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeeSeparationRequestId() {
		return _employeeSeparationRequestId;
	}

	public void setEmployeeSeparationRequestId(
		long employeeSeparationRequestId) {

		_employeeSeparationRequestId = employeeSeparationRequestId;
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

	public String getSeparationMode() {
		return _separationMode;
	}

	public void setSeparationMode(String separationMode) {
		_separationMode = separationMode;
	}

	public Date getSeparationDate() {
		return _separationDate;
	}

	public void setSeparationDate(Date separationDate) {
		_separationDate = separationDate;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public long getProcessFileId() {
		return _processFileId;
	}

	public void setProcessFileId(long processFileId) {
		_processFileId = processFileId;
	}

	public String getProcessFileNo() {
		return _processFileNo;
	}

	public void setProcessFileNo(String processFileNo) {
		_processFileNo = processFileNo;
	}

	public String getOfficeOrderNo() {
		return _officeOrderNo;
	}

	public void setOfficeOrderNo(String officeOrderNo) {
		_officeOrderNo = officeOrderNo;
	}

	private String _uuid;
	private long _employeeSeparationRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _separationMode;
	private Date _separationDate;
	private String _remarks;
	private long _processFileId;
	private String _processFileNo;
	private String _officeOrderNo;

}