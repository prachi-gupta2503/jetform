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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeDelegationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeDelegationSoap implements Serializable {

	public static EmployeeDelegationSoap toSoapModel(EmployeeDelegation model) {
		EmployeeDelegationSoap soapModel = new EmployeeDelegationSoap();

		soapModel.setEmployeeDelegationId(model.getEmployeeDelegationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDelegationType(model.getDelegationType());
		soapModel.setDelegatedEmployeeId(model.getDelegatedEmployeeId());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static EmployeeDelegationSoap[] toSoapModels(
		EmployeeDelegation[] models) {

		EmployeeDelegationSoap[] soapModels =
			new EmployeeDelegationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDelegationSoap[][] toSoapModels(
		EmployeeDelegation[][] models) {

		EmployeeDelegationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeDelegationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDelegationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDelegationSoap[] toSoapModels(
		List<EmployeeDelegation> models) {

		List<EmployeeDelegationSoap> soapModels =
			new ArrayList<EmployeeDelegationSoap>(models.size());

		for (EmployeeDelegation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeDelegationSoap[soapModels.size()]);
	}

	public EmployeeDelegationSoap() {
	}

	public long getPrimaryKey() {
		return _employeeDelegationId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeDelegationId(pk);
	}

	public long getEmployeeDelegationId() {
		return _employeeDelegationId;
	}

	public void setEmployeeDelegationId(long employeeDelegationId) {
		_employeeDelegationId = employeeDelegationId;
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

	public long getDelegationType() {
		return _delegationType;
	}

	public void setDelegationType(long delegationType) {
		_delegationType = delegationType;
	}

	public long getDelegatedEmployeeId() {
		return _delegatedEmployeeId;
	}

	public void setDelegatedEmployeeId(long delegatedEmployeeId) {
		_delegatedEmployeeId = delegatedEmployeeId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private long _employeeDelegationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _delegationType;
	private long _delegatedEmployeeId;
	private long _employeeId;

}