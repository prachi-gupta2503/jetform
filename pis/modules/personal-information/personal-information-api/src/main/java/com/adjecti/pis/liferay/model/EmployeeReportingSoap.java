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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeReportingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeReportingSoap implements Serializable {

	public static EmployeeReportingSoap toSoapModel(EmployeeReporting model) {
		EmployeeReportingSoap soapModel = new EmployeeReportingSoap();

		soapModel.setEmployeeReportingId(model.getEmployeeReportingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setReportingToId(model.getReportingToId());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeReportingSoap[] toSoapModels(
		EmployeeReporting[] models) {

		EmployeeReportingSoap[] soapModels =
			new EmployeeReportingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeReportingSoap[][] toSoapModels(
		EmployeeReporting[][] models) {

		EmployeeReportingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeReportingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeReportingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeReportingSoap[] toSoapModels(
		List<EmployeeReporting> models) {

		List<EmployeeReportingSoap> soapModels =
			new ArrayList<EmployeeReportingSoap>(models.size());

		for (EmployeeReporting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeReportingSoap[soapModels.size()]);
	}

	public EmployeeReportingSoap() {
	}

	public long getPrimaryKey() {
		return _employeeReportingId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeReportingId(pk);
	}

	public long getEmployeeReportingId() {
		return _employeeReportingId;
	}

	public void setEmployeeReportingId(long employeeReportingId) {
		_employeeReportingId = employeeReportingId;
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

	public long getReportingToId() {
		return _reportingToId;
	}

	public void setReportingToId(long reportingToId) {
		_reportingToId = reportingToId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeReportingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private long _reportingToId;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private int _status;

}