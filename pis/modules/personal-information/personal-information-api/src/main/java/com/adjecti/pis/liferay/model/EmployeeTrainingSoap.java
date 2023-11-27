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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeTrainingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeTrainingSoap implements Serializable {

	public static EmployeeTrainingSoap toSoapModel(EmployeeTraining model) {
		EmployeeTrainingSoap soapModel = new EmployeeTrainingSoap();

		soapModel.setEmployeeTrainingId(model.getEmployeeTrainingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setDurationMonths(model.getDurationMonths());
		soapModel.setFromMonth(model.getFromMonth());
		soapModel.setToMonth(model.getToMonth());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setCertificateId(model.getCertificateId());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setInstituteId(model.getInstituteId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeTrainingSoap[] toSoapModels(
		EmployeeTraining[] models) {

		EmployeeTrainingSoap[] soapModels =
			new EmployeeTrainingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTrainingSoap[][] toSoapModels(
		EmployeeTraining[][] models) {

		EmployeeTrainingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeTrainingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeTrainingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTrainingSoap[] toSoapModels(
		List<EmployeeTraining> models) {

		List<EmployeeTrainingSoap> soapModels =
			new ArrayList<EmployeeTrainingSoap>(models.size());

		for (EmployeeTraining model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeTrainingSoap[soapModels.size()]);
	}

	public EmployeeTrainingSoap() {
	}

	public long getPrimaryKey() {
		return _employeeTrainingId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeTrainingId(pk);
	}

	public long getEmployeeTrainingId() {
		return _employeeTrainingId;
	}

	public void setEmployeeTrainingId(long employeeTrainingId) {
		_employeeTrainingId = employeeTrainingId;
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

	public int getDurationMonths() {
		return _durationMonths;
	}

	public void setDurationMonths(int durationMonths) {
		_durationMonths = durationMonths;
	}

	public Date getFromMonth() {
		return _fromMonth;
	}

	public void setFromMonth(Date fromMonth) {
		_fromMonth = fromMonth;
	}

	public Date getToMonth() {
		return _toMonth;
	}

	public void setToMonth(Date toMonth) {
		_toMonth = toMonth;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getCertificateId() {
		return _certificateId;
	}

	public void setCertificateId(long certificateId) {
		_certificateId = certificateId;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public long getInstituteId() {
		return _instituteId;
	}

	public void setInstituteId(long instituteId) {
		_instituteId = instituteId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeTrainingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private int _durationMonths;
	private Date _fromMonth;
	private Date _toMonth;
	private long _courseId;
	private long _employeeId;
	private long _organizationId;
	private long _certificateId;
	private Date _endDate;
	private Date _startDate;
	private long _instituteId;
	private int _status;

}