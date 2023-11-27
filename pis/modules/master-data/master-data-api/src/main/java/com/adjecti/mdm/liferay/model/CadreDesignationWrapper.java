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
 * This class is a wrapper for {@link CadreDesignation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadreDesignation
 * @generated
 */
public class CadreDesignationWrapper
	extends BaseModelWrapper<CadreDesignation>
	implements CadreDesignation, ModelWrapper<CadreDesignation> {

	public CadreDesignationWrapper(CadreDesignation cadreDesignation) {
		super(cadreDesignation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cadreDesignationId", getCadreDesignationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cadreId", getCadreId());
		attributes.put("designationId", getDesignationId());
		attributes.put("rank", getRank());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cadreDesignationId = (Long)attributes.get("cadreDesignationId");

		if (cadreDesignationId != null) {
			setCadreDesignationId(cadreDesignationId);
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

		Long cadreId = (Long)attributes.get("cadreId");

		if (cadreId != null) {
			setCadreId(cadreId);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Integer rank = (Integer)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
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
	 * Returns the cadre designation ID of this cadre designation.
	 *
	 * @return the cadre designation ID of this cadre designation
	 */
	@Override
	public long getCadreDesignationId() {
		return model.getCadreDesignationId();
	}

	/**
	 * Returns the cadre ID of this cadre designation.
	 *
	 * @return the cadre ID of this cadre designation
	 */
	@Override
	public long getCadreId() {
		return model.getCadreId();
	}

	/**
	 * Returns the company ID of this cadre designation.
	 *
	 * @return the company ID of this cadre designation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this cadre designation.
	 *
	 * @return the create date of this cadre designation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this cadre designation.
	 *
	 * @return the deleted of this cadre designation
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the designation ID of this cadre designation.
	 *
	 * @return the designation ID of this cadre designation
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the group ID of this cadre designation.
	 *
	 * @return the group ID of this cadre designation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this cadre designation.
	 *
	 * @return the modified date of this cadre designation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cadre designation.
	 *
	 * @return the primary key of this cadre designation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rank of this cadre designation.
	 *
	 * @return the rank of this cadre designation
	 */
	@Override
	public int getRank() {
		return model.getRank();
	}

	/**
	 * Returns the status of this cadre designation.
	 *
	 * @return the status of this cadre designation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this cadre designation.
	 *
	 * @return the user ID of this cadre designation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cadre designation.
	 *
	 * @return the user name of this cadre designation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cadre designation.
	 *
	 * @return the user uuid of this cadre designation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this cadre designation is deleted.
	 *
	 * @return <code>true</code> if this cadre designation is deleted; <code>false</code> otherwise
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
	 * Sets the cadre designation ID of this cadre designation.
	 *
	 * @param cadreDesignationId the cadre designation ID of this cadre designation
	 */
	@Override
	public void setCadreDesignationId(long cadreDesignationId) {
		model.setCadreDesignationId(cadreDesignationId);
	}

	/**
	 * Sets the cadre ID of this cadre designation.
	 *
	 * @param cadreId the cadre ID of this cadre designation
	 */
	@Override
	public void setCadreId(long cadreId) {
		model.setCadreId(cadreId);
	}

	/**
	 * Sets the company ID of this cadre designation.
	 *
	 * @param companyId the company ID of this cadre designation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this cadre designation.
	 *
	 * @param createDate the create date of this cadre designation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this cadre designation is deleted.
	 *
	 * @param deleted the deleted of this cadre designation
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the designation ID of this cadre designation.
	 *
	 * @param designationId the designation ID of this cadre designation
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the group ID of this cadre designation.
	 *
	 * @param groupId the group ID of this cadre designation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this cadre designation.
	 *
	 * @param modifiedDate the modified date of this cadre designation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cadre designation.
	 *
	 * @param primaryKey the primary key of this cadre designation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rank of this cadre designation.
	 *
	 * @param rank the rank of this cadre designation
	 */
	@Override
	public void setRank(int rank) {
		model.setRank(rank);
	}

	/**
	 * Sets the status of this cadre designation.
	 *
	 * @param status the status of this cadre designation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this cadre designation.
	 *
	 * @param userId the user ID of this cadre designation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cadre designation.
	 *
	 * @param userName the user name of this cadre designation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cadre designation.
	 *
	 * @param userUuid the user uuid of this cadre designation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CadreDesignationWrapper wrap(CadreDesignation cadreDesignation) {
		return new CadreDesignationWrapper(cadreDesignation);
	}

}