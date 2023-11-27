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

package com.adjecti.pis.liferay.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeMessage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeMessage
 * @generated
 */
public class EmployeeMessageWrapper
	extends BaseModelWrapper<EmployeeMessage>
	implements EmployeeMessage, ModelWrapper<EmployeeMessage> {

	public EmployeeMessageWrapper(EmployeeMessage employeeMessage) {
		super(employeeMessage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeMessageId", getEmployeeMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("title", getTitle());
		attributes.put("message", getMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeMessageId = (Long)attributes.get("employeeMessageId");

		if (employeeMessageId != null) {
			setEmployeeMessageId(employeeMessageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}
	}

	/**
	 * Returns the company ID of this employee message.
	 *
	 * @return the company ID of this employee message
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee message.
	 *
	 * @return the create date of this employee message
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this employee message.
	 *
	 * @return the employee ID of this employee message
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee message ID of this employee message.
	 *
	 * @return the employee message ID of this employee message
	 */
	@Override
	public long getEmployeeMessageId() {
		return model.getEmployeeMessageId();
	}

	/**
	 * Returns the group ID of this employee message.
	 *
	 * @return the group ID of this employee message
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the message of this employee message.
	 *
	 * @return the message of this employee message
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the modified date of this employee message.
	 *
	 * @return the modified date of this employee message
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee message.
	 *
	 * @return the primary key of this employee message
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this employee message.
	 *
	 * @return the title of this employee message
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this employee message.
	 *
	 * @return the user ID of this employee message
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee message.
	 *
	 * @return the user name of this employee message
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee message.
	 *
	 * @return the user uuid of this employee message
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
	 * Sets the company ID of this employee message.
	 *
	 * @param companyId the company ID of this employee message
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee message.
	 *
	 * @param createDate the create date of this employee message
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this employee message.
	 *
	 * @param employeeId the employee ID of this employee message
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee message ID of this employee message.
	 *
	 * @param employeeMessageId the employee message ID of this employee message
	 */
	@Override
	public void setEmployeeMessageId(long employeeMessageId) {
		model.setEmployeeMessageId(employeeMessageId);
	}

	/**
	 * Sets the group ID of this employee message.
	 *
	 * @param groupId the group ID of this employee message
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the message of this employee message.
	 *
	 * @param message the message of this employee message
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the modified date of this employee message.
	 *
	 * @param modifiedDate the modified date of this employee message
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee message.
	 *
	 * @param primaryKey the primary key of this employee message
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this employee message.
	 *
	 * @param title the title of this employee message
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this employee message.
	 *
	 * @param userId the user ID of this employee message
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee message.
	 *
	 * @param userName the user name of this employee message
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee message.
	 *
	 * @param userUuid the user uuid of this employee message
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeMessageWrapper wrap(EmployeeMessage employeeMessage) {
		return new EmployeeMessageWrapper(employeeMessage);
	}

}