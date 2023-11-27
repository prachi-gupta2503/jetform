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

import com.adjecti.mdm.liferay.model.BenefitScheme;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BenefitScheme in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BenefitSchemeCacheModel
	implements CacheModel<BenefitScheme>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BenefitSchemeCacheModel)) {
			return false;
		}

		BenefitSchemeCacheModel benefitSchemeCacheModel =
			(BenefitSchemeCacheModel)object;

		if (benefitSchemeId == benefitSchemeCacheModel.benefitSchemeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, benefitSchemeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{benefitSchemeId=");
		sb.append(benefitSchemeId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append(", code=");
		sb.append(code);
		sb.append(", description=");
		sb.append(description);
		sb.append(", effectiveFrom=");
		sb.append(effectiveFrom);
		sb.append(", effectiveRate=");
		sb.append(effectiveRate);
		sb.append(", effectiveUpto=");
		sb.append(effectiveUpto);
		sb.append(", name=");
		sb.append(name);
		sb.append(", frequencyId=");
		sb.append(frequencyId);
		sb.append(", rateTypeId=");
		sb.append(rateTypeId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BenefitScheme toEntityModel() {
		BenefitSchemeImpl benefitSchemeImpl = new BenefitSchemeImpl();

		benefitSchemeImpl.setBenefitSchemeId(benefitSchemeId);
		benefitSchemeImpl.setGroupId(groupId);
		benefitSchemeImpl.setCompanyId(companyId);
		benefitSchemeImpl.setUserId(userId);

		if (userName == null) {
			benefitSchemeImpl.setUserName("");
		}
		else {
			benefitSchemeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			benefitSchemeImpl.setCreateDate(null);
		}
		else {
			benefitSchemeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			benefitSchemeImpl.setModifiedDate(null);
		}
		else {
			benefitSchemeImpl.setModifiedDate(new Date(modifiedDate));
		}

		benefitSchemeImpl.setActive(active);

		if (code == null) {
			benefitSchemeImpl.setCode("");
		}
		else {
			benefitSchemeImpl.setCode(code);
		}

		if (description == null) {
			benefitSchemeImpl.setDescription("");
		}
		else {
			benefitSchemeImpl.setDescription(description);
		}

		if (effectiveFrom == Long.MIN_VALUE) {
			benefitSchemeImpl.setEffectiveFrom(null);
		}
		else {
			benefitSchemeImpl.setEffectiveFrom(new Date(effectiveFrom));
		}

		benefitSchemeImpl.setEffectiveRate(effectiveRate);

		if (effectiveUpto == Long.MIN_VALUE) {
			benefitSchemeImpl.setEffectiveUpto(null);
		}
		else {
			benefitSchemeImpl.setEffectiveUpto(new Date(effectiveUpto));
		}

		if (name == null) {
			benefitSchemeImpl.setName("");
		}
		else {
			benefitSchemeImpl.setName(name);
		}

		benefitSchemeImpl.setFrequencyId(frequencyId);
		benefitSchemeImpl.setRateTypeId(rateTypeId);
		benefitSchemeImpl.setDeleted(deleted);
		benefitSchemeImpl.setStatus(status);

		benefitSchemeImpl.resetOriginalValues();

		return benefitSchemeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		benefitSchemeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		effectiveFrom = objectInput.readLong();

		effectiveRate = objectInput.readFloat();
		effectiveUpto = objectInput.readLong();
		name = objectInput.readUTF();

		frequencyId = objectInput.readInt();

		rateTypeId = objectInput.readInt();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(benefitSchemeId);

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

		objectOutput.writeBoolean(active);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(effectiveFrom);

		objectOutput.writeFloat(effectiveRate);
		objectOutput.writeLong(effectiveUpto);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(frequencyId);

		objectOutput.writeInt(rateTypeId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long benefitSchemeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String code;
	public String description;
	public long effectiveFrom;
	public float effectiveRate;
	public long effectiveUpto;
	public String name;
	public int frequencyId;
	public int rateTypeId;
	public boolean deleted;
	public int status;

}