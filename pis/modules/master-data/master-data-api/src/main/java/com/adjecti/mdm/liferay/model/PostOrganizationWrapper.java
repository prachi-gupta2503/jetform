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
 * This class is a wrapper for {@link PostOrganization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostOrganization
 * @generated
 */
public class PostOrganizationWrapper
	extends BaseModelWrapper<PostOrganization>
	implements ModelWrapper<PostOrganization>, PostOrganization {

	public PostOrganizationWrapper(PostOrganization postOrganization) {
		super(postOrganization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postOrganizationId", getPostOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("postId", getPostId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("postBox", isPostBox());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postOrganizationId = (Long)attributes.get("postOrganizationId");

		if (postOrganizationId != null) {
			setPostOrganizationId(postOrganizationId);
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

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Boolean postBox = (Boolean)attributes.get("postBox");

		if (postBox != null) {
			setPostBox(postBox);
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
	 * Returns the company ID of this post organization.
	 *
	 * @return the company ID of this post organization
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this post organization.
	 *
	 * @return the create date of this post organization
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this post organization.
	 *
	 * @return the deleted of this post organization
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this post organization.
	 *
	 * @return the group ID of this post organization
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this post organization.
	 *
	 * @return the modified date of this post organization
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this post organization.
	 *
	 * @return the organization ID of this post organization
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the post box of this post organization.
	 *
	 * @return the post box of this post organization
	 */
	@Override
	public boolean getPostBox() {
		return model.getPostBox();
	}

	/**
	 * Returns the post ID of this post organization.
	 *
	 * @return the post ID of this post organization
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the post organization ID of this post organization.
	 *
	 * @return the post organization ID of this post organization
	 */
	@Override
	public long getPostOrganizationId() {
		return model.getPostOrganizationId();
	}

	/**
	 * Returns the primary key of this post organization.
	 *
	 * @return the primary key of this post organization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this post organization.
	 *
	 * @return the status of this post organization
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this post organization.
	 *
	 * @return the user ID of this post organization
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this post organization.
	 *
	 * @return the user name of this post organization
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this post organization.
	 *
	 * @return the user uuid of this post organization
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this post organization is deleted.
	 *
	 * @return <code>true</code> if this post organization is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	/**
	 * Returns <code>true</code> if this post organization is post box.
	 *
	 * @return <code>true</code> if this post organization is post box; <code>false</code> otherwise
	 */
	@Override
	public boolean isPostBox() {
		return model.isPostBox();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this post organization.
	 *
	 * @param companyId the company ID of this post organization
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this post organization.
	 *
	 * @param createDate the create date of this post organization
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this post organization is deleted.
	 *
	 * @param deleted the deleted of this post organization
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this post organization.
	 *
	 * @param groupId the group ID of this post organization
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this post organization.
	 *
	 * @param modifiedDate the modified date of this post organization
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this post organization.
	 *
	 * @param organizationId the organization ID of this post organization
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets whether this post organization is post box.
	 *
	 * @param postBox the post box of this post organization
	 */
	@Override
	public void setPostBox(boolean postBox) {
		model.setPostBox(postBox);
	}

	/**
	 * Sets the post ID of this post organization.
	 *
	 * @param postId the post ID of this post organization
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the post organization ID of this post organization.
	 *
	 * @param postOrganizationId the post organization ID of this post organization
	 */
	@Override
	public void setPostOrganizationId(long postOrganizationId) {
		model.setPostOrganizationId(postOrganizationId);
	}

	/**
	 * Sets the primary key of this post organization.
	 *
	 * @param primaryKey the primary key of this post organization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this post organization.
	 *
	 * @param status the status of this post organization
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this post organization.
	 *
	 * @param userId the user ID of this post organization
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this post organization.
	 *
	 * @param userName the user name of this post organization
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this post organization.
	 *
	 * @param userUuid the user uuid of this post organization
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PostOrganizationWrapper wrap(PostOrganization postOrganization) {
		return new PostOrganizationWrapper(postOrganization);
	}

}