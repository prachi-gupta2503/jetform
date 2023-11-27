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

package com.adj.userportlet.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserPortlet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPortlet
 * @generated
 */
public class UserPortletWrapper
	extends BaseModelWrapper<UserPortlet>
	implements ModelWrapper<UserPortlet>, UserPortlet {

	public UserPortletWrapper(UserPortlet userPortlet) {
		super(userPortlet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("portletId", getPortletId());
		attributes.put("thumbnail", getThumbnail());
		attributes.put("added", isAdded());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String thumbnail = (String)attributes.get("thumbnail");

		if (thumbnail != null) {
			setThumbnail(thumbnail);
		}

		Boolean added = (Boolean)attributes.get("added");

		if (added != null) {
			setAdded(added);
		}
	}

	/**
	 * Returns the added of this user portlet.
	 *
	 * @return the added of this user portlet
	 */
	@Override
	public boolean getAdded() {
		return model.getAdded();
	}

	/**
	 * Returns the company ID of this user portlet.
	 *
	 * @return the company ID of this user portlet
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user portlet.
	 *
	 * @return the create date of this user portlet
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this user portlet.
	 *
	 * @return the group ID of this user portlet
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this user portlet.
	 *
	 * @return the ID of this user portlet
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this user portlet.
	 *
	 * @return the modified date of this user portlet
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the portlet ID of this user portlet.
	 *
	 * @return the portlet ID of this user portlet
	 */
	@Override
	public String getPortletId() {
		return model.getPortletId();
	}

	/**
	 * Returns the primary key of this user portlet.
	 *
	 * @return the primary key of this user portlet
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the thumbnail of this user portlet.
	 *
	 * @return the thumbnail of this user portlet
	 */
	@Override
	public String getThumbnail() {
		return model.getThumbnail();
	}

	/**
	 * Returns the user ID of this user portlet.
	 *
	 * @return the user ID of this user portlet
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user portlet.
	 *
	 * @return the user name of this user portlet
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this user portlet.
	 *
	 * @return the user uuid of this user portlet
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user portlet.
	 *
	 * @return the uuid of this user portlet
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this user portlet is added.
	 *
	 * @return <code>true</code> if this user portlet is added; <code>false</code> otherwise
	 */
	@Override
	public boolean isAdded() {
		return model.isAdded();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this user portlet is added.
	 *
	 * @param added the added of this user portlet
	 */
	@Override
	public void setAdded(boolean added) {
		model.setAdded(added);
	}

	/**
	 * Sets the company ID of this user portlet.
	 *
	 * @param companyId the company ID of this user portlet
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user portlet.
	 *
	 * @param createDate the create date of this user portlet
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this user portlet.
	 *
	 * @param groupId the group ID of this user portlet
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this user portlet.
	 *
	 * @param id the ID of this user portlet
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this user portlet.
	 *
	 * @param modifiedDate the modified date of this user portlet
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the portlet ID of this user portlet.
	 *
	 * @param portletId the portlet ID of this user portlet
	 */
	@Override
	public void setPortletId(String portletId) {
		model.setPortletId(portletId);
	}

	/**
	 * Sets the primary key of this user portlet.
	 *
	 * @param primaryKey the primary key of this user portlet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the thumbnail of this user portlet.
	 *
	 * @param thumbnail the thumbnail of this user portlet
	 */
	@Override
	public void setThumbnail(String thumbnail) {
		model.setThumbnail(thumbnail);
	}

	/**
	 * Sets the user ID of this user portlet.
	 *
	 * @param userId the user ID of this user portlet
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user portlet.
	 *
	 * @param userName the user name of this user portlet
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this user portlet.
	 *
	 * @param userUuid the user uuid of this user portlet
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user portlet.
	 *
	 * @param uuid the uuid of this user portlet
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected UserPortletWrapper wrap(UserPortlet userPortlet) {
		return new UserPortletWrapper(userPortlet);
	}

}