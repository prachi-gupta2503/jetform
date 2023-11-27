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
 * This class is a wrapper for {@link EmployeeDsc}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDsc
 * @generated
 */
public class EmployeeDscWrapper
	extends BaseModelWrapper<EmployeeDsc>
	implements EmployeeDsc, ModelWrapper<EmployeeDsc> {

	public EmployeeDscWrapper(EmployeeDsc employeeDsc) {
		super(employeeDsc);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeDscId", getEmployeeDscId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("cid", getCid());
		attributes.put("details", getDetails());
		attributes.put("ofbDSCReissueDate", getOfbDSCReissueDate());
		attributes.put("ofbDSCRevocationDate", getOfbDSCRevocationDate());
		attributes.put("ofbDSCRevocationStatus", isOfbDSCRevocationStatus());
		attributes.put("ofbDSCReissueStatus", isOfbDSCReissueStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeDscId = (Long)attributes.get("employeeDscId");

		if (employeeDscId != null) {
			setEmployeeDscId(employeeDscId);
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

		String cid = (String)attributes.get("cid");

		if (cid != null) {
			setCid(cid);
		}

		String details = (String)attributes.get("details");

		if (details != null) {
			setDetails(details);
		}

		Date ofbDSCReissueDate = (Date)attributes.get("ofbDSCReissueDate");

		if (ofbDSCReissueDate != null) {
			setOfbDSCReissueDate(ofbDSCReissueDate);
		}

		Date ofbDSCRevocationDate = (Date)attributes.get(
			"ofbDSCRevocationDate");

		if (ofbDSCRevocationDate != null) {
			setOfbDSCRevocationDate(ofbDSCRevocationDate);
		}

		Boolean ofbDSCRevocationStatus = (Boolean)attributes.get(
			"ofbDSCRevocationStatus");

		if (ofbDSCRevocationStatus != null) {
			setOfbDSCRevocationStatus(ofbDSCRevocationStatus);
		}

		Boolean ofbDSCReissueStatus = (Boolean)attributes.get(
			"ofbDSCReissueStatus");

		if (ofbDSCReissueStatus != null) {
			setOfbDSCReissueStatus(ofbDSCReissueStatus);
		}
	}

	/**
	 * Returns the cid of this employee dsc.
	 *
	 * @return the cid of this employee dsc
	 */
	@Override
	public String getCid() {
		return model.getCid();
	}

	/**
	 * Returns the company ID of this employee dsc.
	 *
	 * @return the company ID of this employee dsc
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee dsc.
	 *
	 * @return the create date of this employee dsc
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the details of this employee dsc.
	 *
	 * @return the details of this employee dsc
	 */
	@Override
	public String getDetails() {
		return model.getDetails();
	}

	/**
	 * Returns the employee dsc ID of this employee dsc.
	 *
	 * @return the employee dsc ID of this employee dsc
	 */
	@Override
	public long getEmployeeDscId() {
		return model.getEmployeeDscId();
	}

	/**
	 * Returns the employee ID of this employee dsc.
	 *
	 * @return the employee ID of this employee dsc
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee dsc.
	 *
	 * @return the group ID of this employee dsc
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee dsc.
	 *
	 * @return the modified date of this employee dsc
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the ofb dsc reissue date of this employee dsc.
	 *
	 * @return the ofb dsc reissue date of this employee dsc
	 */
	@Override
	public Date getOfbDSCReissueDate() {
		return model.getOfbDSCReissueDate();
	}

	/**
	 * Returns the ofb dsc reissue status of this employee dsc.
	 *
	 * @return the ofb dsc reissue status of this employee dsc
	 */
	@Override
	public boolean getOfbDSCReissueStatus() {
		return model.getOfbDSCReissueStatus();
	}

	/**
	 * Returns the ofb dsc revocation date of this employee dsc.
	 *
	 * @return the ofb dsc revocation date of this employee dsc
	 */
	@Override
	public Date getOfbDSCRevocationDate() {
		return model.getOfbDSCRevocationDate();
	}

	/**
	 * Returns the ofb dsc revocation status of this employee dsc.
	 *
	 * @return the ofb dsc revocation status of this employee dsc
	 */
	@Override
	public boolean getOfbDSCRevocationStatus() {
		return model.getOfbDSCRevocationStatus();
	}

	/**
	 * Returns the primary key of this employee dsc.
	 *
	 * @return the primary key of this employee dsc
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee dsc.
	 *
	 * @return the user ID of this employee dsc
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee dsc.
	 *
	 * @return the user name of this employee dsc
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee dsc.
	 *
	 * @return the user uuid of this employee dsc
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee dsc is ofb dsc reissue status.
	 *
	 * @return <code>true</code> if this employee dsc is ofb dsc reissue status; <code>false</code> otherwise
	 */
	@Override
	public boolean isOfbDSCReissueStatus() {
		return model.isOfbDSCReissueStatus();
	}

	/**
	 * Returns <code>true</code> if this employee dsc is ofb dsc revocation status.
	 *
	 * @return <code>true</code> if this employee dsc is ofb dsc revocation status; <code>false</code> otherwise
	 */
	@Override
	public boolean isOfbDSCRevocationStatus() {
		return model.isOfbDSCRevocationStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cid of this employee dsc.
	 *
	 * @param cid the cid of this employee dsc
	 */
	@Override
	public void setCid(String cid) {
		model.setCid(cid);
	}

	/**
	 * Sets the company ID of this employee dsc.
	 *
	 * @param companyId the company ID of this employee dsc
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee dsc.
	 *
	 * @param createDate the create date of this employee dsc
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the details of this employee dsc.
	 *
	 * @param details the details of this employee dsc
	 */
	@Override
	public void setDetails(String details) {
		model.setDetails(details);
	}

	/**
	 * Sets the employee dsc ID of this employee dsc.
	 *
	 * @param employeeDscId the employee dsc ID of this employee dsc
	 */
	@Override
	public void setEmployeeDscId(long employeeDscId) {
		model.setEmployeeDscId(employeeDscId);
	}

	/**
	 * Sets the employee ID of this employee dsc.
	 *
	 * @param employeeId the employee ID of this employee dsc
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee dsc.
	 *
	 * @param groupId the group ID of this employee dsc
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee dsc.
	 *
	 * @param modifiedDate the modified date of this employee dsc
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the ofb dsc reissue date of this employee dsc.
	 *
	 * @param ofbDSCReissueDate the ofb dsc reissue date of this employee dsc
	 */
	@Override
	public void setOfbDSCReissueDate(Date ofbDSCReissueDate) {
		model.setOfbDSCReissueDate(ofbDSCReissueDate);
	}

	/**
	 * Sets whether this employee dsc is ofb dsc reissue status.
	 *
	 * @param ofbDSCReissueStatus the ofb dsc reissue status of this employee dsc
	 */
	@Override
	public void setOfbDSCReissueStatus(boolean ofbDSCReissueStatus) {
		model.setOfbDSCReissueStatus(ofbDSCReissueStatus);
	}

	/**
	 * Sets the ofb dsc revocation date of this employee dsc.
	 *
	 * @param ofbDSCRevocationDate the ofb dsc revocation date of this employee dsc
	 */
	@Override
	public void setOfbDSCRevocationDate(Date ofbDSCRevocationDate) {
		model.setOfbDSCRevocationDate(ofbDSCRevocationDate);
	}

	/**
	 * Sets whether this employee dsc is ofb dsc revocation status.
	 *
	 * @param ofbDSCRevocationStatus the ofb dsc revocation status of this employee dsc
	 */
	@Override
	public void setOfbDSCRevocationStatus(boolean ofbDSCRevocationStatus) {
		model.setOfbDSCRevocationStatus(ofbDSCRevocationStatus);
	}

	/**
	 * Sets the primary key of this employee dsc.
	 *
	 * @param primaryKey the primary key of this employee dsc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee dsc.
	 *
	 * @param userId the user ID of this employee dsc
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee dsc.
	 *
	 * @param userName the user name of this employee dsc
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee dsc.
	 *
	 * @param userUuid the user uuid of this employee dsc
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeDscWrapper wrap(EmployeeDsc employeeDsc) {
		return new EmployeeDscWrapper(employeeDsc);
	}

}