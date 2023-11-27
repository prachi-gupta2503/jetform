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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeProfileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeProfileSoap implements Serializable {

	public static EmployeeProfileSoap toSoapModel(EmployeeProfile model) {
		EmployeeProfileSoap soapModel = new EmployeeProfileSoap();

		soapModel.setEmployeeProfileId(model.getEmployeeProfileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProfileDocumentId(model.getProfileDocumentId());
		soapModel.setProfileDescription(model.getProfileDescription());

		return soapModel;
	}

	public static EmployeeProfileSoap[] toSoapModels(EmployeeProfile[] models) {
		EmployeeProfileSoap[] soapModels =
			new EmployeeProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeProfileSoap[][] toSoapModels(
		EmployeeProfile[][] models) {

		EmployeeProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeProfileSoap[] toSoapModels(
		List<EmployeeProfile> models) {

		List<EmployeeProfileSoap> soapModels =
			new ArrayList<EmployeeProfileSoap>(models.size());

		for (EmployeeProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeProfileSoap[soapModels.size()]);
	}

	public EmployeeProfileSoap() {
	}

	public long getPrimaryKey() {
		return _employeeProfileId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeProfileId(pk);
	}

	public long getEmployeeProfileId() {
		return _employeeProfileId;
	}

	public void setEmployeeProfileId(long employeeProfileId) {
		_employeeProfileId = employeeProfileId;
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

	public long getProfileDocumentId() {
		return _profileDocumentId;
	}

	public void setProfileDocumentId(long profileDocumentId) {
		_profileDocumentId = profileDocumentId;
	}

	public String getProfileDescription() {
		return _profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		_profileDescription = profileDescription;
	}

	private long _employeeProfileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private long _profileDocumentId;
	private String _profileDescription;

}