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

import com.adjecti.mdm.liferay.model.WorkAreaMajor;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkAreaMajor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkAreaMajorCacheModel
	implements CacheModel<WorkAreaMajor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkAreaMajorCacheModel)) {
			return false;
		}

		WorkAreaMajorCacheModel workAreaMajorCacheModel =
			(WorkAreaMajorCacheModel)object;

		if (workAreaMajorId == workAreaMajorCacheModel.workAreaMajorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workAreaMajorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{workAreaMajorId=");
		sb.append(workAreaMajorId);
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
		sb.append(", workAreaTypeId=");
		sb.append(workAreaTypeId);
		sb.append(", parentWorkAreaId=");
		sb.append(parentWorkAreaId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkAreaMajor toEntityModel() {
		WorkAreaMajorImpl workAreaMajorImpl = new WorkAreaMajorImpl();

		workAreaMajorImpl.setWorkAreaMajorId(workAreaMajorId);
		workAreaMajorImpl.setGroupId(groupId);
		workAreaMajorImpl.setCompanyId(companyId);
		workAreaMajorImpl.setUserId(userId);

		if (userName == null) {
			workAreaMajorImpl.setUserName("");
		}
		else {
			workAreaMajorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workAreaMajorImpl.setCreateDate(null);
		}
		else {
			workAreaMajorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workAreaMajorImpl.setModifiedDate(null);
		}
		else {
			workAreaMajorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			workAreaMajorImpl.setCode("");
		}
		else {
			workAreaMajorImpl.setCode(code);
		}

		if (name == null) {
			workAreaMajorImpl.setName("");
		}
		else {
			workAreaMajorImpl.setName(name);
		}

		workAreaMajorImpl.setWorkAreaTypeId(workAreaTypeId);
		workAreaMajorImpl.setParentWorkAreaId(parentWorkAreaId);
		workAreaMajorImpl.setDeleted(deleted);
		workAreaMajorImpl.setStatus(status);

		workAreaMajorImpl.resetOriginalValues();

		return workAreaMajorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workAreaMajorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		workAreaTypeId = objectInput.readLong();

		parentWorkAreaId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(workAreaMajorId);

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

		objectOutput.writeLong(workAreaTypeId);

		objectOutput.writeLong(parentWorkAreaId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long workAreaMajorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public long workAreaTypeId;
	public long parentWorkAreaId;
	public boolean deleted;
	public int status;

}