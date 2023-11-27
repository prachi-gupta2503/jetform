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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.IDAMFailedTransactionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class IDAMFailedTransactionSoap implements Serializable {

	public static IDAMFailedTransactionSoap toSoapModel(
		IDAMFailedTransaction model) {

		IDAMFailedTransactionSoap soapModel = new IDAMFailedTransactionSoap();

		soapModel.setIdamFailedTransactionId(
			model.getIdamFailedTransactionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setClassId(model.getClassId());
		soapModel.setClassName(model.getClassName());
		soapModel.setIdamUrl(model.getIdamUrl());
		soapModel.setAttribute(model.getAttribute());
		soapModel.setOldValue(model.getOldValue());
		soapModel.setNewValue(model.getNewValue());
		soapModel.setError(model.getError());
		soapModel.setFiredon(model.getFiredon());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static IDAMFailedTransactionSoap[] toSoapModels(
		IDAMFailedTransaction[] models) {

		IDAMFailedTransactionSoap[] soapModels =
			new IDAMFailedTransactionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IDAMFailedTransactionSoap[][] toSoapModels(
		IDAMFailedTransaction[][] models) {

		IDAMFailedTransactionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new IDAMFailedTransactionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IDAMFailedTransactionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IDAMFailedTransactionSoap[] toSoapModels(
		List<IDAMFailedTransaction> models) {

		List<IDAMFailedTransactionSoap> soapModels =
			new ArrayList<IDAMFailedTransactionSoap>(models.size());

		for (IDAMFailedTransaction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new IDAMFailedTransactionSoap[soapModels.size()]);
	}

	public IDAMFailedTransactionSoap() {
	}

	public long getPrimaryKey() {
		return _idamFailedTransactionId;
	}

	public void setPrimaryKey(long pk) {
		setIdamFailedTransactionId(pk);
	}

	public long getIdamFailedTransactionId() {
		return _idamFailedTransactionId;
	}

	public void setIdamFailedTransactionId(long idamFailedTransactionId) {
		_idamFailedTransactionId = idamFailedTransactionId;
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

	public long getClassId() {
		return _classId;
	}

	public void setClassId(long classId) {
		_classId = classId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public String getIdamUrl() {
		return _idamUrl;
	}

	public void setIdamUrl(String idamUrl) {
		_idamUrl = idamUrl;
	}

	public String getAttribute() {
		return _attribute;
	}

	public void setAttribute(String attribute) {
		_attribute = attribute;
	}

	public String getOldValue() {
		return _oldValue;
	}

	public void setOldValue(String oldValue) {
		_oldValue = oldValue;
	}

	public String getNewValue() {
		return _newValue;
	}

	public void setNewValue(String newValue) {
		_newValue = newValue;
	}

	public String getError() {
		return _error;
	}

	public void setError(String error) {
		_error = error;
	}

	public Date getFiredon() {
		return _firedon;
	}

	public void setFiredon(Date firedon) {
		_firedon = firedon;
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

	private long _idamFailedTransactionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private long _classId;
	private String _className;
	private String _idamUrl;
	private String _attribute;
	private String _oldValue;
	private String _newValue;
	private String _error;
	private Date _firedon;
	private boolean _deleted;
	private int _status;

}