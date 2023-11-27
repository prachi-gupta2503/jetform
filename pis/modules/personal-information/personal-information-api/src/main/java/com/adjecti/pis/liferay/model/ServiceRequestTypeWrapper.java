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
 * This class is a wrapper for {@link ServiceRequestType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestType
 * @generated
 */
public class ServiceRequestTypeWrapper
	extends BaseModelWrapper<ServiceRequestType>
	implements ModelWrapper<ServiceRequestType>, ServiceRequestType {

	public ServiceRequestTypeWrapper(ServiceRequestType serviceRequestType) {
		super(serviceRequestType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceRequestTypeId", getServiceRequestTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("className", getClassName());
		attributes.put("action", getAction());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceRequestTypeId = (Long)attributes.get(
			"serviceRequestTypeId");

		if (serviceRequestTypeId != null) {
			setServiceRequestTypeId(serviceRequestTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the action of this service request type.
	 *
	 * @return the action of this service request type
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the class name of this service request type.
	 *
	 * @return the class name of this service request type
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the company ID of this service request type.
	 *
	 * @return the company ID of this service request type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this service request type.
	 *
	 * @return the create date of this service request type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this service request type.
	 *
	 * @return the deleted of this service request type
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this service request type.
	 *
	 * @return the group ID of this service request type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this service request type.
	 *
	 * @return the modified date of this service request type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this service request type.
	 *
	 * @return the name of this service request type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this service request type.
	 *
	 * @return the primary key of this service request type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service request type ID of this service request type.
	 *
	 * @return the service request type ID of this service request type
	 */
	@Override
	public long getServiceRequestTypeId() {
		return model.getServiceRequestTypeId();
	}

	/**
	 * Returns the status of this service request type.
	 *
	 * @return the status of this service request type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this service request type.
	 *
	 * @return the user ID of this service request type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this service request type.
	 *
	 * @return the user name of this service request type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this service request type.
	 *
	 * @return the user uuid of this service request type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this service request type is deleted.
	 *
	 * @return <code>true</code> if this service request type is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this service request type.
	 *
	 * @param action the action of this service request type
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the class name of this service request type.
	 *
	 * @param className the class name of this service request type
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the company ID of this service request type.
	 *
	 * @param companyId the company ID of this service request type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this service request type.
	 *
	 * @param createDate the create date of this service request type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this service request type is deleted.
	 *
	 * @param deleted the deleted of this service request type
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this service request type.
	 *
	 * @param groupId the group ID of this service request type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this service request type.
	 *
	 * @param modifiedDate the modified date of this service request type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this service request type.
	 *
	 * @param name the name of this service request type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this service request type.
	 *
	 * @param primaryKey the primary key of this service request type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service request type ID of this service request type.
	 *
	 * @param serviceRequestTypeId the service request type ID of this service request type
	 */
	@Override
	public void setServiceRequestTypeId(long serviceRequestTypeId) {
		model.setServiceRequestTypeId(serviceRequestTypeId);
	}

	/**
	 * Sets the status of this service request type.
	 *
	 * @param status the status of this service request type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this service request type.
	 *
	 * @param userId the user ID of this service request type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this service request type.
	 *
	 * @param userName the user name of this service request type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this service request type.
	 *
	 * @param userUuid the user uuid of this service request type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ServiceRequestTypeWrapper wrap(
		ServiceRequestType serviceRequestType) {

		return new ServiceRequestTypeWrapper(serviceRequestType);
	}

}