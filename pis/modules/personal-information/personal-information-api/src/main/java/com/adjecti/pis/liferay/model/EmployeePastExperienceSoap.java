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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeePastExperienceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeePastExperienceSoap implements Serializable {

	public static EmployeePastExperienceSoap toSoapModel(
		EmployeePastExperience model) {

		EmployeePastExperienceSoap soapModel = new EmployeePastExperienceSoap();

		soapModel.setEmployeePastExperienceId(
			model.getEmployeePastExperienceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setOrganization(model.getOrganization());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setExperienceLetterId(model.getExperienceLetterId());
		soapModel.setWorkAreaId(model.getWorkAreaId());
		soapModel.setDesignation(model.getDesignation());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setExServiceMan(model.isExServiceMan());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeePastExperienceSoap[] toSoapModels(
		EmployeePastExperience[] models) {

		EmployeePastExperienceSoap[] soapModels =
			new EmployeePastExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeePastExperienceSoap[][] toSoapModels(
		EmployeePastExperience[][] models) {

		EmployeePastExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeePastExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeePastExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeePastExperienceSoap[] toSoapModels(
		List<EmployeePastExperience> models) {

		List<EmployeePastExperienceSoap> soapModels =
			new ArrayList<EmployeePastExperienceSoap>(models.size());

		for (EmployeePastExperience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeePastExperienceSoap[soapModels.size()]);
	}

	public EmployeePastExperienceSoap() {
	}

	public long getPrimaryKey() {
		return _employeePastExperienceId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeePastExperienceId(pk);
	}

	public long getEmployeePastExperienceId() {
		return _employeePastExperienceId;
	}

	public void setEmployeePastExperienceId(long employeePastExperienceId) {
		_employeePastExperienceId = employeePastExperienceId;
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

	public String getOrganization() {
		return _organization;
	}

	public void setOrganization(String organization) {
		_organization = organization;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getExperienceLetterId() {
		return _experienceLetterId;
	}

	public void setExperienceLetterId(long experienceLetterId) {
		_experienceLetterId = experienceLetterId;
	}

	public long getWorkAreaId() {
		return _workAreaId;
	}

	public void setWorkAreaId(long workAreaId) {
		_workAreaId = workAreaId;
	}

	public String getDesignation() {
		return _designation;
	}

	public void setDesignation(String designation) {
		_designation = designation;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public boolean getExServiceMan() {
		return _exServiceMan;
	}

	public boolean isExServiceMan() {
		return _exServiceMan;
	}

	public void setExServiceMan(boolean exServiceMan) {
		_exServiceMan = exServiceMan;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeePastExperienceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private String _organization;
	private long _employeeId;
	private long _experienceLetterId;
	private long _workAreaId;
	private String _designation;
	private long _joiningProcessId;
	private boolean _exServiceMan;
	private int _status;

}