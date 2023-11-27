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

import com.adjecti.mdm.liferay.model.WorkAreaMinor;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkAreaMinor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkAreaMinorCacheModel
	implements CacheModel<WorkAreaMinor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkAreaMinorCacheModel)) {
			return false;
		}

		WorkAreaMinorCacheModel workAreaMinorCacheModel =
			(WorkAreaMinorCacheModel)object;

		if (workAreaMinorId == workAreaMinorCacheModel.workAreaMinorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workAreaMinorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{workAreaMinorId=");
		sb.append(workAreaMinorId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", workAreaMajorId=");
		sb.append(workAreaMajorId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkAreaMinor toEntityModel() {
		WorkAreaMinorImpl workAreaMinorImpl = new WorkAreaMinorImpl();

		workAreaMinorImpl.setWorkAreaMinorId(workAreaMinorId);
		workAreaMinorImpl.setGroupId(groupId);
		workAreaMinorImpl.setCompanyId(companyId);
		workAreaMinorImpl.setUserId(userId);

		if (userName == null) {
			workAreaMinorImpl.setUserName("");
		}
		else {
			workAreaMinorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workAreaMinorImpl.setCreateDate(null);
		}
		else {
			workAreaMinorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workAreaMinorImpl.setModifiedDate(null);
		}
		else {
			workAreaMinorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			workAreaMinorImpl.setCode("");
		}
		else {
			workAreaMinorImpl.setCode(code);
		}

		if (name == null) {
			workAreaMinorImpl.setName("");
		}
		else {
			workAreaMinorImpl.setName(name);
		}

		workAreaMinorImpl.setWorkAreaMajorId(workAreaMajorId);
		workAreaMinorImpl.setDeleted(deleted);
		workAreaMinorImpl.setStatus(status);

		workAreaMinorImpl.resetOriginalValues();

		return workAreaMinorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workAreaMinorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		workAreaMajorId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(workAreaMinorId);

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

		objectOutput.writeLong(workAreaMajorId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long workAreaMinorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public long workAreaMajorId;
	public boolean deleted;
	public int status;

}