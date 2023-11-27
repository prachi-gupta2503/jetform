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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.MasterEntityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterEntitySoap implements Serializable {

	public static MasterEntitySoap toSoapModel(MasterEntity model) {
		MasterEntitySoap soapModel = new MasterEntitySoap();

		soapModel.setMasterEntityId(model.getMasterEntityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEntityClass(model.getEntityClass());
		soapModel.setIcon(model.getIcon());
		soapModel.setLink(model.getLink());
		soapModel.setDescription(model.getDescription());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static MasterEntitySoap[] toSoapModels(MasterEntity[] models) {
		MasterEntitySoap[] soapModels = new MasterEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterEntitySoap[][] toSoapModels(MasterEntity[][] models) {
		MasterEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterEntitySoap[] toSoapModels(List<MasterEntity> models) {
		List<MasterEntitySoap> soapModels = new ArrayList<MasterEntitySoap>(
			models.size());

		for (MasterEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterEntitySoap[soapModels.size()]);
	}

	public MasterEntitySoap() {
	}

	public long getPrimaryKey() {
		return _masterEntityId;
	}

	public void setPrimaryKey(long pk) {
		setMasterEntityId(pk);
	}

	public long getMasterEntityId() {
		return _masterEntityId;
	}

	public void setMasterEntityId(long masterEntityId) {
		_masterEntityId = masterEntityId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEntityClass() {
		return _entityClass;
	}

	public void setEntityClass(String entityClass) {
		_entityClass = entityClass;
	}

	public String getIcon() {
		return _icon;
	}

	public void setIcon(String icon) {
		_icon = icon;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
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

	private long _masterEntityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _entityClass;
	private String _icon;
	private String _link;
	private String _description;
	private boolean _deleted;
	private int _status;

}