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

import com.adjecti.pis.liferay.model.Address;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressCacheModel implements CacheModel<Address>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AddressCacheModel)) {
			return false;
		}

		AddressCacheModel addressCacheModel = (AddressCacheModel)object;

		if (addressId == addressCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{addressId=");
		sb.append(addressId);
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
		sb.append(", addressTypeId=");
		sb.append(addressTypeId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(addressId);
		addressImpl.setGroupId(groupId);
		addressImpl.setCompanyId(companyId);
		addressImpl.setUserId(userId);

		if (userName == null) {
			addressImpl.setUserName("");
		}
		else {
			addressImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			addressImpl.setCreateDate(null);
		}
		else {
			addressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			addressImpl.setModifiedDate(null);
		}
		else {
			addressImpl.setModifiedDate(new Date(modifiedDate));
		}

		addressImpl.setAddressTypeId(addressTypeId);

		if (addressLine1 == null) {
			addressImpl.setAddressLine1("");
		}
		else {
			addressImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			addressImpl.setAddressLine2("");
		}
		else {
			addressImpl.setAddressLine2(addressLine2);
		}

		if (addressLine3 == null) {
			addressImpl.setAddressLine3("");
		}
		else {
			addressImpl.setAddressLine3(addressLine3);
		}

		if (city == null) {
			addressImpl.setCity("");
		}
		else {
			addressImpl.setCity(city);
		}

		if (pinCode == null) {
			addressImpl.setPinCode("");
		}
		else {
			addressImpl.setPinCode(pinCode);
		}

		addressImpl.setCountryId(countryId);
		addressImpl.setStateId(stateId);
		addressImpl.setAccomodationTypeId(accomodationTypeId);
		addressImpl.setDistrictId(districtId);
		addressImpl.setJoiningProcessId(joiningProcessId);
		addressImpl.setAddressProofId(addressProofId);

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		addressTypeId = objectInput.readInt();
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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addressId);

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

		objectOutput.writeInt(addressTypeId);

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
	}

	public long addressId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int addressTypeId;
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

}