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
 * This class is a wrapper for {@link SubjectOfQualification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfQualification
 * @generated
 */
public class SubjectOfQualificationWrapper
	extends BaseModelWrapper<SubjectOfQualification>
	implements ModelWrapper<SubjectOfQualification>, SubjectOfQualification {

	public SubjectOfQualificationWrapper(
		SubjectOfQualification subjectOfQualification) {

		super(subjectOfQualification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"subjectOfQualificationId", getSubjectOfQualificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("code", getCode());
		attributes.put("subjectOfQualification", getSubjectOfQualification());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subjectOfQualificationId = (Long)attributes.get(
			"subjectOfQualificationId");

		if (subjectOfQualificationId != null) {
			setSubjectOfQualificationId(subjectOfQualificationId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String subjectOfQualification = (String)attributes.get(
			"subjectOfQualification");

		if (subjectOfQualification != null) {
			setSubjectOfQualification(subjectOfQualification);
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
	 * Returns the code of this subject of qualification.
	 *
	 * @return the code of this subject of qualification
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this subject of qualification.
	 *
	 * @return the company ID of this subject of qualification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this subject of qualification.
	 *
	 * @return the create date of this subject of qualification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this subject of qualification.
	 *
	 * @return the deleted of this subject of qualification
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this subject of qualification.
	 *
	 * @return the description of this subject of qualification
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this subject of qualification.
	 *
	 * @return the group ID of this subject of qualification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this subject of qualification.
	 *
	 * @return the modified date of this subject of qualification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this subject of qualification.
	 *
	 * @return the primary key of this subject of qualification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this subject of qualification.
	 *
	 * @return the status of this subject of qualification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subject of qualification of this subject of qualification.
	 *
	 * @return the subject of qualification of this subject of qualification
	 */
	@Override
	public String getSubjectOfQualification() {
		return model.getSubjectOfQualification();
	}

	/**
	 * Returns the subject of qualification ID of this subject of qualification.
	 *
	 * @return the subject of qualification ID of this subject of qualification
	 */
	@Override
	public long getSubjectOfQualificationId() {
		return model.getSubjectOfQualificationId();
	}

	/**
	 * Returns the user ID of this subject of qualification.
	 *
	 * @return the user ID of this subject of qualification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this subject of qualification.
	 *
	 * @return the user name of this subject of qualification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this subject of qualification.
	 *
	 * @return the user uuid of this subject of qualification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this subject of qualification is deleted.
	 *
	 * @return <code>true</code> if this subject of qualification is deleted; <code>false</code> otherwise
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
	 * Sets the code of this subject of qualification.
	 *
	 * @param code the code of this subject of qualification
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this subject of qualification.
	 *
	 * @param companyId the company ID of this subject of qualification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this subject of qualification.
	 *
	 * @param createDate the create date of this subject of qualification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this subject of qualification is deleted.
	 *
	 * @param deleted the deleted of this subject of qualification
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this subject of qualification.
	 *
	 * @param description the description of this subject of qualification
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this subject of qualification.
	 *
	 * @param groupId the group ID of this subject of qualification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this subject of qualification.
	 *
	 * @param modifiedDate the modified date of this subject of qualification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this subject of qualification.
	 *
	 * @param primaryKey the primary key of this subject of qualification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this subject of qualification.
	 *
	 * @param status the status of this subject of qualification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subject of qualification of this subject of qualification.
	 *
	 * @param subjectOfQualification the subject of qualification of this subject of qualification
	 */
	@Override
	public void setSubjectOfQualification(String subjectOfQualification) {
		model.setSubjectOfQualification(subjectOfQualification);
	}

	/**
	 * Sets the subject of qualification ID of this subject of qualification.
	 *
	 * @param subjectOfQualificationId the subject of qualification ID of this subject of qualification
	 */
	@Override
	public void setSubjectOfQualificationId(long subjectOfQualificationId) {
		model.setSubjectOfQualificationId(subjectOfQualificationId);
	}

	/**
	 * Sets the user ID of this subject of qualification.
	 *
	 * @param userId the user ID of this subject of qualification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this subject of qualification.
	 *
	 * @param userName the user name of this subject of qualification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this subject of qualification.
	 *
	 * @param userUuid the user uuid of this subject of qualification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SubjectOfQualificationWrapper wrap(
		SubjectOfQualification subjectOfQualification) {

		return new SubjectOfQualificationWrapper(subjectOfQualification);
	}

}