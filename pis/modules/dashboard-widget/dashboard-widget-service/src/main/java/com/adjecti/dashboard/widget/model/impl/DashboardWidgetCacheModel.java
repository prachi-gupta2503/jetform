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

package com.adjecti.dashboard.widget.model.impl;

import com.adjecti.dashboard.widget.model.DashboardWidget;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DashboardWidget in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DashboardWidgetCacheModel
	implements CacheModel<DashboardWidget>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DashboardWidgetCacheModel)) {
			return false;
		}

		DashboardWidgetCacheModel dashboardWidgetCacheModel =
			(DashboardWidgetCacheModel)object;

		if (dashboardWidgetId == dashboardWidgetCacheModel.dashboardWidgetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dashboardWidgetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dashboardWidgetId=");
		sb.append(dashboardWidgetId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", portletName=");
		sb.append(portletName);
		sb.append(", thumbnail=");
		sb.append(thumbnail);
		sb.append(", added=");
		sb.append(added);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DashboardWidget toEntityModel() {
		DashboardWidgetImpl dashboardWidgetImpl = new DashboardWidgetImpl();

		if (uuid == null) {
			dashboardWidgetImpl.setUuid("");
		}
		else {
			dashboardWidgetImpl.setUuid(uuid);
		}

		dashboardWidgetImpl.setDashboardWidgetId(dashboardWidgetId);
		dashboardWidgetImpl.setGroupId(groupId);
		dashboardWidgetImpl.setCompanyId(companyId);
		dashboardWidgetImpl.setUserId(userId);

		if (userName == null) {
			dashboardWidgetImpl.setUserName("");
		}
		else {
			dashboardWidgetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dashboardWidgetImpl.setCreateDate(null);
		}
		else {
			dashboardWidgetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dashboardWidgetImpl.setModifiedDate(null);
		}
		else {
			dashboardWidgetImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (portletName == null) {
			dashboardWidgetImpl.setPortletName("");
		}
		else {
			dashboardWidgetImpl.setPortletName(portletName);
		}

		if (thumbnail == null) {
			dashboardWidgetImpl.setThumbnail("");
		}
		else {
			dashboardWidgetImpl.setThumbnail(thumbnail);
		}

		dashboardWidgetImpl.setAdded(added);

		dashboardWidgetImpl.resetOriginalValues();

		return dashboardWidgetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dashboardWidgetId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		portletName = objectInput.readUTF();
		thumbnail = objectInput.readUTF();

		added = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dashboardWidgetId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (portletName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(portletName);
		}

		if (thumbnail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thumbnail);
		}

		objectOutput.writeBoolean(added);
	}

	public String uuid;
	public long dashboardWidgetId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String portletName;
	public String thumbnail;
	public boolean added;

}