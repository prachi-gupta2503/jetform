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

import com.adjecti.mdm.liferay.model.DesignationGroup;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DesignationGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DesignationGroupCacheModel
	implements CacheModel<DesignationGroup>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DesignationGroupCacheModel)) {
			return false;
		}

		DesignationGroupCacheModel designationGroupCacheModel =
			(DesignationGroupCacheModel)object;

		if (designationGroupId ==
				designationGroupCacheModel.designationGroupId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, designationGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{designationGroupId=");
		sb.append(designationGroupId);
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
		sb.append(", uuid=");
		sb.append(uuid);
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
	public DesignationGroup toEntityModel() {
		DesignationGroupImpl designationGroupImpl = new DesignationGroupImpl();

		designationGroupImpl.setDesignationGroupId(designationGroupId);
		designationGroupImpl.setGroupId(groupId);
		designationGroupImpl.setCompanyId(companyId);
		designationGroupImpl.setUserId(userId);

		if (userName == null) {
			designationGroupImpl.setUserName("");
		}
		else {
			designationGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			designationGroupImpl.setCreateDate(null);
		}
		else {
			designationGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designationGroupImpl.setModifiedDate(null);
		}
		else {
			designationGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uuid == null) {
			designationGroupImpl.setUuid("");
		}
		else {
			designationGroupImpl.setUuid(uuid);
		}

		if (code == null) {
			designationGroupImpl.setCode("");
		}
		else {
			designationGroupImpl.setCode(code);
		}

		if (description == null) {
			designationGroupImpl.setDescription("");
		}
		else {
			designationGroupImpl.setDescription(description);
		}

		if (name == null) {
			designationGroupImpl.setName("");
		}
		else {
			designationGroupImpl.setName(name);
		}

		designationGroupImpl.setDeleted(deleted);
		designationGroupImpl.setStatus(status);

		designationGroupImpl.resetOriginalValues();

		return designationGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designationGroupId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uuid = objectInput.readUTF();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(designationGroupId);

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

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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

	public long designationGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String uuid;
	public String code;
	public String description;
	public String name;
	public boolean deleted;
	public int status;

}