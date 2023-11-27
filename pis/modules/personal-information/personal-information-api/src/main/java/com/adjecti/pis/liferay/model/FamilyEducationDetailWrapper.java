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
 * This class is a wrapper for {@link FamilyEducationDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyEducationDetail
 * @generated
 */
public class FamilyEducationDetailWrapper
	extends BaseModelWrapper<FamilyEducationDetail>
	implements FamilyEducationDetail, ModelWrapper<FamilyEducationDetail> {

	public FamilyEducationDetailWrapper(
		FamilyEducationDetail familyEducationDetail) {

		super(familyEducationDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("familyEducationDetailId", getFamilyEducationDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("boardUniversity", getBoardUniversity());
		attributes.put("cityOfStudy", getCityOfStudy());
		attributes.put("fromYear", getFromYear());
		attributes.put("institutionName", getInstitutionName());
		attributes.put("toYear", getToYear());
		attributes.put("familyMemberId", getFamilyMemberId());
		attributes.put("levelId", getLevelId());
		attributes.put("stateId", getStateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long familyEducationDetailId = (Long)attributes.get(
			"familyEducationDetailId");

		if (familyEducationDetailId != null) {
			setFamilyEducationDetailId(familyEducationDetailId);
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

		String cityOfStudy = (String)attributes.get("cityOfStudy");

		if (cityOfStudy != null) {
			setCityOfStudy(cityOfStudy);
		}

		Integer fromYear = (Integer)attributes.get("fromYear");

		if (fromYear != null) {
			setFromYear(fromYear);
		}

		String institutionName = (String)attributes.get("institutionName");

		if (institutionName != null) {
			setInstitutionName(institutionName);
		}

		Integer toYear = (Integer)attributes.get("toYear");

		if (toYear != null) {
			setToYear(toYear);
		}

		Long familyMemberId = (Long)attributes.get("familyMemberId");

		if (familyMemberId != null) {
			setFamilyMemberId(familyMemberId);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}
	}

	/**
	 * Returns the board university of this family education detail.
	 *
	 * @return the board university of this family education detail
	 */
	@Override
	public String getBoardUniversity() {
		return model.getBoardUniversity();
	}

	/**
	 * Returns the city of study of this family education detail.
	 *
	 * @return the city of study of this family education detail
	 */
	@Override
	public String getCityOfStudy() {
		return model.getCityOfStudy();
	}

	/**
	 * Returns the company ID of this family education detail.
	 *
	 * @return the company ID of this family education detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this family education detail.
	 *
	 * @return the create date of this family education detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the family education detail ID of this family education detail.
	 *
	 * @return the family education detail ID of this family education detail
	 */
	@Override
	public long getFamilyEducationDetailId() {
		return model.getFamilyEducationDetailId();
	}

	/**
	 * Returns the family member ID of this family education detail.
	 *
	 * @return the family member ID of this family education detail
	 */
	@Override
	public long getFamilyMemberId() {
		return model.getFamilyMemberId();
	}

	/**
	 * Returns the from year of this family education detail.
	 *
	 * @return the from year of this family education detail
	 */
	@Override
	public int getFromYear() {
		return model.getFromYear();
	}

	/**
	 * Returns the group ID of this family education detail.
	 *
	 * @return the group ID of this family education detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution name of this family education detail.
	 *
	 * @return the institution name of this family education detail
	 */
	@Override
	public String getInstitutionName() {
		return model.getInstitutionName();
	}

	/**
	 * Returns the level ID of this family education detail.
	 *
	 * @return the level ID of this family education detail
	 */
	@Override
	public long getLevelId() {
		return model.getLevelId();
	}

	/**
	 * Returns the modified date of this family education detail.
	 *
	 * @return the modified date of this family education detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this family education detail.
	 *
	 * @return the primary key of this family education detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this family education detail.
	 *
	 * @return the state ID of this family education detail
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the to year of this family education detail.
	 *
	 * @return the to year of this family education detail
	 */
	@Override
	public int getToYear() {
		return model.getToYear();
	}

	/**
	 * Returns the user ID of this family education detail.
	 *
	 * @return the user ID of this family education detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this family education detail.
	 *
	 * @return the user name of this family education detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this family education detail.
	 *
	 * @return the user uuid of this family education detail
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
	 * Sets the board university of this family education detail.
	 *
	 * @param boardUniversity the board university of this family education detail
	 */
	@Override
	public void setBoardUniversity(String boardUniversity) {
		model.setBoardUniversity(boardUniversity);
	}

	/**
	 * Sets the city of study of this family education detail.
	 *
	 * @param cityOfStudy the city of study of this family education detail
	 */
	@Override
	public void setCityOfStudy(String cityOfStudy) {
		model.setCityOfStudy(cityOfStudy);
	}

	/**
	 * Sets the company ID of this family education detail.
	 *
	 * @param companyId the company ID of this family education detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this family education detail.
	 *
	 * @param createDate the create date of this family education detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the family education detail ID of this family education detail.
	 *
	 * @param familyEducationDetailId the family education detail ID of this family education detail
	 */
	@Override
	public void setFamilyEducationDetailId(long familyEducationDetailId) {
		model.setFamilyEducationDetailId(familyEducationDetailId);
	}

	/**
	 * Sets the family member ID of this family education detail.
	 *
	 * @param familyMemberId the family member ID of this family education detail
	 */
	@Override
	public void setFamilyMemberId(long familyMemberId) {
		model.setFamilyMemberId(familyMemberId);
	}

	/**
	 * Sets the from year of this family education detail.
	 *
	 * @param fromYear the from year of this family education detail
	 */
	@Override
	public void setFromYear(int fromYear) {
		model.setFromYear(fromYear);
	}

	/**
	 * Sets the group ID of this family education detail.
	 *
	 * @param groupId the group ID of this family education detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution name of this family education detail.
	 *
	 * @param institutionName the institution name of this family education detail
	 */
	@Override
	public void setInstitutionName(String institutionName) {
		model.setInstitutionName(institutionName);
	}

	/**
	 * Sets the level ID of this family education detail.
	 *
	 * @param levelId the level ID of this family education detail
	 */
	@Override
	public void setLevelId(long levelId) {
		model.setLevelId(levelId);
	}

	/**
	 * Sets the modified date of this family education detail.
	 *
	 * @param modifiedDate the modified date of this family education detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this family education detail.
	 *
	 * @param primaryKey the primary key of this family education detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this family education detail.
	 *
	 * @param stateId the state ID of this family education detail
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the to year of this family education detail.
	 *
	 * @param toYear the to year of this family education detail
	 */
	@Override
	public void setToYear(int toYear) {
		model.setToYear(toYear);
	}

	/**
	 * Sets the user ID of this family education detail.
	 *
	 * @param userId the user ID of this family education detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this family education detail.
	 *
	 * @param userName the user name of this family education detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this family education detail.
	 *
	 * @param userUuid the user uuid of this family education detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected FamilyEducationDetailWrapper wrap(
		FamilyEducationDetail familyEducationDetail) {

		return new FamilyEducationDetailWrapper(familyEducationDetail);
	}

}