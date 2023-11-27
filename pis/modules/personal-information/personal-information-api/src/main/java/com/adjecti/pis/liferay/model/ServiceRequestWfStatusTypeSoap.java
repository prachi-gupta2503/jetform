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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.ServiceRequestWfStatusTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestWfStatusTypeSoap implements Serializable {

	public static ServiceRequestWfStatusTypeSoap toSoapModel(
		ServiceRequestWfStatusType model) {

		ServiceRequestWfStatusTypeSoap soapModel =
			new ServiceRequestWfStatusTypeSoap();

		soapModel.setServiceRequestWfStatusTypeId(
			model.getServiceRequestWfStatusTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setClassName(model.getClassName());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ServiceRequestWfStatusTypeSoap[] toSoapModels(
		ServiceRequestWfStatusType[] models) {

		ServiceRequestWfStatusTypeSoap[] soapModels =
			new ServiceRequestWfStatusTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestWfStatusTypeSoap[][] toSoapModels(
		ServiceRequestWfStatusType[][] models) {

		ServiceRequestWfStatusTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestWfStatusTypeSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestWfStatusTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestWfStatusTypeSoap[] toSoapModels(
		List<ServiceRequestWfStatusType> models) {

		List<ServiceRequestWfStatusTypeSoap> soapModels =
			new ArrayList<ServiceRequestWfStatusTypeSoap>(models.size());

		for (ServiceRequestWfStatusType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ServiceRequestWfStatusTypeSoap[soapModels.size()]);
	}

	public ServiceRequestWfStatusTypeSoap() {
	}

	public long getPrimaryKey() {
		return _serviceRequestWfStatusTypeId;
	}

	public void setPrimaryKey(long pk) {
		setServiceRequestWfStatusTypeId(pk);
	}

	public long getServiceRequestWfStatusTypeId() {
		return _serviceRequestWfStatusTypeId;
	}

	public void setServiceRequestWfStatusTypeId(
		long serviceRequestWfStatusTypeId) {

		_serviceRequestWfStatusTypeId = serviceRequestWfStatusTypeId;
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

	public long getName() {
		return _name;
	}

	public void setName(long name) {
		_name = name;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _serviceRequestWfStatusTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _name;
	private String _className;
	private boolean _deleted;
	private int _status;

}