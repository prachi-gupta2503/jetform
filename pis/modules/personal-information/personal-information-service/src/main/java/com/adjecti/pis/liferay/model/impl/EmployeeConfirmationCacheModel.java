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

import com.adjecti.pis.liferay.model.EmployeeConfirmation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeConfirmation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeConfirmationCacheModel
	implements CacheModel<EmployeeConfirmation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeConfirmationCacheModel)) {
			return false;
		}

		EmployeeConfirmationCacheModel employeeConfirmationCacheModel =
			(EmployeeConfirmationCacheModel)object;

		if (employeeConfirmationId ==
				employeeConfirmationCacheModel.employeeConfirmationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeConfirmationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{employeeConfirmationId=");
		sb.append(employeeConfirmationId);
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
		sb.append(", confirmationDate=");
		sb.append(confirmationDate);
		sb.append(", confirmationLetterId=");
		sb.append(confirmationLetterId);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", gradeModeId=");
		sb.append(gradeModeId);
		sb.append(", joiningId=");
		sb.append(joiningId);
		sb.append(", promotionId=");
		sb.append(promotionId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", confirmationPostId=");
		sb.append(confirmationPostId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeConfirmation toEntityModel() {
		EmployeeConfirmationImpl employeeConfirmationImpl =
			new EmployeeConfirmationImpl();

		employeeConfirmationImpl.setEmployeeConfirmationId(
			employeeConfirmationId);
		employeeConfirmationImpl.setGroupId(groupId);
		employeeConfirmationImpl.setCompanyId(companyId);
		employeeConfirmationImpl.setUserId(userId);

		if (userName == null) {
			employeeConfirmationImpl.setUserName("");
		}
		else {
			employeeConfirmationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeConfirmationImpl.setCreateDate(null);
		}
		else {
			employeeConfirmationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeConfirmationImpl.setModifiedDate(null);
		}
		else {
			employeeConfirmationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeConfirmationImpl.setActive(active);

		if (confirmationDate == Long.MIN_VALUE) {
			employeeConfirmationImpl.setConfirmationDate(null);
		}
		else {
			employeeConfirmationImpl.setConfirmationDate(
				new Date(confirmationDate));
		}

		employeeConfirmationImpl.setConfirmationLetterId(confirmationLetterId);
		employeeConfirmationImpl.setDesignationId(designationId);
		employeeConfirmationImpl.setGradeId(gradeId);
		employeeConfirmationImpl.setGradeModeId(gradeModeId);
		employeeConfirmationImpl.setJoiningId(joiningId);
		employeeConfirmationImpl.setPromotionId(promotionId);
		employeeConfirmationImpl.setOrganizationId(organizationId);
		employeeConfirmationImpl.setConfirmationPostId(confirmationPostId);
		employeeConfirmationImpl.setStatus(status);
		employeeConfirmationImpl.setEmployeeId(employeeId);

		employeeConfirmationImpl.resetOriginalValues();

		return employeeConfirmationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeConfirmationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		confirmationDate = objectInput.readLong();

		confirmationLetterId = objectInput.readLong();

		designationId = objectInput.readLong();

		gradeId = objectInput.readLong();

		gradeModeId = objectInput.readLong();

		joiningId = objectInput.readLong();

		promotionId = objectInput.readLong();

		organizationId = objectInput.readLong();

		confirmationPostId = objectInput.readLong();

		status = objectInput.readInt();

		employeeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeConfirmationId);

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
		objectOutput.writeLong(confirmationDate);

		objectOutput.writeLong(confirmationLetterId);

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(gradeModeId);

		objectOutput.writeLong(joiningId);

		objectOutput.writeLong(promotionId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(confirmationPostId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(employeeId);
	}

	public long employeeConfirmationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long confirmationDate;
	public long confirmationLetterId;
	public long designationId;
	public long gradeId;
	public long gradeModeId;
	public long joiningId;
	public long promotionId;
	public long organizationId;
	public long confirmationPostId;
	public int status;
	public long employeeId;

}