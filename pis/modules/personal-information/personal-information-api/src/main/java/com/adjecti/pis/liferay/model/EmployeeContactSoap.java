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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeContactServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeContactSoap implements Serializable {

	public static EmployeeContactSoap toSoapModel(EmployeeContact model) {
		EmployeeContactSoap soapModel = new EmployeeContactSoap();

		soapModel.setEmployeeContactId(model.getEmployeeContactId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeskNo(model.getDeskNo());
		soapModel.setExtn(model.getExtn());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setContactId(model.getContactId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDirectNo(model.getDirectNo());

		return soapModel;
	}

	public static EmployeeContactSoap[] toSoapModels(EmployeeContact[] models) {
		EmployeeContactSoap[] soapModels =
			new EmployeeContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeContactSoap[][] toSoapModels(
		EmployeeContact[][] models) {

		EmployeeContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeContactSoap[] toSoapModels(
		List<EmployeeContact> models) {

		List<EmployeeContactSoap> soapModels =
			new ArrayList<EmployeeContactSoap>(models.size());

		for (EmployeeContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeContactSoap[soapModels.size()]);
	}

	public EmployeeContactSoap() {
	}

	public long getPrimaryKey() {
		return _employeeContactId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeContactId(pk);
	}

	public long getEmployeeContactId() {
		return _employeeContactId;
	}

	public void setEmployeeContactId(long employeeContactId) {
		_employeeContactId = employeeContactId;
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

	public String getDeskNo() {
		return _deskNo;
	}

	public void setDeskNo(String deskNo) {
		_deskNo = deskNo;
	}

	public String getExtn() {
		return _extn;
	}

	public void setExtn(String extn) {
		_extn = extn;
	}

	public String getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getDirectNo() {
		return _directNo;
	}

	public void setDirectNo(String directNo) {
		_directNo = directNo;
	}

	private long _employeeContactId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _deskNo;
	private String _extn;
	private String _phoneNo;
	private long _contactId;
	private long _employeeId;
	private String _directNo;

}