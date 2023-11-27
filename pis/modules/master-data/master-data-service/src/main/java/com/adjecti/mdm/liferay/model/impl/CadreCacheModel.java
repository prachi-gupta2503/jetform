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

import com.adjecti.mdm.liferay.model.Cadre;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cadre in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CadreCacheModel implements CacheModel<Cadre>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CadreCacheModel)) {
			return false;
		}

		CadreCacheModel cadreCacheModel = (CadreCacheModel)object;

		if (cadreId == cadreCacheModel.cadreId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cadreId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{cadreId=");
		sb.append(cadreId);
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
		sb.append(", designationGroupId=");
		sb.append(designationGroupId);
		sb.append(", rank=");
		sb.append(rank);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cadre toEntityModel() {
		CadreImpl cadreImpl = new CadreImpl();

		cadreImpl.setCadreId(cadreId);
		cadreImpl.setGroupId(groupId);
		cadreImpl.setCompanyId(companyId);
		cadreImpl.setUserId(userId);

		if (userName == null) {
			cadreImpl.setUserName("");
		}
		else {
			cadreImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cadreImpl.setCreateDate(null);
		}
		else {
			cadreImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cadreImpl.setModifiedDate(null);
		}
		else {
			cadreImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			cadreImpl.setCode("");
		}
		else {
			cadreImpl.setCode(code);
		}

		if (name == null) {
			cadreImpl.setName("");
		}
		else {
			cadreImpl.setName(name);
		}

		if (description == null) {
			cadreImpl.setDescription("");
		}
		else {
			cadreImpl.setDescription(description);
		}

		cadreImpl.setDesignationGroupId(designationGroupId);
		cadreImpl.setRank(rank);
		cadreImpl.setDeleted(deleted);
		cadreImpl.setStatus(status);

		cadreImpl.resetOriginalValues();

		return cadreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cadreId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		designationGroupId = objectInput.readLong();

		rank = objectInput.readInt();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cadreId);

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

		objectOutput.writeLong(designationGroupId);

		objectOutput.writeInt(rank);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long cadreId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public String description;
	public long designationGroupId;
	public int rank;
	public boolean deleted;
	public int status;

}