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

import com.adjecti.mdm.liferay.model.LevelWisePayStructure;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LevelWisePayStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LevelWisePayStructureCacheModel
	implements CacheModel<LevelWisePayStructure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LevelWisePayStructureCacheModel)) {
			return false;
		}

		LevelWisePayStructureCacheModel levelWisePayStructureCacheModel =
			(LevelWisePayStructureCacheModel)object;

		if (levelWisePayStructureId ==
				levelWisePayStructureCacheModel.levelWisePayStructureId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, levelWisePayStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{levelWisePayStructureId=");
		sb.append(levelWisePayStructureId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LevelWisePayStructure toEntityModel() {
		LevelWisePayStructureImpl levelWisePayStructureImpl =
			new LevelWisePayStructureImpl();

		levelWisePayStructureImpl.setLevelWisePayStructureId(
			levelWisePayStructureId);
		levelWisePayStructureImpl.setGroupId(groupId);
		levelWisePayStructureImpl.setCompanyId(companyId);
		levelWisePayStructureImpl.setUserId(userId);

		if (userName == null) {
			levelWisePayStructureImpl.setUserName("");
		}
		else {
			levelWisePayStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			levelWisePayStructureImpl.setCreateDate(null);
		}
		else {
			levelWisePayStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			levelWisePayStructureImpl.setModifiedDate(null);
		}
		else {
			levelWisePayStructureImpl.setModifiedDate(new Date(modifiedDate));
		}

		levelWisePayStructureImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			levelWisePayStructureImpl.setFromDate(null);
		}
		else {
			levelWisePayStructureImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			levelWisePayStructureImpl.setToDate(null);
		}
		else {
			levelWisePayStructureImpl.setToDate(new Date(toDate));
		}

		levelWisePayStructureImpl.setLevelId(levelId);
		levelWisePayStructureImpl.setStructureId(structureId);
		levelWisePayStructureImpl.setDeleted(deleted);
		levelWisePayStructureImpl.setStatus(status);

		levelWisePayStructureImpl.resetOriginalValues();

		return levelWisePayStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		levelWisePayStructureId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		levelId = objectInput.readLong();

		structureId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(levelWisePayStructureId);

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

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(structureId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long levelWisePayStructureId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public long toDate;
	public long levelId;
	public long structureId;
	public boolean deleted;
	public int status;

}