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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeDocumentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeDocumentSoap implements Serializable {

	public static EmployeeDocumentSoap toSoapModel(EmployeeDocument model) {
		EmployeeDocumentSoap soapModel = new EmployeeDocumentSoap();

		soapModel.setEmployeeDocumentId(model.getEmployeeDocumentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDocumentTypeId(model.getDocumentTypeId());
		soapModel.setDiscription(model.getDiscription());

		return soapModel;
	}

	public static EmployeeDocumentSoap[] toSoapModels(
		EmployeeDocument[] models) {

		EmployeeDocumentSoap[] soapModels =
			new EmployeeDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDocumentSoap[][] toSoapModels(
		EmployeeDocument[][] models) {

		EmployeeDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDocumentSoap[] toSoapModels(
		List<EmployeeDocument> models) {

		List<EmployeeDocumentSoap> soapModels =
			new ArrayList<EmployeeDocumentSoap>(models.size());

		for (EmployeeDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeDocumentSoap[soapModels.size()]);
	}

	public EmployeeDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _employeeDocumentId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeDocumentId(pk);
	}

	public long getEmployeeDocumentId() {
		return _employeeDocumentId;
	}

	public void setEmployeeDocumentId(long employeeDocumentId) {
		_employeeDocumentId = employeeDocumentId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getDocumentTypeId() {
		return _documentTypeId;
	}

	public void setDocumentTypeId(long documentTypeId) {
		_documentTypeId = documentTypeId;
	}

	public String getDiscription() {
		return _discription;
	}

	public void setDiscription(String discription) {
		_discription = discription;
	}

	private long _employeeDocumentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private long _documentId;
	private long _employeeId;
	private String _title;
	private long _documentTypeId;
	private String _discription;

}