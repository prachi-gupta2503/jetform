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

import com.adjecti.pis.liferay.model.EmployeeQualification;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeQualification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeQualificationCacheModel
	implements CacheModel<EmployeeQualification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeQualificationCacheModel)) {
			return false;
		}

		EmployeeQualificationCacheModel employeeQualificationCacheModel =
			(EmployeeQualificationCacheModel)object;

		if (employeeQualificationId ==
				employeeQualificationCacheModel.employeeQualificationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeQualificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{employeeQualificationId=");
		sb.append(employeeQualificationId);
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
		sb.append(", foreignDegree=");
		sb.append(foreignDegree);
		sb.append(", foreignInstitution=");
		sb.append(foreignInstitution);
		sb.append(", fromYear=");
		sb.append(fromYear);
		sb.append(", marksSecured=");
		sb.append(marksSecured);
		sb.append(", toYear=");
		sb.append(toYear);
		sb.append(", documentProofId=");
		sb.append(documentProofId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", qualificationId=");
		sb.append(qualificationId);
		sb.append(", specializationId=");
		sb.append(specializationId);
		sb.append(", marksPercentage=");
		sb.append(marksPercentage);
		sb.append(", passedDate=");
		sb.append(passedDate);
		sb.append(", certificateId=");
		sb.append(certificateId);
		sb.append(", qualificationDate=");
		sb.append(qualificationDate);
		sb.append(", institution=");
		sb.append(institution);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeQualification toEntityModel() {
		EmployeeQualificationImpl employeeQualificationImpl =
			new EmployeeQualificationImpl();

		employeeQualificationImpl.setEmployeeQualificationId(
			employeeQualificationId);
		employeeQualificationImpl.setGroupId(groupId);
		employeeQualificationImpl.setCompanyId(companyId);
		employeeQualificationImpl.setUserId(userId);

		if (userName == null) {
			employeeQualificationImpl.setUserName("");
		}
		else {
			employeeQualificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeQualificationImpl.setCreateDate(null);
		}
		else {
			employeeQualificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeQualificationImpl.setModifiedDate(null);
		}
		else {
			employeeQualificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeQualificationImpl.setForeignDegree(foreignDegree);

		if (foreignInstitution == null) {
			employeeQualificationImpl.setForeignInstitution("");
		}
		else {
			employeeQualificationImpl.setForeignInstitution(foreignInstitution);
		}

		employeeQualificationImpl.setFromYear(fromYear);
		employeeQualificationImpl.setMarksSecured(marksSecured);
		employeeQualificationImpl.setToYear(toYear);
		employeeQualificationImpl.setDocumentProofId(documentProofId);
		employeeQualificationImpl.setEmployeeId(employeeId);
		employeeQualificationImpl.setGradeId(gradeId);
		employeeQualificationImpl.setLevelId(levelId);
		employeeQualificationImpl.setQualificationId(qualificationId);
		employeeQualificationImpl.setSpecializationId(specializationId);
		employeeQualificationImpl.setMarksPercentage(marksPercentage);

		if (passedDate == Long.MIN_VALUE) {
			employeeQualificationImpl.setPassedDate(null);
		}
		else {
			employeeQualificationImpl.setPassedDate(new Date(passedDate));
		}

		employeeQualificationImpl.setCertificateId(certificateId);

		if (qualificationDate == Long.MIN_VALUE) {
			employeeQualificationImpl.setQualificationDate(null);
		}
		else {
			employeeQualificationImpl.setQualificationDate(
				new Date(qualificationDate));
		}

		if (institution == null) {
			employeeQualificationImpl.setInstitution("");
		}
		else {
			employeeQualificationImpl.setInstitution(institution);
		}

		employeeQualificationImpl.setJoiningProcessId(joiningProcessId);
		employeeQualificationImpl.setStatus(status);

		employeeQualificationImpl.resetOriginalValues();

		return employeeQualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeQualificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		foreignDegree = objectInput.readBoolean();
		foreignInstitution = objectInput.readUTF();

		fromYear = objectInput.readInt();

		marksSecured = objectInput.readFloat();

		toYear = objectInput.readInt();

		documentProofId = objectInput.readLong();

		employeeId = objectInput.readLong();

		gradeId = objectInput.readLong();

		levelId = objectInput.readLong();

		qualificationId = objectInput.readLong();

		specializationId = objectInput.readLong();

		marksPercentage = objectInput.readLong();
		passedDate = objectInput.readLong();

		certificateId = objectInput.readLong();
		qualificationDate = objectInput.readLong();
		institution = objectInput.readUTF();

		joiningProcessId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeQualificationId);

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

		objectOutput.writeBoolean(foreignDegree);

		if (foreignInstitution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foreignInstitution);
		}

		objectOutput.writeInt(fromYear);

		objectOutput.writeFloat(marksSecured);

		objectOutput.writeInt(toYear);

		objectOutput.writeLong(documentProofId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(qualificationId);

		objectOutput.writeLong(specializationId);

		objectOutput.writeLong(marksPercentage);
		objectOutput.writeLong(passedDate);

		objectOutput.writeLong(certificateId);
		objectOutput.writeLong(qualificationDate);

		if (institution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institution);
		}

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeInt(status);
	}

	public long employeeQualificationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean foreignDegree;
	public String foreignInstitution;
	public int fromYear;
	public float marksSecured;
	public int toYear;
	public long documentProofId;
	public long employeeId;
	public long gradeId;
	public long levelId;
	public long qualificationId;
	public long specializationId;
	public long marksPercentage;
	public long passedDate;
	public long certificateId;
	public long qualificationDate;
	public String institution;
	public long joiningProcessId;
	public int status;

}