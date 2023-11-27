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
 * This class is a wrapper for {@link BenefitScheme}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenefitScheme
 * @generated
 */
public class BenefitSchemeWrapper
	extends BaseModelWrapper<BenefitScheme>
	implements BenefitScheme, ModelWrapper<BenefitScheme> {

	public BenefitSchemeWrapper(BenefitScheme benefitScheme) {
		super(benefitScheme);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("benefitSchemeId", getBenefitSchemeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("effectiveFrom", getEffectiveFrom());
		attributes.put("effectiveRate", getEffectiveRate());
		attributes.put("effectiveUpto", getEffectiveUpto());
		attributes.put("name", getName());
		attributes.put("frequencyId", getFrequencyId());
		attributes.put("rateTypeId", getRateTypeId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long benefitSchemeId = (Long)attributes.get("benefitSchemeId");

		if (benefitSchemeId != null) {
			setBenefitSchemeId(benefitSchemeId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date effectiveFrom = (Date)attributes.get("effectiveFrom");

		if (effectiveFrom != null) {
			setEffectiveFrom(effectiveFrom);
		}

		Float effectiveRate = (Float)attributes.get("effectiveRate");

		if (effectiveRate != null) {
			setEffectiveRate(effectiveRate);
		}

		Date effectiveUpto = (Date)attributes.get("effectiveUpto");

		if (effectiveUpto != null) {
			setEffectiveUpto(effectiveUpto);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer frequencyId = (Integer)attributes.get("frequencyId");

		if (frequencyId != null) {
			setFrequencyId(frequencyId);
		}

		Integer rateTypeId = (Integer)attributes.get("rateTypeId");

		if (rateTypeId != null) {
			setRateTypeId(rateTypeId);
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
	 * Returns the active of this benefit scheme.
	 *
	 * @return the active of this benefit scheme
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit scheme ID of this benefit scheme.
	 *
	 * @return the benefit scheme ID of this benefit scheme
	 */
	@Override
	public long getBenefitSchemeId() {
		return model.getBenefitSchemeId();
	}

	/**
	 * Returns the code of this benefit scheme.
	 *
	 * @return the code of this benefit scheme
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this benefit scheme.
	 *
	 * @return the company ID of this benefit scheme
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this benefit scheme.
	 *
	 * @return the create date of this benefit scheme
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this benefit scheme.
	 *
	 * @return the deleted of this benefit scheme
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this benefit scheme.
	 *
	 * @return the description of this benefit scheme
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the effective from of this benefit scheme.
	 *
	 * @return the effective from of this benefit scheme
	 */
	@Override
	public Date getEffectiveFrom() {
		return model.getEffectiveFrom();
	}

	/**
	 * Returns the effective rate of this benefit scheme.
	 *
	 * @return the effective rate of this benefit scheme
	 */
	@Override
	public float getEffectiveRate() {
		return model.getEffectiveRate();
	}

	/**
	 * Returns the effective upto of this benefit scheme.
	 *
	 * @return the effective upto of this benefit scheme
	 */
	@Override
	public Date getEffectiveUpto() {
		return model.getEffectiveUpto();
	}

	/**
	 * Returns the frequency ID of this benefit scheme.
	 *
	 * @return the frequency ID of this benefit scheme
	 */
	@Override
	public int getFrequencyId() {
		return model.getFrequencyId();
	}

	/**
	 * Returns the group ID of this benefit scheme.
	 *
	 * @return the group ID of this benefit scheme
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this benefit scheme.
	 *
	 * @return the modified date of this benefit scheme
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this benefit scheme.
	 *
	 * @return the name of this benefit scheme
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this benefit scheme.
	 *
	 * @return the primary key of this benefit scheme
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rate type ID of this benefit scheme.
	 *
	 * @return the rate type ID of this benefit scheme
	 */
	@Override
	public int getRateTypeId() {
		return model.getRateTypeId();
	}

	/**
	 * Returns the status of this benefit scheme.
	 *
	 * @return the status of this benefit scheme
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this benefit scheme.
	 *
	 * @return the user ID of this benefit scheme
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this benefit scheme.
	 *
	 * @return the user name of this benefit scheme
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this benefit scheme.
	 *
	 * @return the user uuid of this benefit scheme
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this benefit scheme is active.
	 *
	 * @return <code>true</code> if this benefit scheme is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this benefit scheme is deleted.
	 *
	 * @return <code>true</code> if this benefit scheme is deleted; <code>false</code> otherwise
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
	 * Sets whether this benefit scheme is active.
	 *
	 * @param active the active of this benefit scheme
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit scheme ID of this benefit scheme.
	 *
	 * @param benefitSchemeId the benefit scheme ID of this benefit scheme
	 */
	@Override
	public void setBenefitSchemeId(long benefitSchemeId) {
		model.setBenefitSchemeId(benefitSchemeId);
	}

	/**
	 * Sets the code of this benefit scheme.
	 *
	 * @param code the code of this benefit scheme
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this benefit scheme.
	 *
	 * @param companyId the company ID of this benefit scheme
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this benefit scheme.
	 *
	 * @param createDate the create date of this benefit scheme
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this benefit scheme is deleted.
	 *
	 * @param deleted the deleted of this benefit scheme
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this benefit scheme.
	 *
	 * @param description the description of this benefit scheme
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the effective from of this benefit scheme.
	 *
	 * @param effectiveFrom the effective from of this benefit scheme
	 */
	@Override
	public void setEffectiveFrom(Date effectiveFrom) {
		model.setEffectiveFrom(effectiveFrom);
	}

	/**
	 * Sets the effective rate of this benefit scheme.
	 *
	 * @param effectiveRate the effective rate of this benefit scheme
	 */
	@Override
	public void setEffectiveRate(float effectiveRate) {
		model.setEffectiveRate(effectiveRate);
	}

	/**
	 * Sets the effective upto of this benefit scheme.
	 *
	 * @param effectiveUpto the effective upto of this benefit scheme
	 */
	@Override
	public void setEffectiveUpto(Date effectiveUpto) {
		model.setEffectiveUpto(effectiveUpto);
	}

	/**
	 * Sets the frequency ID of this benefit scheme.
	 *
	 * @param frequencyId the frequency ID of this benefit scheme
	 */
	@Override
	public void setFrequencyId(int frequencyId) {
		model.setFrequencyId(frequencyId);
	}

	/**
	 * Sets the group ID of this benefit scheme.
	 *
	 * @param groupId the group ID of this benefit scheme
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this benefit scheme.
	 *
	 * @param modifiedDate the modified date of this benefit scheme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this benefit scheme.
	 *
	 * @param name the name of this benefit scheme
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this benefit scheme.
	 *
	 * @param primaryKey the primary key of this benefit scheme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rate type ID of this benefit scheme.
	 *
	 * @param rateTypeId the rate type ID of this benefit scheme
	 */
	@Override
	public void setRateTypeId(int rateTypeId) {
		model.setRateTypeId(rateTypeId);
	}

	/**
	 * Sets the status of this benefit scheme.
	 *
	 * @param status the status of this benefit scheme
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this benefit scheme.
	 *
	 * @param userId the user ID of this benefit scheme
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this benefit scheme.
	 *
	 * @param userName the user name of this benefit scheme
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this benefit scheme.
	 *
	 * @param userUuid the user uuid of this benefit scheme
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected BenefitSchemeWrapper wrap(BenefitScheme benefitScheme) {
		return new BenefitSchemeWrapper(benefitScheme);
	}

}