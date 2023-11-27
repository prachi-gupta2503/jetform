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
 * This class is a wrapper for {@link EmployeeDocument}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocument
 * @generated
 */
public class EmployeeDocumentWrapper
	extends BaseModelWrapper<EmployeeDocument>
	implements EmployeeDocument, ModelWrapper<EmployeeDocument> {

	public EmployeeDocumentWrapper(EmployeeDocument employeeDocument) {
		super(employeeDocument);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeDocumentId", getEmployeeDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("documentId", getDocumentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("title", getTitle());
		attributes.put("documentTypeId", getDocumentTypeId());
		attributes.put("discription", getDiscription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeDocumentId = (Long)attributes.get("employeeDocumentId");

		if (employeeDocumentId != null) {
			setEmployeeDocumentId(employeeDocumentId);
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

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long documentTypeId = (Long)attributes.get("documentTypeId");

		if (documentTypeId != null) {
			setDocumentTypeId(documentTypeId);
		}

		String discription = (String)attributes.get("discription");

		if (discription != null) {
			setDiscription(discription);
		}
	}

	/**
	 * Returns the active of this employee document.
	 *
	 * @return the active of this employee document
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee document.
	 *
	 * @return the company ID of this employee document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee document.
	 *
	 * @return the create date of this employee document
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the discription of this employee document.
	 *
	 * @return the discription of this employee document
	 */
	@Override
	public String getDiscription() {
		return model.getDiscription();
	}

	/**
	 * Returns the document ID of this employee document.
	 *
	 * @return the document ID of this employee document
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the document type ID of this employee document.
	 *
	 * @return the document type ID of this employee document
	 */
	@Override
	public long getDocumentTypeId() {
		return model.getDocumentTypeId();
	}

	/**
	 * Returns the employee document ID of this employee document.
	 *
	 * @return the employee document ID of this employee document
	 */
	@Override
	public long getEmployeeDocumentId() {
		return model.getEmployeeDocumentId();
	}

	/**
	 * Returns the employee ID of this employee document.
	 *
	 * @return the employee ID of this employee document
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee document.
	 *
	 * @return the group ID of this employee document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee document.
	 *
	 * @return the modified date of this employee document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee document.
	 *
	 * @return the primary key of this employee document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this employee document.
	 *
	 * @return the title of this employee document
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this employee document.
	 *
	 * @return the user ID of this employee document
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee document.
	 *
	 * @return the user name of this employee document
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee document.
	 *
	 * @return the user uuid of this employee document
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee document is active.
	 *
	 * @return <code>true</code> if this employee document is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee document is active.
	 *
	 * @param active the active of this employee document
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee document.
	 *
	 * @param companyId the company ID of this employee document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee document.
	 *
	 * @param createDate the create date of this employee document
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the discription of this employee document.
	 *
	 * @param discription the discription of this employee document
	 */
	@Override
	public void setDiscription(String discription) {
		model.setDiscription(discription);
	}

	/**
	 * Sets the document ID of this employee document.
	 *
	 * @param documentId the document ID of this employee document
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the document type ID of this employee document.
	 *
	 * @param documentTypeId the document type ID of this employee document
	 */
	@Override
	public void setDocumentTypeId(long documentTypeId) {
		model.setDocumentTypeId(documentTypeId);
	}

	/**
	 * Sets the employee document ID of this employee document.
	 *
	 * @param employeeDocumentId the employee document ID of this employee document
	 */
	@Override
	public void setEmployeeDocumentId(long employeeDocumentId) {
		model.setEmployeeDocumentId(employeeDocumentId);
	}

	/**
	 * Sets the employee ID of this employee document.
	 *
	 * @param employeeId the employee ID of this employee document
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee document.
	 *
	 * @param groupId the group ID of this employee document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee document.
	 *
	 * @param modifiedDate the modified date of this employee document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee document.
	 *
	 * @param primaryKey the primary key of this employee document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this employee document.
	 *
	 * @param title the title of this employee document
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this employee document.
	 *
	 * @param userId the user ID of this employee document
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee document.
	 *
	 * @param userName the user name of this employee document
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee document.
	 *
	 * @param userUuid the user uuid of this employee document
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeDocumentWrapper wrap(EmployeeDocument employeeDocument) {
		return new EmployeeDocumentWrapper(employeeDocument);
	}

}