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

import com.adjecti.mdm.liferay.model.FamilyRelation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FamilyRelation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FamilyRelationCacheModel
	implements CacheModel<FamilyRelation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FamilyRelationCacheModel)) {
			return false;
		}

		FamilyRelationCacheModel familyRelationCacheModel =
			(FamilyRelationCacheModel)object;

		if (familyRelationId == familyRelationCacheModel.familyRelationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, familyRelationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{familyRelationId=");
		sb.append(familyRelationId);
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
	public FamilyRelation toEntityModel() {
		FamilyRelationImpl familyRelationImpl = new FamilyRelationImpl();

		familyRelationImpl.setFamilyRelationId(familyRelationId);
		familyRelationImpl.setGroupId(groupId);
		familyRelationImpl.setCompanyId(companyId);
		familyRelationImpl.setUserId(userId);

		if (userName == null) {
			familyRelationImpl.setUserName("");
		}
		else {
			familyRelationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			familyRelationImpl.setCreateDate(null);
		}
		else {
			familyRelationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			familyRelationImpl.setModifiedDate(null);
		}
		else {
			familyRelationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			familyRelationImpl.setDescription("");
		}
		else {
			familyRelationImpl.setDescription(description);
		}

		if (code == null) {
			familyRelationImpl.setCode("");
		}
		else {
			familyRelationImpl.setCode(code);
		}

		if (name == null) {
			familyRelationImpl.setName("");
		}
		else {
			familyRelationImpl.setName(name);
		}

		familyRelationImpl.setDeleted(deleted);
		familyRelationImpl.setStatus(status);

		familyRelationImpl.resetOriginalValues();

		return familyRelationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		familyRelationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(familyRelationId);

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

	public long familyRelationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
	public String name;
	public boolean deleted;
	public int status;

}