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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.LevelWisePayStructureServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LevelWisePayStructureSoap implements Serializable {

	public static LevelWisePayStructureSoap toSoapModel(
		LevelWisePayStructure model) {

		LevelWisePayStructureSoap soapModel = new LevelWisePayStructureSoap();

		soapModel.setLevelWisePayStructureId(
			model.getLevelWisePayStructureId());
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
		soapModel.setStructureId(model.getStructureId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static LevelWisePayStructureSoap[] toSoapModels(
		LevelWisePayStructure[] models) {

		LevelWisePayStructureSoap[] soapModels =
			new LevelWisePayStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LevelWisePayStructureSoap[][] toSoapModels(
		LevelWisePayStructure[][] models) {

		LevelWisePayStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LevelWisePayStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LevelWisePayStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LevelWisePayStructureSoap[] toSoapModels(
		List<LevelWisePayStructure> models) {

		List<LevelWisePayStructureSoap> soapModels =
			new ArrayList<LevelWisePayStructureSoap>(models.size());

		for (LevelWisePayStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new LevelWisePayStructureSoap[soapModels.size()]);
	}

	public LevelWisePayStructureSoap() {
	}

	public long getPrimaryKey() {
		return _levelWisePayStructureId;
	}

	public void setPrimaryKey(long pk) {
		setLevelWisePayStructureId(pk);
	}

	public long getLevelWisePayStructureId() {
		return _levelWisePayStructureId;
	}

	public void setLevelWisePayStructureId(long levelWisePayStructureId) {
		_levelWisePayStructureId = levelWisePayStructureId;
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

	private long _levelWisePayStructureId;
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
	private long _structureId;
	private boolean _deleted;
	private int _status;

}