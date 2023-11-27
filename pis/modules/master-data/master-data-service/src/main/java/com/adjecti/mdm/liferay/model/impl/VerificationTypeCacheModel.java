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

import com.adjecti.mdm.liferay.model.VerificationType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VerificationType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VerificationTypeCacheModel
	implements CacheModel<VerificationType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VerificationTypeCacheModel)) {
			return false;
		}

		VerificationTypeCacheModel verificationTypeCacheModel =
			(VerificationTypeCacheModel)object;

		if (verificationTypeId ==
				verificationTypeCacheModel.verificationTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, verificationTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{verificationTypeId=");
		sb.append(verificationTypeId);
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
	public VerificationType toEntityModel() {
		VerificationTypeImpl verificationTypeImpl = new VerificationTypeImpl();

		verificationTypeImpl.setVerificationTypeId(verificationTypeId);
		verificationTypeImpl.setGroupId(groupId);
		verificationTypeImpl.setCompanyId(companyId);
		verificationTypeImpl.setUserId(userId);

		if (userName == null) {
			verificationTypeImpl.setUserName("");
		}
		else {
			verificationTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			verificationTypeImpl.setCreateDate(null);
		}
		else {
			verificationTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			verificationTypeImpl.setModifiedDate(null);
		}
		else {
			verificationTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			verificationTypeImpl.setDescription("");
		}
		else {
			verificationTypeImpl.setDescription(description);
		}

		if (name == null) {
			verificationTypeImpl.setName("");
		}
		else {
			verificationTypeImpl.setName(name);
		}

		verificationTypeImpl.setDeleted(deleted);
		verificationTypeImpl.setStatus(status);

		verificationTypeImpl.resetOriginalValues();

		return verificationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		verificationTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(verificationTypeId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long verificationTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String name;
	public boolean deleted;
	public int status;

}