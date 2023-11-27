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

import com.adjecti.pis.liferay.model.FamilyBenefitScheme;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FamilyBenefitScheme in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FamilyBenefitSchemeCacheModel
	implements CacheModel<FamilyBenefitScheme>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FamilyBenefitSchemeCacheModel)) {
			return false;
		}

		FamilyBenefitSchemeCacheModel familyBenefitSchemeCacheModel =
			(FamilyBenefitSchemeCacheModel)object;

		if (familyBenefitSchemeId ==
				familyBenefitSchemeCacheModel.familyBenefitSchemeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, familyBenefitSchemeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{familyBenefitSchemeId=");
		sb.append(familyBenefitSchemeId);
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
		sb.append(", percentage=");
		sb.append(percentage);
		sb.append(", familyMemberId=");
		sb.append(familyMemberId);
		sb.append(", benefitSchemeId=");
		sb.append(benefitSchemeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FamilyBenefitScheme toEntityModel() {
		FamilyBenefitSchemeImpl familyBenefitSchemeImpl =
			new FamilyBenefitSchemeImpl();

		familyBenefitSchemeImpl.setFamilyBenefitSchemeId(familyBenefitSchemeId);
		familyBenefitSchemeImpl.setGroupId(groupId);
		familyBenefitSchemeImpl.setCompanyId(companyId);
		familyBenefitSchemeImpl.setUserId(userId);

		if (userName == null) {
			familyBenefitSchemeImpl.setUserName("");
		}
		else {
			familyBenefitSchemeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			familyBenefitSchemeImpl.setCreateDate(null);
		}
		else {
			familyBenefitSchemeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			familyBenefitSchemeImpl.setModifiedDate(null);
		}
		else {
			familyBenefitSchemeImpl.setModifiedDate(new Date(modifiedDate));
		}

		familyBenefitSchemeImpl.setPercentage(percentage);
		familyBenefitSchemeImpl.setFamilyMemberId(familyMemberId);
		familyBenefitSchemeImpl.setBenefitSchemeId(benefitSchemeId);

		familyBenefitSchemeImpl.resetOriginalValues();

		return familyBenefitSchemeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		familyBenefitSchemeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		percentage = objectInput.readFloat();

		familyMemberId = objectInput.readLong();

		benefitSchemeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(familyBenefitSchemeId);

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

		objectOutput.writeFloat(percentage);

		objectOutput.writeLong(familyMemberId);

		objectOutput.writeLong(benefitSchemeId);
	}

	public long familyBenefitSchemeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public float percentage;
	public long familyMemberId;
	public long benefitSchemeId;

}