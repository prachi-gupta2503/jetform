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

import com.adjecti.pis.liferay.model.ServiceRequestWorkflow;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequestWorkflow in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestWorkflowCacheModel
	implements CacheModel<ServiceRequestWorkflow>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestWorkflowCacheModel)) {
			return false;
		}

		ServiceRequestWorkflowCacheModel serviceRequestWorkflowCacheModel =
			(ServiceRequestWorkflowCacheModel)object;

		if (serviceRequestWorkflowId ==
				serviceRequestWorkflowCacheModel.serviceRequestWorkflowId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceRequestWorkflowId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{serviceRequestWorkflowId=");
		sb.append(serviceRequestWorkflowId);
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
		sb.append(", serviceRequestId=");
		sb.append(serviceRequestId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", remark=");
		sb.append(remark);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestWorkflow toEntityModel() {
		ServiceRequestWorkflowImpl serviceRequestWorkflowImpl =
			new ServiceRequestWorkflowImpl();

		serviceRequestWorkflowImpl.setServiceRequestWorkflowId(
			serviceRequestWorkflowId);
		serviceRequestWorkflowImpl.setGroupId(groupId);
		serviceRequestWorkflowImpl.setCompanyId(companyId);
		serviceRequestWorkflowImpl.setUserId(userId);

		if (userName == null) {
			serviceRequestWorkflowImpl.setUserName("");
		}
		else {
			serviceRequestWorkflowImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serviceRequestWorkflowImpl.setCreateDate(null);
		}
		else {
			serviceRequestWorkflowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceRequestWorkflowImpl.setModifiedDate(null);
		}
		else {
			serviceRequestWorkflowImpl.setModifiedDate(new Date(modifiedDate));
		}

		serviceRequestWorkflowImpl.setServiceRequestId(serviceRequestId);
		serviceRequestWorkflowImpl.setEmployeeId(employeeId);

		if (className == null) {
			serviceRequestWorkflowImpl.setClassName("");
		}
		else {
			serviceRequestWorkflowImpl.setClassName(className);
		}

		serviceRequestWorkflowImpl.setClassPK(classPK);

		if (remark == null) {
			serviceRequestWorkflowImpl.setRemark("");
		}
		else {
			serviceRequestWorkflowImpl.setRemark(remark);
		}

		serviceRequestWorkflowImpl.setStatus(status);

		serviceRequestWorkflowImpl.resetOriginalValues();

		return serviceRequestWorkflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceRequestWorkflowId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		serviceRequestId = objectInput.readLong();

		employeeId = objectInput.readLong();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
		remark = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(serviceRequestWorkflowId);

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

		objectOutput.writeLong(serviceRequestId);

		objectOutput.writeLong(employeeId);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (remark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remark);
		}

		objectOutput.writeInt(status);
	}

	public long serviceRequestWorkflowId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long serviceRequestId;
	public long employeeId;
	public String className;
	public long classPK;
	public String remark;
	public int status;

}