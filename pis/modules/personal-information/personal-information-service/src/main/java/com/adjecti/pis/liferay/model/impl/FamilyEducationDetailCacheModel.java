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

import com.adjecti.pis.liferay.model.FamilyEducationDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FamilyEducationDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FamilyEducationDetailCacheModel
	implements CacheModel<FamilyEducationDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FamilyEducationDetailCacheModel)) {
			return false;
		}

		FamilyEducationDetailCacheModel familyEducationDetailCacheModel =
			(FamilyEducationDetailCacheModel)object;

		if (familyEducationDetailId ==
				familyEducationDetailCacheModel.familyEducationDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, familyEducationDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{familyEducationDetailId=");
		sb.append(familyEducationDetailId);
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
		sb.append(", fromYear=");
		sb.append(fromYear);
		sb.append(", institutionName=");
		sb.append(institutionName);
		sb.append(", toYear=");
		sb.append(toYear);
		sb.append(", familyMemberId=");
		sb.append(familyMemberId);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FamilyEducationDetail toEntityModel() {
		FamilyEducationDetailImpl familyEducationDetailImpl =
			new FamilyEducationDetailImpl();

		familyEducationDetailImpl.setFamilyEducationDetailId(
			familyEducationDetailId);
		familyEducationDetailImpl.setGroupId(groupId);
		familyEducationDetailImpl.setCompanyId(companyId);
		familyEducationDetailImpl.setUserId(userId);

		if (userName == null) {
			familyEducationDetailImpl.setUserName("");
		}
		else {
			familyEducationDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			familyEducationDetailImpl.setCreateDate(null);
		}
		else {
			familyEducationDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			familyEducationDetailImpl.setModifiedDate(null);
		}
		else {
			familyEducationDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (boardUniversity == null) {
			familyEducationDetailImpl.setBoardUniversity("");
		}
		else {
			familyEducationDetailImpl.setBoardUniversity(boardUniversity);
		}

		if (cityOfStudy == null) {
			familyEducationDetailImpl.setCityOfStudy("");
		}
		else {
			familyEducationDetailImpl.setCityOfStudy(cityOfStudy);
		}

		familyEducationDetailImpl.setFromYear(fromYear);

		if (institutionName == null) {
			familyEducationDetailImpl.setInstitutionName("");
		}
		else {
			familyEducationDetailImpl.setInstitutionName(institutionName);
		}

		familyEducationDetailImpl.setToYear(toYear);
		familyEducationDetailImpl.setFamilyMemberId(familyMemberId);
		familyEducationDetailImpl.setLevelId(levelId);
		familyEducationDetailImpl.setStateId(stateId);

		familyEducationDetailImpl.resetOriginalValues();

		return familyEducationDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		familyEducationDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		boardUniversity = objectInput.readUTF();
		cityOfStudy = objectInput.readUTF();

		fromYear = objectInput.readInt();
		institutionName = objectInput.readUTF();

		toYear = objectInput.readInt();

		familyMemberId = objectInput.readLong();

		levelId = objectInput.readLong();

		stateId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(familyEducationDetailId);

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

		objectOutput.writeInt(fromYear);

		if (institutionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institutionName);
		}

		objectOutput.writeInt(toYear);

		objectOutput.writeLong(familyMemberId);

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(stateId);
	}

	public long familyEducationDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String boardUniversity;
	public String cityOfStudy;
	public int fromYear;
	public String institutionName;
	public int toYear;
	public long familyMemberId;
	public long levelId;
	public long stateId;

}