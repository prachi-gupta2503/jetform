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

import net.ayudh.comnet.admin.model.ApplicationAccess;

/**
 * The cache model class for representing ApplicationAccess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ApplicationAccessCacheModel
	implements CacheModel<ApplicationAccess>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ApplicationAccessCacheModel)) {
			return false;
		}

		ApplicationAccessCacheModel applicationAccessCacheModel =
			(ApplicationAccessCacheModel)object;

		if (applicationAccessId ==
				applicationAccessCacheModel.applicationAccessId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationAccessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{applicationAccessId=");
		sb.append(applicationAccessId);
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
		sb.append(", applicationId=");
		sb.append(applicationId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationAccess toEntityModel() {
		ApplicationAccessImpl applicationAccessImpl =
			new ApplicationAccessImpl();

		applicationAccessImpl.setApplicationAccessId(applicationAccessId);
		applicationAccessImpl.setGroupId(groupId);
		applicationAccessImpl.setCompanyId(companyId);
		applicationAccessImpl.setUserId(userId);

		if (userName == null) {
			applicationAccessImpl.setUserName("");
		}
		else {
			applicationAccessImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationAccessImpl.setCreateDate(null);
		}
		else {
			applicationAccessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationAccessImpl.setModifiedDate(null);
		}
		else {
			applicationAccessImpl.setModifiedDate(new Date(modifiedDate));
		}

		applicationAccessImpl.setEmployeeId(employeeId);
		applicationAccessImpl.setApplicationId(applicationId);
		applicationAccessImpl.setStatus(status);
		applicationAccessImpl.setDeleted(deleted);

		applicationAccessImpl.resetOriginalValues();

		return applicationAccessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationAccessId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		applicationId = objectInput.readLong();

		status = objectInput.readInt();

		deleted = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(applicationAccessId);

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

		objectOutput.writeLong(applicationId);

		objectOutput.writeInt(status);

		objectOutput.writeBoolean(deleted);
	}

	public long applicationAccessId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long applicationId;
	public int status;
	public boolean deleted;

}