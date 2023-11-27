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

package com.adjecti.jetform.liferay.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormDefinition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinition
 * @generated
 */
public class FormDefinitionWrapper
	extends BaseModelWrapper<FormDefinition>
	implements FormDefinition, ModelWrapper<FormDefinition> {

	public FormDefinitionWrapper(FormDefinition formDefinition) {
		super(formDefinition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("formDefinitionId", getFormDefinitionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("formKey", getFormKey());
		attributes.put("formClass", getFormClass());
		attributes.put("entityClass", getEntityClass());
		attributes.put("definition", getDefinition());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long formDefinitionId = (Long)attributes.get("formDefinitionId");

		if (formDefinitionId != null) {
			setFormDefinitionId(formDefinitionId);
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

		String formKey = (String)attributes.get("formKey");

		if (formKey != null) {
			setFormKey(formKey);
		}

		String formClass = (String)attributes.get("formClass");

		if (formClass != null) {
			setFormClass(formClass);
		}

		String entityClass = (String)attributes.get("entityClass");

		if (entityClass != null) {
			setEntityClass(entityClass);
		}

		String definition = (String)attributes.get("definition");

		if (definition != null) {
			setDefinition(definition);
		}
	}

	/**
	 * Returns the company ID of this form definition.
	 *
	 * @return the company ID of this form definition
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this form definition.
	 *
	 * @return the create date of this form definition
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the definition of this form definition.
	 *
	 * @return the definition of this form definition
	 */
	@Override
	public String getDefinition() {
		return model.getDefinition();
	}

	/**
	 * Returns the entity class of this form definition.
	 *
	 * @return the entity class of this form definition
	 */
	@Override
	public String getEntityClass() {
		return model.getEntityClass();
	}

	/**
	 * Returns the form class of this form definition.
	 *
	 * @return the form class of this form definition
	 */
	@Override
	public String getFormClass() {
		return model.getFormClass();
	}

	/**
	 * Returns the form definition ID of this form definition.
	 *
	 * @return the form definition ID of this form definition
	 */
	@Override
	public long getFormDefinitionId() {
		return model.getFormDefinitionId();
	}

	/**
	 * Returns the form key of this form definition.
	 *
	 * @return the form key of this form definition
	 */
	@Override
	public String getFormKey() {
		return model.getFormKey();
	}

	/**
	 * Returns the group ID of this form definition.
	 *
	 * @return the group ID of this form definition
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this form definition.
	 *
	 * @return the modified date of this form definition
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this form definition.
	 *
	 * @return the primary key of this form definition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this form definition.
	 *
	 * @return the user ID of this form definition
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this form definition.
	 *
	 * @return the user name of this form definition
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this form definition.
	 *
	 * @return the user uuid of this form definition
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this form definition.
	 *
	 * @return the uuid of this form definition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this form definition.
	 *
	 * @param companyId the company ID of this form definition
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this form definition.
	 *
	 * @param createDate the create date of this form definition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the definition of this form definition.
	 *
	 * @param definition the definition of this form definition
	 */
	@Override
	public void setDefinition(String definition) {
		model.setDefinition(definition);
	}

	/**
	 * Sets the entity class of this form definition.
	 *
	 * @param entityClass the entity class of this form definition
	 */
	@Override
	public void setEntityClass(String entityClass) {
		model.setEntityClass(entityClass);
	}

	/**
	 * Sets the form class of this form definition.
	 *
	 * @param formClass the form class of this form definition
	 */
	@Override
	public void setFormClass(String formClass) {
		model.setFormClass(formClass);
	}

	/**
	 * Sets the form definition ID of this form definition.
	 *
	 * @param formDefinitionId the form definition ID of this form definition
	 */
	@Override
	public void setFormDefinitionId(long formDefinitionId) {
		model.setFormDefinitionId(formDefinitionId);
	}

	/**
	 * Sets the form key of this form definition.
	 *
	 * @param formKey the form key of this form definition
	 */
	@Override
	public void setFormKey(String formKey) {
		model.setFormKey(formKey);
	}

	/**
	 * Sets the group ID of this form definition.
	 *
	 * @param groupId the group ID of this form definition
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this form definition.
	 *
	 * @param modifiedDate the modified date of this form definition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this form definition.
	 *
	 * @param primaryKey the primary key of this form definition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this form definition.
	 *
	 * @param userId the user ID of this form definition
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this form definition.
	 *
	 * @param userName the user name of this form definition
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this form definition.
	 *
	 * @param userUuid the user uuid of this form definition
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this form definition.
	 *
	 * @param uuid the uuid of this form definition
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
	protected FormDefinitionWrapper wrap(FormDefinition formDefinition) {
		return new FormDefinitionWrapper(formDefinition);
	}

}