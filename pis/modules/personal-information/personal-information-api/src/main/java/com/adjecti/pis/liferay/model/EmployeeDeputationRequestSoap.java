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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeDeputationRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeDeputationRequestSoap implements Serializable {

	public static EmployeeDeputationRequestSoap toSoapModel(
		EmployeeDeputationRequest model) {

		EmployeeDeputationRequestSoap soapModel =
			new EmployeeDeputationRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeeDeputationRequestId(
			model.getEmployeeDeputationRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDeputationOrganization(model.getDeputationOrganization());
		soapModel.setDeputationAddress(model.getDeputationAddress());
		soapModel.setDeputationCity(model.getDeputationCity());
		soapModel.setDeputationState(model.getDeputationState());
		soapModel.setDeputationStartDate(model.getDeputationStartDate());
		soapModel.setLastDateInCurrentUnit(model.getLastDateInCurrentUnit());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());
		soapModel.setOfficeOrderNo(model.getOfficeOrderNo());

		return soapModel;
	}

	public static EmployeeDeputationRequestSoap[] toSoapModels(
		EmployeeDeputationRequest[] models) {

		EmployeeDeputationRequestSoap[] soapModels =
			new EmployeeDeputationRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDeputationRequestSoap[][] toSoapModels(
		EmployeeDeputationRequest[][] models) {

		EmployeeDeputationRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeDeputationRequestSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDeputationRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDeputationRequestSoap[] toSoapModels(
		List<EmployeeDeputationRequest> models) {

		List<EmployeeDeputationRequestSoap> soapModels =
			new ArrayList<EmployeeDeputationRequestSoap>(models.size());

		for (EmployeeDeputationRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeDeputationRequestSoap[soapModels.size()]);
	}

	public EmployeeDeputationRequestSoap() {
	}

	public long getPrimaryKey() {
		return _employeeDeputationRequestId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeDeputationRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeeDeputationRequestId() {
		return _employeeDeputationRequestId;
	}

	public void setEmployeeDeputationRequestId(
		long employeeDeputationRequestId) {

		_employeeDeputationRequestId = employeeDeputationRequestId;
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

	public String getDeputationOrganization() {
		return _deputationOrganization;
	}

	public void setDeputationOrganization(String deputationOrganization) {
		_deputationOrganization = deputationOrganization;
	}

	public String getDeputationAddress() {
		return _deputationAddress;
	}

	public void setDeputationAddress(String deputationAddress) {
		_deputationAddress = deputationAddress;
	}

	public String getDeputationCity() {
		return _deputationCity;
	}

	public void setDeputationCity(String deputationCity) {
		_deputationCity = deputationCity;
	}

	public String getDeputationState() {
		return _deputationState;
	}

	public void setDeputationState(String deputationState) {
		_deputationState = deputationState;
	}

	public Date getDeputationStartDate() {
		return _deputationStartDate;
	}

	public void setDeputationStartDate(Date deputationStartDate) {
		_deputationStartDate = deputationStartDate;
	}

	public Date getLastDateInCurrentUnit() {
		return _lastDateInCurrentUnit;
	}

	public void setLastDateInCurrentUnit(Date lastDateInCurrentUnit) {
		_lastDateInCurrentUnit = lastDateInCurrentUnit;
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
	private long _employeeDeputationRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _deputationOrganization;
	private String _deputationAddress;
	private String _deputationCity;
	private String _deputationState;
	private Date _deputationStartDate;
	private Date _lastDateInCurrentUnit;
	private long _processFileId;
	private String _processFileNo;
	private String _officeOrderNo;

}