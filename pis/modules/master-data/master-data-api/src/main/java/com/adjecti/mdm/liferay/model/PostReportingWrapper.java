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
 * This class is a wrapper for {@link PostReporting}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostReporting
 * @generated
 */
public class PostReportingWrapper
	extends BaseModelWrapper<PostReporting>
	implements ModelWrapper<PostReporting>, PostReporting {

	public PostReportingWrapper(PostReporting postReporting) {
		super(postReporting);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postReportingId", getPostReportingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reporteePostId", getReporteePostId());
		attributes.put("reporterPostId", getReporterPostId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postReportingId = (Long)attributes.get("postReportingId");

		if (postReportingId != null) {
			setPostReportingId(postReportingId);
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

		Long reporteePostId = (Long)attributes.get("reporteePostId");

		if (reporteePostId != null) {
			setReporteePostId(reporteePostId);
		}

		Long reporterPostId = (Long)attributes.get("reporterPostId");

		if (reporterPostId != null) {
			setReporterPostId(reporterPostId);
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
	 * Returns the company ID of this post reporting.
	 *
	 * @return the company ID of this post reporting
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this post reporting.
	 *
	 * @return the create date of this post reporting
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this post reporting.
	 *
	 * @return the deleted of this post reporting
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this post reporting.
	 *
	 * @return the group ID of this post reporting
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this post reporting.
	 *
	 * @return the modified date of this post reporting
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the post reporting ID of this post reporting.
	 *
	 * @return the post reporting ID of this post reporting
	 */
	@Override
	public long getPostReportingId() {
		return model.getPostReportingId();
	}

	/**
	 * Returns the primary key of this post reporting.
	 *
	 * @return the primary key of this post reporting
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reportee post ID of this post reporting.
	 *
	 * @return the reportee post ID of this post reporting
	 */
	@Override
	public long getReporteePostId() {
		return model.getReporteePostId();
	}

	/**
	 * Returns the reporter post ID of this post reporting.
	 *
	 * @return the reporter post ID of this post reporting
	 */
	@Override
	public long getReporterPostId() {
		return model.getReporterPostId();
	}

	/**
	 * Returns the status of this post reporting.
	 *
	 * @return the status of this post reporting
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this post reporting.
	 *
	 * @return the user ID of this post reporting
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this post reporting.
	 *
	 * @return the user name of this post reporting
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this post reporting.
	 *
	 * @return the user uuid of this post reporting
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this post reporting is deleted.
	 *
	 * @return <code>true</code> if this post reporting is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this post reporting.
	 *
	 * @param companyId the company ID of this post reporting
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this post reporting.
	 *
	 * @param createDate the create date of this post reporting
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this post reporting is deleted.
	 *
	 * @param deleted the deleted of this post reporting
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this post reporting.
	 *
	 * @param groupId the group ID of this post reporting
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this post reporting.
	 *
	 * @param modifiedDate the modified date of this post reporting
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the post reporting ID of this post reporting.
	 *
	 * @param postReportingId the post reporting ID of this post reporting
	 */
	@Override
	public void setPostReportingId(long postReportingId) {
		model.setPostReportingId(postReportingId);
	}

	/**
	 * Sets the primary key of this post reporting.
	 *
	 * @param primaryKey the primary key of this post reporting
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reportee post ID of this post reporting.
	 *
	 * @param reporteePostId the reportee post ID of this post reporting
	 */
	@Override
	public void setReporteePostId(long reporteePostId) {
		model.setReporteePostId(reporteePostId);
	}

	/**
	 * Sets the reporter post ID of this post reporting.
	 *
	 * @param reporterPostId the reporter post ID of this post reporting
	 */
	@Override
	public void setReporterPostId(long reporterPostId) {
		model.setReporterPostId(reporterPostId);
	}

	/**
	 * Sets the status of this post reporting.
	 *
	 * @param status the status of this post reporting
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this post reporting.
	 *
	 * @param userId the user ID of this post reporting
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this post reporting.
	 *
	 * @param userName the user name of this post reporting
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this post reporting.
	 *
	 * @param userUuid the user uuid of this post reporting
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PostReportingWrapper wrap(PostReporting postReporting) {
		return new PostReportingWrapper(postReporting);
	}

}