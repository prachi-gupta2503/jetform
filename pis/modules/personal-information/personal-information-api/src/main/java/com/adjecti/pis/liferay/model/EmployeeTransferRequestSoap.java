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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeTransferRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeTransferRequestSoap implements Serializable {

	public static EmployeeTransferRequestSoap toSoapModel(
		EmployeeTransferRequest model) {

		EmployeeTransferRequestSoap soapModel =
			new EmployeeTransferRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeeTransferRequestId(
			model.getEmployeeTransferRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setTransferDate(model.getTransferDate());
		soapModel.setStartDateInNewUnit(model.getStartDateInNewUnit());
		soapModel.setLastDateInCurrentUnit(model.getLastDateInCurrentUnit());
		soapModel.setOfficeOrderNo(model.getOfficeOrderNo());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());

		return soapModel;
	}

	public static EmployeeTransferRequestSoap[] toSoapModels(
		EmployeeTransferRequest[] models) {

		EmployeeTransferRequestSoap[] soapModels =
			new EmployeeTransferRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTransferRequestSoap[][] toSoapModels(
		EmployeeTransferRequest[][] models) {

		EmployeeTransferRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeTransferRequestSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeTransferRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTransferRequestSoap[] toSoapModels(
		List<EmployeeTransferRequest> models) {

		List<EmployeeTransferRequestSoap> soapModels =
			new ArrayList<EmployeeTransferRequestSoap>(models.size());

		for (EmployeeTransferRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeTransferRequestSoap[soapModels.size()]);
	}

	public EmployeeTransferRequestSoap() {
	}

	public long getPrimaryKey() {
		return _employeeTransferRequestId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeTransferRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeeTransferRequestId() {
		return _employeeTransferRequestId;
	}

	public void setEmployeeTransferRequestId(long employeeTransferRequestId) {
		_employeeTransferRequestId = employeeTransferRequestId;
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

	public Long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		_organizationId = organizationId;
	}

	public String getTransferDate() {
		return _transferDate;
	}

	public void setTransferDate(String transferDate) {
		_transferDate = transferDate;
	}

	public Date getStartDateInNewUnit() {
		return _startDateInNewUnit;
	}

	public void setStartDateInNewUnit(Date startDateInNewUnit) {
		_startDateInNewUnit = startDateInNewUnit;
	}

	public Date getLastDateInCurrentUnit() {
		return _lastDateInCurrentUnit;
	}

	public void setLastDateInCurrentUnit(Date lastDateInCurrentUnit) {
		_lastDateInCurrentUnit = lastDateInCurrentUnit;
	}

	public String getOfficeOrderNo() {
		return _officeOrderNo;
	}

	public void setOfficeOrderNo(String officeOrderNo) {
		_officeOrderNo = officeOrderNo;
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

	private String _uuid;
	private long _employeeTransferRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private Long _organizationId;
	private String _transferDate;
	private Date _startDateInNewUnit;
	private Date _lastDateInCurrentUnit;
	private String _officeOrderNo;
	private long _processFileId;
	private String _processFileNo;

}