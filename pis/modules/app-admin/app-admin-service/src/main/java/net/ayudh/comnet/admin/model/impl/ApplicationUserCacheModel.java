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

package net.ayudh.comnet.admin.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import net.ayudh.comnet.admin.model.ApplicationUser;

/**
 * The cache model class for representing ApplicationUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ApplicationUserCacheModel
	implements CacheModel<ApplicationUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ApplicationUserCacheModel)) {
			return false;
		}

		ApplicationUserCacheModel applicationUserCacheModel =
			(ApplicationUserCacheModel)object;

		if (applicationUserId == applicationUserCacheModel.applicationUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{applicationUserId=");
		sb.append(applicationUserId);
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
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", loginId=");
		sb.append(loginId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", deleted=");
		sb.append(deleted);
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
		sb.append(", lastIdamUser=");
		sb.append(lastIdamUser);
		sb.append(", lastEmailAccess=");
		sb.append(lastEmailAccess);
		sb.append(", lastDigitalSigning=");
		sb.append(lastDigitalSigning);
		sb.append(", lastEGovAccess=");
		sb.append(lastEGovAccess);
		sb.append(", lastPisAccess=");
		sb.append(lastPisAccess);
		sb.append(", idamServiceStatus=");
		sb.append(idamServiceStatus);
		sb.append(", idamServiceMessage=");
		sb.append(idamServiceMessage);
		sb.append(", idamUserCreated=");
		sb.append(idamUserCreated);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationUser toEntityModel() {
		ApplicationUserImpl applicationUserImpl = new ApplicationUserImpl();

		applicationUserImpl.setApplicationUserId(applicationUserId);
		applicationUserImpl.setGroupId(groupId);
		applicationUserImpl.setCompanyId(companyId);
		applicationUserImpl.setUserId(userId);

		if (userName == null) {
			applicationUserImpl.setUserName("");
		}
		else {
			applicationUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationUserImpl.setCreateDate(null);
		}
		else {
			applicationUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationUserImpl.setModifiedDate(null);
		}
		else {
			applicationUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		applicationUserImpl.setEmployeeId(employeeId);

		if (loginId == null) {
			applicationUserImpl.setLoginId("");
		}
		else {
			applicationUserImpl.setLoginId(loginId);
		}

		applicationUserImpl.setStatus(status);
		applicationUserImpl.setDeleted(deleted);
		applicationUserImpl.setIdamUser(idamUser);
		applicationUserImpl.setEmailAccess(emailAccess);
		applicationUserImpl.setDigitalSigning(digitalSigning);
		applicationUserImpl.setEGovAccess(eGovAccess);
		applicationUserImpl.setPisAccess(pisAccess);
		applicationUserImpl.setLastIdamUser(lastIdamUser);
		applicationUserImpl.setLastEmailAccess(lastEmailAccess);
		applicationUserImpl.setLastDigitalSigning(lastDigitalSigning);
		applicationUserImpl.setLastEGovAccess(lastEGovAccess);
		applicationUserImpl.setLastPisAccess(lastPisAccess);
		applicationUserImpl.setIdamServiceStatus(idamServiceStatus);

		if (idamServiceMessage == null) {
			applicationUserImpl.setIdamServiceMessage("");
		}
		else {
			applicationUserImpl.setIdamServiceMessage(idamServiceMessage);
		}

		applicationUserImpl.setIdamUserCreated(idamUserCreated);

		applicationUserImpl.resetOriginalValues();

		return applicationUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		loginId = objectInput.readUTF();

		status = objectInput.readInt();

		deleted = objectInput.readBoolean();

		idamUser = objectInput.readBoolean();

		emailAccess = objectInput.readBoolean();

		digitalSigning = objectInput.readBoolean();

		eGovAccess = objectInput.readBoolean();

		pisAccess = objectInput.readBoolean();

		lastIdamUser = objectInput.readBoolean();

		lastEmailAccess = objectInput.readBoolean();

		lastDigitalSigning = objectInput.readBoolean();

		lastEGovAccess = objectInput.readBoolean();

		lastPisAccess = objectInput.readBoolean();

		idamServiceStatus = objectInput.readBoolean();
		idamServiceMessage = objectInput.readUTF();

		idamUserCreated = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(applicationUserId);

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

		objectOutput.writeLong(employeeId);

		if (loginId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loginId);
		}

		objectOutput.writeInt(status);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeBoolean(idamUser);

		objectOutput.writeBoolean(emailAccess);

		objectOutput.writeBoolean(digitalSigning);

		objectOutput.writeBoolean(eGovAccess);

		objectOutput.writeBoolean(pisAccess);

		objectOutput.writeBoolean(lastIdamUser);

		objectOutput.writeBoolean(lastEmailAccess);

		objectOutput.writeBoolean(lastDigitalSigning);

		objectOutput.writeBoolean(lastEGovAccess);

		objectOutput.writeBoolean(lastPisAccess);

		objectOutput.writeBoolean(idamServiceStatus);

		if (idamServiceMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idamServiceMessage);
		}

		objectOutput.writeBoolean(idamUserCreated);
	}

	public long applicationUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String loginId;
	public int status;
	public boolean deleted;
	public boolean idamUser;
	public boolean emailAccess;
	public boolean digitalSigning;
	public boolean eGovAccess;
	public boolean pisAccess;
	public boolean lastIdamUser;
	public boolean lastEmailAccess;
	public boolean lastDigitalSigning;
	public boolean lastEGovAccess;
	public boolean lastPisAccess;
	public boolean idamServiceStatus;
	public String idamServiceMessage;
	public boolean idamUserCreated;

}