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

import com.adjecti.pis.liferay.model.EmployeeAddress;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeAddress in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeAddressCacheModel
	implements CacheModel<EmployeeAddress>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeAddressCacheModel)) {
			return false;
		}

		EmployeeAddressCacheModel employeeAddressCacheModel =
			(EmployeeAddressCacheModel)object;

		if (employeeAddressId == employeeAddressCacheModel.employeeAddressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeAddressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{employeeAddressId=");
		sb.append(employeeAddressId);
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
		sb.append(", permanent=");
		sb.append(permanent);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", addressLine1=");
		sb.append(addressLine1);
		sb.append(", addressLine2=");
		sb.append(addressLine2);
		sb.append(", addressLine3=");
		sb.append(addressLine3);
		sb.append(", city=");
		sb.append(city);
		sb.append(", pinCode=");
		sb.append(pinCode);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", accomodationTypeId=");
		sb.append(accomodationTypeId);
		sb.append(", districtId=");
		sb.append(districtId);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", addressProofId=");
		sb.append(addressProofId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeAddress toEntityModel() {
		EmployeeAddressImpl employeeAddressImpl = new EmployeeAddressImpl();

		employeeAddressImpl.setEmployeeAddressId(employeeAddressId);
		employeeAddressImpl.setGroupId(groupId);
		employeeAddressImpl.setCompanyId(companyId);
		employeeAddressImpl.setUserId(userId);

		if (userName == null) {
			employeeAddressImpl.setUserName("");
		}
		else {
			employeeAddressImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeAddressImpl.setCreateDate(null);
		}
		else {
			employeeAddressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeAddressImpl.setModifiedDate(null);
		}
		else {
			employeeAddressImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeAddressImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeAddressImpl.setFromDate(null);
		}
		else {
			employeeAddressImpl.setFromDate(new Date(fromDate));
		}

		employeeAddressImpl.setPermanent(permanent);

		if (toDate == Long.MIN_VALUE) {
			employeeAddressImpl.setToDate(null);
		}
		else {
			employeeAddressImpl.setToDate(new Date(toDate));
		}

		if (addressLine1 == null) {
			employeeAddressImpl.setAddressLine1("");
		}
		else {
			employeeAddressImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			employeeAddressImpl.setAddressLine2("");
		}
		else {
			employeeAddressImpl.setAddressLine2(addressLine2);
		}

		if (addressLine3 == null) {
			employeeAddressImpl.setAddressLine3("");
		}
		else {
			employeeAddressImpl.setAddressLine3(addressLine3);
		}

		if (city == null) {
			employeeAddressImpl.setCity("");
		}
		else {
			employeeAddressImpl.setCity(city);
		}

		if (pinCode == null) {
			employeeAddressImpl.setPinCode("");
		}
		else {
			employeeAddressImpl.setPinCode(pinCode);
		}

		employeeAddressImpl.setCountryId(countryId);
		employeeAddressImpl.setStateId(stateId);
		employeeAddressImpl.setAccomodationTypeId(accomodationTypeId);
		employeeAddressImpl.setDistrictId(districtId);
		employeeAddressImpl.setJoiningProcessId(joiningProcessId);
		employeeAddressImpl.setAddressProofId(addressProofId);
		employeeAddressImpl.setStatus(status);
		employeeAddressImpl.setAddressId(addressId);
		employeeAddressImpl.setEmployeeId(employeeId);

		employeeAddressImpl.resetOriginalValues();

		return employeeAddressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeAddressId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();

		permanent = objectInput.readBoolean();
		toDate = objectInput.readLong();
		addressLine1 = objectInput.readUTF();
		addressLine2 = objectInput.readUTF();
		addressLine3 = objectInput.readUTF();
		city = objectInput.readUTF();
		pinCode = objectInput.readUTF();

		countryId = objectInput.readLong();

		stateId = objectInput.readLong();

		accomodationTypeId = objectInput.readLong();

		districtId = objectInput.readLong();

		joiningProcessId = objectInput.readLong();

		addressProofId = objectInput.readLong();

		status = objectInput.readInt();

		addressId = objectInput.readLong();

		employeeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeAddressId);

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

		objectOutput.writeBoolean(permanent);
		objectOutput.writeLong(toDate);

		if (addressLine1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine1);
		}

		if (addressLine2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine2);
		}

		if (addressLine3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine3);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (pinCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pinCode);
		}

		objectOutput.writeLong(countryId);

		objectOutput.writeLong(stateId);

		objectOutput.writeLong(accomodationTypeId);

		objectOutput.writeLong(districtId);

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeLong(addressProofId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(addressId);

		objectOutput.writeLong(employeeId);
	}

	public long employeeAddressId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public boolean permanent;
	public long toDate;
	public String addressLine1;
	public String addressLine2;
	public String addressLine3;
	public String city;
	public String pinCode;
	public long countryId;
	public long stateId;
	public long accomodationTypeId;
	public long districtId;
	public long joiningProcessId;
	public long addressProofId;
	public int status;
	public long addressId;
	public long employeeId;

}