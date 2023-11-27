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

import com.adjecti.mdm.liferay.model.TrainingInstitute;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TrainingInstitute in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrainingInstituteCacheModel
	implements CacheModel<TrainingInstitute>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingInstituteCacheModel)) {
			return false;
		}

		TrainingInstituteCacheModel trainingInstituteCacheModel =
			(TrainingInstituteCacheModel)object;

		if (trainingInstituteId ==
				trainingInstituteCacheModel.trainingInstituteId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainingInstituteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{trainingInstituteId=");
		sb.append(trainingInstituteId);
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
		sb.append(", locationId=");
		sb.append(locationId);
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
	public TrainingInstitute toEntityModel() {
		TrainingInstituteImpl trainingInstituteImpl =
			new TrainingInstituteImpl();

		trainingInstituteImpl.setTrainingInstituteId(trainingInstituteId);
		trainingInstituteImpl.setGroupId(groupId);
		trainingInstituteImpl.setCompanyId(companyId);
		trainingInstituteImpl.setUserId(userId);

		if (userName == null) {
			trainingInstituteImpl.setUserName("");
		}
		else {
			trainingInstituteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			trainingInstituteImpl.setCreateDate(null);
		}
		else {
			trainingInstituteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			trainingInstituteImpl.setModifiedDate(null);
		}
		else {
			trainingInstituteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			trainingInstituteImpl.setCode("");
		}
		else {
			trainingInstituteImpl.setCode(code);
		}

		if (name == null) {
			trainingInstituteImpl.setName("");
		}
		else {
			trainingInstituteImpl.setName(name);
		}

		trainingInstituteImpl.setLocationId(locationId);
		trainingInstituteImpl.setStateId(stateId);
		trainingInstituteImpl.setDeleted(deleted);
		trainingInstituteImpl.setStatus(status);

		trainingInstituteImpl.resetOriginalValues();

		return trainingInstituteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		trainingInstituteId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		locationId = objectInput.readLong();

		stateId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(trainingInstituteId);

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

		objectOutput.writeLong(locationId);

		objectOutput.writeLong(stateId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long trainingInstituteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public long locationId;
	public long stateId;
	public boolean deleted;
	public int status;

}