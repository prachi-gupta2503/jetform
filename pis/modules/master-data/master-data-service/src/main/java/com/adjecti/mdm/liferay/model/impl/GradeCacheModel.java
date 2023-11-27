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

import com.adjecti.mdm.liferay.model.Grade;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Grade in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GradeCacheModel implements CacheModel<Grade>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GradeCacheModel)) {
			return false;
		}

		GradeCacheModel gradeCacheModel = (GradeCacheModel)object;

		if (gradeId == gradeCacheModel.gradeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, gradeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{gradeId=");
		sb.append(gradeId);
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
	public Grade toEntityModel() {
		GradeImpl gradeImpl = new GradeImpl();

		gradeImpl.setGradeId(gradeId);
		gradeImpl.setGroupId(groupId);
		gradeImpl.setCompanyId(companyId);
		gradeImpl.setUserId(userId);

		if (userName == null) {
			gradeImpl.setUserName("");
		}
		else {
			gradeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gradeImpl.setCreateDate(null);
		}
		else {
			gradeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gradeImpl.setModifiedDate(null);
		}
		else {
			gradeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			gradeImpl.setCode("");
		}
		else {
			gradeImpl.setCode(code);
		}

		if (name == null) {
			gradeImpl.setName("");
		}
		else {
			gradeImpl.setName(name);
		}

		if (description == null) {
			gradeImpl.setDescription("");
		}
		else {
			gradeImpl.setDescription(description);
		}

		gradeImpl.setDeleted(deleted);
		gradeImpl.setStatus(status);

		gradeImpl.resetOriginalValues();

		return gradeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		gradeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(gradeId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long gradeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public String description;
	public boolean deleted;
	public int status;

}