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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EntityWorkflow}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityWorkflow
 * @generated
 */
public class EntityWorkflowWrapper
	extends BaseModelWrapper<EntityWorkflow>
	implements EntityWorkflow, ModelWrapper<EntityWorkflow> {

	public EntityWorkflowWrapper(EntityWorkflow entityWorkflow) {
		super(entityWorkflow);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entityWorkflowId", getEntityWorkflowId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("remark", getRemark());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entityWorkflowId = (Long)attributes.get("entityWorkflowId");

		if (entityWorkflowId != null) {
			setEntityWorkflowId(entityWorkflowId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}
	}

	/**
	 * Returns the class name of this entity workflow.
	 *
	 * @return the class name of this entity workflow
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this entity workflow.
	 *
	 * @return the class pk of this entity workflow
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this entity workflow.
	 *
	 * @return the company ID of this entity workflow
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this entity workflow.
	 *
	 * @return the create date of this entity workflow
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity workflow ID of this entity workflow.
	 *
	 * @return the entity workflow ID of this entity workflow
	 */
	@Override
	public long getEntityWorkflowId() {
		return model.getEntityWorkflowId();
	}

	/**
	 * Returns the group ID of this entity workflow.
	 *
	 * @return the group ID of this entity workflow
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this entity workflow.
	 *
	 * @return the modified date of this entity workflow
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this entity workflow.
	 *
	 * @return the primary key of this entity workflow
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remark of this entity workflow.
	 *
	 * @return the remark of this entity workflow
	 */
	@Override
	public String getRemark() {
		return model.getRemark();
	}

	/**
	 * Returns the status of this entity workflow.
	 *
	 * @return the status of this entity workflow
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this entity workflow.
	 *
	 * @return the user ID of this entity workflow
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this entity workflow.
	 *
	 * @return the user name of this entity workflow
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this entity workflow.
	 *
	 * @return the user uuid of this entity workflow
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class name of this entity workflow.
	 *
	 * @param className the class name of this entity workflow
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this entity workflow.
	 *
	 * @param classPK the class pk of this entity workflow
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this entity workflow.
	 *
	 * @param companyId the company ID of this entity workflow
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this entity workflow.
	 *
	 * @param createDate the create date of this entity workflow
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity workflow ID of this entity workflow.
	 *
	 * @param entityWorkflowId the entity workflow ID of this entity workflow
	 */
	@Override
	public void setEntityWorkflowId(long entityWorkflowId) {
		model.setEntityWorkflowId(entityWorkflowId);
	}

	/**
	 * Sets the group ID of this entity workflow.
	 *
	 * @param groupId the group ID of this entity workflow
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this entity workflow.
	 *
	 * @param modifiedDate the modified date of this entity workflow
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this entity workflow.
	 *
	 * @param primaryKey the primary key of this entity workflow
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remark of this entity workflow.
	 *
	 * @param remark the remark of this entity workflow
	 */
	@Override
	public void setRemark(String remark) {
		model.setRemark(remark);
	}

	/**
	 * Sets the status of this entity workflow.
	 *
	 * @param status the status of this entity workflow
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this entity workflow.
	 *
	 * @param userId the user ID of this entity workflow
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this entity workflow.
	 *
	 * @param userName the user name of this entity workflow
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this entity workflow.
	 *
	 * @param userUuid the user uuid of this entity workflow
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EntityWorkflowWrapper wrap(EntityWorkflow entityWorkflow) {
		return new EntityWorkflowWrapper(entityWorkflow);
	}

}