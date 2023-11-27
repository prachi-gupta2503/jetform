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

import com.adjecti.pis.liferay.model.EmployeeFamily;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeFamily in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeFamilyCacheModel
	implements CacheModel<EmployeeFamily>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeFamilyCacheModel)) {
			return false;
		}

		EmployeeFamilyCacheModel employeeFamilyCacheModel =
			(EmployeeFamilyCacheModel)object;

		if (employeeFamilyId == employeeFamilyCacheModel.employeeFamilyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeFamilyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{employeeFamilyId=");
		sb.append(employeeFamilyId);
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
		sb.append(", alive=");
		sb.append(alive);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", dateOfDemise=");
		sb.append(dateOfDemise);
		sb.append(", dependant=");
		sb.append(dependant);
		sb.append(", name=");
		sb.append(name);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", genderId=");
		sb.append(genderId);
		sb.append(", occupationId=");
		sb.append(occupationId);
		sb.append(", relationId=");
		sb.append(relationId);
		sb.append(", cgegisPercentage=");
		sb.append(cgegisPercentage);
		sb.append(", dcrcPercentage=");
		sb.append(dcrcPercentage);
		sb.append(", healthProblem=");
		sb.append(healthProblem);
		sb.append(", nominee=");
		sb.append(nominee);
		sb.append(", pfPercentage=");
		sb.append(pfPercentage);
		sb.append(", documentProofId=");
		sb.append(documentProofId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeFamily toEntityModel() {
		EmployeeFamilyImpl employeeFamilyImpl = new EmployeeFamilyImpl();

		employeeFamilyImpl.setEmployeeFamilyId(employeeFamilyId);
		employeeFamilyImpl.setGroupId(groupId);
		employeeFamilyImpl.setCompanyId(companyId);
		employeeFamilyImpl.setUserId(userId);

		if (userName == null) {
			employeeFamilyImpl.setUserName("");
		}
		else {
			employeeFamilyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeFamilyImpl.setCreateDate(null);
		}
		else {
			employeeFamilyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeFamilyImpl.setModifiedDate(null);
		}
		else {
			employeeFamilyImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeFamilyImpl.setAlive(alive);

		if (dateOfBirth == Long.MIN_VALUE) {
			employeeFamilyImpl.setDateOfBirth(null);
		}
		else {
			employeeFamilyImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (dateOfDemise == Long.MIN_VALUE) {
			employeeFamilyImpl.setDateOfDemise(null);
		}
		else {
			employeeFamilyImpl.setDateOfDemise(new Date(dateOfDemise));
		}

		employeeFamilyImpl.setDependant(dependant);

		if (name == null) {
			employeeFamilyImpl.setName("");
		}
		else {
			employeeFamilyImpl.setName(name);
		}

		employeeFamilyImpl.setEmployeeId(employeeId);
		employeeFamilyImpl.setGenderId(genderId);
		employeeFamilyImpl.setOccupationId(occupationId);
		employeeFamilyImpl.setRelationId(relationId);
		employeeFamilyImpl.setCgegisPercentage(cgegisPercentage);
		employeeFamilyImpl.setDcrcPercentage(dcrcPercentage);

		if (healthProblem == null) {
			employeeFamilyImpl.setHealthProblem("");
		}
		else {
			employeeFamilyImpl.setHealthProblem(healthProblem);
		}

		employeeFamilyImpl.setNominee(nominee);
		employeeFamilyImpl.setPfPercentage(pfPercentage);
		employeeFamilyImpl.setDocumentProofId(documentProofId);
		employeeFamilyImpl.setStatus(status);

		employeeFamilyImpl.resetOriginalValues();

		return employeeFamilyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeFamilyId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		alive = objectInput.readBoolean();
		dateOfBirth = objectInput.readLong();
		dateOfDemise = objectInput.readLong();

		dependant = objectInput.readBoolean();
		name = objectInput.readUTF();

		employeeId = objectInput.readLong();

		genderId = objectInput.readLong();

		occupationId = objectInput.readLong();

		relationId = objectInput.readLong();

		cgegisPercentage = objectInput.readFloat();

		dcrcPercentage = objectInput.readFloat();
		healthProblem = objectInput.readUTF();

		nominee = objectInput.readBoolean();

		pfPercentage = objectInput.readFloat();

		documentProofId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeFamilyId);

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

		objectOutput.writeBoolean(alive);
		objectOutput.writeLong(dateOfBirth);
		objectOutput.writeLong(dateOfDemise);

		objectOutput.writeBoolean(dependant);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(genderId);

		objectOutput.writeLong(occupationId);

		objectOutput.writeLong(relationId);

		objectOutput.writeFloat(cgegisPercentage);

		objectOutput.writeFloat(dcrcPercentage);

		if (healthProblem == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(healthProblem);
		}

		objectOutput.writeBoolean(nominee);

		objectOutput.writeFloat(pfPercentage);

		objectOutput.writeLong(documentProofId);

		objectOutput.writeInt(status);
	}

	public long employeeFamilyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean alive;
	public long dateOfBirth;
	public long dateOfDemise;
	public boolean dependant;
	public String name;
	public long employeeId;
	public long genderId;
	public long occupationId;
	public long relationId;
	public float cgegisPercentage;
	public float dcrcPercentage;
	public String healthProblem;
	public boolean nominee;
	public float pfPercentage;
	public long documentProofId;
	public int status;

}