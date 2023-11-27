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

import com.adjecti.mdm.liferay.model.PostReporting;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PostReporting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PostReportingCacheModel
	implements CacheModel<PostReporting>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostReportingCacheModel)) {
			return false;
		}

		PostReportingCacheModel postReportingCacheModel =
			(PostReportingCacheModel)object;

		if (postReportingId == postReportingCacheModel.postReportingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, postReportingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{postReportingId=");
		sb.append(postReportingId);
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
		sb.append(", reporteePostId=");
		sb.append(reporteePostId);
		sb.append(", reporterPostId=");
		sb.append(reporterPostId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostReporting toEntityModel() {
		PostReportingImpl postReportingImpl = new PostReportingImpl();

		postReportingImpl.setPostReportingId(postReportingId);
		postReportingImpl.setGroupId(groupId);
		postReportingImpl.setCompanyId(companyId);
		postReportingImpl.setUserId(userId);

		if (userName == null) {
			postReportingImpl.setUserName("");
		}
		else {
			postReportingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postReportingImpl.setCreateDate(null);
		}
		else {
			postReportingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postReportingImpl.setModifiedDate(null);
		}
		else {
			postReportingImpl.setModifiedDate(new Date(modifiedDate));
		}

		postReportingImpl.setReporteePostId(reporteePostId);
		postReportingImpl.setReporterPostId(reporterPostId);
		postReportingImpl.setDeleted(deleted);
		postReportingImpl.setStatus(status);

		postReportingImpl.resetOriginalValues();

		return postReportingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postReportingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		reporteePostId = objectInput.readLong();

		reporterPostId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(postReportingId);

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

		objectOutput.writeLong(reporteePostId);

		objectOutput.writeLong(reporterPostId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long postReportingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long reporteePostId;
	public long reporterPostId;
	public boolean deleted;
	public int status;

}