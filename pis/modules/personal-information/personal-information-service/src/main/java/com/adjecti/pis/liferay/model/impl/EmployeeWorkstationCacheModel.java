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

import com.adjecti.pis.liferay.model.EmployeeWorkstation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeWorkstation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeWorkstationCacheModel
	implements CacheModel<EmployeeWorkstation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeWorkstationCacheModel)) {
			return false;
		}

		EmployeeWorkstationCacheModel employeeWorkstationCacheModel =
			(EmployeeWorkstationCacheModel)object;

		if (employeeWorkstationId ==
				employeeWorkstationCacheModel.employeeWorkstationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeWorkstationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{employeeWorkstationId=");
		sb.append(employeeWorkstationId);
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
		sb.append(", fromMonth=");
		sb.append(fromMonth);
		sb.append(", toMonth=");
		sb.append(toMonth);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", workStationId=");
		sb.append(workStationId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeWorkstation toEntityModel() {
		EmployeeWorkstationImpl employeeWorkstationImpl =
			new EmployeeWorkstationImpl();

		employeeWorkstationImpl.setEmployeeWorkstationId(employeeWorkstationId);
		employeeWorkstationImpl.setGroupId(groupId);
		employeeWorkstationImpl.setCompanyId(companyId);
		employeeWorkstationImpl.setUserId(userId);

		if (userName == null) {
			employeeWorkstationImpl.setUserName("");
		}
		else {
			employeeWorkstationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeWorkstationImpl.setCreateDate(null);
		}
		else {
			employeeWorkstationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeWorkstationImpl.setModifiedDate(null);
		}
		else {
			employeeWorkstationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeWorkstationImpl.setActive(active);

		if (fromMonth == Long.MIN_VALUE) {
			employeeWorkstationImpl.setFromMonth(null);
		}
		else {
			employeeWorkstationImpl.setFromMonth(new Date(fromMonth));
		}

		if (toMonth == Long.MIN_VALUE) {
			employeeWorkstationImpl.setToMonth(null);
		}
		else {
			employeeWorkstationImpl.setToMonth(new Date(toMonth));
		}

		employeeWorkstationImpl.setEmployeeId(employeeId);
		employeeWorkstationImpl.setWorkStationId(workStationId);

		if (deskNo == null) {
			employeeWorkstationImpl.setDeskNo("");
		}
		else {
			employeeWorkstationImpl.setDeskNo(deskNo);
		}

		if (extnNo == null) {
			employeeWorkstationImpl.setExtnNo("");
		}
		else {
			employeeWorkstationImpl.setExtnNo(extnNo);
		}

		if (directNo == null) {
			employeeWorkstationImpl.setDirectNo("");
		}
		else {
			employeeWorkstationImpl.setDirectNo(directNo);
		}

		if (phoneNo == null) {
			employeeWorkstationImpl.setPhoneNo("");
		}
		else {
			employeeWorkstationImpl.setPhoneNo(phoneNo);
		}

		if (cabinNo == null) {
			employeeWorkstationImpl.setCabinNo("");
		}
		else {
			employeeWorkstationImpl.setCabinNo(cabinNo);
		}

		if (floorNo == null) {
			employeeWorkstationImpl.setFloorNo("");
		}
		else {
			employeeWorkstationImpl.setFloorNo(floorNo);
		}

		employeeWorkstationImpl.setStatus(status);

		employeeWorkstationImpl.resetOriginalValues();

		return employeeWorkstationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeWorkstationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromMonth = objectInput.readLong();
		toMonth = objectInput.readLong();

		employeeId = objectInput.readLong();

		workStationId = objectInput.readLong();
		deskNo = objectInput.readUTF();
		extnNo = objectInput.readUTF();
		directNo = objectInput.readUTF();
		phoneNo = objectInput.readUTF();
		cabinNo = objectInput.readUTF();
		floorNo = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeWorkstationId);

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
		objectOutput.writeLong(fromMonth);
		objectOutput.writeLong(toMonth);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(workStationId);

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

		objectOutput.writeInt(status);
	}

	public long employeeWorkstationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromMonth;
	public long toMonth;
	public long employeeId;
	public long workStationId;
	public String deskNo;
	public String extnNo;
	public String directNo;
	public String phoneNo;
	public String cabinNo;
	public String floorNo;
	public int status;

}