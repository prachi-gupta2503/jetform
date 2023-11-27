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
 * This class is a wrapper for {@link DesignationScope}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationScope
 * @generated
 */
public class DesignationScopeWrapper
	extends BaseModelWrapper<DesignationScope>
	implements DesignationScope, ModelWrapper<DesignationScope> {

	public DesignationScopeWrapper(DesignationScope designationScope) {
		super(designationScope);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designationScopeId", getDesignationScopeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("designationId", getDesignationId());
		attributes.put("scopeType", getScopeType());
		attributes.put("scopeOrganizationId", getScopeOrganizationId());
		attributes.put("scopeOrganizationTypeId", getScopeOrganizationTypeId());
		attributes.put("scopePostId", getScopePostId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designationScopeId = (Long)attributes.get("designationScopeId");

		if (designationScopeId != null) {
			setDesignationScopeId(designationScopeId);
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

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Integer scopeType = (Integer)attributes.get("scopeType");

		if (scopeType != null) {
			setScopeType(scopeType);
		}

		Long scopeOrganizationId = (Long)attributes.get("scopeOrganizationId");

		if (scopeOrganizationId != null) {
			setScopeOrganizationId(scopeOrganizationId);
		}

		Long scopeOrganizationTypeId = (Long)attributes.get(
			"scopeOrganizationTypeId");

		if (scopeOrganizationTypeId != null) {
			setScopeOrganizationTypeId(scopeOrganizationTypeId);
		}

		Long scopePostId = (Long)attributes.get("scopePostId");

		if (scopePostId != null) {
			setScopePostId(scopePostId);
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
	 * Returns the company ID of this designation scope.
	 *
	 * @return the company ID of this designation scope
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this designation scope.
	 *
	 * @return the create date of this designation scope
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this designation scope.
	 *
	 * @return the deleted of this designation scope
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the designation ID of this designation scope.
	 *
	 * @return the designation ID of this designation scope
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the designation scope ID of this designation scope.
	 *
	 * @return the designation scope ID of this designation scope
	 */
	@Override
	public long getDesignationScopeId() {
		return model.getDesignationScopeId();
	}

	/**
	 * Returns the group ID of this designation scope.
	 *
	 * @return the group ID of this designation scope
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this designation scope.
	 *
	 * @return the modified date of this designation scope
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this designation scope.
	 *
	 * @return the primary key of this designation scope
	 */
	@Override
	public com.adjecti.mdm.liferay.service.persistence.DesignationScopePK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the scope organization ID of this designation scope.
	 *
	 * @return the scope organization ID of this designation scope
	 */
	@Override
	public long getScopeOrganizationId() {
		return model.getScopeOrganizationId();
	}

	/**
	 * Returns the scope organization type ID of this designation scope.
	 *
	 * @return the scope organization type ID of this designation scope
	 */
	@Override
	public long getScopeOrganizationTypeId() {
		return model.getScopeOrganizationTypeId();
	}

	/**
	 * Returns the scope post ID of this designation scope.
	 *
	 * @return the scope post ID of this designation scope
	 */
	@Override
	public long getScopePostId() {
		return model.getScopePostId();
	}

	/**
	 * Returns the scope type of this designation scope.
	 *
	 * @return the scope type of this designation scope
	 */
	@Override
	public int getScopeType() {
		return model.getScopeType();
	}

	/**
	 * Returns the status of this designation scope.
	 *
	 * @return the status of this designation scope
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this designation scope.
	 *
	 * @return the user ID of this designation scope
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this designation scope.
	 *
	 * @return the user name of this designation scope
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this designation scope.
	 *
	 * @return the user uuid of this designation scope
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this designation scope is deleted.
	 *
	 * @return <code>true</code> if this designation scope is deleted; <code>false</code> otherwise
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
	 * Sets the company ID of this designation scope.
	 *
	 * @param companyId the company ID of this designation scope
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this designation scope.
	 *
	 * @param createDate the create date of this designation scope
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this designation scope is deleted.
	 *
	 * @param deleted the deleted of this designation scope
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the designation ID of this designation scope.
	 *
	 * @param designationId the designation ID of this designation scope
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the designation scope ID of this designation scope.
	 *
	 * @param designationScopeId the designation scope ID of this designation scope
	 */
	@Override
	public void setDesignationScopeId(long designationScopeId) {
		model.setDesignationScopeId(designationScopeId);
	}

	/**
	 * Sets the group ID of this designation scope.
	 *
	 * @param groupId the group ID of this designation scope
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this designation scope.
	 *
	 * @param modifiedDate the modified date of this designation scope
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this designation scope.
	 *
	 * @param primaryKey the primary key of this designation scope
	 */
	@Override
	public void setPrimaryKey(
		com.adjecti.mdm.liferay.service.persistence.DesignationScopePK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the scope organization ID of this designation scope.
	 *
	 * @param scopeOrganizationId the scope organization ID of this designation scope
	 */
	@Override
	public void setScopeOrganizationId(long scopeOrganizationId) {
		model.setScopeOrganizationId(scopeOrganizationId);
	}

	/**
	 * Sets the scope organization type ID of this designation scope.
	 *
	 * @param scopeOrganizationTypeId the scope organization type ID of this designation scope
	 */
	@Override
	public void setScopeOrganizationTypeId(long scopeOrganizationTypeId) {
		model.setScopeOrganizationTypeId(scopeOrganizationTypeId);
	}

	/**
	 * Sets the scope post ID of this designation scope.
	 *
	 * @param scopePostId the scope post ID of this designation scope
	 */
	@Override
	public void setScopePostId(long scopePostId) {
		model.setScopePostId(scopePostId);
	}

	/**
	 * Sets the scope type of this designation scope.
	 *
	 * @param scopeType the scope type of this designation scope
	 */
	@Override
	public void setScopeType(int scopeType) {
		model.setScopeType(scopeType);
	}

	/**
	 * Sets the status of this designation scope.
	 *
	 * @param status the status of this designation scope
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this designation scope.
	 *
	 * @param userId the user ID of this designation scope
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this designation scope.
	 *
	 * @param userName the user name of this designation scope
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this designation scope.
	 *
	 * @param userUuid the user uuid of this designation scope
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DesignationScopeWrapper wrap(DesignationScope designationScope) {
		return new DesignationScopeWrapper(designationScope);
	}

}