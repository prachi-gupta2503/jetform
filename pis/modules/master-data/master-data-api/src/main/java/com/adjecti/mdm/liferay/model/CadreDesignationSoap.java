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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.CadreDesignationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CadreDesignationSoap implements Serializable {

	public static CadreDesignationSoap toSoapModel(CadreDesignation model) {
		CadreDesignationSoap soapModel = new CadreDesignationSoap();

		soapModel.setCadreDesignationId(model.getCadreDesignationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCadreId(model.getCadreId());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setRank(model.getRank());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CadreDesignationSoap[] toSoapModels(
		CadreDesignation[] models) {

		CadreDesignationSoap[] soapModels =
			new CadreDesignationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CadreDesignationSoap[][] toSoapModels(
		CadreDesignation[][] models) {

		CadreDesignationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CadreDesignationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CadreDesignationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CadreDesignationSoap[] toSoapModels(
		List<CadreDesignation> models) {

		List<CadreDesignationSoap> soapModels =
			new ArrayList<CadreDesignationSoap>(models.size());

		for (CadreDesignation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CadreDesignationSoap[soapModels.size()]);
	}

	public CadreDesignationSoap() {
	}

	public long getPrimaryKey() {
		return _cadreDesignationId;
	}

	public void setPrimaryKey(long pk) {
		setCadreDesignationId(pk);
	}

	public long getCadreDesignationId() {
		return _cadreDesignationId;
	}

	public void setCadreDesignationId(long cadreDesignationId) {
		_cadreDesignationId = cadreDesignationId;
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

	public long getCadreId() {
		return _cadreId;
	}

	public void setCadreId(long cadreId) {
		_cadreId = cadreId;
	}

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
	}

	public int getRank() {
		return _rank;
	}

	public void setRank(int rank) {
		_rank = rank;
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

	private long _cadreDesignationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cadreId;
	private long _designationId;
	private int _rank;
	private boolean _deleted;
	private int _status;

}