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

import com.adjecti.mdm.liferay.model.PersonalNoPrefix;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersonalNoPrefix in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersonalNoPrefixCacheModel
	implements CacheModel<PersonalNoPrefix>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersonalNoPrefixCacheModel)) {
			return false;
		}

		PersonalNoPrefixCacheModel personalNoPrefixCacheModel =
			(PersonalNoPrefixCacheModel)object;

		if (personalNoPrefixId ==
				personalNoPrefixCacheModel.personalNoPrefixId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personalNoPrefixId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{personalNoPrefixId=");
		sb.append(personalNoPrefixId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", prefix=");
		sb.append(prefix);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", desigClassId=");
		sb.append(desigClassId);
		sb.append(", desigGradeId=");
		sb.append(desigGradeId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersonalNoPrefix toEntityModel() {
		PersonalNoPrefixImpl personalNoPrefixImpl = new PersonalNoPrefixImpl();

		personalNoPrefixImpl.setPersonalNoPrefixId(personalNoPrefixId);
		personalNoPrefixImpl.setGroupId(groupId);
		personalNoPrefixImpl.setCompanyId(companyId);
		personalNoPrefixImpl.setUserId(userId);

		if (userName == null) {
			personalNoPrefixImpl.setUserName("");
		}
		else {
			personalNoPrefixImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personalNoPrefixImpl.setCreateDate(null);
		}
		else {
			personalNoPrefixImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personalNoPrefixImpl.setModifiedDate(null);
		}
		else {
			personalNoPrefixImpl.setModifiedDate(new Date(modifiedDate));
		}

		personalNoPrefixImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			personalNoPrefixImpl.setFromDate(null);
		}
		else {
			personalNoPrefixImpl.setFromDate(new Date(fromDate));
		}

		if (prefix == null) {
			personalNoPrefixImpl.setPrefix("");
		}
		else {
			personalNoPrefixImpl.setPrefix(prefix);
		}

		if (toDate == Long.MIN_VALUE) {
			personalNoPrefixImpl.setToDate(null);
		}
		else {
			personalNoPrefixImpl.setToDate(new Date(toDate));
		}

		personalNoPrefixImpl.setDesigClassId(desigClassId);
		personalNoPrefixImpl.setDesigGradeId(desigGradeId);
		personalNoPrefixImpl.setDeleted(deleted);
		personalNoPrefixImpl.setStatus(status);

		personalNoPrefixImpl.resetOriginalValues();

		return personalNoPrefixImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personalNoPrefixId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		prefix = objectInput.readUTF();
		toDate = objectInput.readLong();

		desigClassId = objectInput.readLong();

		desigGradeId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(personalNoPrefixId);

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

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(fromDate);

		if (prefix == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prefix);
		}

		objectOutput.writeLong(toDate);

		objectOutput.writeLong(desigClassId);

		objectOutput.writeLong(desigGradeId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long personalNoPrefixId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public String prefix;
	public long toDate;
	public long desigClassId;
	public long desigGradeId;
	public boolean deleted;
	public int status;

}