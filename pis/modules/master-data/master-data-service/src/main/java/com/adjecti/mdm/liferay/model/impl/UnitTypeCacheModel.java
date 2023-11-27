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

import com.adjecti.mdm.liferay.model.UnitType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UnitType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UnitTypeCacheModel
	implements CacheModel<UnitType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UnitTypeCacheModel)) {
			return false;
		}

		UnitTypeCacheModel unitTypeCacheModel = (UnitTypeCacheModel)object;

		if (unitTypeId == unitTypeCacheModel.unitTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, unitTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{unitTypeId=");
		sb.append(unitTypeId);
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
		sb.append(", shortDiscription=");
		sb.append(shortDiscription);
		sb.append(", longDiscription=");
		sb.append(longDiscription);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UnitType toEntityModel() {
		UnitTypeImpl unitTypeImpl = new UnitTypeImpl();

		unitTypeImpl.setUnitTypeId(unitTypeId);
		unitTypeImpl.setGroupId(groupId);
		unitTypeImpl.setCompanyId(companyId);
		unitTypeImpl.setUserId(userId);

		if (userName == null) {
			unitTypeImpl.setUserName("");
		}
		else {
			unitTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			unitTypeImpl.setCreateDate(null);
		}
		else {
			unitTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			unitTypeImpl.setModifiedDate(null);
		}
		else {
			unitTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			unitTypeImpl.setDescription("");
		}
		else {
			unitTypeImpl.setDescription(description);
		}

		if (code == null) {
			unitTypeImpl.setCode("");
		}
		else {
			unitTypeImpl.setCode(code);
		}

		if (shortDiscription == null) {
			unitTypeImpl.setShortDiscription("");
		}
		else {
			unitTypeImpl.setShortDiscription(shortDiscription);
		}

		if (longDiscription == null) {
			unitTypeImpl.setLongDiscription("");
		}
		else {
			unitTypeImpl.setLongDiscription(longDiscription);
		}

		unitTypeImpl.setDeleted(deleted);
		unitTypeImpl.setStatus(status);

		unitTypeImpl.resetOriginalValues();

		return unitTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		unitTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		code = objectInput.readUTF();
		shortDiscription = objectInput.readUTF();
		longDiscription = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(unitTypeId);

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

		if (shortDiscription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortDiscription);
		}

		if (longDiscription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longDiscription);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long unitTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
	public String shortDiscription;
	public String longDiscription;
	public boolean deleted;
	public int status;

}