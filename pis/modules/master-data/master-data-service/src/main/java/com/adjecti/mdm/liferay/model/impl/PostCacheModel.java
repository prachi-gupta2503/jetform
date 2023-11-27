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

import com.adjecti.mdm.liferay.model.Post;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Post in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PostCacheModel implements CacheModel<Post>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostCacheModel)) {
			return false;
		}

		PostCacheModel postCacheModel = (PostCacheModel)object;

		if (postId == postCacheModel.postId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{postId=");
		sb.append(postId);
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
		sb.append(", name_En=");
		sb.append(name_En);
		sb.append(", name_Hi=");
		sb.append(name_Hi);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", postBox=");
		sb.append(postBox);
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
	public Post toEntityModel() {
		PostImpl postImpl = new PostImpl();

		postImpl.setPostId(postId);
		postImpl.setGroupId(groupId);
		postImpl.setCompanyId(companyId);
		postImpl.setUserId(userId);

		if (userName == null) {
			postImpl.setUserName("");
		}
		else {
			postImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postImpl.setCreateDate(null);
		}
		else {
			postImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postImpl.setModifiedDate(null);
		}
		else {
			postImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			postImpl.setCode("");
		}
		else {
			postImpl.setCode(code);
		}

		if (name_En == null) {
			postImpl.setName_En("");
		}
		else {
			postImpl.setName_En(name_En);
		}

		if (name_Hi == null) {
			postImpl.setName_Hi("");
		}
		else {
			postImpl.setName_Hi(name_Hi);
		}

		postImpl.setDesignationId(designationId);
		postImpl.setPostBox(postBox);

		if (description == null) {
			postImpl.setDescription("");
		}
		else {
			postImpl.setDescription(description);
		}

		postImpl.setDeleted(deleted);
		postImpl.setStatus(status);

		postImpl.resetOriginalValues();

		return postImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name_En = objectInput.readUTF();
		name_Hi = objectInput.readUTF();

		designationId = objectInput.readLong();

		postBox = objectInput.readBoolean();
		description = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(postId);

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

		if (name_En == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name_En);
		}

		if (name_Hi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name_Hi);
		}

		objectOutput.writeLong(designationId);

		objectOutput.writeBoolean(postBox);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long postId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name_En;
	public String name_Hi;
	public long designationId;
	public boolean postBox;
	public String description;
	public boolean deleted;
	public int status;

}