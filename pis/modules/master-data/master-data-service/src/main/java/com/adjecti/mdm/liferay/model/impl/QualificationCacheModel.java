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

import com.adjecti.mdm.liferay.model.Qualification;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Qualification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QualificationCacheModel
	implements CacheModel<Qualification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QualificationCacheModel)) {
			return false;
		}

		QualificationCacheModel qualificationCacheModel =
			(QualificationCacheModel)object;

		if (qualificationId == qualificationCacheModel.qualificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, qualificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{qualificationId=");
		sb.append(qualificationId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Qualification toEntityModel() {
		QualificationImpl qualificationImpl = new QualificationImpl();

		qualificationImpl.setQualificationId(qualificationId);
		qualificationImpl.setGroupId(groupId);
		qualificationImpl.setCompanyId(companyId);
		qualificationImpl.setUserId(userId);

		if (userName == null) {
			qualificationImpl.setUserName("");
		}
		else {
			qualificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			qualificationImpl.setCreateDate(null);
		}
		else {
			qualificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			qualificationImpl.setModifiedDate(null);
		}
		else {
			qualificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			qualificationImpl.setCode("");
		}
		else {
			qualificationImpl.setCode(code);
		}

		if (description == null) {
			qualificationImpl.setDescription("");
		}
		else {
			qualificationImpl.setDescription(description);
		}

		if (name == null) {
			qualificationImpl.setName("");
		}
		else {
			qualificationImpl.setName(name);
		}

		if (shortName == null) {
			qualificationImpl.setShortName("");
		}
		else {
			qualificationImpl.setShortName(shortName);
		}

		if (fullName == null) {
			qualificationImpl.setFullName("");
		}
		else {
			qualificationImpl.setFullName(fullName);
		}

		qualificationImpl.setDeleted(deleted);
		qualificationImpl.setStatus(status);

		qualificationImpl.resetOriginalValues();

		return qualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		qualificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		name = objectInput.readUTF();
		shortName = objectInput.readUTF();
		fullName = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(qualificationId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (shortName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long qualificationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String description;
	public String name;
	public String shortName;
	public String fullName;
	public boolean deleted;
	public int status;

}