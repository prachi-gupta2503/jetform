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
 * This class is a wrapper for {@link Post}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Post
 * @generated
 */
public class PostWrapper
	extends BaseModelWrapper<Post> implements ModelWrapper<Post>, Post {

	public PostWrapper(Post post) {
		super(post);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postId", getPostId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name_En", getName_En());
		attributes.put("name_Hi", getName_Hi());
		attributes.put("designationId", getDesignationId());
		attributes.put("postBox", isPostBox());
		attributes.put("description", getDescription());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name_En = (String)attributes.get("name_En");

		if (name_En != null) {
			setName_En(name_En);
		}

		String name_Hi = (String)attributes.get("name_Hi");

		if (name_Hi != null) {
			setName_Hi(name_Hi);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Boolean postBox = (Boolean)attributes.get("postBox");

		if (postBox != null) {
			setPostBox(postBox);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	 * Returns the code of this post.
	 *
	 * @return the code of this post
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this post.
	 *
	 * @return the company ID of this post
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this post.
	 *
	 * @return the create date of this post
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this post.
	 *
	 * @return the deleted of this post
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this post.
	 *
	 * @return the description of this post
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the designation ID of this post.
	 *
	 * @return the designation ID of this post
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the group ID of this post.
	 *
	 * @return the group ID of this post
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this post.
	 *
	 * @return the modified date of this post
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name_ en of this post.
	 *
	 * @return the name_ en of this post
	 */
	@Override
	public String getName_En() {
		return model.getName_En();
	}

	/**
	 * Returns the name_ hi of this post.
	 *
	 * @return the name_ hi of this post
	 */
	@Override
	public String getName_Hi() {
		return model.getName_Hi();
	}

	/**
	 * Returns the post box of this post.
	 *
	 * @return the post box of this post
	 */
	@Override
	public boolean getPostBox() {
		return model.getPostBox();
	}

	/**
	 * Returns the post ID of this post.
	 *
	 * @return the post ID of this post
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this post.
	 *
	 * @return the primary key of this post
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this post.
	 *
	 * @return the status of this post
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this post.
	 *
	 * @return the user ID of this post
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this post.
	 *
	 * @return the user name of this post
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this post.
	 *
	 * @return the user uuid of this post
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this post is deleted.
	 *
	 * @return <code>true</code> if this post is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	/**
	 * Returns <code>true</code> if this post is post box.
	 *
	 * @return <code>true</code> if this post is post box; <code>false</code> otherwise
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
	 * Sets the code of this post.
	 *
	 * @param code the code of this post
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this post.
	 *
	 * @param companyId the company ID of this post
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this post.
	 *
	 * @param createDate the create date of this post
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this post is deleted.
	 *
	 * @param deleted the deleted of this post
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this post.
	 *
	 * @param description the description of this post
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the designation ID of this post.
	 *
	 * @param designationId the designation ID of this post
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the group ID of this post.
	 *
	 * @param groupId the group ID of this post
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this post.
	 *
	 * @param modifiedDate the modified date of this post
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name_ en of this post.
	 *
	 * @param name_En the name_ en of this post
	 */
	@Override
	public void setName_En(String name_En) {
		model.setName_En(name_En);
	}

	/**
	 * Sets the name_ hi of this post.
	 *
	 * @param name_Hi the name_ hi of this post
	 */
	@Override
	public void setName_Hi(String name_Hi) {
		model.setName_Hi(name_Hi);
	}

	/**
	 * Sets whether this post is post box.
	 *
	 * @param postBox the post box of this post
	 */
	@Override
	public void setPostBox(boolean postBox) {
		model.setPostBox(postBox);
	}

	/**
	 * Sets the post ID of this post.
	 *
	 * @param postId the post ID of this post
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this post.
	 *
	 * @param primaryKey the primary key of this post
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this post.
	 *
	 * @param status the status of this post
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this post.
	 *
	 * @param userId the user ID of this post
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this post.
	 *
	 * @param userName the user name of this post
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this post.
	 *
	 * @param userUuid the user uuid of this post
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PostWrapper wrap(Post post) {
		return new PostWrapper(post);
	}

}