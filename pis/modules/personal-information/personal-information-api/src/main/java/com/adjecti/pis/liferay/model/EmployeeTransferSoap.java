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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeTransferServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeTransferSoap implements Serializable {

	public static EmployeeTransferSoap toSoapModel(EmployeeTransfer model) {
		EmployeeTransferSoap soapModel = new EmployeeTransferSoap();

		soapModel.setEmployeeTransferId(model.getEmployeeTransferId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setTransferDate(model.getTransferDate());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setFromOrganizationId(model.getFromOrganizationId());
		soapModel.setGradeId(model.getGradeId());
		soapModel.setGradeModeId(model.getGradeModeId());
		soapModel.setToOrganizationId(model.getToOrganizationId());
		soapModel.setTransferLetterId(model.getTransferLetterId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeTransferSoap[] toSoapModels(
		EmployeeTransfer[] models) {

		EmployeeTransferSoap[] soapModels =
			new EmployeeTransferSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTransferSoap[][] toSoapModels(
		EmployeeTransfer[][] models) {

		EmployeeTransferSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeTransferSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeTransferSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTransferSoap[] toSoapModels(
		List<EmployeeTransfer> models) {

		List<EmployeeTransferSoap> soapModels =
			new ArrayList<EmployeeTransferSoap>(models.size());

		for (EmployeeTransfer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeTransferSoap[soapModels.size()]);
	}

	public EmployeeTransferSoap() {
	}

	public long getPrimaryKey() {
		return _employeeTransferId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeTransferId(pk);
	}

	public long getEmployeeTransferId() {
		return _employeeTransferId;
	}

	public void setEmployeeTransferId(long employeeTransferId) {
		_employeeTransferId = employeeTransferId;
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

	public String getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(String personalNo) {
		_personalNo = personalNo;
	}

	public Date getTransferDate() {
		return _transferDate;
	}

	public void setTransferDate(Date transferDate) {
		_transferDate = transferDate;
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

	public long getFromOrganizationId() {
		return _fromOrganizationId;
	}

	public void setFromOrganizationId(long fromOrganizationId) {
		_fromOrganizationId = fromOrganizationId;
	}

	public long getGradeId() {
		return _gradeId;
	}

	public void setGradeId(long gradeId) {
		_gradeId = gradeId;
	}

	public long getGradeModeId() {
		return _gradeModeId;
	}

	public void setGradeModeId(long gradeModeId) {
		_gradeModeId = gradeModeId;
	}

	public long getToOrganizationId() {
		return _toOrganizationId;
	}

	public void setToOrganizationId(long toOrganizationId) {
		_toOrganizationId = toOrganizationId;
	}

	public long getTransferLetterId() {
		return _transferLetterId;
	}

	public void setTransferLetterId(long transferLetterId) {
		_transferLetterId = transferLetterId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeTransferId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _personalNo;
	private Date _transferDate;
	private long _designationId;
	private long _employeeId;
	private long _fromOrganizationId;
	private long _gradeId;
	private long _gradeModeId;
	private long _toOrganizationId;
	private long _transferLetterId;
	private int _status;

}