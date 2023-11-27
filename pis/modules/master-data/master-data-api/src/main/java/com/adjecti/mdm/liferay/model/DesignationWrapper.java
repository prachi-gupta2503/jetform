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
 * This class is a wrapper for {@link Designation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Designation
 * @generated
 */
public class DesignationWrapper
	extends BaseModelWrapper<Designation>
	implements Designation, ModelWrapper<Designation> {

	public DesignationWrapper(Designation designation) {
		super(designation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designationId", getDesignationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name_En", getName_En());
		attributes.put("name_Hi", getName_Hi());
		attributes.put("shortName", getShortName());
		attributes.put("longName", getLongName());
		attributes.put("description", getDescription());
		attributes.put("designationClassId", getDesignationClassId());
		attributes.put("designationGroupId", getDesignationGroupId());
		attributes.put("designationGroup", getDesignationGroup());
		attributes.put("gradeId", getGradeId());
		attributes.put("organizationType", getOrganizationType());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("rank", getRank());
		attributes.put("scopeType", getScopeType());
		attributes.put("scopeOrganizationId", getScopeOrganizationId());
		attributes.put("scopeOrganizationTypeId", getScopeOrganizationTypeId());
		attributes.put("scopePostId", getScopePostId());
		attributes.put("designationModeId", getDesignationModeId());
		attributes.put("successorGradeId", getSuccessorGradeId());
		attributes.put("scopeOrganizationName", getScopeOrganizationName());
		attributes.put("scopePostName", getScopePostName());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
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

		String name_En = (String)attributes.get("name_En");

		if (name_En != null) {
			setName_En(name_En);
		}

		String name_Hi = (String)attributes.get("name_Hi");

		if (name_Hi != null) {
			setName_Hi(name_Hi);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String longName = (String)attributes.get("longName");

		if (longName != null) {
			setLongName(longName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long designationClassId = (Long)attributes.get("designationClassId");

		if (designationClassId != null) {
			setDesignationClassId(designationClassId);
		}

		Long designationGroupId = (Long)attributes.get("designationGroupId");

		if (designationGroupId != null) {
			setDesignationGroupId(designationGroupId);
		}

		String designationGroup = (String)attributes.get("designationGroup");

		if (designationGroup != null) {
			setDesignationGroup(designationGroup);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		String organizationType = (String)attributes.get("organizationType");

		if (organizationType != null) {
			setOrganizationType(organizationType);
		}

		String sequenceNo = (String)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		Integer rank = (Integer)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
		}

		Integer scopeType = (Integer)attributes.get("scopeType");

		if (scopeType != null) {
			setScopeType(scopeType);
		}

		Long scopeOrganizationId = (Long)attributes.get("scopeOrganizationId");

		if (scopeOrganizationId != null) {
			setScopeOrganizationId(scopeOrganizationId);
		}

		Long scopeOrganizationTypeId = (Long)attributes.get(
			"scopeOrganizationTypeId");

		if (scopeOrganizationTypeId != null) {
			setScopeOrganizationTypeId(scopeOrganizationTypeId);
		}

		Long scopePostId = (Long)attributes.get("scopePostId");

		if (scopePostId != null) {
			setScopePostId(scopePostId);
		}

		Long designationModeId = (Long)attributes.get("designationModeId");

		if (designationModeId != null) {
			setDesignationModeId(designationModeId);
		}

		Long successorGradeId = (Long)attributes.get("successorGradeId");

		if (successorGradeId != null) {
			setSuccessorGradeId(successorGradeId);
		}

		String scopeOrganizationName = (String)attributes.get(
			"scopeOrganizationName");

		if (scopeOrganizationName != null) {
			setScopeOrganizationName(scopeOrganizationName);
		}

		String scopePostName = (String)attributes.get("scopePostName");

		if (scopePostName != null) {
			setScopePostName(scopePostName);
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
	 * Returns the code of this designation.
	 *
	 * @return the code of this designation
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this designation.
	 *
	 * @return the company ID of this designation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this designation.
	 *
	 * @return the create date of this designation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this designation.
	 *
	 * @return the deleted of this designation
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this designation.
	 *
	 * @return the description of this designation
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the designation class ID of this designation.
	 *
	 * @return the designation class ID of this designation
	 */
	@Override
	public long getDesignationClassId() {
		return model.getDesignationClassId();
	}

	/**
	 * Returns the designation group of this designation.
	 *
	 * @return the designation group of this designation
	 */
	@Override
	public String getDesignationGroup() {
		return model.getDesignationGroup();
	}

	/**
	 * Returns the designation group ID of this designation.
	 *
	 * @return the designation group ID of this designation
	 */
	@Override
	public long getDesignationGroupId() {
		return model.getDesignationGroupId();
	}

	/**
	 * Returns the designation ID of this designation.
	 *
	 * @return the designation ID of this designation
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the designation mode ID of this designation.
	 *
	 * @return the designation mode ID of this designation
	 */
	@Override
	public long getDesignationModeId() {
		return model.getDesignationModeId();
	}

	/**
	 * Returns the grade ID of this designation.
	 *
	 * @return the grade ID of this designation
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the group ID of this designation.
	 *
	 * @return the group ID of this designation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the long name of this designation.
	 *
	 * @return the long name of this designation
	 */
	@Override
	public String getLongName() {
		return model.getLongName();
	}

	/**
	 * Returns the modified date of this designation.
	 *
	 * @return the modified date of this designation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name_ en of this designation.
	 *
	 * @return the name_ en of this designation
	 */
	@Override
	public String getName_En() {
		return model.getName_En();
	}

	/**
	 * Returns the name_ hi of this designation.
	 *
	 * @return the name_ hi of this designation
	 */
	@Override
	public String getName_Hi() {
		return model.getName_Hi();
	}

	/**
	 * Returns the organization type of this designation.
	 *
	 * @return the organization type of this designation
	 */
	@Override
	public String getOrganizationType() {
		return model.getOrganizationType();
	}

	/**
	 * Returns the primary key of this designation.
	 *
	 * @return the primary key of this designation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rank of this designation.
	 *
	 * @return the rank of this designation
	 */
	@Override
	public int getRank() {
		return model.getRank();
	}

	/**
	 * Returns the scope organization ID of this designation.
	 *
	 * @return the scope organization ID of this designation
	 */
	@Override
	public long getScopeOrganizationId() {
		return model.getScopeOrganizationId();
	}

	/**
	 * Returns the scope organization name of this designation.
	 *
	 * @return the scope organization name of this designation
	 */
	@Override
	public String getScopeOrganizationName() {
		return model.getScopeOrganizationName();
	}

	/**
	 * Returns the scope organization type ID of this designation.
	 *
	 * @return the scope organization type ID of this designation
	 */
	@Override
	public long getScopeOrganizationTypeId() {
		return model.getScopeOrganizationTypeId();
	}

	/**
	 * Returns the scope post ID of this designation.
	 *
	 * @return the scope post ID of this designation
	 */
	@Override
	public long getScopePostId() {
		return model.getScopePostId();
	}

	/**
	 * Returns the scope post name of this designation.
	 *
	 * @return the scope post name of this designation
	 */
	@Override
	public String getScopePostName() {
		return model.getScopePostName();
	}

	/**
	 * Returns the scope type of this designation.
	 *
	 * @return the scope type of this designation
	 */
	@Override
	public int getScopeType() {
		return model.getScopeType();
	}

	/**
	 * Returns the sequence no of this designation.
	 *
	 * @return the sequence no of this designation
	 */
	@Override
	public String getSequenceNo() {
		return model.getSequenceNo();
	}

	/**
	 * Returns the short name of this designation.
	 *
	 * @return the short name of this designation
	 */
	@Override
	public String getShortName() {
		return model.getShortName();
	}

	/**
	 * Returns the status of this designation.
	 *
	 * @return the status of this designation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the successor grade ID of this designation.
	 *
	 * @return the successor grade ID of this designation
	 */
	@Override
	public long getSuccessorGradeId() {
		return model.getSuccessorGradeId();
	}

	/**
	 * Returns the user ID of this designation.
	 *
	 * @return the user ID of this designation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this designation.
	 *
	 * @return the user name of this designation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this designation.
	 *
	 * @return the user uuid of this designation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this designation is deleted.
	 *
	 * @return <code>true</code> if this designation is deleted; <code>false</code> otherwise
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
	 * Sets the code of this designation.
	 *
	 * @param code the code of this designation
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this designation.
	 *
	 * @param companyId the company ID of this designation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this designation.
	 *
	 * @param createDate the create date of this designation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this designation is deleted.
	 *
	 * @param deleted the deleted of this designation
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this designation.
	 *
	 * @param description the description of this designation
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the designation class ID of this designation.
	 *
	 * @param designationClassId the designation class ID of this designation
	 */
	@Override
	public void setDesignationClassId(long designationClassId) {
		model.setDesignationClassId(designationClassId);
	}

	/**
	 * Sets the designation group of this designation.
	 *
	 * @param designationGroup the designation group of this designation
	 */
	@Override
	public void setDesignationGroup(String designationGroup) {
		model.setDesignationGroup(designationGroup);
	}

	/**
	 * Sets the designation group ID of this designation.
	 *
	 * @param designationGroupId the designation group ID of this designation
	 */
	@Override
	public void setDesignationGroupId(long designationGroupId) {
		model.setDesignationGroupId(designationGroupId);
	}

	/**
	 * Sets the designation ID of this designation.
	 *
	 * @param designationId the designation ID of this designation
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the designation mode ID of this designation.
	 *
	 * @param designationModeId the designation mode ID of this designation
	 */
	@Override
	public void setDesignationModeId(long designationModeId) {
		model.setDesignationModeId(designationModeId);
	}

	/**
	 * Sets the grade ID of this designation.
	 *
	 * @param gradeId the grade ID of this designation
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the group ID of this designation.
	 *
	 * @param groupId the group ID of this designation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the long name of this designation.
	 *
	 * @param longName the long name of this designation
	 */
	@Override
	public void setLongName(String longName) {
		model.setLongName(longName);
	}

	/**
	 * Sets the modified date of this designation.
	 *
	 * @param modifiedDate the modified date of this designation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name_ en of this designation.
	 *
	 * @param name_En the name_ en of this designation
	 */
	@Override
	public void setName_En(String name_En) {
		model.setName_En(name_En);
	}

	/**
	 * Sets the name_ hi of this designation.
	 *
	 * @param name_Hi the name_ hi of this designation
	 */
	@Override
	public void setName_Hi(String name_Hi) {
		model.setName_Hi(name_Hi);
	}

	/**
	 * Sets the organization type of this designation.
	 *
	 * @param organizationType the organization type of this designation
	 */
	@Override
	public void setOrganizationType(String organizationType) {
		model.setOrganizationType(organizationType);
	}

	/**
	 * Sets the primary key of this designation.
	 *
	 * @param primaryKey the primary key of this designation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rank of this designation.
	 *
	 * @param rank the rank of this designation
	 */
	@Override
	public void setRank(int rank) {
		model.setRank(rank);
	}

	/**
	 * Sets the scope organization ID of this designation.
	 *
	 * @param scopeOrganizationId the scope organization ID of this designation
	 */
	@Override
	public void setScopeOrganizationId(long scopeOrganizationId) {
		model.setScopeOrganizationId(scopeOrganizationId);
	}

	/**
	 * Sets the scope organization name of this designation.
	 *
	 * @param scopeOrganizationName the scope organization name of this designation
	 */
	@Override
	public void setScopeOrganizationName(String scopeOrganizationName) {
		model.setScopeOrganizationName(scopeOrganizationName);
	}

	/**
	 * Sets the scope organization type ID of this designation.
	 *
	 * @param scopeOrganizationTypeId the scope organization type ID of this designation
	 */
	@Override
	public void setScopeOrganizationTypeId(long scopeOrganizationTypeId) {
		model.setScopeOrganizationTypeId(scopeOrganizationTypeId);
	}

	/**
	 * Sets the scope post ID of this designation.
	 *
	 * @param scopePostId the scope post ID of this designation
	 */
	@Override
	public void setScopePostId(long scopePostId) {
		model.setScopePostId(scopePostId);
	}

	/**
	 * Sets the scope post name of this designation.
	 *
	 * @param scopePostName the scope post name of this designation
	 */
	@Override
	public void setScopePostName(String scopePostName) {
		model.setScopePostName(scopePostName);
	}

	/**
	 * Sets the scope type of this designation.
	 *
	 * @param scopeType the scope type of this designation
	 */
	@Override
	public void setScopeType(int scopeType) {
		model.setScopeType(scopeType);
	}

	/**
	 * Sets the sequence no of this designation.
	 *
	 * @param sequenceNo the sequence no of this designation
	 */
	@Override
	public void setSequenceNo(String sequenceNo) {
		model.setSequenceNo(sequenceNo);
	}

	/**
	 * Sets the short name of this designation.
	 *
	 * @param shortName the short name of this designation
	 */
	@Override
	public void setShortName(String shortName) {
		model.setShortName(shortName);
	}

	/**
	 * Sets the status of this designation.
	 *
	 * @param status the status of this designation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the successor grade ID of this designation.
	 *
	 * @param successorGradeId the successor grade ID of this designation
	 */
	@Override
	public void setSuccessorGradeId(long successorGradeId) {
		model.setSuccessorGradeId(successorGradeId);
	}

	/**
	 * Sets the user ID of this designation.
	 *
	 * @param userId the user ID of this designation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this designation.
	 *
	 * @param userName the user name of this designation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this designation.
	 *
	 * @param userUuid the user uuid of this designation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DesignationWrapper wrap(Designation designation) {
		return new DesignationWrapper(designation);
	}

}