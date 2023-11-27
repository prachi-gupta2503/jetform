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

import com.adjecti.mdm.liferay.service.persistence.DesignationScopePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.DesignationScopeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DesignationScopeSoap implements Serializable {

	public static DesignationScopeSoap toSoapModel(DesignationScope model) {
		DesignationScopeSoap soapModel = new DesignationScopeSoap();

		soapModel.setDesignationScopeId(model.getDesignationScopeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setScopeType(model.getScopeType());
		soapModel.setScopeOrganizationId(model.getScopeOrganizationId());
		soapModel.setScopeOrganizationTypeId(
			model.getScopeOrganizationTypeId());
		soapModel.setScopePostId(model.getScopePostId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static DesignationScopeSoap[] toSoapModels(
		DesignationScope[] models) {

		DesignationScopeSoap[] soapModels =
			new DesignationScopeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DesignationScopeSoap[][] toSoapModels(
		DesignationScope[][] models) {

		DesignationScopeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DesignationScopeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DesignationScopeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DesignationScopeSoap[] toSoapModels(
		List<DesignationScope> models) {

		List<DesignationScopeSoap> soapModels =
			new ArrayList<DesignationScopeSoap>(models.size());

		for (DesignationScope model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DesignationScopeSoap[soapModels.size()]);
	}

	public DesignationScopeSoap() {
	}

	public DesignationScopePK getPrimaryKey() {
		return new DesignationScopePK(_designationScopeId, _designationId);
	}

	public void setPrimaryKey(DesignationScopePK pk) {
		setDesignationScopeId(pk.designationScopeId);
		setDesignationId(pk.designationId);
	}

	public long getDesignationScopeId() {
		return _designationScopeId;
	}

	public void setDesignationScopeId(long designationScopeId) {
		_designationScopeId = designationScopeId;
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

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
	}

	public int getScopeType() {
		return _scopeType;
	}

	public void setScopeType(int scopeType) {
		_scopeType = scopeType;
	}

	public long getScopeOrganizationId() {
		return _scopeOrganizationId;
	}

	public void setScopeOrganizationId(long scopeOrganizationId) {
		_scopeOrganizationId = scopeOrganizationId;
	}

	public long getScopeOrganizationTypeId() {
		return _scopeOrganizationTypeId;
	}

	public void setScopeOrganizationTypeId(long scopeOrganizationTypeId) {
		_scopeOrganizationTypeId = scopeOrganizationTypeId;
	}

	public long getScopePostId() {
		return _scopePostId;
	}

	public void setScopePostId(long scopePostId) {
		_scopePostId = scopePostId;
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

	private long _designationScopeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _designationId;
	private int _scopeType;
	private long _scopeOrganizationId;
	private long _scopeOrganizationTypeId;
	private long _scopePostId;
	private boolean _deleted;
	private int _status;

}