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

package net.ayudh.audit.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import net.ayudh.audit.model.AuditEventArchive;

/**
 * The cache model class for representing AuditEventArchive in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditEventArchiveCacheModel
	implements CacheModel<AuditEventArchive>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuditEventArchiveCacheModel)) {
			return false;
		}

		AuditEventArchiveCacheModel auditEventArchiveCacheModel =
			(AuditEventArchiveCacheModel)object;

		if (auditEventArchiveId ==
				auditEventArchiveCacheModel.auditEventArchiveId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditEventArchiveId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{auditEventArchiveId=");
		sb.append(auditEventArchiveId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", message=");
		sb.append(message);
		sb.append(", clientHost=");
		sb.append(clientHost);
		sb.append(", clientIP=");
		sb.append(clientIP);
		sb.append(", serverName=");
		sb.append(serverName);
		sb.append(", serverPort=");
		sb.append(serverPort);
		sb.append(", sessionId=");
		sb.append(sessionId);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuditEventArchive toEntityModel() {
		AuditEventArchiveImpl auditEventArchiveImpl =
			new AuditEventArchiveImpl();

		auditEventArchiveImpl.setAuditEventArchiveId(auditEventArchiveId);
		auditEventArchiveImpl.setCompanyId(companyId);
		auditEventArchiveImpl.setUserId(userId);

		if (userName == null) {
			auditEventArchiveImpl.setUserName("");
		}
		else {
			auditEventArchiveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			auditEventArchiveImpl.setCreateDate(null);
		}
		else {
			auditEventArchiveImpl.setCreateDate(new Date(createDate));
		}

		if (eventType == null) {
			auditEventArchiveImpl.setEventType("");
		}
		else {
			auditEventArchiveImpl.setEventType(eventType);
		}

		if (className == null) {
			auditEventArchiveImpl.setClassName("");
		}
		else {
			auditEventArchiveImpl.setClassName(className);
		}

		if (classPK == null) {
			auditEventArchiveImpl.setClassPK("");
		}
		else {
			auditEventArchiveImpl.setClassPK(classPK);
		}

		if (message == null) {
			auditEventArchiveImpl.setMessage("");
		}
		else {
			auditEventArchiveImpl.setMessage(message);
		}

		if (clientHost == null) {
			auditEventArchiveImpl.setClientHost("");
		}
		else {
			auditEventArchiveImpl.setClientHost(clientHost);
		}

		if (clientIP == null) {
			auditEventArchiveImpl.setClientIP("");
		}
		else {
			auditEventArchiveImpl.setClientIP(clientIP);
		}

		if (serverName == null) {
			auditEventArchiveImpl.setServerName("");
		}
		else {
			auditEventArchiveImpl.setServerName(serverName);
		}

		auditEventArchiveImpl.setServerPort(serverPort);

		if (sessionId == null) {
			auditEventArchiveImpl.setSessionId("");
		}
		else {
			auditEventArchiveImpl.setSessionId(sessionId);
		}

		if (additionalInfo == null) {
			auditEventArchiveImpl.setAdditionalInfo("");
		}
		else {
			auditEventArchiveImpl.setAdditionalInfo(additionalInfo);
		}

		auditEventArchiveImpl.resetOriginalValues();

		return auditEventArchiveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		auditEventArchiveId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		className = objectInput.readUTF();
		classPK = objectInput.readUTF();
		message = objectInput.readUTF();
		clientHost = objectInput.readUTF();
		clientIP = objectInput.readUTF();
		serverName = objectInput.readUTF();

		serverPort = objectInput.readInt();
		sessionId = objectInput.readUTF();
		additionalInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(auditEventArchiveId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (classPK == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classPK);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (clientHost == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientHost);
		}

		if (clientIP == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientIP);
		}

		if (serverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serverName);
		}

		objectOutput.writeInt(serverPort);

		if (sessionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sessionId);
		}

		if (additionalInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}
	}

	public long auditEventArchiveId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public String eventType;
	public String className;
	public String classPK;
	public String message;
	public String clientHost;
	public String clientIP;
	public String serverName;
	public int serverPort;
	public String sessionId;
	public String additionalInfo;

}