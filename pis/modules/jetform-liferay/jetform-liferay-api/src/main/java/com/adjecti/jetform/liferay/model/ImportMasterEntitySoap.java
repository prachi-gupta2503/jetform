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

package com.adjecti.jetform.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.jetform.liferay.service.http.ImportMasterEntityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ImportMasterEntitySoap implements Serializable {

	public static ImportMasterEntitySoap toSoapModel(ImportMasterEntity model) {
		ImportMasterEntitySoap soapModel = new ImportMasterEntitySoap();

		soapModel.setImportMasterEntityId(model.getImportMasterEntityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEntityClass(model.getEntityClass());
		soapModel.setDescription(model.getDescription());
		soapModel.setImportFileId(model.getImportFileId());

		return soapModel;
	}

	public static ImportMasterEntitySoap[] toSoapModels(
		ImportMasterEntity[] models) {

		ImportMasterEntitySoap[] soapModels =
			new ImportMasterEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImportMasterEntitySoap[][] toSoapModels(
		ImportMasterEntity[][] models) {

		ImportMasterEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ImportMasterEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImportMasterEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImportMasterEntitySoap[] toSoapModels(
		List<ImportMasterEntity> models) {

		List<ImportMasterEntitySoap> soapModels =
			new ArrayList<ImportMasterEntitySoap>(models.size());

		for (ImportMasterEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ImportMasterEntitySoap[soapModels.size()]);
	}

	public ImportMasterEntitySoap() {
	}

	public long getPrimaryKey() {
		return _importMasterEntityId;
	}

	public void setPrimaryKey(long pk) {
		setImportMasterEntityId(pk);
	}

	public long getImportMasterEntityId() {
		return _importMasterEntityId;
	}

	public void setImportMasterEntityId(long importMasterEntityId) {
		_importMasterEntityId = importMasterEntityId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getImportFileId() {
		return _importFileId;
	}

	public void setImportFileId(long importFileId) {
		_importFileId = importFileId;
	}

	private long _importMasterEntityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _entityClass;
	private String _description;
	private long _importFileId;

}