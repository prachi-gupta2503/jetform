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

import com.adjecti.mdm.liferay.model.PostOrganization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PostOrganization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PostOrganizationCacheModel
	implements CacheModel<PostOrganization>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostOrganizationCacheModel)) {
			return false;
		}

		PostOrganizationCacheModel postOrganizationCacheModel =
			(PostOrganizationCacheModel)object;

		if (postOrganizationId ==
				postOrganizationCacheModel.postOrganizationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postOrganizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{postOrganizationId=");
		sb.append(postOrganizationId);
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
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", postBox=");
		sb.append(postBox);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostOrganization toEntityModel() {
		PostOrganizationImpl postOrganizationImpl = new PostOrganizationImpl();

		postOrganizationImpl.setPostOrganizationId(postOrganizationId);
		postOrganizationImpl.setGroupId(groupId);
		postOrganizationImpl.setCompanyId(companyId);
		postOrganizationImpl.setUserId(userId);

		if (userName == null) {
			postOrganizationImpl.setUserName("");
		}
		else {
			postOrganizationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postOrganizationImpl.setCreateDate(null);
		}
		else {
			postOrganizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postOrganizationImpl.setModifiedDate(null);
		}
		else {
			postOrganizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		postOrganizationImpl.setPostId(postId);
		postOrganizationImpl.setOrganizationId(organizationId);
		postOrganizationImpl.setPostBox(postBox);
		postOrganizationImpl.setDeleted(deleted);
		postOrganizationImpl.setStatus(status);

		postOrganizationImpl.resetOriginalValues();

		return postOrganizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postOrganizationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		postId = objectInput.readLong();

		organizationId = objectInput.readLong();

		postBox = objectInput.readBoolean();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(postOrganizationId);

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

		objectOutput.writeLong(postId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeBoolean(postBox);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long postOrganizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long postId;
	public long organizationId;
	public boolean postBox;
	public boolean deleted;
	public int status;

}