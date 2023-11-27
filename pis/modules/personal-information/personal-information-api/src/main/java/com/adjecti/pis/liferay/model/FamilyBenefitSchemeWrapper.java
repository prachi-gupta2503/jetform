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
 * This class is a wrapper for {@link FamilyBenefitScheme}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyBenefitScheme
 * @generated
 */
public class FamilyBenefitSchemeWrapper
	extends BaseModelWrapper<FamilyBenefitScheme>
	implements FamilyBenefitScheme, ModelWrapper<FamilyBenefitScheme> {

	public FamilyBenefitSchemeWrapper(FamilyBenefitScheme familyBenefitScheme) {
		super(familyBenefitScheme);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("familyBenefitSchemeId", getFamilyBenefitSchemeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("percentage", getPercentage());
		attributes.put("familyMemberId", getFamilyMemberId());
		attributes.put("benefitSchemeId", getBenefitSchemeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long familyBenefitSchemeId = (Long)attributes.get(
			"familyBenefitSchemeId");

		if (familyBenefitSchemeId != null) {
			setFamilyBenefitSchemeId(familyBenefitSchemeId);
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

		Float percentage = (Float)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		Long familyMemberId = (Long)attributes.get("familyMemberId");

		if (familyMemberId != null) {
			setFamilyMemberId(familyMemberId);
		}

		Long benefitSchemeId = (Long)attributes.get("benefitSchemeId");

		if (benefitSchemeId != null) {
			setBenefitSchemeId(benefitSchemeId);
		}
	}

	/**
	 * Returns the benefit scheme ID of this family benefit scheme.
	 *
	 * @return the benefit scheme ID of this family benefit scheme
	 */
	@Override
	public long getBenefitSchemeId() {
		return model.getBenefitSchemeId();
	}

	/**
	 * Returns the company ID of this family benefit scheme.
	 *
	 * @return the company ID of this family benefit scheme
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this family benefit scheme.
	 *
	 * @return the create date of this family benefit scheme
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the family benefit scheme ID of this family benefit scheme.
	 *
	 * @return the family benefit scheme ID of this family benefit scheme
	 */
	@Override
	public long getFamilyBenefitSchemeId() {
		return model.getFamilyBenefitSchemeId();
	}

	/**
	 * Returns the family member ID of this family benefit scheme.
	 *
	 * @return the family member ID of this family benefit scheme
	 */
	@Override
	public long getFamilyMemberId() {
		return model.getFamilyMemberId();
	}

	/**
	 * Returns the group ID of this family benefit scheme.
	 *
	 * @return the group ID of this family benefit scheme
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this family benefit scheme.
	 *
	 * @return the modified date of this family benefit scheme
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the percentage of this family benefit scheme.
	 *
	 * @return the percentage of this family benefit scheme
	 */
	@Override
	public float getPercentage() {
		return model.getPercentage();
	}

	/**
	 * Returns the primary key of this family benefit scheme.
	 *
	 * @return the primary key of this family benefit scheme
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this family benefit scheme.
	 *
	 * @return the user ID of this family benefit scheme
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this family benefit scheme.
	 *
	 * @return the user name of this family benefit scheme
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this family benefit scheme.
	 *
	 * @return the user uuid of this family benefit scheme
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
	 * Sets the benefit scheme ID of this family benefit scheme.
	 *
	 * @param benefitSchemeId the benefit scheme ID of this family benefit scheme
	 */
	@Override
	public void setBenefitSchemeId(long benefitSchemeId) {
		model.setBenefitSchemeId(benefitSchemeId);
	}

	/**
	 * Sets the company ID of this family benefit scheme.
	 *
	 * @param companyId the company ID of this family benefit scheme
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this family benefit scheme.
	 *
	 * @param createDate the create date of this family benefit scheme
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the family benefit scheme ID of this family benefit scheme.
	 *
	 * @param familyBenefitSchemeId the family benefit scheme ID of this family benefit scheme
	 */
	@Override
	public void setFamilyBenefitSchemeId(long familyBenefitSchemeId) {
		model.setFamilyBenefitSchemeId(familyBenefitSchemeId);
	}

	/**
	 * Sets the family member ID of this family benefit scheme.
	 *
	 * @param familyMemberId the family member ID of this family benefit scheme
	 */
	@Override
	public void setFamilyMemberId(long familyMemberId) {
		model.setFamilyMemberId(familyMemberId);
	}

	/**
	 * Sets the group ID of this family benefit scheme.
	 *
	 * @param groupId the group ID of this family benefit scheme
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this family benefit scheme.
	 *
	 * @param modifiedDate the modified date of this family benefit scheme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the percentage of this family benefit scheme.
	 *
	 * @param percentage the percentage of this family benefit scheme
	 */
	@Override
	public void setPercentage(float percentage) {
		model.setPercentage(percentage);
	}

	/**
	 * Sets the primary key of this family benefit scheme.
	 *
	 * @param primaryKey the primary key of this family benefit scheme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this family benefit scheme.
	 *
	 * @param userId the user ID of this family benefit scheme
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this family benefit scheme.
	 *
	 * @param userName the user name of this family benefit scheme
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this family benefit scheme.
	 *
	 * @param userUuid the user uuid of this family benefit scheme
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected FamilyBenefitSchemeWrapper wrap(
		FamilyBenefitScheme familyBenefitScheme) {

		return new FamilyBenefitSchemeWrapper(familyBenefitScheme);
	}

}