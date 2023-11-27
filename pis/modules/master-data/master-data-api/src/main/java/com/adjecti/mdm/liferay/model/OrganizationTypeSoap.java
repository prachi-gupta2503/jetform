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

package com.adjecti.mdm.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.OrganizationTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrganizationTypeSoap implements Serializable {

	public static OrganizationTypeSoap toSoapModel(OrganizationType model) {
		OrganizationTypeSoap soapModel = new OrganizationTypeSoap();

		soapModel.setOrganizationTypeId(model.getOrganizationTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setLongName(model.getLongName());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OrganizationTypeSoap[] toSoapModels(
		OrganizationType[] models) {

		OrganizationTypeSoap[] soapModels =
			new OrganizationTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationTypeSoap[][] toSoapModels(
		OrganizationType[][] models) {

		OrganizationTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new OrganizationTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationTypeSoap[] toSoapModels(
		List<OrganizationType> models) {

		List<OrganizationTypeSoap> soapModels =
			new ArrayList<OrganizationTypeSoap>(models.size());

		for (OrganizationType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationTypeSoap[soapModels.size()]);
	}

	public OrganizationTypeSoap() {
	}

	public long getPrimaryKey() {
		return _organizationTypeId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationTypeId(pk);
	}

	public long getOrganizationTypeId() {
		return _organizationTypeId;
	}

	public void setOrganizationTypeId(long organizationTypeId) {
		_organizationTypeId = organizationTypeId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLongName() {
		return _longName;
	}

	public void setLongName(String longName) {
		_longName = longName;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _organizationTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private String _longName;
	private boolean _deleted;
	private int _status;

}