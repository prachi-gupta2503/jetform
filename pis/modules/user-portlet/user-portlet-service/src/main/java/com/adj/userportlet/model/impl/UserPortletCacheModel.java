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

package com.adj.userportlet.model.impl;

import com.adj.userportlet.model.UserPortlet;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserPortlet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserPortletCacheModel
	implements CacheModel<UserPortlet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserPortletCacheModel)) {
			return false;
		}

		UserPortletCacheModel userPortletCacheModel =
			(UserPortletCacheModel)object;

		if (id == userPortletCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
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
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", thumbnail=");
		sb.append(thumbnail);
		sb.append(", added=");
		sb.append(added);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserPortlet toEntityModel() {
		UserPortletImpl userPortletImpl = new UserPortletImpl();

		if (uuid == null) {
			userPortletImpl.setUuid("");
		}
		else {
			userPortletImpl.setUuid(uuid);
		}

		userPortletImpl.setId(id);
		userPortletImpl.setGroupId(groupId);
		userPortletImpl.setCompanyId(companyId);
		userPortletImpl.setUserId(userId);

		if (userName == null) {
			userPortletImpl.setUserName("");
		}
		else {
			userPortletImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userPortletImpl.setCreateDate(null);
		}
		else {
			userPortletImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userPortletImpl.setModifiedDate(null);
		}
		else {
			userPortletImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (portletId == null) {
			userPortletImpl.setPortletId("");
		}
		else {
			userPortletImpl.setPortletId(portletId);
		}

		if (thumbnail == null) {
			userPortletImpl.setThumbnail("");
		}
		else {
			userPortletImpl.setThumbnail(thumbnail);
		}

		userPortletImpl.setAdded(added);

		userPortletImpl.resetOriginalValues();

		return userPortletImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		portletId = objectInput.readUTF();
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

		objectOutput.writeLong(id);

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

		if (portletId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(portletId);
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
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String portletId;
	public String thumbnail;
	public boolean added;

}