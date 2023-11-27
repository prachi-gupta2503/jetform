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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.ContactServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ContactSoap implements Serializable {

	public static ContactSoap toSoapModel(Contact model) {
		ContactSoap soapModel = new ContactSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAltEmailAddress(model.getAltEmailAddress());
		soapModel.setEmergencyMobile(model.getEmergencyMobile());
		soapModel.setFacebookId(model.getFacebookId());
		soapModel.setInstagramId(model.getInstagramId());
		soapModel.setLinkedInId(model.getLinkedInId());
		soapModel.setMobile(model.getMobile());
		soapModel.setPhone(model.getPhone());
		soapModel.setTwitterId(model.getTwitterId());
		soapModel.setLandline(model.getLandline());
		soapModel.setEmergencyNo(model.getEmergencyNo());
		soapModel.setFax(model.getFax());
		soapModel.setTelegram(model.getTelegram());
		soapModel.setTelex(model.getTelex());
		soapModel.setPersonalEmail(model.getPersonalEmail());

		return soapModel;
	}

	public static ContactSoap[] toSoapModels(Contact[] models) {
		ContactSoap[] soapModels = new ContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactSoap[][] toSoapModels(Contact[][] models) {
		ContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactSoap[] toSoapModels(List<Contact> models) {
		List<ContactSoap> soapModels = new ArrayList<ContactSoap>(
			models.size());

		for (Contact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactSoap[soapModels.size()]);
	}

	public ContactSoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAltEmailAddress() {
		return _altEmailAddress;
	}

	public void setAltEmailAddress(String altEmailAddress) {
		_altEmailAddress = altEmailAddress;
	}

	public String getEmergencyMobile() {
		return _emergencyMobile;
	}

	public void setEmergencyMobile(String emergencyMobile) {
		_emergencyMobile = emergencyMobile;
	}

	public String getFacebookId() {
		return _facebookId;
	}

	public void setFacebookId(String facebookId) {
		_facebookId = facebookId;
	}

	public String getInstagramId() {
		return _instagramId;
	}

	public void setInstagramId(String instagramId) {
		_instagramId = instagramId;
	}

	public String getLinkedInId() {
		return _linkedInId;
	}

	public void setLinkedInId(String linkedInId) {
		_linkedInId = linkedInId;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getTwitterId() {
		return _twitterId;
	}

	public void setTwitterId(String twitterId) {
		_twitterId = twitterId;
	}

	public String getLandline() {
		return _landline;
	}

	public void setLandline(String landline) {
		_landline = landline;
	}

	public String getEmergencyNo() {
		return _emergencyNo;
	}

	public void setEmergencyNo(String emergencyNo) {
		_emergencyNo = emergencyNo;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getTelegram() {
		return _telegram;
	}

	public void setTelegram(String telegram) {
		_telegram = telegram;
	}

	public String getTelex() {
		return _telex;
	}

	public void setTelex(String telex) {
		_telex = telex;
	}

	public String getPersonalEmail() {
		return _personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		_personalEmail = personalEmail;
	}

	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _altEmailAddress;
	private String _emergencyMobile;
	private String _facebookId;
	private String _instagramId;
	private String _linkedInId;
	private String _mobile;
	private String _phone;
	private String _twitterId;
	private String _landline;
	private String _emergencyNo;
	private String _fax;
	private String _telegram;
	private String _telex;
	private String _personalEmail;

}