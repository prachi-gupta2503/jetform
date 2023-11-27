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

import com.adjecti.pis.liferay.model.JoiningProcess;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JoiningProcess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JoiningProcessCacheModel
	implements CacheModel<JoiningProcess>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JoiningProcessCacheModel)) {
			return false;
		}

		JoiningProcessCacheModel joiningProcessCacheModel =
			(JoiningProcessCacheModel)object;

		if (joiningProcessId == joiningProcessCacheModel.joiningProcessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, joiningProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
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
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", unitId=");
		sb.append(unitId);
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
	public JoiningProcess toEntityModel() {
		JoiningProcessImpl joiningProcessImpl = new JoiningProcessImpl();

		if (uuid == null) {
			joiningProcessImpl.setUuid("");
		}
		else {
			joiningProcessImpl.setUuid(uuid);
		}

		joiningProcessImpl.setJoiningProcessId(joiningProcessId);
		joiningProcessImpl.setGroupId(groupId);
		joiningProcessImpl.setCompanyId(companyId);
		joiningProcessImpl.setUserId(userId);

		if (userName == null) {
			joiningProcessImpl.setUserName("");
		}
		else {
			joiningProcessImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			joiningProcessImpl.setCreateDate(null);
		}
		else {
			joiningProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			joiningProcessImpl.setModifiedDate(null);
		}
		else {
			joiningProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			joiningProcessImpl.setName("");
		}
		else {
			joiningProcessImpl.setName(name);
		}

		if (description == null) {
			joiningProcessImpl.setDescription("");
		}
		else {
			joiningProcessImpl.setDescription(description);
		}

		if (reason == null) {
			joiningProcessImpl.setReason("");
		}
		else {
			joiningProcessImpl.setReason(reason);
		}

		joiningProcessImpl.setPersonalNo(personalNo);
		joiningProcessImpl.setUnitId(unitId);
		joiningProcessImpl.setProcessFileId(processFileId);
		joiningProcessImpl.setProcessFileNo(processFileNo);

		if (notingContent == null) {
			joiningProcessImpl.setNotingContent("");
		}
		else {
			joiningProcessImpl.setNotingContent(notingContent);
		}

		if (notingSubmittedDate == Long.MIN_VALUE) {
			joiningProcessImpl.setNotingSubmittedDate(null);
		}
		else {
			joiningProcessImpl.setNotingSubmittedDate(
				new Date(notingSubmittedDate));
		}

		if (notingApprovedDate == Long.MIN_VALUE) {
			joiningProcessImpl.setNotingApprovedDate(null);
		}
		else {
			joiningProcessImpl.setNotingApprovedDate(
				new Date(notingApprovedDate));
		}

		joiningProcessImpl.setProcessStatus(processStatus);

		if (processCompletedDate == Long.MIN_VALUE) {
			joiningProcessImpl.setProcessCompletedDate(null);
		}
		else {
			joiningProcessImpl.setProcessCompletedDate(
				new Date(processCompletedDate));
		}

		if (reviewDate == Long.MIN_VALUE) {
			joiningProcessImpl.setReviewDate(null);
		}
		else {
			joiningProcessImpl.setReviewDate(new Date(reviewDate));
		}

		joiningProcessImpl.setReviewerUserId(reviewerUserId);

		if (approveDate == Long.MIN_VALUE) {
			joiningProcessImpl.setApproveDate(null);
		}
		else {
			joiningProcessImpl.setApproveDate(new Date(approveDate));
		}

		joiningProcessImpl.setApproverUserId(approverUserId);

		joiningProcessImpl.resetOriginalValues();

		return joiningProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		joiningProcessId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		reason = objectInput.readUTF();

		personalNo = objectInput.readLong();

		unitId = objectInput.readLong();

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

		objectOutput.writeLong(joiningProcessId);

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

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		objectOutput.writeLong(personalNo);

		objectOutput.writeLong(unitId);

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
	public long joiningProcessId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String reason;
	public long personalNo;
	public long unitId;
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