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

import com.adjecti.pis.liferay.model.EmployeePastExperience;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeePastExperience in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeePastExperienceCacheModel
	implements CacheModel<EmployeePastExperience>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePastExperienceCacheModel)) {
			return false;
		}

		EmployeePastExperienceCacheModel employeePastExperienceCacheModel =
			(EmployeePastExperienceCacheModel)object;

		if (employeePastExperienceId ==
				employeePastExperienceCacheModel.employeePastExperienceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeePastExperienceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{employeePastExperienceId=");
		sb.append(employeePastExperienceId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", organization=");
		sb.append(organization);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", experienceLetterId=");
		sb.append(experienceLetterId);
		sb.append(", workAreaId=");
		sb.append(workAreaId);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", exServiceMan=");
		sb.append(exServiceMan);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePastExperience toEntityModel() {
		EmployeePastExperienceImpl employeePastExperienceImpl =
			new EmployeePastExperienceImpl();

		employeePastExperienceImpl.setEmployeePastExperienceId(
			employeePastExperienceId);
		employeePastExperienceImpl.setGroupId(groupId);
		employeePastExperienceImpl.setCompanyId(companyId);
		employeePastExperienceImpl.setUserId(userId);

		if (userName == null) {
			employeePastExperienceImpl.setUserName("");
		}
		else {
			employeePastExperienceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeePastExperienceImpl.setCreateDate(null);
		}
		else {
			employeePastExperienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeePastExperienceImpl.setModifiedDate(null);
		}
		else {
			employeePastExperienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeePastExperienceImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeePastExperienceImpl.setFromDate(null);
		}
		else {
			employeePastExperienceImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeePastExperienceImpl.setToDate(null);
		}
		else {
			employeePastExperienceImpl.setToDate(new Date(toDate));
		}

		if (organization == null) {
			employeePastExperienceImpl.setOrganization("");
		}
		else {
			employeePastExperienceImpl.setOrganization(organization);
		}

		employeePastExperienceImpl.setEmployeeId(employeeId);
		employeePastExperienceImpl.setExperienceLetterId(experienceLetterId);
		employeePastExperienceImpl.setWorkAreaId(workAreaId);

		if (designation == null) {
			employeePastExperienceImpl.setDesignation("");
		}
		else {
			employeePastExperienceImpl.setDesignation(designation);
		}

		employeePastExperienceImpl.setJoiningProcessId(joiningProcessId);
		employeePastExperienceImpl.setExServiceMan(exServiceMan);
		employeePastExperienceImpl.setStatus(status);

		employeePastExperienceImpl.resetOriginalValues();

		return employeePastExperienceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeePastExperienceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		organization = objectInput.readUTF();

		employeeId = objectInput.readLong();

		experienceLetterId = objectInput.readLong();

		workAreaId = objectInput.readLong();
		designation = objectInput.readUTF();

		joiningProcessId = objectInput.readLong();

		exServiceMan = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeePastExperienceId);

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

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		if (organization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organization);
		}

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(experienceLetterId);

		objectOutput.writeLong(workAreaId);

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeBoolean(exServiceMan);

		objectOutput.writeInt(status);
	}

	public long employeePastExperienceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public long toDate;
	public String organization;
	public long employeeId;
	public long experienceLetterId;
	public long workAreaId;
	public String designation;
	public long joiningProcessId;
	public boolean exServiceMan;
	public int status;

}