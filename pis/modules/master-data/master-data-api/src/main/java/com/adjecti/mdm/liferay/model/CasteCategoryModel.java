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
 * The base model interface for the CasteCategory service. Represents a row in the &quot;mdm_CasteCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.CasteCategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.CasteCategoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasteCategory
 * @generated
 */
@ProviderType
public interface CasteCategoryModel
	extends BaseModel<CasteCategory>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a caste category model instance should use the {@link CasteCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this caste category.
	 *
	 * @return the primary key of this caste category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this caste category.
	 *
	 * @param primaryKey the primary key of this caste category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the caste category ID of this caste category.
	 *
	 * @return the caste category ID of this caste category
	 */
	public long getCasteCategoryId();

	/**
	 * Sets the caste category ID of this caste category.
	 *
	 * @param casteCategoryId the caste category ID of this caste category
	 */
	public void setCasteCategoryId(long casteCategoryId);

	/**
	 * Returns the group ID of this caste category.
	 *
	 * @return the group ID of this caste category
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this caste category.
	 *
	 * @param groupId the group ID of this caste category
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this caste category.
	 *
	 * @return the company ID of this caste category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this caste category.
	 *
	 * @param companyId the company ID of this caste category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this caste category.
	 *
	 * @return the user ID of this caste category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this caste category.
	 *
	 * @param userId the user ID of this caste category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this caste category.
	 *
	 * @return the user uuid of this caste category
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this caste category.
	 *
	 * @param userUuid the user uuid of this caste category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this caste category.
	 *
	 * @return the user name of this caste category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this caste category.
	 *
	 * @param userName the user name of this caste category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this caste category.
	 *
	 * @return the create date of this caste category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this caste category.
	 *
	 * @param createDate the create date of this caste category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this caste category.
	 *
	 * @return the modified date of this caste category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this caste category.
	 *
	 * @param modifiedDate the modified date of this caste category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this caste category.
	 *
	 * @return the code of this caste category
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this caste category.
	 *
	 * @param code the code of this caste category
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this caste category.
	 *
	 * @return the name of this caste category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this caste category.
	 *
	 * @param name the name of this caste category
	 */
	public void setName(String name);

	/**
	 * Returns the deleted of this caste category.
	 *
	 * @return the deleted of this caste category
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this caste category is deleted.
	 *
	 * @return <code>true</code> if this caste category is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this caste category is deleted.
	 *
	 * @param deleted the deleted of this caste category
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this caste category.
	 *
	 * @return the status of this caste category
	 */
	public int getStatus();

	/**
	 * Sets the status of this caste category.
	 *
	 * @param status the status of this caste category
	 */
	public void setStatus(int status);

}