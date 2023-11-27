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
 * This class is a wrapper for {@link PersonalNoPrefix}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalNoPrefix
 * @generated
 */
public class PersonalNoPrefixWrapper
	extends BaseModelWrapper<PersonalNoPrefix>
	implements ModelWrapper<PersonalNoPrefix>, PersonalNoPrefix {

	public PersonalNoPrefixWrapper(PersonalNoPrefix personalNoPrefix) {
		super(personalNoPrefix);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personalNoPrefixId", getPersonalNoPrefixId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("fromDate", getFromDate());
		attributes.put("prefix", getPrefix());
		attributes.put("toDate", getToDate());
		attributes.put("desigClassId", getDesigClassId());
		attributes.put("desigGradeId", getDesigGradeId());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personalNoPrefixId = (Long)attributes.get("personalNoPrefixId");

		if (personalNoPrefixId != null) {
			setPersonalNoPrefixId(personalNoPrefixId);
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

		String prefix = (String)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long desigClassId = (Long)attributes.get("desigClassId");

		if (desigClassId != null) {
			setDesigClassId(desigClassId);
		}

		Long desigGradeId = (Long)attributes.get("desigGradeId");

		if (desigGradeId != null) {
			setDesigGradeId(desigGradeId);
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
	 * Returns the active of this personal no prefix.
	 *
	 * @return the active of this personal no prefix
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this personal no prefix.
	 *
	 * @return the company ID of this personal no prefix
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this personal no prefix.
	 *
	 * @return the create date of this personal no prefix
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this personal no prefix.
	 *
	 * @return the deleted of this personal no prefix
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the desig class ID of this personal no prefix.
	 *
	 * @return the desig class ID of this personal no prefix
	 */
	@Override
	public long getDesigClassId() {
		return model.getDesigClassId();
	}

	/**
	 * Returns the desig grade ID of this personal no prefix.
	 *
	 * @return the desig grade ID of this personal no prefix
	 */
	@Override
	public long getDesigGradeId() {
		return model.getDesigGradeId();
	}

	/**
	 * Returns the from date of this personal no prefix.
	 *
	 * @return the from date of this personal no prefix
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this personal no prefix.
	 *
	 * @return the group ID of this personal no prefix
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this personal no prefix.
	 *
	 * @return the modified date of this personal no prefix
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal no prefix ID of this personal no prefix.
	 *
	 * @return the personal no prefix ID of this personal no prefix
	 */
	@Override
	public long getPersonalNoPrefixId() {
		return model.getPersonalNoPrefixId();
	}

	/**
	 * Returns the prefix of this personal no prefix.
	 *
	 * @return the prefix of this personal no prefix
	 */
	@Override
	public String getPrefix() {
		return model.getPrefix();
	}

	/**
	 * Returns the primary key of this personal no prefix.
	 *
	 * @return the primary key of this personal no prefix
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this personal no prefix.
	 *
	 * @return the status of this personal no prefix
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the to date of this personal no prefix.
	 *
	 * @return the to date of this personal no prefix
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this personal no prefix.
	 *
	 * @return the user ID of this personal no prefix
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this personal no prefix.
	 *
	 * @return the user name of this personal no prefix
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this personal no prefix.
	 *
	 * @return the user uuid of this personal no prefix
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this personal no prefix is active.
	 *
	 * @return <code>true</code> if this personal no prefix is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this personal no prefix is deleted.
	 *
	 * @return <code>true</code> if this personal no prefix is deleted; <code>false</code> otherwise
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
	 * Sets whether this personal no prefix is active.
	 *
	 * @param active the active of this personal no prefix
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this personal no prefix.
	 *
	 * @param companyId the company ID of this personal no prefix
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this personal no prefix.
	 *
	 * @param createDate the create date of this personal no prefix
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this personal no prefix is deleted.
	 *
	 * @param deleted the deleted of this personal no prefix
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the desig class ID of this personal no prefix.
	 *
	 * @param desigClassId the desig class ID of this personal no prefix
	 */
	@Override
	public void setDesigClassId(long desigClassId) {
		model.setDesigClassId(desigClassId);
	}

	/**
	 * Sets the desig grade ID of this personal no prefix.
	 *
	 * @param desigGradeId the desig grade ID of this personal no prefix
	 */
	@Override
	public void setDesigGradeId(long desigGradeId) {
		model.setDesigGradeId(desigGradeId);
	}

	/**
	 * Sets the from date of this personal no prefix.
	 *
	 * @param fromDate the from date of this personal no prefix
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this personal no prefix.
	 *
	 * @param groupId the group ID of this personal no prefix
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this personal no prefix.
	 *
	 * @param modifiedDate the modified date of this personal no prefix
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal no prefix ID of this personal no prefix.
	 *
	 * @param personalNoPrefixId the personal no prefix ID of this personal no prefix
	 */
	@Override
	public void setPersonalNoPrefixId(long personalNoPrefixId) {
		model.setPersonalNoPrefixId(personalNoPrefixId);
	}

	/**
	 * Sets the prefix of this personal no prefix.
	 *
	 * @param prefix the prefix of this personal no prefix
	 */
	@Override
	public void setPrefix(String prefix) {
		model.setPrefix(prefix);
	}

	/**
	 * Sets the primary key of this personal no prefix.
	 *
	 * @param primaryKey the primary key of this personal no prefix
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this personal no prefix.
	 *
	 * @param status the status of this personal no prefix
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the to date of this personal no prefix.
	 *
	 * @param toDate the to date of this personal no prefix
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this personal no prefix.
	 *
	 * @param userId the user ID of this personal no prefix
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this personal no prefix.
	 *
	 * @param userName the user name of this personal no prefix
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this personal no prefix.
	 *
	 * @param userUuid the user uuid of this personal no prefix
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PersonalNoPrefixWrapper wrap(PersonalNoPrefix personalNoPrefix) {
		return new PersonalNoPrefixWrapper(personalNoPrefix);
	}

}