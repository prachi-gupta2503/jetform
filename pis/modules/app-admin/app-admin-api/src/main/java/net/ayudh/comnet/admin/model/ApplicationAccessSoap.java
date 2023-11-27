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

package net.ayudh.comnet.admin.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link net.ayudh.comnet.admin.service.http.ApplicationAccessServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ApplicationAccessSoap implements Serializable {

	public static ApplicationAccessSoap toSoapModel(ApplicationAccess model) {
		ApplicationAccessSoap soapModel = new ApplicationAccessSoap();

		soapModel.setApplicationAccessId(model.getApplicationAccessId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setStatus(model.getStatus());
		soapModel.setDeleted(model.isDeleted());

		return soapModel;
	}

	public static ApplicationAccessSoap[] toSoapModels(
		ApplicationAccess[] models) {

		ApplicationAccessSoap[] soapModels =
			new ApplicationAccessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationAccessSoap[][] toSoapModels(
		ApplicationAccess[][] models) {

		ApplicationAccessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ApplicationAccessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationAccessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationAccessSoap[] toSoapModels(
		List<ApplicationAccess> models) {

		List<ApplicationAccessSoap> soapModels =
			new ArrayList<ApplicationAccessSoap>(models.size());

		for (ApplicationAccess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationAccessSoap[soapModels.size()]);
	}

	public ApplicationAccessSoap() {
	}

	public long getPrimaryKey() {
		return _applicationAccessId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationAccessId(pk);
	}

	public long getApplicationAccessId() {
		return _applicationAccessId;
	}

	public void setApplicationAccessId(long applicationAccessId) {
		_applicationAccessId = applicationAccessId;
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

	public long getApplicationId() {
		return _applicationId;
	}

	public void setApplicationId(long applicationId) {
		_applicationId = applicationId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
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

	private long _applicationAccessId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private long _applicationId;
	private int _status;
	private boolean _deleted;

}