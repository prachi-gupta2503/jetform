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
 * This class is a wrapper for {@link ServiceRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequest
 * @generated
 */
public class ServiceRequestWrapper
	extends BaseModelWrapper<ServiceRequest>
	implements ModelWrapper<ServiceRequest>, ServiceRequest {

	public ServiceRequestWrapper(ServiceRequest serviceRequest) {
		super(serviceRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceRequestId", getServiceRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("serviceRequestTypeId", getServiceRequestTypeId());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("documentProofId", getDocumentProofId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("status", getStatus());
		attributes.put("deleted", isDeleted());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("state", getState());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceRequestId = (Long)attributes.get("serviceRequestId");

		if (serviceRequestId != null) {
			setServiceRequestId(serviceRequestId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long serviceRequestTypeId = (Long)attributes.get(
			"serviceRequestTypeId");

		if (serviceRequestTypeId != null) {
			setServiceRequestTypeId(serviceRequestTypeId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long documentProofId = (Long)attributes.get("documentProofId");

		if (documentProofId != null) {
			setDocumentProofId(documentProofId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	 * Returns the active of this service request.
	 *
	 * @return the active of this service request
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the comments of this service request.
	 *
	 * @return the comments of this service request
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the company ID of this service request.
	 *
	 * @return the company ID of this service request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this service request.
	 *
	 * @return the create date of this service request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this service request.
	 *
	 * @return the deleted of this service request
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this service request.
	 *
	 * @return the description of this service request
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the document proof ID of this service request.
	 *
	 * @return the document proof ID of this service request
	 */
	@Override
	public long getDocumentProofId() {
		return model.getDocumentProofId();
	}

	/**
	 * Returns the employee ID of this service request.
	 *
	 * @return the employee ID of this service request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this service request.
	 *
	 * @return the group ID of this service request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining process ID of this service request.
	 *
	 * @return the joining process ID of this service request
	 */
	@Override
	public Long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the modified date of this service request.
	 *
	 * @return the modified date of this service request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this service request.
	 *
	 * @return the organization ID of this service request
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this service request.
	 *
	 * @return the primary key of this service request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service request ID of this service request.
	 *
	 * @return the service request ID of this service request
	 */
	@Override
	public long getServiceRequestId() {
		return model.getServiceRequestId();
	}

	/**
	 * Returns the service request type ID of this service request.
	 *
	 * @return the service request type ID of this service request
	 */
	@Override
	public long getServiceRequestTypeId() {
		return model.getServiceRequestTypeId();
	}

	/**
	 * Returns the state of this service request.
	 *
	 * @return the state of this service request
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the status of this service request.
	 *
	 * @return the status of this service request
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this service request.
	 *
	 * @return the status by user ID of this service request
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this service request.
	 *
	 * @return the status by user name of this service request
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this service request.
	 *
	 * @return the status by user uuid of this service request
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this service request.
	 *
	 * @return the status date of this service request
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subject of this service request.
	 *
	 * @return the subject of this service request
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the user ID of this service request.
	 *
	 * @return the user ID of this service request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this service request.
	 *
	 * @return the user name of this service request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this service request.
	 *
	 * @return the user uuid of this service request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this service request is active.
	 *
	 * @return <code>true</code> if this service request is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this service request is approved.
	 *
	 * @return <code>true</code> if this service request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this service request is deleted.
	 *
	 * @return <code>true</code> if this service request is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	/**
	 * Returns <code>true</code> if this service request is denied.
	 *
	 * @return <code>true</code> if this service request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this service request is a draft.
	 *
	 * @return <code>true</code> if this service request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this service request is expired.
	 *
	 * @return <code>true</code> if this service request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this service request is inactive.
	 *
	 * @return <code>true</code> if this service request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this service request is incomplete.
	 *
	 * @return <code>true</code> if this service request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this service request is pending.
	 *
	 * @return <code>true</code> if this service request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this service request is scheduled.
	 *
	 * @return <code>true</code> if this service request is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this service request is active.
	 *
	 * @param active the active of this service request
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the comments of this service request.
	 *
	 * @param comments the comments of this service request
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the company ID of this service request.
	 *
	 * @param companyId the company ID of this service request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this service request.
	 *
	 * @param createDate the create date of this service request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this service request is deleted.
	 *
	 * @param deleted the deleted of this service request
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this service request.
	 *
	 * @param description the description of this service request
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the document proof ID of this service request.
	 *
	 * @param documentProofId the document proof ID of this service request
	 */
	@Override
	public void setDocumentProofId(long documentProofId) {
		model.setDocumentProofId(documentProofId);
	}

	/**
	 * Sets the employee ID of this service request.
	 *
	 * @param employeeId the employee ID of this service request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this service request.
	 *
	 * @param groupId the group ID of this service request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining process ID of this service request.
	 *
	 * @param joiningProcessId the joining process ID of this service request
	 */
	@Override
	public void setJoiningProcessId(Long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the modified date of this service request.
	 *
	 * @param modifiedDate the modified date of this service request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this service request.
	 *
	 * @param organizationId the organization ID of this service request
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this service request.
	 *
	 * @param primaryKey the primary key of this service request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service request ID of this service request.
	 *
	 * @param serviceRequestId the service request ID of this service request
	 */
	@Override
	public void setServiceRequestId(long serviceRequestId) {
		model.setServiceRequestId(serviceRequestId);
	}

	/**
	 * Sets the service request type ID of this service request.
	 *
	 * @param serviceRequestTypeId the service request type ID of this service request
	 */
	@Override
	public void setServiceRequestTypeId(long serviceRequestTypeId) {
		model.setServiceRequestTypeId(serviceRequestTypeId);
	}

	/**
	 * Sets the state of this service request.
	 *
	 * @param state the state of this service request
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the status of this service request.
	 *
	 * @param status the status of this service request
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this service request.
	 *
	 * @param statusByUserId the status by user ID of this service request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this service request.
	 *
	 * @param statusByUserName the status by user name of this service request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this service request.
	 *
	 * @param statusByUserUuid the status by user uuid of this service request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this service request.
	 *
	 * @param statusDate the status date of this service request
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subject of this service request.
	 *
	 * @param subject the subject of this service request
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the user ID of this service request.
	 *
	 * @param userId the user ID of this service request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this service request.
	 *
	 * @param userName the user name of this service request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this service request.
	 *
	 * @param userUuid the user uuid of this service request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ServiceRequestWrapper wrap(ServiceRequest serviceRequest) {
		return new ServiceRequestWrapper(serviceRequest);
	}

}