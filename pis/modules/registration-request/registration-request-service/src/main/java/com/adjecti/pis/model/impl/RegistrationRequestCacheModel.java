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

package com.adjecti.pis.model.impl;

import com.adjecti.pis.model.RegistrationRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RegistrationRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RegistrationRequestCacheModel
	implements CacheModel<RegistrationRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegistrationRequestCacheModel)) {
			return false;
		}

		RegistrationRequestCacheModel registrationRequestCacheModel =
			(RegistrationRequestCacheModel)object;

		if (registrationRequestId ==
				registrationRequestCacheModel.registrationRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registrationRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(113);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", registrationRequestId=");
		sb.append(registrationRequestId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", recordNo=");
		sb.append(recordNo);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", genderId=");
		sb.append(genderId);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", designationCode=");
		sb.append(designationCode);
		sb.append(", tradeId=");
		sb.append(tradeId);
		sb.append(", trade=");
		sb.append(trade);
		sb.append(", tradeCode=");
		sb.append(tradeCode);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", grade=");
		sb.append(grade);
		sb.append(", gradeCode=");
		sb.append(gradeCode);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", dateOfJoiningOrganization=");
		sb.append(dateOfJoiningOrganization);
		sb.append(", casteCategoryId=");
		sb.append(casteCategoryId);
		sb.append(", casteCategory=");
		sb.append(casteCategory);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", dateOfJoiningUnit=");
		sb.append(dateOfJoiningUnit);
		sb.append(", gpfnpsType=");
		sb.append(gpfnpsType);
		sb.append(", gpfnpsNumber=");
		sb.append(gpfnpsNumber);
		sb.append(", sectionId=");
		sb.append(sectionId);
		sb.append(", section=");
		sb.append(section);
		sb.append(", sectionCode=");
		sb.append(sectionCode);
		sb.append(", loginId=");
		sb.append(loginId);
		sb.append(", idamUser=");
		sb.append(idamUser);
		sb.append(", emailAccess=");
		sb.append(emailAccess);
		sb.append(", digitalSigning=");
		sb.append(digitalSigning);
		sb.append(", eGovAccess=");
		sb.append(eGovAccess);
		sb.append(", pisAccess=");
		sb.append(pisAccess);
		sb.append(", state=");
		sb.append(state);
		sb.append(", idamUserCreated=");
		sb.append(idamUserCreated);
		sb.append(", employeeCreated=");
		sb.append(employeeCreated);
		sb.append(", appUserCreated=");
		sb.append(appUserCreated);
		sb.append(", postBox=");
		sb.append(postBox);
		sb.append(", rank=");
		sb.append(rank);
		sb.append(", errorMessage=");
		sb.append(errorMessage);
		sb.append(", bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegistrationRequest toEntityModel() {
		RegistrationRequestImpl registrationRequestImpl =
			new RegistrationRequestImpl();

		if (uuid == null) {
			registrationRequestImpl.setUuid("");
		}
		else {
			registrationRequestImpl.setUuid(uuid);
		}

		registrationRequestImpl.setRegistrationRequestId(registrationRequestId);
		registrationRequestImpl.setGroupId(groupId);
		registrationRequestImpl.setCompanyId(companyId);
		registrationRequestImpl.setUserId(userId);

		if (userName == null) {
			registrationRequestImpl.setUserName("");
		}
		else {
			registrationRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			registrationRequestImpl.setCreateDate(null);
		}
		else {
			registrationRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registrationRequestImpl.setModifiedDate(null);
		}
		else {
			registrationRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		registrationRequestImpl.setStatus(status);
		registrationRequestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			registrationRequestImpl.setStatusByUserName("");
		}
		else {
			registrationRequestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			registrationRequestImpl.setStatusDate(null);
		}
		else {
			registrationRequestImpl.setStatusDate(new Date(statusDate));
		}

		registrationRequestImpl.setRecordNo(recordNo);
		registrationRequestImpl.setUnitId(unitId);

		if (unit == null) {
			registrationRequestImpl.setUnit("");
		}
		else {
			registrationRequestImpl.setUnit(unit);
		}

		registrationRequestImpl.setPersonalNo(personalNo);

		if (firstName == null) {
			registrationRequestImpl.setFirstName("");
		}
		else {
			registrationRequestImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			registrationRequestImpl.setMiddleName("");
		}
		else {
			registrationRequestImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			registrationRequestImpl.setLastName("");
		}
		else {
			registrationRequestImpl.setLastName(lastName);
		}

		registrationRequestImpl.setGenderId(genderId);

		if (gender == null) {
			registrationRequestImpl.setGender("");
		}
		else {
			registrationRequestImpl.setGender(gender);
		}

		registrationRequestImpl.setDesignationId(designationId);

		if (designation == null) {
			registrationRequestImpl.setDesignation("");
		}
		else {
			registrationRequestImpl.setDesignation(designation);
		}

		if (designationCode == null) {
			registrationRequestImpl.setDesignationCode("");
		}
		else {
			registrationRequestImpl.setDesignationCode(designationCode);
		}

		registrationRequestImpl.setTradeId(tradeId);

		if (trade == null) {
			registrationRequestImpl.setTrade("");
		}
		else {
			registrationRequestImpl.setTrade(trade);
		}

		if (tradeCode == null) {
			registrationRequestImpl.setTradeCode("");
		}
		else {
			registrationRequestImpl.setTradeCode(tradeCode);
		}

		registrationRequestImpl.setGradeId(gradeId);

		if (grade == null) {
			registrationRequestImpl.setGrade("");
		}
		else {
			registrationRequestImpl.setGrade(grade);
		}

		if (gradeCode == null) {
			registrationRequestImpl.setGradeCode("");
		}
		else {
			registrationRequestImpl.setGradeCode(gradeCode);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			registrationRequestImpl.setDateOfBirth(null);
		}
		else {
			registrationRequestImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (dateOfJoiningOrganization == Long.MIN_VALUE) {
			registrationRequestImpl.setDateOfJoiningOrganization(null);
		}
		else {
			registrationRequestImpl.setDateOfJoiningOrganization(
				new Date(dateOfJoiningOrganization));
		}

		registrationRequestImpl.setCasteCategoryId(casteCategoryId);

		if (casteCategory == null) {
			registrationRequestImpl.setCasteCategory("");
		}
		else {
			registrationRequestImpl.setCasteCategory(casteCategory);
		}

		registrationRequestImpl.setMobile(mobile);

		if (emailAddress == null) {
			registrationRequestImpl.setEmailAddress("");
		}
		else {
			registrationRequestImpl.setEmailAddress(emailAddress);
		}

		if (dateOfJoiningUnit == Long.MIN_VALUE) {
			registrationRequestImpl.setDateOfJoiningUnit(null);
		}
		else {
			registrationRequestImpl.setDateOfJoiningUnit(
				new Date(dateOfJoiningUnit));
		}

		if (gpfnpsType == null) {
			registrationRequestImpl.setGpfnpsType("");
		}
		else {
			registrationRequestImpl.setGpfnpsType(gpfnpsType);
		}

		registrationRequestImpl.setGpfnpsNumber(gpfnpsNumber);
		registrationRequestImpl.setSectionId(sectionId);

		if (section == null) {
			registrationRequestImpl.setSection("");
		}
		else {
			registrationRequestImpl.setSection(section);
		}

		if (sectionCode == null) {
			registrationRequestImpl.setSectionCode("");
		}
		else {
			registrationRequestImpl.setSectionCode(sectionCode);
		}

		if (loginId == null) {
			registrationRequestImpl.setLoginId("");
		}
		else {
			registrationRequestImpl.setLoginId(loginId);
		}

		registrationRequestImpl.setIdamUser(idamUser);
		registrationRequestImpl.setEmailAccess(emailAccess);
		registrationRequestImpl.setDigitalSigning(digitalSigning);
		registrationRequestImpl.setEGovAccess(eGovAccess);
		registrationRequestImpl.setPisAccess(pisAccess);

		if (state == null) {
			registrationRequestImpl.setState("");
		}
		else {
			registrationRequestImpl.setState(state);
		}

		registrationRequestImpl.setIdamUserCreated(idamUserCreated);
		registrationRequestImpl.setEmployeeCreated(employeeCreated);
		registrationRequestImpl.setAppUserCreated(appUserCreated);

		if (postBox == null) {
			registrationRequestImpl.setPostBox("");
		}
		else {
			registrationRequestImpl.setPostBox(postBox);
		}

		registrationRequestImpl.setRank(rank);

		if (errorMessage == null) {
			registrationRequestImpl.setErrorMessage("");
		}
		else {
			registrationRequestImpl.setErrorMessage(errorMessage);
		}

		registrationRequestImpl.setBulkOnbordingFileId(bulkOnbordingFileId);

		registrationRequestImpl.resetOriginalValues();

		return registrationRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		registrationRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		recordNo = objectInput.readLong();

		unitId = objectInput.readLong();
		unit = objectInput.readUTF();

		personalNo = objectInput.readLong();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();

		genderId = objectInput.readLong();
		gender = objectInput.readUTF();

		designationId = objectInput.readLong();
		designation = objectInput.readUTF();
		designationCode = objectInput.readUTF();

		tradeId = objectInput.readLong();
		trade = objectInput.readUTF();
		tradeCode = objectInput.readUTF();

		gradeId = objectInput.readLong();
		grade = objectInput.readUTF();
		gradeCode = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		dateOfJoiningOrganization = objectInput.readLong();

		casteCategoryId = objectInput.readLong();
		casteCategory = objectInput.readUTF();

		mobile = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		dateOfJoiningUnit = objectInput.readLong();
		gpfnpsType = objectInput.readUTF();

		gpfnpsNumber = objectInput.readLong();

		sectionId = objectInput.readLong();
		section = objectInput.readUTF();
		sectionCode = objectInput.readUTF();
		loginId = objectInput.readUTF();

		idamUser = objectInput.readBoolean();

		emailAccess = objectInput.readBoolean();

		digitalSigning = objectInput.readBoolean();

		eGovAccess = objectInput.readBoolean();

		pisAccess = objectInput.readBoolean();
		state = objectInput.readUTF();

		idamUserCreated = objectInput.readBoolean();

		employeeCreated = objectInput.readBoolean();

		appUserCreated = objectInput.readBoolean();
		postBox = objectInput.readUTF();

		rank = objectInput.readLong();
		errorMessage = objectInput.readUTF();

		bulkOnbordingFileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(registrationRequestId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(recordNo);

		objectOutput.writeLong(unitId);

		if (unit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unit);
		}

		objectOutput.writeLong(personalNo);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeLong(genderId);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(designationId);

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		if (designationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designationCode);
		}

		objectOutput.writeLong(tradeId);

		if (trade == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trade);
		}

		if (tradeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeCode);
		}

		objectOutput.writeLong(gradeId);

		if (grade == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(grade);
		}

		if (gradeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gradeCode);
		}

		objectOutput.writeLong(dateOfBirth);
		objectOutput.writeLong(dateOfJoiningOrganization);

		objectOutput.writeLong(casteCategoryId);

		if (casteCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(casteCategory);
		}

		objectOutput.writeLong(mobile);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(dateOfJoiningUnit);

		if (gpfnpsType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gpfnpsType);
		}

		objectOutput.writeLong(gpfnpsNumber);

		objectOutput.writeLong(sectionId);

		if (section == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(section);
		}

		if (sectionCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sectionCode);
		}

		if (loginId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loginId);
		}

		objectOutput.writeBoolean(idamUser);

		objectOutput.writeBoolean(emailAccess);

		objectOutput.writeBoolean(digitalSigning);

		objectOutput.writeBoolean(eGovAccess);

		objectOutput.writeBoolean(pisAccess);

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeBoolean(idamUserCreated);

		objectOutput.writeBoolean(employeeCreated);

		objectOutput.writeBoolean(appUserCreated);

		if (postBox == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postBox);
		}

		objectOutput.writeLong(rank);

		if (errorMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errorMessage);
		}

		objectOutput.writeLong(bulkOnbordingFileId);
	}

	public String uuid;
	public long registrationRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long recordNo;
	public long unitId;
	public String unit;
	public long personalNo;
	public String firstName;
	public String middleName;
	public String lastName;
	public long genderId;
	public String gender;
	public long designationId;
	public String designation;
	public String designationCode;
	public long tradeId;
	public String trade;
	public String tradeCode;
	public long gradeId;
	public String grade;
	public String gradeCode;
	public long dateOfBirth;
	public long dateOfJoiningOrganization;
	public long casteCategoryId;
	public String casteCategory;
	public long mobile;
	public String emailAddress;
	public long dateOfJoiningUnit;
	public String gpfnpsType;
	public long gpfnpsNumber;
	public long sectionId;
	public String section;
	public String sectionCode;
	public String loginId;
	public boolean idamUser;
	public boolean emailAccess;
	public boolean digitalSigning;
	public boolean eGovAccess;
	public boolean pisAccess;
	public String state;
	public boolean idamUserCreated;
	public boolean employeeCreated;
	public boolean appUserCreated;
	public String postBox;
	public long rank;
	public String errorMessage;
	public long bulkOnbordingFileId;

}