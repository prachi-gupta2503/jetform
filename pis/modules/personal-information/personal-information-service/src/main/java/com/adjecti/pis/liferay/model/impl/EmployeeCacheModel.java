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

import com.adjecti.pis.liferay.model.Employee;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		if (employeeId == employeeCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(83);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeId=");
		sb.append(employeeId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", state=");
		sb.append(state);
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", peopleId=");
		sb.append(peopleId);
		sb.append(", emailId=");
		sb.append(emailId);
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
		sb.append(", cadreId=");
		sb.append(cadreId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", subOrganizationId=");
		sb.append(subOrganizationId);
		sb.append(", gradeModeId=");
		sb.append(gradeModeId);
		sb.append(", designationClassId=");
		sb.append(designationClassId);
		sb.append(", designationGroupId=");
		sb.append(designationGroupId);
		sb.append(", postName=");
		sb.append(postName);
		sb.append(", employmentStatus=");
		sb.append(employmentStatus);
		sb.append(", dateOfJoining=");
		sb.append(dateOfJoining);
		sb.append(", dateOfJoiningOrganization=");
		sb.append(dateOfJoiningOrganization);
		sb.append(", currentDesignationDate=");
		sb.append(currentDesignationDate);
		sb.append(", retirementDate=");
		sb.append(retirementDate);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", loginId=");
		sb.append(loginId);
		sb.append(", bioData=");
		sb.append(bioData);
		sb.append(", message=");
		sb.append(message);
		sb.append(", gpfNps=");
		sb.append(gpfNps);
		sb.append(", gpfNpsNo=");
		sb.append(gpfNpsNo);
		sb.append(", rank=");
		sb.append(rank);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		if (uuid == null) {
			employeeImpl.setUuid("");
		}
		else {
			employeeImpl.setUuid(uuid);
		}

		employeeImpl.setEmployeeId(employeeId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setCompanyId(companyId);
		employeeImpl.setUserId(userId);

		if (userName == null) {
			employeeImpl.setUserName("");
		}
		else {
			employeeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeImpl.setModifiedDate(null);
		}
		else {
			employeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeImpl.setStatus(status);
		employeeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			employeeImpl.setStatusByUserName("");
		}
		else {
			employeeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			employeeImpl.setStatusDate(null);
		}
		else {
			employeeImpl.setStatusDate(new Date(statusDate));
		}

		if (state == null) {
			employeeImpl.setState("");
		}
		else {
			employeeImpl.setState(state);
		}

		if (personalNo == null) {
			employeeImpl.setPersonalNo("");
		}
		else {
			employeeImpl.setPersonalNo(personalNo);
		}

		employeeImpl.setPeopleId(peopleId);

		if (emailId == null) {
			employeeImpl.setEmailId("");
		}
		else {
			employeeImpl.setEmailId(emailId);
		}

		employeeImpl.setDesignationId(designationId);
		employeeImpl.setGradeId(gradeId);
		employeeImpl.setPayLevelId(payLevelId);
		employeeImpl.setPostId(postId);
		employeeImpl.setTradeId(tradeId);
		employeeImpl.setCadreId(cadreId);
		employeeImpl.setOrganizationId(organizationId);
		employeeImpl.setSubOrganizationId(subOrganizationId);
		employeeImpl.setGradeModeId(gradeModeId);
		employeeImpl.setDesignationClassId(designationClassId);
		employeeImpl.setDesignationGroupId(designationGroupId);

		if (postName == null) {
			employeeImpl.setPostName("");
		}
		else {
			employeeImpl.setPostName(postName);
		}

		employeeImpl.setEmploymentStatus(employmentStatus);

		if (dateOfJoining == Long.MIN_VALUE) {
			employeeImpl.setDateOfJoining(null);
		}
		else {
			employeeImpl.setDateOfJoining(new Date(dateOfJoining));
		}

		if (dateOfJoiningOrganization == Long.MIN_VALUE) {
			employeeImpl.setDateOfJoiningOrganization(null);
		}
		else {
			employeeImpl.setDateOfJoiningOrganization(
				new Date(dateOfJoiningOrganization));
		}

		if (currentDesignationDate == Long.MIN_VALUE) {
			employeeImpl.setCurrentDesignationDate(null);
		}
		else {
			employeeImpl.setCurrentDesignationDate(
				new Date(currentDesignationDate));
		}

		if (retirementDate == Long.MIN_VALUE) {
			employeeImpl.setRetirementDate(null);
		}
		else {
			employeeImpl.setRetirementDate(new Date(retirementDate));
		}

		employeeImpl.setJoiningProcessId(joiningProcessId);

		if (processType == null) {
			employeeImpl.setProcessType("");
		}
		else {
			employeeImpl.setProcessType(processType);
		}

		if (loginId == null) {
			employeeImpl.setLoginId("");
		}
		else {
			employeeImpl.setLoginId(loginId);
		}

		if (bioData == null) {
			employeeImpl.setBioData("");
		}
		else {
			employeeImpl.setBioData(bioData);
		}

		if (message == null) {
			employeeImpl.setMessage("");
		}
		else {
			employeeImpl.setMessage(message);
		}

		if (gpfNps == null) {
			employeeImpl.setGpfNps("");
		}
		else {
			employeeImpl.setGpfNps(gpfNps);
		}

		if (gpfNpsNo == null) {
			employeeImpl.setGpfNpsNo("");
		}
		else {
			employeeImpl.setGpfNpsNo(gpfNpsNo);
		}

		employeeImpl.setRank(rank);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		state = objectInput.readUTF();
		personalNo = objectInput.readUTF();

		peopleId = objectInput.readLong();
		emailId = objectInput.readUTF();

		designationId = objectInput.readLong();

		gradeId = objectInput.readLong();

		payLevelId = objectInput.readLong();

		postId = objectInput.readLong();

		tradeId = objectInput.readLong();

		cadreId = objectInput.readLong();

		organizationId = objectInput.readLong();

		subOrganizationId = objectInput.readLong();

		gradeModeId = objectInput.readLong();

		designationClassId = objectInput.readLong();

		designationGroupId = objectInput.readLong();
		postName = objectInput.readUTF();

		employmentStatus = objectInput.readInt();
		dateOfJoining = objectInput.readLong();
		dateOfJoiningOrganization = objectInput.readLong();
		currentDesignationDate = objectInput.readLong();
		retirementDate = objectInput.readLong();

		joiningProcessId = objectInput.readLong();
		processType = objectInput.readUTF();
		loginId = objectInput.readUTF();
		bioData = objectInput.readUTF();
		message = objectInput.readUTF();
		gpfNps = objectInput.readUTF();
		gpfNpsNo = objectInput.readUTF();

		rank = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (personalNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalNo);
		}

		objectOutput.writeLong(peopleId);

		if (emailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(payLevelId);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(tradeId);

		objectOutput.writeLong(cadreId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(subOrganizationId);

		objectOutput.writeLong(gradeModeId);

		objectOutput.writeLong(designationClassId);

		objectOutput.writeLong(designationGroupId);

		if (postName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postName);
		}

		objectOutput.writeInt(employmentStatus);
		objectOutput.writeLong(dateOfJoining);
		objectOutput.writeLong(dateOfJoiningOrganization);
		objectOutput.writeLong(currentDesignationDate);
		objectOutput.writeLong(retirementDate);

		objectOutput.writeLong(joiningProcessId);

		if (processType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processType);
		}

		if (loginId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loginId);
		}

		if (bioData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bioData);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (gpfNps == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gpfNps);
		}

		if (gpfNpsNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gpfNpsNo);
		}

		objectOutput.writeInt(rank);
	}

	public String uuid;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String state;
	public String personalNo;
	public long peopleId;
	public String emailId;
	public long designationId;
	public long gradeId;
	public long payLevelId;
	public long postId;
	public long tradeId;
	public long cadreId;
	public long organizationId;
	public long subOrganizationId;
	public long gradeModeId;
	public long designationClassId;
	public long designationGroupId;
	public String postName;
	public int employmentStatus;
	public long dateOfJoining;
	public long dateOfJoiningOrganization;
	public long currentDesignationDate;
	public long retirementDate;
	public long joiningProcessId;
	public String processType;
	public String loginId;
	public String bioData;
	public String message;
	public String gpfNps;
	public String gpfNpsNo;
	public int rank;

}