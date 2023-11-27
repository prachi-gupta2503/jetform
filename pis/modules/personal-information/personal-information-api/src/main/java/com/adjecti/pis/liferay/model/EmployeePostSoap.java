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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeePostServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeePostSoap implements Serializable {

	public static EmployeePostSoap toSoapModel(EmployeePost model) {
		EmployeePostSoap soapModel = new EmployeePostSoap();

		soapModel.setEmployeePostId(model.getEmployeePostId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setPostId(model.getPostId());
		soapModel.setDelegatedPostId(model.getDelegatedPostId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeePostSoap[] toSoapModels(EmployeePost[] models) {
		EmployeePostSoap[] soapModels = new EmployeePostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeePostSoap[][] toSoapModels(EmployeePost[][] models) {
		EmployeePostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeePostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeePostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeePostSoap[] toSoapModels(List<EmployeePost> models) {
		List<EmployeePostSoap> soapModels = new ArrayList<EmployeePostSoap>(
			models.size());

		for (EmployeePost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeePostSoap[soapModels.size()]);
	}

	public EmployeePostSoap() {
	}

	public long getPrimaryKey() {
		return _employeePostId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeePostId(pk);
	}

	public long getEmployeePostId() {
		return _employeePostId;
	}

	public void setEmployeePostId(long employeePostId) {
		_employeePostId = employeePostId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getDelegatedPostId() {
		return _delegatedPostId;
	}

	public void setDelegatedPostId(long delegatedPostId) {
		_delegatedPostId = delegatedPostId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeePostId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private long _postId;
	private long _delegatedPostId;
	private long _employeeId;
	private int _status;

}