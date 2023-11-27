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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.jetform.liferay.service.http.FormDefinitionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FormDefinitionSoap implements Serializable {

	public static FormDefinitionSoap toSoapModel(FormDefinition model) {
		FormDefinitionSoap soapModel = new FormDefinitionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFormDefinitionId(model.getFormDefinitionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFormKey(model.getFormKey());
		soapModel.setFormClass(model.getFormClass());
		soapModel.setEntityClass(model.getEntityClass());
		soapModel.setDefinition(model.getDefinition());

		return soapModel;
	}

	public static FormDefinitionSoap[] toSoapModels(FormDefinition[] models) {
		FormDefinitionSoap[] soapModels = new FormDefinitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormDefinitionSoap[][] toSoapModels(
		FormDefinition[][] models) {

		FormDefinitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FormDefinitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormDefinitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormDefinitionSoap[] toSoapModels(
		List<FormDefinition> models) {

		List<FormDefinitionSoap> soapModels = new ArrayList<FormDefinitionSoap>(
			models.size());

		for (FormDefinition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormDefinitionSoap[soapModels.size()]);
	}

	public FormDefinitionSoap() {
	}

	public long getPrimaryKey() {
		return _formDefinitionId;
	}

	public void setPrimaryKey(long pk) {
		setFormDefinitionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFormDefinitionId() {
		return _formDefinitionId;
	}

	public void setFormDefinitionId(long formDefinitionId) {
		_formDefinitionId = formDefinitionId;
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

	public String getFormKey() {
		return _formKey;
	}

	public void setFormKey(String formKey) {
		_formKey = formKey;
	}

	public String getFormClass() {
		return _formClass;
	}

	public void setFormClass(String formClass) {
		_formClass = formClass;
	}

	public String getEntityClass() {
		return _entityClass;
	}

	public void setEntityClass(String entityClass) {
		_entityClass = entityClass;
	}

	public String getDefinition() {
		return _definition;
	}

	public void setDefinition(String definition) {
		_definition = definition;
	}

	private String _uuid;
	private long _formDefinitionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _formKey;
	private String _formClass;
	private String _entityClass;
	private String _definition;

}