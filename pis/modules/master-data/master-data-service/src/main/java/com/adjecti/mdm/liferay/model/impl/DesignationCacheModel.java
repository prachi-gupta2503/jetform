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

import com.adjecti.mdm.liferay.model.Designation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Designation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DesignationCacheModel
	implements CacheModel<Designation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DesignationCacheModel)) {
			return false;
		}

		DesignationCacheModel designationCacheModel =
			(DesignationCacheModel)object;

		if (designationId == designationCacheModel.designationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, designationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{designationId=");
		sb.append(designationId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", name_En=");
		sb.append(name_En);
		sb.append(", name_Hi=");
		sb.append(name_Hi);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", longName=");
		sb.append(longName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", designationClassId=");
		sb.append(designationClassId);
		sb.append(", designationGroupId=");
		sb.append(designationGroupId);
		sb.append(", designationGroup=");
		sb.append(designationGroup);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", organizationType=");
		sb.append(organizationType);
		sb.append(", sequenceNo=");
		sb.append(sequenceNo);
		sb.append(", rank=");
		sb.append(rank);
		sb.append(", scopeType=");
		sb.append(scopeType);
		sb.append(", scopeOrganizationId=");
		sb.append(scopeOrganizationId);
		sb.append(", scopeOrganizationTypeId=");
		sb.append(scopeOrganizationTypeId);
		sb.append(", scopePostId=");
		sb.append(scopePostId);
		sb.append(", designationModeId=");
		sb.append(designationModeId);
		sb.append(", successorGradeId=");
		sb.append(successorGradeId);
		sb.append(", scopeOrganizationName=");
		sb.append(scopeOrganizationName);
		sb.append(", scopePostName=");
		sb.append(scopePostName);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Designation toEntityModel() {
		DesignationImpl designationImpl = new DesignationImpl();

		designationImpl.setDesignationId(designationId);
		designationImpl.setGroupId(groupId);
		designationImpl.setCompanyId(companyId);
		designationImpl.setUserId(userId);

		if (userName == null) {
			designationImpl.setUserName("");
		}
		else {
			designationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			designationImpl.setCreateDate(null);
		}
		else {
			designationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designationImpl.setModifiedDate(null);
		}
		else {
			designationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			designationImpl.setCode("");
		}
		else {
			designationImpl.setCode(code);
		}

		if (name_En == null) {
			designationImpl.setName_En("");
		}
		else {
			designationImpl.setName_En(name_En);
		}

		if (name_Hi == null) {
			designationImpl.setName_Hi("");
		}
		else {
			designationImpl.setName_Hi(name_Hi);
		}

		if (shortName == null) {
			designationImpl.setShortName("");
		}
		else {
			designationImpl.setShortName(shortName);
		}

		if (longName == null) {
			designationImpl.setLongName("");
		}
		else {
			designationImpl.setLongName(longName);
		}

		if (description == null) {
			designationImpl.setDescription("");
		}
		else {
			designationImpl.setDescription(description);
		}

		designationImpl.setDesignationClassId(designationClassId);
		designationImpl.setDesignationGroupId(designationGroupId);

		if (designationGroup == null) {
			designationImpl.setDesignationGroup("");
		}
		else {
			designationImpl.setDesignationGroup(designationGroup);
		}

		designationImpl.setGradeId(gradeId);

		if (organizationType == null) {
			designationImpl.setOrganizationType("");
		}
		else {
			designationImpl.setOrganizationType(organizationType);
		}

		if (sequenceNo == null) {
			designationImpl.setSequenceNo("");
		}
		else {
			designationImpl.setSequenceNo(sequenceNo);
		}

		designationImpl.setRank(rank);
		designationImpl.setScopeType(scopeType);
		designationImpl.setScopeOrganizationId(scopeOrganizationId);
		designationImpl.setScopeOrganizationTypeId(scopeOrganizationTypeId);
		designationImpl.setScopePostId(scopePostId);
		designationImpl.setDesignationModeId(designationModeId);
		designationImpl.setSuccessorGradeId(successorGradeId);

		if (scopeOrganizationName == null) {
			designationImpl.setScopeOrganizationName("");
		}
		else {
			designationImpl.setScopeOrganizationName(scopeOrganizationName);
		}

		if (scopePostName == null) {
			designationImpl.setScopePostName("");
		}
		else {
			designationImpl.setScopePostName(scopePostName);
		}

		designationImpl.setDeleted(deleted);
		designationImpl.setStatus(status);

		designationImpl.resetOriginalValues();

		return designationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name_En = objectInput.readUTF();
		name_Hi = objectInput.readUTF();
		shortName = objectInput.readUTF();
		longName = objectInput.readUTF();
		description = objectInput.readUTF();

		designationClassId = objectInput.readLong();

		designationGroupId = objectInput.readLong();
		designationGroup = objectInput.readUTF();

		gradeId = objectInput.readLong();
		organizationType = objectInput.readUTF();
		sequenceNo = objectInput.readUTF();

		rank = objectInput.readInt();

		scopeType = objectInput.readInt();

		scopeOrganizationId = objectInput.readLong();

		scopeOrganizationTypeId = objectInput.readLong();

		scopePostId = objectInput.readLong();

		designationModeId = objectInput.readLong();

		successorGradeId = objectInput.readLong();
		scopeOrganizationName = objectInput.readUTF();
		scopePostName = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(designationId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name_En == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name_En);
		}

		if (name_Hi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name_Hi);
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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(designationClassId);

		objectOutput.writeLong(designationGroupId);

		if (designationGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designationGroup);
		}

		objectOutput.writeLong(gradeId);

		if (organizationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationType);
		}

		if (sequenceNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sequenceNo);
		}

		objectOutput.writeInt(rank);

		objectOutput.writeInt(scopeType);

		objectOutput.writeLong(scopeOrganizationId);

		objectOutput.writeLong(scopeOrganizationTypeId);

		objectOutput.writeLong(scopePostId);

		objectOutput.writeLong(designationModeId);

		objectOutput.writeLong(successorGradeId);

		if (scopeOrganizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scopeOrganizationName);
		}

		if (scopePostName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scopePostName);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long designationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name_En;
	public String name_Hi;
	public String shortName;
	public String longName;
	public String description;
	public long designationClassId;
	public long designationGroupId;
	public String designationGroup;
	public long gradeId;
	public String organizationType;
	public String sequenceNo;
	public int rank;
	public int scopeType;
	public long scopeOrganizationId;
	public long scopeOrganizationTypeId;
	public long scopePostId;
	public long designationModeId;
	public long successorGradeId;
	public String scopeOrganizationName;
	public String scopePostName;
	public boolean deleted;
	public int status;

}