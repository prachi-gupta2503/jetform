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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeMessageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeMessageSoap implements Serializable {

	public static EmployeeMessageSoap toSoapModel(EmployeeMessage model) {
		EmployeeMessageSoap soapModel = new EmployeeMessageSoap();

		soapModel.setEmployeeMessageId(model.getEmployeeMessageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setTitle(model.getTitle());
		soapModel.setMessage(model.getMessage());

		return soapModel;
	}

	public static EmployeeMessageSoap[] toSoapModels(EmployeeMessage[] models) {
		EmployeeMessageSoap[] soapModels =
			new EmployeeMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeMessageSoap[][] toSoapModels(
		EmployeeMessage[][] models) {

		EmployeeMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeMessageSoap[] toSoapModels(
		List<EmployeeMessage> models) {

		List<EmployeeMessageSoap> soapModels =
			new ArrayList<EmployeeMessageSoap>(models.size());

		for (EmployeeMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeMessageSoap[soapModels.size()]);
	}

	public EmployeeMessageSoap() {
	}

	public long getPrimaryKey() {
		return _employeeMessageId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeMessageId(pk);
	}

	public long getEmployeeMessageId() {
		return _employeeMessageId;
	}

	public void setEmployeeMessageId(long employeeMessageId) {
		_employeeMessageId = employeeMessageId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	private long _employeeMessageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _title;
	private String _message;

}