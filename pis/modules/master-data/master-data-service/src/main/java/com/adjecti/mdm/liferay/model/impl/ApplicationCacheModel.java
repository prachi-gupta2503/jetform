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

import com.adjecti.mdm.liferay.model.Application;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Application in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ApplicationCacheModel
	implements CacheModel<Application>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ApplicationCacheModel)) {
			return false;
		}

		ApplicationCacheModel applicationCacheModel =
			(ApplicationCacheModel)object;

		if (applicationId == applicationCacheModel.applicationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{applicationId=");
		sb.append(applicationId);
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
		sb.append(", oemId=");
		sb.append(oemId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Application toEntityModel() {
		ApplicationImpl applicationImpl = new ApplicationImpl();

		applicationImpl.setApplicationId(applicationId);
		applicationImpl.setGroupId(groupId);
		applicationImpl.setCompanyId(companyId);
		applicationImpl.setUserId(userId);

		if (userName == null) {
			applicationImpl.setUserName("");
		}
		else {
			applicationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationImpl.setCreateDate(null);
		}
		else {
			applicationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationImpl.setModifiedDate(null);
		}
		else {
			applicationImpl.setModifiedDate(new Date(modifiedDate));
		}

		applicationImpl.setOemId(oemId);

		if (code == null) {
			applicationImpl.setCode("");
		}
		else {
			applicationImpl.setCode(code);
		}

		if (name == null) {
			applicationImpl.setName("");
		}
		else {
			applicationImpl.setName(name);
		}

		applicationImpl.setDeleted(deleted);
		applicationImpl.setStatus(status);

		applicationImpl.resetOriginalValues();

		return applicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		oemId = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(applicationId);

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

		objectOutput.writeLong(oemId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long applicationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long oemId;
	public String code;
	public String name;
	public boolean deleted;
	public int status;

}