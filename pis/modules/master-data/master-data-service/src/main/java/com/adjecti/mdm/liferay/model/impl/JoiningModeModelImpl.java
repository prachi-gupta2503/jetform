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

import com.adjecti.mdm.liferay.model.JoiningMode;
import com.adjecti.mdm.liferay.model.JoiningModeModel;
import com.adjecti.mdm.liferay.model.JoiningModeSoap;

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
 * The base model implementation for the JoiningMode service. Represents a row in the &quot;mdm_JoiningMode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>JoiningModeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JoiningModeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningModeImpl
 * @generated
 */
@JSON(strict = true)
public class JoiningModeModelImpl
	extends BaseModelImpl<JoiningMode> implements JoiningModeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a joining mode model instance should use the <code>JoiningMode</code> interface instead.
	 */
	public static final String TABLE_NAME = "mdm_JoiningMode";

	public static final Object[][] TABLE_COLUMNS = {
		{"joiningModeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"code_", Types.VARCHAR},
		{"deleted", Types.BOOLEAN}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("joiningModeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table mdm_JoiningMode (joiningModeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,code_ VARCHAR(75) null,deleted BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table mdm_JoiningMode";

	public static final String ORDER_BY_JPQL =
		" ORDER BY joiningMode.joiningModeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY mdm_JoiningMode.joiningModeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long JOININGMODEID_COLUMN_BITMASK = 1L;

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
	public static JoiningMode toModel(JoiningModeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		JoiningMode model = new JoiningModeImpl();

		model.setJoiningModeId(soapModel.getJoiningModeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setCode(soapModel.getCode());
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
	public static List<JoiningMode> toModels(JoiningModeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<JoiningMode> models = new ArrayList<JoiningMode>(
			soapModels.length);

		for (JoiningModeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public JoiningModeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _joiningModeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJoiningModeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _joiningModeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JoiningMode.class;
	}

	@Override
	public String getModelClassName() {
		return JoiningMode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<JoiningMode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<JoiningMode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JoiningMode, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((JoiningMode)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<JoiningMode, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<JoiningMode, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(JoiningMode)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<JoiningMode, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<JoiningMode, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, JoiningMode>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			JoiningMode.class.getClassLoader(), JoiningMode.class,
			ModelWrapper.class);

		try {
			Constructor<JoiningMode> constructor =
				(Constructor<JoiningMode>)proxyClass.getConstructor(
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

	private static final Map<String, Function<JoiningMode, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<JoiningMode, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<JoiningMode, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<JoiningMode, Object>>();
		Map<String, BiConsumer<JoiningMode, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<JoiningMode, ?>>();

		attributeGetterFunctions.put(
			"joiningModeId", JoiningMode::getJoiningModeId);
		attributeSetterBiConsumers.put(
			"joiningModeId",
			(BiConsumer<JoiningMode, Long>)JoiningMode::setJoiningModeId);
		attributeGetterFunctions.put("groupId", JoiningMode::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<JoiningMode, Long>)JoiningMode::setGroupId);
		attributeGetterFunctions.put("companyId", JoiningMode::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<JoiningMode, Long>)JoiningMode::setCompanyId);
		attributeGetterFunctions.put("userId", JoiningMode::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<JoiningMode, Long>)JoiningMode::setUserId);
		attributeGetterFunctions.put("userName", JoiningMode::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<JoiningMode, String>)JoiningMode::setUserName);
		attributeGetterFunctions.put("createDate", JoiningMode::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<JoiningMode, Date>)JoiningMode::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", JoiningMode::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<JoiningMode, Date>)JoiningMode::setModifiedDate);
		attributeGetterFunctions.put("name", JoiningMode::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<JoiningMode, String>)JoiningMode::setName);
		attributeGetterFunctions.put(
			"description", JoiningMode::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<JoiningMode, String>)JoiningMode::setDescription);
		attributeGetterFunctions.put("code", JoiningMode::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<JoiningMode, String>)JoiningMode::setCode);
		attributeGetterFunctions.put("deleted", JoiningMode::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<JoiningMode, Boolean>)JoiningMode::setDeleted);
		attributeGetterFunctions.put("status", JoiningMode::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<JoiningMode, Integer>)JoiningMode::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getJoiningModeId() {
		return _joiningModeId;
	}

	@Override
	public void setJoiningModeId(long joiningModeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_joiningModeId = joiningModeId;
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

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
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
			getCompanyId(), JoiningMode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JoiningMode toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, JoiningMode>
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
		JoiningModeImpl joiningModeImpl = new JoiningModeImpl();

		joiningModeImpl.setJoiningModeId(getJoiningModeId());
		joiningModeImpl.setGroupId(getGroupId());
		joiningModeImpl.setCompanyId(getCompanyId());
		joiningModeImpl.setUserId(getUserId());
		joiningModeImpl.setUserName(getUserName());
		joiningModeImpl.setCreateDate(getCreateDate());
		joiningModeImpl.setModifiedDate(getModifiedDate());
		joiningModeImpl.setName(getName());
		joiningModeImpl.setDescription(getDescription());
		joiningModeImpl.setCode(getCode());
		joiningModeImpl.setDeleted(isDeleted());
		joiningModeImpl.setStatus(getStatus());

		joiningModeImpl.resetOriginalValues();

		return joiningModeImpl;
	}

	@Override
	public int compareTo(JoiningMode joiningMode) {
		long primaryKey = joiningMode.getPrimaryKey();

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

		if (!(object instanceof JoiningMode)) {
			return false;
		}

		JoiningMode joiningMode = (JoiningMode)object;

		long primaryKey = joiningMode.getPrimaryKey();

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
	public CacheModel<JoiningMode> toCacheModel() {
		JoiningModeCacheModel joiningModeCacheModel =
			new JoiningModeCacheModel();

		joiningModeCacheModel.joiningModeId = getJoiningModeId();

		joiningModeCacheModel.groupId = getGroupId();

		joiningModeCacheModel.companyId = getCompanyId();

		joiningModeCacheModel.userId = getUserId();

		joiningModeCacheModel.userName = getUserName();

		String userName = joiningModeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			joiningModeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			joiningModeCacheModel.createDate = createDate.getTime();
		}
		else {
			joiningModeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			joiningModeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			joiningModeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		joiningModeCacheModel.name = getName();

		String name = joiningModeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			joiningModeCacheModel.name = null;
		}

		joiningModeCacheModel.description = getDescription();

		String description = joiningModeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			joiningModeCacheModel.description = null;
		}

		joiningModeCacheModel.code = getCode();

		String code = joiningModeCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			joiningModeCacheModel.code = null;
		}

		joiningModeCacheModel.deleted = isDeleted();

		joiningModeCacheModel.status = getStatus();

		return joiningModeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<JoiningMode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<JoiningMode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JoiningMode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((JoiningMode)this));
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
		Map<String, Function<JoiningMode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<JoiningMode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JoiningMode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((JoiningMode)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, JoiningMode>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _joiningModeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _description;
	private String _code;
	private boolean _deleted;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<JoiningMode, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((JoiningMode)this);
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

		_columnOriginalValues.put("joiningModeId", _joiningModeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("code_", _code);
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

		columnBitmasks.put("joiningModeId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("name", 128L);

		columnBitmasks.put("description", 256L);

		columnBitmasks.put("code_", 512L);

		columnBitmasks.put("deleted", 1024L);

		columnBitmasks.put("status", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private JoiningMode _escapedModel;

}