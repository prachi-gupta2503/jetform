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

import com.adjecti.pis.liferay.model.EmployeeTraining;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeTraining in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeTrainingCacheModel
	implements CacheModel<EmployeeTraining>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeTrainingCacheModel)) {
			return false;
		}

		EmployeeTrainingCacheModel employeeTrainingCacheModel =
			(EmployeeTrainingCacheModel)object;

		if (employeeTrainingId ==
				employeeTrainingCacheModel.employeeTrainingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeTrainingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{employeeTrainingId=");
		sb.append(employeeTrainingId);
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
		sb.append(", durationMonths=");
		sb.append(durationMonths);
		sb.append(", fromMonth=");
		sb.append(fromMonth);
		sb.append(", toMonth=");
		sb.append(toMonth);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", certificateId=");
		sb.append(certificateId);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", instituteId=");
		sb.append(instituteId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeTraining toEntityModel() {
		EmployeeTrainingImpl employeeTrainingImpl = new EmployeeTrainingImpl();

		employeeTrainingImpl.setEmployeeTrainingId(employeeTrainingId);
		employeeTrainingImpl.setGroupId(groupId);
		employeeTrainingImpl.setCompanyId(companyId);
		employeeTrainingImpl.setUserId(userId);

		if (userName == null) {
			employeeTrainingImpl.setUserName("");
		}
		else {
			employeeTrainingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeTrainingImpl.setCreateDate(null);
		}
		else {
			employeeTrainingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeTrainingImpl.setModifiedDate(null);
		}
		else {
			employeeTrainingImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeTrainingImpl.setActive(active);
		employeeTrainingImpl.setDurationMonths(durationMonths);

		if (fromMonth == Long.MIN_VALUE) {
			employeeTrainingImpl.setFromMonth(null);
		}
		else {
			employeeTrainingImpl.setFromMonth(new Date(fromMonth));
		}

		if (toMonth == Long.MIN_VALUE) {
			employeeTrainingImpl.setToMonth(null);
		}
		else {
			employeeTrainingImpl.setToMonth(new Date(toMonth));
		}

		employeeTrainingImpl.setCourseId(courseId);
		employeeTrainingImpl.setEmployeeId(employeeId);
		employeeTrainingImpl.setOrganizationId(organizationId);
		employeeTrainingImpl.setCertificateId(certificateId);

		if (endDate == Long.MIN_VALUE) {
			employeeTrainingImpl.setEndDate(null);
		}
		else {
			employeeTrainingImpl.setEndDate(new Date(endDate));
		}

		if (startDate == Long.MIN_VALUE) {
			employeeTrainingImpl.setStartDate(null);
		}
		else {
			employeeTrainingImpl.setStartDate(new Date(startDate));
		}

		employeeTrainingImpl.setInstituteId(instituteId);
		employeeTrainingImpl.setStatus(status);

		employeeTrainingImpl.resetOriginalValues();

		return employeeTrainingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeTrainingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();

		durationMonths = objectInput.readInt();
		fromMonth = objectInput.readLong();
		toMonth = objectInput.readLong();

		courseId = objectInput.readLong();

		employeeId = objectInput.readLong();

		organizationId = objectInput.readLong();

		certificateId = objectInput.readLong();
		endDate = objectInput.readLong();
		startDate = objectInput.readLong();

		instituteId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeTrainingId);

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

		objectOutput.writeInt(durationMonths);
		objectOutput.writeLong(fromMonth);
		objectOutput.writeLong(toMonth);

		objectOutput.writeLong(courseId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(certificateId);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(startDate);

		objectOutput.writeLong(instituteId);

		objectOutput.writeInt(status);
	}

	public long employeeTrainingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public int durationMonths;
	public long fromMonth;
	public long toMonth;
	public long courseId;
	public long employeeId;
	public long organizationId;
	public long certificateId;
	public long endDate;
	public long startDate;
	public long instituteId;
	public int status;

}