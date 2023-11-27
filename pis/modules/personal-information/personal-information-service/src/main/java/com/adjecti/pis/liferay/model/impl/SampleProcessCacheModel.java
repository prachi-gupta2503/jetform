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

package com.adjecti.pis.liferay.model.impl;

import com.adjecti.pis.liferay.model.SampleProcess;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SampleProcess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SampleProcessCacheModel
	implements CacheModel<SampleProcess>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SampleProcessCacheModel)) {
			return false;
		}

		SampleProcessCacheModel sampleProcessCacheModel =
			(SampleProcessCacheModel)object;

		if (sampleProcessId == sampleProcessCacheModel.sampleProcessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sampleProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sampleProcessId=");
		sb.append(sampleProcessId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", processFileId=");
		sb.append(processFileId);
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append(", notingContent=");
		sb.append(notingContent);
		sb.append(", notingSubmittedDate=");
		sb.append(notingSubmittedDate);
		sb.append(", notingApprovedDate=");
		sb.append(notingApprovedDate);
		sb.append(", processStatus=");
		sb.append(processStatus);
		sb.append(", processCompletedDate=");
		sb.append(processCompletedDate);
		sb.append(", reviewDate=");
		sb.append(reviewDate);
		sb.append(", reviewerUserId=");
		sb.append(reviewerUserId);
		sb.append(", approveDate=");
		sb.append(approveDate);
		sb.append(", approverUserId=");
		sb.append(approverUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleProcess toEntityModel() {
		SampleProcessImpl sampleProcessImpl = new SampleProcessImpl();

		if (uuid == null) {
			sampleProcessImpl.setUuid("");
		}
		else {
			sampleProcessImpl.setUuid(uuid);
		}

		sampleProcessImpl.setSampleProcessId(sampleProcessId);
		sampleProcessImpl.setGroupId(groupId);
		sampleProcessImpl.setCompanyId(companyId);
		sampleProcessImpl.setUserId(userId);

		if (userName == null) {
			sampleProcessImpl.setUserName("");
		}
		else {
			sampleProcessImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sampleProcessImpl.setCreateDate(null);
		}
		else {
			sampleProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sampleProcessImpl.setModifiedDate(null);
		}
		else {
			sampleProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			sampleProcessImpl.setName("");
		}
		else {
			sampleProcessImpl.setName(name);
		}

		if (description == null) {
			sampleProcessImpl.setDescription("");
		}
		else {
			sampleProcessImpl.setDescription(description);
		}

		sampleProcessImpl.setProcessFileId(processFileId);
		sampleProcessImpl.setProcessFileNo(processFileNo);

		if (notingContent == null) {
			sampleProcessImpl.setNotingContent("");
		}
		else {
			sampleProcessImpl.setNotingContent(notingContent);
		}

		if (notingSubmittedDate == Long.MIN_VALUE) {
			sampleProcessImpl.setNotingSubmittedDate(null);
		}
		else {
			sampleProcessImpl.setNotingSubmittedDate(
				new Date(notingSubmittedDate));
		}

		if (notingApprovedDate == Long.MIN_VALUE) {
			sampleProcessImpl.setNotingApprovedDate(null);
		}
		else {
			sampleProcessImpl.setNotingApprovedDate(
				new Date(notingApprovedDate));
		}

		sampleProcessImpl.setProcessStatus(processStatus);

		if (processCompletedDate == Long.MIN_VALUE) {
			sampleProcessImpl.setProcessCompletedDate(null);
		}
		else {
			sampleProcessImpl.setProcessCompletedDate(
				new Date(processCompletedDate));
		}

		if (reviewDate == Long.MIN_VALUE) {
			sampleProcessImpl.setReviewDate(null);
		}
		else {
			sampleProcessImpl.setReviewDate(new Date(reviewDate));
		}

		sampleProcessImpl.setReviewerUserId(reviewerUserId);

		if (approveDate == Long.MIN_VALUE) {
			sampleProcessImpl.setApproveDate(null);
		}
		else {
			sampleProcessImpl.setApproveDate(new Date(approveDate));
		}

		sampleProcessImpl.setApproverUserId(approverUserId);

		sampleProcessImpl.resetOriginalValues();

		return sampleProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sampleProcessId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		processFileId = objectInput.readLong();

		processFileNo = objectInput.readLong();
		notingContent = objectInput.readUTF();
		notingSubmittedDate = objectInput.readLong();
		notingApprovedDate = objectInput.readLong();

		processStatus = objectInput.readInt();
		processCompletedDate = objectInput.readLong();
		reviewDate = objectInput.readLong();

		reviewerUserId = objectInput.readLong();
		approveDate = objectInput.readLong();

		approverUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sampleProcessId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(processFileId);

		objectOutput.writeLong(processFileNo);

		if (notingContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(notingContent);
		}

		objectOutput.writeLong(notingSubmittedDate);
		objectOutput.writeLong(notingApprovedDate);

		objectOutput.writeInt(processStatus);
		objectOutput.writeLong(processCompletedDate);
		objectOutput.writeLong(reviewDate);

		objectOutput.writeLong(reviewerUserId);
		objectOutput.writeLong(approveDate);

		objectOutput.writeLong(approverUserId);
	}

	public String uuid;
	public long sampleProcessId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public long processFileId;
	public long processFileNo;
	public String notingContent;
	public long notingSubmittedDate;
	public long notingApprovedDate;
	public int processStatus;
	public long processCompletedDate;
	public long reviewDate;
	public long reviewerUserId;
	public long approveDate;
	public long approverUserId;

}