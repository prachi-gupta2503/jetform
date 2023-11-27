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

import com.adjecti.mdm.liferay.model.OccupationServiceType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OccupationServiceType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OccupationServiceTypeCacheModel
	implements CacheModel<OccupationServiceType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OccupationServiceTypeCacheModel)) {
			return false;
		}

		OccupationServiceTypeCacheModel occupationServiceTypeCacheModel =
			(OccupationServiceTypeCacheModel)object;

		if (occupationServiceTypeId ==
				occupationServiceTypeCacheModel.occupationServiceTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, occupationServiceTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{occupationServiceTypeId=");
		sb.append(occupationServiceTypeId);
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
	public OccupationServiceType toEntityModel() {
		OccupationServiceTypeImpl occupationServiceTypeImpl =
			new OccupationServiceTypeImpl();

		occupationServiceTypeImpl.setOccupationServiceTypeId(
			occupationServiceTypeId);
		occupationServiceTypeImpl.setGroupId(groupId);
		occupationServiceTypeImpl.setCompanyId(companyId);
		occupationServiceTypeImpl.setUserId(userId);

		if (userName == null) {
			occupationServiceTypeImpl.setUserName("");
		}
		else {
			occupationServiceTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			occupationServiceTypeImpl.setCreateDate(null);
		}
		else {
			occupationServiceTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			occupationServiceTypeImpl.setModifiedDate(null);
		}
		else {
			occupationServiceTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			occupationServiceTypeImpl.setCode("");
		}
		else {
			occupationServiceTypeImpl.setCode(code);
		}

		if (name == null) {
			occupationServiceTypeImpl.setName("");
		}
		else {
			occupationServiceTypeImpl.setName(name);
		}

		if (description == null) {
			occupationServiceTypeImpl.setDescription("");
		}
		else {
			occupationServiceTypeImpl.setDescription(description);
		}

		occupationServiceTypeImpl.setDeleted(deleted);
		occupationServiceTypeImpl.setStatus(status);

		occupationServiceTypeImpl.resetOriginalValues();

		return occupationServiceTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		occupationServiceTypeId = objectInput.readLong();

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
		objectOutput.writeLong(occupationServiceTypeId);

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

	public long occupationServiceTypeId;
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