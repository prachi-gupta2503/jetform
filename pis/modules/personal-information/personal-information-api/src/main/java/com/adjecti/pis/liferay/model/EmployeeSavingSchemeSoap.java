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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeSavingSchemeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeSavingSchemeSoap implements Serializable {

	public static EmployeeSavingSchemeSoap toSoapModel(
		EmployeeSavingScheme model) {

		EmployeeSavingSchemeSoap soapModel = new EmployeeSavingSchemeSoap();

		soapModel.setEmployeeSavingSchemeId(model.getEmployeeSavingSchemeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setDocumentNo(model.getDocumentNo());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGradeId(model.getGradeId());

		return soapModel;
	}

	public static EmployeeSavingSchemeSoap[] toSoapModels(
		EmployeeSavingScheme[] models) {

		EmployeeSavingSchemeSoap[] soapModels =
			new EmployeeSavingSchemeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSavingSchemeSoap[][] toSoapModels(
		EmployeeSavingScheme[][] models) {

		EmployeeSavingSchemeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeSavingSchemeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSavingSchemeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSavingSchemeSoap[] toSoapModels(
		List<EmployeeSavingScheme> models) {

		List<EmployeeSavingSchemeSoap> soapModels =
			new ArrayList<EmployeeSavingSchemeSoap>(models.size());

		for (EmployeeSavingScheme model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeSavingSchemeSoap[soapModels.size()]);
	}

	public EmployeeSavingSchemeSoap() {
	}

	public long getPrimaryKey() {
		return _employeeSavingSchemeId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeSavingSchemeId(pk);
	}

	public long getEmployeeSavingSchemeId() {
		return _employeeSavingSchemeId;
	}

	public void setEmployeeSavingSchemeId(long employeeSavingSchemeId) {
		_employeeSavingSchemeId = employeeSavingSchemeId;
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

	public String getDocumentNo() {
		return _documentNo;
	}

	public void setDocumentNo(String documentNo) {
		_documentNo = documentNo;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getGradeId() {
		return _gradeId;
	}

	public void setGradeId(long gradeId) {
		_gradeId = gradeId;
	}

	private long _employeeSavingSchemeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _documentNo;
	private Date _fromDate;
	private Date _toDate;
	private long _employeeId;
	private long _gradeId;

}