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
 * This class is a wrapper for {@link MasterEntity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterEntity
 * @generated
 */
public class MasterEntityWrapper
	extends BaseModelWrapper<MasterEntity>
	implements MasterEntity, ModelWrapper<MasterEntity> {

	public MasterEntityWrapper(MasterEntity masterEntity) {
		super(masterEntity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterEntityId", getMasterEntityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("entityClass", getEntityClass());
		attributes.put("icon", getIcon());
		attributes.put("link", getLink());
		attributes.put("description", getDescription());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterEntityId = (Long)attributes.get("masterEntityId");

		if (masterEntityId != null) {
			setMasterEntityId(masterEntityId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String entityClass = (String)attributes.get("entityClass");

		if (entityClass != null) {
			setEntityClass(entityClass);
		}

		String icon = (String)attributes.get("icon");

		if (icon != null) {
			setIcon(icon);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
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
	 * Returns the company ID of this master entity.
	 *
	 * @return the company ID of this master entity
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master entity.
	 *
	 * @return the create date of this master entity
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this master entity.
	 *
	 * @return the deleted of this master entity
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the description of this master entity.
	 *
	 * @return the description of this master entity
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the entity class of this master entity.
	 *
	 * @return the entity class of this master entity
	 */
	@Override
	public String getEntityClass() {
		return model.getEntityClass();
	}

	/**
	 * Returns the group ID of this master entity.
	 *
	 * @return the group ID of this master entity
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the icon of this master entity.
	 *
	 * @return the icon of this master entity
	 */
	@Override
	public String getIcon() {
		return model.getIcon();
	}

	/**
	 * Returns the link of this master entity.
	 *
	 * @return the link of this master entity
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the master entity ID of this master entity.
	 *
	 * @return the master entity ID of this master entity
	 */
	@Override
	public long getMasterEntityId() {
		return model.getMasterEntityId();
	}

	/**
	 * Returns the modified date of this master entity.
	 *
	 * @return the modified date of this master entity
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master entity.
	 *
	 * @return the name of this master entity
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master entity.
	 *
	 * @return the primary key of this master entity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this master entity.
	 *
	 * @return the status of this master entity
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this master entity.
	 *
	 * @return the user ID of this master entity
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master entity.
	 *
	 * @return the user name of this master entity
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master entity.
	 *
	 * @return the user uuid of this master entity
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this master entity is deleted.
	 *
	 * @return <code>true</code> if this master entity is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this master entity.
	 *
	 * @param companyId the company ID of this master entity
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master entity.
	 *
	 * @param createDate the create date of this master entity
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this master entity is deleted.
	 *
	 * @param deleted the deleted of this master entity
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the description of this master entity.
	 *
	 * @param description the description of this master entity
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the entity class of this master entity.
	 *
	 * @param entityClass the entity class of this master entity
	 */
	@Override
	public void setEntityClass(String entityClass) {
		model.setEntityClass(entityClass);
	}

	/**
	 * Sets the group ID of this master entity.
	 *
	 * @param groupId the group ID of this master entity
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the icon of this master entity.
	 *
	 * @param icon the icon of this master entity
	 */
	@Override
	public void setIcon(String icon) {
		model.setIcon(icon);
	}

	/**
	 * Sets the link of this master entity.
	 *
	 * @param link the link of this master entity
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the master entity ID of this master entity.
	 *
	 * @param masterEntityId the master entity ID of this master entity
	 */
	@Override
	public void setMasterEntityId(long masterEntityId) {
		model.setMasterEntityId(masterEntityId);
	}

	/**
	 * Sets the modified date of this master entity.
	 *
	 * @param modifiedDate the modified date of this master entity
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master entity.
	 *
	 * @param name the name of this master entity
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master entity.
	 *
	 * @param primaryKey the primary key of this master entity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this master entity.
	 *
	 * @param status the status of this master entity
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this master entity.
	 *
	 * @param userId the user ID of this master entity
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master entity.
	 *
	 * @param userName the user name of this master entity
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master entity.
	 *
	 * @param userUuid the user uuid of this master entity
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterEntityWrapper wrap(MasterEntity masterEntity) {
		return new MasterEntityWrapper(masterEntity);
	}

}