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

import com.adjecti.mdm.liferay.model.PostDelegation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PostDelegation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PostDelegationCacheModel
	implements CacheModel<PostDelegation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostDelegationCacheModel)) {
			return false;
		}

		PostDelegationCacheModel postDelegationCacheModel =
			(PostDelegationCacheModel)object;

		if (postDelegationId == postDelegationCacheModel.postDelegationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postDelegationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{postDelegationId=");
		sb.append(postDelegationId);
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
		sb.append(", delegationType=");
		sb.append(delegationType);
		sb.append(", delegatedPostId=");
		sb.append(delegatedPostId);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostDelegation toEntityModel() {
		PostDelegationImpl postDelegationImpl = new PostDelegationImpl();

		postDelegationImpl.setPostDelegationId(postDelegationId);
		postDelegationImpl.setGroupId(groupId);
		postDelegationImpl.setCompanyId(companyId);
		postDelegationImpl.setUserId(userId);

		if (userName == null) {
			postDelegationImpl.setUserName("");
		}
		else {
			postDelegationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postDelegationImpl.setCreateDate(null);
		}
		else {
			postDelegationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postDelegationImpl.setModifiedDate(null);
		}
		else {
			postDelegationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (delegationType == null) {
			postDelegationImpl.setDelegationType("");
		}
		else {
			postDelegationImpl.setDelegationType(delegationType);
		}

		postDelegationImpl.setDelegatedPostId(delegatedPostId);
		postDelegationImpl.setPostId(postId);
		postDelegationImpl.setDeleted(deleted);
		postDelegationImpl.setStatus(status);

		postDelegationImpl.resetOriginalValues();

		return postDelegationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postDelegationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		delegationType = objectInput.readUTF();

		delegatedPostId = objectInput.readLong();

		postId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(postDelegationId);

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

		if (delegationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(delegationType);
		}

		objectOutput.writeLong(delegatedPostId);

		objectOutput.writeLong(postId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long postDelegationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String delegationType;
	public long delegatedPostId;
	public long postId;
	public boolean deleted;
	public int status;

}