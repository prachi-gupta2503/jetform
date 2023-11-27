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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeEmailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeEmailSoap implements Serializable {

	public static EmployeeEmailSoap toSoapModel(EmployeeEmail model) {
		EmployeeEmailSoap soapModel = new EmployeeEmailSoap();

		soapModel.setEmployeeEmailId(model.getEmployeeEmailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setEmailAddressType(model.getEmailAddressType());
		soapModel.setActive(model.isActive());

		return soapModel;
	}

	public static EmployeeEmailSoap[] toSoapModels(EmployeeEmail[] models) {
		EmployeeEmailSoap[] soapModels = new EmployeeEmailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeEmailSoap[][] toSoapModels(EmployeeEmail[][] models) {
		EmployeeEmailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeEmailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeEmailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeEmailSoap[] toSoapModels(List<EmployeeEmail> models) {
		List<EmployeeEmailSoap> soapModels = new ArrayList<EmployeeEmailSoap>(
			models.size());

		for (EmployeeEmail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeEmailSoap[soapModels.size()]);
	}

	public EmployeeEmailSoap() {
	}

	public long getPrimaryKey() {
		return _employeeEmailId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeEmailId(pk);
	}

	public long getEmployeeEmailId() {
		return _employeeEmailId;
	}

	public void setEmployeeEmailId(long employeeEmailId) {
		_employeeEmailId = employeeEmailId;
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

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getEmailAddressType() {
		return _emailAddressType;
	}

	public void setEmailAddressType(String emailAddressType) {
		_emailAddressType = emailAddressType;
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

	private long _employeeEmailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _emailAddress;
	private String _emailAddressType;
	private boolean _active;

}