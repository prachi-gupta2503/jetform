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
 * The base model interface for the Specialization service. Represents a row in the &quot;mdm_Specialization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.SpecializationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.SpecializationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Specialization
 * @generated
 */
@ProviderType
public interface SpecializationModel
	extends BaseModel<Specialization>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a specialization model instance should use the {@link Specialization} interface instead.
	 */

	/**
	 * Returns the primary key of this specialization.
	 *
	 * @return the primary key of this specialization
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this specialization.
	 *
	 * @param primaryKey the primary key of this specialization
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the specialization ID of this specialization.
	 *
	 * @return the specialization ID of this specialization
	 */
	public long getSpecializationId();

	/**
	 * Sets the specialization ID of this specialization.
	 *
	 * @param specializationId the specialization ID of this specialization
	 */
	public void setSpecializationId(long specializationId);

	/**
	 * Returns the group ID of this specialization.
	 *
	 * @return the group ID of this specialization
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this specialization.
	 *
	 * @param groupId the group ID of this specialization
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this specialization.
	 *
	 * @return the company ID of this specialization
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this specialization.
	 *
	 * @param companyId the company ID of this specialization
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this specialization.
	 *
	 * @return the user ID of this specialization
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this specialization.
	 *
	 * @param userId the user ID of this specialization
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this specialization.
	 *
	 * @return the user uuid of this specialization
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this specialization.
	 *
	 * @param userUuid the user uuid of this specialization
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this specialization.
	 *
	 * @return the user name of this specialization
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this specialization.
	 *
	 * @param userName the user name of this specialization
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this specialization.
	 *
	 * @return the create date of this specialization
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this specialization.
	 *
	 * @param createDate the create date of this specialization
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this specialization.
	 *
	 * @return the modified date of this specialization
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this specialization.
	 *
	 * @param modifiedDate the modified date of this specialization
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this specialization.
	 *
	 * @return the description of this specialization
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this specialization.
	 *
	 * @param description the description of this specialization
	 */
	public void setDescription(String description);

	/**
	 * Returns the name of this specialization.
	 *
	 * @return the name of this specialization
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this specialization.
	 *
	 * @param name the name of this specialization
	 */
	public void setName(String name);

	/**
	 * Returns the code of this specialization.
	 *
	 * @return the code of this specialization
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this specialization.
	 *
	 * @param code the code of this specialization
	 */
	public void setCode(String code);

	/**
	 * Returns the deleted of this specialization.
	 *
	 * @return the deleted of this specialization
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this specialization is deleted.
	 *
	 * @return <code>true</code> if this specialization is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this specialization is deleted.
	 *
	 * @param deleted the deleted of this specialization
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this specialization.
	 *
	 * @return the status of this specialization
	 */
	public int getStatus();

	/**
	 * Sets the status of this specialization.
	 *
	 * @param status the status of this specialization
	 */
	public void setStatus(int status);

}