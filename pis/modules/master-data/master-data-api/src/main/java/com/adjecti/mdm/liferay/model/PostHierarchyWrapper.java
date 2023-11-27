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
 * This class is a wrapper for {@link PostHierarchy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostHierarchy
 * @generated
 */
public class PostHierarchyWrapper
	extends BaseModelWrapper<PostHierarchy>
	implements ModelWrapper<PostHierarchy>, PostHierarchy {

	public PostHierarchyWrapper(PostHierarchy postHierarchy) {
		super(postHierarchy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postHierarchyId", getPostHierarchyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lowerPostId", getLowerPostId());
		attributes.put("upperPostId", getUpperPostId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postHierarchyId = (Long)attributes.get("postHierarchyId");

		if (postHierarchyId != null) {
			setPostHierarchyId(postHierarchyId);
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

		Long lowerPostId = (Long)attributes.get("lowerPostId");

		if (lowerPostId != null) {
			setLowerPostId(lowerPostId);
		}

		Long upperPostId = (Long)attributes.get("upperPostId");

		if (upperPostId != null) {
			setUpperPostId(upperPostId);
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
	 * Returns the company ID of this post hierarchy.
	 *
	 * @return the company ID of this post hierarchy
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this post hierarchy.
	 *
	 * @return the create date of this post hierarchy
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this post hierarchy.
	 *
	 * @return the deleted of this post hierarchy
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this post hierarchy.
	 *
	 * @return the group ID of this post hierarchy
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lower post ID of this post hierarchy.
	 *
	 * @return the lower post ID of this post hierarchy
	 */
	@Override
	public long getLowerPostId() {
		return model.getLowerPostId();
	}

	/**
	 * Returns the modified date of this post hierarchy.
	 *
	 * @return the modified date of this post hierarchy
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the post hierarchy ID of this post hierarchy.
	 *
	 * @return the post hierarchy ID of this post hierarchy
	 */
	@Override
	public long getPostHierarchyId() {
		return model.getPostHierarchyId();
	}

	/**
	 * Returns the primary key of this post hierarchy.
	 *
	 * @return the primary key of this post hierarchy
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this post hierarchy.
	 *
	 * @return the status of this post hierarchy
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the upper post ID of this post hierarchy.
	 *
	 * @return the upper post ID of this post hierarchy
	 */
	@Override
	public long getUpperPostId() {
		return model.getUpperPostId();
	}

	/**
	 * Returns the user ID of this post hierarchy.
	 *
	 * @return the user ID of this post hierarchy
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this post hierarchy.
	 *
	 * @return the user name of this post hierarchy
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this post hierarchy.
	 *
	 * @return the user uuid of this post hierarchy
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this post hierarchy is deleted.
	 *
	 * @return <code>true</code> if this post hierarchy is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this post hierarchy.
	 *
	 * @param companyId the company ID of this post hierarchy
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this post hierarchy.
	 *
	 * @param createDate the create date of this post hierarchy
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this post hierarchy is deleted.
	 *
	 * @param deleted the deleted of this post hierarchy
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this post hierarchy.
	 *
	 * @param groupId the group ID of this post hierarchy
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lower post ID of this post hierarchy.
	 *
	 * @param lowerPostId the lower post ID of this post hierarchy
	 */
	@Override
	public void setLowerPostId(long lowerPostId) {
		model.setLowerPostId(lowerPostId);
	}

	/**
	 * Sets the modified date of this post hierarchy.
	 *
	 * @param modifiedDate the modified date of this post hierarchy
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the post hierarchy ID of this post hierarchy.
	 *
	 * @param postHierarchyId the post hierarchy ID of this post hierarchy
	 */
	@Override
	public void setPostHierarchyId(long postHierarchyId) {
		model.setPostHierarchyId(postHierarchyId);
	}

	/**
	 * Sets the primary key of this post hierarchy.
	 *
	 * @param primaryKey the primary key of this post hierarchy
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this post hierarchy.
	 *
	 * @param status the status of this post hierarchy
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the upper post ID of this post hierarchy.
	 *
	 * @param upperPostId the upper post ID of this post hierarchy
	 */
	@Override
	public void setUpperPostId(long upperPostId) {
		model.setUpperPostId(upperPostId);
	}

	/**
	 * Sets the user ID of this post hierarchy.
	 *
	 * @param userId the user ID of this post hierarchy
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this post hierarchy.
	 *
	 * @param userName the user name of this post hierarchy
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this post hierarchy.
	 *
	 * @param userUuid the user uuid of this post hierarchy
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PostHierarchyWrapper wrap(PostHierarchy postHierarchy) {
		return new PostHierarchyWrapper(postHierarchy);
	}

}