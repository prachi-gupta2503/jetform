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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.OrganizationPayStructureServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrganizationPayStructureSoap implements Serializable {

	public static OrganizationPayStructureSoap toSoapModel(
		OrganizationPayStructure model) {

		OrganizationPayStructureSoap soapModel =
			new OrganizationPayStructureSoap();

		soapModel.setOrganizationPayStructureId(
			model.getOrganizationPayStructureId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setStructureId(model.getStructureId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OrganizationPayStructureSoap[] toSoapModels(
		OrganizationPayStructure[] models) {

		OrganizationPayStructureSoap[] soapModels =
			new OrganizationPayStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationPayStructureSoap[][] toSoapModels(
		OrganizationPayStructure[][] models) {

		OrganizationPayStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new OrganizationPayStructureSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationPayStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationPayStructureSoap[] toSoapModels(
		List<OrganizationPayStructure> models) {

		List<OrganizationPayStructureSoap> soapModels =
			new ArrayList<OrganizationPayStructureSoap>(models.size());

		for (OrganizationPayStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new OrganizationPayStructureSoap[soapModels.size()]);
	}

	public OrganizationPayStructureSoap() {
	}

	public long getPrimaryKey() {
		return _organizationPayStructureId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationPayStructureId(pk);
	}

	public long getOrganizationPayStructureId() {
		return _organizationPayStructureId;
	}

	public void setOrganizationPayStructureId(long organizationPayStructureId) {
		_organizationPayStructureId = organizationPayStructureId;
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

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getStructureId() {
		return _structureId;
	}

	public void setStructureId(long structureId) {
		_structureId = structureId;
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

	private long _organizationPayStructureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private Date _toDate;
	private long _levelId;
	private long _organizationId;
	private long _structureId;
	private boolean _deleted;
	private int _status;

}