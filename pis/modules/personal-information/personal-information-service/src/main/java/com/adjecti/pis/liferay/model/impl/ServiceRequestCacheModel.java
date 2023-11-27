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

import com.adjecti.pis.liferay.model.ServiceRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestCacheModel
	implements CacheModel<ServiceRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestCacheModel)) {
			return false;
		}

		ServiceRequestCacheModel serviceRequestCacheModel =
			(ServiceRequestCacheModel)object;

		if (serviceRequestId == serviceRequestCacheModel.serviceRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{serviceRequestId=");
		sb.append(serviceRequestId);
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
		sb.append(", serviceRequestTypeId=");
		sb.append(serviceRequestTypeId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", description=");
		sb.append(description);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", documentProofId=");
		sb.append(documentProofId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", state=");
		sb.append(state);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequest toEntityModel() {
		ServiceRequestImpl serviceRequestImpl = new ServiceRequestImpl();

		serviceRequestImpl.setServiceRequestId(serviceRequestId);
		serviceRequestImpl.setGroupId(groupId);
		serviceRequestImpl.setCompanyId(companyId);
		serviceRequestImpl.setUserId(userId);

		if (userName == null) {
			serviceRequestImpl.setUserName("");
		}
		else {
			serviceRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serviceRequestImpl.setCreateDate(null);
		}
		else {
			serviceRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceRequestImpl.setModifiedDate(null);
		}
		else {
			serviceRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		serviceRequestImpl.setActive(active);
		serviceRequestImpl.setServiceRequestTypeId(serviceRequestTypeId);

		if (subject == null) {
			serviceRequestImpl.setSubject("");
		}
		else {
			serviceRequestImpl.setSubject(subject);
		}

		if (description == null) {
			serviceRequestImpl.setDescription("");
		}
		else {
			serviceRequestImpl.setDescription(description);
		}

		serviceRequestImpl.setEmployeeId(employeeId);
		serviceRequestImpl.setDocumentProofId(documentProofId);
		serviceRequestImpl.setOrganizationId(organizationId);
		serviceRequestImpl.setJoiningProcessId(joiningProcessId);
		serviceRequestImpl.setStatus(status);
		serviceRequestImpl.setDeleted(deleted);
		serviceRequestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			serviceRequestImpl.setStatusByUserName("");
		}
		else {
			serviceRequestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			serviceRequestImpl.setStatusDate(null);
		}
		else {
			serviceRequestImpl.setStatusDate(new Date(statusDate));
		}

		if (state == null) {
			serviceRequestImpl.setState("");
		}
		else {
			serviceRequestImpl.setState(state);
		}

		if (comments == null) {
			serviceRequestImpl.setComments("");
		}
		else {
			serviceRequestImpl.setComments(comments);
		}

		serviceRequestImpl.resetOriginalValues();

		return serviceRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();

		serviceRequestTypeId = objectInput.readLong();
		subject = objectInput.readUTF();
		description = objectInput.readUTF();

		employeeId = objectInput.readLong();

		documentProofId = objectInput.readLong();

		organizationId = objectInput.readLong();

		joiningProcessId = objectInput.readLong();

		status = objectInput.readInt();

		deleted = objectInput.readBoolean();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		state = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(serviceRequestId);

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

		objectOutput.writeLong(serviceRequestTypeId);

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(documentProofId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeInt(status);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long serviceRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long serviceRequestTypeId;
	public String subject;
	public String description;
	public long employeeId;
	public long documentProofId;
	public long organizationId;
	public long joiningProcessId;
	public int status;
	public boolean deleted;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String state;
	public String comments;

}