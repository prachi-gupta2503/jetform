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

import com.adjecti.mdm.liferay.model.CadreDesignation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CadreDesignation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CadreDesignationCacheModel
	implements CacheModel<CadreDesignation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CadreDesignationCacheModel)) {
			return false;
		}

		CadreDesignationCacheModel cadreDesignationCacheModel =
			(CadreDesignationCacheModel)object;

		if (cadreDesignationId ==
				cadreDesignationCacheModel.cadreDesignationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cadreDesignationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{cadreDesignationId=");
		sb.append(cadreDesignationId);
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
		sb.append(", cadreId=");
		sb.append(cadreId);
		sb.append(", designationId=");
		sb.append(designationId);
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
	public CadreDesignation toEntityModel() {
		CadreDesignationImpl cadreDesignationImpl = new CadreDesignationImpl();

		cadreDesignationImpl.setCadreDesignationId(cadreDesignationId);
		cadreDesignationImpl.setGroupId(groupId);
		cadreDesignationImpl.setCompanyId(companyId);
		cadreDesignationImpl.setUserId(userId);

		if (userName == null) {
			cadreDesignationImpl.setUserName("");
		}
		else {
			cadreDesignationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cadreDesignationImpl.setCreateDate(null);
		}
		else {
			cadreDesignationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cadreDesignationImpl.setModifiedDate(null);
		}
		else {
			cadreDesignationImpl.setModifiedDate(new Date(modifiedDate));
		}

		cadreDesignationImpl.setCadreId(cadreId);
		cadreDesignationImpl.setDesignationId(designationId);
		cadreDesignationImpl.setRank(rank);
		cadreDesignationImpl.setDeleted(deleted);
		cadreDesignationImpl.setStatus(status);

		cadreDesignationImpl.resetOriginalValues();

		return cadreDesignationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cadreDesignationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		cadreId = objectInput.readLong();

		designationId = objectInput.readLong();

		rank = objectInput.readInt();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cadreDesignationId);

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

		objectOutput.writeLong(cadreId);

		objectOutput.writeLong(designationId);

		objectOutput.writeInt(rank);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long cadreDesignationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long cadreId;
	public long designationId;
	public int rank;
	public boolean deleted;
	public int status;

}