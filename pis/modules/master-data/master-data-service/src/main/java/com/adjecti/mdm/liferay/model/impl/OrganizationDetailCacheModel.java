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

import com.adjecti.mdm.liferay.model.OrganizationDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrganizationDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrganizationDetailCacheModel
	implements CacheModel<OrganizationDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrganizationDetailCacheModel)) {
			return false;
		}

		OrganizationDetailCacheModel organizationDetailCacheModel =
			(OrganizationDetailCacheModel)object;

		if (organizationDetailId ==
				organizationDetailCacheModel.organizationDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organizationDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{organizationDetailId=");
		sb.append(organizationDetailId);
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
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", organizationCode=");
		sb.append(organizationCode);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", parentCode=");
		sb.append(parentCode);
		sb.append(", type=");
		sb.append(type);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", longName=");
		sb.append(longName);
		sb.append(", division=");
		sb.append(division);
		sb.append(", addressedTo=");
		sb.append(addressedTo);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", address3=");
		sb.append(address3);
		sb.append(", city=");
		sb.append(city);
		sb.append(", district=");
		sb.append(district);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", zone=");
		sb.append(zone);
		sb.append(", pin=");
		sb.append(pin);
		sb.append(", nearestRailwayStation=");
		sb.append(nearestRailwayStation);
		sb.append(", telegram=");
		sb.append(telegram);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", telex=");
		sb.append(telex);
		sb.append(", telephone1=");
		sb.append(telephone1);
		sb.append(", telephone2=");
		sb.append(telephone2);
		sb.append(", stationId=");
		sb.append(stationId);
		sb.append(", unitType=");
		sb.append(unitType);
		sb.append(", orgStatus=");
		sb.append(orgStatus);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationDetail toEntityModel() {
		OrganizationDetailImpl organizationDetailImpl =
			new OrganizationDetailImpl();

		organizationDetailImpl.setOrganizationDetailId(organizationDetailId);
		organizationDetailImpl.setGroupId(groupId);
		organizationDetailImpl.setCompanyId(companyId);
		organizationDetailImpl.setUserId(userId);

		if (userName == null) {
			organizationDetailImpl.setUserName("");
		}
		else {
			organizationDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			organizationDetailImpl.setCreateDate(null);
		}
		else {
			organizationDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationDetailImpl.setModifiedDate(null);
		}
		else {
			organizationDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationDetailImpl.setOrganizationId(organizationId);

		if (organizationCode == null) {
			organizationDetailImpl.setOrganizationCode("");
		}
		else {
			organizationDetailImpl.setOrganizationCode(organizationCode);
		}

		organizationDetailImpl.setParentId(parentId);

		if (parentCode == null) {
			organizationDetailImpl.setParentCode("");
		}
		else {
			organizationDetailImpl.setParentCode(parentCode);
		}

		if (type == null) {
			organizationDetailImpl.setType("");
		}
		else {
			organizationDetailImpl.setType(type);
		}

		if (shortName == null) {
			organizationDetailImpl.setShortName("");
		}
		else {
			organizationDetailImpl.setShortName(shortName);
		}

		if (longName == null) {
			organizationDetailImpl.setLongName("");
		}
		else {
			organizationDetailImpl.setLongName(longName);
		}

		if (division == null) {
			organizationDetailImpl.setDivision("");
		}
		else {
			organizationDetailImpl.setDivision(division);
		}

		if (addressedTo == null) {
			organizationDetailImpl.setAddressedTo("");
		}
		else {
			organizationDetailImpl.setAddressedTo(addressedTo);
		}

		if (address1 == null) {
			organizationDetailImpl.setAddress1("");
		}
		else {
			organizationDetailImpl.setAddress1(address1);
		}

		if (address2 == null) {
			organizationDetailImpl.setAddress2("");
		}
		else {
			organizationDetailImpl.setAddress2(address2);
		}

		if (address3 == null) {
			organizationDetailImpl.setAddress3("");
		}
		else {
			organizationDetailImpl.setAddress3(address3);
		}

		if (city == null) {
			organizationDetailImpl.setCity("");
		}
		else {
			organizationDetailImpl.setCity(city);
		}

		if (district == null) {
			organizationDetailImpl.setDistrict("");
		}
		else {
			organizationDetailImpl.setDistrict(district);
		}

		organizationDetailImpl.setStateId(stateId);

		if (zone == null) {
			organizationDetailImpl.setZone("");
		}
		else {
			organizationDetailImpl.setZone(zone);
		}

		if (pin == null) {
			organizationDetailImpl.setPin("");
		}
		else {
			organizationDetailImpl.setPin(pin);
		}

		if (nearestRailwayStation == null) {
			organizationDetailImpl.setNearestRailwayStation("");
		}
		else {
			organizationDetailImpl.setNearestRailwayStation(
				nearestRailwayStation);
		}

		if (telegram == null) {
			organizationDetailImpl.setTelegram("");
		}
		else {
			organizationDetailImpl.setTelegram(telegram);
		}

		if (fax == null) {
			organizationDetailImpl.setFax("");
		}
		else {
			organizationDetailImpl.setFax(fax);
		}

		if (telex == null) {
			organizationDetailImpl.setTelex("");
		}
		else {
			organizationDetailImpl.setTelex(telex);
		}

		if (telephone1 == null) {
			organizationDetailImpl.setTelephone1("");
		}
		else {
			organizationDetailImpl.setTelephone1(telephone1);
		}

		if (telephone2 == null) {
			organizationDetailImpl.setTelephone2("");
		}
		else {
			organizationDetailImpl.setTelephone2(telephone2);
		}

		if (stationId == null) {
			organizationDetailImpl.setStationId("");
		}
		else {
			organizationDetailImpl.setStationId(stationId);
		}

		if (unitType == null) {
			organizationDetailImpl.setUnitType("");
		}
		else {
			organizationDetailImpl.setUnitType(unitType);
		}

		if (orgStatus == null) {
			organizationDetailImpl.setOrgStatus("");
		}
		else {
			organizationDetailImpl.setOrgStatus(orgStatus);
		}

		organizationDetailImpl.setDeleted(deleted);
		organizationDetailImpl.setStatus(status);

		organizationDetailImpl.resetOriginalValues();

		return organizationDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		organizationId = objectInput.readLong();
		organizationCode = objectInput.readUTF();

		parentId = objectInput.readLong();
		parentCode = objectInput.readUTF();
		type = objectInput.readUTF();
		shortName = objectInput.readUTF();
		longName = objectInput.readUTF();
		division = objectInput.readUTF();
		addressedTo = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		address3 = objectInput.readUTF();
		city = objectInput.readUTF();
		district = objectInput.readUTF();

		stateId = objectInput.readLong();
		zone = objectInput.readUTF();
		pin = objectInput.readUTF();
		nearestRailwayStation = objectInput.readUTF();
		telegram = objectInput.readUTF();
		fax = objectInput.readUTF();
		telex = objectInput.readUTF();
		telephone1 = objectInput.readUTF();
		telephone2 = objectInput.readUTF();
		stationId = objectInput.readUTF();
		unitType = objectInput.readUTF();
		orgStatus = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(organizationDetailId);

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

		objectOutput.writeLong(organizationId);

		if (organizationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationCode);
		}

		objectOutput.writeLong(parentId);

		if (parentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentCode);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (shortName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		if (longName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longName);
		}

		if (division == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (addressedTo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressedTo);
		}

		if (address1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (address3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address3);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (district == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(district);
		}

		objectOutput.writeLong(stateId);

		if (zone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zone);
		}

		if (pin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pin);
		}

		if (nearestRailwayStation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nearestRailwayStation);
		}

		if (telegram == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telegram);
		}

		if (fax == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fax);
		}

		if (telex == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telex);
		}

		if (telephone1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telephone1);
		}

		if (telephone2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telephone2);
		}

		if (stationId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stationId);
		}

		if (unitType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unitType);
		}

		if (orgStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgStatus);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long organizationDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long organizationId;
	public String organizationCode;
	public long parentId;
	public String parentCode;
	public String type;
	public String shortName;
	public String longName;
	public String division;
	public String addressedTo;
	public String address1;
	public String address2;
	public String address3;
	public String city;
	public String district;
	public long stateId;
	public String zone;
	public String pin;
	public String nearestRailwayStation;
	public String telegram;
	public String fax;
	public String telex;
	public String telephone1;
	public String telephone2;
	public String stationId;
	public String unitType;
	public String orgStatus;
	public boolean deleted;
	public int status;

}