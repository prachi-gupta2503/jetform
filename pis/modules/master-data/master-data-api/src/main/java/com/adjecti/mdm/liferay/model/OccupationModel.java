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
 * The base model interface for the Occupation service. Represents a row in the &quot;mdm_Occupation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.OccupationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.OccupationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Occupation
 * @generated
 */
@ProviderType
public interface OccupationModel
	extends BaseModel<Occupation>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a occupation model instance should use the {@link Occupation} interface instead.
	 */

	/**
	 * Returns the primary key of this occupation.
	 *
	 * @return the primary key of this occupation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this occupation.
	 *
	 * @param primaryKey the primary key of this occupation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the occupation ID of this occupation.
	 *
	 * @return the occupation ID of this occupation
	 */
	public long getOccupationId();

	/**
	 * Sets the occupation ID of this occupation.
	 *
	 * @param occupationId the occupation ID of this occupation
	 */
	public void setOccupationId(long occupationId);

	/**
	 * Returns the group ID of this occupation.
	 *
	 * @return the group ID of this occupation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this occupation.
	 *
	 * @param groupId the group ID of this occupation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this occupation.
	 *
	 * @return the company ID of this occupation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this occupation.
	 *
	 * @param companyId the company ID of this occupation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this occupation.
	 *
	 * @return the user ID of this occupation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this occupation.
	 *
	 * @param userId the user ID of this occupation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this occupation.
	 *
	 * @return the user uuid of this occupation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this occupation.
	 *
	 * @param userUuid the user uuid of this occupation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this occupation.
	 *
	 * @return the user name of this occupation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this occupation.
	 *
	 * @param userName the user name of this occupation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this occupation.
	 *
	 * @return the create date of this occupation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this occupation.
	 *
	 * @param createDate the create date of this occupation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this occupation.
	 *
	 * @return the modified date of this occupation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this occupation.
	 *
	 * @param modifiedDate the modified date of this occupation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this occupation.
	 *
	 * @return the code of this occupation
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this occupation.
	 *
	 * @param code the code of this occupation
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this occupation.
	 *
	 * @return the name of this occupation
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this occupation.
	 *
	 * @param name the name of this occupation
	 */
	public void setName(String name);

	/**
	 * Returns the deleted of this occupation.
	 *
	 * @return the deleted of this occupation
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this occupation is deleted.
	 *
	 * @return <code>true</code> if this occupation is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this occupation is deleted.
	 *
	 * @param deleted the deleted of this occupation
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this occupation.
	 *
	 * @return the status of this occupation
	 */
	public int getStatus();

	/**
	 * Sets the status of this occupation.
	 *
	 * @param status the status of this occupation
	 */
	public void setStatus(int status);

}