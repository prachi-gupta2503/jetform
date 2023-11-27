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

import com.adjecti.pis.liferay.model.Contact;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactCacheModel)) {
			return false;
		}

		ContactCacheModel contactCacheModel = (ContactCacheModel)object;

		if (contactId == contactCacheModel.contactId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{contactId=");
		sb.append(contactId);
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
		sb.append(", altEmailAddress=");
		sb.append(altEmailAddress);
		sb.append(", emergencyMobile=");
		sb.append(emergencyMobile);
		sb.append(", facebookId=");
		sb.append(facebookId);
		sb.append(", instagramId=");
		sb.append(instagramId);
		sb.append(", linkedInId=");
		sb.append(linkedInId);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", twitterId=");
		sb.append(twitterId);
		sb.append(", landline=");
		sb.append(landline);
		sb.append(", emergencyNo=");
		sb.append(emergencyNo);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", telegram=");
		sb.append(telegram);
		sb.append(", telex=");
		sb.append(telex);
		sb.append(", personalEmail=");
		sb.append(personalEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contact toEntityModel() {
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setContactId(contactId);
		contactImpl.setGroupId(groupId);
		contactImpl.setCompanyId(companyId);
		contactImpl.setUserId(userId);

		if (userName == null) {
			contactImpl.setUserName("");
		}
		else {
			contactImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactImpl.setCreateDate(null);
		}
		else {
			contactImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactImpl.setModifiedDate(null);
		}
		else {
			contactImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (altEmailAddress == null) {
			contactImpl.setAltEmailAddress("");
		}
		else {
			contactImpl.setAltEmailAddress(altEmailAddress);
		}

		if (emergencyMobile == null) {
			contactImpl.setEmergencyMobile("");
		}
		else {
			contactImpl.setEmergencyMobile(emergencyMobile);
		}

		if (facebookId == null) {
			contactImpl.setFacebookId("");
		}
		else {
			contactImpl.setFacebookId(facebookId);
		}

		if (instagramId == null) {
			contactImpl.setInstagramId("");
		}
		else {
			contactImpl.setInstagramId(instagramId);
		}

		if (linkedInId == null) {
			contactImpl.setLinkedInId("");
		}
		else {
			contactImpl.setLinkedInId(linkedInId);
		}

		if (mobile == null) {
			contactImpl.setMobile("");
		}
		else {
			contactImpl.setMobile(mobile);
		}

		if (phone == null) {
			contactImpl.setPhone("");
		}
		else {
			contactImpl.setPhone(phone);
		}

		if (twitterId == null) {
			contactImpl.setTwitterId("");
		}
		else {
			contactImpl.setTwitterId(twitterId);
		}

		if (landline == null) {
			contactImpl.setLandline("");
		}
		else {
			contactImpl.setLandline(landline);
		}

		if (emergencyNo == null) {
			contactImpl.setEmergencyNo("");
		}
		else {
			contactImpl.setEmergencyNo(emergencyNo);
		}

		if (fax == null) {
			contactImpl.setFax("");
		}
		else {
			contactImpl.setFax(fax);
		}

		if (telegram == null) {
			contactImpl.setTelegram("");
		}
		else {
			contactImpl.setTelegram(telegram);
		}

		if (telex == null) {
			contactImpl.setTelex("");
		}
		else {
			contactImpl.setTelex(telex);
		}

		if (personalEmail == null) {
			contactImpl.setPersonalEmail("");
		}
		else {
			contactImpl.setPersonalEmail(personalEmail);
		}

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		altEmailAddress = objectInput.readUTF();
		emergencyMobile = objectInput.readUTF();
		facebookId = objectInput.readUTF();
		instagramId = objectInput.readUTF();
		linkedInId = objectInput.readUTF();
		mobile = objectInput.readUTF();
		phone = objectInput.readUTF();
		twitterId = objectInput.readUTF();
		landline = objectInput.readUTF();
		emergencyNo = objectInput.readUTF();
		fax = objectInput.readUTF();
		telegram = objectInput.readUTF();
		telex = objectInput.readUTF();
		personalEmail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(contactId);

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

		if (altEmailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(altEmailAddress);
		}

		if (emergencyMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emergencyMobile);
		}

		if (facebookId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facebookId);
		}

		if (instagramId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(instagramId);
		}

		if (linkedInId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkedInId);
		}

		if (mobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (twitterId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(twitterId);
		}

		if (landline == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(landline);
		}

		if (emergencyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emergencyNo);
		}

		if (fax == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fax);
		}

		if (telegram == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telegram);
		}

		if (telex == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telex);
		}

		if (personalEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalEmail);
		}
	}

	public long contactId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String altEmailAddress;
	public String emergencyMobile;
	public String facebookId;
	public String instagramId;
	public String linkedInId;
	public String mobile;
	public String phone;
	public String twitterId;
	public String landline;
	public String emergencyNo;
	public String fax;
	public String telegram;
	public String telex;
	public String personalEmail;

}