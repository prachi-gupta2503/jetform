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

import com.adjecti.pis.liferay.model.EmployeeMessage;
import com.adjecti.pis.liferay.model.EmployeeMessageModel;
import com.adjecti.pis.liferay.model.EmployeeMessageSoap;

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
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the EmployeeMessage service. Represents a row in the &quot;pis_EmployeeMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeMessageModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeMessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeMessageImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeMessageModelImpl
	extends BaseModelImpl<EmployeeMessage> implements EmployeeMessageModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee message model instance should use the <code>EmployeeMessage</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeMessage";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeMessageId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"employeeId", Types.BIGINT},
		{"title", Types.VARCHAR}, {"message", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeMessageId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeMessage (employeeMessageId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeId LONG,title VARCHAR(75) null,message VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeMessage";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeMessage.employeeMessageId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeMessage.employeeMessageId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EMPLOYEEMESSAGEID_COLUMN_BITMASK = 2L;

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
	public static EmployeeMessage toModel(EmployeeMessageSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeeMessage model = new EmployeeMessageImpl();

		model.setEmployeeMessageId(soapModel.getEmployeeMessageId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setTitle(soapModel.getTitle());
		model.setMessage(soapModel.getMessage());

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
	public static List<EmployeeMessage> toModels(
		EmployeeMessageSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeMessage> models = new ArrayList<EmployeeMessage>(
			soapModels.length);

		for (EmployeeMessageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeMessageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeMessageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeMessageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeMessage.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeMessage, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeMessage, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeMessage)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeMessage, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeMessage, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeMessage)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeMessage, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeMessage, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeMessage>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeMessage.class.getClassLoader(), EmployeeMessage.class,
			ModelWrapper.class);

		try {
			Constructor<EmployeeMessage> constructor =
				(Constructor<EmployeeMessage>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeeMessage, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeMessage, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeMessage, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<EmployeeMessage, Object>>();
		Map<String, BiConsumer<EmployeeMessage, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EmployeeMessage, ?>>();

		attributeGetterFunctions.put(
			"employeeMessageId", EmployeeMessage::getEmployeeMessageId);
		attributeSetterBiConsumers.put(
			"employeeMessageId",
			(BiConsumer<EmployeeMessage, Long>)
				EmployeeMessage::setEmployeeMessageId);
		attributeGetterFunctions.put("groupId", EmployeeMessage::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeMessage, Long>)EmployeeMessage::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeMessage::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeMessage, Long>)EmployeeMessage::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeMessage::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeMessage, Long>)EmployeeMessage::setUserId);
		attributeGetterFunctions.put("userName", EmployeeMessage::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeMessage, String>)EmployeeMessage::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeMessage::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeMessage, Date>)EmployeeMessage::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeMessage::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeMessage, Date>)
				EmployeeMessage::setModifiedDate);
		attributeGetterFunctions.put(
			"employeeId", EmployeeMessage::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeMessage, Long>)EmployeeMessage::setEmployeeId);
		attributeGetterFunctions.put("title", EmployeeMessage::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<EmployeeMessage, String>)EmployeeMessage::setTitle);
		attributeGetterFunctions.put("message", EmployeeMessage::getMessage);
		attributeSetterBiConsumers.put(
			"message",
			(BiConsumer<EmployeeMessage, String>)EmployeeMessage::setMessage);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeMessageId() {
		return _employeeMessageId;
	}

	@Override
	public void setEmployeeMessageId(long employeeMessageId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeMessageId = employeeMessageId;
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
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeId = employeeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEmployeeId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("employeeId"));
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return "";
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_message = message;
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
			getCompanyId(), EmployeeMessage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeMessage toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeMessage>
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
		EmployeeMessageImpl employeeMessageImpl = new EmployeeMessageImpl();

		employeeMessageImpl.setEmployeeMessageId(getEmployeeMessageId());
		employeeMessageImpl.setGroupId(getGroupId());
		employeeMessageImpl.setCompanyId(getCompanyId());
		employeeMessageImpl.setUserId(getUserId());
		employeeMessageImpl.setUserName(getUserName());
		employeeMessageImpl.setCreateDate(getCreateDate());
		employeeMessageImpl.setModifiedDate(getModifiedDate());
		employeeMessageImpl.setEmployeeId(getEmployeeId());
		employeeMessageImpl.setTitle(getTitle());
		employeeMessageImpl.setMessage(getMessage());

		employeeMessageImpl.resetOriginalValues();

		return employeeMessageImpl;
	}

	@Override
	public int compareTo(EmployeeMessage employeeMessage) {
		long primaryKey = employeeMessage.getPrimaryKey();

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

		if (!(object instanceof EmployeeMessage)) {
			return false;
		}

		EmployeeMessage employeeMessage = (EmployeeMessage)object;

		long primaryKey = employeeMessage.getPrimaryKey();

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
	public CacheModel<EmployeeMessage> toCacheModel() {
		EmployeeMessageCacheModel employeeMessageCacheModel =
			new EmployeeMessageCacheModel();

		employeeMessageCacheModel.employeeMessageId = getEmployeeMessageId();

		employeeMessageCacheModel.groupId = getGroupId();

		employeeMessageCacheModel.companyId = getCompanyId();

		employeeMessageCacheModel.userId = getUserId();

		employeeMessageCacheModel.userName = getUserName();

		String userName = employeeMessageCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeMessageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeMessageCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeMessageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeMessageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeMessageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeMessageCacheModel.employeeId = getEmployeeId();

		employeeMessageCacheModel.title = getTitle();

		String title = employeeMessageCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			employeeMessageCacheModel.title = null;
		}

		employeeMessageCacheModel.message = getMessage();

		String message = employeeMessageCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			employeeMessageCacheModel.message = null;
		}

		return employeeMessageCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeMessage, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeMessage, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeeMessage)this));
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
		Map<String, Function<EmployeeMessage, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeMessage, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeMessage)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeMessage>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeMessageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _employeeId;
	private String _title;
	private String _message;

	public <T> T getColumnValue(String columnName) {
		Function<EmployeeMessage, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeMessage)this);
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

		_columnOriginalValues.put("employeeMessageId", _employeeMessageId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("message", _message);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("employeeMessageId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("employeeId", 128L);

		columnBitmasks.put("title", 256L);

		columnBitmasks.put("message", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeMessage _escapedModel;

}