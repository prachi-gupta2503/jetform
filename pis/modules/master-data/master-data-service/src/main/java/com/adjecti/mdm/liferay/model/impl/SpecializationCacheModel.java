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

import com.adjecti.mdm.liferay.model.Specialization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Specialization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecializationCacheModel
	implements CacheModel<Specialization>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecializationCacheModel)) {
			return false;
		}

		SpecializationCacheModel specializationCacheModel =
			(SpecializationCacheModel)object;

		if (specializationId == specializationCacheModel.specializationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specializationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{specializationId=");
		sb.append(specializationId);
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
		sb.append(", description=");
		sb.append(description);
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
	public Specialization toEntityModel() {
		SpecializationImpl specializationImpl = new SpecializationImpl();

		specializationImpl.setSpecializationId(specializationId);
		specializationImpl.setGroupId(groupId);
		specializationImpl.setCompanyId(companyId);
		specializationImpl.setUserId(userId);

		if (userName == null) {
			specializationImpl.setUserName("");
		}
		else {
			specializationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			specializationImpl.setCreateDate(null);
		}
		else {
			specializationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			specializationImpl.setModifiedDate(null);
		}
		else {
			specializationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			specializationImpl.setDescription("");
		}
		else {
			specializationImpl.setDescription(description);
		}

		if (name == null) {
			specializationImpl.setName("");
		}
		else {
			specializationImpl.setName(name);
		}

		if (code == null) {
			specializationImpl.setCode("");
		}
		else {
			specializationImpl.setCode(code);
		}

		specializationImpl.setDeleted(deleted);
		specializationImpl.setStatus(status);

		specializationImpl.resetOriginalValues();

		return specializationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		specializationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(specializationId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long specializationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String name;
	public String code;
	public boolean deleted;
	public int status;

}