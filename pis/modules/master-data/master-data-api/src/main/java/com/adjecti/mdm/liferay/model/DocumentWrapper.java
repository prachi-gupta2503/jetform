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

package com.adjecti.mdm.liferay.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @generated
 */
public class DocumentWrapper
	extends BaseModelWrapper<Document>
	implements Document, ModelWrapper<Document> {

	public DocumentWrapper(Document document) {
		super(document);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("name", getName());
		attributes.put("path", getPath());
		attributes.put("refNo", getRefNo());
		attributes.put("typeId", getTypeId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String refNo = (String)attributes.get("refNo");

		if (refNo != null) {
			setRefNo(refNo);
		}

		String typeId = (String)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
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
	 * Returns the company ID of this document.
	 *
	 * @return the company ID of this document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this document.
	 *
	 * @return the create date of this document
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this document.
	 *
	 * @return the deleted of this document
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this document.
	 *
	 * @return the description of this document
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the document ID of this document.
	 *
	 * @return the document ID of this document
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the group ID of this document.
	 *
	 * @return the group ID of this document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this document.
	 *
	 * @return the modified date of this document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this document.
	 *
	 * @return the name of this document
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the path of this document.
	 *
	 * @return the path of this document
	 */
	@Override
	public String getPath() {
		return model.getPath();
	}

	/**
	 * Returns the primary key of this document.
	 *
	 * @return the primary key of this document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ref no of this document.
	 *
	 * @return the ref no of this document
	 */
	@Override
	public String getRefNo() {
		return model.getRefNo();
	}

	/**
	 * Returns the status of this document.
	 *
	 * @return the status of this document
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type ID of this document.
	 *
	 * @return the type ID of this document
	 */
	@Override
	public String getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user ID of this document.
	 *
	 * @return the user ID of this document
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this document.
	 *
	 * @return the user name of this document
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this document.
	 *
	 * @return the user uuid of this document
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this document is deleted.
	 *
	 * @return <code>true</code> if this document is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this document.
	 *
	 * @param companyId the company ID of this document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this document.
	 *
	 * @param createDate the create date of this document
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this document is deleted.
	 *
	 * @param deleted the deleted of this document
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this document.
	 *
	 * @param description the description of this document
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the document ID of this document.
	 *
	 * @param documentId the document ID of this document
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the group ID of this document.
	 *
	 * @param groupId the group ID of this document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this document.
	 *
	 * @param modifiedDate the modified date of this document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this document.
	 *
	 * @param name the name of this document
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the path of this document.
	 *
	 * @param path the path of this document
	 */
	@Override
	public void setPath(String path) {
		model.setPath(path);
	}

	/**
	 * Sets the primary key of this document.
	 *
	 * @param primaryKey the primary key of this document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ref no of this document.
	 *
	 * @param refNo the ref no of this document
	 */
	@Override
	public void setRefNo(String refNo) {
		model.setRefNo(refNo);
	}

	/**
	 * Sets the status of this document.
	 *
	 * @param status the status of this document
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type ID of this document.
	 *
	 * @param typeId the type ID of this document
	 */
	@Override
	public void setTypeId(String typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this document.
	 *
	 * @param userId the user ID of this document
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this document.
	 *
	 * @param userName the user name of this document
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this document.
	 *
	 * @param userUuid the user uuid of this document
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DocumentWrapper wrap(Document document) {
		return new DocumentWrapper(document);
	}

}