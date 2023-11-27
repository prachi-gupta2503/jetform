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

import com.adjecti.pis.liferay.model.ServiceRequestType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequestType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestTypeCacheModel
	implements CacheModel<ServiceRequestType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestTypeCacheModel)) {
			return false;
		}

		ServiceRequestTypeCacheModel serviceRequestTypeCacheModel =
			(ServiceRequestTypeCacheModel)object;

		if (serviceRequestTypeId ==
				serviceRequestTypeCacheModel.serviceRequestTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceRequestTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{serviceRequestTypeId=");
		sb.append(serviceRequestTypeId);
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
		sb.append(", action=");
		sb.append(action);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestType toEntityModel() {
		ServiceRequestTypeImpl serviceRequestTypeImpl =
			new ServiceRequestTypeImpl();

		serviceRequestTypeImpl.setServiceRequestTypeId(serviceRequestTypeId);
		serviceRequestTypeImpl.setGroupId(groupId);
		serviceRequestTypeImpl.setCompanyId(companyId);
		serviceRequestTypeImpl.setUserId(userId);

		if (userName == null) {
			serviceRequestTypeImpl.setUserName("");
		}
		else {
			serviceRequestTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serviceRequestTypeImpl.setCreateDate(null);
		}
		else {
			serviceRequestTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceRequestTypeImpl.setModifiedDate(null);
		}
		else {
			serviceRequestTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			serviceRequestTypeImpl.setName("");
		}
		else {
			serviceRequestTypeImpl.setName(name);
		}

		if (className == null) {
			serviceRequestTypeImpl.setClassName("");
		}
		else {
			serviceRequestTypeImpl.setClassName(className);
		}

		if (action == null) {
			serviceRequestTypeImpl.setAction("");
		}
		else {
			serviceRequestTypeImpl.setAction(action);
		}

		serviceRequestTypeImpl.setDeleted(deleted);
		serviceRequestTypeImpl.setStatus(status);

		serviceRequestTypeImpl.resetOriginalValues();

		return serviceRequestTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceRequestTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		className = objectInput.readUTF();
		action = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(serviceRequestTypeId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long serviceRequestTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String className;
	public String action;
	public boolean deleted;
	public int status;

}