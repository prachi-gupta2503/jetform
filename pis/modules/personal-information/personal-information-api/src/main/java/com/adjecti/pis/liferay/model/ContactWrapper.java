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
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactWrapper
	extends BaseModelWrapper<Contact>
	implements Contact, ModelWrapper<Contact> {

	public ContactWrapper(Contact contact) {
		super(contact);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("altEmailAddress", getAltEmailAddress());
		attributes.put("emergencyMobile", getEmergencyMobile());
		attributes.put("facebookId", getFacebookId());
		attributes.put("instagramId", getInstagramId());
		attributes.put("linkedInId", getLinkedInId());
		attributes.put("mobile", getMobile());
		attributes.put("phone", getPhone());
		attributes.put("twitterId", getTwitterId());
		attributes.put("landline", getLandline());
		attributes.put("emergencyNo", getEmergencyNo());
		attributes.put("fax", getFax());
		attributes.put("telegram", getTelegram());
		attributes.put("telex", getTelex());
		attributes.put("personalEmail", getPersonalEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
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

		String altEmailAddress = (String)attributes.get("altEmailAddress");

		if (altEmailAddress != null) {
			setAltEmailAddress(altEmailAddress);
		}

		String emergencyMobile = (String)attributes.get("emergencyMobile");

		if (emergencyMobile != null) {
			setEmergencyMobile(emergencyMobile);
		}

		String facebookId = (String)attributes.get("facebookId");

		if (facebookId != null) {
			setFacebookId(facebookId);
		}

		String instagramId = (String)attributes.get("instagramId");

		if (instagramId != null) {
			setInstagramId(instagramId);
		}

		String linkedInId = (String)attributes.get("linkedInId");

		if (linkedInId != null) {
			setLinkedInId(linkedInId);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String twitterId = (String)attributes.get("twitterId");

		if (twitterId != null) {
			setTwitterId(twitterId);
		}

		String landline = (String)attributes.get("landline");

		if (landline != null) {
			setLandline(landline);
		}

		String emergencyNo = (String)attributes.get("emergencyNo");

		if (emergencyNo != null) {
			setEmergencyNo(emergencyNo);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String telegram = (String)attributes.get("telegram");

		if (telegram != null) {
			setTelegram(telegram);
		}

		String telex = (String)attributes.get("telex");

		if (telex != null) {
			setTelex(telex);
		}

		String personalEmail = (String)attributes.get("personalEmail");

		if (personalEmail != null) {
			setPersonalEmail(personalEmail);
		}
	}

	/**
	 * Returns the alt email address of this contact.
	 *
	 * @return the alt email address of this contact
	 */
	@Override
	public String getAltEmailAddress() {
		return model.getAltEmailAddress();
	}

	/**
	 * Returns the company ID of this contact.
	 *
	 * @return the company ID of this contact
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ID of this contact.
	 *
	 * @return the contact ID of this contact
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the create date of this contact.
	 *
	 * @return the create date of this contact
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the emergency mobile of this contact.
	 *
	 * @return the emergency mobile of this contact
	 */
	@Override
	public String getEmergencyMobile() {
		return model.getEmergencyMobile();
	}

	/**
	 * Returns the emergency no of this contact.
	 *
	 * @return the emergency no of this contact
	 */
	@Override
	public String getEmergencyNo() {
		return model.getEmergencyNo();
	}

	/**
	 * Returns the facebook ID of this contact.
	 *
	 * @return the facebook ID of this contact
	 */
	@Override
	public String getFacebookId() {
		return model.getFacebookId();
	}

	/**
	 * Returns the fax of this contact.
	 *
	 * @return the fax of this contact
	 */
	@Override
	public String getFax() {
		return model.getFax();
	}

	/**
	 * Returns the group ID of this contact.
	 *
	 * @return the group ID of this contact
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the instagram ID of this contact.
	 *
	 * @return the instagram ID of this contact
	 */
	@Override
	public String getInstagramId() {
		return model.getInstagramId();
	}

	/**
	 * Returns the landline of this contact.
	 *
	 * @return the landline of this contact
	 */
	@Override
	public String getLandline() {
		return model.getLandline();
	}

	/**
	 * Returns the linked in ID of this contact.
	 *
	 * @return the linked in ID of this contact
	 */
	@Override
	public String getLinkedInId() {
		return model.getLinkedInId();
	}

	/**
	 * Returns the mobile of this contact.
	 *
	 * @return the mobile of this contact
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the modified date of this contact.
	 *
	 * @return the modified date of this contact
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal email of this contact.
	 *
	 * @return the personal email of this contact
	 */
	@Override
	public String getPersonalEmail() {
		return model.getPersonalEmail();
	}

	/**
	 * Returns the phone of this contact.
	 *
	 * @return the phone of this contact
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this contact.
	 *
	 * @return the primary key of this contact
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the telegram of this contact.
	 *
	 * @return the telegram of this contact
	 */
	@Override
	public String getTelegram() {
		return model.getTelegram();
	}

	/**
	 * Returns the telex of this contact.
	 *
	 * @return the telex of this contact
	 */
	@Override
	public String getTelex() {
		return model.getTelex();
	}

	/**
	 * Returns the twitter ID of this contact.
	 *
	 * @return the twitter ID of this contact
	 */
	@Override
	public String getTwitterId() {
		return model.getTwitterId();
	}

	/**
	 * Returns the user ID of this contact.
	 *
	 * @return the user ID of this contact
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this contact.
	 *
	 * @return the user name of this contact
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this contact.
	 *
	 * @return the user uuid of this contact
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
	 * Sets the alt email address of this contact.
	 *
	 * @param altEmailAddress the alt email address of this contact
	 */
	@Override
	public void setAltEmailAddress(String altEmailAddress) {
		model.setAltEmailAddress(altEmailAddress);
	}

	/**
	 * Sets the company ID of this contact.
	 *
	 * @param companyId the company ID of this contact
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ID of this contact.
	 *
	 * @param contactId the contact ID of this contact
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the create date of this contact.
	 *
	 * @param createDate the create date of this contact
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the emergency mobile of this contact.
	 *
	 * @param emergencyMobile the emergency mobile of this contact
	 */
	@Override
	public void setEmergencyMobile(String emergencyMobile) {
		model.setEmergencyMobile(emergencyMobile);
	}

	/**
	 * Sets the emergency no of this contact.
	 *
	 * @param emergencyNo the emergency no of this contact
	 */
	@Override
	public void setEmergencyNo(String emergencyNo) {
		model.setEmergencyNo(emergencyNo);
	}

	/**
	 * Sets the facebook ID of this contact.
	 *
	 * @param facebookId the facebook ID of this contact
	 */
	@Override
	public void setFacebookId(String facebookId) {
		model.setFacebookId(facebookId);
	}

	/**
	 * Sets the fax of this contact.
	 *
	 * @param fax the fax of this contact
	 */
	@Override
	public void setFax(String fax) {
		model.setFax(fax);
	}

	/**
	 * Sets the group ID of this contact.
	 *
	 * @param groupId the group ID of this contact
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the instagram ID of this contact.
	 *
	 * @param instagramId the instagram ID of this contact
	 */
	@Override
	public void setInstagramId(String instagramId) {
		model.setInstagramId(instagramId);
	}

	/**
	 * Sets the landline of this contact.
	 *
	 * @param landline the landline of this contact
	 */
	@Override
	public void setLandline(String landline) {
		model.setLandline(landline);
	}

	/**
	 * Sets the linked in ID of this contact.
	 *
	 * @param linkedInId the linked in ID of this contact
	 */
	@Override
	public void setLinkedInId(String linkedInId) {
		model.setLinkedInId(linkedInId);
	}

	/**
	 * Sets the mobile of this contact.
	 *
	 * @param mobile the mobile of this contact
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the modified date of this contact.
	 *
	 * @param modifiedDate the modified date of this contact
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal email of this contact.
	 *
	 * @param personalEmail the personal email of this contact
	 */
	@Override
	public void setPersonalEmail(String personalEmail) {
		model.setPersonalEmail(personalEmail);
	}

	/**
	 * Sets the phone of this contact.
	 *
	 * @param phone the phone of this contact
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this contact.
	 *
	 * @param primaryKey the primary key of this contact
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the telegram of this contact.
	 *
	 * @param telegram the telegram of this contact
	 */
	@Override
	public void setTelegram(String telegram) {
		model.setTelegram(telegram);
	}

	/**
	 * Sets the telex of this contact.
	 *
	 * @param telex the telex of this contact
	 */
	@Override
	public void setTelex(String telex) {
		model.setTelex(telex);
	}

	/**
	 * Sets the twitter ID of this contact.
	 *
	 * @param twitterId the twitter ID of this contact
	 */
	@Override
	public void setTwitterId(String twitterId) {
		model.setTwitterId(twitterId);
	}

	/**
	 * Sets the user ID of this contact.
	 *
	 * @param userId the user ID of this contact
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this contact.
	 *
	 * @param userName the user name of this contact
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this contact.
	 *
	 * @param userUuid the user uuid of this contact
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ContactWrapper wrap(Contact contact) {
		return new ContactWrapper(contact);
	}

}