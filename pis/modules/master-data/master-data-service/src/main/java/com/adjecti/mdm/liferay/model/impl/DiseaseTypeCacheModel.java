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

import com.adjecti.mdm.liferay.model.DiseaseType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DiseaseType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DiseaseTypeCacheModel
	implements CacheModel<DiseaseType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DiseaseTypeCacheModel)) {
			return false;
		}

		DiseaseTypeCacheModel diseaseTypeCacheModel =
			(DiseaseTypeCacheModel)object;

		if (diseaseTypeId == diseaseTypeCacheModel.diseaseTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, diseaseTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{diseaseTypeId=");
		sb.append(diseaseTypeId);
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
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DiseaseType toEntityModel() {
		DiseaseTypeImpl diseaseTypeImpl = new DiseaseTypeImpl();

		diseaseTypeImpl.setDiseaseTypeId(diseaseTypeId);
		diseaseTypeImpl.setGroupId(groupId);
		diseaseTypeImpl.setCompanyId(companyId);
		diseaseTypeImpl.setUserId(userId);

		if (userName == null) {
			diseaseTypeImpl.setUserName("");
		}
		else {
			diseaseTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			diseaseTypeImpl.setCreateDate(null);
		}
		else {
			diseaseTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			diseaseTypeImpl.setModifiedDate(null);
		}
		else {
			diseaseTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			diseaseTypeImpl.setCode("");
		}
		else {
			diseaseTypeImpl.setCode(code);
		}

		if (description == null) {
			diseaseTypeImpl.setDescription("");
		}
		else {
			diseaseTypeImpl.setDescription(description);
		}

		if (name == null) {
			diseaseTypeImpl.setName("");
		}
		else {
			diseaseTypeImpl.setName(name);
		}

		diseaseTypeImpl.setDeleted(deleted);
		diseaseTypeImpl.setStatus(status);

		diseaseTypeImpl.resetOriginalValues();

		return diseaseTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		diseaseTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(diseaseTypeId);

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

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long diseaseTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String description;
	public String name;
	public boolean deleted;
	public int status;

}