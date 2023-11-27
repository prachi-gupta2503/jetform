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

import com.adjecti.mdm.liferay.model.GradeMode;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GradeMode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GradeModeCacheModel
	implements CacheModel<GradeMode>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GradeModeCacheModel)) {
			return false;
		}

		GradeModeCacheModel gradeModeCacheModel = (GradeModeCacheModel)object;

		if (gradeModeId == gradeModeCacheModel.gradeModeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, gradeModeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{gradeModeId=");
		sb.append(gradeModeId);
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
	public GradeMode toEntityModel() {
		GradeModeImpl gradeModeImpl = new GradeModeImpl();

		gradeModeImpl.setGradeModeId(gradeModeId);
		gradeModeImpl.setGroupId(groupId);
		gradeModeImpl.setCompanyId(companyId);
		gradeModeImpl.setUserId(userId);

		if (userName == null) {
			gradeModeImpl.setUserName("");
		}
		else {
			gradeModeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gradeModeImpl.setCreateDate(null);
		}
		else {
			gradeModeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gradeModeImpl.setModifiedDate(null);
		}
		else {
			gradeModeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			gradeModeImpl.setName("");
		}
		else {
			gradeModeImpl.setName(name);
		}

		if (code == null) {
			gradeModeImpl.setCode("");
		}
		else {
			gradeModeImpl.setCode(code);
		}

		gradeModeImpl.setDeleted(deleted);
		gradeModeImpl.setStatus(status);

		gradeModeImpl.resetOriginalValues();

		return gradeModeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		gradeModeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(gradeModeId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long gradeModeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
	public boolean deleted;
	public int status;

}