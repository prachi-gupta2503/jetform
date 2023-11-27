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

import com.adjecti.mdm.liferay.model.CourseCategory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CourseCategoryCacheModel
	implements CacheModel<CourseCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CourseCategoryCacheModel)) {
			return false;
		}

		CourseCategoryCacheModel courseCategoryCacheModel =
			(CourseCategoryCacheModel)object;

		if (courseCategoryId == courseCategoryCacheModel.courseCategoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, courseCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{courseCategoryId=");
		sb.append(courseCategoryId);
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
	public CourseCategory toEntityModel() {
		CourseCategoryImpl courseCategoryImpl = new CourseCategoryImpl();

		courseCategoryImpl.setCourseCategoryId(courseCategoryId);
		courseCategoryImpl.setGroupId(groupId);
		courseCategoryImpl.setCompanyId(companyId);
		courseCategoryImpl.setUserId(userId);

		if (userName == null) {
			courseCategoryImpl.setUserName("");
		}
		else {
			courseCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseCategoryImpl.setCreateDate(null);
		}
		else {
			courseCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseCategoryImpl.setModifiedDate(null);
		}
		else {
			courseCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			courseCategoryImpl.setCode("");
		}
		else {
			courseCategoryImpl.setCode(code);
		}

		if (description == null) {
			courseCategoryImpl.setDescription("");
		}
		else {
			courseCategoryImpl.setDescription(description);
		}

		if (name == null) {
			courseCategoryImpl.setName("");
		}
		else {
			courseCategoryImpl.setName(name);
		}

		courseCategoryImpl.setDeleted(deleted);
		courseCategoryImpl.setStatus(status);

		courseCategoryImpl.resetOriginalValues();

		return courseCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		courseCategoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(courseCategoryId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long courseCategoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String description;
	public String name;
	public boolean deleted;
	public int status;

}