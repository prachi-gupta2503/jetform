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

import com.adjecti.mdm.liferay.model.SubjectOfQualification;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubjectOfQualification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubjectOfQualificationCacheModel
	implements CacheModel<SubjectOfQualification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubjectOfQualificationCacheModel)) {
			return false;
		}

		SubjectOfQualificationCacheModel subjectOfQualificationCacheModel =
			(SubjectOfQualificationCacheModel)object;

		if (subjectOfQualificationId ==
				subjectOfQualificationCacheModel.subjectOfQualificationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subjectOfQualificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{subjectOfQualificationId=");
		sb.append(subjectOfQualificationId);
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
		sb.append(", subjectOfQualification=");
		sb.append(subjectOfQualification);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubjectOfQualification toEntityModel() {
		SubjectOfQualificationImpl subjectOfQualificationImpl =
			new SubjectOfQualificationImpl();

		subjectOfQualificationImpl.setSubjectOfQualificationId(
			subjectOfQualificationId);
		subjectOfQualificationImpl.setGroupId(groupId);
		subjectOfQualificationImpl.setCompanyId(companyId);
		subjectOfQualificationImpl.setUserId(userId);

		if (userName == null) {
			subjectOfQualificationImpl.setUserName("");
		}
		else {
			subjectOfQualificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subjectOfQualificationImpl.setCreateDate(null);
		}
		else {
			subjectOfQualificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subjectOfQualificationImpl.setModifiedDate(null);
		}
		else {
			subjectOfQualificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			subjectOfQualificationImpl.setDescription("");
		}
		else {
			subjectOfQualificationImpl.setDescription(description);
		}

		if (code == null) {
			subjectOfQualificationImpl.setCode("");
		}
		else {
			subjectOfQualificationImpl.setCode(code);
		}

		if (subjectOfQualification == null) {
			subjectOfQualificationImpl.setSubjectOfQualification("");
		}
		else {
			subjectOfQualificationImpl.setSubjectOfQualification(
				subjectOfQualification);
		}

		subjectOfQualificationImpl.setDeleted(deleted);
		subjectOfQualificationImpl.setStatus(status);

		subjectOfQualificationImpl.resetOriginalValues();

		return subjectOfQualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subjectOfQualificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		code = objectInput.readUTF();
		subjectOfQualification = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(subjectOfQualificationId);

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

		if (subjectOfQualification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subjectOfQualification);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long subjectOfQualificationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
	public String subjectOfQualification;
	public boolean deleted;
	public int status;

}