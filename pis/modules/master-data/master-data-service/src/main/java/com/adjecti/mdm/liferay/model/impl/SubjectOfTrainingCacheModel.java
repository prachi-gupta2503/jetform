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

import com.adjecti.mdm.liferay.model.SubjectOfTraining;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubjectOfTraining in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubjectOfTrainingCacheModel
	implements CacheModel<SubjectOfTraining>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubjectOfTrainingCacheModel)) {
			return false;
		}

		SubjectOfTrainingCacheModel subjectOfTrainingCacheModel =
			(SubjectOfTrainingCacheModel)object;

		if (subjectOfTrainingId ==
				subjectOfTrainingCacheModel.subjectOfTrainingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subjectOfTrainingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{subjectOfTrainingId=");
		sb.append(subjectOfTrainingId);
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
		sb.append(", trainingSubject=");
		sb.append(trainingSubject);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubjectOfTraining toEntityModel() {
		SubjectOfTrainingImpl subjectOfTrainingImpl =
			new SubjectOfTrainingImpl();

		subjectOfTrainingImpl.setSubjectOfTrainingId(subjectOfTrainingId);
		subjectOfTrainingImpl.setGroupId(groupId);
		subjectOfTrainingImpl.setCompanyId(companyId);
		subjectOfTrainingImpl.setUserId(userId);

		if (userName == null) {
			subjectOfTrainingImpl.setUserName("");
		}
		else {
			subjectOfTrainingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subjectOfTrainingImpl.setCreateDate(null);
		}
		else {
			subjectOfTrainingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subjectOfTrainingImpl.setModifiedDate(null);
		}
		else {
			subjectOfTrainingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			subjectOfTrainingImpl.setDescription("");
		}
		else {
			subjectOfTrainingImpl.setDescription(description);
		}

		if (code == null) {
			subjectOfTrainingImpl.setCode("");
		}
		else {
			subjectOfTrainingImpl.setCode(code);
		}

		if (trainingSubject == null) {
			subjectOfTrainingImpl.setTrainingSubject("");
		}
		else {
			subjectOfTrainingImpl.setTrainingSubject(trainingSubject);
		}

		subjectOfTrainingImpl.setDeleted(deleted);
		subjectOfTrainingImpl.setStatus(status);

		subjectOfTrainingImpl.resetOriginalValues();

		return subjectOfTrainingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subjectOfTrainingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		code = objectInput.readUTF();
		trainingSubject = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(subjectOfTrainingId);

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

		if (trainingSubject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingSubject);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long subjectOfTrainingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
	public String trainingSubject;
	public boolean deleted;
	public int status;

}