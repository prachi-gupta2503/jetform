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

import com.adjecti.pis.liferay.model.FamilyServiceDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FamilyServiceDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FamilyServiceDetailCacheModel
	implements CacheModel<FamilyServiceDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FamilyServiceDetailCacheModel)) {
			return false;
		}

		FamilyServiceDetailCacheModel familyServiceDetailCacheModel =
			(FamilyServiceDetailCacheModel)object;

		if (familyServiceDetailId ==
				familyServiceDetailCacheModel.familyServiceDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, familyServiceDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{familyServiceDetailId=");
		sb.append(familyServiceDetailId);
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
		sb.append(", fromYear=");
		sb.append(fromYear);
		sb.append(", toYear=");
		sb.append(toYear);
		sb.append(", description=");
		sb.append(description);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", organization=");
		sb.append(organization);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", familyMemberId=");
		sb.append(familyMemberId);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", serviceTypeId=");
		sb.append(serviceTypeId);
		sb.append(", cityOfStudy=");
		sb.append(cityOfStudy);
		sb.append(", institutionName=");
		sb.append(institutionName);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", cityOfWork=");
		sb.append(cityOfWork);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", govtServant=");
		sb.append(govtServant);
		sb.append(", cityOfHospital=");
		sb.append(cityOfHospital);
		sb.append(", deseaseDetails=");
		sb.append(deseaseDetails);
		sb.append(", hospitalName=");
		sb.append(hospitalName);
		sb.append(", underTreatment=");
		sb.append(underTreatment);
		sb.append(", diseaseTypeId=");
		sb.append(diseaseTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FamilyServiceDetail toEntityModel() {
		FamilyServiceDetailImpl familyServiceDetailImpl =
			new FamilyServiceDetailImpl();

		familyServiceDetailImpl.setFamilyServiceDetailId(familyServiceDetailId);
		familyServiceDetailImpl.setGroupId(groupId);
		familyServiceDetailImpl.setCompanyId(companyId);
		familyServiceDetailImpl.setUserId(userId);

		if (userName == null) {
			familyServiceDetailImpl.setUserName("");
		}
		else {
			familyServiceDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			familyServiceDetailImpl.setCreateDate(null);
		}
		else {
			familyServiceDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			familyServiceDetailImpl.setModifiedDate(null);
		}
		else {
			familyServiceDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (boardUniversity == null) {
			familyServiceDetailImpl.setBoardUniversity("");
		}
		else {
			familyServiceDetailImpl.setBoardUniversity(boardUniversity);
		}

		familyServiceDetailImpl.setFromYear(fromYear);
		familyServiceDetailImpl.setToYear(toYear);

		if (description == null) {
			familyServiceDetailImpl.setDescription("");
		}
		else {
			familyServiceDetailImpl.setDescription(description);
		}

		if (endDate == Long.MIN_VALUE) {
			familyServiceDetailImpl.setEndDate(null);
		}
		else {
			familyServiceDetailImpl.setEndDate(new Date(endDate));
		}

		if (organization == null) {
			familyServiceDetailImpl.setOrganization("");
		}
		else {
			familyServiceDetailImpl.setOrganization(organization);
		}

		if (startDate == Long.MIN_VALUE) {
			familyServiceDetailImpl.setStartDate(null);
		}
		else {
			familyServiceDetailImpl.setStartDate(new Date(startDate));
		}

		familyServiceDetailImpl.setFamilyMemberId(familyMemberId);
		familyServiceDetailImpl.setLevelId(levelId);
		familyServiceDetailImpl.setServiceTypeId(serviceTypeId);

		if (cityOfStudy == null) {
			familyServiceDetailImpl.setCityOfStudy("");
		}
		else {
			familyServiceDetailImpl.setCityOfStudy(cityOfStudy);
		}

		if (institutionName == null) {
			familyServiceDetailImpl.setInstitutionName("");
		}
		else {
			familyServiceDetailImpl.setInstitutionName(institutionName);
		}

		familyServiceDetailImpl.setStateId(stateId);

		if (cityOfWork == null) {
			familyServiceDetailImpl.setCityOfWork("");
		}
		else {
			familyServiceDetailImpl.setCityOfWork(cityOfWork);
		}

		if (designation == null) {
			familyServiceDetailImpl.setDesignation("");
		}
		else {
			familyServiceDetailImpl.setDesignation(designation);
		}

		familyServiceDetailImpl.setGovtServant(govtServant);

		if (cityOfHospital == null) {
			familyServiceDetailImpl.setCityOfHospital("");
		}
		else {
			familyServiceDetailImpl.setCityOfHospital(cityOfHospital);
		}

		if (deseaseDetails == null) {
			familyServiceDetailImpl.setDeseaseDetails("");
		}
		else {
			familyServiceDetailImpl.setDeseaseDetails(deseaseDetails);
		}

		if (hospitalName == null) {
			familyServiceDetailImpl.setHospitalName("");
		}
		else {
			familyServiceDetailImpl.setHospitalName(hospitalName);
		}

		familyServiceDetailImpl.setUnderTreatment(underTreatment);
		familyServiceDetailImpl.setDiseaseTypeId(diseaseTypeId);

		familyServiceDetailImpl.resetOriginalValues();

		return familyServiceDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		familyServiceDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		boardUniversity = objectInput.readUTF();

		fromYear = objectInput.readInt();

		toYear = objectInput.readInt();
		description = objectInput.readUTF();
		endDate = objectInput.readLong();
		organization = objectInput.readUTF();
		startDate = objectInput.readLong();

		familyMemberId = objectInput.readLong();

		levelId = objectInput.readLong();

		serviceTypeId = objectInput.readLong();
		cityOfStudy = objectInput.readUTF();
		institutionName = objectInput.readUTF();

		stateId = objectInput.readLong();
		cityOfWork = objectInput.readUTF();
		designation = objectInput.readUTF();

		govtServant = objectInput.readBoolean();
		cityOfHospital = objectInput.readUTF();
		deseaseDetails = objectInput.readUTF();
		hospitalName = objectInput.readUTF();

		underTreatment = objectInput.readBoolean();

		diseaseTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(familyServiceDetailId);

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

		objectOutput.writeInt(fromYear);

		objectOutput.writeInt(toYear);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(endDate);

		if (organization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organization);
		}

		objectOutput.writeLong(startDate);

		objectOutput.writeLong(familyMemberId);

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(serviceTypeId);

		if (cityOfStudy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityOfStudy);
		}

		if (institutionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institutionName);
		}

		objectOutput.writeLong(stateId);

		if (cityOfWork == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityOfWork);
		}

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		objectOutput.writeBoolean(govtServant);

		if (cityOfHospital == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityOfHospital);
		}

		if (deseaseDetails == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deseaseDetails);
		}

		if (hospitalName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hospitalName);
		}

		objectOutput.writeBoolean(underTreatment);

		objectOutput.writeLong(diseaseTypeId);
	}

	public long familyServiceDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String boardUniversity;
	public int fromYear;
	public int toYear;
	public String description;
	public long endDate;
	public String organization;
	public long startDate;
	public long familyMemberId;
	public long levelId;
	public long serviceTypeId;
	public String cityOfStudy;
	public String institutionName;
	public long stateId;
	public String cityOfWork;
	public String designation;
	public boolean govtServant;
	public String cityOfHospital;
	public String deseaseDetails;
	public String hospitalName;
	public boolean underTreatment;
	public long diseaseTypeId;

}