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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeDscServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeDscSoap implements Serializable {

	public static EmployeeDscSoap toSoapModel(EmployeeDsc model) {
		EmployeeDscSoap soapModel = new EmployeeDscSoap();

		soapModel.setEmployeeDscId(model.getEmployeeDscId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCid(model.getCid());
		soapModel.setDetails(model.getDetails());
		soapModel.setOfbDSCReissueDate(model.getOfbDSCReissueDate());
		soapModel.setOfbDSCRevocationDate(model.getOfbDSCRevocationDate());
		soapModel.setOfbDSCRevocationStatus(model.isOfbDSCRevocationStatus());
		soapModel.setOfbDSCReissueStatus(model.isOfbDSCReissueStatus());

		return soapModel;
	}

	public static EmployeeDscSoap[] toSoapModels(EmployeeDsc[] models) {
		EmployeeDscSoap[] soapModels = new EmployeeDscSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDscSoap[][] toSoapModels(EmployeeDsc[][] models) {
		EmployeeDscSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeDscSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDscSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDscSoap[] toSoapModels(List<EmployeeDsc> models) {
		List<EmployeeDscSoap> soapModels = new ArrayList<EmployeeDscSoap>(
			models.size());

		for (EmployeeDsc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeDscSoap[soapModels.size()]);
	}

	public EmployeeDscSoap() {
	}

	public long getPrimaryKey() {
		return _employeeDscId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeDscId(pk);
	}

	public long getEmployeeDscId() {
		return _employeeDscId;
	}

	public void setEmployeeDscId(long employeeDscId) {
		_employeeDscId = employeeDscId;
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

	public String getCid() {
		return _cid;
	}

	public void setCid(String cid) {
		_cid = cid;
	}

	public String getDetails() {
		return _details;
	}

	public void setDetails(String details) {
		_details = details;
	}

	public Date getOfbDSCReissueDate() {
		return _ofbDSCReissueDate;
	}

	public void setOfbDSCReissueDate(Date ofbDSCReissueDate) {
		_ofbDSCReissueDate = ofbDSCReissueDate;
	}

	public Date getOfbDSCRevocationDate() {
		return _ofbDSCRevocationDate;
	}

	public void setOfbDSCRevocationDate(Date ofbDSCRevocationDate) {
		_ofbDSCRevocationDate = ofbDSCRevocationDate;
	}

	public boolean getOfbDSCRevocationStatus() {
		return _ofbDSCRevocationStatus;
	}

	public boolean isOfbDSCRevocationStatus() {
		return _ofbDSCRevocationStatus;
	}

	public void setOfbDSCRevocationStatus(boolean ofbDSCRevocationStatus) {
		_ofbDSCRevocationStatus = ofbDSCRevocationStatus;
	}

	public boolean getOfbDSCReissueStatus() {
		return _ofbDSCReissueStatus;
	}

	public boolean isOfbDSCReissueStatus() {
		return _ofbDSCReissueStatus;
	}

	public void setOfbDSCReissueStatus(boolean ofbDSCReissueStatus) {
		_ofbDSCReissueStatus = ofbDSCReissueStatus;
	}

	private long _employeeDscId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _cid;
	private String _details;
	private Date _ofbDSCReissueDate;
	private Date _ofbDSCRevocationDate;
	private boolean _ofbDSCRevocationStatus;
	private boolean _ofbDSCReissueStatus;

}