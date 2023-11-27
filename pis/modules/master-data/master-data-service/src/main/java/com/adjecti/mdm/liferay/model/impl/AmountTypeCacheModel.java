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

import com.adjecti.mdm.liferay.model.AmountType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AmountType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmountTypeCacheModel
	implements CacheModel<AmountType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AmountTypeCacheModel)) {
			return false;
		}

		AmountTypeCacheModel amountTypeCacheModel =
			(AmountTypeCacheModel)object;

		if (amountTypeId == amountTypeCacheModel.amountTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amountTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{amountTypeId=");
		sb.append(amountTypeId);
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
	public AmountType toEntityModel() {
		AmountTypeImpl amountTypeImpl = new AmountTypeImpl();

		amountTypeImpl.setAmountTypeId(amountTypeId);
		amountTypeImpl.setGroupId(groupId);
		amountTypeImpl.setCompanyId(companyId);
		amountTypeImpl.setUserId(userId);

		if (userName == null) {
			amountTypeImpl.setUserName("");
		}
		else {
			amountTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			amountTypeImpl.setCreateDate(null);
		}
		else {
			amountTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amountTypeImpl.setModifiedDate(null);
		}
		else {
			amountTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			amountTypeImpl.setName("");
		}
		else {
			amountTypeImpl.setName(name);
		}

		amountTypeImpl.setDeleted(deleted);
		amountTypeImpl.setStatus(status);

		amountTypeImpl.resetOriginalValues();

		return amountTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amountTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(amountTypeId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long amountTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public boolean deleted;
	public int status;

}