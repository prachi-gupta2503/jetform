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
 * This class is a wrapper for {@link PostDelegation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostDelegation
 * @generated
 */
public class PostDelegationWrapper
	extends BaseModelWrapper<PostDelegation>
	implements ModelWrapper<PostDelegation>, PostDelegation {

	public PostDelegationWrapper(PostDelegation postDelegation) {
		super(postDelegation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postDelegationId", getPostDelegationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("delegationType", getDelegationType());
		attributes.put("delegatedPostId", getDelegatedPostId());
		attributes.put("postId", getPostId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postDelegationId = (Long)attributes.get("postDelegationId");

		if (postDelegationId != null) {
			setPostDelegationId(postDelegationId);
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

		String delegationType = (String)attributes.get("delegationType");

		if (delegationType != null) {
			setDelegationType(delegationType);
		}

		Long delegatedPostId = (Long)attributes.get("delegatedPostId");

		if (delegatedPostId != null) {
			setDelegatedPostId(delegatedPostId);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
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
	 * Returns the company ID of this post delegation.
	 *
	 * @return the company ID of this post delegation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this post delegation.
	 *
	 * @return the create date of this post delegation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delegated post ID of this post delegation.
	 *
	 * @return the delegated post ID of this post delegation
	 */
	@Override
	public long getDelegatedPostId() {
		return model.getDelegatedPostId();
	}

	/**
	 * Returns the delegation type of this post delegation.
	 *
	 * @return the delegation type of this post delegation
	 */
	@Override
	public String getDelegationType() {
		return model.getDelegationType();
	}

	/**
	 * Returns the deleted of this post delegation.
	 *
	 * @return the deleted of this post delegation
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this post delegation.
	 *
	 * @return the group ID of this post delegation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this post delegation.
	 *
	 * @return the modified date of this post delegation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the post delegation ID of this post delegation.
	 *
	 * @return the post delegation ID of this post delegation
	 */
	@Override
	public long getPostDelegationId() {
		return model.getPostDelegationId();
	}

	/**
	 * Returns the post ID of this post delegation.
	 *
	 * @return the post ID of this post delegation
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this post delegation.
	 *
	 * @return the primary key of this post delegation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this post delegation.
	 *
	 * @return the status of this post delegation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this post delegation.
	 *
	 * @return the user ID of this post delegation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this post delegation.
	 *
	 * @return the user name of this post delegation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this post delegation.
	 *
	 * @return the user uuid of this post delegation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this post delegation is deleted.
	 *
	 * @return <code>true</code> if this post delegation is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this post delegation.
	 *
	 * @param companyId the company ID of this post delegation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this post delegation.
	 *
	 * @param createDate the create date of this post delegation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delegated post ID of this post delegation.
	 *
	 * @param delegatedPostId the delegated post ID of this post delegation
	 */
	@Override
	public void setDelegatedPostId(long delegatedPostId) {
		model.setDelegatedPostId(delegatedPostId);
	}

	/**
	 * Sets the delegation type of this post delegation.
	 *
	 * @param delegationType the delegation type of this post delegation
	 */
	@Override
	public void setDelegationType(String delegationType) {
		model.setDelegationType(delegationType);
	}

	/**
	 * Sets whether this post delegation is deleted.
	 *
	 * @param deleted the deleted of this post delegation
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this post delegation.
	 *
	 * @param groupId the group ID of this post delegation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this post delegation.
	 *
	 * @param modifiedDate the modified date of this post delegation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the post delegation ID of this post delegation.
	 *
	 * @param postDelegationId the post delegation ID of this post delegation
	 */
	@Override
	public void setPostDelegationId(long postDelegationId) {
		model.setPostDelegationId(postDelegationId);
	}

	/**
	 * Sets the post ID of this post delegation.
	 *
	 * @param postId the post ID of this post delegation
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this post delegation.
	 *
	 * @param primaryKey the primary key of this post delegation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this post delegation.
	 *
	 * @param status the status of this post delegation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this post delegation.
	 *
	 * @param userId the user ID of this post delegation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this post delegation.
	 *
	 * @param userName the user name of this post delegation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this post delegation.
	 *
	 * @param userUuid the user uuid of this post delegation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PostDelegationWrapper wrap(PostDelegation postDelegation) {
		return new PostDelegationWrapper(postDelegation);
	}

}