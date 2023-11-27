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
 * This class is a wrapper for {@link TrainingCourse}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingCourse
 * @generated
 */
public class TrainingCourseWrapper
	extends BaseModelWrapper<TrainingCourse>
	implements ModelWrapper<TrainingCourse>, TrainingCourse {

	public TrainingCourseWrapper(TrainingCourse trainingCourse) {
		super(trainingCourse);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("trainingCourseId", getTrainingCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("institution", getInstitution());
		attributes.put("locationOfInstitute", getLocationOfInstitute());
		attributes.put("name", getName());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("specializationId", getSpecializationId());
		attributes.put("stateInstituteId", getStateInstituteId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long trainingCourseId = (Long)attributes.get("trainingCourseId");

		if (trainingCourseId != null) {
			setTrainingCourseId(trainingCourseId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String institution = (String)attributes.get("institution");

		if (institution != null) {
			setInstitution(institution);
		}

		String locationOfInstitute = (String)attributes.get(
			"locationOfInstitute");

		if (locationOfInstitute != null) {
			setLocationOfInstitute(locationOfInstitute);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long specializationId = (Long)attributes.get("specializationId");

		if (specializationId != null) {
			setSpecializationId(specializationId);
		}

		Long stateInstituteId = (Long)attributes.get("stateInstituteId");

		if (stateInstituteId != null) {
			setStateInstituteId(stateInstituteId);
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
	 * Returns the code of this training course.
	 *
	 * @return the code of this training course
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this training course.
	 *
	 * @return the company ID of this training course
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this training course.
	 *
	 * @return the create date of this training course
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this training course.
	 *
	 * @return the deleted of this training course
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this training course.
	 *
	 * @return the description of this training course
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this training course.
	 *
	 * @return the group ID of this training course
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution of this training course.
	 *
	 * @return the institution of this training course
	 */
	@Override
	public String getInstitution() {
		return model.getInstitution();
	}

	/**
	 * Returns the location of institute of this training course.
	 *
	 * @return the location of institute of this training course
	 */
	@Override
	public String getLocationOfInstitute() {
		return model.getLocationOfInstitute();
	}

	/**
	 * Returns the modified date of this training course.
	 *
	 * @return the modified date of this training course
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this training course.
	 *
	 * @return the name of this training course
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the organization ID of this training course.
	 *
	 * @return the organization ID of this training course
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this training course.
	 *
	 * @return the primary key of this training course
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specialization ID of this training course.
	 *
	 * @return the specialization ID of this training course
	 */
	@Override
	public long getSpecializationId() {
		return model.getSpecializationId();
	}

	/**
	 * Returns the state institute ID of this training course.
	 *
	 * @return the state institute ID of this training course
	 */
	@Override
	public long getStateInstituteId() {
		return model.getStateInstituteId();
	}

	/**
	 * Returns the status of this training course.
	 *
	 * @return the status of this training course
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the training course ID of this training course.
	 *
	 * @return the training course ID of this training course
	 */
	@Override
	public long getTrainingCourseId() {
		return model.getTrainingCourseId();
	}

	/**
	 * Returns the user ID of this training course.
	 *
	 * @return the user ID of this training course
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this training course.
	 *
	 * @return the user name of this training course
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this training course.
	 *
	 * @return the user uuid of this training course
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this training course is deleted.
	 *
	 * @return <code>true</code> if this training course is deleted; <code>false</code> otherwise
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
	 * Sets the code of this training course.
	 *
	 * @param code the code of this training course
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this training course.
	 *
	 * @param companyId the company ID of this training course
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this training course.
	 *
	 * @param createDate the create date of this training course
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this training course is deleted.
	 *
	 * @param deleted the deleted of this training course
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this training course.
	 *
	 * @param description the description of this training course
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this training course.
	 *
	 * @param groupId the group ID of this training course
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution of this training course.
	 *
	 * @param institution the institution of this training course
	 */
	@Override
	public void setInstitution(String institution) {
		model.setInstitution(institution);
	}

	/**
	 * Sets the location of institute of this training course.
	 *
	 * @param locationOfInstitute the location of institute of this training course
	 */
	@Override
	public void setLocationOfInstitute(String locationOfInstitute) {
		model.setLocationOfInstitute(locationOfInstitute);
	}

	/**
	 * Sets the modified date of this training course.
	 *
	 * @param modifiedDate the modified date of this training course
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this training course.
	 *
	 * @param name the name of this training course
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the organization ID of this training course.
	 *
	 * @param organizationId the organization ID of this training course
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this training course.
	 *
	 * @param primaryKey the primary key of this training course
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specialization ID of this training course.
	 *
	 * @param specializationId the specialization ID of this training course
	 */
	@Override
	public void setSpecializationId(long specializationId) {
		model.setSpecializationId(specializationId);
	}

	/**
	 * Sets the state institute ID of this training course.
	 *
	 * @param stateInstituteId the state institute ID of this training course
	 */
	@Override
	public void setStateInstituteId(long stateInstituteId) {
		model.setStateInstituteId(stateInstituteId);
	}

	/**
	 * Sets the status of this training course.
	 *
	 * @param status the status of this training course
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the training course ID of this training course.
	 *
	 * @param trainingCourseId the training course ID of this training course
	 */
	@Override
	public void setTrainingCourseId(long trainingCourseId) {
		model.setTrainingCourseId(trainingCourseId);
	}

	/**
	 * Sets the user ID of this training course.
	 *
	 * @param userId the user ID of this training course
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this training course.
	 *
	 * @param userName the user name of this training course
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this training course.
	 *
	 * @param userUuid the user uuid of this training course
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TrainingCourseWrapper wrap(TrainingCourse trainingCourse) {
		return new TrainingCourseWrapper(trainingCourse);
	}

}