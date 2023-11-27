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
 * The base model interface for the PostHierarchy service. Represents a row in the &quot;mdm_PostHierarchy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.PostHierarchyModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.PostHierarchyImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostHierarchy
 * @generated
 */
@ProviderType
public interface PostHierarchyModel
	extends BaseModel<PostHierarchy>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a post hierarchy model instance should use the {@link PostHierarchy} interface instead.
	 */

	/**
	 * Returns the primary key of this post hierarchy.
	 *
	 * @return the primary key of this post hierarchy
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this post hierarchy.
	 *
	 * @param primaryKey the primary key of this post hierarchy
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the post hierarchy ID of this post hierarchy.
	 *
	 * @return the post hierarchy ID of this post hierarchy
	 */
	public long getPostHierarchyId();

	/**
	 * Sets the post hierarchy ID of this post hierarchy.
	 *
	 * @param postHierarchyId the post hierarchy ID of this post hierarchy
	 */
	public void setPostHierarchyId(long postHierarchyId);

	/**
	 * Returns the group ID of this post hierarchy.
	 *
	 * @return the group ID of this post hierarchy
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this post hierarchy.
	 *
	 * @param groupId the group ID of this post hierarchy
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this post hierarchy.
	 *
	 * @return the company ID of this post hierarchy
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this post hierarchy.
	 *
	 * @param companyId the company ID of this post hierarchy
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this post hierarchy.
	 *
	 * @return the user ID of this post hierarchy
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this post hierarchy.
	 *
	 * @param userId the user ID of this post hierarchy
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this post hierarchy.
	 *
	 * @return the user uuid of this post hierarchy
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this post hierarchy.
	 *
	 * @param userUuid the user uuid of this post hierarchy
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this post hierarchy.
	 *
	 * @return the user name of this post hierarchy
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this post hierarchy.
	 *
	 * @param userName the user name of this post hierarchy
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this post hierarchy.
	 *
	 * @return the create date of this post hierarchy
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this post hierarchy.
	 *
	 * @param createDate the create date of this post hierarchy
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this post hierarchy.
	 *
	 * @return the modified date of this post hierarchy
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this post hierarchy.
	 *
	 * @param modifiedDate the modified date of this post hierarchy
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the lower post ID of this post hierarchy.
	 *
	 * @return the lower post ID of this post hierarchy
	 */
	public long getLowerPostId();

	/**
	 * Sets the lower post ID of this post hierarchy.
	 *
	 * @param lowerPostId the lower post ID of this post hierarchy
	 */
	public void setLowerPostId(long lowerPostId);

	/**
	 * Returns the upper post ID of this post hierarchy.
	 *
	 * @return the upper post ID of this post hierarchy
	 */
	public long getUpperPostId();

	/**
	 * Sets the upper post ID of this post hierarchy.
	 *
	 * @param upperPostId the upper post ID of this post hierarchy
	 */
	public void setUpperPostId(long upperPostId);

	/**
	 * Returns the deleted of this post hierarchy.
	 *
	 * @return the deleted of this post hierarchy
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this post hierarchy is deleted.
	 *
	 * @return <code>true</code> if this post hierarchy is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this post hierarchy is deleted.
	 *
	 * @param deleted the deleted of this post hierarchy
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this post hierarchy.
	 *
	 * @return the status of this post hierarchy
	 */
	public int getStatus();

	/**
	 * Sets the status of this post hierarchy.
	 *
	 * @param status the status of this post hierarchy
	 */
	public void setStatus(int status);

}