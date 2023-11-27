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

import com.adjecti.pis.liferay.model.EmployeePromotion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeePromotion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeePromotionCacheModel
	implements CacheModel<EmployeePromotion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePromotionCacheModel)) {
			return false;
		}

		EmployeePromotionCacheModel employeePromotionCacheModel =
			(EmployeePromotionCacheModel)object;

		if (employeePromotionId ==
				employeePromotionCacheModel.employeePromotionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeePromotionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{employeePromotionId=");
		sb.append(employeePromotionId);
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
		sb.append(", promotionDate=");
		sb.append(promotionDate);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", gradeModeId=");
		sb.append(gradeModeId);
		sb.append(", promotionLetterId=");
		sb.append(promotionLetterId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePromotion toEntityModel() {
		EmployeePromotionImpl employeePromotionImpl =
			new EmployeePromotionImpl();

		employeePromotionImpl.setEmployeePromotionId(employeePromotionId);
		employeePromotionImpl.setGroupId(groupId);
		employeePromotionImpl.setCompanyId(companyId);
		employeePromotionImpl.setUserId(userId);

		if (userName == null) {
			employeePromotionImpl.setUserName("");
		}
		else {
			employeePromotionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeePromotionImpl.setCreateDate(null);
		}
		else {
			employeePromotionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeePromotionImpl.setModifiedDate(null);
		}
		else {
			employeePromotionImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeePromotionImpl.setActive(active);

		if (promotionDate == Long.MIN_VALUE) {
			employeePromotionImpl.setPromotionDate(null);
		}
		else {
			employeePromotionImpl.setPromotionDate(new Date(promotionDate));
		}

		employeePromotionImpl.setDesignationId(designationId);
		employeePromotionImpl.setEmployeeId(employeeId);
		employeePromotionImpl.setGradeId(gradeId);
		employeePromotionImpl.setGradeModeId(gradeModeId);
		employeePromotionImpl.setPromotionLetterId(promotionLetterId);
		employeePromotionImpl.setOrganizationId(organizationId);
		employeePromotionImpl.setPersonalNo(personalNo);
		employeePromotionImpl.setStatus(status);

		employeePromotionImpl.resetOriginalValues();

		return employeePromotionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeePromotionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		promotionDate = objectInput.readLong();

		designationId = objectInput.readLong();

		employeeId = objectInput.readLong();

		gradeId = objectInput.readLong();

		gradeModeId = objectInput.readLong();

		promotionLetterId = objectInput.readLong();

		organizationId = objectInput.readLong();

		personalNo = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeePromotionId);

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
		objectOutput.writeLong(promotionDate);

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(gradeModeId);

		objectOutput.writeLong(promotionLetterId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(personalNo);

		objectOutput.writeInt(status);
	}

	public long employeePromotionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long promotionDate;
	public long designationId;
	public long employeeId;
	public long gradeId;
	public long gradeModeId;
	public long promotionLetterId;
	public long organizationId;
	public long personalNo;
	public int status;

}