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

import com.adjecti.mdm.liferay.model.JoiningMode;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JoiningMode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JoiningModeCacheModel
	implements CacheModel<JoiningMode>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JoiningModeCacheModel)) {
			return false;
		}

		JoiningModeCacheModel joiningModeCacheModel =
			(JoiningModeCacheModel)object;

		if (joiningModeId == joiningModeCacheModel.joiningModeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, joiningModeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{joiningModeId=");
		sb.append(joiningModeId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", code=");
		sb.append(code);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JoiningMode toEntityModel() {
		JoiningModeImpl joiningModeImpl = new JoiningModeImpl();

		joiningModeImpl.setJoiningModeId(joiningModeId);
		joiningModeImpl.setGroupId(groupId);
		joiningModeImpl.setCompanyId(companyId);
		joiningModeImpl.setUserId(userId);

		if (userName == null) {
			joiningModeImpl.setUserName("");
		}
		else {
			joiningModeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			joiningModeImpl.setCreateDate(null);
		}
		else {
			joiningModeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			joiningModeImpl.setModifiedDate(null);
		}
		else {
			joiningModeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			joiningModeImpl.setName("");
		}
		else {
			joiningModeImpl.setName(name);
		}

		if (description == null) {
			joiningModeImpl.setDescription("");
		}
		else {
			joiningModeImpl.setDescription(description);
		}

		if (code == null) {
			joiningModeImpl.setCode("");
		}
		else {
			joiningModeImpl.setCode(code);
		}

		joiningModeImpl.setDeleted(deleted);
		joiningModeImpl.setStatus(status);

		joiningModeImpl.resetOriginalValues();

		return joiningModeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		joiningModeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		code = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(joiningModeId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long joiningModeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String code;
	public boolean deleted;
	public int status;

}