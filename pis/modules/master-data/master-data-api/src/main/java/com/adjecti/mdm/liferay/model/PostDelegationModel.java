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
 * The base model interface for the PostDelegation service. Represents a row in the &quot;mdm_PostDelegation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.PostDelegationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.PostDelegationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostDelegation
 * @generated
 */
@ProviderType
public interface PostDelegationModel
	extends BaseModel<PostDelegation>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a post delegation model instance should use the {@link PostDelegation} interface instead.
	 */

	/**
	 * Returns the primary key of this post delegation.
	 *
	 * @return the primary key of this post delegation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this post delegation.
	 *
	 * @param primaryKey the primary key of this post delegation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the post delegation ID of this post delegation.
	 *
	 * @return the post delegation ID of this post delegation
	 */
	public long getPostDelegationId();

	/**
	 * Sets the post delegation ID of this post delegation.
	 *
	 * @param postDelegationId the post delegation ID of this post delegation
	 */
	public void setPostDelegationId(long postDelegationId);

	/**
	 * Returns the group ID of this post delegation.
	 *
	 * @return the group ID of this post delegation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this post delegation.
	 *
	 * @param groupId the group ID of this post delegation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this post delegation.
	 *
	 * @return the company ID of this post delegation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this post delegation.
	 *
	 * @param companyId the company ID of this post delegation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this post delegation.
	 *
	 * @return the user ID of this post delegation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this post delegation.
	 *
	 * @param userId the user ID of this post delegation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this post delegation.
	 *
	 * @return the user uuid of this post delegation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this post delegation.
	 *
	 * @param userUuid the user uuid of this post delegation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this post delegation.
	 *
	 * @return the user name of this post delegation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this post delegation.
	 *
	 * @param userName the user name of this post delegation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this post delegation.
	 *
	 * @return the create date of this post delegation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this post delegation.
	 *
	 * @param createDate the create date of this post delegation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this post delegation.
	 *
	 * @return the modified date of this post delegation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this post delegation.
	 *
	 * @param modifiedDate the modified date of this post delegation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the delegation type of this post delegation.
	 *
	 * @return the delegation type of this post delegation
	 */
	@AutoEscape
	public String getDelegationType();

	/**
	 * Sets the delegation type of this post delegation.
	 *
	 * @param delegationType the delegation type of this post delegation
	 */
	public void setDelegationType(String delegationType);

	/**
	 * Returns the delegated post ID of this post delegation.
	 *
	 * @return the delegated post ID of this post delegation
	 */
	public long getDelegatedPostId();

	/**
	 * Sets the delegated post ID of this post delegation.
	 *
	 * @param delegatedPostId the delegated post ID of this post delegation
	 */
	public void setDelegatedPostId(long delegatedPostId);

	/**
	 * Returns the post ID of this post delegation.
	 *
	 * @return the post ID of this post delegation
	 */
	public long getPostId();

	/**
	 * Sets the post ID of this post delegation.
	 *
	 * @param postId the post ID of this post delegation
	 */
	public void setPostId(long postId);

	/**
	 * Returns the deleted of this post delegation.
	 *
	 * @return the deleted of this post delegation
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this post delegation is deleted.
	 *
	 * @return <code>true</code> if this post delegation is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this post delegation is deleted.
	 *
	 * @param deleted the deleted of this post delegation
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this post delegation.
	 *
	 * @return the status of this post delegation
	 */
	public int getStatus();

	/**
	 * Sets the status of this post delegation.
	 *
	 * @param status the status of this post delegation
	 */
	public void setStatus(int status);

}