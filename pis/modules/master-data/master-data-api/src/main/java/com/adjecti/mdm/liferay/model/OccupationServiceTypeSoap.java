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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.OccupationServiceTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OccupationServiceTypeSoap implements Serializable {

	public static OccupationServiceTypeSoap toSoapModel(
		OccupationServiceType model) {

		OccupationServiceTypeSoap soapModel = new OccupationServiceTypeSoap();

		soapModel.setOccupationServiceTypeId(
			model.getOccupationServiceTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OccupationServiceTypeSoap[] toSoapModels(
		OccupationServiceType[] models) {

		OccupationServiceTypeSoap[] soapModels =
			new OccupationServiceTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OccupationServiceTypeSoap[][] toSoapModels(
		OccupationServiceType[][] models) {

		OccupationServiceTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new OccupationServiceTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OccupationServiceTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OccupationServiceTypeSoap[] toSoapModels(
		List<OccupationServiceType> models) {

		List<OccupationServiceTypeSoap> soapModels =
			new ArrayList<OccupationServiceTypeSoap>(models.size());

		for (OccupationServiceType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new OccupationServiceTypeSoap[soapModels.size()]);
	}

	public OccupationServiceTypeSoap() {
	}

	public long getPrimaryKey() {
		return _occupationServiceTypeId;
	}

	public void setPrimaryKey(long pk) {
		setOccupationServiceTypeId(pk);
	}

	public long getOccupationServiceTypeId() {
		return _occupationServiceTypeId;
	}

	public void setOccupationServiceTypeId(long occupationServiceTypeId) {
		_occupationServiceTypeId = occupationServiceTypeId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _occupationServiceTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private String _description;
	private boolean _deleted;
	private int _status;

}