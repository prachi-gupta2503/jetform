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
 * This class is a wrapper for {@link IDAMFailedTransaction}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IDAMFailedTransaction
 * @generated
 */
public class IDAMFailedTransactionWrapper
	extends BaseModelWrapper<IDAMFailedTransaction>
	implements IDAMFailedTransaction, ModelWrapper<IDAMFailedTransaction> {

	public IDAMFailedTransactionWrapper(
		IDAMFailedTransaction idamFailedTransaction) {

		super(idamFailedTransaction);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idamFailedTransactionId", getIdamFailedTransactionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("classId", getClassId());
		attributes.put("className", getClassName());
		attributes.put("idamUrl", getIdamUrl());
		attributes.put("attribute", getAttribute());
		attributes.put("oldValue", getOldValue());
		attributes.put("newValue", getNewValue());
		attributes.put("error", getError());
		attributes.put("firedon", getFiredon());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idamFailedTransactionId = (Long)attributes.get(
			"idamFailedTransactionId");

		if (idamFailedTransactionId != null) {
			setIdamFailedTransactionId(idamFailedTransactionId);
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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String idamUrl = (String)attributes.get("idamUrl");

		if (idamUrl != null) {
			setIdamUrl(idamUrl);
		}

		String attribute = (String)attributes.get("attribute");

		if (attribute != null) {
			setAttribute(attribute);
		}

		String oldValue = (String)attributes.get("oldValue");

		if (oldValue != null) {
			setOldValue(oldValue);
		}

		String newValue = (String)attributes.get("newValue");

		if (newValue != null) {
			setNewValue(newValue);
		}

		String error = (String)attributes.get("error");

		if (error != null) {
			setError(error);
		}

		Date firedon = (Date)attributes.get("firedon");

		if (firedon != null) {
			setFiredon(firedon);
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
	 * Returns the attribute of this idam failed transaction.
	 *
	 * @return the attribute of this idam failed transaction
	 */
	@Override
	public String getAttribute() {
		return model.getAttribute();
	}

	/**
	 * Returns the class ID of this idam failed transaction.
	 *
	 * @return the class ID of this idam failed transaction
	 */
	@Override
	public long getClassId() {
		return model.getClassId();
	}

	/**
	 * Returns the class name of this idam failed transaction.
	 *
	 * @return the class name of this idam failed transaction
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the company ID of this idam failed transaction.
	 *
	 * @return the company ID of this idam failed transaction
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this idam failed transaction.
	 *
	 * @return the create date of this idam failed transaction
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this idam failed transaction.
	 *
	 * @return the deleted of this idam failed transaction
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the employee ID of this idam failed transaction.
	 *
	 * @return the employee ID of this idam failed transaction
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the error of this idam failed transaction.
	 *
	 * @return the error of this idam failed transaction
	 */
	@Override
	public String getError() {
		return model.getError();
	}

	/**
	 * Returns the firedon of this idam failed transaction.
	 *
	 * @return the firedon of this idam failed transaction
	 */
	@Override
	public Date getFiredon() {
		return model.getFiredon();
	}

	/**
	 * Returns the group ID of this idam failed transaction.
	 *
	 * @return the group ID of this idam failed transaction
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the idam failed transaction ID of this idam failed transaction.
	 *
	 * @return the idam failed transaction ID of this idam failed transaction
	 */
	@Override
	public long getIdamFailedTransactionId() {
		return model.getIdamFailedTransactionId();
	}

	/**
	 * Returns the idam url of this idam failed transaction.
	 *
	 * @return the idam url of this idam failed transaction
	 */
	@Override
	public String getIdamUrl() {
		return model.getIdamUrl();
	}

	/**
	 * Returns the modified date of this idam failed transaction.
	 *
	 * @return the modified date of this idam failed transaction
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the new value of this idam failed transaction.
	 *
	 * @return the new value of this idam failed transaction
	 */
	@Override
	public String getNewValue() {
		return model.getNewValue();
	}

	/**
	 * Returns the old value of this idam failed transaction.
	 *
	 * @return the old value of this idam failed transaction
	 */
	@Override
	public String getOldValue() {
		return model.getOldValue();
	}

	/**
	 * Returns the primary key of this idam failed transaction.
	 *
	 * @return the primary key of this idam failed transaction
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this idam failed transaction.
	 *
	 * @return the status of this idam failed transaction
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this idam failed transaction.
	 *
	 * @return the user ID of this idam failed transaction
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this idam failed transaction.
	 *
	 * @return the user name of this idam failed transaction
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this idam failed transaction.
	 *
	 * @return the user uuid of this idam failed transaction
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this idam failed transaction is deleted.
	 *
	 * @return <code>true</code> if this idam failed transaction is deleted; <code>false</code> otherwise
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
	 * Sets the attribute of this idam failed transaction.
	 *
	 * @param attribute the attribute of this idam failed transaction
	 */
	@Override
	public void setAttribute(String attribute) {
		model.setAttribute(attribute);
	}

	/**
	 * Sets the class ID of this idam failed transaction.
	 *
	 * @param classId the class ID of this idam failed transaction
	 */
	@Override
	public void setClassId(long classId) {
		model.setClassId(classId);
	}

	/**
	 * Sets the class name of this idam failed transaction.
	 *
	 * @param className the class name of this idam failed transaction
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the company ID of this idam failed transaction.
	 *
	 * @param companyId the company ID of this idam failed transaction
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this idam failed transaction.
	 *
	 * @param createDate the create date of this idam failed transaction
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this idam failed transaction is deleted.
	 *
	 * @param deleted the deleted of this idam failed transaction
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the employee ID of this idam failed transaction.
	 *
	 * @param employeeId the employee ID of this idam failed transaction
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the error of this idam failed transaction.
	 *
	 * @param error the error of this idam failed transaction
	 */
	@Override
	public void setError(String error) {
		model.setError(error);
	}

	/**
	 * Sets the firedon of this idam failed transaction.
	 *
	 * @param firedon the firedon of this idam failed transaction
	 */
	@Override
	public void setFiredon(Date firedon) {
		model.setFiredon(firedon);
	}

	/**
	 * Sets the group ID of this idam failed transaction.
	 *
	 * @param groupId the group ID of this idam failed transaction
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the idam failed transaction ID of this idam failed transaction.
	 *
	 * @param idamFailedTransactionId the idam failed transaction ID of this idam failed transaction
	 */
	@Override
	public void setIdamFailedTransactionId(long idamFailedTransactionId) {
		model.setIdamFailedTransactionId(idamFailedTransactionId);
	}

	/**
	 * Sets the idam url of this idam failed transaction.
	 *
	 * @param idamUrl the idam url of this idam failed transaction
	 */
	@Override
	public void setIdamUrl(String idamUrl) {
		model.setIdamUrl(idamUrl);
	}

	/**
	 * Sets the modified date of this idam failed transaction.
	 *
	 * @param modifiedDate the modified date of this idam failed transaction
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the new value of this idam failed transaction.
	 *
	 * @param newValue the new value of this idam failed transaction
	 */
	@Override
	public void setNewValue(String newValue) {
		model.setNewValue(newValue);
	}

	/**
	 * Sets the old value of this idam failed transaction.
	 *
	 * @param oldValue the old value of this idam failed transaction
	 */
	@Override
	public void setOldValue(String oldValue) {
		model.setOldValue(oldValue);
	}

	/**
	 * Sets the primary key of this idam failed transaction.
	 *
	 * @param primaryKey the primary key of this idam failed transaction
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this idam failed transaction.
	 *
	 * @param status the status of this idam failed transaction
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this idam failed transaction.
	 *
	 * @param userId the user ID of this idam failed transaction
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this idam failed transaction.
	 *
	 * @param userName the user name of this idam failed transaction
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this idam failed transaction.
	 *
	 * @param userUuid the user uuid of this idam failed transaction
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected IDAMFailedTransactionWrapper wrap(
		IDAMFailedTransaction idamFailedTransaction) {

		return new IDAMFailedTransactionWrapper(idamFailedTransaction);
	}

}