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

package com.adj.userportlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adj.userportlet.service.http.UserPortletServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserPortletSoap implements Serializable {

	public static UserPortletSoap toSoapModel(UserPortlet model) {
		UserPortletSoap soapModel = new UserPortletSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setThumbnail(model.getThumbnail());
		soapModel.setAdded(model.isAdded());

		return soapModel;
	}

	public static UserPortletSoap[] toSoapModels(UserPortlet[] models) {
		UserPortletSoap[] soapModels = new UserPortletSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPortletSoap[][] toSoapModels(UserPortlet[][] models) {
		UserPortletSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserPortletSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPortletSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPortletSoap[] toSoapModels(List<UserPortlet> models) {
		List<UserPortletSoap> soapModels = new ArrayList<UserPortletSoap>(
			models.size());

		for (UserPortlet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserPortletSoap[soapModels.size()]);
	}

	public UserPortletSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getThumbnail() {
		return _thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		_thumbnail = thumbnail;
	}

	public boolean getAdded() {
		return _added;
	}

	public boolean isAdded() {
		return _added;
	}

	public void setAdded(boolean added) {
		_added = added;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _portletId;
	private String _thumbnail;
	private boolean _added;

}