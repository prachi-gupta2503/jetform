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

import com.adjecti.pis.liferay.model.FamilyMemberServiceDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FamilyMemberServiceDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FamilyMemberServiceDetailCacheModel
	implements CacheModel<FamilyMemberServiceDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FamilyMemberServiceDetailCacheModel)) {
			return false;
		}

		FamilyMemberServiceDetailCacheModel
			familyMemberServiceDetailCacheModel =
				(FamilyMemberServiceDetailCacheModel)object;

		if (familyMemberServiceDetailId ==
				familyMemberServiceDetailCacheModel.
					familyMemberServiceDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, familyMemberServiceDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{familyMemberServiceDetailId=");
		sb.append(familyMemberServiceDetailId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FamilyMemberServiceDetail toEntityModel() {
		FamilyMemberServiceDetailImpl familyMemberServiceDetailImpl =
			new FamilyMemberServiceDetailImpl();

		familyMemberServiceDetailImpl.setFamilyMemberServiceDetailId(
			familyMemberServiceDetailId);
		familyMemberServiceDetailImpl.setGroupId(groupId);
		familyMemberServiceDetailImpl.setCompanyId(companyId);
		familyMemberServiceDetailImpl.setUserId(userId);

		if (userName == null) {
			familyMemberServiceDetailImpl.setUserName("");
		}
		else {
			familyMemberServiceDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			familyMemberServiceDetailImpl.setCreateDate(null);
		}
		else {
			familyMemberServiceDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			familyMemberServiceDetailImpl.setModifiedDate(null);
		}
		else {
			familyMemberServiceDetailImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (boardUniversity == null) {
			familyMemberServiceDetailImpl.setBoardUniversity("");
		}
		else {
			familyMemberServiceDetailImpl.setBoardUniversity(boardUniversity);
		}

		familyMemberServiceDetailImpl.setFromYear(fromYear);
		familyMemberServiceDetailImpl.setToYear(toYear);

		if (description == null) {
			familyMemberServiceDetailImpl.setDescription("");
		}
		else {
			familyMemberServiceDetailImpl.setDescription(description);
		}

		if (endDate == Long.MIN_VALUE) {
			familyMemberServiceDetailImpl.setEndDate(null);
		}
		else {
			familyMemberServiceDetailImpl.setEndDate(new Date(endDate));
		}

		if (organization == null) {
			familyMemberServiceDetailImpl.setOrganization("");
		}
		else {
			familyMemberServiceDetailImpl.setOrganization(organization);
		}

		if (startDate == Long.MIN_VALUE) {
			familyMemberServiceDetailImpl.setStartDate(null);
		}
		else {
			familyMemberServiceDetailImpl.setStartDate(new Date(startDate));
		}

		familyMemberServiceDetailImpl.setFamilyMemberId(familyMemberId);
		familyMemberServiceDetailImpl.setLevelId(levelId);
		familyMemberServiceDetailImpl.setServiceTypeId(serviceTypeId);

		familyMemberServiceDetailImpl.resetOriginalValues();

		return familyMemberServiceDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		familyMemberServiceDetailId = objectInput.readLong();

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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(familyMemberServiceDetailId);

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
	}

	public long familyMemberServiceDetailId;
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

}