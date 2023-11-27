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

import com.adjecti.pis.liferay.model.EmployeePromotionRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeePromotionRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeePromotionRequestCacheModel
	implements CacheModel<EmployeePromotionRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePromotionRequestCacheModel)) {
			return false;
		}

		EmployeePromotionRequestCacheModel employeePromotionRequestCacheModel =
			(EmployeePromotionRequestCacheModel)object;

		if (employeePromotionRequestId ==
				employeePromotionRequestCacheModel.employeePromotionRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeePromotionRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeePromotionRequestId=");
		sb.append(employeePromotionRequestId);
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
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", promotionModeId=");
		sb.append(promotionModeId);
		sb.append(", promotionDate=");
		sb.append(promotionDate);
		sb.append(", officeOrderNo=");
		sb.append(officeOrderNo);
		sb.append(", processFileId=");
		sb.append(processFileId);
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePromotionRequest toEntityModel() {
		EmployeePromotionRequestImpl employeePromotionRequestImpl =
			new EmployeePromotionRequestImpl();

		if (uuid == null) {
			employeePromotionRequestImpl.setUuid("");
		}
		else {
			employeePromotionRequestImpl.setUuid(uuid);
		}

		employeePromotionRequestImpl.setEmployeePromotionRequestId(
			employeePromotionRequestId);
		employeePromotionRequestImpl.setGroupId(groupId);
		employeePromotionRequestImpl.setCompanyId(companyId);
		employeePromotionRequestImpl.setUserId(userId);

		if (userName == null) {
			employeePromotionRequestImpl.setUserName("");
		}
		else {
			employeePromotionRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeePromotionRequestImpl.setCreateDate(null);
		}
		else {
			employeePromotionRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeePromotionRequestImpl.setModifiedDate(null);
		}
		else {
			employeePromotionRequestImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		employeePromotionRequestImpl.setEmployeeId(employeeId);
		employeePromotionRequestImpl.setDesignationId(designationId);
		employeePromotionRequestImpl.setPromotionModeId(promotionModeId);

		if (promotionDate == Long.MIN_VALUE) {
			employeePromotionRequestImpl.setPromotionDate(null);
		}
		else {
			employeePromotionRequestImpl.setPromotionDate(
				new Date(promotionDate));
		}

		if (officeOrderNo == null) {
			employeePromotionRequestImpl.setOfficeOrderNo("");
		}
		else {
			employeePromotionRequestImpl.setOfficeOrderNo(officeOrderNo);
		}

		employeePromotionRequestImpl.setProcessFileId(processFileId);

		if (processFileNo == null) {
			employeePromotionRequestImpl.setProcessFileNo("");
		}
		else {
			employeePromotionRequestImpl.setProcessFileNo(processFileNo);
		}

		employeePromotionRequestImpl.resetOriginalValues();

		return employeePromotionRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeePromotionRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		designationId = objectInput.readLong();

		promotionModeId = objectInput.readLong();
		promotionDate = objectInput.readLong();
		officeOrderNo = objectInput.readUTF();

		processFileId = objectInput.readLong();
		processFileNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeePromotionRequestId);

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

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(promotionModeId);
		objectOutput.writeLong(promotionDate);

		if (officeOrderNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeOrderNo);
		}

		objectOutput.writeLong(processFileId);

		if (processFileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processFileNo);
		}
	}

	public String uuid;
	public long employeePromotionRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long designationId;
	public long promotionModeId;
	public long promotionDate;
	public String officeOrderNo;
	public long processFileId;
	public String processFileNo;

}