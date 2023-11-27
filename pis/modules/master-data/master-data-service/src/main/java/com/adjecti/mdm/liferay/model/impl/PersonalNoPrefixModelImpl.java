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

package com.adjecti.mdm.liferay.model.impl;

import com.adjecti.mdm.liferay.model.PersonalNoPrefix;
import com.adjecti.mdm.liferay.model.PersonalNoPrefixModel;
import com.adjecti.mdm.liferay.model.PersonalNoPrefixSoap;

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
 * The base model implementation for the PersonalNoPrefix service. Represents a row in the &quot;mdm_PersonalNoPrefix&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PersonalNoPrefixModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersonalNoPrefixImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalNoPrefixImpl
 * @generated
 */
@JSON(strict = true)
public class PersonalNoPrefixModelImpl
	extends BaseModelImpl<PersonalNoPrefix> implements PersonalNoPrefixModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a personal no prefix model instance should use the <code>PersonalNoPrefix</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_PersonalNoPrefix";

	public static final Object[][] TABLE_COLUMNS = {
		{"personalNoPrefixId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"active_", Types.BOOLEAN},
		{"fromDate", Types.TIMESTAMP}, {"prefix", Types.VARCHAR},
		{"toDate", Types.TIMESTAMP}, {"desigClassId", Types.BIGINT},
		{"desigGradeId", Types.BIGINT}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("personalNoPrefixId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("prefix", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("desigClassId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("desigGradeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_PersonalNoPrefix (personalNoPrefixId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,fromDate DATE null,prefix VARCHAR(75) null,toDate DATE null,desigClassId LONG,desigGradeId LONG,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table mdm_PersonalNoPrefix";

	public static final String ORDER_BY_JPQL =
		" ORDER BY personalNoPrefix.personalNoPrefixId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_PersonalNoPrefix.personalNoPrefixId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PERSONALNOPREFIXID_COLUMN_BITMASK = 1L;

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
	public static PersonalNoPrefix toModel(PersonalNoPrefixSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PersonalNoPrefix model = new PersonalNoPrefixImpl();

		model.setPersonalNoPrefixId(soapModel.getPersonalNoPrefixId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.isActive());
		model.setFromDate(soapModel.getFromDate());
		model.setPrefix(soapModel.getPrefix());
		model.setToDate(soapModel.getToDate());
		model.setDesigClassId(soapModel.getDesigClassId());
		model.setDesigGradeId(soapModel.getDesigGradeId());
		model.setDeleted(soapModel.isDeleted());
		model.setStatus(soapModel.getStatus());

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
	public static List<PersonalNoPrefix> toModels(
		PersonalNoPrefixSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<PersonalNoPrefix> models = new ArrayList<PersonalNoPrefix>(
			soapModels.length);

		for (PersonalNoPrefixSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PersonalNoPrefixModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _personalNoPrefixId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPersonalNoPrefixId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _personalNoPrefixId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PersonalNoPrefix.class;
	}

	@Override
	public String getModelClassName() {
		return PersonalNoPrefix.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PersonalNoPrefix, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PersonalNoPrefix, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PersonalNoPrefix, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PersonalNoPrefix)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PersonalNoPrefix, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PersonalNoPrefix, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PersonalNoPrefix)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PersonalNoPrefix, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PersonalNoPrefix, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PersonalNoPrefix>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PersonalNoPrefix.class.getClassLoader(), PersonalNoPrefix.class,
			ModelWrapper.class);

		try {
			Constructor<PersonalNoPrefix> constructor =
				(Constructor<PersonalNoPrefix>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PersonalNoPrefix, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PersonalNoPrefix, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PersonalNoPrefix, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<PersonalNoPrefix, Object>>();
		Map<String, BiConsumer<PersonalNoPrefix, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<PersonalNoPrefix, ?>>();

		attributeGetterFunctions.put(
			"personalNoPrefixId", PersonalNoPrefix::getPersonalNoPrefixId);
		attributeSetterBiConsumers.put(
			"personalNoPrefixId",
			(BiConsumer<PersonalNoPrefix, Long>)
				PersonalNoPrefix::setPersonalNoPrefixId);
		attributeGetterFunctions.put("groupId", PersonalNoPrefix::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<PersonalNoPrefix, Long>)PersonalNoPrefix::setGroupId);
		attributeGetterFunctions.put(
			"companyId", PersonalNoPrefix::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<PersonalNoPrefix, Long>)PersonalNoPrefix::setCompanyId);
		attributeGetterFunctions.put("userId", PersonalNoPrefix::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<PersonalNoPrefix, Long>)PersonalNoPrefix::setUserId);
		attributeGetterFunctions.put("userName", PersonalNoPrefix::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<PersonalNoPrefix, String>)
				PersonalNoPrefix::setUserName);
		attributeGetterFunctions.put(
			"createDate", PersonalNoPrefix::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<PersonalNoPrefix, Date>)
				PersonalNoPrefix::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", PersonalNoPrefix::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PersonalNoPrefix, Date>)
				PersonalNoPrefix::setModifiedDate);
		attributeGetterFunctions.put("active", PersonalNoPrefix::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<PersonalNoPrefix, Boolean>)PersonalNoPrefix::setActive);
		attributeGetterFunctions.put("fromDate", PersonalNoPrefix::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate",
			(BiConsumer<PersonalNoPrefix, Date>)PersonalNoPrefix::setFromDate);
		attributeGetterFunctions.put("prefix", PersonalNoPrefix::getPrefix);
		attributeSetterBiConsumers.put(
			"prefix",
			(BiConsumer<PersonalNoPrefix, String>)PersonalNoPrefix::setPrefix);
		attributeGetterFunctions.put("toDate", PersonalNoPrefix::getToDate);
		attributeSetterBiConsumers.put(
			"toDate",
			(BiConsumer<PersonalNoPrefix, Date>)PersonalNoPrefix::setToDate);
		attributeGetterFunctions.put(
			"desigClassId", PersonalNoPrefix::getDesigClassId);
		attributeSetterBiConsumers.put(
			"desigClassId",
			(BiConsumer<PersonalNoPrefix, Long>)
				PersonalNoPrefix::setDesigClassId);
		attributeGetterFunctions.put(
			"desigGradeId", PersonalNoPrefix::getDesigGradeId);
		attributeSetterBiConsumers.put(
			"desigGradeId",
			(BiConsumer<PersonalNoPrefix, Long>)
				PersonalNoPrefix::setDesigGradeId);
		attributeGetterFunctions.put("deleted", PersonalNoPrefix::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<PersonalNoPrefix, Boolean>)
				PersonalNoPrefix::setDeleted);
		attributeGetterFunctions.put("status", PersonalNoPrefix::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<PersonalNoPrefix, Integer>)PersonalNoPrefix::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPersonalNoPrefixId() {
		return _personalNoPrefixId;
	}

	@Override
	public void setPersonalNoPrefixId(long personalNoPrefixId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_personalNoPrefixId = personalNoPrefixId;
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
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_active = active;
	}

	@JSON
	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fromDate = fromDate;
	}

	@JSON
	@Override
	public String getPrefix() {
		if (_prefix == null) {
			return "";
		}
		else {
			return _prefix;
		}
	}

	@Override
	public void setPrefix(String prefix) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_prefix = prefix;
	}

	@JSON
	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_toDate = toDate;
	}

	@JSON
	@Override
	public long getDesigClassId() {
		return _desigClassId;
	}

	@Override
	public void setDesigClassId(long desigClassId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_desigClassId = desigClassId;
	}

	@JSON
	@Override
	public long getDesigGradeId() {
		return _desigGradeId;
	}

	@Override
	public void setDesigGradeId(long desigGradeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_desigGradeId = desigGradeId;
	}

	@JSON
	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@JSON
	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deleted = deleted;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
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
			getCompanyId(), PersonalNoPrefix.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PersonalNoPrefix toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PersonalNoPrefix>
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
		PersonalNoPrefixImpl personalNoPrefixImpl = new PersonalNoPrefixImpl();

		personalNoPrefixImpl.setPersonalNoPrefixId(getPersonalNoPrefixId());
		personalNoPrefixImpl.setGroupId(getGroupId());
		personalNoPrefixImpl.setCompanyId(getCompanyId());
		personalNoPrefixImpl.setUserId(getUserId());
		personalNoPrefixImpl.setUserName(getUserName());
		personalNoPrefixImpl.setCreateDate(getCreateDate());
		personalNoPrefixImpl.setModifiedDate(getModifiedDate());
		personalNoPrefixImpl.setActive(isActive());
		personalNoPrefixImpl.setFromDate(getFromDate());
		personalNoPrefixImpl.setPrefix(getPrefix());
		personalNoPrefixImpl.setToDate(getToDate());
		personalNoPrefixImpl.setDesigClassId(getDesigClassId());
		personalNoPrefixImpl.setDesigGradeId(getDesigGradeId());
		personalNoPrefixImpl.setDeleted(isDeleted());
		personalNoPrefixImpl.setStatus(getStatus());

		personalNoPrefixImpl.resetOriginalValues();

		return personalNoPrefixImpl;
	}

	@Override
	public int compareTo(PersonalNoPrefix personalNoPrefix) {
		long primaryKey = personalNoPrefix.getPrimaryKey();

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

		if (!(object instanceof PersonalNoPrefix)) {
			return false;
		}

		PersonalNoPrefix personalNoPrefix = (PersonalNoPrefix)object;

		long primaryKey = personalNoPrefix.getPrimaryKey();

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
	public CacheModel<PersonalNoPrefix> toCacheModel() {
		PersonalNoPrefixCacheModel personalNoPrefixCacheModel =
			new PersonalNoPrefixCacheModel();

		personalNoPrefixCacheModel.personalNoPrefixId = getPersonalNoPrefixId();

		personalNoPrefixCacheModel.groupId = getGroupId();

		personalNoPrefixCacheModel.companyId = getCompanyId();

		personalNoPrefixCacheModel.userId = getUserId();

		personalNoPrefixCacheModel.userName = getUserName();

		String userName = personalNoPrefixCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			personalNoPrefixCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			personalNoPrefixCacheModel.createDate = createDate.getTime();
		}
		else {
			personalNoPrefixCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			personalNoPrefixCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			personalNoPrefixCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		personalNoPrefixCacheModel.active = isActive();

		Date fromDate = getFromDate();

		if (fromDate != null) {
			personalNoPrefixCacheModel.fromDate = fromDate.getTime();
		}
		else {
			personalNoPrefixCacheModel.fromDate = Long.MIN_VALUE;
		}

		personalNoPrefixCacheModel.prefix = getPrefix();

		String prefix = personalNoPrefixCacheModel.prefix;

		if ((prefix != null) && (prefix.length() == 0)) {
			personalNoPrefixCacheModel.prefix = null;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			personalNoPrefixCacheModel.toDate = toDate.getTime();
		}
		else {
			personalNoPrefixCacheModel.toDate = Long.MIN_VALUE;
		}

		personalNoPrefixCacheModel.desigClassId = getDesigClassId();

		personalNoPrefixCacheModel.desigGradeId = getDesigGradeId();

		personalNoPrefixCacheModel.deleted = isDeleted();

		personalNoPrefixCacheModel.status = getStatus();

		return personalNoPrefixCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PersonalNoPrefix, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PersonalNoPrefix, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PersonalNoPrefix, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PersonalNoPrefix)this));
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
		Map<String, Function<PersonalNoPrefix, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PersonalNoPrefix, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PersonalNoPrefix, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PersonalNoPrefix)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PersonalNoPrefix>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _personalNoPrefixId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private Date _fromDate;
	private String _prefix;
	private Date _toDate;
	private long _desigClassId;
	private long _desigGradeId;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PersonalNoPrefix, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PersonalNoPrefix)this);
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

		_columnOriginalValues.put("personalNoPrefixId", _personalNoPrefixId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("fromDate", _fromDate);
		_columnOriginalValues.put("prefix", _prefix);
		_columnOriginalValues.put("toDate", _toDate);
		_columnOriginalValues.put("desigClassId", _desigClassId);
		_columnOriginalValues.put("desigGradeId", _desigGradeId);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("active_", "active");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("personalNoPrefixId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("active_", 128L);

		columnBitmasks.put("fromDate", 256L);

		columnBitmasks.put("prefix", 512L);

		columnBitmasks.put("toDate", 1024L);

		columnBitmasks.put("desigClassId", 2048L);

		columnBitmasks.put("desigGradeId", 4096L);

		columnBitmasks.put("deleted", 8192L);

		columnBitmasks.put("status", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PersonalNoPrefix _escapedModel;

}