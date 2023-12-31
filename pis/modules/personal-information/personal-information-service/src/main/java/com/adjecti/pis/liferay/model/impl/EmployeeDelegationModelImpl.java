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

import com.adjecti.pis.liferay.model.EmployeeDelegation;
import com.adjecti.pis.liferay.model.EmployeeDelegationModel;
import com.adjecti.pis.liferay.model.EmployeeDelegationSoap;

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
 * The base model implementation for the EmployeeDelegation service. Represents a row in the &quot;pis_EmployeeDelegation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeDelegationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeDelegationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDelegationImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeDelegationModelImpl
	extends BaseModelImpl<EmployeeDelegation>
	implements EmployeeDelegationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee delegation model instance should use the <code>EmployeeDelegation</code> interface instead.
	 */
	public static final String TABLE_NAME = "pis_EmployeeDelegation";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeDelegationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"delegationType", Types.BIGINT},
		{"delegatedEmployeeId", Types.BIGINT}, {"employeeId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeDelegationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("delegationType", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("delegatedEmployeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table pis_EmployeeDelegation (employeeDelegationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,delegationType LONG,delegatedEmployeeId LONG,employeeId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table pis_EmployeeDelegation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeDelegation.employeeDelegationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY pis_EmployeeDelegation.employeeDelegationId ASC";

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
	public static final long EMPLOYEEDELEGATIONID_COLUMN_BITMASK = 2L;

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
	public static EmployeeDelegation toModel(EmployeeDelegationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmployeeDelegation model = new EmployeeDelegationImpl();

		model.setEmployeeDelegationId(soapModel.getEmployeeDelegationId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDelegationType(soapModel.getDelegationType());
		model.setDelegatedEmployeeId(soapModel.getDelegatedEmployeeId());
		model.setEmployeeId(soapModel.getEmployeeId());

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
	public static List<EmployeeDelegation> toModels(
		EmployeeDelegationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EmployeeDelegation> models = new ArrayList<EmployeeDelegation>(
			soapModels.length);

		for (EmployeeDelegationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeDelegationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeDelegationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeDelegationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeDelegationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeDelegation.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeDelegation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeDelegation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeDelegation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDelegation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeDelegation)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeDelegation, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeDelegation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeDelegation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeDelegation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeDelegation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmployeeDelegation>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmployeeDelegation.class.getClassLoader(), EmployeeDelegation.class,
			ModelWrapper.class);

		try {
			Constructor<EmployeeDelegation> constructor =
				(Constructor<EmployeeDelegation>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmployeeDelegation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeDelegation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeDelegation, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EmployeeDelegation, Object>>();
		Map<String, BiConsumer<EmployeeDelegation, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<EmployeeDelegation, ?>>();

		attributeGetterFunctions.put(
			"employeeDelegationId",
			EmployeeDelegation::getEmployeeDelegationId);
		attributeSetterBiConsumers.put(
			"employeeDelegationId",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setEmployeeDelegationId);
		attributeGetterFunctions.put("groupId", EmployeeDelegation::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EmployeeDelegation::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setCompanyId);
		attributeGetterFunctions.put("userId", EmployeeDelegation::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setUserId);
		attributeGetterFunctions.put(
			"userName", EmployeeDelegation::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmployeeDelegation, String>)
				EmployeeDelegation::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmployeeDelegation::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmployeeDelegation, Date>)
				EmployeeDelegation::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmployeeDelegation::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmployeeDelegation, Date>)
				EmployeeDelegation::setModifiedDate);
		attributeGetterFunctions.put(
			"delegationType", EmployeeDelegation::getDelegationType);
		attributeSetterBiConsumers.put(
			"delegationType",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setDelegationType);
		attributeGetterFunctions.put(
			"delegatedEmployeeId", EmployeeDelegation::getDelegatedEmployeeId);
		attributeSetterBiConsumers.put(
			"delegatedEmployeeId",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setDelegatedEmployeeId);
		attributeGetterFunctions.put(
			"employeeId", EmployeeDelegation::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeDelegation, Long>)
				EmployeeDelegation::setEmployeeId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getEmployeeDelegationId() {
		return _employeeDelegationId;
	}

	@Override
	public void setEmployeeDelegationId(long employeeDelegationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeDelegationId = employeeDelegationId;
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
	public long getDelegationType() {
		return _delegationType;
	}

	@Override
	public void setDelegationType(long delegationType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delegationType = delegationType;
	}

	@JSON
	@Override
	public long getDelegatedEmployeeId() {
		return _delegatedEmployeeId;
	}

	@Override
	public void setDelegatedEmployeeId(long delegatedEmployeeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delegatedEmployeeId = delegatedEmployeeId;
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
			getCompanyId(), EmployeeDelegation.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeDelegation toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeDelegation>
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
		EmployeeDelegationImpl employeeDelegationImpl =
			new EmployeeDelegationImpl();

		employeeDelegationImpl.setEmployeeDelegationId(
			getEmployeeDelegationId());
		employeeDelegationImpl.setGroupId(getGroupId());
		employeeDelegationImpl.setCompanyId(getCompanyId());
		employeeDelegationImpl.setUserId(getUserId());
		employeeDelegationImpl.setUserName(getUserName());
		employeeDelegationImpl.setCreateDate(getCreateDate());
		employeeDelegationImpl.setModifiedDate(getModifiedDate());
		employeeDelegationImpl.setDelegationType(getDelegationType());
		employeeDelegationImpl.setDelegatedEmployeeId(getDelegatedEmployeeId());
		employeeDelegationImpl.setEmployeeId(getEmployeeId());

		employeeDelegationImpl.resetOriginalValues();

		return employeeDelegationImpl;
	}

	@Override
	public int compareTo(EmployeeDelegation employeeDelegation) {
		long primaryKey = employeeDelegation.getPrimaryKey();

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

		if (!(object instanceof EmployeeDelegation)) {
			return false;
		}

		EmployeeDelegation employeeDelegation = (EmployeeDelegation)object;

		long primaryKey = employeeDelegation.getPrimaryKey();

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
	public CacheModel<EmployeeDelegation> toCacheModel() {
		EmployeeDelegationCacheModel employeeDelegationCacheModel =
			new EmployeeDelegationCacheModel();

		employeeDelegationCacheModel.employeeDelegationId =
			getEmployeeDelegationId();

		employeeDelegationCacheModel.groupId = getGroupId();

		employeeDelegationCacheModel.companyId = getCompanyId();

		employeeDelegationCacheModel.userId = getUserId();

		employeeDelegationCacheModel.userName = getUserName();

		String userName = employeeDelegationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeDelegationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeDelegationCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeDelegationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeDelegationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeDelegationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeDelegationCacheModel.delegationType = getDelegationType();

		employeeDelegationCacheModel.delegatedEmployeeId =
			getDelegatedEmployeeId();

		employeeDelegationCacheModel.employeeId = getEmployeeId();

		return employeeDelegationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeDelegation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeDelegation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDelegation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmployeeDelegation)this));
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
		Map<String, Function<EmployeeDelegation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeDelegation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDelegation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeDelegation)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeDelegation>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _employeeDelegationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _delegationType;
	private long _delegatedEmployeeId;
	private long _employeeId;

	public <T> T getColumnValue(String columnName) {
		Function<EmployeeDelegation, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeDelegation)this);
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

		_columnOriginalValues.put(
			"employeeDelegationId", _employeeDelegationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("delegationType", _delegationType);
		_columnOriginalValues.put("delegatedEmployeeId", _delegatedEmployeeId);
		_columnOriginalValues.put("employeeId", _employeeId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("employeeDelegationId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("delegationType", 128L);

		columnBitmasks.put("delegatedEmployeeId", 256L);

		columnBitmasks.put("employeeId", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeDelegation _escapedModel;

}