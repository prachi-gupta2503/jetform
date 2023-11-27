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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeExperienceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeExperienceSoap implements Serializable {

	public static EmployeeExperienceSoap toSoapModel(EmployeeExperience model) {
		EmployeeExperienceSoap soapModel = new EmployeeExperienceSoap();

		soapModel.setEmployeeExperienceId(model.getEmployeeExperienceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setPostId(model.getPostId());
		soapModel.setTradeId(model.getTradeId());
		soapModel.setExperienceId(model.getExperienceId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setWorkAreaId(model.getWorkAreaId());
		soapModel.setWorkAreaMinorId(model.getWorkAreaMinorId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeExperienceSoap[] toSoapModels(
		EmployeeExperience[] models) {

		EmployeeExperienceSoap[] soapModels =
			new EmployeeExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeExperienceSoap[][] toSoapModels(
		EmployeeExperience[][] models) {

		EmployeeExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeExperienceSoap[] toSoapModels(
		List<EmployeeExperience> models) {

		List<EmployeeExperienceSoap> soapModels =
			new ArrayList<EmployeeExperienceSoap>(models.size());

		for (EmployeeExperience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeExperienceSoap[soapModels.size()]);
	}

	public EmployeeExperienceSoap() {
	}

	public long getPrimaryKey() {
		return _employeeExperienceId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeExperienceId(pk);
	}

	public long getEmployeeExperienceId() {
		return _employeeExperienceId;
	}

	public void setEmployeeExperienceId(long employeeExperienceId) {
		_employeeExperienceId = employeeExperienceId;
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

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getTradeId() {
		return _tradeId;
	}

	public void setTradeId(long tradeId) {
		_tradeId = tradeId;
	}

	public long getExperienceId() {
		return _experienceId;
	}

	public void setExperienceId(long experienceId) {
		_experienceId = experienceId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getWorkAreaId() {
		return _workAreaId;
	}

	public void setWorkAreaId(long workAreaId) {
		_workAreaId = workAreaId;
	}

	public long getWorkAreaMinorId() {
		return _workAreaMinorId;
	}

	public void setWorkAreaMinorId(long workAreaMinorId) {
		_workAreaMinorId = workAreaMinorId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeExperienceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private long _designationId;
	private long _employeeId;
	private long _postId;
	private long _tradeId;
	private long _experienceId;
	private long _organizationId;
	private long _workAreaId;
	private long _workAreaMinorId;
	private int _status;

}