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

package com.adjecti.dashboard.widget.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.dashboard.widget.service.http.DashboardWidgetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DashboardWidgetSoap implements Serializable {

	public static DashboardWidgetSoap toSoapModel(DashboardWidget model) {
		DashboardWidgetSoap soapModel = new DashboardWidgetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDashboardWidgetId(model.getDashboardWidgetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPortletName(model.getPortletName());
		soapModel.setThumbnail(model.getThumbnail());
		soapModel.setAdded(model.isAdded());

		return soapModel;
	}

	public static DashboardWidgetSoap[] toSoapModels(DashboardWidget[] models) {
		DashboardWidgetSoap[] soapModels =
			new DashboardWidgetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DashboardWidgetSoap[][] toSoapModels(
		DashboardWidget[][] models) {

		DashboardWidgetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DashboardWidgetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DashboardWidgetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DashboardWidgetSoap[] toSoapModels(
		List<DashboardWidget> models) {

		List<DashboardWidgetSoap> soapModels =
			new ArrayList<DashboardWidgetSoap>(models.size());

		for (DashboardWidget model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DashboardWidgetSoap[soapModels.size()]);
	}

	public DashboardWidgetSoap() {
	}

	public long getPrimaryKey() {
		return _dashboardWidgetId;
	}

	public void setPrimaryKey(long pk) {
		setDashboardWidgetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDashboardWidgetId() {
		return _dashboardWidgetId;
	}

	public void setDashboardWidgetId(long dashboardWidgetId) {
		_dashboardWidgetId = dashboardWidgetId;
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

	public String getPortletName() {
		return _portletName;
	}

	public void setPortletName(String portletName) {
		_portletName = portletName;
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
	private long _dashboardWidgetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _portletName;
	private String _thumbnail;
	private boolean _added;

}