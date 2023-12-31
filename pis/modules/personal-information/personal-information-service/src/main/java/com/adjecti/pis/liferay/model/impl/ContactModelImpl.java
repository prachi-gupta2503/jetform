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

package com.adjecti.pis.liferay.model.impl;

import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.ContactModel;
import com.adjecti.pis.liferay.model.ContactSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Contact service. Represents a row in the &quot;pis_Contact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ContactModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactImpl
 * @generated
 */
@JSON(strict = true)
public class ContactModelImpl
	extends BaseModelImpl<Contact> implements ContactModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a contact model instance should use the <code>Contact</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_Contact";

	public static final Object[][] TABLE_COLUMNS = {
		{"contactId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"altEmailAddress", Types.VARCHAR},
		{"emergencyMobile", Types.VARCHAR}, {"facebookId", Types.VARCHAR},
		{"instagramId", Types.VARCHAR}, {"linkedInId", Types.VARCHAR},
		{"mobile", Types.VARCHAR}, {"phone", Types.VARCHAR},
		{"twitterId", Types.VARCHAR}, {"landline", Types.VARCHAR},
		{"emergencyNo", Types.VARCHAR}, {"fax", Types.VARCHAR},
		{"telegram", Types.VARCHAR}, {"telex", Types.VARCHAR},
		{"personalEmail", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("contactId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("altEmailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emergencyMobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("facebookId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("instagramId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("linkedInId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("twitterId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("landline", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emergencyNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fax", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("telegram", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("telex", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("personalEmail", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_Contact (contactId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,altEmailAddress VARCHAR(75) null,emergencyMobile VARCHAR(75) null,facebookId VARCHAR(75) null,instagramId VARCHAR(75) null,linkedInId VARCHAR(75) null,mobile VARCHAR(75) null,phone VARCHAR(75) null,twitterId VARCHAR(75) null,landline VARCHAR(75) null,emergencyNo VARCHAR(75) null,fax VARCHAR(75) null,telegram VARCHAR(75) null,telex VARCHAR(75) null,personalEmail VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table pis_Contact";

	public static final String ORDER_BY_JPQL =
		" ORDER BY contact.contactId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_Contact.contactId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CONTACTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Contact toModel(ContactSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Contact model = new ContactImpl();

		model.setContactId(soapModel.getContactId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAltEmailAddress(soapModel.getAltEmailAddress());
		model.setEmergencyMobile(soapModel.getEmergencyMobile());
		model.setFacebookId(soapModel.getFacebookId());
		model.setInstagramId(soapModel.getInstagramId());
		model.setLinkedInId(soapModel.getLinkedInId());
		model.setMobile(soapModel.getMobile());
		model.setPhone(soapModel.getPhone());
		model.setTwitterId(soapModel.getTwitterId());
		model.setLandline(soapModel.getLandline());
		model.setEmergencyNo(soapModel.getEmergencyNo());
		model.setFax(soapModel.getFax());
		model.setTelegram(soapModel.getTelegram());
		model.setTelex(soapModel.getTelex());
		model.setPersonalEmail(soapModel.getPersonalEmail());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Contact> toModels(ContactSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Contact> models = new ArrayList<Contact>(soapModels.length);

		for (ContactSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ContactModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _contactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Contact.class;
	}

	@Override
	public String getModelClassName() {
		return Contact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Contact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Contact, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Contact)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Contact, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Contact, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Contact)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Contact, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Contact, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Contact>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Contact.class.getClassLoader(), Contact.class, ModelWrapper.class);

		try {
			Constructor<Contact> constructor =
				(Constructor<Contact>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Contact, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Contact, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Contact, Object>>();
		Map<String, BiConsumer<Contact, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Contact, ?>>();

		attributeGetterFunctions.put("contactId", Contact::getContactId);
		attributeSetterBiConsumers.put(
			"contactId", (BiConsumer<Contact, Long>)Contact::setContactId);
		attributeGetterFunctions.put("groupId", Contact::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Contact, Long>)Contact::setGroupId);
		attributeGetterFunctions.put("companyId", Contact::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Contact, Long>)Contact::setCompanyId);
		attributeGetterFunctions.put("userId", Contact::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Contact, Long>)Contact::setUserId);
		attributeGetterFunctions.put("userName", Contact::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Contact, String>)Contact::setUserName);
		attributeGetterFunctions.put("createDate", Contact::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Contact, Date>)Contact::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Contact::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Contact, Date>)Contact::setModifiedDate);
		attributeGetterFunctions.put(
			"altEmailAddress", Contact::getAltEmailAddress);
		attributeSetterBiConsumers.put(
			"altEmailAddress",
			(BiConsumer<Contact, String>)Contact::setAltEmailAddress);
		attributeGetterFunctions.put(
			"emergencyMobile", Contact::getEmergencyMobile);
		attributeSetterBiConsumers.put(
			"emergencyMobile",
			(BiConsumer<Contact, String>)Contact::setEmergencyMobile);
		attributeGetterFunctions.put("facebookId", Contact::getFacebookId);
		attributeSetterBiConsumers.put(
			"facebookId", (BiConsumer<Contact, String>)Contact::setFacebookId);
		attributeGetterFunctions.put("instagramId", Contact::getInstagramId);
		attributeSetterBiConsumers.put(
			"instagramId",
			(BiConsumer<Contact, String>)Contact::setInstagramId);
		attributeGetterFunctions.put("linkedInId", Contact::getLinkedInId);
		attributeSetterBiConsumers.put(
			"linkedInId", (BiConsumer<Contact, String>)Contact::setLinkedInId);
		attributeGetterFunctions.put("mobile", Contact::getMobile);
		attributeSetterBiConsumers.put(
			"mobile", (BiConsumer<Contact, String>)Contact::setMobile);
		attributeGetterFunctions.put("phone", Contact::getPhone);
		attributeSetterBiConsumers.put(
			"phone", (BiConsumer<Contact, String>)Contact::setPhone);
		attributeGetterFunctions.put("twitterId", Contact::getTwitterId);
		attributeSetterBiConsumers.put(
			"twitterId", (BiConsumer<Contact, String>)Contact::setTwitterId);
		attributeGetterFunctions.put("landline", Contact::getLandline);
		attributeSetterBiConsumers.put(
			"landline", (BiConsumer<Contact, String>)Contact::setLandline);
		attributeGetterFunctions.put("emergencyNo", Contact::getEmergencyNo);
		attributeSetterBiConsumers.put(
			"emergencyNo",
			(BiConsumer<Contact, String>)Contact::setEmergencyNo);
		attributeGetterFunctions.put("fax", Contact::getFax);
		attributeSetterBiConsumers.put(
			"fax", (BiConsumer<Contact, String>)Contact::setFax);
		attributeGetterFunctions.put("telegram", Contact::getTelegram);
		attributeSetterBiConsumers.put(
			"telegram", (BiConsumer<Contact, String>)Contact::setTelegram);
		attributeGetterFunctions.put("telex", Contact::getTelex);
		attributeSetterBiConsumers.put(
			"telex", (BiConsumer<Contact, String>)Contact::setTelex);
		attributeGetterFunctions.put(
			"personalEmail", Contact::getPersonalEmail);
		attributeSetterBiConsumers.put(
			"personalEmail",
			(BiConsumer<Contact, String>)Contact::setPersonalEmail);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contactId = contactId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getAltEmailAddress() {
		if (_altEmailAddress == null) {
			return "";
		}
		else {
			return _altEmailAddress;
		}
	}

	@Override
	public void setAltEmailAddress(String altEmailAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_altEmailAddress = altEmailAddress;
	}

	@JSON
	@Override
	public String getEmergencyMobile() {
		if (_emergencyMobile == null) {
			return "";
		}
		else {
			return _emergencyMobile;
		}
	}

	@Override
	public void setEmergencyMobile(String emergencyMobile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emergencyMobile = emergencyMobile;
	}

	@JSON
	@Override
	public String getFacebookId() {
		if (_facebookId == null) {
			return "";
		}
		else {
			return _facebookId;
		}
	}

	@Override
	public void setFacebookId(String facebookId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_facebookId = facebookId;
	}

	@JSON
	@Override
	public String getInstagramId() {
		if (_instagramId == null) {
			return "";
		}
		else {
			return _instagramId;
		}
	}

	@Override
	public void setInstagramId(String instagramId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_instagramId = instagramId;
	}

	@JSON
	@Override
	public String getLinkedInId() {
		if (_linkedInId == null) {
			return "";
		}
		else {
			return _linkedInId;
		}
	}

	@Override
	public void setLinkedInId(String linkedInId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_linkedInId = linkedInId;
	}

	@JSON
	@Override
	public String getMobile() {
		if (_mobile == null) {
			return "";
		}
		else {
			return _mobile;
		}
	}

	@Override
	public void setMobile(String mobile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobile = mobile;
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return "";
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phone = phone;
	}

	@JSON
	@Override
	public String getTwitterId() {
		if (_twitterId == null) {
			return "";
		}
		else {
			return _twitterId;
		}
	}

	@Override
	public void setTwitterId(String twitterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_twitterId = twitterId;
	}

	@JSON
	@Override
	public String getLandline() {
		if (_landline == null) {
			return "";
		}
		else {
			return _landline;
		}
	}

	@Override
	public void setLandline(String landline) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_landline = landline;
	}

	@JSON
	@Override
	public String getEmergencyNo() {
		if (_emergencyNo == null) {
			return "";
		}
		else {
			return _emergencyNo;
		}
	}

	@Override
	public void setEmergencyNo(String emergencyNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emergencyNo = emergencyNo;
	}

	@JSON
	@Override
	public String getFax() {
		if (_fax == null) {
			return "";
		}
		else {
			return _fax;
		}
	}

	@Override
	public void setFax(String fax) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fax = fax;
	}

	@JSON
	@Override
	public String getTelegram() {
		if (_telegram == null) {
			return "";
		}
		else {
			return _telegram;
		}
	}

	@Override
	public void setTelegram(String telegram) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_telegram = telegram;
	}

	@JSON
	@Override
	public String getTelex() {
		if (_telex == null) {
			return "";
		}
		else {
			return _telex;
		}
	}

	@Override
	public void setTelex(String telex) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_telex = telex;
	}

	@JSON
	@Override
	public String getPersonalEmail() {
		if (_personalEmail == null) {
			return "";
		}
		else {
			return _personalEmail;
		}
	}

	@Override
	public void setPersonalEmail(String personalEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_personalEmail = personalEmail;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Contact.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Contact toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Contact>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setContactId(getContactId());
		contactImpl.setGroupId(getGroupId());
		contactImpl.setCompanyId(getCompanyId());
		contactImpl.setUserId(getUserId());
		contactImpl.setUserName(getUserName());
		contactImpl.setCreateDate(getCreateDate());
		contactImpl.setModifiedDate(getModifiedDate());
		contactImpl.setAltEmailAddress(getAltEmailAddress());
		contactImpl.setEmergencyMobile(getEmergencyMobile());
		contactImpl.setFacebookId(getFacebookId());
		contactImpl.setInstagramId(getInstagramId());
		contactImpl.setLinkedInId(getLinkedInId());
		contactImpl.setMobile(getMobile());
		contactImpl.setPhone(getPhone());
		contactImpl.setTwitterId(getTwitterId());
		contactImpl.setLandline(getLandline());
		contactImpl.setEmergencyNo(getEmergencyNo());
		contactImpl.setFax(getFax());
		contactImpl.setTelegram(getTelegram());
		contactImpl.setTelex(getTelex());
		contactImpl.setPersonalEmail(getPersonalEmail());

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public int compareTo(Contact contact) {
		long primaryKey = contact.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Contact)) {
			return false;
		}

		Contact contact = (Contact)object;

		long primaryKey = contact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Contact> toCacheModel() {
		ContactCacheModel contactCacheModel = new ContactCacheModel();

		contactCacheModel.contactId = getContactId();

		contactCacheModel.groupId = getGroupId();

		contactCacheModel.companyId = getCompanyId();

		contactCacheModel.userId = getUserId();

		contactCacheModel.userName = getUserName();

		String userName = contactCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			contactCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			contactCacheModel.createDate = createDate.getTime();
		}
		else {
			contactCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			contactCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			contactCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		contactCacheModel.altEmailAddress = getAltEmailAddress();

		String altEmailAddress = contactCacheModel.altEmailAddress;

		if ((altEmailAddress != null) && (altEmailAddress.length() == 0)) {
			contactCacheModel.altEmailAddress = null;
		}

		contactCacheModel.emergencyMobile = getEmergencyMobile();

		String emergencyMobile = contactCacheModel.emergencyMobile;

		if ((emergencyMobile != null) && (emergencyMobile.length() == 0)) {
			contactCacheModel.emergencyMobile = null;
		}

		contactCacheModel.facebookId = getFacebookId();

		String facebookId = contactCacheModel.facebookId;

		if ((facebookId != null) && (facebookId.length() == 0)) {
			contactCacheModel.facebookId = null;
		}

		contactCacheModel.instagramId = getInstagramId();

		String instagramId = contactCacheModel.instagramId;

		if ((instagramId != null) && (instagramId.length() == 0)) {
			contactCacheModel.instagramId = null;
		}

		contactCacheModel.linkedInId = getLinkedInId();

		String linkedInId = contactCacheModel.linkedInId;

		if ((linkedInId != null) && (linkedInId.length() == 0)) {
			contactCacheModel.linkedInId = null;
		}

		contactCacheModel.mobile = getMobile();

		String mobile = contactCacheModel.mobile;

		if ((mobile != null) && (mobile.length() == 0)) {
			contactCacheModel.mobile = null;
		}

		contactCacheModel.phone = getPhone();

		String phone = contactCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			contactCacheModel.phone = null;
		}

		contactCacheModel.twitterId = getTwitterId();

		String twitterId = contactCacheModel.twitterId;

		if ((twitterId != null) && (twitterId.length() == 0)) {
			contactCacheModel.twitterId = null;
		}

		contactCacheModel.landline = getLandline();

		String landline = contactCacheModel.landline;

		if ((landline != null) && (landline.length() == 0)) {
			contactCacheModel.landline = null;
		}

		contactCacheModel.emergencyNo = getEmergencyNo();

		String emergencyNo = contactCacheModel.emergencyNo;

		if ((emergencyNo != null) && (emergencyNo.length() == 0)) {
			contactCacheModel.emergencyNo = null;
		}

		contactCacheModel.fax = getFax();

		String fax = contactCacheModel.fax;

		if ((fax != null) && (fax.length() == 0)) {
			contactCacheModel.fax = null;
		}

		contactCacheModel.telegram = getTelegram();

		String telegram = contactCacheModel.telegram;

		if ((telegram != null) && (telegram.length() == 0)) {
			contactCacheModel.telegram = null;
		}

		contactCacheModel.telex = getTelex();

		String telex = contactCacheModel.telex;

		if ((telex != null) && (telex.length() == 0)) {
			contactCacheModel.telex = null;
		}

		contactCacheModel.personalEmail = getPersonalEmail();

		String personalEmail = contactCacheModel.personalEmail;

		if ((personalEmail != null) && (personalEmail.length() == 0)) {
			contactCacheModel.personalEmail = null;
		}

		return contactCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Contact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Contact, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Contact)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Contact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Contact, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Contact)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Contact>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
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

	public <T> T getColumnValue(String columnName) {
		Function<Contact, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Contact)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("contactId", _contactId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("altEmailAddress", _altEmailAddress);
		_columnOriginalValues.put("emergencyMobile", _emergencyMobile);
		_columnOriginalValues.put("facebookId", _facebookId);
		_columnOriginalValues.put("instagramId", _instagramId);
		_columnOriginalValues.put("linkedInId", _linkedInId);
		_columnOriginalValues.put("mobile", _mobile);
		_columnOriginalValues.put("phone", _phone);
		_columnOriginalValues.put("twitterId", _twitterId);
		_columnOriginalValues.put("landline", _landline);
		_columnOriginalValues.put("emergencyNo", _emergencyNo);
		_columnOriginalValues.put("fax", _fax);
		_columnOriginalValues.put("telegram", _telegram);
		_columnOriginalValues.put("telex", _telex);
		_columnOriginalValues.put("personalEmail", _personalEmail);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("contactId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("altEmailAddress", 128L);

		columnBitmasks.put("emergencyMobile", 256L);

		columnBitmasks.put("facebookId", 512L);

		columnBitmasks.put("instagramId", 1024L);

		columnBitmasks.put("linkedInId", 2048L);

		columnBitmasks.put("mobile", 4096L);

		columnBitmasks.put("phone", 8192L);

		columnBitmasks.put("twitterId", 16384L);

		columnBitmasks.put("landline", 32768L);

		columnBitmasks.put("emergencyNo", 65536L);

		columnBitmasks.put("fax", 131072L);

		columnBitmasks.put("telegram", 262144L);

		columnBitmasks.put("telex", 524288L);

		columnBitmasks.put("personalEmail", 1048576L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Contact _escapedModel;

}