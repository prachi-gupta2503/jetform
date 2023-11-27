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
 * This class is a wrapper for {@link EmployeeContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContact
 * @generated
 */
public class EmployeeContactWrapper
	extends BaseModelWrapper<EmployeeContact>
	implements EmployeeContact, ModelWrapper<EmployeeContact> {

	public EmployeeContactWrapper(EmployeeContact employeeContact) {
		super(employeeContact);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeContactId", getEmployeeContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deskNo", getDeskNo());
		attributes.put("extn", getExtn());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("contactId", getContactId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("directNo", getDirectNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeContactId = (Long)attributes.get("employeeContactId");

		if (employeeContactId != null) {
			setEmployeeContactId(employeeContactId);
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

		String deskNo = (String)attributes.get("deskNo");

		if (deskNo != null) {
			setDeskNo(deskNo);
		}

		String extn = (String)attributes.get("extn");

		if (extn != null) {
			setExtn(extn);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String directNo = (String)attributes.get("directNo");

		if (directNo != null) {
			setDirectNo(directNo);
		}
	}

	/**
	 * Returns the company ID of this employee contact.
	 *
	 * @return the company ID of this employee contact
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ID of this employee contact.
	 *
	 * @return the contact ID of this employee contact
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the create date of this employee contact.
	 *
	 * @return the create date of this employee contact
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the desk no of this employee contact.
	 *
	 * @return the desk no of this employee contact
	 */
	@Override
	public String getDeskNo() {
		return model.getDeskNo();
	}

	/**
	 * Returns the direct no of this employee contact.
	 *
	 * @return the direct no of this employee contact
	 */
	@Override
	public String getDirectNo() {
		return model.getDirectNo();
	}

	/**
	 * Returns the employee contact ID of this employee contact.
	 *
	 * @return the employee contact ID of this employee contact
	 */
	@Override
	public long getEmployeeContactId() {
		return model.getEmployeeContactId();
	}

	/**
	 * Returns the employee ID of this employee contact.
	 *
	 * @return the employee ID of this employee contact
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the extn of this employee contact.
	 *
	 * @return the extn of this employee contact
	 */
	@Override
	public String getExtn() {
		return model.getExtn();
	}

	/**
	 * Returns the group ID of this employee contact.
	 *
	 * @return the group ID of this employee contact
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employee contact.
	 *
	 * @return the modified date of this employee contact
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone no of this employee contact.
	 *
	 * @return the phone no of this employee contact
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the primary key of this employee contact.
	 *
	 * @return the primary key of this employee contact
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee contact.
	 *
	 * @return the user ID of this employee contact
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee contact.
	 *
	 * @return the user name of this employee contact
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee contact.
	 *
	 * @return the user uuid of this employee contact
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
	 * Sets the company ID of this employee contact.
	 *
	 * @param companyId the company ID of this employee contact
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ID of this employee contact.
	 *
	 * @param contactId the contact ID of this employee contact
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the create date of this employee contact.
	 *
	 * @param createDate the create date of this employee contact
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the desk no of this employee contact.
	 *
	 * @param deskNo the desk no of this employee contact
	 */
	@Override
	public void setDeskNo(String deskNo) {
		model.setDeskNo(deskNo);
	}

	/**
	 * Sets the direct no of this employee contact.
	 *
	 * @param directNo the direct no of this employee contact
	 */
	@Override
	public void setDirectNo(String directNo) {
		model.setDirectNo(directNo);
	}

	/**
	 * Sets the employee contact ID of this employee contact.
	 *
	 * @param employeeContactId the employee contact ID of this employee contact
	 */
	@Override
	public void setEmployeeContactId(long employeeContactId) {
		model.setEmployeeContactId(employeeContactId);
	}

	/**
	 * Sets the employee ID of this employee contact.
	 *
	 * @param employeeId the employee ID of this employee contact
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the extn of this employee contact.
	 *
	 * @param extn the extn of this employee contact
	 */
	@Override
	public void setExtn(String extn) {
		model.setExtn(extn);
	}

	/**
	 * Sets the group ID of this employee contact.
	 *
	 * @param groupId the group ID of this employee contact
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employee contact.
	 *
	 * @param modifiedDate the modified date of this employee contact
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone no of this employee contact.
	 *
	 * @param phoneNo the phone no of this employee contact
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the primary key of this employee contact.
	 *
	 * @param primaryKey the primary key of this employee contact
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee contact.
	 *
	 * @param userId the user ID of this employee contact
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee contact.
	 *
	 * @param userName the user name of this employee contact
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee contact.
	 *
	 * @param userUuid the user uuid of this employee contact
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeContactWrapper wrap(EmployeeContact employeeContact) {
		return new EmployeeContactWrapper(employeeContact);
	}

}