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

import com.adjecti.pis.liferay.model.SampleProcessRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SampleProcessRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SampleProcessRequestCacheModel
	implements CacheModel<SampleProcessRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SampleProcessRequestCacheModel)) {
			return false;
		}

		SampleProcessRequestCacheModel sampleProcessRequestCacheModel =
			(SampleProcessRequestCacheModel)object;

		if (sampleProcessRequestId ==
				sampleProcessRequestCacheModel.sampleProcessRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sampleProcessRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sampleProcessRequestId=");
		sb.append(sampleProcessRequestId);
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
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", deputationOrganization=");
		sb.append(deputationOrganization);
		sb.append(", deputationAddress=");
		sb.append(deputationAddress);
		sb.append(", deputationCity=");
		sb.append(deputationCity);
		sb.append(", deputationState=");
		sb.append(deputationState);
		sb.append(", processFileId=");
		sb.append(processFileId);
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append(", doPart1Content=");
		sb.append(doPart1Content);
		sb.append(", doPart1SumittedDate=");
		sb.append(doPart1SumittedDate);
		sb.append(", doPart1ReviewDate=");
		sb.append(doPart1ReviewDate);
		sb.append(", doPart1Status=");
		sb.append(doPart1Status);
		sb.append(", doPart2Content=");
		sb.append(doPart2Content);
		sb.append(", doPart2SumittedDate=");
		sb.append(doPart2SumittedDate);
		sb.append(", doPart2ReviewDate=");
		sb.append(doPart2ReviewDate);
		sb.append(", doPart2Status=");
		sb.append(doPart2Status);
		sb.append(", requestStatus=");
		sb.append(requestStatus);
		sb.append(", requestCompletedDate=");
		sb.append(requestCompletedDate);
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
	public SampleProcessRequest toEntityModel() {
		SampleProcessRequestImpl sampleProcessRequestImpl =
			new SampleProcessRequestImpl();

		if (uuid == null) {
			sampleProcessRequestImpl.setUuid("");
		}
		else {
			sampleProcessRequestImpl.setUuid(uuid);
		}

		sampleProcessRequestImpl.setSampleProcessRequestId(
			sampleProcessRequestId);
		sampleProcessRequestImpl.setGroupId(groupId);
		sampleProcessRequestImpl.setCompanyId(companyId);
		sampleProcessRequestImpl.setUserId(userId);

		if (userName == null) {
			sampleProcessRequestImpl.setUserName("");
		}
		else {
			sampleProcessRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setCreateDate(null);
		}
		else {
			sampleProcessRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setModifiedDate(null);
		}
		else {
			sampleProcessRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		sampleProcessRequestImpl.setEmployeeId(employeeId);

		if (deputationOrganization == null) {
			sampleProcessRequestImpl.setDeputationOrganization("");
		}
		else {
			sampleProcessRequestImpl.setDeputationOrganization(
				deputationOrganization);
		}

		if (deputationAddress == null) {
			sampleProcessRequestImpl.setDeputationAddress("");
		}
		else {
			sampleProcessRequestImpl.setDeputationAddress(deputationAddress);
		}

		if (deputationCity == null) {
			sampleProcessRequestImpl.setDeputationCity("");
		}
		else {
			sampleProcessRequestImpl.setDeputationCity(deputationCity);
		}

		if (deputationState == null) {
			sampleProcessRequestImpl.setDeputationState("");
		}
		else {
			sampleProcessRequestImpl.setDeputationState(deputationState);
		}

		sampleProcessRequestImpl.setProcessFileId(processFileId);
		sampleProcessRequestImpl.setProcessFileNo(processFileNo);

		if (doPart1Content == null) {
			sampleProcessRequestImpl.setDoPart1Content("");
		}
		else {
			sampleProcessRequestImpl.setDoPart1Content(doPart1Content);
		}

		if (doPart1SumittedDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setDoPart1SumittedDate(null);
		}
		else {
			sampleProcessRequestImpl.setDoPart1SumittedDate(
				new Date(doPart1SumittedDate));
		}

		if (doPart1ReviewDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setDoPart1ReviewDate(null);
		}
		else {
			sampleProcessRequestImpl.setDoPart1ReviewDate(
				new Date(doPart1ReviewDate));
		}

		sampleProcessRequestImpl.setDoPart1Status(doPart1Status);

		if (doPart2Content == null) {
			sampleProcessRequestImpl.setDoPart2Content("");
		}
		else {
			sampleProcessRequestImpl.setDoPart2Content(doPart2Content);
		}

		if (doPart2SumittedDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setDoPart2SumittedDate(null);
		}
		else {
			sampleProcessRequestImpl.setDoPart2SumittedDate(
				new Date(doPart2SumittedDate));
		}

		if (doPart2ReviewDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setDoPart2ReviewDate(null);
		}
		else {
			sampleProcessRequestImpl.setDoPart2ReviewDate(
				new Date(doPart2ReviewDate));
		}

		sampleProcessRequestImpl.setDoPart2Status(doPart2Status);
		sampleProcessRequestImpl.setRequestStatus(requestStatus);

		if (requestCompletedDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setRequestCompletedDate(null);
		}
		else {
			sampleProcessRequestImpl.setRequestCompletedDate(
				new Date(requestCompletedDate));
		}

		if (reviewDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setReviewDate(null);
		}
		else {
			sampleProcessRequestImpl.setReviewDate(new Date(reviewDate));
		}

		sampleProcessRequestImpl.setReviewerUserId(reviewerUserId);

		if (approveDate == Long.MIN_VALUE) {
			sampleProcessRequestImpl.setApproveDate(null);
		}
		else {
			sampleProcessRequestImpl.setApproveDate(new Date(approveDate));
		}

		sampleProcessRequestImpl.setApproverUserId(approverUserId);

		sampleProcessRequestImpl.resetOriginalValues();

		return sampleProcessRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sampleProcessRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		deputationOrganization = objectInput.readUTF();
		deputationAddress = objectInput.readUTF();
		deputationCity = objectInput.readUTF();
		deputationState = objectInput.readUTF();

		processFileId = objectInput.readLong();

		processFileNo = objectInput.readLong();
		doPart1Content = objectInput.readUTF();
		doPart1SumittedDate = objectInput.readLong();
		doPart1ReviewDate = objectInput.readLong();

		doPart1Status = objectInput.readLong();
		doPart2Content = objectInput.readUTF();
		doPart2SumittedDate = objectInput.readLong();
		doPart2ReviewDate = objectInput.readLong();

		doPart2Status = objectInput.readLong();

		requestStatus = objectInput.readInt();
		requestCompletedDate = objectInput.readLong();
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

		objectOutput.writeLong(sampleProcessRequestId);

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

		objectOutput.writeLong(employeeId);

		if (deputationOrganization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationOrganization);
		}

		if (deputationAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationAddress);
		}

		if (deputationCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationCity);
		}

		if (deputationState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationState);
		}

		objectOutput.writeLong(processFileId);

		objectOutput.writeLong(processFileNo);

		if (doPart1Content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doPart1Content);
		}

		objectOutput.writeLong(doPart1SumittedDate);
		objectOutput.writeLong(doPart1ReviewDate);

		objectOutput.writeLong(doPart1Status);

		if (doPart2Content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doPart2Content);
		}

		objectOutput.writeLong(doPart2SumittedDate);
		objectOutput.writeLong(doPart2ReviewDate);

		objectOutput.writeLong(doPart2Status);

		objectOutput.writeInt(requestStatus);
		objectOutput.writeLong(requestCompletedDate);
		objectOutput.writeLong(reviewDate);

		objectOutput.writeLong(reviewerUserId);
		objectOutput.writeLong(approveDate);

		objectOutput.writeLong(approverUserId);
	}

	public String uuid;
	public long sampleProcessRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String deputationOrganization;
	public String deputationAddress;
	public String deputationCity;
	public String deputationState;
	public long processFileId;
	public long processFileNo;
	public String doPart1Content;
	public long doPart1SumittedDate;
	public long doPart1ReviewDate;
	public long doPart1Status;
	public String doPart2Content;
	public long doPart2SumittedDate;
	public long doPart2ReviewDate;
	public long doPart2Status;
	public int requestStatus;
	public long requestCompletedDate;
	public long reviewDate;
	public long reviewerUserId;
	public long approveDate;
	public long approverUserId;

}