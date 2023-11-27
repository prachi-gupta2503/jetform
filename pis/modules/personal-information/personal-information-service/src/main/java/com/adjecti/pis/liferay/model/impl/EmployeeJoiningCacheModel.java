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

import com.adjecti.pis.liferay.model.EmployeeJoining;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeJoining in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeJoiningCacheModel
	implements CacheModel<EmployeeJoining>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeJoiningCacheModel)) {
			return false;
		}

		EmployeeJoiningCacheModel employeeJoiningCacheModel =
			(EmployeeJoiningCacheModel)object;

		if (employeeJoiningId == employeeJoiningCacheModel.employeeJoiningId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeJoiningId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(83);

		sb.append("{employeeJoiningId=");
		sb.append(employeeJoiningId);
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
		sb.append(", aadhaarNo=");
		sb.append(aadhaarNo);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", exServiceMan=");
		sb.append(exServiceMan);
		sb.append(", panNo=");
		sb.append(panNo);
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", peopleId=");
		sb.append(peopleId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", payLevelId=");
		sb.append(payLevelId);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", tradeId=");
		sb.append(tradeId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", subOrganizationId=");
		sb.append(subOrganizationId);
		sb.append(", designationClassId=");
		sb.append(designationClassId);
		sb.append(", designationGroupId=");
		sb.append(designationGroupId);
		sb.append(", joiningModeId=");
		sb.append(joiningModeId);
		sb.append(", joiningLetterId=");
		sb.append(joiningLetterId);
		sb.append(", gradeModeId=");
		sb.append(gradeModeId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", selectionDate=");
		sb.append(selectionDate);
		sb.append(", confirmationDate=");
		sb.append(confirmationDate);
		sb.append(", gradeConfirmationDate=");
		sb.append(gradeConfirmationDate);
		sb.append(", govtServiceDate=");
		sb.append(govtServiceDate);
		sb.append(", recruitmentBatch=");
		sb.append(recruitmentBatch);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append(", postBox=");
		sb.append(postBox);
		sb.append(", dateOfJoining=");
		sb.append(dateOfJoining);
		sb.append(", dateOfJoiningOrganization=");
		sb.append(dateOfJoiningOrganization);
		sb.append(", rank=");
		sb.append(rank);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeJoining toEntityModel() {
		EmployeeJoiningImpl employeeJoiningImpl = new EmployeeJoiningImpl();

		employeeJoiningImpl.setEmployeeJoiningId(employeeJoiningId);
		employeeJoiningImpl.setGroupId(groupId);
		employeeJoiningImpl.setCompanyId(companyId);
		employeeJoiningImpl.setUserId(userId);

		if (userName == null) {
			employeeJoiningImpl.setUserName("");
		}
		else {
			employeeJoiningImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setCreateDate(null);
		}
		else {
			employeeJoiningImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setModifiedDate(null);
		}
		else {
			employeeJoiningImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (aadhaarNo == null) {
			employeeJoiningImpl.setAadhaarNo("");
		}
		else {
			employeeJoiningImpl.setAadhaarNo(aadhaarNo);
		}

		if (emailAddress == null) {
			employeeJoiningImpl.setEmailAddress("");
		}
		else {
			employeeJoiningImpl.setEmailAddress(emailAddress);
		}

		employeeJoiningImpl.setExServiceMan(exServiceMan);

		if (panNo == null) {
			employeeJoiningImpl.setPanNo("");
		}
		else {
			employeeJoiningImpl.setPanNo(panNo);
		}

		if (personalNo == null) {
			employeeJoiningImpl.setPersonalNo("");
		}
		else {
			employeeJoiningImpl.setPersonalNo(personalNo);
		}

		employeeJoiningImpl.setPeopleId(peopleId);

		if (fullName == null) {
			employeeJoiningImpl.setFullName("");
		}
		else {
			employeeJoiningImpl.setFullName(fullName);
		}

		employeeJoiningImpl.setDesignationId(designationId);
		employeeJoiningImpl.setGradeId(gradeId);
		employeeJoiningImpl.setPayLevelId(payLevelId);
		employeeJoiningImpl.setPostId(postId);
		employeeJoiningImpl.setTradeId(tradeId);
		employeeJoiningImpl.setOrganizationId(organizationId);
		employeeJoiningImpl.setSubOrganizationId(subOrganizationId);
		employeeJoiningImpl.setDesignationClassId(designationClassId);
		employeeJoiningImpl.setDesignationGroupId(designationGroupId);
		employeeJoiningImpl.setJoiningModeId(joiningModeId);
		employeeJoiningImpl.setJoiningLetterId(joiningLetterId);
		employeeJoiningImpl.setGradeModeId(gradeModeId);

		if (fromDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setFromDate(null);
		}
		else {
			employeeJoiningImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setToDate(null);
		}
		else {
			employeeJoiningImpl.setToDate(new Date(toDate));
		}

		if (selectionDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setSelectionDate(null);
		}
		else {
			employeeJoiningImpl.setSelectionDate(new Date(selectionDate));
		}

		if (confirmationDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setConfirmationDate(null);
		}
		else {
			employeeJoiningImpl.setConfirmationDate(new Date(confirmationDate));
		}

		if (gradeConfirmationDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setGradeConfirmationDate(null);
		}
		else {
			employeeJoiningImpl.setGradeConfirmationDate(
				new Date(gradeConfirmationDate));
		}

		if (govtServiceDate == Long.MIN_VALUE) {
			employeeJoiningImpl.setGovtServiceDate(null);
		}
		else {
			employeeJoiningImpl.setGovtServiceDate(new Date(govtServiceDate));
		}

		if (recruitmentBatch == null) {
			employeeJoiningImpl.setRecruitmentBatch("");
		}
		else {
			employeeJoiningImpl.setRecruitmentBatch(recruitmentBatch);
		}

		employeeJoiningImpl.setEmployeeId(employeeId);

		if (emailId == null) {
			employeeJoiningImpl.setEmailId("");
		}
		else {
			employeeJoiningImpl.setEmailId(emailId);
		}

		if (postBox == null) {
			employeeJoiningImpl.setPostBox("");
		}
		else {
			employeeJoiningImpl.setPostBox(postBox);
		}

		if (dateOfJoining == Long.MIN_VALUE) {
			employeeJoiningImpl.setDateOfJoining(null);
		}
		else {
			employeeJoiningImpl.setDateOfJoining(new Date(dateOfJoining));
		}

		if (dateOfJoiningOrganization == Long.MIN_VALUE) {
			employeeJoiningImpl.setDateOfJoiningOrganization(null);
		}
		else {
			employeeJoiningImpl.setDateOfJoiningOrganization(
				new Date(dateOfJoiningOrganization));
		}

		employeeJoiningImpl.setRank(rank);
		employeeJoiningImpl.setJoiningProcessId(joiningProcessId);
		employeeJoiningImpl.setStatus(status);

		employeeJoiningImpl.resetOriginalValues();

		return employeeJoiningImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeJoiningId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		aadhaarNo = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		exServiceMan = objectInput.readBoolean();
		panNo = objectInput.readUTF();
		personalNo = objectInput.readUTF();

		peopleId = objectInput.readLong();
		fullName = objectInput.readUTF();

		designationId = objectInput.readLong();

		gradeId = objectInput.readLong();

		payLevelId = objectInput.readLong();

		postId = objectInput.readLong();

		tradeId = objectInput.readLong();

		organizationId = objectInput.readLong();

		subOrganizationId = objectInput.readLong();

		designationClassId = objectInput.readLong();

		designationGroupId = objectInput.readLong();

		joiningModeId = objectInput.readLong();

		joiningLetterId = objectInput.readLong();

		gradeModeId = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		selectionDate = objectInput.readLong();
		confirmationDate = objectInput.readLong();
		gradeConfirmationDate = objectInput.readLong();
		govtServiceDate = objectInput.readLong();
		recruitmentBatch = objectInput.readUTF();

		employeeId = objectInput.readLong();
		emailId = objectInput.readUTF();
		postBox = objectInput.readUTF();
		dateOfJoining = objectInput.readLong();
		dateOfJoiningOrganization = objectInput.readLong();

		rank = objectInput.readLong();

		joiningProcessId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeJoiningId);

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

		if (aadhaarNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadhaarNo);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeBoolean(exServiceMan);

		if (panNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNo);
		}

		if (personalNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalNo);
		}

		objectOutput.writeLong(peopleId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(payLevelId);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(tradeId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(subOrganizationId);

		objectOutput.writeLong(designationClassId);

		objectOutput.writeLong(designationGroupId);

		objectOutput.writeLong(joiningModeId);

		objectOutput.writeLong(joiningLetterId);

		objectOutput.writeLong(gradeModeId);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
		objectOutput.writeLong(selectionDate);
		objectOutput.writeLong(confirmationDate);
		objectOutput.writeLong(gradeConfirmationDate);
		objectOutput.writeLong(govtServiceDate);

		if (recruitmentBatch == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recruitmentBatch);
		}

		objectOutput.writeLong(employeeId);

		if (emailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		if (postBox == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postBox);
		}

		objectOutput.writeLong(dateOfJoining);
		objectOutput.writeLong(dateOfJoiningOrganization);

		objectOutput.writeLong(rank);

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeInt(status);
	}

	public long employeeJoiningId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String aadhaarNo;
	public String emailAddress;
	public boolean exServiceMan;
	public String panNo;
	public String personalNo;
	public long peopleId;
	public String fullName;
	public long designationId;
	public long gradeId;
	public long payLevelId;
	public long postId;
	public long tradeId;
	public long organizationId;
	public long subOrganizationId;
	public long designationClassId;
	public long designationGroupId;
	public long joiningModeId;
	public long joiningLetterId;
	public long gradeModeId;
	public long fromDate;
	public long toDate;
	public long selectionDate;
	public long confirmationDate;
	public long gradeConfirmationDate;
	public long govtServiceDate;
	public String recruitmentBatch;
	public long employeeId;
	public String emailId;
	public String postBox;
	public long dateOfJoining;
	public long dateOfJoiningOrganization;
	public long rank;
	public long joiningProcessId;
	public int status;

}