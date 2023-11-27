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

import com.adjecti.pis.liferay.model.EmployeeExperience;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeExperience in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeExperienceCacheModel
	implements CacheModel<EmployeeExperience>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeExperienceCacheModel)) {
			return false;
		}

		EmployeeExperienceCacheModel employeeExperienceCacheModel =
			(EmployeeExperienceCacheModel)object;

		if (employeeExperienceId ==
				employeeExperienceCacheModel.employeeExperienceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeExperienceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{employeeExperienceId=");
		sb.append(employeeExperienceId);
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
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", tradeId=");
		sb.append(tradeId);
		sb.append(", experienceId=");
		sb.append(experienceId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", workAreaId=");
		sb.append(workAreaId);
		sb.append(", workAreaMinorId=");
		sb.append(workAreaMinorId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeExperience toEntityModel() {
		EmployeeExperienceImpl employeeExperienceImpl =
			new EmployeeExperienceImpl();

		employeeExperienceImpl.setEmployeeExperienceId(employeeExperienceId);
		employeeExperienceImpl.setGroupId(groupId);
		employeeExperienceImpl.setCompanyId(companyId);
		employeeExperienceImpl.setUserId(userId);

		if (userName == null) {
			employeeExperienceImpl.setUserName("");
		}
		else {
			employeeExperienceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setCreateDate(null);
		}
		else {
			employeeExperienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setModifiedDate(null);
		}
		else {
			employeeExperienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeExperienceImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setFromDate(null);
		}
		else {
			employeeExperienceImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setToDate(null);
		}
		else {
			employeeExperienceImpl.setToDate(new Date(toDate));
		}

		employeeExperienceImpl.setDesignationId(designationId);
		employeeExperienceImpl.setEmployeeId(employeeId);
		employeeExperienceImpl.setPostId(postId);
		employeeExperienceImpl.setTradeId(tradeId);
		employeeExperienceImpl.setExperienceId(experienceId);
		employeeExperienceImpl.setOrganizationId(organizationId);
		employeeExperienceImpl.setWorkAreaId(workAreaId);
		employeeExperienceImpl.setWorkAreaMinorId(workAreaMinorId);
		employeeExperienceImpl.setStatus(status);

		employeeExperienceImpl.resetOriginalValues();

		return employeeExperienceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeExperienceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		designationId = objectInput.readLong();

		employeeId = objectInput.readLong();

		postId = objectInput.readLong();

		tradeId = objectInput.readLong();

		experienceId = objectInput.readLong();

		organizationId = objectInput.readLong();

		workAreaId = objectInput.readLong();

		workAreaMinorId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeExperienceId);

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

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(tradeId);

		objectOutput.writeLong(experienceId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(workAreaId);

		objectOutput.writeLong(workAreaMinorId);

		objectOutput.writeInt(status);
	}

	public long employeeExperienceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public long toDate;
	public long designationId;
	public long employeeId;
	public long postId;
	public long tradeId;
	public long experienceId;
	public long organizationId;
	public long workAreaId;
	public long workAreaMinorId;
	public int status;

}