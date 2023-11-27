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

import com.adjecti.pis.liferay.model.ServiceRequestWfStatusType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequestWfStatusType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestWfStatusTypeCacheModel
	implements CacheModel<ServiceRequestWfStatusType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestWfStatusTypeCacheModel)) {
			return false;
		}

		ServiceRequestWfStatusTypeCacheModel
			serviceRequestWfStatusTypeCacheModel =
				(ServiceRequestWfStatusTypeCacheModel)object;

		if (serviceRequestWfStatusTypeId ==
				serviceRequestWfStatusTypeCacheModel.
					serviceRequestWfStatusTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceRequestWfStatusTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{serviceRequestWfStatusTypeId=");
		sb.append(serviceRequestWfStatusTypeId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", className=");
		sb.append(className);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestWfStatusType toEntityModel() {
		ServiceRequestWfStatusTypeImpl serviceRequestWfStatusTypeImpl =
			new ServiceRequestWfStatusTypeImpl();

		serviceRequestWfStatusTypeImpl.setServiceRequestWfStatusTypeId(
			serviceRequestWfStatusTypeId);
		serviceRequestWfStatusTypeImpl.setGroupId(groupId);
		serviceRequestWfStatusTypeImpl.setCompanyId(companyId);
		serviceRequestWfStatusTypeImpl.setUserId(userId);

		if (userName == null) {
			serviceRequestWfStatusTypeImpl.setUserName("");
		}
		else {
			serviceRequestWfStatusTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serviceRequestWfStatusTypeImpl.setCreateDate(null);
		}
		else {
			serviceRequestWfStatusTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceRequestWfStatusTypeImpl.setModifiedDate(null);
		}
		else {
			serviceRequestWfStatusTypeImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		serviceRequestWfStatusTypeImpl.setName(name);

		if (className == null) {
			serviceRequestWfStatusTypeImpl.setClassName("");
		}
		else {
			serviceRequestWfStatusTypeImpl.setClassName(className);
		}

		serviceRequestWfStatusTypeImpl.setDeleted(deleted);
		serviceRequestWfStatusTypeImpl.setStatus(status);

		serviceRequestWfStatusTypeImpl.resetOriginalValues();

		return serviceRequestWfStatusTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceRequestWfStatusTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		name = objectInput.readLong();
		className = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(serviceRequestWfStatusTypeId);

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

		objectOutput.writeLong(name);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long serviceRequestWfStatusTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long name;
	public String className;
	public boolean deleted;
	public int status;

}