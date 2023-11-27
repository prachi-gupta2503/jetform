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
 * This class is a wrapper for {@link ServiceRequestWorkflow}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWorkflow
 * @generated
 */
public class ServiceRequestWorkflowWrapper
	extends BaseModelWrapper<ServiceRequestWorkflow>
	implements ModelWrapper<ServiceRequestWorkflow>, ServiceRequestWorkflow {

	public ServiceRequestWorkflowWrapper(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		super(serviceRequestWorkflow);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"serviceRequestWorkflowId", getServiceRequestWorkflowId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceRequestId", getServiceRequestId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("remark", getRemark());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceRequestWorkflowId = (Long)attributes.get(
			"serviceRequestWorkflowId");

		if (serviceRequestWorkflowId != null) {
			setServiceRequestWorkflowId(serviceRequestWorkflowId);
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

		Long serviceRequestId = (Long)attributes.get("serviceRequestId");

		if (serviceRequestId != null) {
			setServiceRequestId(serviceRequestId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the class name of this service request workflow.
	 *
	 * @return the class name of this service request workflow
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this service request workflow.
	 *
	 * @return the class pk of this service request workflow
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this service request workflow.
	 *
	 * @return the company ID of this service request workflow
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this service request workflow.
	 *
	 * @return the create date of this service request workflow
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee ID of this service request workflow.
	 *
	 * @return the employee ID of this service request workflow
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this service request workflow.
	 *
	 * @return the group ID of this service request workflow
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this service request workflow.
	 *
	 * @return the modified date of this service request workflow
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this service request workflow.
	 *
	 * @return the primary key of this service request workflow
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remark of this service request workflow.
	 *
	 * @return the remark of this service request workflow
	 */
	@Override
	public String getRemark() {
		return model.getRemark();
	}

	/**
	 * Returns the service request ID of this service request workflow.
	 *
	 * @return the service request ID of this service request workflow
	 */
	@Override
	public long getServiceRequestId() {
		return model.getServiceRequestId();
	}

	/**
	 * Returns the service request workflow ID of this service request workflow.
	 *
	 * @return the service request workflow ID of this service request workflow
	 */
	@Override
	public long getServiceRequestWorkflowId() {
		return model.getServiceRequestWorkflowId();
	}

	/**
	 * Returns the status of this service request workflow.
	 *
	 * @return the status of this service request workflow
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this service request workflow.
	 *
	 * @return the user ID of this service request workflow
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this service request workflow.
	 *
	 * @return the user name of this service request workflow
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this service request workflow.
	 *
	 * @return the user uuid of this service request workflow
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
	 * Sets the class name of this service request workflow.
	 *
	 * @param className the class name of this service request workflow
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this service request workflow.
	 *
	 * @param classPK the class pk of this service request workflow
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this service request workflow.
	 *
	 * @param companyId the company ID of this service request workflow
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this service request workflow.
	 *
	 * @param createDate the create date of this service request workflow
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee ID of this service request workflow.
	 *
	 * @param employeeId the employee ID of this service request workflow
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this service request workflow.
	 *
	 * @param groupId the group ID of this service request workflow
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this service request workflow.
	 *
	 * @param modifiedDate the modified date of this service request workflow
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this service request workflow.
	 *
	 * @param primaryKey the primary key of this service request workflow
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remark of this service request workflow.
	 *
	 * @param remark the remark of this service request workflow
	 */
	@Override
	public void setRemark(String remark) {
		model.setRemark(remark);
	}

	/**
	 * Sets the service request ID of this service request workflow.
	 *
	 * @param serviceRequestId the service request ID of this service request workflow
	 */
	@Override
	public void setServiceRequestId(long serviceRequestId) {
		model.setServiceRequestId(serviceRequestId);
	}

	/**
	 * Sets the service request workflow ID of this service request workflow.
	 *
	 * @param serviceRequestWorkflowId the service request workflow ID of this service request workflow
	 */
	@Override
	public void setServiceRequestWorkflowId(long serviceRequestWorkflowId) {
		model.setServiceRequestWorkflowId(serviceRequestWorkflowId);
	}

	/**
	 * Sets the status of this service request workflow.
	 *
	 * @param status the status of this service request workflow
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this service request workflow.
	 *
	 * @param userId the user ID of this service request workflow
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this service request workflow.
	 *
	 * @param userName the user name of this service request workflow
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this service request workflow.
	 *
	 * @param userUuid the user uuid of this service request workflow
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ServiceRequestWorkflowWrapper wrap(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		return new ServiceRequestWorkflowWrapper(serviceRequestWorkflow);
	}

}