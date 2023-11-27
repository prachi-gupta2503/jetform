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

import com.adjecti.mdm.liferay.model.District;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing District in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DistrictCacheModel
	implements CacheModel<District>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DistrictCacheModel)) {
			return false;
		}

		DistrictCacheModel districtCacheModel = (DistrictCacheModel)object;

		if (districtId == districtCacheModel.districtId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, districtId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{districtId=");
		sb.append(districtId);
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
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public District toEntityModel() {
		DistrictImpl districtImpl = new DistrictImpl();

		districtImpl.setDistrictId(districtId);
		districtImpl.setGroupId(groupId);
		districtImpl.setCompanyId(companyId);
		districtImpl.setUserId(userId);

		if (userName == null) {
			districtImpl.setUserName("");
		}
		else {
			districtImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			districtImpl.setCreateDate(null);
		}
		else {
			districtImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			districtImpl.setModifiedDate(null);
		}
		else {
			districtImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			districtImpl.setCode("");
		}
		else {
			districtImpl.setCode(code);
		}

		if (name == null) {
			districtImpl.setName("");
		}
		else {
			districtImpl.setName(name);
		}

		districtImpl.setStateId(stateId);
		districtImpl.setDeleted(deleted);
		districtImpl.setStatus(status);

		districtImpl.resetOriginalValues();

		return districtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		districtId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		stateId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(districtId);

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

		objectOutput.writeLong(stateId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long districtId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public long stateId;
	public boolean deleted;
	public int status;

}