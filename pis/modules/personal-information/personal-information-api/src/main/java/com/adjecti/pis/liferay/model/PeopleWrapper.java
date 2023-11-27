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
 * This class is a wrapper for {@link People}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see People
 * @generated
 */
public class PeopleWrapper
	extends BaseModelWrapper<People> implements ModelWrapper<People>, People {

	public PeopleWrapper(People people) {
		super(people);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("peopleId", getPeopleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("appellationId", getAppellationId());
		attributes.put("firstName_Hi", getFirstName_Hi());
		attributes.put("firstName_En", getFirstName_En());
		attributes.put("lastName_Hi", getLastName_Hi());
		attributes.put("lastName_En", getLastName_En());
		attributes.put("middleName_Hi", getMiddleName_Hi());
		attributes.put("middleName_En", getMiddleName_En());
		attributes.put("fatherName_Hi", getFatherName_Hi());
		attributes.put("fatherName_En", getFatherName_En());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("genderId", getGenderId());
		attributes.put("maritalStatusId", getMaritalStatusId());
		attributes.put("casteCategoryId", getCasteCategoryId());
		attributes.put("identityProofId", getIdentityProofId());
		attributes.put("bloodGroupId", getBloodGroupId());
		attributes.put("citizenshipId", getCitizenshipId());
		attributes.put("phTypeId", getPhTypeId());
		attributes.put("religionId", getReligionId());
		attributes.put("aadhaarNo", getAadhaarNo());
		attributes.put("panNo", getPanNo());
		attributes.put("color", getColor());
		attributes.put("height", getHeight());
		attributes.put("identificationMark", getIdentificationMark());
		attributes.put("exServiceMan", isExServiceMan());
		attributes.put("profileImageId", getProfileImageId());
		attributes.put("joiningProcessId", getJoiningProcessId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long peopleId = (Long)attributes.get("peopleId");

		if (peopleId != null) {
			setPeopleId(peopleId);
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

		Long appellationId = (Long)attributes.get("appellationId");

		if (appellationId != null) {
			setAppellationId(appellationId);
		}

		String firstName_Hi = (String)attributes.get("firstName_Hi");

		if (firstName_Hi != null) {
			setFirstName_Hi(firstName_Hi);
		}

		String firstName_En = (String)attributes.get("firstName_En");

		if (firstName_En != null) {
			setFirstName_En(firstName_En);
		}

		String lastName_Hi = (String)attributes.get("lastName_Hi");

		if (lastName_Hi != null) {
			setLastName_Hi(lastName_Hi);
		}

		String lastName_En = (String)attributes.get("lastName_En");

		if (lastName_En != null) {
			setLastName_En(lastName_En);
		}

		String middleName_Hi = (String)attributes.get("middleName_Hi");

		if (middleName_Hi != null) {
			setMiddleName_Hi(middleName_Hi);
		}

		String middleName_En = (String)attributes.get("middleName_En");

		if (middleName_En != null) {
			setMiddleName_En(middleName_En);
		}

		String fatherName_Hi = (String)attributes.get("fatherName_Hi");

		if (fatherName_Hi != null) {
			setFatherName_Hi(fatherName_Hi);
		}

		String fatherName_En = (String)attributes.get("fatherName_En");

		if (fatherName_En != null) {
			setFatherName_En(fatherName_En);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Long genderId = (Long)attributes.get("genderId");

		if (genderId != null) {
			setGenderId(genderId);
		}

		Long maritalStatusId = (Long)attributes.get("maritalStatusId");

		if (maritalStatusId != null) {
			setMaritalStatusId(maritalStatusId);
		}

		Long casteCategoryId = (Long)attributes.get("casteCategoryId");

		if (casteCategoryId != null) {
			setCasteCategoryId(casteCategoryId);
		}

		Long identityProofId = (Long)attributes.get("identityProofId");

		if (identityProofId != null) {
			setIdentityProofId(identityProofId);
		}

		Long bloodGroupId = (Long)attributes.get("bloodGroupId");

		if (bloodGroupId != null) {
			setBloodGroupId(bloodGroupId);
		}

		Long citizenshipId = (Long)attributes.get("citizenshipId");

		if (citizenshipId != null) {
			setCitizenshipId(citizenshipId);
		}

		Long phTypeId = (Long)attributes.get("phTypeId");

		if (phTypeId != null) {
			setPhTypeId(phTypeId);
		}

		Long religionId = (Long)attributes.get("religionId");

		if (religionId != null) {
			setReligionId(religionId);
		}

		String aadhaarNo = (String)attributes.get("aadhaarNo");

		if (aadhaarNo != null) {
			setAadhaarNo(aadhaarNo);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Float height = (Float)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		String identificationMark = (String)attributes.get(
			"identificationMark");

		if (identificationMark != null) {
			setIdentificationMark(identificationMark);
		}

		Boolean exServiceMan = (Boolean)attributes.get("exServiceMan");

		if (exServiceMan != null) {
			setExServiceMan(exServiceMan);
		}

		Long profileImageId = (Long)attributes.get("profileImageId");

		if (profileImageId != null) {
			setProfileImageId(profileImageId);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}
	}

	/**
	 * Returns the aadhaar no of this people.
	 *
	 * @return the aadhaar no of this people
	 */
	@Override
	public String getAadhaarNo() {
		return model.getAadhaarNo();
	}

	/**
	 * Returns the appellation ID of this people.
	 *
	 * @return the appellation ID of this people
	 */
	@Override
	public long getAppellationId() {
		return model.getAppellationId();
	}

	/**
	 * Returns the blood group ID of this people.
	 *
	 * @return the blood group ID of this people
	 */
	@Override
	public long getBloodGroupId() {
		return model.getBloodGroupId();
	}

	/**
	 * Returns the caste category ID of this people.
	 *
	 * @return the caste category ID of this people
	 */
	@Override
	public long getCasteCategoryId() {
		return model.getCasteCategoryId();
	}

	/**
	 * Returns the citizenship ID of this people.
	 *
	 * @return the citizenship ID of this people
	 */
	@Override
	public long getCitizenshipId() {
		return model.getCitizenshipId();
	}

	/**
	 * Returns the color of this people.
	 *
	 * @return the color of this people
	 */
	@Override
	public String getColor() {
		return model.getColor();
	}

	/**
	 * Returns the company ID of this people.
	 *
	 * @return the company ID of this people
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this people.
	 *
	 * @return the create date of this people
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of birth of this people.
	 *
	 * @return the date of birth of this people
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the ex service man of this people.
	 *
	 * @return the ex service man of this people
	 */
	@Override
	public boolean getExServiceMan() {
		return model.getExServiceMan();
	}

	/**
	 * Returns the father name_ en of this people.
	 *
	 * @return the father name_ en of this people
	 */
	@Override
	public String getFatherName_En() {
		return model.getFatherName_En();
	}

	/**
	 * Returns the father name_ hi of this people.
	 *
	 * @return the father name_ hi of this people
	 */
	@Override
	public String getFatherName_Hi() {
		return model.getFatherName_Hi();
	}

	/**
	 * Returns the first name_ en of this people.
	 *
	 * @return the first name_ en of this people
	 */
	@Override
	public String getFirstName_En() {
		return model.getFirstName_En();
	}

	/**
	 * Returns the first name_ hi of this people.
	 *
	 * @return the first name_ hi of this people
	 */
	@Override
	public String getFirstName_Hi() {
		return model.getFirstName_Hi();
	}

	/**
	 * Returns the gender ID of this people.
	 *
	 * @return the gender ID of this people
	 */
	@Override
	public long getGenderId() {
		return model.getGenderId();
	}

	/**
	 * Returns the group ID of this people.
	 *
	 * @return the group ID of this people
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the height of this people.
	 *
	 * @return the height of this people
	 */
	@Override
	public float getHeight() {
		return model.getHeight();
	}

	/**
	 * Returns the identification mark of this people.
	 *
	 * @return the identification mark of this people
	 */
	@Override
	public String getIdentificationMark() {
		return model.getIdentificationMark();
	}

	/**
	 * Returns the identity proof ID of this people.
	 *
	 * @return the identity proof ID of this people
	 */
	@Override
	public long getIdentityProofId() {
		return model.getIdentityProofId();
	}

	/**
	 * Returns the joining process ID of this people.
	 *
	 * @return the joining process ID of this people
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the last name_ en of this people.
	 *
	 * @return the last name_ en of this people
	 */
	@Override
	public String getLastName_En() {
		return model.getLastName_En();
	}

	/**
	 * Returns the last name_ hi of this people.
	 *
	 * @return the last name_ hi of this people
	 */
	@Override
	public String getLastName_Hi() {
		return model.getLastName_Hi();
	}

	/**
	 * Returns the marital status ID of this people.
	 *
	 * @return the marital status ID of this people
	 */
	@Override
	public long getMaritalStatusId() {
		return model.getMaritalStatusId();
	}

	/**
	 * Returns the middle name_ en of this people.
	 *
	 * @return the middle name_ en of this people
	 */
	@Override
	public String getMiddleName_En() {
		return model.getMiddleName_En();
	}

	/**
	 * Returns the middle name_ hi of this people.
	 *
	 * @return the middle name_ hi of this people
	 */
	@Override
	public String getMiddleName_Hi() {
		return model.getMiddleName_Hi();
	}

	/**
	 * Returns the modified date of this people.
	 *
	 * @return the modified date of this people
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public String getName_En() {
		return model.getName_En();
	}

	@Override
	public String getName_Hi() {
		return model.getName_Hi();
	}

	/**
	 * Returns the pan no of this people.
	 *
	 * @return the pan no of this people
	 */
	@Override
	public String getPanNo() {
		return model.getPanNo();
	}

	/**
	 * Returns the people ID of this people.
	 *
	 * @return the people ID of this people
	 */
	@Override
	public long getPeopleId() {
		return model.getPeopleId();
	}

	/**
	 * Returns the ph type ID of this people.
	 *
	 * @return the ph type ID of this people
	 */
	@Override
	public long getPhTypeId() {
		return model.getPhTypeId();
	}

	/**
	 * Returns the primary key of this people.
	 *
	 * @return the primary key of this people
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile image ID of this people.
	 *
	 * @return the profile image ID of this people
	 */
	@Override
	public long getProfileImageId() {
		return model.getProfileImageId();
	}

	/**
	 * Returns the religion ID of this people.
	 *
	 * @return the religion ID of this people
	 */
	@Override
	public long getReligionId() {
		return model.getReligionId();
	}

	/**
	 * Returns the user ID of this people.
	 *
	 * @return the user ID of this people
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this people.
	 *
	 * @return the user name of this people
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this people.
	 *
	 * @return the user uuid of this people
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this people is ex service man.
	 *
	 * @return <code>true</code> if this people is ex service man; <code>false</code> otherwise
	 */
	@Override
	public boolean isExServiceMan() {
		return model.isExServiceMan();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhaar no of this people.
	 *
	 * @param aadhaarNo the aadhaar no of this people
	 */
	@Override
	public void setAadhaarNo(String aadhaarNo) {
		model.setAadhaarNo(aadhaarNo);
	}

	/**
	 * Sets the appellation ID of this people.
	 *
	 * @param appellationId the appellation ID of this people
	 */
	@Override
	public void setAppellationId(long appellationId) {
		model.setAppellationId(appellationId);
	}

	/**
	 * Sets the blood group ID of this people.
	 *
	 * @param bloodGroupId the blood group ID of this people
	 */
	@Override
	public void setBloodGroupId(long bloodGroupId) {
		model.setBloodGroupId(bloodGroupId);
	}

	/**
	 * Sets the caste category ID of this people.
	 *
	 * @param casteCategoryId the caste category ID of this people
	 */
	@Override
	public void setCasteCategoryId(long casteCategoryId) {
		model.setCasteCategoryId(casteCategoryId);
	}

	/**
	 * Sets the citizenship ID of this people.
	 *
	 * @param citizenshipId the citizenship ID of this people
	 */
	@Override
	public void setCitizenshipId(long citizenshipId) {
		model.setCitizenshipId(citizenshipId);
	}

	/**
	 * Sets the color of this people.
	 *
	 * @param color the color of this people
	 */
	@Override
	public void setColor(String color) {
		model.setColor(color);
	}

	/**
	 * Sets the company ID of this people.
	 *
	 * @param companyId the company ID of this people
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this people.
	 *
	 * @param createDate the create date of this people
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of birth of this people.
	 *
	 * @param dateOfBirth the date of birth of this people
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets whether this people is ex service man.
	 *
	 * @param exServiceMan the ex service man of this people
	 */
	@Override
	public void setExServiceMan(boolean exServiceMan) {
		model.setExServiceMan(exServiceMan);
	}

	/**
	 * Sets the father name_ en of this people.
	 *
	 * @param fatherName_En the father name_ en of this people
	 */
	@Override
	public void setFatherName_En(String fatherName_En) {
		model.setFatherName_En(fatherName_En);
	}

	/**
	 * Sets the father name_ hi of this people.
	 *
	 * @param fatherName_Hi the father name_ hi of this people
	 */
	@Override
	public void setFatherName_Hi(String fatherName_Hi) {
		model.setFatherName_Hi(fatherName_Hi);
	}

	/**
	 * Sets the first name_ en of this people.
	 *
	 * @param firstName_En the first name_ en of this people
	 */
	@Override
	public void setFirstName_En(String firstName_En) {
		model.setFirstName_En(firstName_En);
	}

	/**
	 * Sets the first name_ hi of this people.
	 *
	 * @param firstName_Hi the first name_ hi of this people
	 */
	@Override
	public void setFirstName_Hi(String firstName_Hi) {
		model.setFirstName_Hi(firstName_Hi);
	}

	/**
	 * Sets the gender ID of this people.
	 *
	 * @param genderId the gender ID of this people
	 */
	@Override
	public void setGenderId(long genderId) {
		model.setGenderId(genderId);
	}

	/**
	 * Sets the group ID of this people.
	 *
	 * @param groupId the group ID of this people
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the height of this people.
	 *
	 * @param height the height of this people
	 */
	@Override
	public void setHeight(float height) {
		model.setHeight(height);
	}

	/**
	 * Sets the identification mark of this people.
	 *
	 * @param identificationMark the identification mark of this people
	 */
	@Override
	public void setIdentificationMark(String identificationMark) {
		model.setIdentificationMark(identificationMark);
	}

	/**
	 * Sets the identity proof ID of this people.
	 *
	 * @param identityProofId the identity proof ID of this people
	 */
	@Override
	public void setIdentityProofId(long identityProofId) {
		model.setIdentityProofId(identityProofId);
	}

	/**
	 * Sets the joining process ID of this people.
	 *
	 * @param joiningProcessId the joining process ID of this people
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the last name_ en of this people.
	 *
	 * @param lastName_En the last name_ en of this people
	 */
	@Override
	public void setLastName_En(String lastName_En) {
		model.setLastName_En(lastName_En);
	}

	/**
	 * Sets the last name_ hi of this people.
	 *
	 * @param lastName_Hi the last name_ hi of this people
	 */
	@Override
	public void setLastName_Hi(String lastName_Hi) {
		model.setLastName_Hi(lastName_Hi);
	}

	/**
	 * Sets the marital status ID of this people.
	 *
	 * @param maritalStatusId the marital status ID of this people
	 */
	@Override
	public void setMaritalStatusId(long maritalStatusId) {
		model.setMaritalStatusId(maritalStatusId);
	}

	/**
	 * Sets the middle name_ en of this people.
	 *
	 * @param middleName_En the middle name_ en of this people
	 */
	@Override
	public void setMiddleName_En(String middleName_En) {
		model.setMiddleName_En(middleName_En);
	}

	/**
	 * Sets the middle name_ hi of this people.
	 *
	 * @param middleName_Hi the middle name_ hi of this people
	 */
	@Override
	public void setMiddleName_Hi(String middleName_Hi) {
		model.setMiddleName_Hi(middleName_Hi);
	}

	/**
	 * Sets the modified date of this people.
	 *
	 * @param modifiedDate the modified date of this people
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pan no of this people.
	 *
	 * @param panNo the pan no of this people
	 */
	@Override
	public void setPanNo(String panNo) {
		model.setPanNo(panNo);
	}

	/**
	 * Sets the people ID of this people.
	 *
	 * @param peopleId the people ID of this people
	 */
	@Override
	public void setPeopleId(long peopleId) {
		model.setPeopleId(peopleId);
	}

	/**
	 * Sets the ph type ID of this people.
	 *
	 * @param phTypeId the ph type ID of this people
	 */
	@Override
	public void setPhTypeId(long phTypeId) {
		model.setPhTypeId(phTypeId);
	}

	/**
	 * Sets the primary key of this people.
	 *
	 * @param primaryKey the primary key of this people
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile image ID of this people.
	 *
	 * @param profileImageId the profile image ID of this people
	 */
	@Override
	public void setProfileImageId(long profileImageId) {
		model.setProfileImageId(profileImageId);
	}

	/**
	 * Sets the religion ID of this people.
	 *
	 * @param religionId the religion ID of this people
	 */
	@Override
	public void setReligionId(long religionId) {
		model.setReligionId(religionId);
	}

	/**
	 * Sets the user ID of this people.
	 *
	 * @param userId the user ID of this people
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this people.
	 *
	 * @param userName the user name of this people
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this people.
	 *
	 * @param userUuid the user uuid of this people
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PeopleWrapper wrap(People people) {
		return new PeopleWrapper(people);
	}

}