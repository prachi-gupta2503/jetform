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

package net.ayudh.audit.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditEventArchive}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventArchive
 * @generated
 */
public class AuditEventArchiveWrapper
	extends BaseModelWrapper<AuditEventArchive>
	implements AuditEventArchive, ModelWrapper<AuditEventArchive> {

	public AuditEventArchiveWrapper(AuditEventArchive auditEventArchive) {
		super(auditEventArchive);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("auditEventArchiveId", getAuditEventArchiveId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("eventType", getEventType());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("message", getMessage());
		attributes.put("clientHost", getClientHost());
		attributes.put("clientIP", getClientIP());
		attributes.put("serverName", getServerName());
		attributes.put("serverPort", getServerPort());
		attributes.put("sessionId", getSessionId());
		attributes.put("additionalInfo", getAdditionalInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long auditEventArchiveId = (Long)attributes.get("auditEventArchiveId");

		if (auditEventArchiveId != null) {
			setAuditEventArchiveId(auditEventArchiveId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String classPK = (String)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String clientHost = (String)attributes.get("clientHost");

		if (clientHost != null) {
			setClientHost(clientHost);
		}

		String clientIP = (String)attributes.get("clientIP");

		if (clientIP != null) {
			setClientIP(clientIP);
		}

		String serverName = (String)attributes.get("serverName");

		if (serverName != null) {
			setServerName(serverName);
		}

		Integer serverPort = (Integer)attributes.get("serverPort");

		if (serverPort != null) {
			setServerPort(serverPort);
		}

		String sessionId = (String)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}
	}

	/**
	 * Returns the additional info of this audit event archive.
	 *
	 * @return the additional info of this audit event archive
	 */
	@Override
	public String getAdditionalInfo() {
		return model.getAdditionalInfo();
	}

	/**
	 * Returns the audit event archive ID of this audit event archive.
	 *
	 * @return the audit event archive ID of this audit event archive
	 */
	@Override
	public long getAuditEventArchiveId() {
		return model.getAuditEventArchiveId();
	}

	/**
	 * Returns the class name of this audit event archive.
	 *
	 * @return the class name of this audit event archive
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this audit event archive.
	 *
	 * @return the class pk of this audit event archive
	 */
	@Override
	public String getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the client host of this audit event archive.
	 *
	 * @return the client host of this audit event archive
	 */
	@Override
	public String getClientHost() {
		return model.getClientHost();
	}

	/**
	 * Returns the client ip of this audit event archive.
	 *
	 * @return the client ip of this audit event archive
	 */
	@Override
	public String getClientIP() {
		return model.getClientIP();
	}

	/**
	 * Returns the company ID of this audit event archive.
	 *
	 * @return the company ID of this audit event archive
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this audit event archive.
	 *
	 * @return the create date of this audit event archive
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event type of this audit event archive.
	 *
	 * @return the event type of this audit event archive
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the message of this audit event archive.
	 *
	 * @return the message of this audit event archive
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the primary key of this audit event archive.
	 *
	 * @return the primary key of this audit event archive
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the server name of this audit event archive.
	 *
	 * @return the server name of this audit event archive
	 */
	@Override
	public String getServerName() {
		return model.getServerName();
	}

	/**
	 * Returns the server port of this audit event archive.
	 *
	 * @return the server port of this audit event archive
	 */
	@Override
	public int getServerPort() {
		return model.getServerPort();
	}

	/**
	 * Returns the session ID of this audit event archive.
	 *
	 * @return the session ID of this audit event archive
	 */
	@Override
	public String getSessionId() {
		return model.getSessionId();
	}

	/**
	 * Returns the user ID of this audit event archive.
	 *
	 * @return the user ID of this audit event archive
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this audit event archive.
	 *
	 * @return the user name of this audit event archive
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this audit event archive.
	 *
	 * @return the user uuid of this audit event archive
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the additional info of this audit event archive.
	 *
	 * @param additionalInfo the additional info of this audit event archive
	 */
	@Override
	public void setAdditionalInfo(String additionalInfo) {
		model.setAdditionalInfo(additionalInfo);
	}

	/**
	 * Sets the audit event archive ID of this audit event archive.
	 *
	 * @param auditEventArchiveId the audit event archive ID of this audit event archive
	 */
	@Override
	public void setAuditEventArchiveId(long auditEventArchiveId) {
		model.setAuditEventArchiveId(auditEventArchiveId);
	}

	/**
	 * Sets the class name of this audit event archive.
	 *
	 * @param className the class name of this audit event archive
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this audit event archive.
	 *
	 * @param classPK the class pk of this audit event archive
	 */
	@Override
	public void setClassPK(String classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the client host of this audit event archive.
	 *
	 * @param clientHost the client host of this audit event archive
	 */
	@Override
	public void setClientHost(String clientHost) {
		model.setClientHost(clientHost);
	}

	/**
	 * Sets the client ip of this audit event archive.
	 *
	 * @param clientIP the client ip of this audit event archive
	 */
	@Override
	public void setClientIP(String clientIP) {
		model.setClientIP(clientIP);
	}

	/**
	 * Sets the company ID of this audit event archive.
	 *
	 * @param companyId the company ID of this audit event archive
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this audit event archive.
	 *
	 * @param createDate the create date of this audit event archive
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event type of this audit event archive.
	 *
	 * @param eventType the event type of this audit event archive
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the message of this audit event archive.
	 *
	 * @param message the message of this audit event archive
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the primary key of this audit event archive.
	 *
	 * @param primaryKey the primary key of this audit event archive
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the server name of this audit event archive.
	 *
	 * @param serverName the server name of this audit event archive
	 */
	@Override
	public void setServerName(String serverName) {
		model.setServerName(serverName);
	}

	/**
	 * Sets the server port of this audit event archive.
	 *
	 * @param serverPort the server port of this audit event archive
	 */
	@Override
	public void setServerPort(int serverPort) {
		model.setServerPort(serverPort);
	}

	/**
	 * Sets the session ID of this audit event archive.
	 *
	 * @param sessionId the session ID of this audit event archive
	 */
	@Override
	public void setSessionId(String sessionId) {
		model.setSessionId(sessionId);
	}

	/**
	 * Sets the user ID of this audit event archive.
	 *
	 * @param userId the user ID of this audit event archive
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this audit event archive.
	 *
	 * @param userName the user name of this audit event archive
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this audit event archive.
	 *
	 * @param userUuid the user uuid of this audit event archive
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AuditEventArchiveWrapper wrap(
		AuditEventArchive auditEventArchive) {

		return new AuditEventArchiveWrapper(auditEventArchive);
	}

}