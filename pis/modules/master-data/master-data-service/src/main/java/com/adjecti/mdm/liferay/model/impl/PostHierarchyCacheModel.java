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

import com.adjecti.mdm.liferay.model.PostHierarchy;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PostHierarchy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PostHierarchyCacheModel
	implements CacheModel<PostHierarchy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostHierarchyCacheModel)) {
			return false;
		}

		PostHierarchyCacheModel postHierarchyCacheModel =
			(PostHierarchyCacheModel)object;

		if (postHierarchyId == postHierarchyCacheModel.postHierarchyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postHierarchyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{postHierarchyId=");
		sb.append(postHierarchyId);
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
		sb.append(", lowerPostId=");
		sb.append(lowerPostId);
		sb.append(", upperPostId=");
		sb.append(upperPostId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostHierarchy toEntityModel() {
		PostHierarchyImpl postHierarchyImpl = new PostHierarchyImpl();

		postHierarchyImpl.setPostHierarchyId(postHierarchyId);
		postHierarchyImpl.setGroupId(groupId);
		postHierarchyImpl.setCompanyId(companyId);
		postHierarchyImpl.setUserId(userId);

		if (userName == null) {
			postHierarchyImpl.setUserName("");
		}
		else {
			postHierarchyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postHierarchyImpl.setCreateDate(null);
		}
		else {
			postHierarchyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postHierarchyImpl.setModifiedDate(null);
		}
		else {
			postHierarchyImpl.setModifiedDate(new Date(modifiedDate));
		}

		postHierarchyImpl.setLowerPostId(lowerPostId);
		postHierarchyImpl.setUpperPostId(upperPostId);
		postHierarchyImpl.setDeleted(deleted);
		postHierarchyImpl.setStatus(status);

		postHierarchyImpl.resetOriginalValues();

		return postHierarchyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postHierarchyId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		lowerPostId = objectInput.readLong();

		upperPostId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(postHierarchyId);

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

		objectOutput.writeLong(lowerPostId);

		objectOutput.writeLong(upperPostId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long postHierarchyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lowerPostId;
	public long upperPostId;
	public boolean deleted;
	public int status;

}