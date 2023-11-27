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
 * This class is a wrapper for {@link FamilyMemberServiceDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyMemberServiceDetail
 * @generated
 */
public class FamilyMemberServiceDetailWrapper
	extends BaseModelWrapper<FamilyMemberServiceDetail>
	implements FamilyMemberServiceDetail,
			   ModelWrapper<FamilyMemberServiceDetail> {

	public FamilyMemberServiceDetailWrapper(
		FamilyMemberServiceDetail familyMemberServiceDetail) {

		super(familyMemberServiceDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"familyMemberServiceDetailId", getFamilyMemberServiceDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("boardUniversity", getBoardUniversity());
		attributes.put("fromYear", getFromYear());
		attributes.put("toYear", getToYear());
		attributes.put("description", getDescription());
		attributes.put("endDate", getEndDate());
		attributes.put("organization", getOrganization());
		attributes.put("startDate", getStartDate());
		attributes.put("familyMemberId", getFamilyMemberId());
		attributes.put("levelId", getLevelId());
		attributes.put("serviceTypeId", getServiceTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long familyMemberServiceDetailId = (Long)attributes.get(
			"familyMemberServiceDetailId");

		if (familyMemberServiceDetailId != null) {
			setFamilyMemberServiceDetailId(familyMemberServiceDetailId);
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

		String boardUniversity = (String)attributes.get("boardUniversity");

		if (boardUniversity != null) {
			setBoardUniversity(boardUniversity);
		}

		Integer fromYear = (Integer)attributes.get("fromYear");

		if (fromYear != null) {
			setFromYear(fromYear);
		}

		Integer toYear = (Integer)attributes.get("toYear");

		if (toYear != null) {
			setToYear(toYear);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long familyMemberId = (Long)attributes.get("familyMemberId");

		if (familyMemberId != null) {
			setFamilyMemberId(familyMemberId);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long serviceTypeId = (Long)attributes.get("serviceTypeId");

		if (serviceTypeId != null) {
			setServiceTypeId(serviceTypeId);
		}
	}

	/**
	 * Returns the board university of this family member service detail.
	 *
	 * @return the board university of this family member service detail
	 */
	@Override
	public String getBoardUniversity() {
		return model.getBoardUniversity();
	}

	/**
	 * Returns the company ID of this family member service detail.
	 *
	 * @return the company ID of this family member service detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this family member service detail.
	 *
	 * @return the create date of this family member service detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this family member service detail.
	 *
	 * @return the description of this family member service detail
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this family member service detail.
	 *
	 * @return the end date of this family member service detail
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the family member ID of this family member service detail.
	 *
	 * @return the family member ID of this family member service detail
	 */
	@Override
	public long getFamilyMemberId() {
		return model.getFamilyMemberId();
	}

	/**
	 * Returns the family member service detail ID of this family member service detail.
	 *
	 * @return the family member service detail ID of this family member service detail
	 */
	@Override
	public long getFamilyMemberServiceDetailId() {
		return model.getFamilyMemberServiceDetailId();
	}

	/**
	 * Returns the from year of this family member service detail.
	 *
	 * @return the from year of this family member service detail
	 */
	@Override
	public int getFromYear() {
		return model.getFromYear();
	}

	/**
	 * Returns the group ID of this family member service detail.
	 *
	 * @return the group ID of this family member service detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level ID of this family member service detail.
	 *
	 * @return the level ID of this family member service detail
	 */
	@Override
	public long getLevelId() {
		return model.getLevelId();
	}

	/**
	 * Returns the modified date of this family member service detail.
	 *
	 * @return the modified date of this family member service detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization of this family member service detail.
	 *
	 * @return the organization of this family member service detail
	 */
	@Override
	public String getOrganization() {
		return model.getOrganization();
	}

	/**
	 * Returns the primary key of this family member service detail.
	 *
	 * @return the primary key of this family member service detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service type ID of this family member service detail.
	 *
	 * @return the service type ID of this family member service detail
	 */
	@Override
	public long getServiceTypeId() {
		return model.getServiceTypeId();
	}

	/**
	 * Returns the start date of this family member service detail.
	 *
	 * @return the start date of this family member service detail
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the to year of this family member service detail.
	 *
	 * @return the to year of this family member service detail
	 */
	@Override
	public int getToYear() {
		return model.getToYear();
	}

	/**
	 * Returns the user ID of this family member service detail.
	 *
	 * @return the user ID of this family member service detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this family member service detail.
	 *
	 * @return the user name of this family member service detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this family member service detail.
	 *
	 * @return the user uuid of this family member service detail
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
	 * Sets the board university of this family member service detail.
	 *
	 * @param boardUniversity the board university of this family member service detail
	 */
	@Override
	public void setBoardUniversity(String boardUniversity) {
		model.setBoardUniversity(boardUniversity);
	}

	/**
	 * Sets the company ID of this family member service detail.
	 *
	 * @param companyId the company ID of this family member service detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this family member service detail.
	 *
	 * @param createDate the create date of this family member service detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this family member service detail.
	 *
	 * @param description the description of this family member service detail
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this family member service detail.
	 *
	 * @param endDate the end date of this family member service detail
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the family member ID of this family member service detail.
	 *
	 * @param familyMemberId the family member ID of this family member service detail
	 */
	@Override
	public void setFamilyMemberId(long familyMemberId) {
		model.setFamilyMemberId(familyMemberId);
	}

	/**
	 * Sets the family member service detail ID of this family member service detail.
	 *
	 * @param familyMemberServiceDetailId the family member service detail ID of this family member service detail
	 */
	@Override
	public void setFamilyMemberServiceDetailId(
		long familyMemberServiceDetailId) {

		model.setFamilyMemberServiceDetailId(familyMemberServiceDetailId);
	}

	/**
	 * Sets the from year of this family member service detail.
	 *
	 * @param fromYear the from year of this family member service detail
	 */
	@Override
	public void setFromYear(int fromYear) {
		model.setFromYear(fromYear);
	}

	/**
	 * Sets the group ID of this family member service detail.
	 *
	 * @param groupId the group ID of this family member service detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level ID of this family member service detail.
	 *
	 * @param levelId the level ID of this family member service detail
	 */
	@Override
	public void setLevelId(long levelId) {
		model.setLevelId(levelId);
	}

	/**
	 * Sets the modified date of this family member service detail.
	 *
	 * @param modifiedDate the modified date of this family member service detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization of this family member service detail.
	 *
	 * @param organization the organization of this family member service detail
	 */
	@Override
	public void setOrganization(String organization) {
		model.setOrganization(organization);
	}

	/**
	 * Sets the primary key of this family member service detail.
	 *
	 * @param primaryKey the primary key of this family member service detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service type ID of this family member service detail.
	 *
	 * @param serviceTypeId the service type ID of this family member service detail
	 */
	@Override
	public void setServiceTypeId(long serviceTypeId) {
		model.setServiceTypeId(serviceTypeId);
	}

	/**
	 * Sets the start date of this family member service detail.
	 *
	 * @param startDate the start date of this family member service detail
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the to year of this family member service detail.
	 *
	 * @param toYear the to year of this family member service detail
	 */
	@Override
	public void setToYear(int toYear) {
		model.setToYear(toYear);
	}

	/**
	 * Sets the user ID of this family member service detail.
	 *
	 * @param userId the user ID of this family member service detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this family member service detail.
	 *
	 * @param userName the user name of this family member service detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this family member service detail.
	 *
	 * @param userUuid the user uuid of this family member service detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected FamilyMemberServiceDetailWrapper wrap(
		FamilyMemberServiceDetail familyMemberServiceDetail) {

		return new FamilyMemberServiceDetailWrapper(familyMemberServiceDetail);
	}

}