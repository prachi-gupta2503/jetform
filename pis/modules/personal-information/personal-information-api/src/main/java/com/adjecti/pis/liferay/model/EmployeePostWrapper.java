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

package com.adjecti.pis.liferay.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeePost}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePost
 * @generated
 */
public class EmployeePostWrapper
	extends BaseModelWrapper<EmployeePost>
	implements EmployeePost, ModelWrapper<EmployeePost> {

	public EmployeePostWrapper(EmployeePost employeePost) {
		super(employeePost);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeePostId", getEmployeePostId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("postId", getPostId());
		attributes.put("delegatedPostId", getDelegatedPostId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeePostId = (Long)attributes.get("employeePostId");

		if (employeePostId != null) {
			setEmployeePostId(employeePostId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long delegatedPostId = (Long)attributes.get("delegatedPostId");

		if (delegatedPostId != null) {
			setDelegatedPostId(delegatedPostId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the active of this employee post.
	 *
	 * @return the active of this employee post
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this employee post.
	 *
	 * @return the company ID of this employee post
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee post.
	 *
	 * @return the create date of this employee post
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delegated post ID of this employee post.
	 *
	 * @return the delegated post ID of this employee post
	 */
	@Override
	public long getDelegatedPostId() {
		return model.getDelegatedPostId();
	}

	/**
	 * Returns the employee ID of this employee post.
	 *
	 * @return the employee ID of this employee post
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee post ID of this employee post.
	 *
	 * @return the employee post ID of this employee post
	 */
	@Override
	public long getEmployeePostId() {
		return model.getEmployeePostId();
	}

	/**
	 * Returns the from date of this employee post.
	 *
	 * @return the from date of this employee post
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this employee post.
	 *
	 * @return the group ID of this employee post
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee post.
	 *
	 * @return the modified date of this employee post
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the post ID of this employee post.
	 *
	 * @return the post ID of this employee post
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this employee post.
	 *
	 * @return the primary key of this employee post
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee post.
	 *
	 * @return the status of this employee post
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this employee post.
	 *
	 * @return the to date of this employee post
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this employee post.
	 *
	 * @return the user ID of this employee post
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee post.
	 *
	 * @return the user name of this employee post
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee post.
	 *
	 * @return the user uuid of this employee post
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee post is active.
	 *
	 * @return <code>true</code> if this employee post is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee post is active.
	 *
	 * @param active the active of this employee post
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this employee post.
	 *
	 * @param companyId the company ID of this employee post
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee post.
	 *
	 * @param createDate the create date of this employee post
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delegated post ID of this employee post.
	 *
	 * @param delegatedPostId the delegated post ID of this employee post
	 */
	@Override
	public void setDelegatedPostId(long delegatedPostId) {
		model.setDelegatedPostId(delegatedPostId);
	}

	/**
	 * Sets the employee ID of this employee post.
	 *
	 * @param employeeId the employee ID of this employee post
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee post ID of this employee post.
	 *
	 * @param employeePostId the employee post ID of this employee post
	 */
	@Override
	public void setEmployeePostId(long employeePostId) {
		model.setEmployeePostId(employeePostId);
	}

	/**
	 * Sets the from date of this employee post.
	 *
	 * @param fromDate the from date of this employee post
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this employee post.
	 *
	 * @param groupId the group ID of this employee post
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee post.
	 *
	 * @param modifiedDate the modified date of this employee post
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the post ID of this employee post.
	 *
	 * @param postId the post ID of this employee post
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this employee post.
	 *
	 * @param primaryKey the primary key of this employee post
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this employee post.
	 *
	 * @param status the status of this employee post
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this employee post.
	 *
	 * @param toDate the to date of this employee post
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this employee post.
	 *
	 * @param userId the user ID of this employee post
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee post.
	 *
	 * @param userName the user name of this employee post
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee post.
	 *
	 * @param userUuid the user uuid of this employee post
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeePostWrapper wrap(EmployeePost employeePost) {
		return new EmployeePostWrapper(employeePost);
	}

}