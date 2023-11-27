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

package com.adjecti.mdm.liferay.model.impl;

import com.adjecti.mdm.liferay.model.MasterEntity;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MasterEntityCacheModel
	implements CacheModel<MasterEntity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterEntityCacheModel)) {
			return false;
		}

		MasterEntityCacheModel masterEntityCacheModel =
			(MasterEntityCacheModel)object;

		if (masterEntityId == masterEntityCacheModel.masterEntityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterEntityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{masterEntityId=");
		sb.append(masterEntityId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", entityClass=");
		sb.append(entityClass);
		sb.append(", icon=");
		sb.append(icon);
		sb.append(", link=");
		sb.append(link);
		sb.append(", description=");
		sb.append(description);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterEntity toEntityModel() {
		MasterEntityImpl masterEntityImpl = new MasterEntityImpl();

		masterEntityImpl.setMasterEntityId(masterEntityId);
		masterEntityImpl.setGroupId(groupId);
		masterEntityImpl.setCompanyId(companyId);
		masterEntityImpl.setUserId(userId);

		if (userName == null) {
			masterEntityImpl.setUserName("");
		}
		else {
			masterEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterEntityImpl.setCreateDate(null);
		}
		else {
			masterEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterEntityImpl.setModifiedDate(null);
		}
		else {
			masterEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			masterEntityImpl.setName("");
		}
		else {
			masterEntityImpl.setName(name);
		}

		if (entityClass == null) {
			masterEntityImpl.setEntityClass("");
		}
		else {
			masterEntityImpl.setEntityClass(entityClass);
		}

		if (icon == null) {
			masterEntityImpl.setIcon("");
		}
		else {
			masterEntityImpl.setIcon(icon);
		}

		if (link == null) {
			masterEntityImpl.setLink("");
		}
		else {
			masterEntityImpl.setLink(link);
		}

		if (description == null) {
			masterEntityImpl.setDescription("");
		}
		else {
			masterEntityImpl.setDescription(description);
		}

		masterEntityImpl.setDeleted(deleted);
		masterEntityImpl.setStatus(status);

		masterEntityImpl.resetOriginalValues();

		return masterEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterEntityId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		entityClass = objectInput.readUTF();
		icon = objectInput.readUTF();
		link = objectInput.readUTF();
		description = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterEntityId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (entityClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityClass);
		}

		if (icon == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(icon);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long masterEntityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String entityClass;
	public String icon;
	public String link;
	public String description;
	public boolean deleted;
	public int status;

}