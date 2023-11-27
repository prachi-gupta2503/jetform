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
 * This class is a wrapper for {@link SubjectOfTraining}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfTraining
 * @generated
 */
public class SubjectOfTrainingWrapper
	extends BaseModelWrapper<SubjectOfTraining>
	implements ModelWrapper<SubjectOfTraining>, SubjectOfTraining {

	public SubjectOfTrainingWrapper(SubjectOfTraining subjectOfTraining) {
		super(subjectOfTraining);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subjectOfTrainingId", getSubjectOfTrainingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("code", getCode());
		attributes.put("trainingSubject", getTrainingSubject());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subjectOfTrainingId = (Long)attributes.get("subjectOfTrainingId");

		if (subjectOfTrainingId != null) {
			setSubjectOfTrainingId(subjectOfTrainingId);
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

		String trainingSubject = (String)attributes.get("trainingSubject");

		if (trainingSubject != null) {
			setTrainingSubject(trainingSubject);
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
	 * Returns the code of this subject of training.
	 *
	 * @return the code of this subject of training
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this subject of training.
	 *
	 * @return the company ID of this subject of training
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this subject of training.
	 *
	 * @return the create date of this subject of training
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this subject of training.
	 *
	 * @return the deleted of this subject of training
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this subject of training.
	 *
	 * @return the description of this subject of training
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this subject of training.
	 *
	 * @return the group ID of this subject of training
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this subject of training.
	 *
	 * @return the modified date of this subject of training
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this subject of training.
	 *
	 * @return the primary key of this subject of training
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this subject of training.
	 *
	 * @return the status of this subject of training
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subject of training ID of this subject of training.
	 *
	 * @return the subject of training ID of this subject of training
	 */
	@Override
	public long getSubjectOfTrainingId() {
		return model.getSubjectOfTrainingId();
	}

	/**
	 * Returns the training subject of this subject of training.
	 *
	 * @return the training subject of this subject of training
	 */
	@Override
	public String getTrainingSubject() {
		return model.getTrainingSubject();
	}

	/**
	 * Returns the user ID of this subject of training.
	 *
	 * @return the user ID of this subject of training
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this subject of training.
	 *
	 * @return the user name of this subject of training
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this subject of training.
	 *
	 * @return the user uuid of this subject of training
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this subject of training is deleted.
	 *
	 * @return <code>true</code> if this subject of training is deleted; <code>false</code> otherwise
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
	 * Sets the code of this subject of training.
	 *
	 * @param code the code of this subject of training
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this subject of training.
	 *
	 * @param companyId the company ID of this subject of training
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this subject of training.
	 *
	 * @param createDate the create date of this subject of training
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this subject of training is deleted.
	 *
	 * @param deleted the deleted of this subject of training
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this subject of training.
	 *
	 * @param description the description of this subject of training
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this subject of training.
	 *
	 * @param groupId the group ID of this subject of training
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this subject of training.
	 *
	 * @param modifiedDate the modified date of this subject of training
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this subject of training.
	 *
	 * @param primaryKey the primary key of this subject of training
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this subject of training.
	 *
	 * @param status the status of this subject of training
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subject of training ID of this subject of training.
	 *
	 * @param subjectOfTrainingId the subject of training ID of this subject of training
	 */
	@Override
	public void setSubjectOfTrainingId(long subjectOfTrainingId) {
		model.setSubjectOfTrainingId(subjectOfTrainingId);
	}

	/**
	 * Sets the training subject of this subject of training.
	 *
	 * @param trainingSubject the training subject of this subject of training
	 */
	@Override
	public void setTrainingSubject(String trainingSubject) {
		model.setTrainingSubject(trainingSubject);
	}

	/**
	 * Sets the user ID of this subject of training.
	 *
	 * @param userId the user ID of this subject of training
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this subject of training.
	 *
	 * @param userName the user name of this subject of training
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this subject of training.
	 *
	 * @param userUuid the user uuid of this subject of training
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SubjectOfTrainingWrapper wrap(
		SubjectOfTraining subjectOfTraining) {

		return new SubjectOfTrainingWrapper(subjectOfTraining);
	}

}