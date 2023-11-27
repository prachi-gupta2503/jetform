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

import com.adjecti.mdm.liferay.model.AccomodationType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccomodationType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccomodationTypeCacheModel
	implements CacheModel<AccomodationType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccomodationTypeCacheModel)) {
			return false;
		}

		AccomodationTypeCacheModel accomodationTypeCacheModel =
			(AccomodationTypeCacheModel)object;

		if (accomodationTypeId ==
				accomodationTypeCacheModel.accomodationTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accomodationTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{accomodationTypeId=");
		sb.append(accomodationTypeId);
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
	public AccomodationType toEntityModel() {
		AccomodationTypeImpl accomodationTypeImpl = new AccomodationTypeImpl();

		accomodationTypeImpl.setAccomodationTypeId(accomodationTypeId);
		accomodationTypeImpl.setGroupId(groupId);
		accomodationTypeImpl.setCompanyId(companyId);
		accomodationTypeImpl.setUserId(userId);

		if (userName == null) {
			accomodationTypeImpl.setUserName("");
		}
		else {
			accomodationTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			accomodationTypeImpl.setCreateDate(null);
		}
		else {
			accomodationTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accomodationTypeImpl.setModifiedDate(null);
		}
		else {
			accomodationTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			accomodationTypeImpl.setName("");
		}
		else {
			accomodationTypeImpl.setName(name);
		}

		if (description == null) {
			accomodationTypeImpl.setDescription("");
		}
		else {
			accomodationTypeImpl.setDescription(description);
		}

		accomodationTypeImpl.setDeleted(deleted);
		accomodationTypeImpl.setStatus(status);

		accomodationTypeImpl.resetOriginalValues();

		return accomodationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		accomodationTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(accomodationTypeId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long accomodationTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public boolean deleted;
	public int status;

}