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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeVerificationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeVerificationSoap implements Serializable {

	public static EmployeeVerificationSoap toSoapModel(
		EmployeeVerification model) {

		EmployeeVerificationSoap soapModel = new EmployeeVerificationSoap();

		soapModel.setEmployeeVerificationId(model.getEmployeeVerificationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setAuthority(model.getAuthority());
		soapModel.setDocumentNo(model.getDocumentNo());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setVerificationDate(model.getVerificationDate());
		soapModel.setVerificationTypeId(model.getVerificationTypeId());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeVerificationSoap[] toSoapModels(
		EmployeeVerification[] models) {

		EmployeeVerificationSoap[] soapModels =
			new EmployeeVerificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeVerificationSoap[][] toSoapModels(
		EmployeeVerification[][] models) {

		EmployeeVerificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeVerificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeVerificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeVerificationSoap[] toSoapModels(
		List<EmployeeVerification> models) {

		List<EmployeeVerificationSoap> soapModels =
			new ArrayList<EmployeeVerificationSoap>(models.size());

		for (EmployeeVerification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeVerificationSoap[soapModels.size()]);
	}

	public EmployeeVerificationSoap() {
	}

	public long getPrimaryKey() {
		return _employeeVerificationId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeVerificationId(pk);
	}

	public long getEmployeeVerificationId() {
		return _employeeVerificationId;
	}

	public void setEmployeeVerificationId(long employeeVerificationId) {
		_employeeVerificationId = employeeVerificationId;
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

	public String getAuthority() {
		return _authority;
	}

	public void setAuthority(String authority) {
		_authority = authority;
	}

	public String getDocumentNo() {
		return _documentNo;
	}

	public void setDocumentNo(String documentNo) {
		_documentNo = documentNo;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public Date getVerificationDate() {
		return _verificationDate;
	}

	public void setVerificationDate(Date verificationDate) {
		_verificationDate = verificationDate;
	}

	public long getVerificationTypeId() {
		return _verificationTypeId;
	}

	public void setVerificationTypeId(long verificationTypeId) {
		_verificationTypeId = verificationTypeId;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
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

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeVerificationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _authority;
	private String _documentNo;
	private String _remarks;
	private Date _verificationDate;
	private long _verificationTypeId;
	private long _documentId;
	private long _employeeId;
	private long _organizationId;
	private long _joiningProcessId;
	private int _status;

}