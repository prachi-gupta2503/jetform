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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BenefitScheme service. Represents a row in the &quot;mdm_BenefitScheme&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.BenefitSchemeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.BenefitSchemeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenefitScheme
 * @generated
 */
@ProviderType
public interface BenefitSchemeModel
	extends BaseModel<BenefitScheme>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a benefit scheme model instance should use the {@link BenefitScheme} interface instead.
	 */

	/**
	 * Returns the primary key of this benefit scheme.
	 *
	 * @return the primary key of this benefit scheme
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this benefit scheme.
	 *
	 * @param primaryKey the primary key of this benefit scheme
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the benefit scheme ID of this benefit scheme.
	 *
	 * @return the benefit scheme ID of this benefit scheme
	 */
	public long getBenefitSchemeId();

	/**
	 * Sets the benefit scheme ID of this benefit scheme.
	 *
	 * @param benefitSchemeId the benefit scheme ID of this benefit scheme
	 */
	public void setBenefitSchemeId(long benefitSchemeId);

	/**
	 * Returns the group ID of this benefit scheme.
	 *
	 * @return the group ID of this benefit scheme
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this benefit scheme.
	 *
	 * @param groupId the group ID of this benefit scheme
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this benefit scheme.
	 *
	 * @return the company ID of this benefit scheme
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this benefit scheme.
	 *
	 * @param companyId the company ID of this benefit scheme
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this benefit scheme.
	 *
	 * @return the user ID of this benefit scheme
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this benefit scheme.
	 *
	 * @param userId the user ID of this benefit scheme
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this benefit scheme.
	 *
	 * @return the user uuid of this benefit scheme
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this benefit scheme.
	 *
	 * @param userUuid the user uuid of this benefit scheme
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this benefit scheme.
	 *
	 * @return the user name of this benefit scheme
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this benefit scheme.
	 *
	 * @param userName the user name of this benefit scheme
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this benefit scheme.
	 *
	 * @return the create date of this benefit scheme
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this benefit scheme.
	 *
	 * @param createDate the create date of this benefit scheme
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this benefit scheme.
	 *
	 * @return the modified date of this benefit scheme
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this benefit scheme.
	 *
	 * @param modifiedDate the modified date of this benefit scheme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this benefit scheme.
	 *
	 * @return the active of this benefit scheme
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this benefit scheme is active.
	 *
	 * @return <code>true</code> if this benefit scheme is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this benefit scheme is active.
	 *
	 * @param active the active of this benefit scheme
	 */
	public void setActive(boolean active);

	/**
	 * Returns the code of this benefit scheme.
	 *
	 * @return the code of this benefit scheme
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this benefit scheme.
	 *
	 * @param code the code of this benefit scheme
	 */
	public void setCode(String code);

	/**
	 * Returns the description of this benefit scheme.
	 *
	 * @return the description of this benefit scheme
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this benefit scheme.
	 *
	 * @param description the description of this benefit scheme
	 */
	public void setDescription(String description);

	/**
	 * Returns the effective from of this benefit scheme.
	 *
	 * @return the effective from of this benefit scheme
	 */
	public Date getEffectiveFrom();

	/**
	 * Sets the effective from of this benefit scheme.
	 *
	 * @param effectiveFrom the effective from of this benefit scheme
	 */
	public void setEffectiveFrom(Date effectiveFrom);

	/**
	 * Returns the effective rate of this benefit scheme.
	 *
	 * @return the effective rate of this benefit scheme
	 */
	public float getEffectiveRate();

	/**
	 * Sets the effective rate of this benefit scheme.
	 *
	 * @param effectiveRate the effective rate of this benefit scheme
	 */
	public void setEffectiveRate(float effectiveRate);

	/**
	 * Returns the effective upto of this benefit scheme.
	 *
	 * @return the effective upto of this benefit scheme
	 */
	public Date getEffectiveUpto();

	/**
	 * Sets the effective upto of this benefit scheme.
	 *
	 * @param effectiveUpto the effective upto of this benefit scheme
	 */
	public void setEffectiveUpto(Date effectiveUpto);

	/**
	 * Returns the name of this benefit scheme.
	 *
	 * @return the name of this benefit scheme
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this benefit scheme.
	 *
	 * @param name the name of this benefit scheme
	 */
	public void setName(String name);

	/**
	 * Returns the frequency ID of this benefit scheme.
	 *
	 * @return the frequency ID of this benefit scheme
	 */
	public int getFrequencyId();

	/**
	 * Sets the frequency ID of this benefit scheme.
	 *
	 * @param frequencyId the frequency ID of this benefit scheme
	 */
	public void setFrequencyId(int frequencyId);

	/**
	 * Returns the rate type ID of this benefit scheme.
	 *
	 * @return the rate type ID of this benefit scheme
	 */
	public int getRateTypeId();

	/**
	 * Sets the rate type ID of this benefit scheme.
	 *
	 * @param rateTypeId the rate type ID of this benefit scheme
	 */
	public void setRateTypeId(int rateTypeId);

	/**
	 * Returns the deleted of this benefit scheme.
	 *
	 * @return the deleted of this benefit scheme
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this benefit scheme is deleted.
	 *
	 * @return <code>true</code> if this benefit scheme is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this benefit scheme is deleted.
	 *
	 * @param deleted the deleted of this benefit scheme
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this benefit scheme.
	 *
	 * @return the status of this benefit scheme
	 */
	public int getStatus();

	/**
	 * Sets the status of this benefit scheme.
	 *
	 * @param status the status of this benefit scheme
	 */
	public void setStatus(int status);

}