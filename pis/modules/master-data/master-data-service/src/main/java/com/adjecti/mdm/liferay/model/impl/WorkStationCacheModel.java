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

package com.adjecti.mdm.liferay.model.impl;

import com.adjecti.mdm.liferay.model.WorkStation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkStation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkStationCacheModel
	implements CacheModel<WorkStation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkStationCacheModel)) {
			return false;
		}

		WorkStationCacheModel workStationCacheModel =
			(WorkStationCacheModel)object;

		if (workStationId == workStationCacheModel.workStationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workStationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{workStationId=");
		sb.append(workStationId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", deskNo=");
		sb.append(deskNo);
		sb.append(", extnNo=");
		sb.append(extnNo);
		sb.append(", directNo=");
		sb.append(directNo);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", cabinNo=");
		sb.append(cabinNo);
		sb.append(", floorNo=");
		sb.append(floorNo);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkStation toEntityModel() {
		WorkStationImpl workStationImpl = new WorkStationImpl();

		workStationImpl.setWorkStationId(workStationId);
		workStationImpl.setGroupId(groupId);
		workStationImpl.setCompanyId(companyId);
		workStationImpl.setUserId(userId);

		if (userName == null) {
			workStationImpl.setUserName("");
		}
		else {
			workStationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workStationImpl.setCreateDate(null);
		}
		else {
			workStationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workStationImpl.setModifiedDate(null);
		}
		else {
			workStationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			workStationImpl.setCode("");
		}
		else {
			workStationImpl.setCode(code);
		}

		if (deskNo == null) {
			workStationImpl.setDeskNo("");
		}
		else {
			workStationImpl.setDeskNo(deskNo);
		}

		if (extnNo == null) {
			workStationImpl.setExtnNo("");
		}
		else {
			workStationImpl.setExtnNo(extnNo);
		}

		if (directNo == null) {
			workStationImpl.setDirectNo("");
		}
		else {
			workStationImpl.setDirectNo(directNo);
		}

		if (phoneNo == null) {
			workStationImpl.setPhoneNo("");
		}
		else {
			workStationImpl.setPhoneNo(phoneNo);
		}

		if (cabinNo == null) {
			workStationImpl.setCabinNo("");
		}
		else {
			workStationImpl.setCabinNo(cabinNo);
		}

		if (floorNo == null) {
			workStationImpl.setFloorNo("");
		}
		else {
			workStationImpl.setFloorNo(floorNo);
		}

		workStationImpl.setDeleted(deleted);
		workStationImpl.setStatus(status);

		workStationImpl.resetOriginalValues();

		return workStationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workStationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		deskNo = objectInput.readUTF();
		extnNo = objectInput.readUTF();
		directNo = objectInput.readUTF();
		phoneNo = objectInput.readUTF();
		cabinNo = objectInput.readUTF();
		floorNo = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(workStationId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (deskNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deskNo);
		}

		if (extnNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extnNo);
		}

		if (directNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(directNo);
		}

		if (phoneNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		if (cabinNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cabinNo);
		}

		if (floorNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(floorNo);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long workStationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String deskNo;
	public String extnNo;
	public String directNo;
	public String phoneNo;
	public String cabinNo;
	public String floorNo;
	public boolean deleted;
	public int status;

}