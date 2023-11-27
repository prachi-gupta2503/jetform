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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeDigitalSignatureServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeDigitalSignatureSoap implements Serializable {

	public static EmployeeDigitalSignatureSoap toSoapModel(
		EmployeeDigitalSignature model) {

		EmployeeDigitalSignatureSoap soapModel =
			new EmployeeDigitalSignatureSoap();

		soapModel.setEmployeeDigitalSignatureId(
			model.getEmployeeDigitalSignatureId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCid(model.getCid());
		soapModel.setDetails(model.getDetails());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setRevokeDate(model.getRevokeDate());
		soapModel.setRevoked(model.isRevoked());

		return soapModel;
	}

	public static EmployeeDigitalSignatureSoap[] toSoapModels(
		EmployeeDigitalSignature[] models) {

		EmployeeDigitalSignatureSoap[] soapModels =
			new EmployeeDigitalSignatureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDigitalSignatureSoap[][] toSoapModels(
		EmployeeDigitalSignature[][] models) {

		EmployeeDigitalSignatureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeDigitalSignatureSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDigitalSignatureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDigitalSignatureSoap[] toSoapModels(
		List<EmployeeDigitalSignature> models) {

		List<EmployeeDigitalSignatureSoap> soapModels =
			new ArrayList<EmployeeDigitalSignatureSoap>(models.size());

		for (EmployeeDigitalSignature model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeDigitalSignatureSoap[soapModels.size()]);
	}

	public EmployeeDigitalSignatureSoap() {
	}

	public long getPrimaryKey() {
		return _employeeDigitalSignatureId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeDigitalSignatureId(pk);
	}

	public long getEmployeeDigitalSignatureId() {
		return _employeeDigitalSignatureId;
	}

	public void setEmployeeDigitalSignatureId(long employeeDigitalSignatureId) {
		_employeeDigitalSignatureId = employeeDigitalSignatureId;
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

	public String getCid() {
		return _cid;
	}

	public void setCid(String cid) {
		_cid = cid;
	}

	public String getDetails() {
		return _details;
	}

	public void setDetails(String details) {
		_details = details;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public Date getRevokeDate() {
		return _revokeDate;
	}

	public void setRevokeDate(Date revokeDate) {
		_revokeDate = revokeDate;
	}

	public boolean getRevoked() {
		return _revoked;
	}

	public boolean isRevoked() {
		return _revoked;
	}

	public void setRevoked(boolean revoked) {
		_revoked = revoked;
	}

	private long _employeeDigitalSignatureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _cid;
	private String _details;
	private Date _issueDate;
	private Date _revokeDate;
	private boolean _revoked;

}