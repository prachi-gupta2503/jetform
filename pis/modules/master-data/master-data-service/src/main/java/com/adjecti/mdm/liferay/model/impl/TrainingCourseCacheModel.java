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

import com.adjecti.mdm.liferay.model.TrainingCourse;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TrainingCourse in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrainingCourseCacheModel
	implements CacheModel<TrainingCourse>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingCourseCacheModel)) {
			return false;
		}

		TrainingCourseCacheModel trainingCourseCacheModel =
			(TrainingCourseCacheModel)object;

		if (trainingCourseId == trainingCourseCacheModel.trainingCourseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainingCourseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{trainingCourseId=");
		sb.append(trainingCourseId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", institution=");
		sb.append(institution);
		sb.append(", locationOfInstitute=");
		sb.append(locationOfInstitute);
		sb.append(", name=");
		sb.append(name);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", specializationId=");
		sb.append(specializationId);
		sb.append(", stateInstituteId=");
		sb.append(stateInstituteId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TrainingCourse toEntityModel() {
		TrainingCourseImpl trainingCourseImpl = new TrainingCourseImpl();

		trainingCourseImpl.setTrainingCourseId(trainingCourseId);
		trainingCourseImpl.setGroupId(groupId);
		trainingCourseImpl.setCompanyId(companyId);
		trainingCourseImpl.setUserId(userId);

		if (userName == null) {
			trainingCourseImpl.setUserName("");
		}
		else {
			trainingCourseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			trainingCourseImpl.setCreateDate(null);
		}
		else {
			trainingCourseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			trainingCourseImpl.setModifiedDate(null);
		}
		else {
			trainingCourseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			trainingCourseImpl.setCode("");
		}
		else {
			trainingCourseImpl.setCode(code);
		}

		if (description == null) {
			trainingCourseImpl.setDescription("");
		}
		else {
			trainingCourseImpl.setDescription(description);
		}

		if (institution == null) {
			trainingCourseImpl.setInstitution("");
		}
		else {
			trainingCourseImpl.setInstitution(institution);
		}

		if (locationOfInstitute == null) {
			trainingCourseImpl.setLocationOfInstitute("");
		}
		else {
			trainingCourseImpl.setLocationOfInstitute(locationOfInstitute);
		}

		if (name == null) {
			trainingCourseImpl.setName("");
		}
		else {
			trainingCourseImpl.setName(name);
		}

		trainingCourseImpl.setOrganizationId(organizationId);
		trainingCourseImpl.setSpecializationId(specializationId);
		trainingCourseImpl.setStateInstituteId(stateInstituteId);
		trainingCourseImpl.setDeleted(deleted);
		trainingCourseImpl.setStatus(status);

		trainingCourseImpl.resetOriginalValues();

		return trainingCourseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		trainingCourseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		institution = objectInput.readUTF();
		locationOfInstitute = objectInput.readUTF();
		name = objectInput.readUTF();

		organizationId = objectInput.readLong();

		specializationId = objectInput.readLong();

		stateInstituteId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(trainingCourseId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (institution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institution);
		}

		if (locationOfInstitute == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(locationOfInstitute);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(specializationId);

		objectOutput.writeLong(stateInstituteId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long trainingCourseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String description;
	public String institution;
	public String locationOfInstitute;
	public String name;
	public long organizationId;
	public long specializationId;
	public long stateInstituteId;
	public boolean deleted;
	public int status;

}