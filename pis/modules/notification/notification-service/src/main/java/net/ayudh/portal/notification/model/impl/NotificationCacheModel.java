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

package net.ayudh.portal.notification.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import net.ayudh.portal.notification.model.Notification;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NotificationCacheModel
	implements CacheModel<Notification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotificationCacheModel)) {
			return false;
		}

		NotificationCacheModel notificationCacheModel =
			(NotificationCacheModel)object;

		if (notificationId == notificationCacheModel.notificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", notificationId=");
		sb.append(notificationId);
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
		sb.append(", topic=");
		sb.append(topic);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		if (uuid == null) {
			notificationImpl.setUuid("");
		}
		else {
			notificationImpl.setUuid(uuid);
		}

		notificationImpl.setNotificationId(notificationId);
		notificationImpl.setGroupId(groupId);
		notificationImpl.setCompanyId(companyId);
		notificationImpl.setUserId(userId);

		if (userName == null) {
			notificationImpl.setUserName("");
		}
		else {
			notificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			notificationImpl.setCreateDate(null);
		}
		else {
			notificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificationImpl.setModifiedDate(null);
		}
		else {
			notificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (topic == null) {
			notificationImpl.setTopic("");
		}
		else {
			notificationImpl.setTopic(topic);
		}

		if (clientId == null) {
			notificationImpl.setClientId("");
		}
		else {
			notificationImpl.setClientId(clientId);
		}

		if (message == null) {
			notificationImpl.setMessage("");
		}
		else {
			notificationImpl.setMessage(message);
		}

		notificationImpl.setStatus(status);

		if (statusDate == Long.MIN_VALUE) {
			notificationImpl.setStatusDate(null);
		}
		else {
			notificationImpl.setStatusDate(new Date(statusDate));
		}

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		notificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		topic = objectInput.readUTF();
		clientId = objectInput.readUTF();
		message = objectInput.readUTF();

		status = objectInput.readInt();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(notificationId);

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

		if (topic == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(topic);
		}

		if (clientId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientId);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long notificationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String topic;
	public String clientId;
	public String message;
	public int status;
	public long statusDate;

}