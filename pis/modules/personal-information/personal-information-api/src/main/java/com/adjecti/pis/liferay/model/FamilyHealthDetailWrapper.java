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
 * This class is a wrapper for {@link FamilyHealthDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyHealthDetail
 * @generated
 */
public class FamilyHealthDetailWrapper
	extends BaseModelWrapper<FamilyHealthDetail>
	implements FamilyHealthDetail, ModelWrapper<FamilyHealthDetail> {

	public FamilyHealthDetailWrapper(FamilyHealthDetail familyHealthDetail) {
		super(familyHealthDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("familyHealthDetailId", getFamilyHealthDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("boardUniversity", getBoardUniversity());
		attributes.put("cityOfStudy", getCityOfStudy());
		attributes.put("deseaseDetails", getDeseaseDetails());
		attributes.put("fromYear", getFromYear());
		attributes.put("institutionName", getInstitutionName());
		attributes.put("toYear", getToYear());
		attributes.put("familyMemberId", getFamilyMemberId());
		attributes.put("stateId", getStateId());
		attributes.put("hospitalName", getHospitalName());
		attributes.put("underTreatment", isUnderTreatment());
		attributes.put("cityOfHospital", getCityOfHospital());
		attributes.put("levelId", getLevelId());
		attributes.put("diseaseTypeId", getDiseaseTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long familyHealthDetailId = (Long)attributes.get(
			"familyHealthDetailId");

		if (familyHealthDetailId != null) {
			setFamilyHealthDetailId(familyHealthDetailId);
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

		String deseaseDetails = (String)attributes.get("deseaseDetails");

		if (deseaseDetails != null) {
			setDeseaseDetails(deseaseDetails);
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

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String hospitalName = (String)attributes.get("hospitalName");

		if (hospitalName != null) {
			setHospitalName(hospitalName);
		}

		Boolean underTreatment = (Boolean)attributes.get("underTreatment");

		if (underTreatment != null) {
			setUnderTreatment(underTreatment);
		}

		String cityOfHospital = (String)attributes.get("cityOfHospital");

		if (cityOfHospital != null) {
			setCityOfHospital(cityOfHospital);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long diseaseTypeId = (Long)attributes.get("diseaseTypeId");

		if (diseaseTypeId != null) {
			setDiseaseTypeId(diseaseTypeId);
		}
	}

	/**
	 * Returns the board university of this family health detail.
	 *
	 * @return the board university of this family health detail
	 */
	@Override
	public String getBoardUniversity() {
		return model.getBoardUniversity();
	}

	/**
	 * Returns the city of hospital of this family health detail.
	 *
	 * @return the city of hospital of this family health detail
	 */
	@Override
	public String getCityOfHospital() {
		return model.getCityOfHospital();
	}

	/**
	 * Returns the city of study of this family health detail.
	 *
	 * @return the city of study of this family health detail
	 */
	@Override
	public String getCityOfStudy() {
		return model.getCityOfStudy();
	}

	/**
	 * Returns the company ID of this family health detail.
	 *
	 * @return the company ID of this family health detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this family health detail.
	 *
	 * @return the create date of this family health detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the desease details of this family health detail.
	 *
	 * @return the desease details of this family health detail
	 */
	@Override
	public String getDeseaseDetails() {
		return model.getDeseaseDetails();
	}

	/**
	 * Returns the disease type ID of this family health detail.
	 *
	 * @return the disease type ID of this family health detail
	 */
	@Override
	public long getDiseaseTypeId() {
		return model.getDiseaseTypeId();
	}

	/**
	 * Returns the family health detail ID of this family health detail.
	 *
	 * @return the family health detail ID of this family health detail
	 */
	@Override
	public long getFamilyHealthDetailId() {
		return model.getFamilyHealthDetailId();
	}

	/**
	 * Returns the family member ID of this family health detail.
	 *
	 * @return the family member ID of this family health detail
	 */
	@Override
	public long getFamilyMemberId() {
		return model.getFamilyMemberId();
	}

	/**
	 * Returns the from year of this family health detail.
	 *
	 * @return the from year of this family health detail
	 */
	@Override
	public int getFromYear() {
		return model.getFromYear();
	}

	/**
	 * Returns the group ID of this family health detail.
	 *
	 * @return the group ID of this family health detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hospital name of this family health detail.
	 *
	 * @return the hospital name of this family health detail
	 */
	@Override
	public String getHospitalName() {
		return model.getHospitalName();
	}

	/**
	 * Returns the institution name of this family health detail.
	 *
	 * @return the institution name of this family health detail
	 */
	@Override
	public String getInstitutionName() {
		return model.getInstitutionName();
	}

	/**
	 * Returns the level ID of this family health detail.
	 *
	 * @return the level ID of this family health detail
	 */
	@Override
	public long getLevelId() {
		return model.getLevelId();
	}

	/**
	 * Returns the modified date of this family health detail.
	 *
	 * @return the modified date of this family health detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this family health detail.
	 *
	 * @return the primary key of this family health detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this family health detail.
	 *
	 * @return the state ID of this family health detail
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the to year of this family health detail.
	 *
	 * @return the to year of this family health detail
	 */
	@Override
	public int getToYear() {
		return model.getToYear();
	}

	/**
	 * Returns the under treatment of this family health detail.
	 *
	 * @return the under treatment of this family health detail
	 */
	@Override
	public boolean getUnderTreatment() {
		return model.getUnderTreatment();
	}

	/**
	 * Returns the user ID of this family health detail.
	 *
	 * @return the user ID of this family health detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this family health detail.
	 *
	 * @return the user name of this family health detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this family health detail.
	 *
	 * @return the user uuid of this family health detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this family health detail is under treatment.
	 *
	 * @return <code>true</code> if this family health detail is under treatment; <code>false</code> otherwise
	 */
	@Override
	public boolean isUnderTreatment() {
		return model.isUnderTreatment();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the board university of this family health detail.
	 *
	 * @param boardUniversity the board university of this family health detail
	 */
	@Override
	public void setBoardUniversity(String boardUniversity) {
		model.setBoardUniversity(boardUniversity);
	}

	/**
	 * Sets the city of hospital of this family health detail.
	 *
	 * @param cityOfHospital the city of hospital of this family health detail
	 */
	@Override
	public void setCityOfHospital(String cityOfHospital) {
		model.setCityOfHospital(cityOfHospital);
	}

	/**
	 * Sets the city of study of this family health detail.
	 *
	 * @param cityOfStudy the city of study of this family health detail
	 */
	@Override
	public void setCityOfStudy(String cityOfStudy) {
		model.setCityOfStudy(cityOfStudy);
	}

	/**
	 * Sets the company ID of this family health detail.
	 *
	 * @param companyId the company ID of this family health detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this family health detail.
	 *
	 * @param createDate the create date of this family health detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the desease details of this family health detail.
	 *
	 * @param deseaseDetails the desease details of this family health detail
	 */
	@Override
	public void setDeseaseDetails(String deseaseDetails) {
		model.setDeseaseDetails(deseaseDetails);
	}

	/**
	 * Sets the disease type ID of this family health detail.
	 *
	 * @param diseaseTypeId the disease type ID of this family health detail
	 */
	@Override
	public void setDiseaseTypeId(long diseaseTypeId) {
		model.setDiseaseTypeId(diseaseTypeId);
	}

	/**
	 * Sets the family health detail ID of this family health detail.
	 *
	 * @param familyHealthDetailId the family health detail ID of this family health detail
	 */
	@Override
	public void setFamilyHealthDetailId(long familyHealthDetailId) {
		model.setFamilyHealthDetailId(familyHealthDetailId);
	}

	/**
	 * Sets the family member ID of this family health detail.
	 *
	 * @param familyMemberId the family member ID of this family health detail
	 */
	@Override
	public void setFamilyMemberId(long familyMemberId) {
		model.setFamilyMemberId(familyMemberId);
	}

	/**
	 * Sets the from year of this family health detail.
	 *
	 * @param fromYear the from year of this family health detail
	 */
	@Override
	public void setFromYear(int fromYear) {
		model.setFromYear(fromYear);
	}

	/**
	 * Sets the group ID of this family health detail.
	 *
	 * @param groupId the group ID of this family health detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hospital name of this family health detail.
	 *
	 * @param hospitalName the hospital name of this family health detail
	 */
	@Override
	public void setHospitalName(String hospitalName) {
		model.setHospitalName(hospitalName);
	}

	/**
	 * Sets the institution name of this family health detail.
	 *
	 * @param institutionName the institution name of this family health detail
	 */
	@Override
	public void setInstitutionName(String institutionName) {
		model.setInstitutionName(institutionName);
	}

	/**
	 * Sets the level ID of this family health detail.
	 *
	 * @param levelId the level ID of this family health detail
	 */
	@Override
	public void setLevelId(long levelId) {
		model.setLevelId(levelId);
	}

	/**
	 * Sets the modified date of this family health detail.
	 *
	 * @param modifiedDate the modified date of this family health detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this family health detail.
	 *
	 * @param primaryKey the primary key of this family health detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this family health detail.
	 *
	 * @param stateId the state ID of this family health detail
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the to year of this family health detail.
	 *
	 * @param toYear the to year of this family health detail
	 */
	@Override
	public void setToYear(int toYear) {
		model.setToYear(toYear);
	}

	/**
	 * Sets whether this family health detail is under treatment.
	 *
	 * @param underTreatment the under treatment of this family health detail
	 */
	@Override
	public void setUnderTreatment(boolean underTreatment) {
		model.setUnderTreatment(underTreatment);
	}

	/**
	 * Sets the user ID of this family health detail.
	 *
	 * @param userId the user ID of this family health detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this family health detail.
	 *
	 * @param userName the user name of this family health detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this family health detail.
	 *
	 * @param userUuid the user uuid of this family health detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected FamilyHealthDetailWrapper wrap(
		FamilyHealthDetail familyHealthDetail) {

		return new FamilyHealthDetailWrapper(familyHealthDetail);
	}

}