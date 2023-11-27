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

import com.adjecti.pis.liferay.model.People;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing People in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PeopleCacheModel implements CacheModel<People>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PeopleCacheModel)) {
			return false;
		}

		PeopleCacheModel peopleCacheModel = (PeopleCacheModel)object;

		if (peopleId == peopleCacheModel.peopleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, peopleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{peopleId=");
		sb.append(peopleId);
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
		sb.append(", appellationId=");
		sb.append(appellationId);
		sb.append(", firstName_Hi=");
		sb.append(firstName_Hi);
		sb.append(", firstName_En=");
		sb.append(firstName_En);
		sb.append(", lastName_Hi=");
		sb.append(lastName_Hi);
		sb.append(", lastName_En=");
		sb.append(lastName_En);
		sb.append(", middleName_Hi=");
		sb.append(middleName_Hi);
		sb.append(", middleName_En=");
		sb.append(middleName_En);
		sb.append(", fatherName_Hi=");
		sb.append(fatherName_Hi);
		sb.append(", fatherName_En=");
		sb.append(fatherName_En);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", genderId=");
		sb.append(genderId);
		sb.append(", maritalStatusId=");
		sb.append(maritalStatusId);
		sb.append(", casteCategoryId=");
		sb.append(casteCategoryId);
		sb.append(", identityProofId=");
		sb.append(identityProofId);
		sb.append(", bloodGroupId=");
		sb.append(bloodGroupId);
		sb.append(", citizenshipId=");
		sb.append(citizenshipId);
		sb.append(", phTypeId=");
		sb.append(phTypeId);
		sb.append(", religionId=");
		sb.append(religionId);
		sb.append(", aadhaarNo=");
		sb.append(aadhaarNo);
		sb.append(", panNo=");
		sb.append(panNo);
		sb.append(", color=");
		sb.append(color);
		sb.append(", height=");
		sb.append(height);
		sb.append(", identificationMark=");
		sb.append(identificationMark);
		sb.append(", exServiceMan=");
		sb.append(exServiceMan);
		sb.append(", profileImageId=");
		sb.append(profileImageId);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public People toEntityModel() {
		PeopleImpl peopleImpl = new PeopleImpl();

		peopleImpl.setPeopleId(peopleId);
		peopleImpl.setGroupId(groupId);
		peopleImpl.setCompanyId(companyId);
		peopleImpl.setUserId(userId);

		if (userName == null) {
			peopleImpl.setUserName("");
		}
		else {
			peopleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peopleImpl.setCreateDate(null);
		}
		else {
			peopleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peopleImpl.setModifiedDate(null);
		}
		else {
			peopleImpl.setModifiedDate(new Date(modifiedDate));
		}

		peopleImpl.setAppellationId(appellationId);

		if (firstName_Hi == null) {
			peopleImpl.setFirstName_Hi("");
		}
		else {
			peopleImpl.setFirstName_Hi(firstName_Hi);
		}

		if (firstName_En == null) {
			peopleImpl.setFirstName_En("");
		}
		else {
			peopleImpl.setFirstName_En(firstName_En);
		}

		if (lastName_Hi == null) {
			peopleImpl.setLastName_Hi("");
		}
		else {
			peopleImpl.setLastName_Hi(lastName_Hi);
		}

		if (lastName_En == null) {
			peopleImpl.setLastName_En("");
		}
		else {
			peopleImpl.setLastName_En(lastName_En);
		}

		if (middleName_Hi == null) {
			peopleImpl.setMiddleName_Hi("");
		}
		else {
			peopleImpl.setMiddleName_Hi(middleName_Hi);
		}

		if (middleName_En == null) {
			peopleImpl.setMiddleName_En("");
		}
		else {
			peopleImpl.setMiddleName_En(middleName_En);
		}

		if (fatherName_Hi == null) {
			peopleImpl.setFatherName_Hi("");
		}
		else {
			peopleImpl.setFatherName_Hi(fatherName_Hi);
		}

		if (fatherName_En == null) {
			peopleImpl.setFatherName_En("");
		}
		else {
			peopleImpl.setFatherName_En(fatherName_En);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			peopleImpl.setDateOfBirth(null);
		}
		else {
			peopleImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		peopleImpl.setGenderId(genderId);
		peopleImpl.setMaritalStatusId(maritalStatusId);
		peopleImpl.setCasteCategoryId(casteCategoryId);
		peopleImpl.setIdentityProofId(identityProofId);
		peopleImpl.setBloodGroupId(bloodGroupId);
		peopleImpl.setCitizenshipId(citizenshipId);
		peopleImpl.setPhTypeId(phTypeId);
		peopleImpl.setReligionId(religionId);

		if (aadhaarNo == null) {
			peopleImpl.setAadhaarNo("");
		}
		else {
			peopleImpl.setAadhaarNo(aadhaarNo);
		}

		if (panNo == null) {
			peopleImpl.setPanNo("");
		}
		else {
			peopleImpl.setPanNo(panNo);
		}

		if (color == null) {
			peopleImpl.setColor("");
		}
		else {
			peopleImpl.setColor(color);
		}

		peopleImpl.setHeight(height);

		if (identificationMark == null) {
			peopleImpl.setIdentificationMark("");
		}
		else {
			peopleImpl.setIdentificationMark(identificationMark);
		}

		peopleImpl.setExServiceMan(exServiceMan);
		peopleImpl.setProfileImageId(profileImageId);
		peopleImpl.setJoiningProcessId(joiningProcessId);

		peopleImpl.resetOriginalValues();

		return peopleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		peopleId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		appellationId = objectInput.readLong();
		firstName_Hi = objectInput.readUTF();
		firstName_En = objectInput.readUTF();
		lastName_Hi = objectInput.readUTF();
		lastName_En = objectInput.readUTF();
		middleName_Hi = objectInput.readUTF();
		middleName_En = objectInput.readUTF();
		fatherName_Hi = objectInput.readUTF();
		fatherName_En = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();

		genderId = objectInput.readLong();

		maritalStatusId = objectInput.readLong();

		casteCategoryId = objectInput.readLong();

		identityProofId = objectInput.readLong();

		bloodGroupId = objectInput.readLong();

		citizenshipId = objectInput.readLong();

		phTypeId = objectInput.readLong();

		religionId = objectInput.readLong();
		aadhaarNo = objectInput.readUTF();
		panNo = objectInput.readUTF();
		color = objectInput.readUTF();

		height = objectInput.readFloat();
		identificationMark = objectInput.readUTF();

		exServiceMan = objectInput.readBoolean();

		profileImageId = objectInput.readLong();

		joiningProcessId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(peopleId);

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

		objectOutput.writeLong(appellationId);

		if (firstName_Hi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName_Hi);
		}

		if (firstName_En == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName_En);
		}

		if (lastName_Hi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName_Hi);
		}

		if (lastName_En == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName_En);
		}

		if (middleName_Hi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(middleName_Hi);
		}

		if (middleName_En == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(middleName_En);
		}

		if (fatherName_Hi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName_Hi);
		}

		if (fatherName_En == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName_En);
		}

		objectOutput.writeLong(dateOfBirth);

		objectOutput.writeLong(genderId);

		objectOutput.writeLong(maritalStatusId);

		objectOutput.writeLong(casteCategoryId);

		objectOutput.writeLong(identityProofId);

		objectOutput.writeLong(bloodGroupId);

		objectOutput.writeLong(citizenshipId);

		objectOutput.writeLong(phTypeId);

		objectOutput.writeLong(religionId);

		if (aadhaarNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadhaarNo);
		}

		if (panNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNo);
		}

		if (color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(color);
		}

		objectOutput.writeFloat(height);

		if (identificationMark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(identificationMark);
		}

		objectOutput.writeBoolean(exServiceMan);

		objectOutput.writeLong(profileImageId);

		objectOutput.writeLong(joiningProcessId);
	}

	public long peopleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long appellationId;
	public String firstName_Hi;
	public String firstName_En;
	public String lastName_Hi;
	public String lastName_En;
	public String middleName_Hi;
	public String middleName_En;
	public String fatherName_Hi;
	public String fatherName_En;
	public long dateOfBirth;
	public long genderId;
	public long maritalStatusId;
	public long casteCategoryId;
	public long identityProofId;
	public long bloodGroupId;
	public long citizenshipId;
	public long phTypeId;
	public long religionId;
	public String aadhaarNo;
	public String panNo;
	public String color;
	public float height;
	public String identificationMark;
	public boolean exServiceMan;
	public long profileImageId;
	public long joiningProcessId;

}