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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.jetform.liferay.service.http.EntityWorkflowServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EntityWorkflowSoap implements Serializable {

	public static EntityWorkflowSoap toSoapModel(EntityWorkflow model) {
		EntityWorkflowSoap soapModel = new EntityWorkflowSoap();

		soapModel.setEntityWorkflowId(model.getEntityWorkflowId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setRemark(model.getRemark());

		return soapModel;
	}

	public static EntityWorkflowSoap[] toSoapModels(EntityWorkflow[] models) {
		EntityWorkflowSoap[] soapModels = new EntityWorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntityWorkflowSoap[][] toSoapModels(
		EntityWorkflow[][] models) {

		EntityWorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EntityWorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntityWorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntityWorkflowSoap[] toSoapModels(
		List<EntityWorkflow> models) {

		List<EntityWorkflowSoap> soapModels = new ArrayList<EntityWorkflowSoap>(
			models.size());

		for (EntityWorkflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntityWorkflowSoap[soapModels.size()]);
	}

	public EntityWorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _entityWorkflowId;
	}

	public void setPrimaryKey(long pk) {
		setEntityWorkflowId(pk);
	}

	public long getEntityWorkflowId() {
		return _entityWorkflowId;
	}

	public void setEntityWorkflowId(long entityWorkflowId) {
		_entityWorkflowId = entityWorkflowId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getRemark() {
		return _remark;
	}

	public void setRemark(String remark) {
		_remark = remark;
	}

	private long _entityWorkflowId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private String _className;
	private long _classPK;
	private String _remark;

}