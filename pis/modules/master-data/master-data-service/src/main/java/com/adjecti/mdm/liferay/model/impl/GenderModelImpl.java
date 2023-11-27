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

import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.GenderModel;
import com.adjecti.mdm.liferay.model.GenderSoap;

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
 * The base model implementation for the Gender service. Represents a row in the &quot;mdm_Gender&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>GenderModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GenderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderImpl
 * @generated
 */
@JSON(strict = true)
public class GenderModelImpl
	extends BaseModelImpl<Gender> implements GenderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a gender model instance should use the <code>Gender</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_Gender";

	public static final Object[][] TABLE_COLUMNS = {
		{"genderId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"code_", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"deleted", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("genderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_Gender (genderId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_Gender";

	public static final String ORDER_BY_JPQL = " ORDER BY gender.genderId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_Gender.genderId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GENDERID_COLUMN_BITMASK = 2L;

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
	public static Gender toModel(GenderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Gender model = new GenderImpl();

		model.setGenderId(soapModel.getGenderId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCode(soapModel.getCode());
		model.setName(soapModel.getName());
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
	public static List<Gender> toModels(GenderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Gender> models = new ArrayList<Gender>(soapModels.length);

		for (GenderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public GenderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _genderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGenderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _genderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Gender.class;
	}

	@Override
	public String getModelClassName() {
		return Gender.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Gender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Gender, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Gender)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Gender, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Gender, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Gender)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Gender, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Gender, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Gender>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Gender.class.getClassLoader(), Gender.class, ModelWrapper.class);

		try {
			Constructor<Gender> constructor =
				(Constructor<Gender>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Gender, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Gender, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Gender, Object>>();
		Map<String, BiConsumer<Gender, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Gender, ?>>();

		attributeGetterFunctions.put("genderId", Gender::getGenderId);
		attributeSetterBiConsumers.put(
			"genderId", (BiConsumer<Gender, Long>)Gender::setGenderId);
		attributeGetterFunctions.put("groupId", Gender::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Gender, Long>)Gender::setGroupId);
		attributeGetterFunctions.put("companyId", Gender::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Gender, Long>)Gender::setCompanyId);
		attributeGetterFunctions.put("userId", Gender::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Gender, Long>)Gender::setUserId);
		attributeGetterFunctions.put("userName", Gender::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Gender, String>)Gender::setUserName);
		attributeGetterFunctions.put("createDate", Gender::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Gender, Date>)Gender::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Gender::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Gender, Date>)Gender::setModifiedDate);
		attributeGetterFunctions.put("code", Gender::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<Gender, String>)Gender::setCode);
		attributeGetterFunctions.put("name", Gender::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Gender, String>)Gender::setName);
		attributeGetterFunctions.put("deleted", Gender::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted", (BiConsumer<Gender, Boolean>)Gender::setDeleted);
		attributeGetterFunctions.put("status", Gender::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Gender, Integer>)Gender::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getGenderId() {
		return _genderId;
	}

	@Override
	public void setGenderId(long genderId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_genderId = genderId;
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
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_code = code;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
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
			getCompanyId(), Gender.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Gender toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Gender>
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
		GenderImpl genderImpl = new GenderImpl();

		genderImpl.setGenderId(getGenderId());
		genderImpl.setGroupId(getGroupId());
		genderImpl.setCompanyId(getCompanyId());
		genderImpl.setUserId(getUserId());
		genderImpl.setUserName(getUserName());
		genderImpl.setCreateDate(getCreateDate());
		genderImpl.setModifiedDate(getModifiedDate());
		genderImpl.setCode(getCode());
		genderImpl.setName(getName());
		genderImpl.setDeleted(isDeleted());
		genderImpl.setStatus(getStatus());

		genderImpl.resetOriginalValues();

		return genderImpl;
	}

	@Override
	public int compareTo(Gender gender) {
		long primaryKey = gender.getPrimaryKey();

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

		if (!(object instanceof Gender)) {
			return false;
		}

		Gender gender = (Gender)object;

		long primaryKey = gender.getPrimaryKey();

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
	public CacheModel<Gender> toCacheModel() {
		GenderCacheModel genderCacheModel = new GenderCacheModel();

		genderCacheModel.genderId = getGenderId();

		genderCacheModel.groupId = getGroupId();

		genderCacheModel.companyId = getCompanyId();

		genderCacheModel.userId = getUserId();

		genderCacheModel.userName = getUserName();

		String userName = genderCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			genderCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			genderCacheModel.createDate = createDate.getTime();
		}
		else {
			genderCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			genderCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			genderCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		genderCacheModel.code = getCode();

		String code = genderCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			genderCacheModel.code = null;
		}

		genderCacheModel.name = getName();

		String name = genderCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			genderCacheModel.name = null;
		}

		genderCacheModel.deleted = isDeleted();

		genderCacheModel.status = getStatus();

		return genderCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Gender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Gender, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Gender)this));
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
		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Gender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Gender, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Gender)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Gender>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _genderId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _code;
	private String _name;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Gender, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Gender)this);
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

		_columnOriginalValues.put("genderId", _genderId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("code_", "code");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("genderId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("code_", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("deleted", 512L);

		columnBitmasks.put("status", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Gender _escapedModel;

}