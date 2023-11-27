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

import com.adjecti.pis.liferay.model.FamilyHealthDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FamilyHealthDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FamilyHealthDetailCacheModel
	implements CacheModel<FamilyHealthDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FamilyHealthDetailCacheModel)) {
			return false;
		}

		FamilyHealthDetailCacheModel familyHealthDetailCacheModel =
			(FamilyHealthDetailCacheModel)object;

		if (familyHealthDetailId ==
				familyHealthDetailCacheModel.familyHealthDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, familyHealthDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{familyHealthDetailId=");
		sb.append(familyHealthDetailId);
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
		sb.append(", boardUniversity=");
		sb.append(boardUniversity);
		sb.append(", cityOfStudy=");
		sb.append(cityOfStudy);
		sb.append(", deseaseDetails=");
		sb.append(deseaseDetails);
		sb.append(", fromYear=");
		sb.append(fromYear);
		sb.append(", institutionName=");
		sb.append(institutionName);
		sb.append(", toYear=");
		sb.append(toYear);
		sb.append(", familyMemberId=");
		sb.append(familyMemberId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", hospitalName=");
		sb.append(hospitalName);
		sb.append(", underTreatment=");
		sb.append(underTreatment);
		sb.append(", cityOfHospital=");
		sb.append(cityOfHospital);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", diseaseTypeId=");
		sb.append(diseaseTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FamilyHealthDetail toEntityModel() {
		FamilyHealthDetailImpl familyHealthDetailImpl =
			new FamilyHealthDetailImpl();

		familyHealthDetailImpl.setFamilyHealthDetailId(familyHealthDetailId);
		familyHealthDetailImpl.setGroupId(groupId);
		familyHealthDetailImpl.setCompanyId(companyId);
		familyHealthDetailImpl.setUserId(userId);

		if (userName == null) {
			familyHealthDetailImpl.setUserName("");
		}
		else {
			familyHealthDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			familyHealthDetailImpl.setCreateDate(null);
		}
		else {
			familyHealthDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			familyHealthDetailImpl.setModifiedDate(null);
		}
		else {
			familyHealthDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (boardUniversity == null) {
			familyHealthDetailImpl.setBoardUniversity("");
		}
		else {
			familyHealthDetailImpl.setBoardUniversity(boardUniversity);
		}

		if (cityOfStudy == null) {
			familyHealthDetailImpl.setCityOfStudy("");
		}
		else {
			familyHealthDetailImpl.setCityOfStudy(cityOfStudy);
		}

		if (deseaseDetails == null) {
			familyHealthDetailImpl.setDeseaseDetails("");
		}
		else {
			familyHealthDetailImpl.setDeseaseDetails(deseaseDetails);
		}

		familyHealthDetailImpl.setFromYear(fromYear);

		if (institutionName == null) {
			familyHealthDetailImpl.setInstitutionName("");
		}
		else {
			familyHealthDetailImpl.setInstitutionName(institutionName);
		}

		familyHealthDetailImpl.setToYear(toYear);
		familyHealthDetailImpl.setFamilyMemberId(familyMemberId);
		familyHealthDetailImpl.setStateId(stateId);

		if (hospitalName == null) {
			familyHealthDetailImpl.setHospitalName("");
		}
		else {
			familyHealthDetailImpl.setHospitalName(hospitalName);
		}

		familyHealthDetailImpl.setUnderTreatment(underTreatment);

		if (cityOfHospital == null) {
			familyHealthDetailImpl.setCityOfHospital("");
		}
		else {
			familyHealthDetailImpl.setCityOfHospital(cityOfHospital);
		}

		familyHealthDetailImpl.setLevelId(levelId);
		familyHealthDetailImpl.setDiseaseTypeId(diseaseTypeId);

		familyHealthDetailImpl.resetOriginalValues();

		return familyHealthDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		familyHealthDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		boardUniversity = objectInput.readUTF();
		cityOfStudy = objectInput.readUTF();
		deseaseDetails = objectInput.readUTF();

		fromYear = objectInput.readInt();
		institutionName = objectInput.readUTF();

		toYear = objectInput.readInt();

		familyMemberId = objectInput.readLong();

		stateId = objectInput.readLong();
		hospitalName = objectInput.readUTF();

		underTreatment = objectInput.readBoolean();
		cityOfHospital = objectInput.readUTF();

		levelId = objectInput.readLong();

		diseaseTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(familyHealthDetailId);

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

		if (boardUniversity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(boardUniversity);
		}

		if (cityOfStudy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityOfStudy);
		}

		if (deseaseDetails == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deseaseDetails);
		}

		objectOutput.writeInt(fromYear);

		if (institutionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institutionName);
		}

		objectOutput.writeInt(toYear);

		objectOutput.writeLong(familyMemberId);

		objectOutput.writeLong(stateId);

		if (hospitalName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hospitalName);
		}

		objectOutput.writeBoolean(underTreatment);

		if (cityOfHospital == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityOfHospital);
		}

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(diseaseTypeId);
	}

	public long familyHealthDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String boardUniversity;
	public String cityOfStudy;
	public String deseaseDetails;
	public int fromYear;
	public String institutionName;
	public int toYear;
	public long familyMemberId;
	public long stateId;
	public String hospitalName;
	public boolean underTreatment;
	public String cityOfHospital;
	public long levelId;
	public long diseaseTypeId;

}